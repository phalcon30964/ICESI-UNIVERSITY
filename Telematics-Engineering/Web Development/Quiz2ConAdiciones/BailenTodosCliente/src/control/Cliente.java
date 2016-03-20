package control;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Cancion;
import modelo.Disco;
import modelo.DiscoTiendaCliente;
import vista.Interfaz;


public class Cliente {

	//----------------------------------------atributos---------------------------------------------------------------
	private static Interfaz interfaz;
	private static DiscoTiendaCliente mundo;
	private static Socket socket;	
	private static BufferedReader lector;
	private static PrintWriter escritor;
	private static ObjectOutputStream escritorObjetos;
	private static ObjectInputStream lectorObjetos;
	
	//----------------------------------------constantes---------------------------------------------------------------
	public static final String DIRECCIONIP = "127.0.0.1";
	public static final int PUERTO = 62000;

	//----------------------------------------comandos---------------------------------------------------------------

	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String REGISTRAR_ARTISTA = "REGISTRAR_ARTISTA";
	public static final String REGISTRAR_CANCION = "REGISTRAR_CANCION";
	public static final String REGISTRAR_DISCO = "REGISTRAR_DISCO";
	public static final String CONSULTAR_DISCOS = "CONSULTAR_DISCOS";
	public static final String CONSULTAR_DISCOS_NOMBRE = "NOMBRE";
	public static final String CONSULTAR_DISCOS_CANCION = "CANCION";
	public static final String CONSULTAR_DISCOS_ARTISTA = "ARTISTA";
	public static final String CONSULTAR_DISCOS_GENERO = "GENERO";
	public static final String CONSULTAR_ARTISTAS = "CONSULTAR_ARTISTAS";
	public static final String VENDER = "VENDER";
	public static final String ESTADISTICA = "ESTADISTICA";
	public static final String ESTADISTICA_IND = "ESTADISTICA_IND";
	public static final String FOTO = "FOTO";
	public static final String CARATULA = "CARATULA";

	

	
	//----------------------------------------main---------------------------------------------------------------
	
	public static void main(String[] args) {
		
		establecerConexion(DIRECCIONIP, PUERTO);
		mundo = new DiscoTiendaCliente();
		
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				inicializarInterfaz();
				escucharSeleccionarFotoArtista();
				escucharRegistrarArtista();
				escucharSeleccionarCaratula();
				escucharRegistarDisco();
				escucharRegistrarCancion();
				escucharConsultarDiscosPor();
				escucharListaResultadoDeDiscos();
				escucharVenderDisco();
				escucharComboBoxFoto();
				escucharComboBoxCaratula();
				escucharSalir();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
	}
	
	//----------------------------------------metodos de la interfaz---------------------------------------------------------------
	
