package mundo;

import java.util.*;

public class MudanzasLaLoma {

	private ArrayList<Cliente> clientes;

	private ArrayList<Mudanza> mudanzas;

	public MudanzasLaLoma() {
		clientes = new ArrayList<Cliente>(); 
		mudanzas = new ArrayList<Mudanza>();
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
	public void registrarCliente(String cedula, String nombres,
			String apellidos, int edad) throws Exception {
		if (edad < 18 || edad > 100) {
			throw new Exception("La edad no esta en el rango permitido");
		}
		if (cedula.equals("")) {
			throw new Exception("La cedula no puede ser vacia");
		}
		if (nombres.equals("")) {
			throw new Exception("Los nombres no pueden ser vacios");
		}
		if (apellidos.equals("")) {
			throw new Exception("Los apellidos no pueden ser vacios");
		}
		if ( buscarCliente(cedula) != null) {
			throw new Exception("Ya existe un cliente con esa misma cedula");
		}

		 clientes.add(new Cliente(cedula, nombres, apellidos, edad));
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
	public Cliente buscarCliente(String cedula) {
		for (int i = 0; i <  clientes.size(); i++) {
			Cliente cliente = (Cliente)  clientes.get(i);
			if (cliente.darCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}

	/**
	 * Nombre: consultarCliente
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de buscar un cliente dado un
	 * numero de cedula como parametro y dar su informacion personal en una
	 * cadena. (Cedula: Nombres Apellidos)
	 * <b>pre: </b>La contenedora de clientes est‡ inicializada <br/>
	 * @param cedula
	 *            - String que contiene el numero de cedula del cliente. cedula!= null, cedula!=""
	 * @return String con los datos personales del cliente si lo encuentra, o la cadena "No se encontr— cliente alguno" 
	 * en el caso contrario.
	 */
	public String consultarCliente(String cedula) {
		Cliente cliente =  buscarCliente(cedula);
		if (cliente == null) {
			return "No se encontro cliente alguno.";
		} else {
			return cliente.toString();
		}
	}

	/**
	 * Nombre: buscarMudanzaSinTerminarPorCliente
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de verificar si un cliente
	 * identificado por una cedula dada (entrada) tiene registradas en el sistema 
	 * mudanzas en estado NO Realizado.
	 * <b>pre: </b>Las contenedora de  mudanzas esta inicializada <br/>
	 * @param cedulaCliente
	 *            - String que contiene el numero de cedula del cliente. cedulaCliente es un numero de cedula que ya existe en la
	 *            aplicacion
	 * @return boolean - true si se encuentra alguna mudanza registrada para el
	 *         cliente identificado con la cedula dada como parametro y con estado No realizado.  false en el caso contrario
	 */
	
	public boolean buscarMudanzaSinTerminarPorCliente(String cedulaCliente){
		boolean respuesta = false;
		
		for(int i = 0; i< mudanzas.size() && respuesta == false; i++){
			Mudanza actual = mudanzas.get(i);
			
			if(actual.darRealizado() == false && actual.darCliente().darCedula().equals(cedulaCliente)){
				respuesta = true;
			}
			 
		}
		
		return respuesta;
	}

	
	
	
	/**
	 * Nombre: registrarMudanza
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de crear una nueva mudanza y
	 * guardarla en la contenedora de tamano variable mudanzas. La mudanza se
	 * crea y se guarda en la contenedora UNICAMENTE SI el cliente tiene todas sus otras
	 * mudanzas en estado realizado, o si no tiene mudanzas previas registradas.
	 * Este metodo no maneja excepciones.
	 * 
	 * <b>pre: </b>Las contenedoras de clientes y mudanzas est‡n inicializadas <br/>
	 * <b>pos: </b> se a–adi— una nueva mudanza a la contenedora de mudanzas<br/>
	 * @param cedulaCliente
	 *            - String que contiene el numero de cedula del cliente. cedulaCliente es un numero de cedula que ya existe en la
	 *            aplicacion
	 * @param direccionSalida
	 *            - String que contiene la direccion desde donde sale el
	 *            trasteo.  direccionSalida != null
	 * @param direccionLlegada
	 *            - String que contiene la direccion donde llega el trasteo.
	 *             direccionLlegada != null
	 * 
	 * @return mudanza de clase Mudanza siempre y cuando el proceso de registro de la mudanza termina con
	 *         exito, null en caso contrario.
	 * 
	 * @throws Exception
	 *             si la direccion de salida o de llegada no contiene al menos un símbolo de numeral (#).
	 *             el mensaje que se envía al crear la excepción debe indicar cual dirección (si la de salida
	 *              o la de llegada) es a la que le falta el #.
	 */

public Mudanza registrarMudanza(String cedulaCliente, String dirSalida, String dirLlegada)throws Exception{
	Mudanza respuesta = null; 
	boolean dirSBien = false;
	boolean dirLBien = false;
	
	for (int i = 0; i < dirSalida.length() && dirSBien == false ; i++) {
		
		if(dirSalida.charAt(i)=='#'){
			dirSBien = true;
		}
		
	}
		
	for (int j = 0; j < dirLlegada.length() && dirLBien == false ; j++){
			
		if(dirLlegada.charAt(j)=='#'){
				dirLBien = true;
		}
		
	}
		
	if(dirSBien == false){
		throw new Exception("La direccion de salido no tiene simbolo de #");
	}
	
	if(dirLBien == false){
		throw new Exception("La direccion de llegada no tiene simbolo de #");
	}
	
	Cliente cliente = buscarCliente(cedulaCliente);
		
	if(buscarMudanzaSinTerminarPorCliente(cedulaCliente) == false || cliente == null){
		mudanzas.add(new Mudanza(cliente, dirSalida, dirLlegada));
		}
	
	return respuesta;
}
	
	
	/**
	 * Nombre: buscarMudanza
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de buscar una mudanza dado un
	 * numero consecutivo como parametro
	 * <b>pre: </b>Las contenedora de  mudanzas esta inicializada <br/>
	 * 
	 * @param consecutivo
	 *            - int que representa el numero consecutivo de la mudanza.
	 * @return Mudanza si encuentra una mudanza asociada al entero dado como
	 *         parametro, null si no la encuentra.
	 * 
	 * @throws Exception
	 *             si el entero dado como parametro es inferior a 1.
	 */
	public Mudanza buscarMudanza(int numero) throws Exception {
		if (numero < 1) {
			throw new Exception(
					"El numero consecutivo no puede ser inferior a 1");
		}

		for (int i = 0; i <  mudanzas.size(); i++) {
			Mudanza mudanza = (Mudanza)  mudanzas.get(i);
			if (mudanza.darNumero() == numero) {
				return mudanza;
			}
		}
		return null;
	}

	public String metodo1(){
		return "salida del reporte 1";
	}
	
	public String metodo2(int cantidadAnhos){
		return "salida del reporte 2\nUsted ha digitado: "+cantidadAnhos;
	}
	
	public String metodo3(){
		return "salida del reporte 3";
	}
}
