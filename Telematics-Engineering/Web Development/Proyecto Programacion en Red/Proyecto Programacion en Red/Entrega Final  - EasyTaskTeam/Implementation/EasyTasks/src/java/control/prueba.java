/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.AdminPDF;
import control.AdministradorBD;
import java.util.ArrayList;
import modelo.Tarea;

/**
 *
 * @author CL
 */
public class prueba {

	public static void main(String[] args) {


		String usuario = "123456789400ss22";
		String contrasena = "12346789400422";

		if(AdministradorBD.getConnection()){
			System.out.println("se conectó a la base de datos");
		}else{
			System.out.println("Fallo algo al conectarse");
		}

		if(AdministradorBD.registrarUsuario(usuario, contrasena, "delgado.diego.e@gmail.com")){
			System.out.println("Se registró bien usuario");
		}else{
			System.out.println("Fallo algo al registrar usuario");
		}

		if(AdministradorBD.iniciarSesion(usuario, contrasena)){   
			System.out.println("Verificacion existosa");
		}else{
			System.out.println("Fallo algo al iniciar sesion");
		}

		if(AdministradorBD.restablecerContrasena(usuario)){
			System.out.println("Se restablecio contraseña");
		}else{
			System.out.println("Hubo un problema");
		}

		if(AdministradorBD.crearCategoria("PEREZA", usuario)){
			System.out.println("Creacion de categoria existosa");
		}else{
			System.out.println("Fallo la creacion de categoria");
		}

		if(AdministradorBD.crearTarea("a", "b", "2008-02-05 18:12:54", 1, 12345, 12345, "pereza,estudiar", "PEREZA", usuario)){
			System.out.println("Se creo bien la tarea");
		}else{
			System.out.println("No se creo la tarea");
		}

		if(AdministradorBD.crearTarea("b", "b", "2008-02-05 18:12:54", 1, 12345, 12345, "pereza,estudiar", "PEREZA", usuario)){
			System.out.println("Se creo bien la tarea");
		}else{
			System.out.println("No se creo la tarea");
		}

		if(AdministradorBD.crearTarea("c", "b", "2008-02-05 18:12:54", 1, 12345, 12345, "pereza,estudiar", "PEREZA", usuario)){
			System.out.println("Se creo bien la tarea");
		}else{
			System.out.println("No se creo la tarea");
		}

//		if(AdministradorBD.eliminarCategoria("PEREZA", usuario)){
//			System.out.println("Se elimino bien la categoria");
//		}else{
//			System.out.println("No se elimino bien la categoria");
//		}
//
//		if(AdministradorBD.eliminarTarea("a", usuario)){
//			System.out.println("Se elimino la tarea");
//		}else{
//			System.out.println("No se elimino la tarea");
//		}
		
		if(AdministradorBD.getTareasPorNombre(usuario)!=null){
			System.out.println("Consulto");
			ArrayList<Tarea> tareas= AdministradorBD.getTareasPorNombre(usuario);
			AdminPDF.generarInforme(tareas, usuario);
			System.out.println("Genero");
		}else{
			System.out.println("No genero");
		} 
                
                ArrayList<Tarea> o = AdministradorBD.getTareasPorNombre(usuario);
		if(o!=null){
			System.out.println("Se consultó bien base de datos");

			for (int i = 0; i < o.size(); i++) {
				Tarea get = o.get(i);
				System.out.println(get.getNombre());
			}

		}else{
			System.out.println("Fallo consulta base de datos");
		}

		ArrayList<String> o1 = AdministradorBD.getCategoriasDisponibles(usuario);
		if(o1!=null){
			System.out.println("Se consultó bien base de datos");

			for (int i = 0; i < o1.size(); i++) {
				String get = o1.get(i);
				System.out.println(get);
			}

		}else{
			System.out.println("Fallo consulta base de datos");
		}
		
		
	}

}
