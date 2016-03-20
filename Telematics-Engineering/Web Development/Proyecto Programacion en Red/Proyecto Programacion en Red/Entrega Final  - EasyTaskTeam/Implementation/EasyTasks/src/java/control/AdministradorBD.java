package control;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import modelo.Tarea;



public class AdministradorBD {
	
	private static Connection conexion;
	private static Statement comandos;
	
	public final static String driver = "com.mysql.jdbc.Driver";
	public final static String urlExterna = "jdbc:mysql://200.3.193.22:3306/P09728_1_3";
	public final static String urlInterna = "jdbc:mysql://172.16.0.105:3306/P09728_1_3";
	public final static String usuario = "P09728_1_3";
	public final static String contrasena = "KA0EuM0V";
	
	public AdministradorBD() {
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
                    + "FOREIGN KEY (`nombreTarea`) REFERENCES `Tareas` (`nombreTarea`), "
                    + "FOREIGN KEY (  `nombreUsuario` ) REFERENCES `Usuarios` (  `nombreUsuario` )"
                    + ")");

            comandos.execute("CREATE TABLE IF NOT EXISTS `Etiquetas` ("
                    + "`nombreTag` VARCHAR(20) NOT NULL,"
                    + "`nombreTarea` VARCHAR(50) NOT NULL,"
                    + "`nombreUsuario` VARCHAR( 30 ) NOT NULL,"
                    + "PRIMARY KEY (`nombreTag`,`nombreTarea`,`nombreUsuario`),"
                    + "FOREIGN KEY (`nombreTag`) REFERENCES `Tags` (`nombreTag`),"
                    + "FOREIGN KEY (`nombreTarea`) REFERENCES `Tareas` (`nombreTarea`), "
                    + "FOREIGN KEY (`nombreUsuario` ) REFERENCES `Usuarios` (  `nombreUsuario` ))");
            
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
                String[] email2={email};
          
                AdminEmail.generateAndSendEmail(email2,"Bienvenido a EasyTasks", "Su cuenta ha sido creada existosamente.\nSu usuario: "+nombreUsuario+"\nSu contraseña: "+contrasena);
                
