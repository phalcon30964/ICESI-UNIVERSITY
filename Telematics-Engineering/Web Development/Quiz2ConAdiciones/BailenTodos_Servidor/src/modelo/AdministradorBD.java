package modelo;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AdministradorBD {

	private Connection conexion;
	private Statement comandos;

	public final static String driver = "com.mysql.jdbc.Driver";
	public final static String urlExterna = "jdbc:mysql://200.3.193.22:3306/P09728_1_3";
	public final static String urlInterna = "jdbc:mysql://172.16.0.105:3306/P09728_1_3";
	public final static String usuario = "P09728_1_3";
	public final static String contrasena = "KA0EuM0V";

	public AdministradorBD() {
		try {
			conexion = GetConnection();
			comandos = conexion.createStatement();
//			borrarTablas();
			inicializarBD();		
		} catch (SQLException e) {
			System.out.println("Hubo un problema creando el canal");
		}
	}

	@SuppressWarnings("finally")
	public Connection GetConnection() {
		Connection conx = null;
		try {
			Class.forName(driver);
			conx = DriverManager.getConnection(urlExterna, usuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conx != null) {
				System.out.println("Conexión a la base de datos realizada correctamente");
			} else {
				System.out.println("Conexión a la base de datos fallida");
			}
			return conx;
		}
	}

	public void inicializarBD() {

		try {
			comandos.executeQuery("SELECT * FROM repertorio");
			System.out.println("Base de datos existente");
		} catch (SQLException e) {
			e.printStackTrace();
			crearTablas();
		}

	}

	public boolean crearTablas() {

		System.out.println("Base de datos no existente, creandose");

		try {

			comandos.execute("CREATE TABLE discos (nombre varchar(30) not null, genero varchar(20) not null,"
					+ "imagen LONGBLOB, disponibles int not null, vendidos int not null, "
					+ "PRIMARY KEY(nombre), CHECK(disponibles > 0))");

			comandos.execute("CREATE TABLE artistas (nombre_natural varchar(30) not null,  nombre_artistico varchar(30) not null, "
					+ "tipoId varchar(10) not null, id int not null, imagen LONGBLOB, direccion_residencia varchar(50),  "
					+ "ciudad_residencia varchar(20), direccion_correspondencia varchar(50),  ciudad_correspondencia varchar(20), "
					+ "telefono_fijo int, numero_contacto int, PRIMARY KEY(nombre_artistico))");

			comandos.execute("CREATE TABLE canciones (nombre varchar(30) not null, duracion int not null, nombre_disco varchar(30) not null"
					+ ", PRIMARY KEY(nombre), FOREIGN KEY(nombre_disco) REFERENCES discos(nombre))");

			comandos.execute("CREATE TABLE canta (nombre_cancion varchar(30) not null,  nombre_artistico varchar(30) not null, PRIMARY KEY(nombre_cancion,nombre_artistico), "
					+ "FOREIGN KEY(nombre_cancion) REFERENCES canciones(nombre), FOREIGN KEY(nombre_artistico) REFERENCES artistas(nombre_artistico))");

			comandos.execute("CREATE TABLE repertorio(nombre_disco varchar(30) not null,  nombre_artistico varchar(30) not null, PRIMARY KEY(nombre_disco,nombre_artistico), "
					+ "FOREIGN KEY(nombre_disco) REFERENCES discos(nombre), FOREIGN KEY(nombre_artistico) REFERENCES artistas(nombre_artistico))");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		System.out.println("Base de datos creada");

		return true;
	}

	public boolean borrarTablas() {

		try {
			comandos.executeUpdate("DROP TABLE canta");
			comandos.executeUpdate("DROP TABLE repertorio");
			comandos.executeUpdate("DROP TABLE canciones");
			comandos.executeUpdate("DROP TABLE discos");
			comandos.executeUpdate("DROP TABLE artistas");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		System.out.println("Se borro la base de datos");
		return true;
	}

	/**
	 * Metodo de la base de datos que permite al mundo registrar artistas 
	 * 
	 * @param nombreCompleto
	 * @param nombreArtistico
	 * @param tipoId
	 * @param id
	 * @param imagen
	 * @param dirresidencia
	 * @param ciudresidencia
	 * @param dirCorrespondencia
	 * @param ciudCorrespondencia
	 * @param telefono
	 * @param numContacto
	 * @return boolean true si se ejecuto bien el registro false sino
	 * 
	 */
	public boolean registrarArtista(String nombreCompleto,
			String nombreArtistico, String tipoId, String id, BufferedImage imagen,
			String dirresidencia, String ciudresidencia,
			String dirCorrespondencia, String ciudCorrespondencia,
			String telefono, String numContacto) {

		try {
			String sql = "INSERT INTO  `P09728_1_3`.`artistas` ("
					+ "`nombre_natural` ," + "`nombre_artistico` ,"
					+ "`tipoId` ," + "`id` ," + "`imagen` ,"
					+ "`direccion_residencia` ," + "`ciudad_residencia` ,"
					+ "`direccion_correspondencia` ,"
					+ "`ciudad_correspondencia` ," + "`telefono_fijo` ,"
					+ "`numero_contacto`)"
					+ "VALUES (?,  ?,  ?,  ?, ? , ? , ? , ? , ? , ?, ?)";

			PreparedStatement ps = conexion.prepareStatement(sql);;
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imagen,"jpg", os); 
			InputStream archivofoto = new ByteArrayInputStream(os.toByteArray());

			ps.setString(1, nombreCompleto);
			ps.setString(2, nombreArtistico);
			ps.setString(3, tipoId);
			ps.setInt(4, Integer.parseInt(id));
			ps.setBinaryStream(5, archivofoto);
			ps.setString(6, dirresidencia);
			ps.setString(7, ciudresidencia);
			ps.setString(8, dirCorrespondencia);
			ps.setString(9, ciudCorrespondencia);
			ps.setInt(10, Integer.parseInt(telefono));
			ps.setInt(11, Integer.parseInt(numContacto));

			if (ps.executeUpdate() > 0) {
				System.out
						.println("Se guardo correctamente el registro de artista");
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo que de la base de datos para registrar discos
	 * @param nombre
	 * @param genero
	 * @param imagen
	 * @param disponibles
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean registraDiscos(String nombre, String genero, BufferedImage imagen, String disponibles) {

		try {
			String sql = "INSERT INTO  `P09728_1_3`.`discos` (`nombre` ,"
					+ "`genero` ,`imagen` , `disponibles`, `vendidos`)"
					+ "VALUES (?,  ?,  ?, ?,  ?)";

			PreparedStatement ps = conexion.prepareStatement(sql);

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imagen,"jpg", os); 
			InputStream archivofoto = new ByteArrayInputStream(os.toByteArray());

			ps.setString(1, nombre);
			ps.setString(2, genero);
			ps.setBinaryStream(3, archivofoto);
			ps.setInt(4, Integer.parseInt(disponibles));
			ps.setInt(5, 0);

			if (ps.executeUpdate() > 0) {
				System.out
						.println("Se guardo correctamente el registro de disco");
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	/**
	 * Metodo que referencia que a un artista de la base de datos como autor principal del disco registrandose
	 * @param nombreDisco
	 * @param artistas
	 * @returnboolean true si fue exitoso el registro false si no
	 */
	public boolean agregarArtistaADisco(String nombreDisco, String artistas) {
		// atristas es un [artista1, artista2,....artistaN]

		// arroja exception sin el artista no existe
		try {

			String[] art = artistas.split(",");
			for (int i = 0; i < art.length; i++) {
				comandos.executeUpdate("INSERT INTO  `P09728_1_3`.`repertorio` VALUES ('"
						+ nombreDisco + "','" + art[i] + "')");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Metodo que registra una cancion en la base de datos
	 * @param nombre
	 * @param duracion
	 * @param nombreDisco
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean registrarCancion(String nombre, String duracion,
			String nombreDisco) {

		// arroja exception sin el artista no existe
		try {
			comandos.executeUpdate("INSERT INTO `P09728_1_3`.`canciones` VALUES ('"
					+ nombre + "','" + duracion + "','" + nombreDisco + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo que registra a un artista existente en la base de datos como artista de una cancion
	 * @param nombreCancion
	 * @param artistas
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean agregarArtistaACancion(String nombreCancion, String artistas) {
		// atristas es un [artista1, artista2,....artistaN]

		// arroja exception sin el artista no existe
		try {

			String[] art = artistas.split(",");
			for (int i = 0; i < art.length; i++) {
				comandos.executeUpdate("INSERT INTO  `P09728_1_3`.`canta` VALUES ('"
						+ nombreCancion + "','" + art[i] + "')");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Metodo que registra la venta de discos en la base de datos 
	 * @param nombreDisco
	 * @param cantidad
	 * @return  boolean true si fue exitoso el registro false si no
	 */
	public boolean venderDisco(String nombreDisco, String cantidad) {

		// estado 1 , disponible, estado 2 vendido.

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT discos.disponibles FROM discos WHERE `P09728_1_3`.`discos`.`nombre` = '"
					+ nombreDisco + "'");
			rs.next();
			int j = rs.getInt(1);
			int k = Integer.parseInt(cantidad);
			
			if((j-k)>=0){
				comandos.executeUpdate("UPDATE `P09728_1_3`.`discos` SET disponibles = disponibles-"+cantidad+", "
						+ "vendidos = vendidos+"+cantidad+" WHERE `P09728_1_3`.`discos`.`nombre` = '"
						+ nombreDisco + "'");
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo que consulta en la base de datos el total de los discos vendidos
	 * @return int discos vendidos
	 */
	public int numeroDeDiscosVendidos() {

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT SUM( discos.vendidos ) FROM discos");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Metodo que consulta en la base de datos el total de los discos disponibles
	 * @return int discos disponibles
	 */
	public int numeroDeDiscosDisponibles() {

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT SUM( discos.disponibles ) FROM discos");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre de parametro
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorNombre(String nombreDisco) {

		ArrayList<Disco> discos = new ArrayList<Disco>();

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT * FROM discos WHERE discos.nombre = '"+ nombreDisco + "'");

			while (rs.next()) {

				String nombre = rs.getString(1);
				String genero = rs.getString(2);
				InputStream binario = rs.getBinaryStream(3);
				int disponibles = rs.getInt(4);
				int vendidos = rs.getInt(5);
				
				BufferedImage img = ImageIO.read(binario);
				ImageIcon imagen = new ImageIcon(img);

				Disco d = new Disco(nombre, genero, imagen, disponibles,vendidos);

				try {
					
					Statement comandoInterno = conexion.createStatement();
					ResultSet rs1 = comandoInterno
							.executeQuery("SELECT canciones.nombre, canciones.duracion FROM canciones WHERE canciones.nombre_disco = '"
									+ nombre + "'");

					while (rs1.next()) {
						String nombreCancion = rs1.getString(1);
						int duracionCancion = rs1.getInt(2);

						Cancion c = new Cancion(nombreCancion, duracionCancion,d);
						d.agregarCancion(c);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El disco no tiene cancines");
				}

				discos.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return discos;
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre de parametro
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorCancion(String nombreCancion) {

		ArrayList<Disco> discos = new ArrayList<Disco>();

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT discos.nombre, discos.genero, discos.imagen, discos.disponibles, discos.vendidos"
							+ " FROM discos,canciones WHERE discos.nombre = canciones.nombre_disco AND canciones.nombre = '"
							+ nombreCancion + "'");

			while (rs.next()) {

				String nombre = rs.getString(1);
				String genero = rs.getString(2);
				InputStream binario = rs.getBinaryStream(3);
				int disponibles = rs.getInt(4);
				int vendidos = rs.getInt(5);


				BufferedImage img = ImageIO.read(binario);
				ImageIcon imagen = new ImageIcon(img);

				Disco d = new Disco(nombre, genero, imagen, disponibles,vendidos);

				try {
					Statement comandoInterno = conexion.createStatement();
					ResultSet rs1 = comandoInterno
							.executeQuery("SELECT canciones.nombre, canciones.duracion FROM canciones WHERE canciones.nombre_disco = '"
									+ nombre + "'");

					while (rs1.next()) {
						String nomCancion = rs1.getString(1);
						int durCancion = rs1.getInt(2);

						Cancion c = new Cancion(nomCancion, durCancion,d);
						d.agregarCancion(c);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El disco no tiene cancines");
				}

				discos.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return discos;
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre del artista
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorArtista(String nombreArtista) {

		ArrayList<Disco> discos = new ArrayList<Disco>();

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT discos.nombre, discos.genero, discos.imagen, discos.disponibles, discos.vendidos FROM discos,repertorio,artistas WHERE discos.nombre = repertorio.nombre_disco AND artistas.nombre_artistico = repertorio.nombre_artistico AND artistas.nombre_artistico = '"+nombreArtista+"'");

			while (rs.next()) {

				String nombre = rs.getString(1);
				String genero = rs.getString(2);
				InputStream binario = rs.getBinaryStream(3);
				int disponibles = rs.getInt(4);
				int vendidos = rs.getInt(5);


				BufferedImage img = ImageIO.read(binario);
				ImageIcon imagen = new ImageIcon(img);
			

				Disco d = new Disco(nombre, genero, imagen, disponibles,vendidos);

				try {
					Statement comandoInterno = conexion.createStatement();
					ResultSet rs1 = comandoInterno
							.executeQuery("SELECT canciones.nombre, canciones.duracion FROM canciones WHERE canciones.nombre_disco = '"
									+ nombre + "'");

					while (rs1.next()) {
						String nomCancion = rs1.getString(1);
						int durCancion = rs1.getInt(2);

						Cancion c = new Cancion(nomCancion, durCancion,d);
						d.agregarCancion(c);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El disco no tiene cancines");
				}

				discos.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return discos;
	}
	/**
	 * Metodo que consulta el nombre todos los discos de la base de datos
	 * @return ArrayList con el nombre de todos los discos
	 */
	public ArrayList<String> consultarDiscos() {
		
		ArrayList<String> m = new ArrayList<String>();
		
		try {
			ResultSet rs = comandos.executeQuery("SELECT discos.nombre FROM discos");
			
			while(rs.next()){
				m.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	/**
	 * Metodo que consulta el nombre todos los artistas de la base de datos
	 * @return ArrayList con el nombre de todos los artistas
	 */
	public ArrayList<String> consultarArtistas() {
		
		ArrayList<String> m = new ArrayList<String>();
		
		try {
			ResultSet rs = comandos.executeQuery("SELECT artistas.nombre_artistico FROM artistas");
			
			while(rs.next()){
				m.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el genero por parametro
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorGenero(String gen) {

		ArrayList<Disco> discos = new ArrayList<Disco>();

		try {
			ResultSet rs = comandos
					.executeQuery("SELECT * FROM discos WHERE discos.genero = '"+gen+"'");

			while (rs.next()) {

				String nombre = rs.getString(1);
				String genero = rs.getString(2);
				InputStream binario = rs.getBinaryStream(3);
				int disponibles = rs.getInt(4);
				int vendidos = rs.getInt(5);


				BufferedImage img = ImageIO.read(binario);
				ImageIcon imagen = new ImageIcon(img);

				Disco d = new Disco(nombre, genero, imagen, disponibles,vendidos);

				try {
					Statement comandoInterno = conexion.createStatement();
					ResultSet rs1 = comandoInterno
							.executeQuery("SELECT canciones.nombre, canciones.duracion FROM canciones WHERE canciones.nombre_disco = '"
									+ nombre + "'");

					while (rs1.next()) {
						String nomCancion = rs1.getString(1);
						int durCancion = rs1.getInt(2);

						Cancion c = new Cancion(nomCancion, durCancion,d);
						d.agregarCancion(c);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El disco no tiene cancines");
				}

				discos.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return discos;
	}
	/**
	 * Meotdo elabora un array con la estadistica de discos vendidos y disponibles en inventario de un disco
	 * @return arraylist
	 */
	public ArrayList<String> estadisticaPorDisco (){
		
		ArrayList<String> o = new ArrayList<String>();
		
		try {
			ResultSet rs = comandos
					.executeQuery("SELECT discos.nombre, discos.vendidos, discos.disponibles FROM discos");
			
			while(rs.next()){
			o.add("Copias vendidas:"+rs.getString(2)+"          Copias disponibles:"+rs.getString(3)+"          Disco:"+rs.getString(1).toUpperCase());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	public ImageIcon consultarFoto(String nombreArtista){
		
		try {
			ResultSet rs = comandos
					.executeQuery("SELECT artistas.imagen FROM artistas WHERE artistas.nombre_artistico = '"+nombreArtista+"'");
			
			rs.next();
			
			InputStream binario = rs.getBinaryStream(1);
			BufferedImage img = ImageIO.read(binario);
			ImageIcon imagen = new ImageIcon(img);
			
			return imagen;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ImageIcon consultarCaratula(String nombreDisco){
		
		try {
			ResultSet rs = comandos
					.executeQuery("SELECT discos.imagen FROM discos WHERE discos.nombre = '"+nombreDisco+"'");
			
			rs.next();
			
			InputStream binario = rs.getBinaryStream(1);
			BufferedImage img = ImageIO.read(binario);
			ImageIcon imagen = new ImageIcon(img);
			
			return imagen;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
