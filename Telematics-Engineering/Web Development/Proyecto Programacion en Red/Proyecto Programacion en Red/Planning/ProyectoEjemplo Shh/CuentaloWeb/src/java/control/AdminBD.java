package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminBD {

    public static Connection conexion;
    public static Statement sentencia;

    public AdminBD() {
    }

    public static void iniciarConexionConBd() {
        String usuario = "P09639_1_7";
        String contrasena = "ChmiWhqg";
        String nombreConector = "oracle.jdbc.OracleDriver";
        String ipInterna = "172.16.0.103";
        String ipExterna = "200.3.193.24";
        String puerto = "1522";
        String nombreBD = "P09639_1_7";
        String urlInterna = "jdbc:oracle:thin:" + usuario + "/" + contrasena
                + "@" + ipInterna + ":" + puerto + ":ESTUD";
        String urlExterna = "jdbc:oracle:thin:" + usuario + "/" + contrasena
                + "@" + ipExterna + ":" + puerto + ":ESTUD";
        try {
            Class.forName(nombreConector);
            Connection conexion = DriverManager.getConnection(urlInterna);
            sentencia = conexion.createStatement();
            System.out.println("Conexion a la BD Oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    
    public static String creacionIDaleatorioCuento(String clasificacion,
			String fechaDeCreacion, String titulo) {
		String[] splitteado = fechaDeCreacion.split("/");
		String retorno = splitteado[0] + "@" + clasificacion.charAt(0) + "@"
				+ splitteado[1] + "@" + titulo.charAt(0) + "@" + splitteado[2];
		/*
		 * ejemplo input = educacion, 23/09/2013, luna caliente --------- output
		 * = 23@e@09@l@2013
		 */
		return retorno;
	}
    
    public static boolean buscarUsuario(String usuario, String contrasena, String tipoUsuario) {
        boolean registrado = false;
        String sql = "SELECT contrasena FROM Clientes WHERE idCliente = '" + usuario + "' AND tipo ='" + tipoUsuario + "'";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                String pass = resultado.getString(1);
                if (pass.equalsIgnoreCase(contrasena)) {
                    registrado = true;
                }
            }
            resultado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Esta registrado?: " + registrado);
        return registrado;
    }

    public static boolean registrar(String tipo, String nombre, String apellido, String direccion, String telefono, String fechaNacimiento, String email, String contrasena) throws SQLException {
        boolean registrado = false;
        if (!(AdminBD.buscarUsuario(email, contrasena, tipo))) {
            String sql = "INSERT INTO Clientes VALUES ('" + email + "','" + tipo + "','" + nombre + "','" + apellido + "','" + direccion + "','" + telefono + "','" + fechaNacimiento + "','" + contrasena + "','" + "0" + "' )";
            try {
                sentencia.executeUpdate(sql);
                registrado = true;
                System.out.println("Quedo registrado? " + registrado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return registrado;
    }

    
    
    public static boolean registrarCuentoEnConcurso(String idCuento, int idConcurso) throws SQLException {
        boolean registrado = false;
     
            String sql = "INSERT INTO cuentosyconcursos VALUES ('" + idCuento + "','" + idConcurso + "')";
            try {
                sentencia.executeUpdate(sql);
                registrado = true;
                System.out.println("Quedo registrado? " + registrado);
            } catch (Exception e) {
                e.printStackTrace();
            }
     
       return registrado;
    }
    
    
    
    
    public static ArrayList<String> darConcursosAbiertos() throws SQLException {
        ArrayList<String> concursos = new ArrayList<String>();
        String sql = "SELECT idConcurso, nombre FROM Concursos WHERE estado = 'Abierto'";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                String idConcurso = resultado.getString(1);
                String nombre = resultado.getString(2);
                concursos.add(idConcurso + "-" + nombre);
            }
            resultado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concursos;
    }

    public static ArrayList<String> darConcursosCerrados()
            throws SQLException {
        ArrayList<String> concursos = new ArrayList<String>();
        String sql = "SELECT idConcurso, nombre FROM Concursos WHERE estado = 'Cerrado'";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                String idConcurso = resultado.getString(1);
                String nombre = resultado.getString(2);
                concursos.add(idConcurso + "-" + nombre);
            }
            resultado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concursos;
    }

    public static ArrayList<String> darCuentos(int idConcurso)
            throws SQLException {
        ArrayList<String> concursos = new ArrayList<String>();
        String sql = "SELECT cuentosyconcursos.idCuento, Cuentos.titulo, Cuentos.autor FROM cuentosyconcursos, Cuentos WHERE cuentosyconcursos.idConcurso ='" + idConcurso + "' AND Cuentos.idCuento = cuentosyconcursos.idCuento";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                String idCuento = resultado.getString(1);
                String tituloCuento = resultado.getString(2);
                String autorCuento = resultado.getString(3);
                concursos.add(idCuento + "-" + tituloCuento + "-" + autorCuento);
                System.out.println("Agregado");
            }
            resultado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concursos;
    }

    public static boolean consultarCuento(String idNotificacion) {
        boolean registrado = false;
        String sql = "SELECT * FROM Cuentos WHERE IDCUENTO = '"
                + idNotificacion + "'";
        try {

            ResultSet resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                registrado = true;

            }
            resultado.close();
            System.out.println("Esta registrado - cuentos - : "
                    + idNotificacion + "?..." + registrado);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error en BD -consulta cuentos-");
        }
        return registrado;
    }

    public static boolean registrarCuento(String idCuento, String titulo,
            String autor, String clasificacion, String fechaDeCreacion) {
        boolean retorno = false;
        boolean yaExiste = AdminBD.consultarCuento(idCuento);
        System.out.println(yaExiste);
        if (!yaExiste) {
            try {
                String sql = "INSERT INTO Cuentos VALUES('" + idCuento + "','"
                        + titulo + "','" + autor + "','" + clasificacion
                        + "','" + fechaDeCreacion + "')";

                System.out.println("antes de execute");
                sentencia.execute(sql);
                System.out.println("este es el resulset");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error en registro de cuentos");
            }
            System.out.println("Registrado");
            retorno = true;
        }
        return retorno;
    }

    public static String verificarEstadocuento(String idCuento) {
        String retorno = "";
        String sql = "SELECT DISTINCT Concursos.estado "
                + "FROM cuentosyconcursos, concursos, cuentos "
                + "WHERE cuentosyconcursos.idconcurso=concursos.idconcurso AND cuentosyconcursos.idcuento='" + idCuento + "'";
        ResultSet resultado;
        try {
            resultado = sentencia.executeQuery(sql);
            if (resultado.next()) {
                retorno = resultado.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static ArrayList<String> darPaginasCuento(String idCuento)
            throws SQLException {
        ArrayList<String> paginas = new ArrayList<String>();
        String sql = "SELECT CONTENIDO FROM paginas WHERE idcuento = '" + idCuento + "'";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                String pagina = resultado.getString(1);
                paginas.add(pagina + "--------");
            }
            resultado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginas;
    }

    public static int contarConcursos() {
        int cantidadConcursos = 0;
        String sql = "SELECT COUNT(idConcurso) FROM Concursos";
        try {
            ResultSet resultado = sentencia.executeQuery(sql);
            resultado.next();
            cantidadConcursos = resultado.getInt(1);
            System.out.println("La cantidad de concursos es: " + cantidadConcursos);
            resultado.close();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("Problema al traer un mensaje de la BD");
            e1.printStackTrace();
        }
        return cantidadConcursos;
    }

    public static boolean crearConcurso(String nombre, String fechaApertura, String fechaCierreInscripciones, String fechaCierreConcurso, String tematica, String clasificacion, String estado, String minimoLetras, String maximoLetras) throws SQLException {
        boolean creado = false;
        int idConcurso = AdminBD.contarConcursos() + 1;
        String sql = "INSERT INTO Concursos VALUES ('" + "" + idConcurso + "','" + nombre + "','" + fechaApertura + "','" + fechaCierreInscripciones + "','" + fechaCierreConcurso + "','" + tematica + "','" + clasificacion + "','" + estado + "','" + minimoLetras + "','" + maximoLetras + "')";
        try {
            sentencia.executeUpdate(sql);
            creado = true;
            System.out.println("Quedo registrado? " + creado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return creado;
    }

    public static boolean consultarPagina(String numPagina, String idCuento) {
		boolean registrado = false;
		String sql = "SELECT * FROM Paginas WHERE IDPAGINA = '"
				+ (numPagina + "-" + idCuento) + "'";
		try {

			ResultSet resultado = sentencia.executeQuery(sql);
			if (resultado.next()) {
				registrado = true;

			}
			resultado.close();
			System.out.println("Esta registrado - paginas - : "
					+ (numPagina + "-" + idCuento) + "?..." + registrado);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error en BD -consulta paginas-");
		}
		return registrado;
	}

    
    
    public static boolean registrarPagina(String numPagina, String contenido,
			String idCuento) {
		boolean retorno = false;
		boolean yaExiste = AdminBD.consultarPagina(numPagina, idCuento);
		System.out.println(yaExiste);
		if (!yaExiste) {
			try {
				System.out.println(idCuento);
				String sql = "INSERT INTO Paginas VALUES('"
						+ (numPagina + "-" + idCuento) + "','" + numPagina
						+ "','" + contenido + "','" + idCuento + "')";

				System.out.println("antes de execute");
				sentencia.execute(sql);
				System.out.println("este es el resulset");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en registro de paginas");
			}
			System.out.println("Registrado");
			retorno = true;
		}
		return retorno;
	}

    public static void aumentarPuntajeEn(int valor, String idUser) {
        String sqlconsultarCalificacion = "SELECT calificacion FROM clientes WHERE idCliente='"
                + idUser + "'";
        int valorDeCalificacionEnTabla = 0;
        ResultSet resultado;
        try {
            resultado = sentencia.executeQuery(sqlconsultarCalificacion);
            if (resultado.next()) {
                valorDeCalificacionEnTabla = Integer
                        .parseInt((String) resultado.getString(1));
            }
            valorDeCalificacionEnTabla += valor;
            String sqlModificarCalificacion = "UPDATE clientes SET calificacion='"
                    + valorDeCalificacionEnTabla
                    + "' WHERE idcliente='"
                    + idUser + "'";
            sentencia.execute(sqlModificarCalificacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void desconectarBD() {
        try {
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            AdminBD.iniciarConexionConBd();
            darCuentos(1);
        } catch (SQLException ex) {
            Logger.getLogger(AdminBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
