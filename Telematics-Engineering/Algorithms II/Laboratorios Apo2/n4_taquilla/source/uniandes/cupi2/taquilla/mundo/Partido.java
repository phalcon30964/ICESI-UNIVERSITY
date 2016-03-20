/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Muñoz Lattion - 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.taquilla.mundo;

/**
 * Clase que representa un Partido
 */
public class Partido
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el torneo Liga
     */
    public static final String TORNEO_LIGA = "Torneo Liga";

    /**
     * Constante que representa el torneo Copa
     */
    public static final String TORNEO_COPA = "Torneo Copa";

    /**
     * Constante que representa el torneo Super Liga
     */
    public static final String TORNEO_SUPER_LIGA = "Torneo Super Liga";

    /**
     * Constante que representa el número de sillas en la localidad Norte
     */
    public static final int SILLAS_LOCALIDAD_NORTE = 50;

    /**
     * Constante que representa el número de sillas en la Localidad Occidental
     */
    public static final int SILLAS_LOCALIDAD_OCCIDENTAL = 100;

    /**
     * Constante que representa el número de sillas en la Localidad Oriental
     */
    public static final int SILLAS_LOCALIDAD_ORIENTAL = 100;

    /**
     * Constante que representa el número de sillas en la Localidad Sur
     */
    public static final int SILLAS_LOCALIDAD_SUR = 50;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
    /**
     * El rival de Partido
     */
    private String rival;

    /**
     * El Torneo de Partido
     */
    private String torneo;

    /**
     * El totalIngresos de Partido
     */
    private double totalIngresos;

    /**
     * Las sillas en la localidad norte del Partido
     */
    private Silla[] localidadNorte;

    /**
     * Las sillas en la localidad sur del Partido
     */
    private Silla[] localidadSur;

    /**
     * Las sillas en la localidad occidental del Partido
     */
   
    private Silla[] localidadOccidental;
 
    /**
     * Las sillas en la localidad oriental del Partido
     */
    
    private Silla[] localidadOriental;
     /**
     * Fecha del partido
     */
    private String fechaPartido;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
   
    /**
     * Construye un partido con la información dada por parámetro <br>
     * <b> post: </b> Se inicializaron los arreglos de las localidades y cada una de sus sillas <br>
     * 				  Se inicializó el total de ingresos en 0 <br>
     * @param pRival Nombre del equipo rival - pRival != null && pRival != ""
     * @param pTorneo Tipo de torneo del partido - pTorneo != null && pTorneo != ""
     * @param pFechaPartido Fecha del partido - pFechaPartido != null && pFechaPartido != ""
     */
    public Partido( String pRival, String pTorneo, String pFechaPartido )
    {
        rival = pRival;
        torneo = pTorneo;
        fechaPartido = pFechaPartido;
        totalIngresos = 0;
        
        localidadNorte = new Silla[SILLAS_LOCALIDAD_NORTE];
        inicializar( localidadNorte, Taquilla.LOCALIDAD_NORTE );
        localidadSur = new Silla[SILLAS_LOCALIDAD_SUR];
        inicializar( localidadSur, Taquilla.LOCALIDAD_SUR );
        localidadOccidental = new Silla[SILLAS_LOCALIDAD_OCCIDENTAL];
        inicializar(localidadOccidental, Taquilla.LOCALIDAD_OCCIDENTAL);
        localidadOriental = new Silla[SILLAS_LOCALIDAD_ORIENTAL];
        inicializar(localidadOriental, Taquilla.LOCALIDAD_ORIENTAL);
   
        }

    /**
     * Inicializa las sillas del arreglo dado por parámetro, asigna a cada silla su número de silla que corresponde a su posición en el arreglo <br>
     * y el nombre de la localidad a la que pertenece <br>
     * @param pLocalidad Sillas de una localidad - pLocalidad != null
     * @param pNombreLocalidad Nombre de la localidad de la silla - pNombreLocalidad != "" && pNombreLocalidad != null
     */
    private void inicializar( Silla[] pLocalidad, String pNombreLocalidad )
    {
        Silla[] vTemp = pLocalidad;
        for( int i = 0; i < pLocalidad.length; i++ )
        {
            vTemp[ i ] = new Silla( i, pNombreLocalidad );
        }
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Informa el rival del partido
     * @return rival del partido
     */
    public String darRival( )
    {
        return rival;
    }

    /**
     * Informa el tipo de torneo del partido
     * @return Torneo del partido
     */
    public String darTorneo( )
    {
        return torneo;
    }

    /**
     * Informa el total de ingresos del partido
     * @return totalIngresos el total de ingresos del partido
     */
    public double darTotalIngresos( )
    {
        return totalIngresos;
    }

    /**
     * Devuelve las sillas de la localidad norte del partido
     * @return Sillas en la localidad norte del partido
     */
    public Silla[] darLocalidadNorte( )
    {
        return localidadNorte;
    }

    /**
     * Devuelve las sillas de la localidad sur del partido
     * @return Sillas en la localidad sur del partido
     */
    public Silla[] darLocalidadSur( )
    {
        return localidadSur;
    }

    /**
     * Devuelve las sillas de la localidad occidental del partido
     * @return Sillas en la localidad occidental del partido
     */
    public Silla[] darLocalidadOccidental( )
    {
    	return localidadOccidental;
    }

    /**
     * Devuelve las sillas de la localidad oriental del partido
     * @return Sillas en la localidad oriental del partido
     */
    public Silla[] darLocalidadOriental( )
    {
    
    	return localidadOriental;
    }

    /**
     * Informa la fecha del partido
     * @return Fecha del partido
     */
    public String darFechaPartido( )
    {
        return fechaPartido;
    }

    /**
     * Devuelve el arreglo de sillas de una localidad dado el nombre de la localidad
     * @param pLocalidad Nombre de la localidad - pLocalidad != null && (pLocalidad == Silla.LOCALIDAD_NORTE || pLocalidad == Silla.LOCALIDAD_OCCIDENTAL || pLocalidad == Silla.LOCALIDAD_ORIENTAL || pLocalidad == Silla.LOCALIDAD_SUR)
     * @return vSillasTemp El arreglo de las sillas
     */
    public Silla[] darSillasPorLocalidad( String pLocalidad )
    {
        
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_NORTE))
    		return localidadNorte;
    	else if (pLocalidad.equals(Taquilla.LOCALIDAD_OCCIDENTAL))
    		return localidadOccidental;
    	else if (pLocalidad.equals(Taquilla.LOCALIDAD_ORIENTAL))
    		return localidadOriental;
    	else
    		return localidadSur;
    }

    /**
     * Devuelve la silla de una localidad dado su número <br>
     * <b> pre: </b> Los arreglos de las sillas se encuentran inicializados <br>
     * @param pNumeroSilla Número de la silla - pNumeroSilla >= 0
     * @param pLocalidad Nombre de la localidad - pLocalidad != null && (pLocalidad == Silla.LOCALIDAD_NORTE || pLocalidad == Silla.LOCALIDAD_OCCIDENTAL || pLocalidad == Silla.LOCALIDAD_ORIENTAL || pLocalidad == Silla.LOCALIDAD_SUR)
     * @return silla La silla con el número dado en la localidad dada
     * @throws Exception Si no existe una silla en la localidad dada con el número dado
     */
    public Silla darSillaDeLocalidad( int pNumeroSilla, String pLocalidad ) throws Exception
    {
    	Silla respuesta = null;
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_NORTE) && pNumeroSilla>SILLAS_LOCALIDAD_NORTE){
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_OCCIDENTAL) && pNumeroSilla>SILLAS_LOCALIDAD_OCCIDENTAL){
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    	}

    	if(pLocalidad.equals(Taquilla.LOCALIDAD_ORIENTAL) && pNumeroSilla>SILLAS_LOCALIDAD_ORIENTAL){
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_SUR) && pNumeroSilla>SILLAS_LOCALIDAD_SUR){
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    	}
    
 
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_NORTE)){
    		respuesta = localidadNorte[pNumeroSilla];
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_OCCIDENTAL)){
    		respuesta = localidadOccidental[pNumeroSilla];
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_ORIENTAL)){
    		respuesta = localidadOriental[pNumeroSilla];
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_SUR)){
    		respuesta = localidadSur[pNumeroSilla];
    	}
    	
    	return respuesta;
    
 
    	
        //TODO Completar según la documentación del método
    	
    }

    /**
     * Informa el precio de la silla dependiendo de la localidad en la que se encuentre ubicada la silla
     * @return El precio de la silla
     */
    public double darPrecio( Silla pSilla )
    {
        if( pSilla.darLocalidad( ).equals( Taquilla.LOCALIDAD_NORTE ) )
        {
            return Taquilla.PRECIO_NORTE;
        }
        else if( pSilla.darLocalidad( ).equals( Taquilla.LOCALIDAD_SUR ) )
        {
            return Taquilla.PRECIO_SUR;
        }
        else if( pSilla.darLocalidad( ).equals( Taquilla.LOCALIDAD_OCCIDENTAL ) )
        {
            return Taquilla.PRECIO_OCCIDENTAL;
        }
        else 
        {
            return Taquilla.PRECIO_ORIENTAL;
        }
    }
    
    /**
     * Método encargado de vender una silla teniendo en cuenta una localidad y el numero de silla que llegan por parámetro <br>
     * <b> pre: </b> Los arreglos de las sillas se encuentran inicializados <br>
     * <b> post: </b> Se le asigno un comprador a la silla requerida <br>
     *                Se aumento el total de ingresos en el precio de la silla vendida teniendo en cuenta el descuento <br>
     * @param pNumeroSilla Numero de la silla que se quiere vender - pNumeroSilla != null
     * @param pLocalidad Nombre de la localidad - pLocalidad != null && (pLocalidad == Silla.LOCALIDAD_NORTE || pLocalidad == Silla.LOCALIDAD_OCCIDENTAL || pLocalidad == Silla.LOCALIDAD_ORIENTAL || pLocalidad == Silla.LOCALIDAD_SUR)
     * @param pNombreComprador Nombre del comprador de la silla - pNombreComprador != null && pNombreComprador != ""
     * @param pCedulaComprador Cédula del comprador de la silla - pCedulaComprador != null && pCedulaComprador != ""
     * @param pDescuento Descuento de la silla - pDescuento >= 0.0 && pDescuento <= 1.0
     * @return costoVenta El costo de la venta de la Silla
     * @throws Exception Si no existe la silla en la localidad dada con el número dado
     *                   En caso que la silla ya se encuentre asignada
     */
    public double venderSilla( int pNumeroSilla, String pLocalidad, String pNombreComprador, String pCedulaComprador, double pDescuento ) throws Exception
    {  
    	
    	double precioSilla = 0;
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_NORTE)){
    		
    		int precio = 0;
    		
    		if(pNumeroSilla>SILLAS_LOCALIDAD_NORTE || localidadNorte[pNumeroSilla].estaAsignada() ){
    	
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    		
    		}
    		
    		localidadNorte[pNumeroSilla].asignarSilla(pNombreComprador,pCedulaComprador);
    		
    		if(existeSocio(pCedulaComprador)){
    		   localidadNorte[pNumeroSilla].darPrecio
    		}
    		
    		precioSilla = localidadNorte[pNumeroSilla].darprecio
    		
    		
    		
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_OCCIDENTAL)){ 
  
    		 if (pNumeroSilla>SILLAS_LOCALIDAD_OCCIDENTAL || localidadOccidental[pNumeroSilla].estaAsignada()){
    			 
    		 throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    		 }
    	}
    		
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_ORIENTAL)) {
    		
    		if(pNumeroSilla>SILLAS_LOCALIDAD_ORIENTAL || localidadOriental[pNumeroSilla].estaAsignada() ){
    	
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    		
    		}
    		
    	}
    	
    	if(pLocalidad.equals(Taquilla.LOCALIDAD_SUR)){
    		
    		if(pNumeroSilla>SILLAS_LOCALIDAD_SUR || localidadSur[pNumeroSilla].estaAsignada()){
    			
    		throw new Exception("la silla en la localidad "+pLocalidad+" en el puesto "+pNumeroSilla+" no existe.");
    		
    		}
    	}
    	
    	if
    	
    	return precioSilla;
    	
    	
    	
        //TODO Completar según la documentación del método
    }
    
    
    
    //TODO Escriba el contrato del método, teniendo en cuenta la implementación.
    public Silla buscarSillaLibre( String pLocalidad ) 
    {
        Silla vSillas[] = darSillasPorLocalidad( pLocalidad );
        Silla res = null;
        for( int i = 0; i < vSillas.length && res == null; i++ )
        {
            Silla vSillaTemp = vSillas[ i ];
            if( !vSillaTemp.estaAsignada( ) )
            {
                res = vSillaTemp;
            }
        }
        return res; 
    }

    /**
     * Método que se encarga de vender la primera silla que se encuentre disponible dentro de la localidad dada <br>
     * <b> pre: </b> Los arreglos de las sillas se encuentran inicializados <br>
     * <b> post: </b> Se le asigno un comprador a la primera silla libre en la localidad requerida <br>
     *                Se aumento el total de ingresos en el precio de la silla vendida teniendo en cuenta el descuento <br>
     * @param pLocalidad Nombre de la localidad - pLocalidad != null && (pLocalidad == Silla.LOCALIDAD_NORTE || pLocalidad == Silla.LOCALIDAD_OCCIDENTAL || pLocalidad == Silla.LOCALIDAD_ORIENTAL || pLocalidad == Silla.LOCALIDAD_SUR)
     * @param pNombreComprador Nombre del comprador - pNombreComprador != null && pNombreComprador != ""
     * @param pCedulaComprador Cédula del comprador - pCedulaComprador != null && pCedulaComprador != ""
     * @param pDescuento Descuento de la silla - pDescuento >= 0.0 && pDescuento <= 1.0
     * @return costoVenta El costo de la venta de la Silla
     * @throws Exception En caso de no encontrar ninguna silla disponible
     */
    public double venderPrimeraSillaLibre( String pLocalidad, String pNombreComprador, String pCedulaComprador, double pDescuento ) throws Exception
    {
        //TODO Completar según la documentación del método
    }
    
  
    //TODO Cree la documentación e Implemente el método darPorcentajeDeAsistencia
    //Responsabilidad del método: Calcula el porcentaje de asistencia del partido teniendo en cuenta todas sus localidades.<br>
    
  
    /**
     * Retorna una cadena de texto que representa el partido con el siguiente formato: <br>
     *  <torneo> - <rival> - <fechaPartido>
     */
    public String toString() {
    	return torneo + " - " + rival + " - " + fechaPartido;
    }

}