package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;


/**
 * Clase que representa el juego de piensa con los pies
 */

public class Juego {
	
	
//-----------------------------------------------------------------
// Constantes
//-----------------------------------------------------------------

	
	/**
     * Número filas y columnas de una matriz pequeña
     */
	public final static int TAM_PEQUENO = 4;
	
	/**
     * Número filas y columnas de una matriz normal
     */
	public final static int TAM_NORMAL = 5;
	
	/**
     * Número filas y columnas de una matriz mediana
     */
	public final static int TAM_MEDIANO = 6;
	
	/**
     * Número filas y columnas de una matriz grande
     */
	public final static int TAM_GRANDE = 7;
	
	/**
     * Número de intentos maximos permitidos
     */
	public final static int INTENTOS_MAXIMOS = 3;
	
	/**
     * Número de intentos minimos con que comienza el juego
     */
	public final static int INTENTOS_MINIMOS = 1;
	

//-----------------------------------------------------------------
// Atributos
//-----------------------------------------------------------------
	
	 /**
	 * Atributo que almacena el numero de intentos actuales
	 */
	private int numIntentos;
	
	 /**
     * Atributo que guarda el puntaje actual del juego
     */
	private int puntajeActual;
	
	 /**
     * Atributo que guarda el tamaño actual de la matriz de cuadros y el tamaño del patron 
     */
	private int tamanoActual;
	
	 /**
     * Atributo que duarda la configuracion de cada matriz segun el nivel y tamaño
     */
	private Properties datos;
	
	/**
     * Matriz de cuadros matriz
     */
	private Cuadro[][] matriz;
	
//-----------------------------------------------------------------
// Constructor
//-----------------------------------------------------------------
	
	 /**
     * Constructor de juego. <br>
     * <br/><b>pre: </b> Se crea un nuevo juego, con intentos en estado minimo, puntaje 0, tamaño pequeño
 	 *  y se inicializa el atributo properties datos.
     */
	public Juego(){
		
		numIntentos = INTENTOS_MINIMOS;
		puntajeActual = 0;
		tamanoActual = TAM_PEQUENO;
		datos = new Properties();
		
	}
	
//-----------------------------------------------------------------
// Métodos
//-----------------------------------------------------------------

   /**
	* Metodo que carga en el atributo datos, la infomarcion proveniente de un objeto File pasado por parametro.
	* 
	*<br/><b>pre: </b>el atributo datos esta declarado
	*<br/><b>pos: </b> el atrubuto datos ha sido inicilizado y cargado con un properties
	*
	*@throws si hay algun error en el formato del archivo no reconocible por java
	*@param: file archivo, file con ruta del archivo a cargar
	*/
	public void cargarInfoJuego(File archivo) throws Exception{
		
		FileInputStream in = new FileInputStream(archivo);
		
		try{
		datos.load(in);
		in.close();
		}catch(Exception e){
			throw new Exception("El archivo es invalido");
		}
	}
	
	
	/**
	 * Metodo que sirve par inicilizar la matriz de casillas matriz, cada vez el tamano actual del juego  cambie 
	 * teniendo en cuenta el numero de intentos.
	 * 
	 *<br/><b>pre: </b> matriz!=null
	 *<br/><b>pros: </b> la matriz ha sido inicializada y sus posiciones tambien. matriz[i][j]!=null
	*/
	public void inicializarMatriz(){
		
		matriz = new Cuadro[tamanoActual][tamanoActual];
		
		for (int i = 0; i < tamanoActual; i++) {
			for (int j = 0; j < tamanoActual; j++) {
				
//				String tam = "";
//				switch(tamanoActual){
//				case 4:
//					tam = "pequena";
//					break;
//				case 5:
//					tam = "normal";
//					break;
//				case 6:
//					tam = "mediana";
//					break;
//				case 7:
//					tam = "grande";
//					break;
//				}
				
				String estaMarcado = datos.getProperty("matriz."+tamanoActual+".intento."+numIntentos+".posicion."+i+"_"+j);
				
				matriz[i][j] = new Cuadro(i, j, estaMarcado, tamanoActual);
				
			}
			
		}
	}
	
	
	/**
	 * Metodo que da el patron de la matriz actual, el patron es una matriz de booleanos boolean[][] que 
	 * contiene en sus posiciones true si esta ocupada o false si esta vacio.
	 * 
	 *<br/><b>pre: </b> matriz!=null 
	 *<br/><b>pre: </b> matriz[i][j]!=null
	 *
	 *@return: boolean[][], una matriz de booleanos que representa el patron de ocupacion de matriz
	 */
	public boolean[][] darPatronMatriz(){
		
		boolean[][] patron = new boolean[tamanoActual][tamanoActual];
		
		for (int i = 0; i < tamanoActual; i++) {
			for (int j = 0; j < tamanoActual; j++) {
				
				if(matriz[i][j].darEstaMarcado().equals(Cuadro.OCUPADO)){
					patron[i][j] = true;
				}else{
					patron[i][j] = false;
				}
			}
		}
		
		return patron;
	}
	