	/**
	 * Metodo que establece conexion al servidor ye inicializa los flujos necesario para transmitir informacion
	 * 
	 * @param ip del servidor
	 * @param port del servidor
	 */
	public static void establecerConexion(String ip, int port){
		try {
			//creo un canal por donde escribir y escuchar
			socket = new Socket(ip,port);
			//inicializo los flujos del canal
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			lectorObjetos = new ObjectInputStream( socket.getInputStream()); 
			escritor = new PrintWriter(socket.getOutputStream(),true);	
		    escritorObjetos = new ObjectOutputStream( socket.getOutputStream()); 

			//inicializo protocolo handshake
			escritor.println(OK);
			String comando = lector.readLine();
			if(comando.equals(OK)){
				JOptionPane.showMessageDialog(null, "Conexion establecida exitosamente");
			}

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la ip");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que inicializa la interfaz del cliente, llena el combobox de tipoId y setea la foto y caratura generica
	 */
	public static void inicializarInterfaz(){
		
		interfaz = new Interfaz();
		interfaz.getComboBoxTipoId_Artista().addItem("C.C.");
		interfaz.getComboBoxTipoId_Artista().addItem("D.I.");
		interfaz.getComboBoxTipoId_Artista().addItem("C.E.");
		interfaz.getComboBoxBusquedaPor_Ventas().addItem(CONSULTAR_DISCOS_NOMBRE);
		interfaz.getComboBoxBusquedaPor_Ventas().addItem(CONSULTAR_DISCOS_CANCION);
		interfaz.getComboBoxBusquedaPor_Ventas().addItem(CONSULTAR_DISCOS_ARTISTA);
		interfaz.getComboBoxBusquedaPor_Ventas().addItem(CONSULTAR_DISCOS_GENERO);

		refrescarComboboxArtistas();
		refrescarComboboxDiscos();
		setCaratulaGenerica();
		setFotoGenerica();
		setEstadistica();
		setEstadisticaIndividual();
		interfaz.frame.setVisible(true);
	}
	
	/**
	 * Metodo al que se le relega setear la imagen por defecto para la foto de los artistas nuevos
	 */
	public static void setFotoGenerica(){
		try {
			File inputFoto = new File("./data/foto.jpg");
	    	ImageIcon imagen = new ImageIcon(ImageIO.read(inputFoto).getScaledInstance(111, 148,java.awt.Image.SCALE_SMOOTH));
	    	interfaz.getLabelFoto_Artista().setIcon(imagen);
	    	interfaz.setFotoArtista(imagen);
		} catch (IOException e) {
			System.out.println("No se pudo cargar la foto por defecto");
		}	
	}
	
	/**
	 * Metodo al que se le relega setear la imagen por defecto para las caratula de los discos nuevos
	 */
	public static void setCaratulaGenerica(){
		try {
			File inputCaratula = new File("./data/caratula.jpg");
	    	ImageIcon imagen = new ImageIcon(ImageIO.read(inputCaratula).getScaledInstance(190, 140,java.awt.Image.SCALE_SMOOTH));
	    	interfaz.getLabelCaratula_Disco().setIcon(imagen);
	    	interfaz.setCaratulaDisco(imagen);
		} catch (IOException e) {
			System.out.println("No se pudo cargar la caratula por defecto");
		}	
	}
	
	/**
	 * Metodo que se ecarga de cerrar todos los flujos al cerrar la ventana principal
	 */
	public static void escucharSalir() {
		interfaz.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				try {
					escritor.println(FINALIZAR_CONEXION);
					escritor.close();
					escritorObjetos.close();
					lector.close();
					lectorObjetos.close();
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Metodo que refresca la interfaz
	 */
	public static void refrescarComboboxDiscos(){
		try {
			escritor.println(CONSULTAR_DISCOS);
			ArrayList<String > discos = (ArrayList<String >)lectorObjetos.readObject();
			
			interfaz.getComboBoxDisco_Cancion().removeAllItems();
			
			for (int i = 0; i < discos.size(); i++) {
				interfaz.getComboBoxDisco_Cancion().addItem(discos.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que refresca la interfaz
	 */
	public static void refrescarComboboxArtistas(){
		try {
			escritor.println(CONSULTAR_ARTISTAS);
			ArrayList<String > artistas = (ArrayList<String >)lectorObjetos.readObject();
			
			interfaz.getComboBoxArtista_Cancion().removeAllItems();
			interfaz.getComboBoxArtistaPrincipal_Disco().removeAllItems();
			
			for (int i = 0; i < artistas.size(); i++) {
				interfaz.getComboBoxArtista_Cancion().addItem(artistas.get(i));
				interfaz.getComboBoxArtistaPrincipal_Disco().addItem(artistas.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------metodos la pestana artistas---------------------------------------------------------------

	
	/**
	 * Meotodo que controla el boton para seleccionar una nueva imagen para el artista que este registrando
	 * solo se permite seleccionar archivos JPG y solo archivos. 
	 * Ademas se recorta la imagen que se seleccione para adecuarse a la interfaz.
	 */
	public static void escucharSeleccionarFotoArtista(){
		
		interfaz.getBtnSeleccionarFoto_Artista().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		        JFileChooser j = new JFileChooser();
		        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG file", "jpg");
				j.addChoosableFileFilter(filter);
		        int estado=j.showOpenDialog(null);

		        try{

		        if(estado== JFileChooser.APPROVE_OPTION){
		        	
		        	if(j.getSelectedFile().length()<1000000){
		        		Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance(111, 148,java.awt.Image.SCALE_SMOOTH);
			        	ImageIcon imagen = new ImageIcon(icono);
			        	
						interfaz.getLabelFoto_Artista().setIcon(imagen);
						interfaz.setFotoArtista(imagen);
		        	}else{
		        		JOptionPane.showMessageDialog(null,"Imagen demasiado pesada por favor seleccione una imagen de hasta 100kb");
		        	}
		        	
		        }
		        
		        }catch(Exception e2){
		        	e2.printStackTrace();
		        }
			}
		});
	}
	
	/**
	 * Metodo que controla el boton registrar artista, usa la informacion registrada por el usuario para enviarse al serividor 
	 * y crear un nuevo usuario.
	 * 
	 * pos: se ha creado un nuevo artista en la base de datos
	 */
	public static void escucharRegistrarArtista(){
		
		interfaz.getBtnRegistrarArtista_Artista().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				String nomNatural = interfaz.getTextFieldNombreCompleto_Artista().getText();
				String nomArtistico = interfaz.getTextFieldNombreArtistico_Artista().getText();
				String tipoId = interfaz.getComboBoxTipoId_Artista().getSelectedItem().toString();
				String id = interfaz.getTextFieldId_Artista().getText();
				String dirRes = interfaz.getTextFieldDireccionResidencia_Artista().getText();
				String ciuRes = interfaz.getTextFieldCiudadResidencia_Artista().getText();
				String dirCorr = interfaz.getTextFieldDireccion_Correspondencia_Artista().getText();
				String ciuCorr = interfaz.getTextFieldCiudadCorrespondencia_Artista().getText();
				String tel = interfaz.getTextFieldTelfono_Artista().getText();
				String numContacto = interfaz.getTextFieldNumContacto_Artista().getText();
				ImageIcon imagen = interfaz.getFotoArtista();
				
				
				if(!nomNatural.equals("") && !nomArtistico.equals("") && !tipoId.equals("") && !id.equals("") && !dirRes.equals("") 
						&& !ciuRes.equals("") && !dirCorr.equals("") && !ciuCorr.equals("") && !tel.equals("") && !numContacto.equals("")){
					
					try {
						Integer.parseInt(id);
						Integer.parseInt(tel);
						Integer.parseInt(numContacto);
						
						//aqui comienza el protocolo
	
						escritor.println(REGISTRAR_ARTISTA);
						escritor.println(nomNatural+","+nomArtistico+","+tipoId+","+id+","+dirRes+","+ciuRes+","+dirCorr+","+ciuCorr+","+tel+","+numContacto);
						escritorObjetos.writeObject(serialize(imagen));
						
						String resServidor = lector.readLine();
						
						if (resServidor.equals(OK)) {
							JOptionPane.showMessageDialog(null, "Registro existoso");
						}else{
							JOptionPane.showMessageDialog(null, "Registro fallido");
						}
					
						//aqui termina el protocolo
							
						setFotoGenerica();
						refrescarComboboxArtistas();

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "El id, telefono y numero de contacto deben ser numeros. Vuelva a ingresar datos e intente de nuevo");
						e.printStackTrace();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios por favor ingrese todos los datos y vuelva a intentar");
				}
			}
		});
		
	}
	
	
	//----------------------------------------metodos la pestana discos---------------------------------------------------------------

	/**
	 * Metodo que permite seleccionar caratula del disco que se esta registrando
	 */
	public static void escucharSeleccionarCaratula(){
		
		interfaz.getBtnSeleccionarCaratula_Disco().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		        JFileChooser j = new JFileChooser();
		        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG file", "jpg");
				j.addChoosableFileFilter(filter);
		        int estado=j.showOpenDialog(null);

		        try{

		        if(estado== JFileChooser.APPROVE_OPTION){
		        	
		        	if(j.getSelectedFile().length()<1000000){
		        	Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance(190, 140,java.awt.Image.SCALE_SMOOTH);
		        	ImageIcon imagen = new ImageIcon(icono);
		        	
					interfaz.getLabelCaratula_Disco().setIcon(imagen);
					interfaz.setCaratulaDisco(imagen);
		        	}else{
		        		JOptionPane.showMessageDialog(null,"Imagen demasiado pesada por favor seleccione una imagen de hasta 100kb");
		        	}
		        }
		        
		        }catch(Exception e2){
		        	e2.printStackTrace();
		        }
			}
		});
	}

	/**
	 * Metodo que envia datos de un disco nuevo para registralos en la base de datos
	 * 
	 * pos: un nuevo disco se ha creado
	 */
	public static void escucharRegistarDisco(){
		
		interfaz.getBtnRegistrarDisco_Disco().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String titulo = interfaz.getTextFieldNombre_Disco().getText();
				String genero = interfaz.getTextFieldGenero_Disco().getText();
				String uniDisponibles = interfaz.getTextFieldDisponibles_Disco().getText();
				ImageIcon imagen = interfaz.getCaratulaDisco();
				String artista = interfaz.getComboBoxArtistaPrincipal_Disco().getSelectedItem().toString();

				if(!titulo.equals("") && !genero.equals("")&&!artista.equals("")){
					
					try {
						Integer.parseInt(uniDisponibles);
						//Aqui empieza el protocolo
						
						escritor.println(REGISTRAR_DISCO);
						escritor.println(titulo+","+genero+","+uniDisponibles+","+artista);
						escritorObjetos.writeObject(serialize(imagen));
						
						String resServidor = lector.readLine();
						
						if (resServidor.equals(OK)) {
							JOptionPane.showMessageDialog(null, "Registro existoso");
						}else{
							JOptionPane.showMessageDialog(null, "Registro fallido");
						}

						//Aqui termina el protocolo
						setCaratulaGenerica();
						refrescarComboboxDiscos();
						setEstadistica();
						setEstadisticaIndividual();
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Las unidades disponibles debe ser un numero");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios, por favor ingreselos y vuelva a intentar");
				}
			}
		});
	}
	
