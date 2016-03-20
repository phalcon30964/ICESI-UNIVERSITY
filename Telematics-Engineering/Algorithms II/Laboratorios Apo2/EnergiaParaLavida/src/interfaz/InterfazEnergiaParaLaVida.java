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
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import mundo.*;

public class InterfazEnergiaParaLaVida {
	
	private Mensaje mensajeActual;
	private Dia diaActual;
	private EnergiaParaLaVida mundo;
	

	private JFrame frame;
	private JLabel labBanner;
	private JPanel panelBanner;
	private JPanel panelCrearDia;
	private JPanel panelCrearMensaje;
	private JPanel panelEliminarMensaje;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnho;
	private JTextField txtDiaRecomendado;
	private JButton butAgregarMensajeMotivador;
	private JLabel labMensaje;
	private JTextField txtMensajeMotivador;
	private JLabel labParaElDia;
	private JComboBox cmbDia;
	private JButton btnEliminarMensaje;
	private JButton butAgregarDia;
	private JLabel labFecha;
	private JLabel labDia;
	private JLabel labMes;
	private JLabel labAnho;
	private JLabel labColorRecomendado;
	private JLabel labDiaActual;
	private JLabel labColorRecomendadorActual;
	private JTextField txtColorRecomendadoActual;
	private JLabel labMensajeDeMotivacion;
	private JTextField txtMensajeMotivacionActual;
	private JButton btnMensajeAnterior;
	private JButton btnMensajeSiguiente;
	private JTextField txtDiaActual;
	private JLabel labAutor;
	private JTextField txtAutorActual;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 640, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelBanner = new JPanel();
		labBanner = new JLabel(new ImageIcon("D:\\Dropbox\\Mini 2\\Code\\Mini 2\\EnergiaParaLaVida\\data\\ima.jpg"));
		