	/**
	 *Metodo que comprueba si el patron dado por parametro es igual al patron original de la matriz juego.
	 *
	 *<br/><b>pre: </b>: la matriz esta inicializada. matriz!=null.
	 *<br/><b>pre: </b>: todas las posiciones de la matriz estan inicializdas. matriz[i][j]!=null.
	 *
	 *@param: boolean[][] a comparar con la matriz juego.
	 *@return: boolean true si son iguales , false si son diferentes.
	 */
	public boolean comprobarPatronMatriz(boolean[][] patronSeleccionado){
		boolean esIgual = true;
		boolean[][] patronOriginal = darPatronMatriz();
		
		for (int i = 0; i < patronSeleccionado.length && esIgual==true; i++) {
			for (int j = 0; j < patronOriginal[0].length && esIgual==true; j++) {
				
				if(patronOriginal[i][j]!=patronSeleccionado[i][j]){
					esIgual = false;
				}
			}
		}	
		return esIgual;
	}
	
	
	/**
	 *El metodo aumenta el puntaje después de una ronda ganada. 
	 *
	 *<br/><b>pre: </b>: la matriz debe estar inicalizada. matriz!=null
	 *<br/><b>pre: </b>: todas las posicones de la matriz deben estar inicializadas. matriz[i][j]!=null
	 *<br/><b>pos: </b>:puntajeActual ha sido aumentado segun el puntajeActual de los cuadros.
	 */
	public void aumentarPuntaje(){
		puntajeActual = matriz[0][0].darPuntajeActual()*tamanoActual;
	}
	
	/**
	 *El metodo aumenta el tamanoActual del juego y la matriz de cuadrados. Además reinicia el numero de intentos.
	 *
	 *<br/><b>pre: </b>:tamanoActual esta inicializado.
	 *<br/><b>pos: </b>:tamanoActial ha sido aumentado y numIntentos reseteado
	 *@throws al ganar el juego
	 */
	public void aumentarTamanoMatriz()throws Exception{
		if(tamanoActual==4){
		tamanoActual = 5;
		}else if(tamanoActual==5){
		tamanoActual = 6;
		}else if(tamanoActual==6){
		tamanoActual = 7;
		}else if(tamanoActual==7){
			throw new Exception("Ganaste!!\n\nTu puntaje final fue:"+puntajeActual);
		}
		resetNumIntentos();
	}
	
	/**
	 *Metodo que disminuye el tamanoActual del juego y la matriz, ademas aumenta el contador de intentos.
	 * 
	 *<br/><b>pre: </b>:tamanoActual esta inicializado
	 *<br/><b>pos: </b>:tamanoActial ha sido disminuido y numIntentos aumentado 1
	 *@throws al perder el juego por numero de intentos
	 */
	public void disminuirTamanoMatriz()throws Exception{
		if(tamanoActual==7){
			tamanoActual = 6;
			}else if(tamanoActual==6){
			tamanoActual = 5;
			}else if(tamanoActual==5){
			tamanoActual = 4;
			}
		
			if(numIntentos==INTENTOS_MAXIMOS){
			throw new Exception("Lo sentimos, se terminaron tus intentos.\n\nTu puntaje final fue:"+puntajeActual);
			}
		numIntentos+= 1;	
	}
	
	/**
	 * Metodo que devuelve el numero de intentos
	 */
	public int darNumIntentos(){
		return numIntentos;
	}
	
	/**
	 * Metodo que devuelve el puntaje actual
	 */
	public int darPuntajeActual(){
		return puntajeActual;
	}
	
	/**
	 * Metodo que devuelve el tamano actual de la matriz de cuadros
	 */
	public int darTamanoActual(){
		return tamanoActual;
	}
	
	/**
	 * Metodo que restablece el tamaño actual a su estado por defecto
	 */
	public void resetTamano(){
		tamanoActual = TAM_PEQUENO ;
	}
	
	/**
	 * Metodo que restablece el numero de intentos a su estado por defecto
	 */
	public void resetNumIntentos(){
		numIntentos = INTENTOS_MINIMOS ;
	}
	
	/**
	 * Metodo que restablece el puntaje actual a su estado por defecto
	 */
	public void resetScore(){
		puntajeActual = 0;
	}
	
	

}
