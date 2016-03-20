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
public class PanelTarjetasInvitacion extends JPanel implements ActionListener{
	private InterfazEgresados principal;
	private JTextArea areaTarjetas;
	private JButton butGenerar;
	private JButton butGuardar;
	private JLabel labNombreArchivo;
	
	public final static String GENERAR_TARJETAS  = "GENERAR_TARJETAS";
	public final static String GUARDAR_A_ARCHIVO = "GUARDAR_A_ARCHIVO";
	
	public PanelTarjetasInvitacion(InterfazEgresados ventana){
		principal = ventana;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Tarjetas de Invitación"));
		
		areaTarjetas = new JTextArea();
		areaTarjetas.setEditable(false);
		
		butGenerar = new JButton("Generar Tarjetas");
		butGenerar.setActionCommand(GENERAR_TARJETAS);
		butGenerar.addActionListener(this);
		
		butGuardar = new JButton("Guardar Tarjetas a Archivo");
		butGuardar.setActionCommand(GUARDAR_A_ARCHIVO);
		butGuardar.addActionListener(this);
		
		labNombreArchivo = new JLabel("Archivo: No se ha seleccionado ninguno para guardar!");
		labNombreArchivo.setToolTipText("No se ha seleccionado ningún archivo para guardar datos.");
		
		JPanel panelBotones = new JPanel();//un panel interno para los botones
		panelBotones.setLayout(new GridLayout(1,2));
		panelBotones.add(butGenerar);
		panelBotones.add(butGuardar);
		
		add(panelBotones, BorderLayout.NORTH);
		add(new JScrollPane(areaTarjetas), BorderLayout.CENTER);
		add(labNombreArchivo,BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(450,0));
	}
	
	public void cambiarEstadoNombreArchivo(String nombreArchivo){
		labNombreArchivo.setText("Archivo: "+nombreArchivo);
		labNombreArchivo.setToolTipText(nombreArchivo);
	}

	public void cambiarTextoArea(String listaTarjetas){
		areaTarjetas.setText(listaTarjetas);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(GENERAR_TARJETAS)){
			principal.generarTarjetasInvitacion();
		}else if(comando.equals(GUARDAR_A_ARCHIVO)){
			principal.guardarTarjetasInvitacion();
		}
	}	
}
