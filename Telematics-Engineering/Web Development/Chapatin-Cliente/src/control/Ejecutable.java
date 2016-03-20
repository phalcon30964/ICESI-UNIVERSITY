package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import vista.Ventana;




import vista.VentanaCitas;
import vista.VentanaCliente;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.Principal;

public class Ejecutable {

	private static Socket canal;
	private static BufferedReader lector;
	private static PrintWriter escritor;
	private ArrayList<String> datosPaciente;
	private static Ventana vista;
	private static VentanaCliente vCliente;
	private static VentanaCitas vCitas;
	private static MulticastSocket mSocket;
	private static InetAddress direccionGrupo;

	private final static String DIR="127.0.0.1";
	private final static int PUERTO=4444;
	private final static String VC="VERIFICAR_CEDULA";
	private final static String CEDULA="CEDULA";
	private final static String EXISTE="EXISTE";
	private final static String YA="YA";
	private final static String NO_CITAS="NO CITAS";
	private final static String NO_SE_ENCUENTRA="NO SE ENCUENTRA";
	private final static String RP="REGISTRAR PACIENTE";
	private final static String DATOS="DATOS";
	private final static String CC="CC";
	private final static String RC="RC";
	private final static String CHAO="CHAO";


	public static void main(String[] args)  {

		vista= new Ventana();		
		escucharBotonRegistrar();
		escucharBotonVerificar();
		escucharBotonDifusion();
		vista.setVisible(true);
		inicializarCanal();
		inicializarCanalMulticast();
	}

