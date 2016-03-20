package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;



public class AdminBD {
	
	private static Connection conexion;
	private static Statement comandos;
	
	public final static String driver = "com.mysql.jdbc.Driver";
	public final static String urlExterna = "jdbc:mysql://200.3.193.22:3306/P09728_1_3";
	public final static String urlInterna = "jdbc:mysql://172.16.0.105:3306/P09728_1_3";
	public final static String usuario = "P09728_1_3";
	public final static String contrasena = "KA0EuM0V";
	
	public AdminBD() {
		getConnection();
	}
	
	@SuppressWarnings("finally")
	public static boolean getConnection(){
			try {
				Class.forName(driver);
				conexion =   DriverManager.getConnection(urlInterna,usuario,contrasena);
                                verificarTablas();
			} catch (Exception e) {
                                System.out.println("Error al conectar a la base de datos, se reintentará con diferente ip");
                            try {
                                Class.forName(driver);
				conexion =   DriverManager.getConnection(urlExterna,usuario,contrasena);
                                verificarTablas();
                            } catch (Exception i) {
                                i.printStackTrace();
                                System.out.println("Error al conectar a la base de datos, se reintentó con diferente ip y problema persiste");
                            }
			}finally{
				if(conexion!=null)
				{
					System.out.println("Conexión a la base de datos realizada correctamente");
                                        return true;
				}else{
					System.out.println("Conexión a la base de datos fallida");
                                        return false;
				}
			}	
	}
        