	//----------------------------------------metodos la pestana cancion---------------------------------------------------------------
	/**
	 * Metodo que envia los datos de una cancion para registrase de en el servidor
	 */
	public static void  escucharRegistrarCancion(){
		
		
		interfaz.getBtnRegistroCancion_Cancion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = interfaz.getTextFieldNombre_Cancion().getText();
				String duracion = interfaz.getTextFieldDuracion_Cancion().getText();
				String album = interfaz.getComboBoxDisco_Cancion().getSelectedItem().toString();
				String artista = interfaz.getComboBoxArtista_Cancion().getSelectedItem().toString();
				
				if(!(nombre.equals("")||duracion.equals("")||album.equals("")||artista.equals(""))){
					
					try {
						Integer.parseInt(duracion);
						
						//Aqui empieza el protocolo
						
						escritor.println(REGISTRAR_CANCION);
						escritor.println(nombre+","+duracion+","+album+","+artista);
						
						String resServidor = lector.readLine();
						
						if (resServidor.equals(OK)) {
							JOptionPane.showMessageDialog(null, "Registro existoso");
						}else{
							JOptionPane.showMessageDialog(null, "Registro fallido");
						}
						
						//Aqui termina el protocolo
										
					} catch (Exception i) {
						JOptionPane.showMessageDialog(null, "Las duracion del disco es un numero que representa la longitud del disco en minutos, por favor ingrese un numero ");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios, por favor ingreselos y vuelva a intentar");
				}
				
			}
		});
	}
	
	//----------------------------------------metodos la pestana ventas---------------------------------------------------------------
	/**
	 * Metodo que permite la consulta al servidor de los discos que se desean vender.
	 */
	public static void escucharConsultarDiscosPor(){
		
		interfaz.getBtnBuscarDisco_Ventas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String criterioBusqueda = interfaz.getComboBoxBusquedaPor_Ventas().getSelectedItem().toString();
				String palabraClave = interfaz.getTextFieldBuscarDisco_Ventas().getText();
				
				if(!palabraClave.equals("")){
					
					try {
						escritor.println(criterioBusqueda);
						escritor.println(palabraClave);
						mundo.setListadoDiscos((ArrayList<Disco>)lectorObjetos.readObject());								
						
						interfaz.getListaResultados_Ventas().removeAll();
						interfaz.getLabelCaratula_Ventas().setIcon(null);
						interfaz.getListaResultadosCancion_Ventas().removeAll();
						
						for (int i = 0; i < mundo.getListadoDiscos().size(); i++) {
							interfaz.getListaResultados_Ventas().addItem(mundo.getListadoDiscos().get(i).toString());
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} 

					//aqui termina el protocolo
				}else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios, por favor ingreselos y vuelva a buscar");
				}
				
				
			}
		});
	}
	
	/**
	 * Metodo que escucha las selecciones de la lista de resultado de discos
	 */
	public static void escucharListaResultadoDeDiscos(){
	

		interfaz.getListaResultados_Ventas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Disco d = mundo.buscarDisco(interfaz.getListaResultados_Ventas().getSelectedItem());
				interfaz.getLabelCaratula_Ventas().setIcon(d.getImagen());
				
				interfaz.getListaResultadosCancion_Ventas().removeAll();
				ArrayList<Cancion> c = d.getCanciones();
				for (int i = 0; i < c.size(); i++) {
					interfaz.getListaResultadosCancion_Ventas().addItem("Track "+(i+1)+" "+c.get(i).toString());
				}
			}
		});
	}
	
	/**
	 * Metodo que permite enviar al servidor los discos que se desean ver
	 */
	public static void escucharVenderDisco(){
		
		
		interfaz.getBtnVenderDisco_Ventas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String num = interfaz.getTextFieldNumDiscos_Ventas().getText();
				String disco = interfaz.getListaResultados_Ventas().getSelectedItem();
				
				if(disco != null && !num.equals("")){
					
					try {
						Integer.parseInt(num);
						
						escritor.println(VENDER);
						escritor.println(disco+","+num);
						
						String resServidor = lector.readLine();
						
						if (resServidor.equals(OK)) {
							JOptionPane.showMessageDialog(null, "Venta existosa");
						}else{
							JOptionPane.showMessageDialog(null, "Venta fallida, no hay suficientes copias");
						}
						
						setEstadistica();
						setEstadisticaIndividual();
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El campo numero discos es numerico");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "No ha seleccionado ningun disco, por favor busquelo y haga doble click encima del nombre");
				}
				
			}
		});
		
	}
	
	//----------------------------------------metodos la pestana estadisticas---------------------------------------------------------------

	/**
	 * Metodo setea las estadisticas de la aplicacion
	 */
	public static void setEstadistica(){
		
		try {
			escritor.println(ESTADISTICA);
			String resServidor = lector.readLine();
			String[] datos = resServidor.split(",");
			
			interfaz.getTextFieldNumVendidos_Estadisticas().setText(datos[0]);
			interfaz.getTextFieldNumDisponibles_Estadisticas().setText(datos[1]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * Metodo setea las estadisticas de la aplicacion
	 */
	public static void setEstadisticaIndividual(){
		
		try {
			
			escritor.println(ESTADISTICA_IND);
			ArrayList<String> result = (ArrayList<String>)lectorObjetos.readObject();
			
			interfaz.getListResultados_Estadisticas().removeAll();;
			for (int i = 0; i < result.size(); i++) {
				interfaz.getListResultados_Estadisticas().addItem(result.get(i));;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	 public static byte[] serialize(Object obj) throws IOException {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        ObjectOutputStream o = new ObjectOutputStream(b);
	        o.writeObject(obj);
	        return b.toByteArray();
	    }
	 
	 public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
	        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
	        ObjectInputStream o = new ObjectInputStream(b);
	        return o.readObject();
	    }
	 
	 public static void escucharComboBoxFoto(){
		 
		 interfaz.getComboBoxArtista_Cancion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
					Object temp = interfaz.getComboBoxArtista_Cancion().getSelectedItem();
					
					if(temp!=null){
						String a = temp.toString();
						escritor.println(FOTO);
						escritor.println(a);
						ImageIcon foto = new ImageIcon(((ImageIcon)lectorObjetos.readObject()).getImage().getScaledInstance( 112, 75, java.awt.Image.SCALE_SMOOTH));
						interfaz.getLabelMinuaturaArtista_Cancion().setIcon(foto);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		  
	 }
	 
	 public static void escucharComboBoxCaratula(){
		 
		 interfaz.getComboBoxDisco_Cancion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Object temp = interfaz.getComboBoxDisco_Cancion().getSelectedItem();
					if(temp!=null){
						String a = temp.toString();
						escritor.println(CARATULA);
						escritor.println(a);
						ImageIcon foto = new ImageIcon(((ImageIcon)lectorObjetos.readObject()).getImage().getScaledInstance( 112, 75, java.awt.Image.SCALE_SMOOTH));
						interfaz.getLabel_MiniaturaDisco_Cacion().setIcon(foto);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		  
	 }
	
	
	

	
	
	
}
