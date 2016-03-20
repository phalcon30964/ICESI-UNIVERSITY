package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class EntreNubes implements Serializable {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * relacion a la raiz del arbol de ciudades Rutas
	 **/
	private Ciudad raizRutas;
	
	
	public final static String CIUDAD_RAIZ="Cali";

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Constructor de la clase EntreNubes
	 * 
	 * Este metodo se encarga iniciar el mundo por medio de la clase EntreNubes,
	 * crea un objeto de la clase EntreNuebes e iniciliaza la raiz del arbol
	 * rutas con la ciudad ¨Cali¨ por defecto.
	 * 
	 * post: Se ha creado un nuevo objeto de la clase EntreNubes
	 **/
	public EntreNubes() {
		// Inicializacion del arbol con la ciudad cali por defecto
		raizRutas = new Ciudad(null, CIUDAD_RAIZ, "Alfonozo Bonilla Aragon", 0, 0);
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Metodo que se encarga de buscar una ciudad dentro del arbol Ruta de
	 * ciudades
	 * 
	 * @param nomCiudad
	 *            String con el nombre de la ciudad a buscar en el arbol Rutas.
	 *            nomCiudad!=null.
	 * @return la ciudad que tiene el nombre introducido por parametro, sino se
	 *         encontro se retorna null
	 **/
	public Ciudad buscarCiudad(String nomCiudad) {

		return raizRutas.buscarCiudad(nomCiudad);
	}

	/**
	 * Metodo que agrega una nueva ciudad al arbol de ciudades Rutas.
	 * 
	 * pos: Se ha agregado una nueva ciudad al arbol de rutas
	 * 
	 * @param ciudadOrigen
	 *            String con el nombre de la ciudad origen sobre la cual se
	 *            agregará la ciudad con los atributos introducidos por
	 *            parametro
	 * @param nombre
	 *            String con el nombre de la ciudad a agregar
	 * @param aeropuertoLlegada
	 *            nombre del aeropuerto en la ciudad a agregar
	 * @param distanciaVuelo
	 *            int de la distancia en KILOMETROS desde la ciudad origen hasta
	 *            la que se desea agregar
	 * @param tiempoDeVuelo
	 *            int con el tiempo en MINUTOS que se tarda en llegar el avion
	 *            desde la ciudad origen hasta la que deseo agregar
	 * 
	 * @throws rutaException
	 *             si no se puede agregar la ciudad porque ya existe o la ciudad
	 *             de origen es invalida
	 **/
	public void agregarCiudad(String ciudadPadre, String nombre,
			String aeropuertoLlegada, int distanciaVuelo, int tiempoVuelo)
			throws rutaException {

		if (buscarCiudad(nombre) != null) {
			throw new rutaException("La ciudad : " + nombre
					+ " que trata de agregar ya existe");
		} else {

			Ciudad padre = buscarCiudad(ciudadPadre);

			if (padre == null) {
				throw new rutaException("La ciudad padre: " + ciudadPadre
						+ " indicada no existe");
			}
			padre.agregarCiudadHija(nombre, aeropuertoLlegada, distanciaVuelo,
					tiempoVuelo);
		}

	}

	/**
	 * Metodo que elimina una ciudad del arbol de rutas
	 * 
	 * pos: se ha suprimido una ciudad el arbol de rutas
	 * 
	 * @param nCiudad
	 *            String nombre de la ciudad a eliminar del arbol
	 * @throws rutaException
	 *             si la a eliminar no existe
	 */
	public void eliminarCiudad(String nomCiudad) throws rutaException {
		
		Ciudad padre = buscarCiudad(nomCiudad).darCiudadPadre();
		
		if(padre!=null){
			padre.eliminarCiudadHija(nomCiudad);
		}else{
			throw new rutaException("Ciudad invalida de eliminar");
		}
		
	}

	/**
	 * Metodo que calcula la ruta entre una ciudad incial y otra final dentro del arbol
	 * 
	 * 
	 * @param nCiudadInicio ciudad en la que empieza el recorrido
	 * @param nCiudadFin ciudad en la que termina el recorrido
	 * @throws rutaException
	 *             cuando no existe alguna de las ciudades que entran como
	 *             parametro
	 * @return un ArrayList con las ciudades que componen la ruta a seguir entre la ciudad inicio y la final
	 * 
	 */
	public ArrayList<Ciudad> calcularRuta(String nCiudadInicio, String nCiudadFin) throws rutaException {
		
		Ciudad inicio = buscarCiudad(nCiudadInicio);
		Ciudad fin = buscarCiudad(nCiudadFin);
		
		if(inicio==null){
			throw new rutaException("La ciudad de inicio de ruta es invalida");
		}
		
		if(fin==null){
			throw new rutaException("La ciudad de fin de ruta es invalida");
		}
		
		ArrayList<Ciudad> ruta = new ArrayList<Ciudad>();
				
		if(inicio.buscarCiudad(nCiudadFin)!=null){
			fin.calcularRutaHastaCiudad(nCiudadInicio, ruta);	
			Collections.reverse(ruta);
		}else if(fin.buscarCiudad(nCiudadInicio)!=null){
			inicio.calcularRutaHastaCiudad(nCiudadFin, ruta);
		}else{
			ArrayList<Ciudad> tramo1 = new ArrayList<Ciudad>();
			ArrayList<Ciudad> tramo2 = new ArrayList<Ciudad>();
			
			inicio.calcularRutaHastaCiudad(CIUDAD_RAIZ, tramo1);
			fin.calcularRutaHastaCiudad(CIUDAD_RAIZ, tramo2);
			
			//cambio el orden del tramo 2
			Collections.reverse(tramo2);
			//como cali esta repetido en tramo 1 y 2, elimino a cali del tramo 2
			tramo2.remove(0);
			
			ruta.addAll(tramo1);
			ruta.addAll(tramo2);
			
		}
		
		return ruta;
	}

	/**
	 * Metodo que devuelve el aeropuerto de llega en base a una ruta pasada por parametro
	 * 
	 * @param ruta ArrayList de ciudades que tiene la ruta de un vuelo
	 * 
	 * @return String con nombre del aeropuerto de llegada del vuelo
	 */
	public String darAeropuertoLlegadaRuta(ArrayList<Ciudad> ruta) {
				
		return (ruta.get(ruta.size()-1)).darAeropuertoLlegada();
	}
	
	
/**
 * Medoto que devuelve la distancia en km recorrida en una ruta 
 * 
 * @param ruta ArrayList de ciudades que tiene la ruta de un vuelo
 * 
 * @return String con el la distancia recorrida en el vuelo en km
 */
	public String calcularDistancia(ArrayList<Ciudad> ruta) {
		
		int distanciaTotal = 0;
		
		if(ruta.size()==1){
			
			//no haga nada
			
		}else if(ruta.get(ruta.size()-1).darNombre().equals(CIUDAD_RAIZ)){
			
			for (int i = 0; i < ruta.size()-1; i++) {
				
				distanciaTotal+= ruta.get(i).darDistanciaVuelo();
				
			}
			
		}else if(ruta.get(0).darNombre().equals(CIUDAD_RAIZ)){
			
			for (int i = 1; i < ruta.size(); i++) {
				
				distanciaTotal+= ruta.get(i).darDistanciaVuelo();
				
			}
			
		}else{
			
			for (int i = 0; i < ruta.size(); i++) {
			
			distanciaTotal+= ruta.get(i).darDistanciaVuelo();
			
			}
		
		}
		
		return distanciaTotal+ "km";
	}
	
	/**
	 * Metodo que calcula cuanto se tardara en llegar a un ciudad en base a una ruta parametro
	 * 
	 * @param ruta ArrayList de ciudades que tiene la ruta de un vuelo
	 * 
	 * @return String con el tiempo de vuelo de una ruta. 
	 */
	public String calcularTiempo(ArrayList<Ciudad> ruta) {
		
		int duracionTotal = 0;
		
		
		if(ruta.size()==1){
			
			//no haga nada
			
		}else if(ruta.get(ruta.size()-1).darNombre().equals(CIUDAD_RAIZ)){
			
	
			for (int i = 0; i < ruta.size()-1; i++) {
				
				duracionTotal+= ruta.get(i).darTiempoVuelo();
				
				if(i>=2){
					
				duracionTotal+= 60;
						
				}
				
			}
			
			
		}else if(ruta.get(0).darNombre().equals(CIUDAD_RAIZ)){
			
			
			for (int i = 1 ; i < ruta.size(); i++) {
				
				duracionTotal+= ruta.get(i).darTiempoVuelo();
				
				if(i>=2){
					
				duracionTotal+= 60;
						
				}
				
			}
			
			
		}else{
			
			for (int i = 0; i < ruta.size(); i++) {
			
				duracionTotal+= ruta.get(i).darTiempoVuelo();
				
				if(i>=2){
					
				duracionTotal+= 60;
						
				}
			
			}
		
		}
		
		return duracionTotal+ "min";
	}
	
	/**
	 * Metodo que devuelve la lista de nombres de las ciudades en disponibles en la aerolinea
	 * 
	 * @return Lista de nombres
	 */
	public ArrayList<String> darListaDeCiudades(){
		
		ArrayList<String> lista = new ArrayList<String>();
		
		raizRutas.preOrden(lista);
		
		return lista;
		
	}

	/**
	 * Metodo que devuelve la raiz del arbol de ciudades ruta
	 * 
	 * @return ciudad raiz
	 * 
	 */
	public Ciudad darRaizRuta() {
		return raizRutas;
	}
	
	
	
	// -----------------------------------------------------------------
	// Invariante
	// -----------------------------------------------------------------

}
