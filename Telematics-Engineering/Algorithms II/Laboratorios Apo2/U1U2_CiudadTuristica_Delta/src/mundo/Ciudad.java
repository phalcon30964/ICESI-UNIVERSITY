package mundo;

/**
 * Entidad que modela una ciudad con proyección turística
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Ciudad {

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	/**
	 * El nombre de la ciudad
	 */
	private String nombre;
	
	/**
	 * El porcentaje de desempleo de la ciudad
	 */
	private double desempleo;
	
	/**
	 * El número de habitantes según el último censo realizado
	 */
	private int cantidadHabitantes;
	
	/**
	 * La relación con la zona geográfica que se ubica en el norte de la ciudad
	 */
	private Zona zonaNorte;
	
	/**
	 * La relación con la zona geográfica que se ubica en el centro de la ciudad
	 */
	private Zona zonaCentro;
	
	/**
	 * La relación con la zona geográfica que se ubica en el sur de la ciudad
	 */
	private Zona zonaSur;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

	/**
	 * Crea una nueva ciudad con un escenario muy específico
	 * que es planteado al interior del método 
	 */
	public Ciudad() {
		nombre             = "Springfield";
		desempleo          = 10.3;
		cantidadHabitantes = 2319684;
		
		zonaNorte  = new Zona(Zona.NORTE,  21.7, 32, 7);
		zonaCentro = new Zona(Zona.CENTRO, 9.4,  5,  2);
		zonaSur    = new Zona(Zona.SUR,    35.1, 48, 13);
		
		zonaNorte.agregarSitio("Restaurante La Trufa Dorada","TrufaDorada.jpg", Sitio.COMERCIAL, 1973, "Calle A con Avenida B");
		zonaNorte.agregarSitio("Museo de Arte Moderno", "Museo.jpg", Sitio.CULTURAL, 1965, "Carrera C con Calle D");
		zonaNorte.agregarSitio("Estadio de Hockey", "EstadioDeHockey.jpg", Sitio.ESCENARIOS, 1987, "Calle E con Carrera F");
		zonaCentro.agregarSitio("Coliseo", "Coliseo.jpg", Sitio.ESCENARIOS, 1981, "Avenida G con Calle H");
		zonaCentro.agregarSitio("Estatua del Fundador", "EstatuaFundador.jpg", Sitio.INTERES, 1854, "Calle I con Carrera J");
		zonaCentro.agregarSitio("Tienda de Comics", "TiendaDeComics.jpg", Sitio.COMERCIAL, 1991, "Calle K con Avenida M");
		zonaCentro.agregarSitio("Primera Iglesia Cristiana", "PrimeraIglesiaCristiana.jpg", Sitio.INTERES, 1978, "Carrera N con Calle O");
		zonaCentro.agregarSitio("Restaurante de Comidas Rápidas", "ComidasRapidas.jpg", Sitio.COMERCIAL, 1995, "Calle P con Carrera Q");
		zonaSur.agregarSitio("Teatro de la Ópera", "TeatroDeOpera.jpg", Sitio.CULTURAL, 2008, "Avenida R con Calle S");
		zonaSur.agregarSitio("Museo de Cera", "MuseoDeCera.jpg", Sitio.CULTURAL, 1998, "Diagonal T con Transversal U");
		zonaSur.agregarSitio("Tienda de Zurdos", "TiendaDeZurdos.jpg", Sitio.COMERCIAL, 1996, "Calle V con Diagonal W");
		zonaSur.agregarSitio("Museo Smithsonian", "MuseoSmithsonian.jpg", Sitio.CULTURAL, 2003, "Transversal X con Avenida Y");
	}
	
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

	/**
	 * Retorna la zona ubicada en el norte de la ciudad
	 * @return zonaNorte
	 */
	public Zona darzonaNorte(){
		return zonaNorte;
	}
	
	/**
	 * Retorna la zona ubicada en el centro de la ciudad
	 * @return zonaCentro
	 */
	public Zona darzonaCentro(){
		return zonaCentro;
	}
	
	/**
	 * Retorna la zona ubicada en el sur de la ciudad
	 * @return zonaSur
	 */
	public Zona darzonaSur(){
		return zonaSur;
	}
	
	/**
	 * Actualiza la información de la zona indicada en el parámetro ubicacionZona
	 * con los demás valores pasados por parámetro: area, educ y salud.
	 * 
	 * @param ubicacionZona Es la ubicación de la zona que se desea actualizar
	 * @param area Es el nuevo valor de área que se actualizará en la zona indicada
	 * @param educ Es el nuevo valor de cantidad de centros educativos que se actualizará en la zona indicada
	 * @param salud Es el nuevo valor de cantidad de centros de salud que se actualizará en la zona indicada
	 */
	public void actualizarZona(int ubicacionZona, double area, int educ, int salud){
		switch(ubicacionZona){
			case Zona.NORTE:
				zonaNorte.cambiarCantidadCentrosEducativos(educ);
				zonaNorte.cambiarCantidadCentrosSalud(salud);
				zonaNorte.cambiarAreaProporcional(area);
			break;
			case Zona.CENTRO:
				zonaCentro.cambiarCantidadCentrosEducativos(educ);
				zonaCentro.cambiarCantidadCentrosSalud(salud);
				zonaCentro.cambiarAreaProporcional(area);
			break;
			case Zona.SUR:
				zonaSur.cambiarCantidadCentrosEducativos(educ);
				zonaSur.cambiarCantidadCentrosSalud(salud);
				zonaSur.cambiarAreaProporcional(area);
			break;
		}
	}
	
	/**
	 * Actualiza el sitio indicado en el parámetro numeroSitio de la zona indicada en 
	 * el parámetro ubicacionZona con los demás parámetros: nom, anho y dir.
	 * 
	 * @param ubicacionZona Es la ubicación de la zona donde se encuentra el sitio que se va a actualizar
	 * @param numeroSitio Hace referencia al número de la relación del sitio que se va a actualizar
	 * @param nom El nuevo nombre del sitio que se va a actualizar
	 * @param anho El nuevo anho de construcción del sitio que se va a actualizar
	 * @param dir La nueva dirección del sitio que se va a actualizar
	 */
	public void actualizarSitioDeZona(int ubicacionZona, int numeroSitio, String nom, int anho, String dir){
		switch(ubicacionZona){
			case Zona.NORTE:
				zonaNorte.actualizarSitio(numeroSitio, nom, anho, dir);;
			break;
			case Zona.CENTRO:
				zonaCentro.actualizarSitio(numeroSitio, nom, anho, dir);;
			break;
			case Zona.SUR:
				zonaSur.actualizarSitio(numeroSitio, nom, anho, dir);;
			break;
		}
	}
	
	/**
	 * Agrega un nuevo sitio a la zona indicada en el parámetro ubicacionZona.<br/><br/>
	 * 
	 * Los demás parámetros son los valores de los atributos del nuevo objeto sitio
	 * agregado a la zona.<br/><br/>
	 * 
	 * Se retorna true si el sitio pudo ser agregado y false en caso de no poderse agregar.
	 * Esto último puede ocurrir debido a que no haya mas espacio en la zona (es decir,
	 * las cinco (5) relaciones ya tienen un objeto) ó a que ya exista un sitio en la zona
	 * cuyo nombre sea igual al parámetro elNombre.
	 * 
	 * @param ubicacionZona La ubicación de la zona donde se va a agregar el nuevo sitio.
	 * @param elNombre El nombre del nuevo sitio.
	 * @param elNombreImagen El nombre del archivo de la imagen del nuevo sitio.
	 * @param elTipoSitio El tipo de sitio del nuevo sitio.
	 * @param elAnhoConstruccion El año de construcción del nuevo sitio.
	 * @param laDireccion La dirección del nuevo sitio.
	 * @return true si se pudo agregar el nuevo objeto, false en caso contrario.
	 */
	public boolean agregarSitioAZona(int ubicacionZona,String elNombre, String elNombreImagen, String elTipoSitio, int elAnhoConstruccion, String laDireccion){
		boolean agrego = false;
		
		switch(ubicacionZona){
			case Zona.NORTE:
				agrego = zonaNorte.agregarSitio(elNombre, elNombreImagen, elTipoSitio, elAnhoConstruccion, laDireccion);
			break;
			case Zona.CENTRO:
				agrego = zonaCentro.agregarSitio(elNombre, elNombreImagen, elTipoSitio, elAnhoConstruccion, laDireccion);
			break;
			case Zona.SUR:
				agrego = zonaSur.agregarSitio(elNombre, elNombreImagen, elTipoSitio, elAnhoConstruccion, laDireccion);
			break;
		}
		
		return agrego;
	}
	
	/**
	 * Elimina el sitio cuyo nombre es igual al parámetro elNombre, de la zona
	 * indicada por el parámetro ubicacionZona.
	 * 
	 * @param ubicacionZona La ubicacion de la zona donde se va a eliminar el sitio.
	 * @param elNombre El nombre del sitio que va a eliminar.
	 * @return true si se pudo eliminar el sitio, false de lo contrario.
	 */
	public boolean eliminarSitioDeZona(int ubicacionZona,String elNombre){
		boolean elimino = false;
		
		switch(ubicacionZona){
			case Zona.NORTE:
				elimino = zonaNorte.eliminarSitio(elNombre);
			break;
			case Zona.CENTRO:
				elimino = zonaCentro.eliminarSitio(elNombre);
			break;
			case Zona.SUR:
				elimino = zonaSur.eliminarSitio(elNombre);
			break;
		}
		
		return elimino;
	}
	
	/**
	 * Califica el sitio indicado por el parámetro numeroSitio que se encuentra en
	 * la zona indicada por el parámetro ubicacionZona asignándole como calificación
	 * el parámetro calificacion
	 * 
	 * @param ubicacionZona Es la ubicación de la zona donde está el sitio que se va a calificar
	 * @param numeroSitio Es el número del sitio que se calificará
	 * @param calificacion Es la calificación asignada
	 * @return true si se logro calificar al sitio, false de lo contrario
	 */
	public boolean calificarSitioDeZona(int ubicacionZona, int numeroSitio, int calificacion){
		boolean califico = false;
		switch(ubicacionZona){
			case Zona.NORTE:
				zonaNorte.calificarSitio(numeroSitio, calificacion);
				califico = true;
			break;
			case Zona.CENTRO:
				zonaCentro.calificarSitio(numeroSitio, calificacion);
				califico = true;
			break;
			case Zona.SUR:
				zonaSur.calificarSitio(numeroSitio, calificacion);
				califico = true;
			break;
		}
		return califico;
	}
	
	/**
	 * Genera un reporte indicando el nombre y la calificación del sitio
	 * mejor calificado de la zona indicada por el parámetro ubicacionZona.
	 * 
	 * @param ubicacionZona Es la ubicacion de la zona de la cual se va a generar el reporte.
	 * @return El reporte de la zona con el sitio con mayor puntuación.
	 */
	public String generarReporteMejorSitioDeZona(int ubicacionZona){
	String mensaje = "";
		
		if(ubicacionZona==Zona.CENTRO){
			mensaje = zonaCentro.generarReporteMejorSitio();
		}
		
		if(ubicacionZona==Zona.NORTE){
			mensaje = zonaNorte.generarReporteMejorSitio();
		}
		
		if(ubicacionZona==Zona.SUR){
			mensaje = zonaSur.generarReporteMejorSitio();
		}
		
		
		return mensaje;
	
	}
	
	/**
	 * Calcula el porcentaje de sitios que ya están calificados entre los 
	 * sitios que están registrados en la zona indicada en el parámetro ubicacionZona
	 * 
	 * @param ubicacionZona Es la ubicacion de la zona sobre la cual se realizará el cálculo indicado en la descripción.
	 * @return El porcentaje de sitios calificados de la zona indicada en ubicacionZona.
	 */
	public double calcularPorcentajeCalificadoDeZona(int ubicacionZona){
		double porcentaje = 0;
		
		if(ubicacionZona==Zona.CENTRO){
			porcentaje = zonaCentro.calcularPorcentajeCalificado();
		}
		
		if(ubicacionZona==Zona.NORTE){
			porcentaje = zonaNorte.calcularPorcentajeCalificado();
		}
		
		if(ubicacionZona==Zona.SUR){
			porcentaje = zonaSur.calcularPorcentajeCalificado();
		}
		
		
		return porcentaje;
	}
	
	/**
	 * Busca la zona con menor densidad de centros educativos con relación al área de la zona.<br/><br/>
	 * 
	 * La densidad educativa de una zona se calcula como la cantidad de centros educativos
	 * dividido el área de la zona.
	 * 
	 * @return La zona con menor densidad educativa.
	 */
	public Zona encontrarZonaMenorDensidadEducativa(){
		Zona menorZona = null;
		
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		
		if(zonaSur!=null){
		   s1 = zonaSur.darCantidadCentrosEducativos()/zonaSur.darAreaProporcional();
		}
		
		if(zonaNorte!=null){
			   s2 = zonaNorte.darCantidadCentrosEducativos()/zonaNorte.darAreaProporcional();
		}
		
		if(zonaSur!=null){
			   s3 = zonaCentro.darCantidadCentrosEducativos()/zonaCentro.darAreaProporcional();
	    }
		
		
		if(s1<s2 && s1<s3){
			menorZona = zonaSur;
		}else if(s2<s3){
			menorZona = zonaNorte;
		}else{ menorZona = zonaCentro;
		}
		
		return menorZona;
	}
	
	/** 
	 * Retorna el nombre de la ciudad.
	 * @return nombre
	 */
	public String darNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el índice de desempleo de la ciudad
	 * @return desempleo
	 */
	public double darDesempleo() {
		return desempleo;
	}
	
	/**
	 * Retorna la cantidad de habitantes de la ciudad
	 * @return cantidadHabitantes
	 */
	public int darCantidadHabitantes() {
		return cantidadHabitantes;
	}
	
	/**
	 * Modifica el nombre de la ciudad por el valor pasado como parámetro.
	 * @param elNombre Es el nuevo nombre
	 */
	public void cambiarNombre(String elNombre) {
		nombre = elNombre;
	}
	
	/**
	 * Modifica el índice de desempleo de la ciudad por el valor pasado como parámetro.
	 * @param elDesempleo El nuevo porcentaje de desempleo.
	 */
	public void cambiarDesempleo(double elDesempleo) {
		desempleo = elDesempleo;
	}
	
	/**
	 * Modifica la cantidad de habitantes de la ciudad por el valor pasado como parámetro.
	 * @param laCantidadHabitantes La nueva cantidad de habitantes
	 */
	public void cambiarCantidadHabitantes(int laCantidadHabitantes) {
		cantidadHabitantes = laCantidadHabitantes;
	}
}
