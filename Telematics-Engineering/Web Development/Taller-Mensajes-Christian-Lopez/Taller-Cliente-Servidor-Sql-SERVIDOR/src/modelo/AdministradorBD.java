package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				conx = DriverManager.getConnection(urlInterna,usuario,contrasena);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				if(conx!=null)
				{
					JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "Conexión Fallida");
				}
				
				return conx;
			}	
	}
	
//	public void ejecutarActualizacion(String command) throws SQLException{
//		comandos.execute(command);
//	}
//	
//	public ResultSet ejecutarConsulta(String command) throws SQLException{
//		return comandos.executeQuery(command);
//	}
	
	public Mensaje consultarNuevoMensaje() throws SQLException{
		
		Random rand = new Random();
		
		int id = rand.nextInt(9)+1;
		
		ResultSet rs = comandos.executeQuery("SELECT Mensaje FROM Mensajes WHERE Identificador="+id);
		
		String msj = "";
		
		if(rs.next()){
			msj = rs.getString(1);
		}
				
		return new Mensaje(msj);
	} 

}
