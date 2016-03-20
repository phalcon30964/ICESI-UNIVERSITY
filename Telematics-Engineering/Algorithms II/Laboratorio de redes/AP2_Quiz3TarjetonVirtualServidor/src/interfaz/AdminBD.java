package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mundo.Candidato;

public class AdminBD {

	private final static String USER = "P09704_12";
	private final static String PASSWORD = "ARIjk07X";
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL_CONEXION = "jdbc:mysql://172.16.0.105:3306/P09704_12";


	private Connection conexion;
	private Statement state;

	public AdminBD() {
		
		
		// Es importante que la clase InterfazXXX que crea un objeto de la clase
		// actual, invoque el método abrirConexion para establecer la
		// comunicación con la base de datos indicada en las constantes

		// Verifique que el llamado al método abrirConexion ya se realizó
		// en el método constructor de la clase InterfazXXX
	}

	/**
	 * Inicializa el Statement
	 */
	public void abrirConexion() throws ClassNotFoundException, SQLException {
		
		try 
		{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL_CONEXION,USER,PASSWORD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion");		
		}
			
		if(conexion!=null)
		{
				JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
				state = conexion.createStatement();
				
				state.executeQuery("select * from Candidato where 1=2 ");
				
		
				String  crearTabla = "CREATE TABLE Candidato (Codigo varchar(50), Nombre varchar(50), Partido varchar(50), Votos varchar(50))";
				state.execute(crearTabla);
					
		}
		
		

		
	}

	/**
	 * Se encarga de consultar TODOS los candidatos y retornar un ArrayList de
	 * objetos Candidatos, uno por cada registro presente en la tabla.
	 */
	public ArrayList<Candidato> consultarCandidatos() throws SQLException {
		return null;
	}

	/**
	 * Incrementa en 1 (uno) los votos del candidato con el código pasado por
	 * parámetro
	 */
	public void actualizarVotosCandidato(String codigo) throws SQLException {

	}

}
