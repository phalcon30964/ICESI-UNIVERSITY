package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;



public class AdministradorBD {
	
	private Connection conexion;
	private Statement comandos;
	
	public final static String driver = "com.mysql.jdbc.Driver";
	public final static String urlExterna = "jdbc:mysql://200.3.193.22:3306/P09728_1_5";
	public final static String urlInterna = "jdbc:mysql://172.16.0.105:3306/P09728_1_5";
	public final static String usuario = "P09728_1_5";
	public final static String contrasena = "5ndFrH8B";
	
	public AdministradorBD() {
		
		conexion =  GetConnection();
		try {
			comandos = conexion.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Hubo un problema creando el canal");

		}		
		
	}
	
	@SuppressWarnings("finally")
	public  Connection GetConnection(){
		
			Connection conx = null;
		
			try {
				Class.forName(driver);
				conx = DriverManager.getConnection(urlExterna,usuario,contrasena);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				if(conx!=null)
				{
					System.out.println("Conexión a la base de datos realizada correctamente");
				}else{
					System.out.println("Conexión a la base de datos fallida");
				}
				
				return conx;
			}	
	}
	
	
	public boolean restablecerContrasena(String email){
		return false;
	}
	
	public boolean registrarUsuario(String nombre, String contrasena, String email){
		return false;
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
	
	public boolean agregarTagsTarea(String nombreTarea, String fecha, String tag, String nombreUsuario){
		return false;
	}
	
	public boolean iniciarSesion(String nombreUsuario, String contrasena){
		return false;
	}
	
//	public void ejecutarActualizacion(String command) throws SQLException{
//		comandos.execute(command);
//	}
//	
//	public ResultSet ejecutarConsulta(String command) throws SQLException{
//		return comandos.executeQuery(command);
//	}

}