		JPanel panelMensajesMotivaciones = new JPanel();
		panelMensajesMotivaciones.setBorder(new TitledBorder(null, "Mensajes y Motivaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelVisualizacion = new JPanel();
		panelVisualizacion.setBorder(new TitledBorder(null, "Visualizacion de Motivaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(labBanner, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panelBanner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelMensajesMotivaciones, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelVisualizacion, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(labBanner, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelBanner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMensajesMotivaciones, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
						.addComponent(panelVisualizacion, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		labDiaActual = new JLabel("Dia Actual:");
		
		txtDiaActual = new JTextField();
		txtDiaActual.setEditable(false);
		txtDiaActual.setColumns(10);
		
		labColorRecomendadorActual = new JLabel("Color Recomendador Actual:");
		
		txtColorRecomendadoActual = new JTextField();
		txtColorRecomendadoActual.setEditable(false);
		txtColorRecomendadoActual.setColumns(10);
		
		labMensajeDeMotivacion = new JLabel("Mensaje De Motivacion ");
		
		txtMensajeMotivacionActual = new JTextField();
		txtMensajeMotivacionActual.setEditable(false);
		txtMensajeMotivacionActual.setColumns(10);
		
		txtAutorActual = new JTextField();
		txtAutorActual.setEditable(false);
		txtAutorActual.setColumns(10);
		
		labAutor = new JLabel("Autor");
		
		btnMensajeAnterior = new JButton("Mensaje Anterior");
		
		btnMensajeSiguiente = new JButton("Mensaje Siguiente");
		GroupLayout gl_panelVisualizacion = new GroupLayout(panelVisualizacion);
		gl_panelVisualizacion.setHorizontalGroup(
			gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVisualizacion.createSequentialGroup()
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVisualizacion.createSequentialGroup()
									.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
										.addComponent(labDiaActual)
										.addComponent(labColorRecomendadorActual))
									.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
									.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
										.addComponent(txtColorRecomendadoActual, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDiaActual, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelVisualizacion.createSequentialGroup()
									.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
										.addComponent(labMensajeDeMotivacion)
										.addComponent(labAutor))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAutorActual, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
										.addComponent(txtMensajeMotivacionActual, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
						.addGroup(gl_panelVisualizacion.createSequentialGroup()
							.addGap(19)
							.addComponent(btnMensajeAnterior, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMensajeSiguiente, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelVisualizacion.setVerticalGroup(
			gl_panelVisualizacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVisualizacion.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(labDiaActual)
						.addComponent(txtDiaActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtColorRecomendadoActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labColorRecomendadorActual))
					.addGap(33)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMensajeMotivacionActual, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(labMensajeDeMotivacion))
					.addGap(18)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAutorActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labAutor))
					.addGap(45)
					.addGroup(gl_panelVisualizacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMensajeAnterior, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMensajeSiguiente, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		panelVisualizacion.setLayout(gl_panelVisualizacion);
		
		panelCrearDia = new JPanel();
		panelCrearDia.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear dia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panelCrearMensaje = new JPanel();
		panelCrearMensaje.setBorder(new TitledBorder(null, "Crear Mensaje Motivador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panelEliminarMensaje = new JPanel();
		panelEliminarMensaje.setBorder(new TitledBorder(null, "Eliminar Mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelMensajesMotivaciones = new GroupLayout(panelMensajesMotivaciones);
		gl_panelMensajesMotivaciones.setHorizontalGroup(
			gl_panelMensajesMotivaciones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMensajesMotivaciones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMensajesMotivaciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCrearDia, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 259, Short.MAX_VALUE)
						.addGroup(gl_panelMensajesMotivaciones.createParallelGroup(Alignment.LEADING)
							.addComponent(panelEliminarMensaje, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addComponent(panelCrearMensaje, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelMensajesMotivaciones.setVerticalGroup(
			gl_panelMensajesMotivaciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMensajesMotivaciones.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCrearDia, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCrearMensaje, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEliminarMensaje, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelEliminarMensaje.setLayout(new BorderLayout(0, 0));
		
		btnEliminarMensaje = new JButton("Eliminar Mensaje");
		panelEliminarMensaje.add(btnEliminarMensaje, BorderLayout.CENTER);
		
		txtMensajeMotivador = new JTextField();
		txtMensajeMotivador.setColumns(10);
		
		labMensaje = new JLabel("Mensaje:");
		
		labParaElDia = new JLabel("Para el dia:");
		
		cmbDia = new JComboBox();
		
		butAgregarMensajeMotivador = new JButton("Agregar Mensaje Motivador");
		GroupLayout gl_panelCrearMensaje = new GroupLayout(panelCrearMensaje);
		gl_panelCrearMensaje.setHorizontalGroup(
			gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearMensaje.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
						.addComponent(butAgregarMensajeMotivador, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addGroup(gl_panelCrearMensaje.createSequentialGroup()
							.addComponent(labMensaje)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtMensajeMotivador, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(gl_panelCrearMensaje.createSequentialGroup()
							.addComponent(labParaElDia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbDia, 0, 169, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelCrearMensaje.setVerticalGroup(
			gl_panelCrearMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearMensaje.createSequentialGroup()
					.addGroup(gl_panelCrearMensaje.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMensajeMotivador, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(labMensaje))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearMensaje.createParallelGroup(Alignment.BASELINE)
						.addComponent(labParaElDia)
						.addComponent(cmbDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butAgregarMensajeMotivador)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelCrearMensaje.setLayout(gl_panelCrearMensaje);
		
		labFecha = new JLabel("Fecha:");
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		
		txtAnho = new JTextField();
		txtAnho.setColumns(10);
		
		labDia = new JLabel("Dia");
		
		labMes = new JLabel("Mes");
		
		labAnho = new JLabel("A\u00F1o");
		
		labColorRecomendado = new JLabel("Color Recomendado:");
		
		txtDiaRecomendado = new JTextField();
		txtDiaRecomendado.setColumns(10);
		
		butAgregarDia = new JButton("Agregar Dia");
		GroupLayout gl_panelCrearDia = new GroupLayout(panelCrearDia);
		gl_panelCrearDia.setHorizontalGroup(
			gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearDia.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
						.addComponent(butAgregarDia, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addGroup(gl_panelCrearDia.createSequentialGroup()
							.addComponent(labFecha)
							.addGap(52)
							.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDia, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(labDia))
							.addGap(18)
							.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(labMes))
							.addGap(18)
							.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
								.addComponent(labAnho)
								.addComponent(txtAnho, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCrearDia.createSequentialGroup()
							.addComponent(labColorRecomendado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDiaRecomendado, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelCrearDia.setVerticalGroup(
			gl_panelCrearDia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearDia.createSequentialGroup()
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAnho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labFecha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.BASELINE)
						.addComponent(labAnho)
						.addComponent(labMes)
						.addComponent(labDia))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearDia.createParallelGroup(Alignment.BASELINE)
						.addComponent(labColorRecomendado)
						.addComponent(txtDiaRecomendado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butAgregarDia)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelCrearDia.setLayout(gl_panelCrearDia);
		panelMensajesMotivaciones.setLayout(gl_panelMensajesMotivaciones);
		
		ImageIcon imag = new ImageIcon("./data/ima.jpg");
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
	
	public void crearDia(String fecha, String color){
		
	}
	
	public void crearMensaje(String fecha, String motivacion, String autor){
		
	}
	
	public void eliminarMensaje(String fecha, Mensaje mensaje){
		
	}
	
	public void mensajeSiguiente(){
		
	}
	
	public void mensajeAnterior(){
		
	}
	
	public void refrescarDiaActual(Dia dia){
		
	}
	
	public void refrescarMensajeActual(Mensaje msj){
		
	}
	
}
