package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Ciudad clase nodo sobre la que se implementa el arbol Rutas
 * 
 * inv:
 * 
 * No pueden existir dos ciudades con el mismo nombre
 * 
 * nombre!=null; aeropuertoLlegada!= null; distanciaVuelo != 0; tiempoVuelo !=
 * 0; ciudadesHijas!= null;
 */
public class Ciudad implements Serializable{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * nombre de la ciudad padre en el arbol
	 **/
	private Ciudad ciudadPadre;

	/**
	 * nombre de la ciudad
	 **/
	private String nombre;

	/**
	 * nombre del aeropuerto de la ciudad
	 **/
	private String aeropuertoLlegada;

	/**
	 * distancia en kilometros desde la ciudad origen hasta la ciudad
	 **/
	private int distanciaVuelo;

	/**
	 * tiempo en minutos que tarda un vuelo en llegar desde la ciudad origen
	 **/
	private int tiempoVuelo;

	/**
	 * nombre de la ciudad
	 **/
	private ArrayList<Ciudad> ciudadesHijas;
	
	

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Constructor de la clase ciudad
	 * 
	 * Inicializa los atributos nombre, aeropuerLlegada, distanciaVuelo y
	 * tiempoVuelo. Crea un objecto de la clase Ciudad
	 * 
	 * <br/>
	 * <b>pos: </b> Se ha creado un nuevo objeto de la clase Ciudad
	 * 
	 * @param nombre
	 *            String que contiene el nombre de la ciudad.
	 * @param aeropuertoLlegada
	 *            String que contiene el aeropuerto al cual se llega.
	 * @param distanciaVuelo
	 *            int que contiene la distancia que hay de una ciudad a otra en
	 *            kilometros.
	 * @param tiempoVuelo
	 *            int que contiene la duracion de un vuelo respecto a otro en
	 *            min.
	 * 
	 */
	public Ciudad(Ciudad ciudadPadre, String nombre, String aeropuertoLlegada,
			int distanciaVuelo, int tiempoVuelo) {

		this.ciudadPadre = ciudadPadre;
		this.nombre = nombre;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.distanciaVuelo = distanciaVuelo;
		this.tiempoVuelo = tiempoVuelo;
		this.ciudadesHijas = new ArrayList<Ciudad>();

		verificarInvariante();
	}

	// -----------------------------------------------------------------
	// Métodos dar()
	// -----------------------------------------------------------------

	/**
	 * Metodo que devuelve la ciudad padre de la ciudad
	 * 
	 * @return String con el nombre de la ciudad
	 */
	public Ciudad darCiudadPadre() {
		return this.ciudadPadre;
	}

	/**
	 * Metodo que devuelve el nombre de la ciudad
	 * 
	 * @return String con el nombre de la ciudad
	 */
	public String darNombre() {
		return this.nombre;
	}

	/**
	 * Metodo que devuelve el nombre del aeropuerto de LLegada
	 * 
	 * @return String con el nombre del aeropuerto
	 */
	public String darAeropuertoLlegada() {
		return this.aeropuertoLlegada;
	}

	/**
	 * Metodo que devuelve la distancia que hay de una ciudad a otra en
	 * kilometros
	 * 
	 * @return String con la distancia entre dos ciudades.
	 */
	public int darDistanciaVuelo() {
		return this.distanciaVuelo;
	}

	/**
	 * Metodo que devuelve el tiempo que dura un vuelo
	 * 
	 * @return String con el tiempo que dura el vuelo
	 */
	public int darTiempoVuelo() {
		return this.tiempoVuelo;
	}

	/**
	 * Metodo que devuelve una coleccion de ciudades
	 * 
	 * @return ArrayList con todas las ciudades
	 */

	public ArrayList<Ciudad> darCiudadesHijas() {

		return this.ciudadesHijas;

	}

	// -----------------------------------------------------------------
	// Métodos funcionales
	// -----------------------------------------------------------------

