package baseDatos;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connector {

	private static Connection conexion;
	private static Statement comandos;
	
	public connector() {
		
		conexion =  GetConnection();
		try {
			comandos = conexion.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Hubo un problema creando el canal");

		}
		crearTablaProductos();
		
		
	}
	
	public static Connection GetConnection(){
		
			Connection conx = null;
		
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://200.3.193.22:5432/P09704_12";
				conx = DriverManager.getConnection(url,"P09704_12","ARIjk07X");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				if(conx!=null)
				{
					JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
				}
				
				return conx;
			}
			
			
			
			
	}
	
	
	public void crearTablaProductos(){
		
		
		String cad = "CREATE TABLE Customer (First_Name char(50), Last_Name char(50), Address char(50), City char(50), Country char(25), Birth_Date datetime)";
		
//		try {
//			comandos.execute(cad);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "No se pudo crear tabla");
//		}
		
		Statement con;
		try {
			con = conexion.createStatement();
			con.execute(cad);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No se pudo crear tabla");
		}
	
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			connector x = new connector();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
