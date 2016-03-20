package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import mundo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;



import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.TextArea;

public class InterfazEnergiaParaLaVida extends JFrame{
	
	public Mensaje mensajeActual;
	public Dia diaActual;
	private String rutaPersistencia ;
	public EnergiaParaLaVida mundo;
	

	private JFrame frame;
	private JLabel labBanner;
	private JPanel panelBanner;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnho;
	private JTextField txtColorRecomendado;
	private JButton butAgregarDia;
	private JTextField txtColorRecomendadoActual;
	private JTextField txtMensajeMotivacionActual;
	private JButton butMensajeAnterior;
	private JButton butMensajeSiguiente;
	private JTextField txtAutorActual;
	private JButton butAgregarUnMensaje;
	private JButton butEliminarUnMensaje;
	public JComboBox comboBoxDia;
	private JTextField txtDiaActual;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEnergiaParaLaVida window = new InterfazEnergiaParaLaVida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazEnergiaParaLaVida() {
		
		rutaPersistencia = "./data/archivo";
		deserializar();
		initialize();
		refrescarComboBoxDia();
		refrescarPanelMensajesMotivaciones(mundo.darDiaFechaMasCerca());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 643, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelBanner = new JPanel();
		labBanner = new JLabel(new ImageIcon("./data/ima.jpg"));
		
		JPanel panelMensajesMotivaciones = new JPanel();
		panelMensajesMotivaciones.setBorder(new TitledBorder(null, "Mensajes y Motivaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelVisualizacion = new JPanel();
		panelVisualizacion.setBorder(new TitledBorder(null, "Visualizacion de Motivaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(labBanner, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addGap(261)
					.addComponent(panelBanner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelMensajesMotivaciones, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelVisualizacion, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBanner, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(labBanner, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panelMensajesMotivaciones, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelVisualizacion, 0, 0, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel labDiaActual = new JLabel("Dia Actual:");
		
		JLabel labColorRecomendadorActual = new JLabel("Color Recomendador Actual:");
		
		txtColorRecomendadoActual = new JTextField();
		txtColorRecomendadoActual.setEditable(false);
		txtColorRecomendadoActual.setColumns(10);
		
		JLabel labMensajeDeMotivacion = new JLabel("Mensaje De Motivacion ");
		
		txtMensajeMotivacionActual = new JTextField();
		txtMensajeMotivacionActual.setEditable(false);
		txtMensajeMotivacionActual.setColumns(10);
		
		txtAutorActual = new JTextField();
		txtAutorActual.setEditable(false);
		txtAutorActual.setColumns(10);
		
		JLabel labAutor = new JLabel("Autor");
		
		butMensajeAnterior = new JButton("Mensaje Anterior");
		butMensajeAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeAnterior();
			}
		});
		
		butMensajeSiguiente = new JButton("Mensaje Siguiente");
		butMensajeSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeSiguiente();
			}
		});
		
		comboBoxDia = new JComboBox();
		comboBoxDia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				diaActual = (Dia) e.getItem();
				refrescarPanelMensajesMotivaciones(diaActual);
			}
		});
		
		JTextArea textArea = new JTextArea();
		
		JLabel labEscojaDia = new JLabel("Escoja dia:");
		
		txtDiaActual = new JTextField();
		txtDiaActual.setEditable(false);
		txtDiaActual.setColumns(10);
		GroupLayout gl_panelVisualizacion = new GroupLayout(panelVisualizacion);
		gl_panelVisualizacion.setHorizontalGroup(
			gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVisualizacion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelVisualizacion.createSequentialGroup()
							.addComponent(labMensajeDeMotivacion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMensajeMotivacionActual, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addComponent(butMensajeAnterior, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(butMensajeSiguiente, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panelVisualizacion.createSequentialGroup()
							.addComponent(labAutor)
							.addGap(90)
							.addComponent(txtAutorActual, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
								.addComponent(labColorRecomendadorActual)
								.addComponent(labEscojaDia)
								.addComponent(labDiaActual))
							.addGap(42)
							.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxDia, 0, 102, Short.MAX_VALUE)
								.addComponent(txtColorRecomendadoActual, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(txtDiaActual, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelVisualizacion.setVerticalGroup(
			gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVisualizacion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelVisualizacion.createSequentialGroup()
							.addComponent(labEscojaDia)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labDiaActual))
						.addGroup(Alignment.TRAILING, gl_panelVisualizacion.createSequentialGroup()
							.addComponent(comboBoxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(txtDiaActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtColorRecomendadoActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labColorRecomendadorActual))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addComponent(labMensajeDeMotivacion)
							.addGap(29))
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMensajeMotivacionActual, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)))
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAutorActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labAutor))
					.addGap(8)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.TRAILING)
						.addComponent(butMensajeAnterior, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(butMensajeSiguiente, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelVisualizacion.setLayout(gl_panelVisualizacion);
		
		JPanel panelCrearDia = new JPanel();
		panelCrearDia.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear dia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelCrearMensaje = new JPanel();
		panelCrearMensaje.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Crear o eliminar un mensaje ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelMensajesMotivaciones = new GroupLayout(panelMensajesMotivaciones);
		gl_panelMensajesMotivaciones.setHorizontalGroup(
			gl_panelMensajesMotivaciones.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelMensajesMotivaciones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMensajesMotivaciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCrearMensaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(panelCrearDia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMensajesMotivaciones.setVerticalGroup(
			gl_panelMensajesMotivaciones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMensajesMotivaciones.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCrearDia, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelCrearMensaje, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		butAgregarUnMensaje = new JButton("Agregar un mensaje");
		butAgregarUnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearMensaje();
			}
		});
		
		butEliminarUnMensaje = new JButton("Eliminar un mensaje");
		butEliminarUnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarMensaje();
				
			}
		});
		GroupLayout gl_panelCrearMensaje = new GroupLayout(panelCrearMensaje);
		gl_panelCrearMensaje.setHorizontalGroup(
			gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearMensaje.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
						.addComponent(butEliminarUnMensaje, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(butAgregarUnMensaje, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCrearMensaje.setVerticalGroup(
			gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCrearMensaje.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addComponent(butAgregarUnMensaje)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butEliminarUnMensaje)
					.addContainerGap())
		);
		panelCrearMensaje.setLayout(gl_panelCrearMensaje);
		
		JLabel labFecha = new JLabel("Fecha:");
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		
		txtAnho = new JTextField();
		txtAnho.setColumns(10);
		
		JLabel labColorRecomendado = new JLabel("Color Recomendado:");
		
		txtColorRecomendado = new JTextField();
		txtColorRecomendado.setColumns(10);
		
		butAgregarDia = new JButton("Agregar Dia");
		butAgregarDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearDia();
			}
		});
		
		JLabel labDia = new JLabel("Dia");
		
		JLabel labMes = new JLabel("Mes");
		
		JLabel labAnho = new JLabel("A\u00F1o");
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		GroupLayout gl_panelCrearDia = new GroupLayout(panelCrearDia);
		gl_panelCrearDia.setHorizontalGroup(
			gl_panelCrearDia.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCrearDia.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCrearDia.createSequentialGroup()
							.addComponent(labColorRecomendado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtColorRecomendado, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
						.addGroup(gl_panelCrearDia.createSequentialGroup()
							.addComponent(labFecha)
							.addGap(37)
							.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAnho, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCrearDia.createSequentialGroup()
									.addGap(10)
									.addComponent(labAnho)))
							.addGap(15)
							.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCrearDia.createSequentialGroup()
									.addComponent(labMes)
									.addGap(29)
									.addComponent(labDia)
									.addGap(8))
								.addGroup(gl_panelCrearDia.createSequentialGroup()
									.addComponent(txtMes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtDia, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addComponent(butAgregarDia, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCrearDia.setVerticalGroup(
			gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearDia.createSequentialGroup()
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.BASELINE)
						.addComponent(labFecha)
						.addComponent(txtAnho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.BASELINE)
						.addComponent(labDia)
						.addComponent(labMes)
						.addComponent(labAnho))
					.addGap(12)
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
						.addComponent(labColorRecomendado)
						.addComponent(txtColorRecomendado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(butAgregarDia)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panelCrearDia.setLayout(gl_panelCrearDia);
		panelMensajesMotivaciones.setLayout(gl_panelMensajesMotivaciones);
		
		ImageIcon imag = new ImageIcon("./data/ima.jpg");
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
	
	public void refrescarDiaActual(){
		txtDiaActual.setText(diaActual.darFecha());
		txtColorRecomendadoActual.setText(diaActual.darColorRecomendado());
	}
	
	public void refrescarMensajeActual(){
		txtMensajeMotivacionActual.setText(mensajeActual.darMsjMotivacion());
		txtAutorActual.setText(mensajeActual.darAutorMsj());
	}
	
	public void refrescarPanelMensajesMotivaciones(Dia dia){
		
		diaActual = dia;
		
		if(diaActual!=null){
			
			refrescarDiaActual();
			mensajeActual = diaActual.darPrimerMensaje();
			
			if(mensajeActual==null){
				txtMensajeMotivacionActual.setText("No hay mensajes");
				txtAutorActual.setText("");
			}else{
				refrescarMensajeActual();
			}
		
		}
		
	}
	
	public void refrescarComboBoxDia(){
		
        comboBoxDia.removeAllItems();
        
		ArrayList<Dia> list = (ArrayList<Dia>) mundo.darListaDias();
		for (int i = 0; i < list.size(); i++) {
			comboBoxDia.addItem((Dia)list.get(i));
		}
	}
	
	public void crearDia(){
		 
		//Comprobacion de que no sea entradas vacias
		if(txtDia.getText().equals("") || txtMes.getText().equals("") || txtAnho.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese una fecha");
		}else if(txtColorRecomendado.getText().equals("")){ 
			JOptionPane.showMessageDialog(null, "Ingrese un color");
		}else{
			
		//Construccion de la fecha del dia agregar
		int dia = Integer.parseInt(txtDia.getText());
		int mes = Integer.parseInt(txtMes.getText());
		int anho = Integer.parseInt(txtAnho.getText());
		
		String fechaIntroducida = anho+"/"+mes+"/"+dia;
		
		//Comprobacion de formato de la fecha
		if(anho<1000 || anho>9999 ){
			JOptionPane.showMessageDialog(null, "Introduzca un año valido");
		}else if(mes<0 || mes>12){
			JOptionPane.showMessageDialog(null, "Introduzca un mes valido");
		}else if(dia<0 || dia>31){
			JOptionPane.showMessageDialog(null, "Introduzca un dia valido");
		}else{
			
			//Agregado del dia 
			
			String color = txtColorRecomendado.getText();
			color.trim();
			color.toUpperCase();
			
			try {
				mundo.agregarDia(fechaIntroducida, color);
				JOptionPane.showMessageDialog(null, "El dia fue agregado exitosamente");
			} catch (DiaException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			} 
		 }
		
		}
		
		// Guargadado del programa
		
		refrescarComboBoxDia();
		serializar();
	}
	
	public void crearMensaje(){
		
		//El panel se encarga
		DialogoCrearMensaje dialogo = new DialogoCrearMensaje(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
		
	}
	
	public void eliminarMensaje(){
		
		//El panel se encarga
		DialogoEliminarMensaje dialogo = new DialogoEliminarMensaje(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);

	}
	
	public void deserializar(){
		File archivo = new File(rutaPersistencia);
		
		if(archivo.exists()){
				ObjectInputStream ois;
				
				try {
					ois = new ObjectInputStream(new FileInputStream(archivo));
					mundo = (EnergiaParaLaVida)ois.readObject();
					ois.close();
				} catch (Exception e) {
				 JOptionPane.showMessageDialog(this, e.getMessage());
				}
				
			
		}else{
			mundo = new EnergiaParaLaVida();
		}
	}
	
	public void serializar(){
		
		File archivo = new File(rutaPersistencia);
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(mundo);
			oos.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void mensajeAnterior(){
		
		if(mensajeActual!=null && mensajeActual.darAnterior()!=null){
			mensajeActual = mensajeActual.darAnterior();
			refrescarMensajeActual();
		}else{
			JOptionPane.showMessageDialog(this, "No hay mas mensajes");

		}
		
	}
	
	public void mensajeSiguiente(){
		
		if(mensajeActual!=null && mensajeActual.darSiguiente()!=null){
			mensajeActual = mensajeActual.darSiguiente();
			refrescarMensajeActual();
		}else{
			JOptionPane.showMessageDialog(this, "No hay mas mensajes");

		}
		
	}
}
