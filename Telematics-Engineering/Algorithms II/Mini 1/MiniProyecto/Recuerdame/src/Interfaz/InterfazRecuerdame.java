package Interfaz;

import java.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JScrollBar;

import Mundo.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class InterfazRecuerdame extends JFrame {
	
	private String clasificacion;
	
	private Recuerdame mundo;
	private JPanel InterfazRecuerdame;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAnio;
	private JTextField textDescripcionClasificacion;
	private JTextField textNombreClasificacion;
	private JTextField textDescripcionCompleta;
	private JTextField textNombreTarea;
	private JList listTareasPendientes;
	private JButton butAnadirTarea;
	private JButton butAnadirClasificacion;
	private JButton butEliminarTarea;
	private JButton butPorFecha;
	private JButton butPorClasificacion;
	private JButton butExportar;
	private JComboBox comClasificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRecuerdame frame = new InterfazRecuerdame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazRecuerdame() {
		
		mundo = new Recuerdame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 460);
		InterfazRecuerdame = new JPanel();
		InterfazRecuerdame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InterfazRecuerdame);
		InterfazRecuerdame.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel PanelAnadir = new JPanel();
		PanelAnadir.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Anadir ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InterfazRecuerdame.add(PanelAnadir);
		
		JLabel labClasificacion = new JLabel("Clasificaci\u00F3n:");
		
		comClasificacion = new JComboBox();
		
		refrescarComClasificacion();
		
		JLabel labNombre = new JLabel("Nombre:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel labDescripcion = new JLabel("Descripci\u00F3n:");
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		
		JLabel labRecordatorio = new JLabel("Recordatorio");
		
		JLabel labDia = new JLabel("D\u00EDa");
		
		JLabel labMes = new JLabel("Mes");
		
		JLabel labAnio = new JLabel("A\u00F1o");
		
		textDia = new JTextField();
		textDia.setColumns(10);
		
		textMes = new JTextField();
		textMes.setColumns(10);
		
		textAnio = new JTextField();
		textAnio.setColumns(10);
		
		butAnadirClasificacion = new JButton("Anadir Clasificaci\u00F3n");
		butAnadirClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				anadirClasificacion();
				
			}
		});
		
		butAnadirTarea = new JButton("Anadir Tarea");
		butAnadirTarea.setActionCommand("ANADIR_TAREA");
		butAnadirTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				anadirTarea();
				
			}
		}
			);
		
		JLabel labNombreClasificacion = new JLabel("Nombre Casificaci\u00F3n");
		
		JLabel labDescripcionClasificacion = new JLabel("Descripci\u00F3n Clasifi.");
		
		textDescripcionClasificacion = new JTextField();
		textDescripcionClasificacion.setColumns(10);
		
		textNombreClasificacion = new JTextField();
		textNombreClasificacion.setColumns(10);
		GroupLayout gl_PanelAnadir = new GroupLayout(PanelAnadir);
		gl_PanelAnadir.setHorizontalGroup(
			gl_PanelAnadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelAnadir.createSequentialGroup()
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_PanelAnadir.createSequentialGroup()
							.addGap(10)
							.addComponent(butAnadirClasificacion, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
						.addGroup(gl_PanelAnadir.createSequentialGroup()
							.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
								.addComponent(labNombreClasificacion)
								.addComponent(labDescripcionClasificacion))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
								.addComponent(textDescripcionClasificacion, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombreClasificacion, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
						.addGroup(gl_PanelAnadir.createSequentialGroup()
							.addComponent(labRecordatorio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_PanelAnadir.createSequentialGroup()
									.addComponent(labDia)
									.addGap(18)
									.addComponent(labMes)
									.addGap(18)
									.addComponent(labAnio))
								.addGroup(gl_PanelAnadir.createSequentialGroup()
									.addComponent(textDia, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textMes, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAnio, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
						.addGroup(Alignment.LEADING, gl_PanelAnadir.createSequentialGroup()
							.addContainerGap()
							.addComponent(butAnadirTarea, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_PanelAnadir.createSequentialGroup()
							.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
								.addComponent(labClasificacion)
								.addComponent(labDescripcion)
								.addComponent(labNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
								.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(textDescripcion, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(comClasificacion, 0, 154, Short.MAX_VALUE))))
					.addGap(48))
		);
		gl_PanelAnadir.setVerticalGroup(
			gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelAnadir.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(labNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
						.addComponent(labDescripcion)
						.addComponent(textDescripcion, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.LEADING)
						.addComponent(labClasificacion)
						.addComponent(comClasificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(labRecordatorio)
						.addComponent(textDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(labDia)
						.addComponent(labMes)
						.addComponent(labAnio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(butAnadirTarea)
					.addGap(27)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(labNombreClasificacion)
						.addComponent(textNombreClasificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_PanelAnadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDescripcionClasificacion, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(labDescripcionClasificacion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butAnadirClasificacion)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		PanelAnadir.setLayout(gl_PanelAnadir);
		
		JPanel PanelPendientes = new JPanel();
		PanelPendientes.setBorder(new TitledBorder(null, "Tareas Pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InterfazRecuerdame.add(PanelPendientes);
		
		listTareasPendientes = new JList();
		listTareasPendientes.setValueIsAdjusting(true);
		listTareasPendientes.setSelectedIndex(0);
		listTareasPendientes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if(listTareasPendientes.getSelectedValue()!=null){
				
				Tarea tar = (Tarea)listTareasPendientes.getSelectedValue();
				
				textNombreTarea.setText(tar.darNombre());
				textDescripcionCompleta.setText(tar.darDescripcion());
				
				}
				
			}
		});
		refrescarTareasPendientes(mundo.darTodasLasTareas());
		
		
		JScrollBar scrollBarTareasPendientes = new JScrollBar();
		scrollBarTareasPendientes.setBlockIncrement(1);
		GroupLayout gl_PanelPendientes = new GroupLayout(PanelPendientes);
		gl_PanelPendientes.setHorizontalGroup(
			gl_PanelPendientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelPendientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(listTareasPendientes, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollBarTareasPendientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_PanelPendientes.setVerticalGroup(
			gl_PanelPendientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelPendientes.createSequentialGroup()
					.addGroup(gl_PanelPendientes.createParallelGroup(Alignment.TRAILING)
						.addComponent(listTareasPendientes, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
						.addComponent(scrollBarTareasPendientes, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
					.addContainerGap())
		);
		PanelPendientes.setLayout(gl_PanelPendientes);
		
		JPanel PanelDetalles = new JPanel();
		PanelDetalles.setBorder(new TitledBorder("Detalles Tarea"));
		InterfazRecuerdame.add(PanelDetalles);
		
		butPorFecha = new JButton("Ordenar por fecha de creaci\u00F3n");
		butPorFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i = 0; i < mundo.darTareasOrdenadasPorFechaConInsercion().size() ; i++) {
					
					System.out.println(mundo.darTareasOrdenadasPorFechaConInsercion().get(i));
					
				}
				System.out.println();
				refrescarTareasPendientes(mundo.darTareasOrdenadasPorFechaConInsercion());
				
			}
		});
		
		butPorClasificacion = new JButton("Ordenar por clasificaci\u00F3n");
		butPorClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				for (int i = 0; i < mundo.darTodasLasTareas().size() ; i++) {
					System.out.println(mundo.darTodasLasTareas().get(i));
				}
				
				refrescarTareasPendientes(mundo.darTodasLasTareas());
				
			}
		});
		
		butExportar = new JButton("Exportar tareas no realizadas");
		butExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				mundo.exportarTareasPendientes();
				
				
				
			}
		});
		
		textDescripcionCompleta = new JTextField();
		textDescripcionCompleta.setEditable(false);
		textDescripcionCompleta.setColumns(10);
		
//		chckbxTareaRealizada.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				
//				Tarea tare = (Tarea)listTareasPendientes.getSelectedValue();
//				
//				if(tare!=null){
//				
//				mundo.realizarTarea(tare.darClasificacion(),tare.darNombre());
//				refrescarTareasPendientes(mundo.darTareasOrdenadasPorFechaConInsercion());
//				}
//			}
//		});
		
		textNombreTarea = new JTextField();
		textNombreTarea.setEditable(false);
		textNombreTarea.setColumns(10);
		
		JLabel labNombreTarea = new JLabel("Nombre tarea");
		
		JLabel labDescripcionCompleta = new JLabel("Descripcion completa");
		
		butEliminarTarea = new JButton("Eliminar tarea");
		butEliminarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				eliminarTarea();
				
			}
		});
		
		JButton btnRealizar = new JButton("Realizar/Desrealizar ");
		btnRealizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				realizarTarea();
			}
		});
		GroupLayout gl_PanelDetalles = new GroupLayout(PanelDetalles);
		gl_PanelDetalles.setHorizontalGroup(
			gl_PanelDetalles.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelDetalles.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PanelDetalles.createParallelGroup(Alignment.LEADING)
						.addComponent(textNombreTarea, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(butExportar, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(labNombreTarea)
						.addComponent(butPorClasificacion, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(butPorFecha, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(butEliminarTarea, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(labDescripcionCompleta)
						.addComponent(textDescripcionCompleta, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(btnRealizar, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_PanelDetalles.setVerticalGroup(
			gl_PanelDetalles.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelDetalles.createSequentialGroup()
					.addContainerGap()
					.addComponent(labNombreTarea)
					.addGap(12)
					.addComponent(textNombreTarea, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labDescripcionCompleta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textDescripcionCompleta, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnRealizar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(butEliminarTarea)
					.addGap(10)
					.addComponent(butPorFecha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butPorClasificacion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butExportar)
					.addGap(30))
		);
		PanelDetalles.setLayout(gl_PanelDetalles);
		
		
		
	}
	
	public void refrescarComClasificacion(){
		
		comClasificacion.removeAllItems();
		
		ArrayList<Clasificacion> list = mundo.darClasificaciones();
		
		for (int i = 0; i < list.size(); i++) {
			
			comClasificacion.addItem((Clasificacion)list.get(i));
			
		}
	
	}
	
	public void refrescarTareasPendientes(ArrayList listAux){
		
		DefaultListModel listModel = new DefaultListModel();
		//Recorrer el contenido del ArrayList
		for(int i=0; i<listAux.size(); i++) {
		//Añadir cada elemento del ArrayList en el modelo de la lista
		listModel.add(i, listAux.get(i));
		}
		//Asociar el modelo de lista al JList
		listTareasPendientes.setModel(listModel);
		
	}
	
	public void anadirTarea(){
		
		String nombre = textNombre.getText();
		String descripcion = textDescripcion.getText();
		String fecha = textAnio.getText()+textMes.getText()+textDia.getText();
		
		Clasificacion clas = (Clasificacion)comClasificacion.getSelectedItem();
		clasificacion = clas.darNombre();
		
		
		
		if(nombre.equals("")){
			JOptionPane.showMessageDialog(null, "Tienes que especificar un nombre para tu tarea");
		}else if(!nombre.equals("")){
		
			if(textDia.getText().equals("") ||Integer.parseInt(textDia.getText())<0 || Integer.parseInt(textDia.getText())>31){
			JOptionPane.showMessageDialog(null, "Ingrese un dia valido, Si no desea un recordatorio por favor ingrese 00 en dia 00 en mes y 0000 en año");
			}else if(textMes.getText().equals("") || Integer.parseInt(textMes.getText())<0 || Integer.parseInt(textMes.getText())>12){
			JOptionPane.showMessageDialog(null, "Ingrese un mes valido, Si no desea un recordatorio por favor ingrese 00 en dia 00 en mes y 0000 en año");
			}else if(textAnio.getText().equals("") ||Integer.parseInt(textAnio.getText())<0 ||Integer.parseInt(textAnio.getText())>9999 ){
				JOptionPane.showMessageDialog(null, "Ha ingresado un año invalido, Si no desea un recordatorio por favor ingrese 00 en dia 00 en mes y 0000 en año");
			}else{
				boolean respuesta = mundo.anadirTarea(nombre , descripcion , fecha, clasificacion);
				if(respuesta==false){
					JOptionPane.showMessageDialog(null, "La tarea: "+nombre+" ya existe");
					}else{
					JOptionPane.showMessageDialog(null, "La tarea se agrego con exito");
					
					Calendar fechas = Calendar.getInstance();
					int anho = fechas.get(Calendar.YEAR);
					int mes = fechas.get(Calendar.MONTH)+1;
					int dia = fechas.get(Calendar.DATE);
					
					if(Integer.parseInt(textDia.getText())==dia && Integer.parseInt(textMes.getText())==mes && Integer.parseInt(textAnio.getText())==anho){
						JOptionPane.showMessageDialog(null, "Hoy debes realizar tu tarea: "+nombre);

					}
				}
			}
		}
		
		refrescarTareasPendientes(mundo.darTareasOrdenadasPorFechaConInsercion());
	}
	
	public void anadirClasificacion(){
		//Extraigo los valores de los campos de nombre y de descripcion
		String nombreClas = textNombreClasificacion.getText();
		String descripcionClas = textDescripcionClasificacion.getText();
		
		//Comprueba que el nombre sea diferente de vacio
		if(!nombreClas.equals("")){
			//crea la clasificacion
			boolean respuesta = mundo.crearClasificacion(nombreClas, descripcionClas);
			
			//retorna mensaje
			if(respuesta==false){
				JOptionPane.showMessageDialog(null, "La clasificacion ya existe");
			}else{
				
				JOptionPane.showMessageDialog(null, "La clasificacion fue agregada existosamente");
				refrescarComClasificacion();
			}
			
		}else{
			
			JOptionPane.showMessageDialog(null, "El nombre de la clasificacion no puede estar vacio");
		}
		
	}
	
	public void realizarTarea(){
		Tarea tare = (Tarea)listTareasPendientes.getSelectedValue();
		
		if(tare!=null){
		
		mundo.realizarTarea(tare.darClasificacion(),tare.darNombre());
		refrescarTareasPendientes(mundo.darTareasOrdenadasPorFechaConInsercion());
		
		JOptionPane.showMessageDialog(null, "Un tarea menos por hacer!, sigue así!!\nSi deseas en el futuro " +
				"volver a marcar esta tarea como no realizada, debes volverla a seleccionar en la lista");
		
		}
	}
	
	public void eliminarTarea(){
		Tarea tare = (Tarea)listTareasPendientes.getSelectedValue();
		
		if(tare!=null){
		
		boolean respuesta = mundo.eliminarTarea(tare.darClasificacion(), tare);
		
			if(respuesta==false){
				JOptionPane.showMessageDialog(null, "La tarea no se pudo eliminar");
			}else{
				JOptionPane.showMessageDialog(null, "La tarea se eliminó con exito");
			}
		
		refrescarTareasPendientes(mundo.darTareasOrdenadasPorFechaConInsercion());
		}
	}
}
