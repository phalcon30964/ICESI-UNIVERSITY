package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import mundo.Sitio;
import mundo.Zona;

@SuppressWarnings("serial")
public class VentanaNuevoSitio extends JDialog implements ActionListener{
	private JTextField txtNombre;
	private JTextField txtAnho;
	private JTextField txtDireccion;
	private JComboBox comboTipo;
	private JComboBox comboImagen;
	
	private JButton butGuardar;
	private JButton butCancelar;
	
	public static final String GUARDAR="GUARDAR";
	public static final String CANCELAR="CANCELAR";
	
	private InterfazTurismo principal;
	
	private Zona zona;
	
	public VentanaNuevoSitio(InterfazTurismo ventana, Zona z){
		principal = ventana;
		zona = z;
		String nombreZona = z.obtenerNombreUbicacion();
		setTitle("Nuevo Sitio - Zona "+nombreZona);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		
		JPanel panelPrincipal = new JPanel();
		add(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(6,2));
		panelPrincipal.setBorder(new TitledBorder("Agregar Nuevo Sitio a la Zona "+nombreZona));
		
		txtNombre    = new JTextField();
		txtAnho      = new JTextField();
		txtDireccion = new JTextField();
		
		String[] tiposSitio = new String[]{Sitio.COMERCIAL,Sitio.CULTURAL,Sitio.ESCENARIOS,Sitio.INTERES};
		comboTipo = new JComboBox(tiposSitio);
		
		/*
		FilenameFilter filter=new FilenameFilter(){
			public boolean accept(File dir, String fileName) {
				return new File(dir.getAbsolutePath()+"/"+fileName).isFile();
			}
		};*/
		File f=new File("./data/img/sitios/");
		String [] fileList=f.list(/*filter*/);
		comboImagen = new JComboBox(fileList);
		
		butGuardar  = new JButton("Guardar");
		butCancelar = new JButton("Cancelar");
		
		butGuardar.setActionCommand(GUARDAR);
		butCancelar.setActionCommand(CANCELAR);
		
		butGuardar.addActionListener(this);
		butCancelar.addActionListener(this);
		
		panelPrincipal.add(new JLabel("Nombre:",SwingConstants.RIGHT));
		panelPrincipal.add(txtNombre);
		panelPrincipal.add(new JLabel("Imagen:",SwingConstants.RIGHT));
		panelPrincipal.add(comboImagen);
		panelPrincipal.add(new JLabel("Tipo de Sitio:",SwingConstants.RIGHT));
		panelPrincipal.add(comboTipo);
		panelPrincipal.add(new JLabel("Año de Construcción:",SwingConstants.RIGHT));
		panelPrincipal.add(txtAnho);
		panelPrincipal.add(new JLabel("Dirección:",SwingConstants.RIGHT));
		panelPrincipal.add(txtDireccion);
		panelPrincipal.add(butGuardar);
		panelPrincipal.add(butCancelar);
		
		pack();
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

	public String darTipo(){
		return comboTipo.getSelectedItem().toString();
	}
	
	public String darImagen(){
		return comboImagen.getSelectedItem().toString();
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		String comando = ev.getActionCommand();
		if(comando.equals(GUARDAR)){
			if(principal.guardarNuevoSitio(this, zona)){
				dispose();
			}
		}else if(comando.equals(CANCELAR)){
			dispose();
		}
	}
}
