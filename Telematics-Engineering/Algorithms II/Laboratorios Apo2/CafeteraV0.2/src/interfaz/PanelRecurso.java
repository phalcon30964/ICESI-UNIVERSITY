package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mundo.Recurso;

@SuppressWarnings("serial")
public class PanelRecurso extends JPanel implements ActionListener{
	
	private JLabel labImagenRecurso;
	//private JLabel labNombreRecurso;
	private JLabel labMaximoRecurso;
	private JLabel labCantidadActual;

	//private JTextField txtNombreRecurso;
	private JTextField txtMaximoRecurso;
	private JTextField txtCantidadActual;
	private JTextField txtCantidadAbastecer;
	
	private JButton butAbastecer;
	
	private InterfazCafetera principal;
	private Recurso recurso;
	
	public final static String ABASTECER_RECURSO="ABASTECER_RECURSO";
	
	public PanelRecurso(InterfazCafetera ventana, Recurso elRecurso){
		principal = ventana;
		recurso   = elRecurso;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(recurso.darNombre()));
		
		labImagenRecurso  = new JLabel(new ImageIcon("data/img/"+recurso.darNombre()+".jpg"));
		//labNombreRecurso  = new JLabel("Recurso:");
		labMaximoRecurso  = new JLabel("Máximo:");
		labCantidadActual = new JLabel("Cantidad Actual:");

		DecimalFormat formateador = new DecimalFormat("#.##");

		//txtNombreRecurso     = new JTextField(recurso.darNombre());
		txtMaximoRecurso     = new JTextField(formateador.format(recurso.darCantidadMaxima())+" "+recurso.darUnidad());
		txtCantidadActual    = new JTextField(formateador.format(recurso.darCantidadActual())+" "+recurso.darUnidad());
		txtCantidadAbastecer = new JTextField(4);
		
		//txtNombreRecurso.setEditable(false);
		txtMaximoRecurso.setEditable(false);
		txtCantidadActual.setEditable(false);

		//txtNombreRecurso.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaximoRecurso.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCantidadActual.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCantidadAbastecer.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtCantidadAbastecer.setFont(new Font( Font.SANS_SERIF ,Font.PLAIN,16 ));
		
		butAbastecer = new JButton("+");
		butAbastecer.setActionCommand(ABASTECER_RECURSO);
		butAbastecer.addActionListener(this);
		butAbastecer.setFont(new Font( Font.SANS_SERIF ,Font.BOLD,14 ));
		
		add(labImagenRecurso,BorderLayout.NORTH);
		
		JPanel panDatos = new JPanel();
		panDatos.setLayout(new GridLayout(0,1));
		
		//panDatos.add(labNombreRecurso);
		//panDatos.add(txtNombreRecurso);
		panDatos.add(labMaximoRecurso);
		panDatos.add(txtMaximoRecurso);
		panDatos.add(labCantidadActual);
		panDatos.add(txtCantidadActual);
		
		add(panDatos,BorderLayout.CENTER);

		JPanel panForma = new JPanel();
		panForma.setLayout(new FlowLayout());
		panForma.add(txtCantidadAbastecer);
		panForma.add(butAbastecer);

		add(panForma,BorderLayout.SOUTH);
	}
	
	public String darCantidadAbastecer(){
		return txtCantidadAbastecer.getText();
	}
	
	public void limpiarCantidadAbastecer(){
		txtCantidadAbastecer.setText("");
	}
	
	public void actualizarRecurso(){
		DecimalFormat formateador = new DecimalFormat("#.##");
		txtCantidadActual.setText(formateador.format(recurso.darCantidadActual())+" "+recurso.darUnidad());
	}
	
	public void actionPerformed(ActionEvent evento){
		String comando = evento.getActionCommand();
		if(comando.equals(ABASTECER_RECURSO)){
			principal.abastecerRecurso(recurso.darIdentificador());
		}
	}
}
