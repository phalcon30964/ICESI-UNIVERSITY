package mundo;

/**
 * Entidad que modela una zona geográfica con sitios turísticas de una ciudad
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Zona {

	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	/**
	 * Constante para modelar la característica de ubicación NORTE
	 */
	public final static int NORTE  = 1; 
	
	/**
	 * Constante para modelar la característica de ubicación CENTRO
	 */
	public final static int CENTRO = 2; 
	
	/**
	 * Constante para modelar la característica de ubicación SUR
	 */
	public final static int SUR    = 3; 
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	/**
	 * La ubicación de la zona (puede ser NORTE, CENTRO, etc)
	 */
	private int ubicacion;
	
	/**
	 * La proporción del área de la zona con respecto al área de la ciudad (en porcentaje)
	 */
	private double areaProporcional;
	
	/**
	 * La cantidad de centros educativos presentes en la zona
	 */
	private int cantidadCentrosEducativos;
	
	/**
	 * La cantidad de centros de salud presentes en la zona
	 */
	private int cantidadCentrosSalud;
	
	/**
	 * El sitio turístico uno (1)
	 */
	private Sitio sitioUno;
	
	/**
	 * El sitio turístico dos (2)
	 */
	private Sitio sitioDos;
	
	/**
	 * El sitio turístico tres (3)
	 */
	private Sitio sitioTres;
	
	/**
	 * El sitio turístico cuatro (4)
	 */
	private Sitio sitioCuatro;
	
	/**
	 * El sitio turístico cinco (5)
	 */
	private Sitio sitioCinco;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

	/**
	 * Crea una nueva zona con la información pasada como parámetro.
	 * 
	 * @param laUbicacion La ubicación de la nueva zona
	 * @param elAreaProporcional La proporción del área de la nueva zona con respecto a la ciudad (en porcentaje)
	 * @param laCantidadCentrosEducativos La cantidad de centros educativos de la nueva zona
	 * @param laCantidadCentrosSalud La cantidad de centros de salud de la nueva zona
	 */
	public Zona(int laUbicacion, double elAreaProporcional, int laCantidadCentrosEducativos, int laCantidadCentrosSalud) {
		ubicacion = laUbicacion;
		areaProporcional = elAreaProporcional;
		cantidadCentrosEducativos = laCantidadCentrosEducativos;
		cantidadCentrosSalud = laCantidadCentrosSalud;
		
		sitioUno    = null;
		sitioDos    = null;
		sitioTres   = null;
		sitioCuatro = null;
		sitioCinco  = null;
	}
	
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

	/**
	 * Agrega un nuevo sitio a la zona actual.
	 * 
	 * @param elNombre el nombre del sitio que se va a agregar
	 * @param elNombreImagen el nombre del archivo de la imagen del sitio que va a agregar
	 * @param elTipoSitio el tipo de sitio del sitio que se va a agregar
	 * @param elAnhoConstruccion el año en que fue construido el sitio que se va a agregar
	 * @param laDireccion la dirección del sitio que se va a agregar
	 * @return true si se pudo agregar el nuevo sitio, false de lo contrario
	 */
	public boolean agregarSitio(String elNombre, String elNombreImagen, String elTipoSitio, int elAnhoConstruccion, String laDireccion){
		boolean seAgrego = false;

		if(buscarSitio(elNombre)==null){
			Sitio nuevoSitio = new Sitio(elNombre,elNombreImagen,elTipoSitio,elAnhoConstruccion,laDireccion);
			
			if(sitioUno==null){
				sitioUno=nuevoSitio;
				seAgrego = true;
			}else if(sitioDos==null){
				sitioDos=nuevoSitio;			
				seAgrego = true;
			}else if(sitioTres==null){
				sitioTres=nuevoSitio;			
				seAgrego = true;
			}else if(sitioCuatro==null){
				sitioCuatro=nuevoSitio;			
				seAgrego = true;
			}else if(sitioCinco==null){
				sitioCinco=nuevoSitio;			
				seAgrego = true;
			}
		}
		
		return seAgrego;
	}
	
	/**
	 * Busca en la zona actual el sitio cuyo nombre es el pasado como parámetro
	 * y retorna el sitio encontrado. Si no se encontró un sitio que coincidiera
	 * con ese nombre entonces retorna null.
	 * 
	 * @param nombreSitio Es el nombre del sitio que se está buscando
	 * @return el objeto de tipo sitio cuyo nombre es igual al pasado por parámetro ó null si no se encuentra
	 */
	public Sitio buscarSitio(String nombreSitio){
		Sitio sitioBuscado = null;
		
		if(sitioUno!=null && nombreSitio.equals(sitioUno.darNombre())){
			sitioBuscado = sitioUno;
		}else if(sitioDos!=null && nombreSitio.equals(sitioDos.darNombre())){
			sitioBuscado = sitioDos;
		}else if(sitioTres!=null && nombreSitio.equals(sitioTres.darNombre())){
			sitioBuscado = sitioTres;
		}else if(sitioCuatro!=null && nombreSitio.equals(sitioCuatro.darNombre())){
			sitioBuscado = sitioCuatro;
		}else if(sitioCinco!=null && nombreSitio.equals(sitioCinco.darNombre())){
			sitioBuscado = sitioCinco;
		}
		
		return sitioBuscado;
	}
	
	/**
	 * Elimina el sitio cuyo nombre ha sido pasado por parámetro
	 * y retorna null si el sitio pudo ser eliminado. El caso en
	 * que no puede ser eliminado es cuando el sitio con ese nombre
	 * no existe.
	 * 
	 * @param nombreSitio Es el nombre del sitio a eliminar
	 * @return true si se pudo eliminar el sitio, false de lo contrario
	 */
	public boolean eliminarSitio(String nombreSitio){
		boolean elimino = false;
		
		if(sitioUno!=null && nombreSitio.equals(sitioUno.darNombre())){
			sitioUno = null;
			elimino = true;
		}else if(sitioDos!=null && nombreSitio.equals(sitioDos.darNombre())){
			sitioDos = null;
			elimino = true;
		}else if(sitioTres!=null && nombreSitio.equals(sitioTres.darNombre())){
			sitioTres = null;
			elimino = true;
		}else if(sitioCuatro!=null && nombreSitio.equals(sitioCuatro.darNombre())){
			sitioCuatro = null;
			elimino = true;
		}else if(sitioCinco!=null && nombreSitio.equals(sitioCinco.darNombre())){
			sitioCinco = null;
			elimino = true;
		}
		
		return elimino;
	}
	
	/**
	 * Actualiza el sitio en la relación indicada por el parámetro numeroSitio con
	 * los valores nom, anho y dir pasados por parámetro. El sitio no se puede
	 * actualizar en caso de que la relación indicada por numeroSitio sea null 
	 * 
	 * @param numeroSitio Es el número de la relación que se va a actualizar
	 * @param nom Es el nuevo nombre que tendrá el sitio que se va a actualizar
	 * @param anho Es el nuevo año que tendrá el sitio que se va a actualizar
	 * @param dir Es la nueva dirección que tendrá el sitio que se va a actualizar
	 * @return true si se pudo actualizar el sitio, false de lo contrario
	 */
	public boolean actualizarSitio(int numeroSitio, String nom, int anho, String dir){
		Sitio elSitioAActualizar = null;
		switch(numeroSitio){
			case 1:
				elSitioAActualizar = sitioUno;
			break;
			case 2:
				elSitioAActualizar = sitioDos;
			break;
			case 3:
				elSitioAActualizar = sitioTres;
			break;
			case 4:
				elSitioAActualizar = sitioCuatro;
			break;
			case 5:
				elSitioAActualizar = sitioCinco;
			break;
		}
		
		if(elSitioAActualizar!=null){
			elSitioAActualizar.cambiarNombre(nom);
			elSitioAActualizar.cambiarAnhoConstruccion(anho);
			elSitioAActualizar.cambiarDireccion(dir);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Calcula el porcentaje de sitios que han sido calificados. Un sitio
	 * se considera que no ha sido calificacdo si su nota es cero (0).<br/><br/>
	 * 
	 * Si por ejemplo se tienen 3 sitios con objetos (2 estarían en null) 
	 * y cada uno tiene calificaciones 2, 0 y 0, entonces el porcentaje de
	 * calificación sería 33.3333333333
	 * 
	 * @return el porcentaje de calificación de los sitios de esta zona
	 */
	public double calcularPorcentajeCalificado(){
	
		double totalSitiosCalificados = 0;
		double totalSitios = 0;
		
		if(sitioUno!=null){
			totalSitios+= 1;
			if(sitioUno.darCalificacion()!=0){
				totalSitiosCalificados+= 1;
			}	
		}
		
		if(sitioDos!=null){
			totalSitios+= 1;
			if(sitioDos.darCalificacion()!=0){
				totalSitiosCalificados+= 1;
			}	
		}
		
		if(sitioTres!=null){
			totalSitios+= 1;
			if(sitioTres.darCalificacion()!=0){
				totalSitiosCalificados+= 1;
			}	
		}
		
		if(sitioCuatro!=null){
			totalSitios+= 1;
			if(sitioCuatro.darCalificacion()!=0){
				totalSitiosCalificados+= 1;
			}	
		}
		
		if(sitioCinco!=null){
			totalSitios+= 1;
			if(sitioCinco.darCalificacion()!=0){
				totalSitiosCalificados+= 1;
			}	
		}
		
		return (totalSitiosCalificados/totalSitios)*100;
		
		
		/*verificar que el sitio exista
		invocar el dar calificacion y contar los que tengan mas de 0
		sumar todas los que tengan mas de 0 y dividirlo por el numero total de sitios existentes
		*/
		
	}
	
	/**
	 * Calcula el promedio de calificación entre los sitios
	 * que ya han sido calificados en la zona actual.<br/><br/>
	 * 
	 * Recordar que se considera que un sitio ya ha sido calificado
	 * si su calificación es diferente de cero (0).
	 * 
	 * @return el promedio de calificación de los sitios de la zona actual.
	 */
	public double calcularPromedioCalificacion(){
		double promedio=0;
		int totalCalificados = 0;
		if(sitioUno!=null && sitioUno.darCalificacion()>0){
			promedio += sitioUno.darCalificacion();
			totalCalificados++;
		}
		if(sitioDos!=null && sitioDos.darCalificacion()>0){
			promedio += sitioDos.darCalificacion();
			totalCalificados++;
		}
		if(sitioTres!=null && sitioTres.darCalificacion()>0){
			promedio += sitioTres.darCalificacion();
			totalCalificados++;
		}
		if(sitioCuatro!=null && sitioCuatro.darCalificacion()>0){
			promedio += sitioCuatro.darCalificacion();
			totalCalificados++;
		}
		if(sitioCinco!=null && sitioCinco.darCalificacion()>0){
			promedio += sitioCinco.darCalificacion();
			totalCalificados++;
		}
		
		if(totalCalificados>0){
			promedio = promedio / totalCalificados;
		}
		return promedio;
	}
	
	/**
	 * Genera un reporte indicando cual es el sitio mejor calificado.<br/><br/>
	 * 
	 * El formato del reporte es:<br/>
	 * “El sitio XXXNombre con una calificación de YYYCalificacion es el mejor calificado de la zona”.<br/>
	 * 
	 * Pero si ningún sitio ha sido calificado entonces la cadena resultado debe ser:<br/>
	 * “No hay ningún sitio calificado en la zona”
	 * 
	 * @return el reporte que indica el nombre y la calificación del mejor sitio de la zona actual
	 */
	public String generarReporteMejorSitio(){
		String mensaje = "";
		
		int mejorCalificacion = 0;
		String mejorSitio = "";
		
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		int s4 = 0;
		int s5 = 0;
		
		if(sitioUno!=null){
			s1 = sitioUno.darCalificacion();
		}
		if(sitioDos!=null){
			s1 = sitioDos.darCalificacion();
		}
		if(sitioTres!=null){
			s1 = sitioTres.darCalificacion();
		}
		if(sitioCuatro!=null){
			s1 = sitioCuatro.darCalificacion();
		}
		if(sitioCinco!=null){
			s1 = sitioCinco.darCalificacion();
		}
		
		if(s1>s2 && s1>s3 && s1>s4 && s1>s5){
		     mejorCalificacion = s1 ;
		     mejorSitio= sitioUno.darNombre();
		}else if(s2>s3 && s2>s4 && s2>s5){
			 mejorCalificacion = s2 ;
			 mejorSitio= sitioDos.darNombre();
		}else if(s3>s4 && s3>s5){
		     mejorCalificacion = s3 ;
		     mejorSitio= sitioTres.darNombre();
		}else if(s4>s5){
			 mejorCalificacion = s4 ;
			 mejorSitio= sitioCuatro.darNombre();
		}else{ mejorCalificacion = s5;
		       mejorSitio = sitioCinco.darNombre();
		}
		
		if(mejorCalificacion!=0){
		mensaje = "El sitio "+mejorSitio+"con una calificación de "+mejorCalificacion+" es el mejor calificado de la zona" ;
		}else{ mensaje = "No hay ningún sitio calificado en la zona";
		}
		
		
		return mensaje;

}
	       
		

			 
	
	
	/**
	 * Asigna el parámetro calificación como la calificación del sitio 
	 * indicado por el parámetro numeroSitio.<br/>
	 * 
	 * @param numeroSitio Es el número asociado a la relación del sitio que se va a calificar
	 * @param calificacion Es la calificación que se va a asignar al sitio
	 * @return true si se logro calificar al sitio, false de lo contrario
	 */
	public boolean calificarSitio(int numeroSitio, int calificacion){
		boolean califico = false;
		Sitio elSitioACalificar = null;
		switch(numeroSitio){
			case 1:
				elSitioACalificar = sitioUno;
			break;
			case 2:
				elSitioACalificar = sitioDos;
			break;
			case 3:
				elSitioACalificar = sitioTres;
			break;
			case 4:
				elSitioACalificar = sitioCuatro;
			break;
			case 5:
				elSitioACalificar = sitioCinco;
			break;
		}
		
		if(elSitioACalificar!=null){
			califico = true;
			elSitioACalificar.cambiarCalificacion(calificacion);
		}
		
		return califico;
	}
	
	/**
	 * Retorna el nombre de la ubicación dependiendo del
	 * valor que tenga el atributo ubicación:<br/><br/>
	 * 
	 * Si es igual a la constante NORTE, entonces se retorna Norte.<br/> 
	 * Si es igual a la constante CENTRO, entonces se retorna Centro.<br/>
	 * Si es igual a la constante SUR, entonces se retorna Sur.<br/>
	 * 
	 * @return el nombre de la ubicación tal como se especifica en la descripción
	 */
	public String obtenerNombreUbicacion(){
		String nombreUbicacion = "";
		switch(ubicacion){
			case NORTE:
				nombreUbicacion = "Norte";
			break;
			case CENTRO:
				nombreUbicacion = "Centro";
			break;
			case SUR:
				nombreUbicacion = "Sur";
			break;
		}
		return nombreUbicacion;
	}
	
	/**
	 * Retorna la ubicación del sitio
	 * @return ubicacion
	 */
	public int darUbicacion() {
		return ubicacion;
	}
	
	/**
	 * Retorna la proporción del área de la zona actual al área de la ciudad (en porcentaje)
	 * @return areaProporcional
	 */
	public double darAreaProporcional() {
		return areaProporcional;
	}
	
	/**
	 * Retorna la cantidad de centros educativos de la zona actual
	 * @return cantidadCentrosEducativos
	 */
	public int darCantidadCentrosEducativos() {
		return cantidadCentrosEducativos;
	}
	
	/**
	 * Retorna la cantidad de centros de salud de la zona actual
	 * @return cantidadCentrosSalud
	 */
	public int darCantidadCentrosSalud() {
		return cantidadCentrosSalud;
	}
	
	/**
	 * Modifica la ubicación por la indicada en el parámetro
	 * @param laUbicacion es la nueva ubicación de la zona
	 */
	public void cambiarUbicacion(int laUbicacion) {
		ubicacion = laUbicacion;
	}
	
	/**
	 * Modifica la proporción del área de la zona actual con respecto al área de la ciudad (en porcentaje)
	 * @param elAreaProporcional es la nueva proporción que se asignará a la zona
	 */
	public void cambiarAreaProporcional(double elAreaProporcional) {
		areaProporcional = elAreaProporcional;
	}
	
	/**
	 * Modifica la cantidad de centros educativos de la zona actual
	 * @param laCantidadCentrosEducativos es la nueva cantidad de centros educativos 
	 */
	public void cambiarCantidadCentrosEducativos(int laCantidadCentrosEducativos) {
		cantidadCentrosEducativos = laCantidadCentrosEducativos;
	}
	
	/**
	 * Modifica la cantidad de centros de salud de la zona actual
	 * @param laCantidadCentrosSalud es la nueva cantidad de centros educativos
	 */
	public void cambiarCantidadCentrosSalud(int laCantidadCentrosSalud) {
		cantidadCentrosSalud = laCantidadCentrosSalud;
	}

	/**
	 * Retorna el primer sitio
	 * @return sitioUno
	 */
	public Sitio darSitioUno() {
		return sitioUno;
	}

	/**
	 * Retorna el segundo sitio
	 * @return sitioDos
	 */
	public Sitio darSitioDos() {
		return sitioDos;
	}

	/**
	 * Retorna el tercer sitio
	 * @return sitioTres
	 */
	public Sitio darSitioTres() {
		return sitioTres;
	}

	/**
	 * Retorna el cuarto sitio
	 * @return sitioCuatro
	 */
	public Sitio darSitioCuatro() {
		return sitioCuatro;
	}

	/**
	 * Retorna el quinto sitio
	 * @return sitioCinco
	 */
	public Sitio darSitioCinco() {
		return sitioCinco;
	}
}
