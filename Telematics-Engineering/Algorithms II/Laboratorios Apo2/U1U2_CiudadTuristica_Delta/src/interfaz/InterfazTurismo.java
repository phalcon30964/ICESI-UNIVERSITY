package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import mundo.Ciudad;
import mundo.Sitio;
import mundo.Zona;

@SuppressWarnings("serial")
public class InterfazTurismo extends JFrame{
	private PanelZona pvzNorte;
	private PanelZona pvzCentro;
	private PanelZona pvzSur;
	
	private PanelSitios pvsNorte;
	private PanelSitios pvsCentro;
	private PanelSitios pvsSur;
	private Ciudad ciudad;
	
	public final static String PREFIJO_ZONA = "Zona ";
	
	public InterfazTurismo(){
		ciudad    = new Ciudad();
		
		pvsNorte  = new PanelSitios(this,ciudad.darzonaNorte());
		pvsCentro = new PanelSitios(this,ciudad.darzonaCentro());
		pvsSur    = new PanelSitios(this,ciudad.darzonaSur());
		
		pvzNorte  = new PanelZona(this,ciudad.darzonaNorte(),pvsNorte);
		pvzCentro = new PanelZona(this,ciudad.darzonaCentro(),pvsCentro);
		pvzSur    = new PanelZona(this,ciudad.darzonaSur(),pvsSur);
		
		setTitle("Ciudad Turística");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JTabbedPane pestanas = new JTabbedPane();
		add(pestanas,BorderLayout.CENTER);
		pestanas.addTab(PREFIJO_ZONA+ciudad.darzonaNorte().obtenerNombreUbicacion(),pvzNorte);
		pestanas.addTab(PREFIJO_ZONA+ciudad.darzonaCentro().obtenerNombreUbicacion(),pvzCentro);
		pestanas.addTab(PREFIJO_ZONA+ciudad.darzonaSur().obtenerNombreUbicacion(),pvzSur);
		
		configurarMenu();
		
		setSize(1100,410);
		setResizable(false);
	}
	
