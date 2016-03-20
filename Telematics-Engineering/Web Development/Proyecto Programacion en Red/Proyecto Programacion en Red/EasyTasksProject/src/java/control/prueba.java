/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author CL
 */
public class prueba {
    
    
    
    public static void main(String[] args) {
		if(AdminBD.getConnection()){
                    System.out.println("se conectó a la base de datos");
                }else{
                    System.out.println("Fallo algo al conectarse");
                }
                
                if(AdminBD.registrarUsuario("usuario4", "contrasena4", "usuario@mail.com3")){
                    System.out.println("se registró bien usuario");
                }else{
                    System.out.println("Fallo algo al registrar usuario");
                }
                
                if(AdminBD.iniciarSesion("usuario4", "contrasena4")){   
                    System.out.println("Verificacion existosa");
                }else{
                    System.out.println("Fallo algo al iniciar sesion");
                }
               
                if(AdminBD.crearCategoria("ESTUDIO", "usuario4")){
                    System.out.println("Creacion de categoria existosa");
                }else{
                    System.out.println("Fallo la creacion de categoria");
                }

                if(AdminBD.crearTarea("a", "b", "2008-02-05 18:12:54", 1, 12345, 12345, "pereza,estudiar", "ESTUDIO", "usuario4")){
                    System.out.println("Se creo bien la tarea");
                }else{
                    System.out.println("No se creo la tarea");
                }
                
                if(AdminBD.eliminarTarea("a", "usuario4")){
                    System.out.println("Se elimino la tarea");
                }else{
                    System.out.println("No se elimino la tarea");
                } 
                
    }
    
}