	public static void inicializarCanal(){


		try{
			canal = new Socket(DIR,PUERTO);
			lector = new BufferedReader(new InputStreamReader(canal.getInputStream()));
			escritor = new PrintWriter(canal.getOutputStream(), true);

		} catch (UnknownHostException e) {
			System.out.println("Host " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error IO " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error suma " + e.getMessage());
		}
	}
	public static void registrarPaciente(String nom, String ape, String ced, String dir , String tel, String cel, String fecha ){
		String reg= nom +";"+ ape+";"+ced+";"+dir+";"+tel+";"+cel+";"+fecha;


		escritor.println(RP);
		escritor.flush();
		try {
			if(lector.readLine().equals(DATOS)){
				escritor.println(reg);			
				escritor.flush();

				String respuesta = lector.readLine();
				if(respuesta.equals("SI")){
					JOptionPane.showMessageDialog(null, "El Cliente Se Registro Satisfactoriamente", "Registrado", JOptionPane.INFORMATION_MESSAGE);
				}
				else{

					JOptionPane.showMessageDialog(null, "Ya Existe Un Cliente con Este numero de cedula", "Ya Existe", JOptionPane.WARNING_MESSAGE);
				}

				escritor.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void inicializarCanalMulticast() {
		// TODO Auto-generated method stub
		boolean escuchar = true;

		try {
			//unirse al grupo
			mSocket = new MulticastSocket(6500);

			direccionGrupo = InetAddress.getByName("224.0.0.0");

			mSocket.joinGroup(direccionGrupo);

			while(escuchar){

				// recibir mensajes
				byte[]buf = new byte[200];

				DatagramPacket recibe = new DatagramPacket(buf, buf.length);
				mSocket.receive(recibe);


				String datos = "DIFUCION:   ";
				byte[] dat = recibe.getData();

				for(int i = 0; i<dat.length; i++){
					datos +=  (char)dat[i];

				}


				darDatos(datos);
				if(datos.equals("Fin")){

					escuchar=false;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	public static void darDatos(String datos){

		String texto = "";
		texto += datos;

		vista.getTextArea().setText(texto);

	}


	public static void verificarCedula(String ced) {
		String cedu = ced;

		escritor.println(VC);		
		escritor.flush();


		try {
			String lectura = lector.readLine();
			if(lectura.equalsIgnoreCase(CEDULA)){
				escritor.println(cedu);

				lectura = lector.readLine();
				if(lectura.equalsIgnoreCase(NO_SE_ENCUENTRA)){
					JOptionPane.showMessageDialog(null,"Por Favor Registra el Paciente","Paciente No Existe",JOptionPane.WARNING_MESSAGE);
				}
				else if(lectura.equalsIgnoreCase(EXISTE)){
					lectura = lector.readLine();
					vCliente= new VentanaCliente();
					String[] datosPa = new String[3];
					datosPa = lectura.split(";");					
					vCliente.getLbCedulaCli().setText(datosPa[0]);
					vCliente.getLbNyA().setText(datosPa[1]+" "+datosPa[2]);

					escritor.println(YA);
					escritor.flush();
					lectura = lector.readLine();

					if(!lectura.equals(NO_CITAS)){
						DefaultListModel modelo = new DefaultListModel();

						String[] arS =new String[2];
						arS = lectura.split("/");
						int numcitas= Integer.parseInt(arS[0]);
						String[] arC = new String[numcitas];
						arC = arS[1].split(";");
						for(int i =0;i<arC.length;i++){
							modelo.addElement(arC[i]);
						}
						((VentanaCliente) vCliente).getLsCitas().setModel(modelo);
					}
					escuchaVentanaCliente();
					escucharBotonNuevaCita();
					escucharBotonCancelarCi();

					vista.setVisible(false);
					vCliente.setVisible(true);
				}
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void registrarCita(){

		int seleccion = vCitas.getCitasFecha().getSelectedIndex();
		String fecha = vCitas.getTxFecha().getText();
		String ced = vista.getTxtVerificar().getText();
		String mensaje = ""+seleccion+"-"+ced+"-"+fecha;

		escritor.println(RC);
		escritor.flush();
		try {
			if(lector.readLine().equals("HORA")){
				escritor.println(mensaje);
				escritor.flush();

				JOptionPane.showMessageDialog(null, "Su cita se ha asignado exitosamente "  , "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void escucharBotonRegistrar(){

		vista.getBtnRegistrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String nom = vista.getTxtNombre().getText();
				String ape = vista.getTxtApellido().getText();
				String ced = vista.getTxtCedula().getText();
				String dir = vista.getTxtDireccion().getText();
				String tel = vista.getTxtTelefono().getText();
				String cel = vista.getTxtCelular().getText();
				String fec = vista.getTxtFecha().getText();

				registrarPaciente(nom,ape,ced,dir,tel,cel,fec);
				vaciarCamposRegistro();

			}
		});
	}

	public static void difundir(){

		escritor.println("DIFU");
		escritor.flush();

		String lectura;
		try {
			lectura = lector.readLine();
			if(lectura.equals("DEME_MENSAJE")){
				String mensaje = vista.getTxtEnviar().getText();
				escritor.println(mensaje);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void escucharBotonDifusion(){
		vista.getBtnDifusion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				difundir();
			}
		});

	}

	public static void escuchaVentanaCliente() {
		vCliente.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

				vista.setVisible(true);
			}
		});
	}

	public static void escuchaVentanaCitas() {
		vCitas.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				verificarCedula(vCliente.getLbCedulaCli().getText());
				vCliente.setVisible(true);
			}
		});
	}

	public static void escucharBotonVerificar(){

		vista.getBtnVerificar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				;
				String ced = vista.getTxtVerificar().getText();
				verificarCedula(ced);				

			}
		});

	}

	public static  void escucharBotonRegistrarCita(){

		vCitas.getBtregistrarCita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				registrarCita();
				String fecha = vCitas.getTxFecha().getText();
				//				System.out.println("Fecha "+ fecha);
				mostrarLista(fecha);
				//				System.out.println("Hecho");
			}
		});
	}

	public static void escucharBotonNuevaCita(){

		vCliente.getBtNCita().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				vCitas = new VentanaCitas();

				escuchaVentanaCitas();
				escucharBotonConsultarFecha();
				escucharBotonRegistrarCita();

				vCliente.setVisible(false);
				vCitas.setVisible(true);	

			}
		});

	}

	public static void vaciarCamposRegistro(){

		vista.getTxtNombre().setText("");
		vista.getTxtApellido().setText("");
		vista.getTxtCedula().setText("");
		vista.getTxtDireccion().setText("");
		vista.getTxtTelefono().setText("");
		vista.getTxtCelular().setText("");
		vista.getTxtFecha().setText("");


	}

	public static void mostrarLista(String fecha){

		escritor.println("DD");
		escritor.flush();
		String lectura;
		try {
			lectura = lector.readLine();
			if(lectura.equals("FECHA")){


				escritor.println(fecha);
				escritor.flush();
				String cad = lector.readLine();
				String[] disp = new String[15];
				disp = cad.split(";");
				refrescarLista(disp);


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void refrescarLista(String[] disp){

		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement("8:00    "+disp[0]);
		modelo.addElement("8:30    "+disp[1]);
		modelo.addElement("9:00    "+disp[2]);
		modelo.addElement("9:30    "+disp[3]);
		modelo.addElement("10:00   "+disp[4]);
		modelo.addElement("10:30   "+disp[5]);
		modelo.addElement("11:00   "+disp[6]);
		modelo.addElement("11:30   "+disp[7]);
		modelo.addElement("14:00   "+disp[8]);
		modelo.addElement("14:30   "+disp[9]);
		modelo.addElement("15:00   "+disp[10]);
		modelo.addElement("15:30   "+disp[11]);
		modelo.addElement("16:00   "+disp[12]);
		modelo.addElement("16:30   "+disp[13]);
		modelo.addElement("17:00   "+disp[14]);
		vCitas.getCitasFecha().setModel(modelo);
	}

	public static void escucharBotonConsultarFecha(){

		vCitas.getBtCFecha().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String fecha = vCitas.getTxFecha().getText();
				//				System.out.println("Fecha "+ fecha);
				mostrarLista(fecha);
				System.out.println("Hecho");
			}
		});

	}

	public static void cancelarCita(){
		escritor.println(CC);
		escritor.flush();
		try {
			if(lector.readLine().equals("INFO")){
				String cita = (String) vCliente.getLsCitas().getSelectedValue();


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void escucharBotonCancelarCi(){

		vCliente.getBtEcita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cancelarCita();
			}
		});
	}

	public static void escuchaVentana() {
		vista.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				escritor.println(CHAO);
				escritor.flush();
				JOptionPane.showInputDialog(this, "La conexion se ha cerrado exitosamente");
				vista.setVisible(false);

			}
		});
	}





}
