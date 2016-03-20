package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Usuarios;
import vista.Interfaz;

public class EjecutableCliente {
	
	//relaciones
	
	private static Interfaz interfaz;
	private static Socket socketTCP;
	private static DatagramSocket socketUDP_Unicast;
	private static MulticastSocket socketUDP_Multicast;
	private static BufferedReader lector;
	private static PrintWriter escritor;
	private static String nombre;
	
	//constantes
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String REGISTRAR = "1";
	public static final String CONSULTAR_PERSONA = "2";
	public static final String CONSULTAR_FECHA = "3";
	public static final String ENCONTRADO = "ENTONTRADO";
	public static final String NO_ENCONTRADO = "NO_ENTONTRADO";
	public static final String AGREGAR_CITA = "4";
	public static final String ELIMINAR_CITA = "5";
	public static final String ACTUALIZAR = "_ACTUALIZAR_";


	public static final String ipGrupo = "239.1.2.2";


	public static void main(String[] args) {
	
		establecerConexionTCP("127.0.0.1", "61000");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				interfaz = new Interfaz();
				interfaz.frame.setVisible(true);
				interfaz.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				interfaz.frame.setTitle(nombre);
				escucharAgregarPaciente();
				escucharBuscarPacientePanelAgregar();
				escucharConsultarDisponibilidad();
				escucharAgregarCita();
				escucharBuscarPacientePanelConsultas();
				escucharEliminarCita();
				escucharSalir();
				escucharDifudirMensaje();
				escucharEnviarMensaje();
			}
		});	
		//como debo escuchar por unicast y multicas al tiempo, creo otro hilo que se escargue exclusivamente de 
		//atender unicast, el hilo principal se encarga de atender el multicast.
		Thread i = new Thread(){
			public void run() {
				establecerConexionUDPunicast();
			}
		};
		i.start();
		establecerConexionUDPmulticast();
		
		
	}
	
	public static void establecerConexionUDPunicast(){
		try {
			Thread.sleep(500);
		
			while(!socketUDP_Unicast.isClosed()){
			byte[] buf = new byte[2000];
			DatagramPacket recibe = new DatagramPacket(buf, buf.length);
			socketUDP_Unicast.receive(recibe);
			String comando = new String(recibe.getData(),0,recibe.getLength());
			interfaz.getTextArea_Visualizador().insert(comando+"\n", interfaz.getTextArea_Visualizador().getRows());
			}
			
		} catch (Exception e1) {
		}
	}
	
	public static void establecerConexionUDPmulticast(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!socketUDP_Multicast.isClosed()){
			byte[] buf = new byte[2000];
			DatagramPacket recibe = new DatagramPacket(buf, buf.length);
			try {
				socketUDP_Multicast.receive(recibe);
				String comando = new String(recibe.getData(),0,recibe.getLength());
				
				if(comando.startsWith(ACTUALIZAR)){
				actualizarCHAT();
				}else{
					interfaz.getTextArea_Visualizador().insert(comando+"\n", interfaz.getTextArea_Visualizador().getRows());
				}

			} catch (IOException e) {

			}
		}
	}
		
	public static void establecerConexionTCP(String ip, String port){
		int puerto = Integer.parseInt(port);
		try {
			
			
			//inicializa conexion tcp
			socketTCP = new Socket(ip,puerto);
			lector = new BufferedReader(new InputStreamReader(socketTCP.getInputStream()));
			escritor = new PrintWriter(socketTCP.getOutputStream(),true);
			//iniciliza conexiones udp unicast, queda con puerto aleatorio para evitar conflictos
			socketUDP_Unicast = new DatagramSocket();
			//iniciliza conexiones udp multicast, queda con puerto aleatorio para evitar conflictos y se une a grupo
			socketUDP_Multicast = new MulticastSocket(6150);
			socketUDP_Multicast.joinGroup(InetAddress.getByName(ipGrupo));
			
			nombre  = JOptionPane.showInputDialog("Introduzca su nombre");

			//confirma conexion tcp
			escritor.println(OK);
			String comando = lector.readLine();
			if(comando.equals(OK)){
				escritor.println(nombre+"/"+socketUDP_Unicast.getInetAddress().getLocalHost().getHostAddress()
				         +"/"+socketUDP_Unicast.getLocalPort());;
				JOptionPane.showMessageDialog(null, "Conexion establecida exitosamente");
				difundirMensaje(ACTUALIZAR);
			}

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la ip");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}
	}
	public static void actualizarCHAT() throws NumberFormatException, IOException{
		
		escritor.println(ACTUALIZAR);
	
			int numeroUsiarios = Integer.parseInt(lector.readLine());
			String[] nombres = lector.readLine().split("/");
			String[] ips = lector.readLine().split("/");
			String[] puertos = lector.readLine().split("/");
			
				interfaz.getComboBoxUSUARIOS().removeAllItems();
				
			int j =0;	
			while(j<numeroUsiarios){
				interfaz.getComboBoxUSUARIOS().addItem(new Usuarios(nombres[j],ips[j],puertos[j]));
				j++;
			}
	}

	public static void escucharEnviarMensaje(){
		
		interfaz.getBtnEnviarMensajePrivado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent r) {

				try {
					Usuarios  temp = (Usuarios)interfaz.getComboBoxUSUARIOS().getSelectedItem();
					String msj = "PV de "+nombre+" : "+interfaz.getTextField_Mensaje().getText();
					if(temp!=null){
					byte[] buf = msj.getBytes();
					DatagramPacket paquete = new DatagramPacket(buf, buf.length, InetAddress.getByName(temp.getIp()), Integer.parseInt(temp.getPuerto()));
					socketUDP_Unicast.send(paquete);
					interfaz.getTextArea_Visualizador().insert("PV a "+temp.getNombre()+" : "+interfaz.getTextField_Mensaje().getText()+"\n", interfaz.getTextArea_Visualizador().getRows());

					}else{
						JOptionPane.showMessageDialog(null, "No ha seleccionado a nadie para enviar mensaje");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
		});
	
	}
	
	public static boolean difundirMensaje(String msj){
		try {
			byte[] buf = msj.getBytes();
			DatagramPacket paquete = new DatagramPacket(buf, buf.length,InetAddress.getByName(ipGrupo),6150);
			socketUDP_Multicast.send(paquete);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public static void escucharDifudirMensaje(){
		interfaz.getBtnDifundirMensaje().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msj = interfaz.getTextField_Mensaje().getText();
				difundirMensaje(nombre+" : "+msj);
			}
		});
	}
	
	public static void escucharAgregarPaciente(){
	
		interfaz.getBtnAgregarPaciente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = interfaz.getTextField_Nombre().getText();
				String apellido = interfaz.getTextField_Apellido().getText();
				String direccion = interfaz.getTextField_Direccion().getText();
				String telefono = interfaz.getTextField_Telefono().getText();
				String celular = interfaz.getTextField_Celular().getText();
				String id = interfaz.getTextField_Id().getText();
				String ano = interfaz.getTextField_Ano().getText();
				String mes = interfaz.getTextField_Mes().getText();
				String dia = interfaz.getTextField_Dia().getText();
				
				//comprobacion1
				if(!(nombre.equals("")||apellido.equals("")||direccion.equals("")||telefono.equals("")||celular.equals("")
						||id.equals("")||ano.equals("")||mes.equals("")||dia.equals(""))){
					
					
					try {//comprobacion2 
						Integer.parseInt(telefono);
						Integer.parseInt(celular);
						Integer.parseInt(id);
						Integer.parseInt(ano);
						Integer.parseInt(mes);
						Integer.parseInt(dia);
						
						if(ano.trim().length()==4 && mes.trim().length()==2 && dia.trim().length()==2){
						//protocolo
						escritor.println(REGISTRAR);
						escritor.println(nombre+"-"+apellido+"-"+direccion+"-"+telefono+"-"+celular+"-"+id+"-"+(ano.trim())+"-"+(mes.trim())+"-"+(dia.trim()));
						String respuesta = lector.readLine();
							
							if(respuesta.equalsIgnoreCase(OK)){
								JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente");
								limpiarPanelAgregar();
							}else if(respuesta.equalsIgnoreCase(ERROR)){
								JOptionPane.showMessageDialog(null, "No se pudo registrar paciente");
								limpiarPanelAgregar();
							}else{
								JOptionPane.showMessageDialog(null, "Erro en el protocolo");
								limpiarPanelAgregar();
							}
							
						}else{
							JOptionPane.showMessageDialog(null, "Fecha mal introducida, debe tener el formato AAAA.MM.DD");

						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Hay letras en un campo que debia introducir numero, recuerde que id es numerico");
					}
						
				}else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios, por favor ingrese todos los campos");
				}
			}
		});
	}
	
	public static void escucharBuscarPacientePanelAgregar(){
		
		interfaz.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String id = interfaz.getTextField_IdCita().getText();
					
					Integer.parseInt(id);
					
					if(!id.equalsIgnoreCase("")){
						
						escritor.println(CONSULTAR_PERSONA);
						escritor.println(id);
						
						try {
							String respuesta = lector.readLine();
							
							if(respuesta.equalsIgnoreCase(ENCONTRADO)){
								String[] temp = lector.readLine().split("-");
								interfaz.getTextField_NombreCita().setText(temp[0]);
								interfaz.getTextField_ApellidoCita().setText(temp[1]);
							}else if(respuesta.equalsIgnoreCase(NO_ENCONTRADO)){
								JOptionPane.showMessageDialog(null, "El paciente no esta en la base de datos");
							}else{
								JOptionPane.showMessageDialog(null, "Error en protocolo");
							}

						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}else{
						JOptionPane.showMessageDialog(null, "el id esta vacio, ingrese un id");
					}
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "el id debe ser numerico, verifique y vuelva a intentar");
				}
			}
		});
	}

	public static void escucharConsultarDisponibilidad(){
		
		interfaz.getBtnConsultarDisponibilidad().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ano = interfaz.getTextField_AnoCita().getText();
				String mes = interfaz.getTextField_MesCita().getText();
				String dia = interfaz.getTextField_DiaCita().getText();
				
				if(!(ano.equals("")||mes.equals("")||dia.equals(""))){
					if((ano.length()==4||mes.length()==2||dia.length()==2)){
						
						try {
							Integer.parseInt(ano);
							Integer.parseInt(mes);
							Integer.parseInt(dia);
							
							escritor.println(CONSULTAR_FECHA);
							escritor.println(ano+"-"+mes+"-"+dia);

							String[] horarios = lector.readLine().split("-");
							
							for (int i = 0; i < horarios.length; i++) {
								interfaz.getComboBox_HorariosDisponibles().addItem(horarios[i]);
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Los datos de la fecha no son numericos");
						}
	
					}else{
						JOptionPane.showMessageDialog(null, "No ha introducido bien los datos de la feha");
					}
				}else{
					JOptionPane.showMessageDialog(null, "No ha introducido una fecha para verificar");
				}
				
			}
		});
		
	}
	
	public static void escucharAgregarCita(){
		
		interfaz.getBtnAgregarCitaEn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = interfaz.getTextField_IdCita().getText();
				String nom = interfaz.getTextField_NombreCita().getText();
				String ano = interfaz.getTextField_AnoCita().getText();
				String mes = interfaz.getTextField_MesCita().getText();
				String dia = interfaz.getTextField_DiaCita().getText();
				String hora = (String) interfaz.getComboBox_HorariosDisponibles().getSelectedItem();
				
				if(!(id.equals("")||nom.equals(""))){
					if(!(ano.equals("")||mes.equals("")||dia.equals(""))){

					escritor.println(AGREGAR_CITA);
					escritor.println(id+"-"+ano+"-"+mes+"-"+dia+"-"+hora);
					
					try {
						String respuesta = lector.readLine();
						
						if(respuesta.equalsIgnoreCase(OK)){
							JOptionPane.showMessageDialog(null, "Cita agregada exitosamente");
							limpiarPanelCita();
						}else if(respuesta.equalsIgnoreCase(ERROR)){
							JOptionPane.showMessageDialog(null, "Cita no se pudo agregar exitosamente");
							limpiarPanelCita();
						}else{
							JOptionPane.showMessageDialog(null, "Problema en el protocolo");
							limpiarPanelCita();
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					}else{
						JOptionPane.showMessageDialog(null, "Verifique los horarios disponibles para la fecha deseada con el boton consultar");
					}					
				}else{
					JOptionPane.showMessageDialog(null, "Verifique si el paciente existe con el boton buscar");
				}
			}
		});
		
	}
	
	public static void escucharBuscarPacientePanelConsultas(){
		interfaz.getButton_buscarConsultar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					interfaz.getTextPanex_CitasPendientes().setText("");
					interfaz.getComboBox_CitasPendientes().removeAllItems();
					
					String id = interfaz.getTextField_IdConsultar().getText();

					Integer.parseInt(id);

					if(!id.equalsIgnoreCase("")){
						
						escritor.println(CONSULTAR_PERSONA);
						escritor.println(id);
						
						try {
							String respuesta = lector.readLine();
							
							if(respuesta.equalsIgnoreCase(ENCONTRADO)){
								
								String[] temp = lector.readLine().split("-");
								interfaz.getTextField_NombreConsultar().setText(temp[0]);
								interfaz.getTextField_ApellidoConsultar().setText(temp[1]);
								String msj = "";
								if(temp.length>2){
									for (int i = 2; i < temp.length; i++) {
										interfaz.getComboBox_CitasPendientes().addItem(temp[i]);
										msj += temp[i]+"\n";
									}
									interfaz.getTextPanex_CitasPendientes().setText(msj);
								}else{
									JOptionPane.showMessageDialog(null, "El paciente no tiene citas pendientes");
								}
								
							}else if(respuesta.equalsIgnoreCase(NO_ENCONTRADO)){
								JOptionPane.showMessageDialog(null, "El paciente no esta en la base de datos");
							}else{
								JOptionPane.showMessageDialog(null, "Error en protocolo");
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}else{
						JOptionPane.showMessageDialog(null, "el id esta vacio, ingrese un id");
					}
				} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "el id debe ser numerico, verifique y vuelva a intentar");
				}
			}
		});
	}

	public static void escucharEliminarCita(){
		interfaz.getBtnEliminarCita().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String id = interfaz.getTextField_IdConsultar().getText();
				String nom = interfaz.getTextField_NombreConsultar().getText();
				String cita = (String) interfaz.getComboBox_CitasPendientes().getSelectedItem();
				
				if(!(id.equals("")||nom.equals(""))){
					if(!cita.equals("")){
						
						escritor.println(ELIMINAR_CITA);
						String ano = cita.substring(19, 23);
						String mes = cita.substring(24, 26);
						String dia = cita.substring(27, 29);
						String hora = cita.substring(6, 11);
						escritor.println(id+"-"+ano+"-"+mes+"-"+dia+"-"+hora);
						
						try {
							String respuesta = lector.readLine();
							
							if(respuesta.equalsIgnoreCase(OK)){
								JOptionPane.showMessageDialog(null, "Cita eliminada con exito");
								limpiarPanelConsulta();
							}else if(respuesta.equalsIgnoreCase(ERROR)){
								JOptionPane.showMessageDialog(null, "Cita no pudo se eliminada con exito");
								limpiarPanelConsulta();
							}else {
								JOptionPane.showMessageDialog(null, "Error de protocolo");
								limpiarPanelConsulta();
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						
					}else{
						JOptionPane.showMessageDialog(null, "No hay cita para eliminar");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Verifique las citas pendientes con el boton busca primero");
				}
				
				
			}
		});
	}
	
	public static void limpiarPanelConsulta(){
		interfaz.getTextField_IdConsultar().setText("");
		interfaz.getTextField_NombreConsultar().setText("");
		interfaz.getTextField_ApellidoConsultar().setText("");
		interfaz.getTextPanex_CitasPendientes().setText("");
		interfaz.getComboBox_CitasPendientes().removeAllItems();
	}

	public static void limpiarPanelCita(){
		interfaz.getTextField_IdCita().setText("");
		interfaz.getTextField_NombreCita().setText("");
		interfaz.getTextField_ApellidoCita().setText("");
		interfaz.getTextField_DiaCita().setText("");
		interfaz.getTextField_MesCita().setText("");
		interfaz.getTextField_AnoCita().setText("");
		interfaz.getComboBox_HorariosDisponibles().removeAllItems();
		interfaz.frame.repaint();
	}

	public static void limpiarPanelAgregar(){

		interfaz.getTextField_Nombre().setText("");
		interfaz.getTextField_Apellido().setText("");
		interfaz.getTextField_Direccion().setText("");
		interfaz.getTextField_Telefono().setText("");
		interfaz.getTextField_Celular().setText("");
		interfaz.getTextField_Id().setText("");
		interfaz.getTextField_Ano().setText("");
		interfaz.getTextField_Mes().setText("");
		interfaz.getTextField_Dia().setText("");
	}
	
	public static void escucharSalir(){
		
		interfaz.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				escritor.println(FINALIZAR_CONEXION);
				escritor.println(nombre);
				
				try {
					lector.close();
					escritor.close();
					socketTCP.close();
					difundirMensaje(ACTUALIZAR);
					socketUDP_Unicast.close();
					socketUDP_Multicast.leaveGroup(InetAddress.getByName(ipGrupo));
					socketUDP_Multicast.close();


				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				System.exit(0);
			}
			
		});
		
	}
	
}
