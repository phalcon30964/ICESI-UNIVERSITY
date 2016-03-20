package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import mundo.Sitio;
import mundo.Zona;

@SuppressWarnings("serial")
public class PanelSitio extends JPanel implements ActionListener{
	
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	
	private final static String EDITAR="EDITAR";
	private final static String GUARDAR="GUARDAR";
	private final static String ELIMINAR="ELIMINAR";
	
	private JTextField txtNombre;
	private JTextField txtAnho;
	private JTextField txtDireccion;
	
	private Sitio sitio;
	private Zona zona;
	private InterfazTurismo principal;
	
	private static int comercial  = 1;
	private static int cultural   = 1;
	private static int escenarios = 1;
	private static int interes    = 1;
	
	public PanelSitio(InterfazTurismo ventana, Sitio s, Zona z){
		principal = ventana;
		sitio = s;
		zona  = z;
		setLayout(new BorderLayout());
		
		txtNombre    = new JTextField(sitio.darNombre());
		txtAnho      = new JTextField("Construido en "+sitio.darAnhoConstruccion());
		txtDireccion = new JTextField(sitio.darDireccion());
		
		txtNombre.setEditable(false);
		txtAnho.setEditable(false);
		txtDireccion.setEditable(false);
		
		btnEditar  = new JButton(new ImageIcon("data/img/edit.png"));
		btnGuardar = new JButton(new ImageIcon("data/img/save.png"));
		btnEliminar = new JButton(new ImageIcon("data/img/delete.png"));
		btnEditar.setMargin(new Insets(0, 0, 0, 0));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		btnEliminar.setMargin(new Insets(0, 0, 0, 0));
		btnEditar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnEditar.setActionCommand(EDITAR);
		btnGuardar.setActionCommand(GUARDAR);
		btnEliminar.setActionCommand(ELIMINAR);
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);		
		btnEliminar.setEnabled(true);		
		btnEditar.setToolTipText("Editar este Sitio");
		btnGuardar.setToolTipText("Guardar este Sitio");
		btnEliminar.setToolTipText("Eliminar este Sitio");
		
		JPanel panelEdicion = new JPanel();
		panelEdicion.setLayout(new GridLayout(1,2));
		panelEdicion.add(btnEditar);
		panelEdicion.add(btnGuardar);		
		
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new BorderLayout());
		panelArriba.add(txtNombre,BorderLayout.CENTER);
		panelArriba.add(panelEdicion,BorderLayout.EAST);

		JPanel panelMedio = new JPanel();
		panelMedio.setLayout(new BorderLayout());
		panelMedio.add(new JLabel(sitio.darTipoSitio()),BorderLayout.CENTER);
		panelMedio.add(btnEliminar,BorderLayout.EAST);
		
		add(panelArriba,BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("data/img/sitios/"+sitio.darNombreImagen())),BorderLayout.CENTER);
				
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BorderLayout());
		panelInfo.add(panelMedio,BorderLayout.NORTH);
		
		JPanel restoCampos = new JPanel();
		restoCampos.setLayout(new GridLayout(3,1));
		panelInfo.add(restoCampos,BorderLayout.CENTER);

		
		JPanel panelCalificacion = new JPanel();
		panelCalificacion.setLayout(new FlowLayout());
		
		panelCalificacion.add(new JLabel("Calificar:"));
		ButtonGroup calificacion = new ButtonGroup();
		JRadioButton[] cals = new JRadioButton[5];
		for(int i=0;i<cals.length;i++){
			cals[i] = new JRadioButton((i+1)+"");
			//cals[i].setHorizontalTextPosition(SwingConstants.LEADING );
			cals[i].setMargin(new Insets(0, 0, 0, 0));
			cals[i].addActionListener(this);
			calificacion.add(cals[i]);
			panelCalificacion.add(cals[i]);
			
			if(sitio.darCalificacion()==(i+1)){
				cals[i].setSelected(true);
			}
		}
		
		restoCampos.add(txtAnho);
		restoCampos.add(txtDireccion);
		restoCampos.add(panelCalificacion);
		
		add(panelInfo,BorderLayout.SOUTH);
	}
	
	public String obtenerNombreImagen(String tipoSitio){
		if(tipoSitio.equals(Sitio.COMERCIAL)){
			return (comercial++)+"";
		}else if(tipoSitio.equals(Sitio.CULTURAL)){
			return (cultural++)+"";
		}else if(tipoSitio.equals(Sitio.ESCENARIOS)){
			return (escenarios++)+"";
		}else if(tipoSitio.equals(Sitio.INTERES)){
			return (interes++)+"";
		}else{
			return 0+"";
		}
	}
	
	public String darNombre(){
		return txtNombre.getText();
	}

	public String darAnho(){
		return txtAnho.getText();
	}

	public String darDireccion(){
		return txtDireccion.getText();
	}

	private void hacerCamposEditables(){
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		txtNombre.setEditable(true);
		txtAnho.setEditable(true);
		txtAnho.setText(sitio.darAnhoConstruccion()+"");
		txtDireccion.setEditable(true);
	}
	
	private void hacerCamposNoEditables(){
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);
		txtNombre.setEditable(false);
		txtAnho.setEditable(false);
		txtAnho.setText("Construido en "+sitio.darAnhoConstruccion());
		txtDireccion.setEditable(false);		
	}
	
	private void recargarInformacion(){
		txtNombre.setText(sitio.darNombre());
		txtAnho.setText("Construido en "+sitio.darAnhoConstruccion());
		txtDireccion.setText(sitio.darDireccion());
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() instanceof JRadioButton){
			try{
				int calificacion = Integer.parseInt(((JRadioButton)ev.getSource()).getText());
				
				if(principal.darCiudad().calificarSitioDeZona(zona.darUbicacion(), principal.darNumeroSitio(zona, sitio), calificacion)){//sitio.cambiarCalificacion(calificacion);
					JOptionPane.showMessageDialog(this,"Se ha asignado satisfactoriamente la calificación\n" +
													" de: "+calificacion+" al sitio: "+sitio.darNombre());
				}else{
					JOptionPane.showMessageDialog(this,"El sitio no pudo ser calificado.");
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Se no se ha podido asignar la calificación\n" +
												   "al sitio: "+sitio.darNombre());				
			}
		}else{
			String comando = ev.getActionCommand();
			if(comando.equals(EDITAR)){
				hacerCamposEditables();
			}else if(comando.equals(GUARDAR)){
				principal.guardarCambiosSitio(this,sitio,zona);
				hacerCamposNoEditables();
				recargarInformacion();
			}else if(comando.equals(ELIMINAR)){
				principal.eliminarSitio(this,sitio,zona);
			}
		}
	}
}
