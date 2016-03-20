package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelListaEgresados extends JPanel implements ActionListener{
	private InterfazEgresados principal;
	private JTextArea areaEgresados;
	private JButton butCargar;
	private JButton butAsignar;
	private JLabel labNombreArchivo;
	
	public final static String CARGAR_DE_ARCHIVO = "CARGAR";
	public final static String ASIGNAR_PUESTOS   = "ASIGNAR";
	
	public PanelListaEgresados(InterfazEgresados ventana){
		principal = ventana;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Listado de Egresados"));
		
		areaEgresados = new JTextArea();
		areaEgresados.setEditable(false);
		
		butCargar = new JButton("Cargar Datos desde Archivo");
		butCargar.setActionCommand(CARGAR_DE_ARCHIVO);
		butCargar.addActionListener(this);
		
		butAsignar = new JButton("Asignar Puestos");
		butAsignar.setActionCommand(ASIGNAR_PUESTOS);
		butAsignar.addActionListener(this);
		
		labNombreArchivo = new JLabel("Archivo: No se ha seleccionado ninguno para cargar!");
		labNombreArchivo.setToolTipText("No se ha seleccionado ningún archivo para cargar datos.");
		
		JPanel panelBotones = new JPanel();//un panel interno para los botones
		panelBotones.setLayout(new GridLayout(1,2));
		panelBotones.add(butCargar);
		panelBotones.add(butAsignar);
		
		add(panelBotones, BorderLayout.NORTH);
		add(new JScrollPane(areaEgresados), BorderLayout.CENTER);
		add(labNombreArchivo,BorderLayout.SOUTH);

		setPreferredSize(new Dimension(450,0));
	}
	
	public void cambiarEstadoNombreArchivo(String nombreArchivo){
		labNombreArchivo.setText("Archivo: "+nombreArchivo);
		labNombreArchivo.setToolTipText(nombreArchivo);
	}
	
	public void cambiarTextoArea(String listaEgresados){
		areaEgresados.setText(listaEgresados);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(CARGAR_DE_ARCHIVO)){
			principal.cargarListaDesdeArchivo();
		}else if(comando.equals(ASIGNAR_PUESTOS)){
			principal.asignarPuestosEnAuditorio();
		}
	}
}
