package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectorPostgreSql {
	
	private Connection conexion;
	private Statement comandos;
	
	public final static String driver = "org.postgresql.Driver";
	public static String url;
	public static String usuario;
	public static String contrasena;
	
	public ConectorPostgreSql(String usuario, String contrasena, String ipServidor, String puertoServidor) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		url = "jdbc:postgresql://"+ipServidor+":"+puertoServidor+"/"+usuario;

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
				conx = DriverManager.getConnection(url,usuario,contrasena);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				if(conx!=null)
				{
					JOptionPane.showMessageDialog(null, "Conexión al servidor de base de datos realizada correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "Conexión Fallida");
				}
				
				return conx;
			}	
	}
	
	public void ejecutarActualizacion(String command) throws SQLException{
		comandos.execute(command);
	}
	
	public ResultSet ejecutarConsulta(String command) throws SQLException{
		return comandos.executeQuery(command);
	}
}
