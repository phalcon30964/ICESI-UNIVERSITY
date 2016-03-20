package mundo;

/**
 * Clase que representa un cuadro de la matriz del juego
 */
public class Cuadro {
	
	
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	
	/**
     * estaMarcado estado ocupado
     */
	public final static String OCUPADO = "OCUPADO";
	
	/**
     * estaMarcado estado no ocupado
     */
	public final static String NO_OCUPADO = "NO_OCUPADO";
	
	/**
     * tipos de puntajes de cuadro según el nivel
     */
	public final static int PUNTAJE_PEQUENO = 10;
	public final static int	PUNTAJE_NORMAL = 12;
	public final static int	PUNTAJE_MEDIANO = 15;
	public final static int PUNTAJE_GRANDE = 20;
	
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
     * Posicion en x
     */
	private int posX;
	
	/**
     * Posicion en y
     */
	private int posY;
	
	/**
     * Marca de si esta seleccionado un cuadro
     */
	private String estaMarcado;
	
	/**
     * Puntaje del cuadro segun el nivel
     */
	private int puntajeActual;

    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
	
	/**
     * Constructor de cuadro. <br>
     * <b>post: </b> todos los atributos han sido inicializados.
     */
	public Cuadro(int laPosX, int laPosY, String siEstaMarcado, int tamanoActual){
		
		posX = laPosX;
		posY = laPosY;
		estaMarcado = siEstaMarcado;
		
		switch(tamanoActual){
		case 4:
			puntajeActual = PUNTAJE_PEQUENO;
			break;
		case 5:
			puntajeActual = PUNTAJE_NORMAL;
			break;
		case 6:
			puntajeActual = PUNTAJE_MEDIANO;
			break;
		case 7:
			puntajeActual = PUNTAJE_GRANDE;
			break;
		}
		
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	
	/**
	 * Metodo que devuelve la posicion en X
	 */
	public int darPosx(){
		return posX;
	}
	
	/**
	 * Metodo que devuelve la posicion en Y
	 */
	public int darposY(){
		return posY;
	}
	
	/**
	 * Metodo que devuelve si esta marcado el cuadro
	 */
	public String darEstaMarcado(){
		return estaMarcado;
	}
	
	/**
	 * Metodo que devuelve el puntaje actual
	 */
	public int darPuntajeActual(){
		return puntajeActual;
	}

}
