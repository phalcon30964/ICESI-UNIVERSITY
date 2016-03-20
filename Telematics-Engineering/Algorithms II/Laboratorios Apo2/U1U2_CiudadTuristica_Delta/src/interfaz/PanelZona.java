package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import mundo.Zona;

@SuppressWarnings("serial")
public class PanelZona extends JPanel implements ActionListener{
	private JTextField txtUbicacion;
	private JTextField txtArea;
	private JTextField txtEducacion;
	private JTextField txtSalud;
	private JLabel labImagen;
	private int imgActual;
	private final static int NRO_IMGS = 3;
	private final static int TIEMPO_PASE = 5000;
	
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnAgregarSitio;
	
	private final static String EDITAR="EDITAR";
	private final static String GUARDAR="GUARDAR";
	private final static String AGREGAR_SITIO="AGREGAR_SITIO";
	
	private Zona zona;
	private InterfazTurismo principal;
	
	public PanelZona(InterfazTurismo ventana, Zona laZona, PanelSitios pvs){
		principal = ventana;
		zona      = laZona;
		imgActual = 1;
		
		//setBorder(new TitledBorder(InterfazTurismo.PREFIJO_ZONA+zona.obtenerNombreUbicacion()));
		setLayout(new BorderLayout());
		
		ImageIcon imagen = new ImageIcon("data/img/"+zona.darUbicacion()+"_"+((imgActual++)%NRO_IMGS)+".jpg");
		labImagen  = new JLabel(imagen);
		imagen.setImageObserver(labImagen);
		JPanel panelImagen = new JPanel();
		panelImagen.setBorder(new LineBorder(Color.BLACK));
		panelImagen.setLayout(new BorderLayout());
		panelImagen.add(labImagen,BorderLayout.NORTH);
		add(panelImagen,BorderLayout.WEST);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(new GridLayout(2,4));
		panelInformacion.setBorder(new TitledBorder("Información de la "+InterfazTurismo.PREFIJO_ZONA+zona.obtenerNombreUbicacion()));
		panelInformacion.setPreferredSize(new Dimension(0,70));
		
		txtUbicacion = new JTextField(zona.obtenerNombreUbicacion());
		txtArea      = new JTextField(zona.darAreaProporcional()+"");
		txtEducacion = new JTextField(zona.darCantidadCentrosEducativos()+"");
		txtSalud     = new JTextField(zona.darCantidadCentrosSalud()+"");
		txtUbicacion.setEditable(false);
		txtArea.setEditable(false);
		txtEducacion.setEditable(false);
		txtSalud.setEditable(false);
		
		btnEditar  = new JButton("Editar Información");
		btnGuardar = new JButton("Guardar Cambios");
		btnAgregarSitio = new JButton("Agregar un Nuevo Sitio");
		btnEditar.setMargin(new Insets(0, 0, 0, 0));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		btnAgregarSitio.setMargin(new Insets(0, 0, 0, 0));
		btnEditar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnAgregarSitio.addActionListener(this);
		btnEditar.setActionCommand(EDITAR);
		btnGuardar.setActionCommand(GUARDAR);
		btnAgregarSitio.setActionCommand(AGREGAR_SITIO);
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnAgregarSitio.setEnabled(true);
		btnEditar.setToolTipText("Editar esta zona");
		btnGuardar.setToolTipText("Guardar la información actualizada de esta zona");
		btnAgregarSitio.setToolTipText("Agregar un nuevo sitio para esta zona");
		
		JPanel panelAgregarSitio = new JPanel();
		//panelAgregarSitio.setBorder(BorderFactory.createRaisedBevelBorder());
		panelAgregarSitio.setLayout(new GridLayout(1,1));
		panelAgregarSitio.add(btnAgregarSitio);
		panelImagen.add(panelAgregarSitio,BorderLayout.CENTER);
		
		panelInformacion.add(new JLabel("Ubicación"));
		panelInformacion.add(new JLabel("Área"));
		panelInformacion.add(new JLabel("# C. Educ."));
		panelInformacion.add(new JLabel("# C. Salud"));
		panelInformacion.add(btnEditar);
		panelInformacion.add(txtUbicacion);
		panelInformacion.add(txtArea);
		panelInformacion.add(txtEducacion);
		panelInformacion.add(txtSalud);
		panelInformacion.add(btnGuardar);
		
		JPanel derecha = new JPanel();
		derecha.setLayout(new BorderLayout());
		derecha.add(panelInformacion,BorderLayout.NORTH);
		JScrollPane jsp = new JScrollPane(pvs);
		jsp.setBorder(new TitledBorder("Sitios de la "+InterfazTurismo.PREFIJO_ZONA+zona.obtenerNombreUbicacion()));
		derecha.add(jsp,BorderLayout.CENTER);
		
		add(derecha,BorderLayout.CENTER);
		
		new Thread(){public void run(){
			while(true){
				try{Thread.sleep(TIEMPO_PASE);labImagen.setIcon(new ImageIcon("data/img/"+zona.darUbicacion()+"_"+((imgActual++)%NRO_IMGS)+".jpg"));}
				catch(Exception e){};
			}}}.start();
	}
	
	public String darArea(){
		return txtArea.getText();
	}

	public String darEducacion(){
		return txtEducacion.getText();
	}

	public String darSalud(){
		return txtSalud.getText();
	}
	
	private void hacerCamposEditables(){
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		//txtUbicacion.setEditable(true);
		txtArea.setEditable(true);
		txtEducacion.setEditable(true);
		txtSalud.setEditable(true);		
	}
	
	private void hacerCamposNoEditables(){
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);
		//txtUbicacion.setEditable(false);
		txtArea.setEditable(false);
		txtEducacion.setEditable(false);
		txtSalud.setEditable(false);		
	}

	private void recargarInformacion(){
		txtArea.setText(zona.darAreaProporcional()+"");
		txtEducacion.setText(zona.darCantidadCentrosEducativos()+"");
		txtSalud.setText(zona.darCantidadCentrosSalud()+"");		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String comando = ev.getActionCommand();
		if(comando.equals(EDITAR)){
			hacerCamposEditables();
		}else if(comando.equals(GUARDAR)){
			principal.guardarCambiosZona(this,zona);
			hacerCamposNoEditables();
			recargarInformacion();
		}else if(comando.equals(AGREGAR_SITIO)){
			principal.abrirVentanaNuevoSitio(zona);
		}
	}
}