        public static void verificarTablas(){

            try {

            comandos = conexion.createStatement();

            comandos.execute("CREATE TABLE IF NOT EXISTS `Usuarios` ("
                    + "`nombreUsuario` VARCHAR(30) NOT NULL,"
                    + "`contrasena` VARCHAR(30) NOT NULL,"
                    + "`email` VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (`nombreUsuario`)"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Categoria` ("
                    + "`nombreCategoria` VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (`nombreCategoria`)"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Tags` ("
                    + "`nombreTag` VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (`nombreTag`)"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Tareas`("
                    + "`nombreTarea` VARCHAR( 50 ) NOT NULL,"
                    + "`descripcion` VARCHAR( 100 ) NOT NULL ,"
                    + "`fechaLimite` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
                    + "`prioridad` INT NOT NULL ,"
                    + "`ubiLongitud` DOUBLE,"
                    + "`ubiLatitud` DOUBLE,"
                    + "`nombreUsuario` VARCHAR( 30 ) NOT NULL,"
                    + "PRIMARY KEY (  `nombreTarea`,`nombreUsuario`),"
                    + "FOREIGN KEY (  `nombreUsuario` ) REFERENCES `Usuarios` (  `nombreUsuario` )"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Clasificaciones` ("
                    + "`nombreCategoria` VARCHAR(20) NOT NULL,"
                    + "`nombreTarea` VARCHAR(50) NOT NULL,"
                    + "`nombreUsuario` VARCHAR( 30 ) NOT NULL,"
                    + "PRIMARY KEY (`nombreCategoria`,`nombreTarea`,`nombreUsuario`),"
                    + "FOREIGN KEY (`nombreCategoria`) REFERENCES `Categoria` (`nombreCategoria`),"
                    + "FOREIGN KEY (`nombreTarea`,`nombreUsuario`) REFERENCES `Tareas` (`nombreTarea`,`nombreUsuario`)"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Etiquetas` ("
                    + "`nombreTag` VARCHAR(20) NOT NULL,"
                    + "`nombreTarea` VARCHAR(50) NOT NULL,"
                    + "PRIMARY KEY (`nombreTag`,`nombreTarea`),"
                    + "FOREIGN KEY (`nombreTarea`) REFERENCES `Tareas` (`nombreTarea`),"
                    + "FOREIGN KEY (`nombreTag`) REFERENCES `Tags` (`nombreTag`)"
                    + ")");
            
            comandos.execute("CREATE TABLE IF NOT EXISTS `RelacionTags` ("
                    + "`nombreUsuario` VARCHAR(30) NOT NULL,"
                    + "`nombreTag` VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (`nombreUsuario`,`nombreTag`),"
                    + "FOREIGN KEY (`nombreUsuario`) REFERENCES `Usuarios` (`nombreUsuario`),"
                    + "FOREIGN KEY (`nombreTag`) REFERENCES `Tags` (`nombreTag`)"
                    + ")");
            
            comandos.execute("CREATE TABLE IF NOT EXISTS `RelacionCategoria` ("
                    + "`nombreUsuario` VARCHAR(30) NOT NULL,"
                    + "`nombreCategoria` VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (`nombreUsuario`,`nombreCategoria`)"
                    + ",FOREIGN KEY (`nombreUsuario`) REFERENCES `Usuarios` (`nombreUsuario`),"
                    + "FOREIGN KEY (`nombreCategoria`) REFERENCES `Categoria` (`nombreCategoria`)"
                    + ")");
            
            comandos.close();

            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
        
        public static boolean registrarUsuario(String nombreUsuario, String contrasena, String email){
            try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("INSERT INTO `Usuarios` VALUES ('"+ nombreUsuario + "','" + contrasena + "','" + email +"')");
             
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Usuario ya existe");
                return false;
            }
		return true;
	}
        
        public static boolean iniciarSesion(String nombreUsuario, String contrasena){
            
             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery("SELECT Usuarios.nombreUsuario, Usuarios.contrasena "
                        + "FROM Usuarios "
                        + "WHERE Usuarios.nombreUsuario = '"+nombreUsuario+"' "
                        + "AND Usuarios.contrasena = '"+contrasena+"'"
                        );

                if(rs.next()){
                    comandos.close();
                    return true;
                }else{
                    comandos.close();
                    System.out.println("Usuario o contraseña invalidos");
                    return false;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	
	}
        
        public static boolean restablecerContrasena(String nombreUsuario){
            
             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery(""
                        + "SELECT Usuarios.mail "
                        + "FROM Usuarios"
                        + "WHERE Usuarios.nombreUsuario = '"+nombreUsuario+"'"
                        );
                
                if(rs.next()){
                    String mail = rs.getString(1);
                    
                    Random rand = new Random();
                    int nuevaContraseña = rand.nextInt(100000);
                
                    comandos.executeUpdate("UPDATE `Usuarios` SET contrasena = '"+nuevaContraseña+"' WHERE `nombreUsuario` = '"+nombreUsuario+"' ");
                
                    AdminEmail.generateAndSendEmail(mail,"Contraseña nueva", nombreUsuario+" se ha restablecido su contraseña, su nueva contraseña es: "+nuevaContraseña);
                
                    comandos.close();
                    return true;
                }else{
                    System.out.println("Error, no existe usuario");
                    return false;
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error consultando la base de datos");
                return false;
            }
		
	}

        //tags se separan por ,
        public static boolean crearTarea(String nombreTarea, String descripcion, String fechaLimite, int prioridad, 
			double ubicacionLatitud, double ubicacionLongitud, String tags, String nombreCategoria, 
			String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                //agrego tarea 
                comandos.executeUpdate("INSERT INTO `Tareas` VALUES ('"+nombreTarea+"','"+descripcion+"','"+fechaLimite+"','"+prioridad+"','"+ubicacionLongitud+"','"+ubicacionLongitud+"','"+nombreUsuario+"')");
                //como la categoria ya debe estar agregada, agrega la clasificacion a la tarea
                comandos.executeUpdate("INSERT INTO `Clasificaciones` VALUES ('"+nombreCategoria+"','"+nombreTarea+"','"+nombreUsuario+"')");
                
                String[] nombreTag = tags.split(",");
                
                 for (int i = 0; i < nombreTag.length; i++) {
                    //crea los tags sino existen
                    crearTag(nombreTag[i], nombreUsuario);
                    //los agrega a la tarea
                    agregarTagATarea(nombreTag[i],nombreTarea,nombreUsuario);
                 }

                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("La categoria no existe o la tarea ya existe");
                return false;
            }	
	}
        
        public static boolean agregarTagATarea(String nombreTag,String nombreTarea,String nombreUsuario){
            try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("INSERT INTO `Etiquetas` VALUES ('"+nombreTag+"','"+nombreTarea+"','"+nombreUsuario+"')");

                comandos.close();
                
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
	
	public static boolean eliminarTarea(String nombreTarea, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                comandos.executeUpdate("DELETE FROM Etiquetas WHERE nombreTarea = '"+nombreTarea+"' AND nombreUsuario = '"+nombreUsuario+"'");
                comandos.executeUpdate("DELETE FROM Clasificaciones  WHERE nombreTarea = '"+nombreTarea+"' AND nombreUsuario = '"+nombreUsuario+"'");
                comandos.executeUpdate("DELETE FROM Tareas WHERE nombreTarea = '"+nombreTarea+"' AND nombreUsuario = '"+nombreUsuario+"'");

                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	}
	//Lo unico que no se puede cambiar de la tarea es el nombre, ni los tags, ni la categoria, 
        //si desea cambiar el nombre debe borrar y construir denuevo la tarea
	public boolean modificarTarea(String nombreTarea, String descripcion, String fechaLimite, int prioridad,
			double ubicacionLatitud, double ubicacionLongitud, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate(""
                        + "UPDATE Tareas "
                        + "descripcion = '"+descripcion+"', "
                        + "fechaLimite = "+fechaLimite+", "
                        + "prioridad =  "+prioridad+", "
                        + "ubilongitud = "+ubicacionLongitud+", "
                        + "ubiLatitud = "+ubicacionLatitud+" "
                        + "WHERE nombreUsuario = '"+nombreUsuario+"' "
                        + "AND nombreTarea = '"+nombreTarea+"'"
                        );

                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return false;
	}
	
	public boolean cambiarPrioridadTarea(String nombre, String fecha, int nuevaPrioridad, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return false;
	}
	
	public boolean cambiarCategoriaTarea(String nombre, String fecha, String nuevaCategoria, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return false;
	}
	
	public static boolean crearCategoria(String nombreCategoria, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("INSERT INTO `Categoria` VALUES ('"+nombreCategoria+"')");
                comandos.executeUpdate("INSERT INTO `RelacionCategoria` VALUES ('"+nombreUsuario+"','"+nombreCategoria+"')");

                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	}
        
        public static boolean crearTag(String nombreTag, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("REPLACE INTO `Tags` VALUES ('"+nombreTag+"')");
                comandos.executeUpdate("REPLACE INTO `RelacionTags` VALUES ('"+nombreUsuario+"','"+nombreTag+"')");
                
                comandos.close();
                
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	}
        
       
	
	public boolean eliminarCategoria(String nombre, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return false;
	}
	
	public boolean modificarCategoria(String nombre,String nuevoNombre, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return false;
	}
	//0 de mayor a menor
        //1 de prioridad 1
        //2 prioridad 2
        //
	public String getTareasPorPrioridad(String nombreUsuario, int prioridad){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public String getTareasPorFechaLimite(String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public String getTareasPorNombre(String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public String getTareasPorPorCategoria(String categoria, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public String getTareasSemana(String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public String getCategoriasDisponibles(String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public boolean agregarTagsTarea(String nombreTarea, String fecha, String tag, String nombreUsuario){
            try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
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
