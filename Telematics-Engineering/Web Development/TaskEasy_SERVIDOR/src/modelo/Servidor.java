package modelo;

import java.util.ArrayList;

public class Servidor {
	
	private AdministradorBD adminBD;
	private AdministradorEmail adminEmail;
	
	public Servidor() {
		adminBD = new AdministradorBD();
		adminEmail = new AdministradorEmail();
	}
	
	
	public String cargarInformacion(){
		return null;	
	}
	
	public boolean crearTarea(String nombre, String fecha, String fechaLimite, int prioridad, 
			double ubicacionLatitud, double ubicacionLongitud, ArrayList<String> tags, String categoria, 
			String nombreUsuario){
		return false;
	}

	public boolean eliminarTarea(String nombreTarea, String fecha, String nombreUsuario){
		return false;
	}
	
	public boolean modificarTarea(String nombre, String fecha, String fechaLimite, int prioridad,
			double ubicacionLatitud, double ubicacionLongitud, ArrayList<String> tags, String categoria
			, String nombreUsuario){
		return false;
	}
	
	public boolean cambiarPrioridadTarea(String nombre, String fecha, int nuevaPrioridad, String nombreUsuario){
		return false;
	}
	
	public boolean cambiarCategoriaTarea(String nombre, String fecha, String nuevaCategoria, String nombreUsuario){
		return false;
	}
	
	public boolean crearCategoria(String nombre, String nombreUsuario){
		return false;
	}
	
	public boolean eliminarCategoria(String nombre, String nombreUsuario){
		return false;
	}
	
	public boolean modificarCategoria(String nombre,String nuevoNombre, String nombreUsuario){
		return false;
	}
	
	public String getTareasPorPrioridad(String nombreUsuario){
		return null;
	}
	
	public String getTareasPorFechaLimite(String nombreUsuario){
		return null;
	}
	
	public String getTareasPorNombre(String nombreUsuario){
		return null;
	}
	
	public String getTareasPorPorCategoria(String categoria, String nombreUsuario){
		return null;
	}
	
	public String getTareasSemana(String nombreUsuario){
		return null;
	}
	
	public String getCategoriasDisponibles(String nombreUsuario){
		return null;
	}
	
	public boolean savePDFTareasSemana(String directorio, String nombreUsuario){
		return false;
	}
	
	public boolean agregarTagsTarea(String nombreTarea, String fecha, String tag, String nombreUsuario){
		return false;
	}
	
	public boolean iniciarSesion(String nombreUsuario, String contrasena){
		return false;
	}

}
