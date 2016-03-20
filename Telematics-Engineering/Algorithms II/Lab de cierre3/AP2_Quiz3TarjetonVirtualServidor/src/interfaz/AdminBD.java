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

	}

	/**
	 * Inicializa el Statement
	 */
	public void abrirConexion() {
		
		// Abro conecion con servidor sql
		try {
			Class.forName(DRIVER);
			conexion = DriverManager
					.getConnection(URL_CONEXION, USER, PASSWORD);

		} catch (Exception e) {
			System.out.println("No se pudo establecer conexion");

		}

		// Compruebo conexion

		if (conexion != null) {
			System.out.println("Conexion Exitosa");
		}

		// Creo flujo

		try {
			
			state = conexion.createStatement();
			
		} catch (SQLException e) {

			System.out.println("Fallo creacion de statement");
		}

		// Consulto si hay tabla o si hay datos en la tabla, sino la creo

		ResultSet rs = null;

		try {

			String consulta = "SELECT * FROM Candidato WHERE Codigo = 1234 ";

			rs = state.executeQuery(consulta);
			

		} catch (SQLException e1) {
			
			System.out.println("No existe tabla, creando...");
			
			crearTabla();

		}
	}

	public void crearTabla() {

		try {

			String sql = "CREATE TABLE Candidato ( Codigo int, Nombre varchar(100), Partido varchar(100), Votos int)";

			state.execute(sql);

			sql = "INSERT INTO Candidato VALUES ( 1234, 'Leonard Hofstadter', 'Fisica Experimental', 0)";

			state.execute(sql);

			sql = "INSERT INTO Candidato VALUES ( 5678, 'Sheldon Cooper', 'Fisica Experimental', 0)";

			state.execute(sql);

			sql = "INSERT INTO Candidato VALUES ( 2468, 'Penny', 'Actuacion', 0)";

			state.execute(sql);

			sql = "INSERT INTO Candidato VALUES ( 1357, 'Howard Wolowitz', 'Ingenieria Aeroespacial', 0)";

			state.execute(sql);

			sql = "INSERT INTO Candidato VALUES ( 1479, 'Rajesh Koothrappali', 'Astrofisica', 0)";

			state.execute(sql);

			System.out.println("Tabla creada correctamente");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Error creando tabla");
			
			e.printStackTrace();
			
		}

	}

	/**
	 * Se encarga de consultar TODOS los candidatos y retornar un ArrayList de
	 * objetos Candidatos, uno por cada registro presente en la tabla.
	 */
	public ArrayList<Candidato> consultarCandidatos() throws SQLException {
	
	ArrayList<Candidato> lista =  new ArrayList<Candidato>();
	
	ResultSet resultado = null;
	
	resultado = state.executeQuery("SELECT * FROM Candidato");
	
	while(resultado.next()){
		
		int codigo = resultado.getInt(1);
		String nombre = resultado.getString(2);
		String partido = resultado.getString(3);
		int votos = resultado.getInt(4);
		
		Candidato can = new Candidato(codigo, nombre, partido, votos);
		
		lista.add(can);
		
	}
	
	return lista;

	}

	/**
	 * Incrementa en 1 (uno) los votos del candidato con el código pasado por
	 * parámetro
	 */
	public void actualizarVotosCandidato(String codigo) throws SQLException {
		
		String comando = "UPDATE Candidato SET votos+1  WHERE Codigo = " + codigo;
		
		state.executeUpdate(comando);
	

	}

}
