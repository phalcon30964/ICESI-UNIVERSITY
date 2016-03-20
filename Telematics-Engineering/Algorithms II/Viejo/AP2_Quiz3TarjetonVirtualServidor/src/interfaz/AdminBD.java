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

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import mundo.Candidato;

public class AdminBD {


	private final static String USER = "P09704_12";
	private final static String PASSWORD = "ARIjk07X";
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL_CONEXION = "jdbc:mysql://200.3.193.22:3306/P09704_12";

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
	
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL_CONEXION,USER, PASSWORD);
			state = conexion.createStatement();
			
			try{
			ResultSet consultaTabla = state.executeQuery("SELECT * FROM Candidatos");
			}catch(Exception e){
				System.out.println("No existe tabla, creando");
				crearTabla();
			}
			
			
			
				
	}
	
	public void crearTabla() {
		
			
			try {
				state.execute("CREATE TABLE Candidatos (codigo integer, nombre varchar(50), partido varchar(50), votos integer)");
				
				state.execute("INSERT INTO Candidatos VALUES (1234, 'Leonard Hofstadter', 'Fisica experimental', 0)");
				state.execute("INSERT INTO Candidatos VALUES  (1357, 'Howard Wolowitz', 'Ingeniería Aeroespacial', 0)");
				state.execute("INSERT INTO Candidatos VALUES  (1479, 'Rajesh Koothappali', 'Astrofísica', 0)");
				state.execute("INSERT INTO Candidatos VALUES (2468, 'Penny', 'Actuación', 0)");
				state.execute("INSERT INTO Candidatos VALUES (5678, 'Sheldon Cooper', 'Fisica experimental', 0)");
				
				state.execute("CREATE TABLE Candidatitos (codigo integer, nombre varchar(50), partido varchar(50), votos integer)");
				
				state.execute("INSERT INTO Candidatitos VALUES (1234, 'Leonard Hofstadter', 'Fisica experimental', 0)");
				state.execute("INSERT INTO Candidatitos VALUES  (1479, 'Rajesh Koothappali', 'Astrofísica', 0)");
				state.execute("INSERT INTO Candidatitos VALUES (5678, 'Sheldon Cooper', 'Fisica experimental', 0)");
				
				System.out.println("Creacion de tabla exitosa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
	}

	/**
	 * Se encarga de consultar TODOS los candidatos y retornar un ArrayList de
	 * objetos Candidatos, uno por cada registro presente en la tabla.
	 */
	public ArrayList<Candidato> consultarCandidatos() throws SQLException {
		
		ArrayList<Candidato> respuesta = new ArrayList<Candidato>();
		
		ResultSet consultaCand = state.executeQuery("SELECT * FROM Candidatos");
		
		while(consultaCand.next()){
			
			int cod = consultaCand.getInt(1);
			String nom = consultaCand.getString(2);
			String par = consultaCand.getString(3);
			int vot = consultaCand.getInt(4);
			
			Candidato cand =  new Candidato(cod, nom, par, vot);
			
			respuesta.add(cand);
			
		}
		
		return respuesta;
	}

	/**
	 * Incrementa en 1 (uno) los votos del candidato con el código pasado por
	 * parámetro
	 */
	public void actualizarVotosCandidato(String codigo) throws SQLException {
		
		state.executeUpdate("UPDATE Candidatos SET votos = votos + 1 WHERE codigo = '"+codigo+"'");

	}
	
	public void nuevaFuncion(){
		
		System.out.println("entro al metodo");
		
		try {
			String sql ="SELECT nombre";
			ResultSet resultado = state.executeQuery(sql);
			
			while(resultado.next()){ 
				
				int codigo=resultado.getInt(1);
				String nombre=resultado.getString(2);
				
				System.out.println(codigo+" " +""+nombre);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	/*	try {
			state.executeUpdate("UPDATE Candidatos SET votos = votos + 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	
	

}
