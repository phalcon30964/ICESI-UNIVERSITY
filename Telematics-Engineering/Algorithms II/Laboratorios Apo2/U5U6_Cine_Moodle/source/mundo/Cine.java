/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - 13-Sep-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package mundo;

import java.util.*;
import java.io.*;



/**
 * Clase que representa una sala de cine
 */
public class Cine
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Número de filas en general
     */
    public static final int FILAS_GENERAL = 8;

    /**
     * Número de filas en preferencial. Comienza en la siguiente en donde termina general
     */
    public static final int FILAS_PREFERENCIAL = 3;

    /**
     * Número de sillas por fila
     */
    public static final int SILLAS_POR_FILA = 20;
    
    public static final int TOTAL_FILAS= 11;
    public static final int TOTAL_COLUMNAS= 20;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Matriz de sillas del cine
     */
    private Silla[][] sillas;
    private Pelicula pelicula;


    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------

    /**
     * Constructor de la sala de cine. <br>
     * <b>post: </b> Se crea un nuevo cine, con todas las sillas disponibles, sin reservas.
     */
    public Cine( )
    {
        sillas = new Silla[TOTAL_FILAS][TOTAL_COLUMNAS];
        pelicula = null;
        
		for (int i = 0; i < TOTAL_FILAS; i++) {
			for (int j = 0; j < TOTAL_COLUMNAS; j++) {
				char letraSilla= darLetra(i);
				int numSilla= j;
				String tipoSilla= darTipo(i);
				String estadoSilla= Silla.ESTADO_DISPONIBLE;
				Silla silla= new Silla (letraSilla,numSilla,tipoSilla,estadoSilla );
				sillas[i][j] = silla;

			}
		}
        
        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

	
    /**
     * MŽtodo que retorna el caracter asosiado a una fila.
     * @param fila, entero que corresponde a la fila.
     * Ejemplos:
     * si fila es cero, la salida es 'A'
     * si fila es uno, la salida es 'B'
     * ... si fila es 10, la salida es 'K'
     * @return char es un caracter con el id de la fila
     */
    private char darLetra(int fila){
		char letra='A';
		
		switch(fila){
		case 0:
			letra='A';
			break;
		case 1:
			letra='B';
			break;
		case 2:
			letra='C';
			break;
		case 3:
			letra='D';
			break;
		case 4:
			letra='E';
			break;
		case 5:
			letra='F';
			break;
		case 6:
			letra='G';
			break;
		case 7:
			letra='H';
			break;
		case 8:
			letra='I';
			break;
		case 9:
			letra='J';
			break;
		case 10:
			letra='K';
			break;
		}
		return letra;
	}
	
    /**
     * Retorna un String con el tipo de la fila
     * @param fila, int que representa la fila
     * @return tipo con el String que corresponde as’:
     * si la fila es menor a 8, entonces es de tipo general
     * en el caso contrario es de tipo preferencial
     */
	private String darTipo(int fila){
		String tipo="";
		if (fila<=8){
			tipo = Silla.GENERAL;
		}else{
			tipo = Silla.PREFERENCIAL;		
		}
		return tipo;
	}
	/**
	 * MŽtodo que se encarga de cargar la informaci—n de la sala a partir del mundo
	 * @param archivo
	 * @throws Exception de entrada salida
	 */
    public void cargar(File archivo) throws Exception{
		Properties datos = cargarSillas(archivo);
		cargarDatos(datos);
	}	
	
    /**
     * MŽtodo que carga la informaci—n de un objeto de la clase File 
     * en un objeto de la clase Properties usando un flujo de datos
     * @param archivo, objeto de la clase File
     * @return objeto de la clase propeties
     * @throws Exception en el caso en que no pueda hacerse la carga
     */
    public Properties cargarSillas(File archivo) throws Exception{
		Properties datos = new Properties();
		try{
			FileInputStream in = new FileInputStream(archivo);
			datos.load(in);
			in.close();
		}catch(Exception e){
			throw new Exception("Archivo Invalido");
		}
		
		return datos;
	}
    
    
    /**
    * nombre: cargarDatos
    * Descripci—n: Este mŽtodo permite leer la informaci—n de un objeto Properties, para obtener
    * los datos de las sillas, llenar la matriz de sillas y obtener la informaci—n de la pelicula.
    * Pre: sillas != null
    * Pos: sillas est‡ llena a partir de la informaci—n del archivo
    * Pos: pel’cula ha sido inicializada y contiene la informaci—n de la pel’cula
    *  @param datos: es el objeto tipo Properties, datos !=null,
    * @throws se lanza una excepcci—n en el caso en que ocurra un error en la carga de datos.
    * Mensaje de la excepci—n: "Hubo un error en la carga de los datos"
    */
   
    public void cargarDatos(Properties datos) throws Exception {
    	
    	//usar constantes en los recorridos, y el medoto anteriror

    	String nombre = datos.getProperty("pelicula.nombre");
    	String genero = datos.getProperty("pelicula.genero");
    	String sinopsis = datos.getProperty("pelicula.sinopsis");
    	String idioma = datos.getProperty("pelicula.idioma");
    	String pais = datos.getProperty("pelicula.pais");
    	int duracion = Integer.parseInt(datos.getProperty("pelicula.duracion"));
    	
    	pelicula = new Pelicula(nombre,genero,sinopsis,idioma,pais,duracion);
    	
    	for (int i = 0; i < TOTAL_FILAS; i++) {
    		for (int j = 0; j < TOTAL_COLUMNAS; j++) {
    			
    			String estado = datos.getProperty("cine.silla."+i+"-"+j);
    			
    			if(estado.equals(Silla.ESTADO_RESERVADA)){
    			sillas[i][j].reservarSilla();
    			}else if(estado.equals(Silla.ESTADO_VENDIDA)){
    			sillas[i][j].venderSilla();
    			}
			}
			
		}
    	

	}
    
   /**
    * Retorna la cantidad de sillas reservadas en la sala de cine
    * @return int, cantidad de sillas reservadas
    */
    public int darSillasReservadas(){
    	Silla silla = null;
    	int contador = 0;
    	for (int i = 0; i < (FILAS_GENERAL + FILAS_PREFERENCIAL); i++) {
			for (int j = 0; j < SILLAS_POR_FILA; j++) {
				silla = sillas[i][j];
				if(silla.estaReservada()){
					contador++;
				}
			}
    	}
     return contador;
    }
    
   /**
    * Retona la cantidad de sillas vendidas de la sala de Cine
    * @return int, cantidad de sillas vendidas
    */
   
    public int darSillasVendidas(){
    	Silla silla = null;
    	int contador = 0;
    	for (int i = 0; i < (FILAS_GENERAL + FILAS_PREFERENCIAL); i++) {
			for (int j = 0; j < SILLAS_POR_FILA; j++) {
				silla = (Silla)sillas[i][j];
				if(silla.estaVendida()){
					contador++;
				}
			}
    	}
     return contador;
    }

    /**
     * darPorcentajeOcupacion
     * Descripción: Devuelve el porcentaje de ocupación de toda la sala de cine. se tienen en cuenta las sillas reservadas y vendidas  
     * <br/><b>pre: </b> la matriz de sillas está inicializada y != null <br />
     * @return porcentaje de ocupación
     */
    
    
    <br/><b>pre: </b>
    @return:
    
    
    
    public int darPorcentajeOcupacion(){
    	
    	int reservadas = 0;
    	int vendidas = 0;
    	for (int i = 0; i < TOTAL_FILAS; i++) {
			for (int j = 0; j < TOTAL_COLUMNAS; j++) {
				Silla silla = sillas[i][j];
				if(silla.estaVendida()){
					vendidas++;
				}
				if(silla.estaReservada()){
					reservadas++;
				}
			}
    	}
    	int suma = vendidas + reservadas;
    	int totalSillas =  (FILAS_GENERAL + FILAS_PREFERENCIAL) * 20;
    	int porcentaje = (suma * 100)/totalSillas;
    	return porcentaje;
    }
    
    /**
     * Nombre MŽtodo: darFilaGralDisponible
     * Descripci—n: retorna el nombre de la primera silla general que se encuentra disponible.
     * El nombre de una silla se compone de la letra de la fila y el nœmero.  
     * <br/><b>pre: </b> 
     * - la matriz de sillas est‡ inicializada y ninguna de sus posiciones es null
     * - sillas[i][j]!= null <br />
     * @return String con el nombre de la PRIMERA silla de tipo general que estŽ disponible
     */
	public String darFilaGralDisponible() {

		String numSilla = "";
		boolean seEncontro = false;
		
		for (int i = 0; i < TOTAL_FILAS && seEncontro == false; i++) {
			for (int j = 0; j < TOTAL_COLUMNAS && seEncontro == false; j++) {
				
				if(sillas[i][j].esGeneral()==true && sillas[i][j].estaDisponible()==true){
					
					String fila = sillas[i][j].darFila()+"";
					String numero = sillas[i][j].darNumero()+"";
				
					numSilla = fila+numero;
					seEncontro = true;
					
				}
			}
		}

		return numSilla;	
	}
 
	
	 /**
     * darSillaGanadora
     * Descripción: Genera aleotariamente la silla ganadora de toda la sala de cine  
     * @return el número de la silla ganadora, en el formato A01
     */
	public String darSillaGanadora() {
		// Generar aleatoriamente la letra
		// Las letras mayusculas de las sillas están entre 65= A y 75 = K
		String fila = (char) ((75 - 65 + 1) * Math.random() + 65) + "";
		// Generar número aleatorio entre 0 y 20
		int numero = (int) (Math.random() * 20 + 1);
		if (numero < 10)
			return fila + "0" + numero;
		else
			return fila + numero;
	}

    /**
     * Dada una letra, devuelve la siguiente según el código ASCII.
     * @param letra Letra inicial.
     * @return Letra siguiente.
     */

    public Silla[][] darSillas(){
    	
    	return sillas;
    }
    
    public Pelicula darPelicula(){
    	return pelicula;
    }

}