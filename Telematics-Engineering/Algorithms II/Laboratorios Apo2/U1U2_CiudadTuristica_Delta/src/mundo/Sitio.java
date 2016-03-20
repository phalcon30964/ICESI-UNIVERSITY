package mundo;

/**
 * Entidad que modela un sitio turístico
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Sitio {
	
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Constante para modelar la característica de tipo de sitio CULTURAL
     */
	public final static String CULTURAL   = "CULTURAL"; 

	/**
     * Constante para modelar la característica de tipo de sitio ESCENARIOS
     */
	public final static String ESCENARIOS = "ESCENARIOS"; 

	/**
     * Constante para modelar la característica de tipo de sitio COMERCIAL
     */
	public final static String COMERCIAL  = "COMERCIAL";

	/**
     * Constante para modelar la característica de tipo de sitio de INTERÉS
     */
	public final static String INTERES    = "INTERES";
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	/**
	 * El nombre del sitio turístico
	 */
	private String nombre;

	/**
	 * El nombre del archivo de la imagen del sitio
	 */
	private String nombreImagen;

	/**
	 * El tipo de sitio (si es CULTURAL, ESCENARIOS, etc)
	 */
	private String tipoSitio;

	/**
	 * El año en que fue construido el sitio
	 */
	private int anhoConstruccion;

	/**
	 * La direccion del sitio dentro de la ciudad
	 */
	private String direccion;

	/**
	 * La calificacion asignada al sitio de acuerdo con su importancia y su popularidad
	 */
	private int calificacion;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea un sitio con la información básica.
     * @param elNombre es el nombre del nuevo sitio
     * @param elNombreImagen es el nombre del archivo de la imagen del nuevo sitio
     * @param elTipoSitio es el tipo de sitio del nuevo sitio
     * @param elAnhoConstruccion es el año en que fue construido el nuevo sitio
     */
	public Sitio(String elNombre, String elNombreImagen, String elTipoSitio, int elAnhoConstruccion, String laDireccion) {
		nombre = elNombre;
		nombreImagen = elNombreImagen;
		tipoSitio = elTipoSitio;
		anhoConstruccion = elAnhoConstruccion;
		direccion = laDireccion;
		calificacion = 0;
	}
	
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna el nombre del sitio.
     * @return nombre
     */
	public String darNombre() {
		return nombre;
	}
	
    /**
     * Modifica el nombre del sitio por el indicado en el parámetro
     * @param elNombre es el nuevo nombre del sitio
     */
	public void cambiarNombre(String elNombre) {
		nombre = elNombre;
	}
	
    /**
     * Retorna el tipo de sitio.
     * @return tipoSitio
     */
	public String darTipoSitio() {
		return tipoSitio;
	}
	
    /**
     * Modifica el tipo de sitio por el indicado en el parámetro
     * @param elTipoSitio es el nuevo tipo de sitio
     */
	public void cambiarTipoSitio(String elTipoSitio) {
		tipoSitio = elTipoSitio;
	}
	
    /**
     * Retorna el año de construcción del sitio.
     * @return anhoConstruccion
     */
	public int darAnhoConstruccion() {
		return anhoConstruccion;
	}
	
    /**
     * Modifica el año de construcción por el indicado en el parámetro
     * @param elAnhoConstruccion es el nuevo año que se desea asignar
     */
	public void cambiarAnhoConstruccion(int elAnhoConstruccion) {
		anhoConstruccion = elAnhoConstruccion;
	}
	
    /**
     * Retorna la dirección del sitio.
     * @return direccion
     */
	public String darDireccion() {
		return direccion;
	}
	
    /**
     * Modifica la dirección por la indicada en el parámetro
     * @param laDireccion es la nueva dirección del sitio
     */
	public void cambiarDireccion(String laDireccion) {
		direccion = laDireccion;
	}

    /**
     * Retorna el nombre de la imagen del sitio.
     * @return nombreImagen
     */
	public String darNombreImagen() {
		return nombreImagen;
	}

    /**
     * Modifica el el nombre de la imagen por el indicado en el parámetro
     * @param elNombreImagen es el nuevo nombre del archivo de imagen del sitio
     */
	public void cambiarNombreImagen(String elNombreImagen) {
		nombreImagen = elNombreImagen;
	}

    /**
     * Retorna la calificación del sitio.
     * @return calificacion
     */
	public int darCalificacion() {
		return calificacion;
	}

    /**
     * Modifica la calificación por la indicada en el parámetro
     * @param laCalificacion es la nueva calificación del sitio
     */
	public void cambiarCalificacion(int laCalificacion) {
		calificacion = laCalificacion;
	}
}