	/**
	 * Metodo encargado de agregar ciudades al arraylist de ciudadeshijas
	 * 
	 * @param nombre
	 *            String con el nombre de la nueva ciudad !nombre.equals("") &&
	 *            nombre!= null
	 * @param aeropuertoLlegada
	 *            String con el nombre de el aeropuerto de la ciudad
	 * @param distanciaVuelo
	 *            int con la distancia que existe entre dos ciudades
	 * @param tiempVuelo
	 *            int con el tiempo que dura el vuelo
	 * 
	 * @throws rutaException
	 *             si ya existe la ciudad en la lista de hijas
	 */
	public void agregarCiudadHija(String nombre, String aeropuertoLlegada,
			int distanciaVuelo, int tiempoVuelo) throws rutaException {

		if (buscarCiudad(nombre) != null) {
			throw new rutaException(
					"la ciudad que intenta agregar ya existe en el arraylist de hijas");
		}

		Ciudad nueva = new Ciudad(this, nombre, aeropuertoLlegada,
				distanciaVuelo, tiempoVuelo);

		ciudadesHijas.add(nueva);

	}

	/**
	 * Metodo encargado de buscar una ciudad respecto al nombre en la coleccion
	 * de ciudades
	 * 
	 * @param nomCiudad
	 *            String con el nombre de la ciudad que se desea buscar
	 * @return una ciudad
	 */
	public Ciudad buscarCiudad(String nomCiudad) {

		if (this.nombre.equalsIgnoreCase(nomCiudad)) {
			return this;

		} else {

			for (int i = 0; i < ciudadesHijas.size(); i++) {

				Ciudad hija = ciudadesHijas.get(i);

				Ciudad temp = hija.buscarCiudad(nomCiudad);

				if (temp != null) {

					return temp;
				}

			}

			return null;
		}

	}

	/**
	 * Metodo que permite eliminar una ciudad de la coleccion de ciudades.
	 * 
	 * @param nombreCiudad
	 *            String con el nombre de la ciudad que se desea eliminar
	 * @throws rutaException
	 *             lanza excepcion si la ciudad a eliminar no es eliminable
	 */
	public void eliminarCiudadHija(String nomCiudad) throws rutaException {

		for (int i = 0; i < ciudadesHijas.size(); i++) {

			Ciudad hija = ciudadesHijas.get(i);

			if (hija.darNombre().equalsIgnoreCase(nomCiudad)) {

				if (hija.esHoja()) {

					ciudadesHijas.remove(i);

					return;

				} else {
					throw new rutaException(
							"Ciudad no es eliminable porque desde esta ciudad se llega a otras");
				}

			}

		}

	}

	/**
	 * Indica si este nodo es una hoja
	 * 
	 * @return true si este nodo es una hoja y false en caso contrario
	 */

	public boolean esHoja() {
		return ciudadesHijas.size() == 0;
		
	}
	
	/**
	 * Metodo que calcula ruta desde una ciudad actual hasta la ciudad final  introducida por parametro
	 * 
	 * pos: el arraylist introducido por parametro fue modificado con las ciudades que componen la ruta
	 * 
	 * @param nombreCiudadFinal String con el nombre de la ciudad final hasta donde llega la ruta. nombreCiudadFinal != null
	 * @param lista ArrayList a modificar por acumulacion de parametros
	 */
	public void calcularRutaHastaCiudad(String nombreCiudadFinal, ArrayList lista){
		
		if(nombre.equalsIgnoreCase(nombreCiudadFinal)){
			lista.add(this);
			return;
			
		}else{
			
			lista.add(this);
			
			if(ciudadPadre!=null){
			ciudadPadre.calcularRutaHastaCiudad(nombreCiudadFinal, lista);
			}
		}
		
	}
	

	/**
	 * Metodo que devuelve una lista de todas las ciudades ordenadas en preorden
	 * 
	 * @param lista parametrica a acumular las ciudades del arbol
	 * @return lista que contiene todas las ciudades del arbol
	 */
	public void preOrden(ArrayList<String> lista) {

		lista.add(nombre);
		
		for (int i = 0; i < ciudadesHijas.size(); i++) {
			
			Ciudad otraCiudad = ciudadesHijas.get(i);
			
			otraCiudad.preOrden(lista);
			
		}
		
	}
	
	// -----------------------------------------------------------------
	// 	Invariante
	// -----------------------------------------------------------------
	
	/**
	 * Verifica el invariante de la clase. <br>
	 * <b>inv:</b> <br>
	 * nombre != null.
	 */
	
	public void verificarInvariante() {

		assert nombre != null;
		assert aeropuertoLlegada != null;
		assert distanciaVuelo != 0;
		assert tiempoVuelo != 0;
		assert ciudadesHijas != null;

	}

}
