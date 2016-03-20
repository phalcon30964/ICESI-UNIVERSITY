package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.DivisionEgresados;
import mundo.FormatoInvalidoException;

@SuppressWarnings("serial")
public class InterfazEgresados extends JFrame{	
	private DivisionEgresados divisionE;
	private PanelListaEgresados panelLista;
	private PanelTarjetasInvitacion panelTarjetas;
	private PanelBanner panelBanner;
	
	public InterfazEgresados(){
		setTitle("Laboratorio: Division de Egresados");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		setSize(900,500);
		
		divisionE     = new DivisionEgresados();
		panelLista    = new PanelListaEgresados(this);
		panelTarjetas = new PanelTarjetasInvitacion(this);
		panelBanner   = new PanelBanner();
		
		add(panelBanner,BorderLayout.NORTH);
		add(panelLista,BorderLayout.CENTER);
		add(panelTarjetas,BorderLayout.EAST);
	}
	
	private String preguntarNombreArchivoAbrir(){
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Abrir Archivo de Egresados");
		
		File archivoEgresados = null;
		int resultado = fc.showOpenDialog(this);
		if(resultado == JFileChooser.APPROVE_OPTION){
			archivoEgresados = fc.getSelectedFile();
		}
		
		String nombreArchivo = null;
		if(archivoEgresados!=null){
			nombreArchivo = archivoEgresados.getAbsolutePath();
			panelLista.cambiarEstadoNombreArchivo(nombreArchivo);
		}
		
		return nombreArchivo;
	}
	
	private String preguntarNombreArchivoGuardar(){
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Guardar Archivo de Tarjetas");
		fc.setApproveButtonText("Guardar Tarjetas");
		
		File archivoAGuardar = null;
		int resultado = fc.showSaveDialog(this);
		if(resultado == JFileChooser.APPROVE_OPTION){
			archivoAGuardar = fc.getSelectedFile();
		}
		
		String nombreArchivo = null;
		if(archivoAGuardar!=null){
			nombreArchivo = archivoAGuardar.getAbsolutePath();
			panelTarjetas.cambiarEstadoNombreArchivo(nombreArchivo);
		}
		
		return nombreArchivo;
	}
	
	public void cargarListaDesdeArchivo(){
		
		int respuesta = JOptionPane.showConfirmDialog(this, "Desea cargar el archivo por medio de texto?");
		
		if(respuesta==JOptionPane.YES_OPTION){
		
		String nombreArchivo = preguntarNombreArchivoAbrir();
		
		if(nombreArchivo!=null){
			try {				
			
				divisionE.cargarListaEgresados(nombreArchivo);
				panelLista.cambiarTextoArea(divisionE.obtenerCadenaInfoEgresados());
				JOptionPane.showMessageDialog(this,"La lista se cargó exitosamente del archivo!");
				
			} catch (FormatoInvalidoException e) {
				String mensajeAMostrar;
				mensajeAMostrar = "Formato Inválido:\n"
						        + "Mensaje: "+e.getMessage()+"\n" +"Nombre de archivo inválido: "+ e.darNombreArchivo() +"\nLinea de error: " + e.darNumeroLineaPrimerError();
								
				JOptionPane.showMessageDialog(this,mensajeAMostrar);
			}
		}else{
			JOptionPane.showMessageDialog(this,"No se seleccionó un archivo!");
		}
		
		}else if(respuesta == JOptionPane.NO_OPTION){
			
			int respuesta2 = JOptionPane.showConfirmDialog(this, "Desea cargar datos deserializados?");
			
			if(respuesta2 == JOptionPane.YES_NO_OPTION){
				
				String nombreArchivo2 = preguntarNombreArchivoAbrir();
				
				try{
					
				divisionE.cargarListaEgresadosSerializada(nombreArchivo2);
				panelLista.cambiarTextoArea(divisionE.obtenerCadenaInfoEgresados());
				JOptionPane.showMessageDialog(this,"La lista se cargó exitosamente del archivo!");
				
				}catch(Exception e){
				
					JOptionPane.showMessageDialog(this, "Hubo un error al cargar el archivo serializado de: "+nombreArchivo2);
				
				}
				
			}
		}
	}
	
	public void asignarPuestosEnAuditorio(){
		divisionE.asignarPuestoAInvitados();
		panelLista.cambiarTextoArea(divisionE.obtenerCadenaInfoEgresados());
		JOptionPane.showMessageDialog(this,"Los puestos fueron generados y asignados satisfactoriamente!");		
	}
	
	public void generarTarjetasInvitacion(){
		String tarjetas = divisionE.generaTarjetasInvitacion();
		panelTarjetas.cambiarTextoArea(tarjetas);
		JOptionPane.showMessageDialog(this,"Las tarjetas fueron generadas satisfactoriamente!");		
	}
	
	public void guardarTarjetasInvitacion(){
		String nombreArchivo = preguntarNombreArchivoGuardar();
		
			if(nombreArchivo!=null){
				try {
					String tarjetas = divisionE.generaTarjetasInvitacion();				
					divisionE.guardarTarjetasInvitacion(nombreArchivo);
					JOptionPane.showMessageDialog(this,"Las tarjetas se guardaron exitosamente en el archivo!");				
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this,"Ocurrió un problema al guardar las tarjetas en archivo.");
				}
			}else{
				JOptionPane.showMessageDialog(this,"No se seleccionó un archivo!");
			}
	}
		
		
	
	
	public static void main(String[] args){
		new InterfazEgresados().setVisible(true);
		
		
	}
}
