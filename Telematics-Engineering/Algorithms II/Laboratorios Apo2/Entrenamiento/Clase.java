package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Clase {

	//------------------------------
	//ATRIBUTO
	//------------------------------
	private Connection conexion;
	
	//------------------------------
	//CONSTRUCTOR
	//------------------------------

	public Clase() throws SQLException{

		conexion=GetConnection();

	}

	public static Connection GetConnection()
	{
		Connection conexion=null;

		try
		{
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://200.3.193.22:5432/P09704_9";
			conexion= DriverManager.getConnection(url,"P09704_9", "ewBbkbB7");
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion=null;
		}
		finally
		{
			return conexion;
		}
	}


	public void tablaParticipante(){

		try {
			String tabl= "CREATE TABLE participantes (nombre varchar(50) not null, telefono varchar(20),tipo varchar(20)not null,"
					+"PRYMARY KEY(telefono), check (tipo in('ponente','asistente'))";
//			String campos="INSERT INTO participantes VALUES (columna1,columna2,columna3)";

			Statement con;
			con= conexion.createStatement();
			con.execute(tabl);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarParticipante(){
		try {
			
			Statement con = conexion.createStatement();
			
			String integ="INSERT INTO EMPLEADOS (nombre, telefono, tipo )VALUES ('Pedro' , '3250600','ponente' )";
			con.execute(integ);
			integ="INSERT INTO EMPLEADOS (nombre, telefono, tipo )VALUES ('Pablo','33454556','asistente' )";
			con.execute(integ);
			integ= "INSERT INTO EMPLEADOS (nombre, telefono, tipo )VALUES ('Lucia' , '4556432',ponente )";
			con.execute(integ);
			integ= "INSERT INTO EMPLEADOS (nombre, telefono, tipo )VALUES ('Luciana' , '5455676',ponente )";
			con.execute(integ);

		
			System.out.println("Agraga tparticipantes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	public static void main(String[] args)
	{
		Connection miConexion;
		miConexion=Clase.GetConnection();

		if(miConexion!=null)
		{
			JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
		}
	}

}


