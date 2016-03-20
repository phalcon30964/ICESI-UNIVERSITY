package mundo;

import java.util.*;

public class MudanzasLaLoma {

	private ArrayList <Cliente> clientes;

	private ArrayList mudanzas;

	public MudanzasLaLoma() {
		clientes = new ArrayList <Cliente>();

		mudanzas = new ArrayList();
	}
	

		/**
	 * Nombre: registrarCliente
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de crear un nuevo cliente y
	 * guardarlo en la contenedora de tamano variable clientes. Este metodo no
	 * maneja excepciones.<br/>
	 * 
	 * <b>pre: </b>La contenedora de clientes est‡ inicializada <br/>
	 * <b>pos: </b> se a–adi— en nuevo cliente a la contenedora de clientes<br/>
	 * 
	 * @param cedula String que contiene el numero de cedula del cliente. cedula != null
	 * @param nombres String que contiene los nombre del cliente.  nombres!= null
	 * @param apellidos String que contiene los apellidos del cliente. apellidos != null
	 * @param edad int que indica la edad en anos del cliente
	 * @throws Exception
	 *             si la edad es un valor inferior a 18 o superior a 100 (es
	 *             decir, 18 < edad < 100)
	 * @throws Exception
	 *             si la cedula dada como parametro ya esta registrada para otro
	 *             cliente
	 * @throws Exception
	 *             si el parametro cedula es una cadena vacia
	 * @throws Exception
	 *             si el parametro nombres es una cadena vacia
	 * @throws Exception
	 *             si el parametro apellidos es una cadena vacia
	 */
	
	public void registrarCliente(String ced, String nom, String ape, int edad)throws Exception{
		
		if(ced.equals("") || nom.equals("") || ape.equals("")){
			throw new Exception(" Introdusca datos para registrar ");
		}
		
		if(edad<18){ 
			throw new Exception("La edad es invalida ");
		}
		
		if(edad>100){
			throw new Exception("La edad es invalida ");
		}
		
		
		if(buscarCliente(ced)!=null){
			throw new Exception(" La cedula introducida ya esta registrada ");
		}
		
		
		
		clientes.add(new Cliente(ced, nom, ape, edad));
		throw new Exception("El cliente fue agregado satisfactoriamente");
	}
	

	/**
	 * Nombre: buscarCliente
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de buscar un cliente dado un
	 * numero de cedula como parametro.<br/>
	 * <b>pre: </b>La contenedora de clientes est‡ inicializada <br/>
	 * 
	 * @param cedula
	 *            - String que contiene el numero de cedula del cliente. cedula!= null, cedula!=""
	 * @return Cliente si encuentra un cliente asociado a la cedula dada como
	 *         parametro, null si no lo encuentra.
	 */
	
	public Cliente buscarCliente(String cedu){
		Cliente respuesta = null;
		
		for(int i= 0; i < clientes.size() && respuesta == null ; i++ ){
			Cliente actual =  clientes.get(i);
			
			if(cedu.equals(actual.darCedula())){
				respuesta = actual;
			}
		}
		
		return respuesta;
	}
	 
	 
	public String consultarCliente(String cedula) {
		Cliente cliente =  buscarCliente(cedula);
		if (cliente == null) {
			return "No se encontro cliente alguno.";
		} else {
			return cliente.toString();
		}
	}

	
 /**
 * Nombre: darNombresMayoresA15Carateres <br/>
 * 
 * <b>Descripcion: </b> Muestra en la pantalla los nombres completos de los clientes los cuales 
 * cumplen con la condición de tener una longitud de sus nombres completos 
 * (nombres + espacio + apellidos) superior a los 15 caracteres y además que contengan al menos
 * 2 caracteres iguales al indicado por el usuario.<br/>
 * 
 * <b>pre: </b>La contenedora de clientes est‡ inicializada <br/>
 * <b>pos: </b> String que muestra los clientes que 
 * cumplen con longitud de nombre mayor a 15.<br/>
 * 
 * @param char caraterIgual caracter instrudido por el usuario para verificar si aparece 
 * en el nombre
 * 
 */
	
	public String darNombresMayoresA15Carateres(char caracterIgual){
		String reporte ="";
		
		for (int i = 0; i < clientes.size(); i++) {
			
			Cliente actual = clientes.get(i);
			String nombre = (actual.darNombres()+" "+actual.darApellidos());
			int numVeces = 0 ;
			
			for (int j = 0; j < nombre.length(); j++) {
				
				if(nombre.charAt(j)==caracterIgual){
					numVeces++;
				}
			}
			
			if(nombre.length()>=15 && numVeces >= 2){
				reporte += nombre + "\n";
			}
		}
		
		return reporte;
	}
	
	public String metodo1(){
		return darNombresMayoresA15Carateres('a');
	}
	public String metodo2(){
		return "salida del reporte 2";
	}
	public String metodo3(){
		return "salida del reporte 3";
	}
}