	private void configurarMenu(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu estadisticas = new JMenu("Estadísticas");
		JMenu zonaNorte    = new JMenu("Zona Norte");
		JMenu zonaCentro   = new JMenu("Zona Centro");
		JMenu zonaSur      = new JMenu("Zona Sur");
		JMenu generales    = new JMenu("Toda la Ciudad");

		JMenuItem estadistica2N = new JMenuItem("Sitio Mejor Calificado");
		estadistica2N.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarMejorSitioZona(ciudad.darzonaNorte());}});
		JMenuItem estadistica3N = new JMenuItem("Porcentaje Sitios Calificados");
		estadistica3N.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarPorcentajeCalificadosZona(ciudad.darzonaNorte());}});
		
		zonaNorte.add(estadistica3N);
		zonaNorte.add(estadistica2N);

		JMenuItem estadistica2C = new JMenuItem("Sitio Mejor Calificado");
		estadistica2C.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarMejorSitioZona(ciudad.darzonaCentro());}});
		JMenuItem estadistica3C = new JMenuItem("Porcentaje Sitios Calificados");
		estadistica3C.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarPorcentajeCalificadosZona(ciudad.darzonaCentro());}});
		
		zonaCentro.add(estadistica3C);
		zonaCentro.add(estadistica2C);

		JMenuItem estadistica2S = new JMenuItem("Sitio Mejor Calificado");
		estadistica2S.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarMejorSitioZona(ciudad.darzonaSur());}});
		JMenuItem estadistica3S = new JMenuItem("Porcentaje Sitios Calificados");
		estadistica3S.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarPorcentajeCalificadosZona(ciudad.darzonaSur());}});
		
		zonaSur.add(estadistica3S);
		zonaSur.add(estadistica2S);

		JMenuItem estadistica3G = new JMenuItem("Zona Con Menor Densidad Educativa");
		estadistica3G.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {mostrarZonaMenorDensidadEducativa();}});
		
		generales.add(estadistica3G);

		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {System.exit(0);}});
		
		estadisticas.add(zonaNorte);
		estadisticas.add(zonaCentro);
		estadisticas.add(zonaSur);
		estadisticas.add(generales);
		estadisticas.addSeparator();
		estadisticas.add(salir);
		
		JMenu ayuda = new JMenu("Ayuda");
		JMenuItem creditos = new JMenuItem("Créditos");
		creditos.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev) {JOptionPane.showMessageDialog(null, "Material desarrollado para el curso de:\nAlgoritmos y Programación 1\nUniversidad ICESI\nCali-Colombia");}});
		ayuda.add(creditos);

		menuBar.add(estadisticas);
		menuBar.add(ayuda);
		
		setJMenuBar(menuBar);		
	}
	
	private void mostrarMejorSitioZona(Zona z){
		String reporte = ciudad.generarReporteMejorSitioDeZona(z.darUbicacion());
		if(!reporte.trim().equals("")){
			JOptionPane.showMessageDialog(this, reporte+" "+z.obtenerNombreUbicacion());
		}else{
			JOptionPane.showMessageDialog(this,"El reporte está vacío.");
		}
	}
	
	private void mostrarPorcentajeCalificadosZona(Zona z){
		JOptionPane.showMessageDialog(this, "El porcentaje de sitios calificados de la zona "+z.obtenerNombreUbicacion()+" es "+ciudad.calcularPorcentajeCalificadoDeZona(z.darUbicacion())+" %");
	}
	
	private void mostrarZonaMenorDensidadEducativa(){
		Zona z = ciudad.encontrarZonaMenorDensidadEducativa();
		double densidad = 0;
		if(z!=null){
			if(z.darAreaProporcional()!=0) densidad = z.darCantidadCentrosEducativos()/z.darAreaProporcional();
				JOptionPane.showMessageDialog(this, "La menor densidad educativa se presenta en la zona "+z.obtenerNombreUbicacion()+"\n"
				+ "Con una densidad centros educativos por área (#centros/area) de "+densidad);
		}else{
			JOptionPane.showMessageDialog(this, "No se encontró ninguna zona en el mundo!\nSu método debe estar muy mal porque las relaciones hacia Zona son obligatorias.");
		}
	}
	
	public boolean guardarCambiosZona(PanelZona pvz, Zona z){
		try{
			double area = Double.parseDouble(pvz.darArea()); 
			int educ    = Integer.parseInt(pvz.darEducacion()); 
			int salu    = Integer.parseInt(pvz.darSalud());
			
			ciudad.actualizarZona(z.darUbicacion(), area, educ, salu);
			
			JOptionPane.showMessageDialog(this, "La información fue actualizada exitosamente!");
			
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "La información no pudo ser actualizada!\n" +
												"Debe llenar los campos con datos válidos y debe tener en cuenta que\n" +
												"el área, el número de centros educativos y de saludo son valores numéricos");
			return false;			
		}
	}
	
	public boolean guardarCambiosSitio(PanelSitio ps, Sitio s, Zona z){
		try{
			String nombre = ps.darNombre(); 
			int anho      = Integer.parseInt(ps.darAnho()); 
			String direcc = ps.darDireccion(); 
			
			int numeroSitio = darNumeroSitio(z, s);
			
			ciudad.actualizarSitioDeZona(z.darUbicacion(),numeroSitio, nombre, anho, direcc);
			
			JOptionPane.showMessageDialog(this, "La información fue actualizada exitosamente!");
			
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "La información no pudo ser actualizada!\n" +
												"Debe llenar los campos con datos válidos y debe tener\n" +
												"en cuenta que el año es un valor numérico entero");
			return false;			
		}		
	}
	
	public void eliminarSitio(PanelSitio ps, Sitio s, Zona z){
		int confirmacion = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar el sitio indicado?");
		if(confirmacion == JOptionPane.YES_OPTION){
			if(ciudad.eliminarSitioDeZona(z.darUbicacion(), s.darNombre())){//if(z.eliminarSitio(s.darNombre())){
				if(z==ciudad.darzonaNorte()){
					pvsNorte.eliminarPanelSitio(ps);
				}else if(z==ciudad.darzonaCentro()){
					pvsCentro.eliminarPanelSitio(ps);
				}else if(z==ciudad.darzonaSur()){
					pvsSur.eliminarPanelSitio(ps);
				}
			
				JOptionPane.showMessageDialog(this, "El sitio fue eliminado satisfactoriamente!");
			}else{
				JOptionPane.showMessageDialog(this, "El sitio NO pudo ser eliminado");				
			}
		}
	}
	
	public void abrirVentanaNuevoSitio(Zona zona){
		new VentanaNuevoSitio(this,zona).setVisible(true);
	}
	
	public boolean guardarNuevoSitio(VentanaNuevoSitio vns, Zona zona){
		try{
			
			String nombre = vns.darNombre(); 
			int anho      = Integer.parseInt(vns.darAnho()); 
			String direcc = vns.darDireccion(); 
			String tipo   = vns.darTipo();
			String imagen = vns.darImagen();
			
			boolean guardo = ciudad.agregarSitioAZona(zona.darUbicacion(), nombre, imagen, tipo, anho, direcc);
			
			if(guardo){
				JOptionPane.showMessageDialog(this, "El nuevo sitio fue guardado exitosamente!");
				switch(zona.darUbicacion()){
					case Zona.NORTE:
						pvsNorte.actualizarSitios();
					break;
					case Zona.CENTRO:
						pvsCentro.actualizarSitios();
					break;
					case Zona.SUR:
						pvsSur.actualizarSitios();
					break;
				}
			}else{
				JOptionPane.showMessageDialog(this, "El nuevo sitio no pudo ser guardado\n" +
													"Es probable que ya exista un sitio con el nombre indicado\n" +
													"o que se haya alcanzado el número máximo de\n" +
													"sitios permitidos para una zona (máximo sitios: 5)");				
			}
			
			return guardo;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "El nuevo sitio no pudo ser guardado\n" +
												"Debe llenar los campos con datos válidos y debe tener\n" +
												"en cuenta que el año es un valor numérico entero");
			return false;			
		}		
	}
	
	public int darNumeroSitio(Zona z, Sitio s){
		if(z.darSitioUno()==s)    return 1;
		if(z.darSitioDos()==s)    return 2;
		if(z.darSitioTres()==s)   return 3;
		if(z.darSitioCuatro()==s) return 4;
		if(z.darSitioCinco()==s)  return 5;
		
		return 0;
	}
	
	public Ciudad darCiudad(){
		return ciudad;
	}
	
	public static void main(String[] args){
		new InterfazTurismo().setVisible(true);
	}
}