                crearCategoria("Trabajo", nombreUsuario);
                crearCategoria("Estudio", nombreUsuario);
                crearCategoria("Personal", nombreUsuario);

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Usuario ya existe");
                return false;
            }
		
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
                        + "SELECT Usuarios.email "
                        + "FROM Usuarios "
                        + "WHERE Usuarios.nombreUsuario = '"+nombreUsuario+"'"
                        );
                
                if(rs.next()){
                    String mail = rs.getString(1);
                    
                    Random rand = new Random();
                    int nuevaContraseña = rand.nextInt(100000);
                
                    comandos.executeUpdate("UPDATE `Usuarios` SET contrasena = '"+nuevaContraseña+"' WHERE `nombreUsuario` = '"+nombreUsuario+"' ");
                
                    String[] email={mail};
                    
                    AdminEmail.generateAndSendEmail(email,"Contraseña nueva", nombreUsuario+" se ha restablecido su contraseña, su nueva contraseña es: "+nuevaContraseña);
                
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
                 agregarClasificacionATarea(nombreCategoria, nombreTarea, nombreUsuario);
                 
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
        
        public static boolean agregarClasificacionATarea(String nombreCategoria,String nombreTarea,String nombreUsuario){
            try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("INSERT INTO `Clasificaciones` VALUES ('"+nombreCategoria+"','"+nombreTarea+"','"+nombreUsuario+"')");

                comandos.close();
                
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
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
                comandos.executeUpdate(""
                        + "DELETE FROM Etiquetas "
                        + "WHERE nombreTarea = '"+nombreTarea+"' "
                        + "AND nombreUsuario = '"+nombreUsuario+"'");
                comandos.executeUpdate(""
                        + "DELETE FROM Clasificaciones  "
                        + "WHERE nombreTarea = '"+nombreTarea+"' "
                        + "AND nombreUsuario = '"+nombreUsuario+"'");
                comandos.executeUpdate(""
                        + "DELETE FROM Tareas "
                        + "WHERE nombreTarea = '"+nombreTarea+"' "
                        + "AND nombreUsuario = '"+nombreUsuario+"'");

                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	}
	//Lo unico que no se puede cambiar de la tarea es el nombre, ni los tags, ni la categoria, 
        //si desea cambiar el nombre debe borrar y construir denuevo la tarea
	public static boolean modificarTarea(String descripcion, String fechaLimite, int prioridad,
			double ubicacionLatitud, double ubicacionLongitud, String nombreTarea, String nombreUsuario){
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
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
		
	}
	
//	public boolean cambiarPrioridadTarea(String nombreTarea, String fecha, int nuevaPrioridad, String nombreUsuario){
//             try {
//                comandos = conexion.createStatement();
//                
//                comandos.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//		return false;
//	}
	
	public static boolean cambiarCategoriaTarea(String viejaCategoria,  String nuevaCategoria, String nombreTarea, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                //le cambio la asociacion a la tarea actualizando su relacion en las clasificaciones por la nueva categoria
                comandos.executeUpdate("UPDATE `Clasificaciones` SET nombreCategoria = '"+nuevaCategoria+"' "
                        + "WHERE nombreTarea = '"+nombreTarea+"' "
                        + "AND nombreCategoria = '"+viejaCategoria+"'"
                        + "AND nombreUsuario = '"+nombreUsuario+"'");
                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
		
	}
	
	public static boolean crearCategoria(String nombreCategoria, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.executeUpdate("INSERT IGNORE INTO `Categoria` VALUES ('"+nombreCategoria+"')");
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
                
                comandos.executeUpdate("INSERT IGNORE INTO `Tags` VALUES ('"+nombreTag+"')");
                comandos.executeUpdate("INSERT IGNORE INTO `RelacionTags` VALUES ('"+nombreUsuario+"','"+nombreTag+"')");
                
                comandos.close();
                
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
	}
        
	
	public static boolean eliminarCategoria(String nombreCategoria, String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                //borrar la categoria del usuario , borrarla de relacioncategoria.
                comandos.executeUpdate(""
                        + "DELETE FROM RelacionCategoria "
                        + "WHERE nombreCategoria = '"+nombreCategoria+"' "
                        + "AND nombreUsuario = '"+nombreUsuario+"'");
                
                //borrar la categoria de las tareas que este con ella , borrarla de clasificaciones
                comandos.executeUpdate(""
                        + "DELETE FROM Clasificaciones "
                        + "WHERE nombreCategoria = '"+nombreCategoria+"' "
                        + "AND nombreUsuario = '"+nombreUsuario+"'");
                
                //borrar la categoria de la tabla de categorias
                comandos.executeUpdate(""
                        + "DELETE FROM Categoria "
                        + "WHERE nombreCategoria = '"+nombreCategoria+"'"
                        );
                comandos.close();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
		
	}
	
//	public boolean modificarCategoria(String nombre,String nuevoNombre, String nombreUsuario){
//             try {
//                comandos = conexion.createStatement();
//                
//                comandos.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//		return false;
//	}
	//0 de mayor a menor
        //1 de prioridad 1
        //2 prioridad 2
        //
//        public ArrayList<Disco> consultarDiscoPorGenero(String gen) {
//
//		ArrayList<Disco> discos = new ArrayList<Disco>();
//
//		try {
//			ResultSet rs = comandos
//					.executeQuery("SELECT * FROM discos WHERE discos.genero = '"+gen+"'");
//
//			while (rs.next()) {
//
//				String nombre = rs.getString(1);
//				String genero = rs.getString(2);
//				InputStream binario = rs.getBinaryStream(3);
//				int disponibles = rs.getInt(4);
//				int vendidos = rs.getInt(5);
//
//
//				BufferedImage img = ImageIO.read(binario);
//				ImageIcon imagen = new ImageIcon(img);
//
//				Disco d = new Disco(nombre, genero, imagen, disponibles,vendidos);
//
//				try {
//					Statement comandoInterno = conexion.createStatement();
//					ResultSet rs1 = comandoInterno
//							.executeQuery("SELECT canciones.nombre, canciones.duracion FROM canciones WHERE canciones.nombre_disco = '"
//									+ nombre + "'");
//
//					while (rs1.next()) {
//						String nomCancion = rs1.getString(1);
//						int durCancion = rs1.getInt(2);
//
//						Cancion c = new Cancion(nomCancion, durCancion,d);
//						d.agregarCancion(c);
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("El disco no tiene cancines");
//				}
//
//				discos.add(d);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return discos;
//	}
        
        public static ArrayList<Tarea> getTareasDeRS(ResultSet rs, String nombreUsuario) throws SQLException{
        
            ArrayList<Tarea> tareas = new ArrayList<Tarea>();

            while (rs.next()) {
                     
                     String nombre = rs.getString(1);
                     String descripcion = rs.getString(2);
                     Timestamp fechaLimite = rs.getTimestamp(3);
                     int prioridadT = rs.getInt(4);
                     double ubiLongitud = rs.getDouble(5);
                     double ubiLatitud = rs.getDouble(6);
                     

			Statement comandoInterno1 = conexion.createStatement();
			ResultSet rs1 = comandoInterno1.executeQuery(""
                                + "SELECT Etiquetas.nombreTag "
                                + "FROM Etiquetas "
                                + "WHERE Etiquetas.nombreTarea = '"+nombre+"' "
                                + "AND Etiquetas.nombreUsuario = '"+nombreUsuario+"'"
                                );
                        
                        ArrayList<String> tags = new ArrayList<String>();
                        
			while (rs1.next()) {
			String tag = rs1.getString(1);
			tags.add(tag);
			}
                        
                                Statement comandoInterno2 = conexion.createStatement();
                                ResultSet rs2 = comandoInterno2.executeQuery(""
                                        + "SELECT Clasificaciones.nombreCategoria "
                                        + "FROM Clasificaciones "
                                        + "WHERE Clasificaciones.nombreTarea = '"+nombre+"' "
                                        + "AND Clasificaciones.nombreUsuario = '"+nombreUsuario+"'");

                                String categoria = "";
                                
                                if(rs2.next()){
                                 rs2.getString(1);
                                }
                                
                         Tarea  t = new Tarea(nombre, descripcion, fechaLimite, prioridadT, ubiLongitud, ubiLatitud, tags, categoria);
                         tareas.add(t);
                     }
            return tareas;
        }
        
	public static ArrayList<Tarea> getTareasPorPrioridad(String nombreUsuario, int prioridad){
            
            ArrayList<Tarea> tareas = new ArrayList<Tarea>();
             try {
                comandos = conexion.createStatement();
                
                if(prioridad ==0 || prioridad ==1 || prioridad == 2 || prioridad == 3){
                
                    ResultSet rs = comandos.executeQuery(""
                            + "SELECT * "
                            + "FROM  `Tareas` "
                            + "WHERE Tareas.nombreUsuario = '"+nombreUsuario+"' "
                            + "AND Tareas.prioridad = '"+prioridad+"'");

                    tareas = getTareasDeRS(rs, nombreUsuario);
                    
                }else if(prioridad == -1){

                    ResultSet rs = comandos.executeQuery(""
                            + "SELECT * "
                            + "FROM  `Tareas` "
                            + "WHERE Tareas.nombreUsuario = '"+nombreUsuario+"' "
                            + "ORDER BY Tareas.prioridad DESC");

                    tareas = getTareasDeRS(rs, nombreUsuario);
                }

                comandos.close();
                return tareas;
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
	}
	
	public static ArrayList<Tarea> getTareasPorFechaLimite(String nombreUsuario){
            
            ArrayList<Tarea> tareas = new ArrayList<Tarea>();

             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery(""
                        + "SELECT * "
                        + "FROM  `Tareas` "
                        + "WHERE Tareas.nombreUsuario = '"+nombreUsuario+"' "
                        + "ORDER BY Tareas.fechaLimite DESC");

                tareas = getTareasDeRS(rs, nombreUsuario);
                
                comandos.close();
                return tareas;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
	}

	public static ArrayList<Tarea> getTareasPorNombre(String nombreUsuario){
            
             ArrayList<Tarea> tareas = new ArrayList<Tarea>();

             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery(""
                        + "SELECT * "
                        + "FROM  `Tareas` "
                        + "WHERE Tareas.nombreUsuario = '"+nombreUsuario+"' "
                        + "ORDER BY Tareas.nombreTarea ASC");

                tareas = getTareasDeRS(rs, nombreUsuario);
                
                comandos.close();
                return tareas;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
	}
        
        public static boolean existeCategoria(){
            try {
                comandos = conexion.createStatement();
                //ResultSet rs = comandos.executeQuery("SELECT RelacionCategoria FROM RelacionCategoria.nombre WHERE RelacionCategoria.nombre");

                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
            return false;
            
        }
	
	public static ArrayList<Tarea> getTareasPorPorCategoria(String categoria, String nombreUsuario){
             ArrayList<Tarea> tareas = new ArrayList<Tarea>();

             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery(""
                        + "SELECT `Tareas`.nombreTarea` ,Tareas.`descripcion` , Tareas.`fechaLimite` ,Tareas.`prioridad` ,Tareas.`ubiLongitud` ,Tareas.`ubiLatitud`"
                        + "FROM  `Tareas`, `Clasificaciones` "
                        + "WHERE Tareas.nombreUsuario = '"+nombreUsuario+"' "
                        + "AND Clasificaciones.nombreCategoria ='"+categoria+"'"
                        + "AND Tareas.nombreUsuario=Clasificaciones.nombreUsuario"
                        + "ORDER BY Tareas.nombreTarea ASC");

                tareas = getTareasDeRS(rs, nombreUsuario);
                
                comandos.close();
                return tareas;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
	}
	
	public static String getTareasSemana(String nombreUsuario){
             try {
                comandos = conexion.createStatement();
                
                comandos.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		return null;
	}
	
	public static ArrayList<String> getCategoriasDisponibles(String nombreUsuario){
            
            ArrayList<String> categoiras = new ArrayList<String>();

             try {
                comandos = conexion.createStatement();
                
                ResultSet rs = comandos.executeQuery(""
                        + "SELECT RelacionCategoria.nombreCategoria "
                        + "FROM  `RelacionCategoria` "
                        + "WHERE RelacionCategoria.nombreUsuario = '"+nombreUsuario+"' ");
                
                 while (rs.next()) {
                     
                     String categoria = rs.getString(1);
                     categoiras.add(categoria);
                 }
                 
                comandos.close();
                return categoiras;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
	}
	

}
