package mundo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
	
	//Relaciones
	
	private Connection conexion;
	private Statement comando;
	
	//Constructor
	
	public DataBase(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://200.3.193.22:3306/P09704_12";
				conexion = DriverManager.getConnection(url,"P09704_12","ARIjk07X");
				comando = conexion.createStatement();
			} catch (Exception e) {
				System.out.println("No se pudo establecer conexion");
			}	
			
			ResultSet rs = null;
			
			try {
				rs = comando.executeQuery("SELECT * FROM usuarios");
			} catch (Exception e) {
				
				System.out.println("no existe tabla de usuarios... creando");
				setUpTables();
			}
	}
	
	public void setUpTables() {
		
		
		try {
			//crea tablas
			comando.execute("CREATE TABLE usuarios (nombre varchar(100) primary key , contrasena varchar(100) not null)");
			comando.execute("CREATE TABLE conectados (  nombre varchar(100) primary key , ip varchar(100) not null ) ");
			System.out.println("se creo tabla satisfactoriamente");
			
			//inserta primer usuario
			
			comando.executeUpdate("INSERT INTO usuarios VALUES ( 'ollicrom93' , '930617' )");
			System.out.println("se inserto satisfactoriamente ollicrom93");
			
		} catch (SQLException e) {
			System.out.println("Error creando tablas");
		}
		
	}
	
	public boolean checkPassword(String nombre, String contrasena){
		
		boolean b = true;
		ResultSet rs = null;
		
		try {
			rs = comando.executeQuery("SELECT * FROM usuarios WHERE nombre = ' "+ nombre +" ' ");
			
			String password = rs.getString(2);
			if(!password.equalsIgnoreCase(contrasena)){
				b = false;
				System.out.println("La contraseña no coincide");
			}
		} catch (Exception e) {
			System.out.println("No se encuetra usuario");
			b = false;
		}
		return b;
	}
	
	public void singInUser(String nombre, String ip){
		
		try {
			comando.executeUpdate("INSERT INTO conectados VALUES ( ' " + nombre + " ' , ' "+ ip +" ' )");	
		} catch (SQLException e) {
			System.out.println("No se pudo registrar usuario");
		}
	}
	
	public void singOutUser(String nombre){
	
		try {
			comando.executeUpdate("DELETE FROM conectados WHERE nombre = ' " + nombre + " ' " );
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar usuario");
		}
	}
	
	public ArrayList <Usuario> getContacs(){
		
		ResultSet rs = null;
		ArrayList <Usuario> list = new ArrayList <Usuario>();
		
		try {
			while(rs.next()){
			
			rs = comando.executeQuery("SELECT * FROM conectados");
			
			String nom = rs.getString(1);
			String i = rs.getString(2);
			
			list.add(new Usuario(nom, i));
			
			}
		} catch (SQLException e) {
			System.out.println("Error creando lista de usuario conectados o no hay ninguno");
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		DataBase nuevo = new DataBase();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite su usuario");
		String respuesta = scan.nextLine();
		System.out.println("Digite su contraseña");
		String respuesta2 = scan.nextLine();
		
		if(nuevo.checkPassword(respuesta, respuesta2)){
			System.out.println("contraseña correcta iniciando sesion...");
			nuevo.singInUser(respuesta, "192.168.0.9");
		}else{
			System.out.println("contraseña incorrecta reinicie aplicacion");
		}
		
		ArrayList <Usuario> list =  nuevo.getContacs();
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println("usuario"+ list.get(i).getNombre()+" conectado");
			
		}
		

	}
	
	

}
