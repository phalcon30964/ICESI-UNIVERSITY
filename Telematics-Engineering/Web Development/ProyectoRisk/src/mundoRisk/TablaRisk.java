package mundoRisk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import TadGrafo.GrafoLista;
import TadLista.ListaDoble;
import TadLista.ListaOrdenada;
import TadLista.ListaSimple;
import TadPila.Pila;


public class TablaRisk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numJugadores;
	
	public static  GrafoLista<Territorio> territorios;
	
	private ListaSimple<Jugador> jugadores;
	
	private Pila<CartaMision> cartasMision;
	
	private Pila<CartaTerritorio> cartasTerritorios;
		
	private int jugadorActual;
	
	private int numCanjeosHastaElMomento;

	private int etapaJuego;
	
	
	public final static String CARTA_MISION="Carta mision";
	
	public final static String CARTA_TERRITORIO="Carta Territorio";
	
	public final static String AMARILLO = "Amarillo";
	
	public final static String NEGRO = "Negro";
	
	public final static String AZUL = "Azul";
	
	public final static String ROSADO = "Rosado";
	
	public final static String NARANJA = "Naranja";
	
	public final static String ROJO = "Rojo";
	
	public final static String [] nombreTerritorios={"Alaska","Alberta","México","Estados Unidos del Este","Groenlandia",
		"Territorios del Noroeste","Ontario","Quebec","Estados Unidos del Oeste"
		,"Argentina","Brasil","Perú","Venezuela","Gran Bretaña","Islandia","Europa del Norte",
		"Escandinavia","Europa del Sur","Ucrania","Europa Occidental","Congo",
		"África Oriental","Egipto","Madagascar","África del Norte","Sudáfrica",
		"Afganistán","China","India","Irkutsk","Japón","Kamchatka","Oriente Medio",
		"Mongolia","Siam","Siberia","Ural","Yakutsk","Australia Oriental","Indonesia","Nueva Guinea","Australia Occidental"
		};

	/**
	 * Metodo constructor de la clase TablaRisk, se encarga de incializar todos los atributos de la tabla.
	 * 
	 * @param numJugadores con que se inicializa el juego
	 */
	public TablaRisk(int numJugadores){
		
		 this.numJugadores = numJugadores;

		 TablaRisk.territorios =new GrafoLista<Territorio>(false);

		 this.jugadores = new ListaSimple<Jugador>();

		 this.cartasMision = new Pila<CartaMision>();
		 
		 this.cartasTerritorios = new Pila<CartaTerritorio>();

		 this.jugadorActual=0;
		 
		 this.etapaJuego = 1;
		 		
		 this.numCanjeosHastaElMomento = 0;
		 
		 try {
			inicializarTerritorios();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 inicializarCartaMision();
		 inicializarCartasTerritorio();
	}
	
	/**
	 * Metodo crucial del juego, inicializa los territorios del grafo 
	 * 
	 * pos:el mundo ha quedado lleno de los territorios
	 * 
	 * @throws Exception si algun territorio a agregar ya existia antes
	 */
	public void inicializarTerritorios() throws Exception { 
		
		for (int i = 0;i<9; i++) {
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "América del Norte"));
		}
		
		for(int i=9; i<13;i++){ 
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "América del Sur"));
			
		}
		for(int i=13;i<20;i++){ 
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "Europa"));
		}
	
		for (int i = 20; i < 26; i++) {
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "África Oriental"));
		}
		
		for(int i=26;i<38;i++){ 
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "Asia"));
			
		}
		for(int i=38;i<42;i++){ 
			territorios.agregarVertice(new Territorio(nombreTerritorios[i], "Oceanía"));
		}
		
		inicializarAdyacencias();
		
	}
	
	/**
	 * Metodo que se encarga de volver adyacentes los terriorios del grafo territorios
	 * 
	 * pos: los territorios de la tabla risk han sido vueltos adyacentes unos de otros
	 * 
	 * @throws Exception si alguna adyacencia ya existia
	 */
	private void inicializarAdyacencias() throws Exception{
				
		//Alaska  
		territorios.agregarArista(1, buscarTerritorio("Alaska"), buscarTerritorio("Territorios del Noroeste"));
		territorios.agregarArista(1, buscarTerritorio("Alaska"), buscarTerritorio("Alberta"));
		territorios.agregarArista(1, buscarTerritorio("Alaska"), buscarTerritorio("Kamchatka"));
		
		//Alberta
		territorios.agregarArista(1,buscarTerritorio("Alberta"), buscarTerritorio("Territorios del Noroeste"));
		territorios.agregarArista(1, buscarTerritorio("Alberta"), buscarTerritorio("Ontario"));
		territorios.agregarArista(1, buscarTerritorio("Alberta"), buscarTerritorio("Estados Unidos del Este"));
		
		//Mexico
		territorios.agregarArista(1,buscarTerritorio("México"), buscarTerritorio("Estados Unidos del Este"));
		territorios.agregarArista(1,buscarTerritorio("México"), buscarTerritorio("Estados Unidos del Oeste"));
		territorios.agregarArista(1, buscarTerritorio("México"), buscarTerritorio("Venezuela"));
		
		//Estados unidos del este
		territorios.agregarArista(1, buscarTerritorio("Estados Unidos del Este"), buscarTerritorio("Ontario"));
		territorios.agregarArista(1, buscarTerritorio("Estados Unidos del Este"), buscarTerritorio("Estados Unidos del Oeste"));
		
		//Groenlandia
		territorios.agregarArista(1, buscarTerritorio("Groenlandia"),buscarTerritorio("Territorios del Noroeste"));
		territorios.agregarArista(1, buscarTerritorio("Groenlandia"), buscarTerritorio("Ontario"));
		territorios.agregarArista(1, buscarTerritorio("Groenlandia"),buscarTerritorio("Quebec"));
		territorios.agregarArista(1, buscarTerritorio("Groenlandia"), buscarTerritorio("Islandia"));
		
		//Territorios del Noroeste
		territorios.agregarArista(1,  buscarTerritorio("Territorios del Noroeste"),  buscarTerritorio("Ontario"));
		
		//Ontario
		territorios.agregarArista(1, buscarTerritorio("Ontario"),buscarTerritorio("Estados Unidos del Oeste"));
		territorios.agregarArista(1, buscarTerritorio("Ontario"), buscarTerritorio("Quebec"));
		
		
		//Quebec
		territorios.agregarArista(1, buscarTerritorio("Quebec"),  buscarTerritorio("Estados Unidos del Oeste"));
		
		//Estados Unidos del Oeste 	// ya!!
	
		//Argentina
		territorios.agregarArista(1,  buscarTerritorio("Argentina"), buscarTerritorio("Perú"));
		territorios.agregarArista(1,  buscarTerritorio("Argentina"),  buscarTerritorio("Brasil"));

		//Brasil
		territorios.agregarArista(1,  buscarTerritorio("Brasil"),  buscarTerritorio("Perú"));
		territorios.agregarArista(1, buscarTerritorio("Brasil"),  buscarTerritorio("Venezuela"));
		territorios.agregarArista(1,  buscarTerritorio("Brasil"),  buscarTerritorio("África del Norte"));
		
		//Perú
		territorios.agregarArista(1,  buscarTerritorio("Perú"),  buscarTerritorio("Venezuela"));
		
		//Venezuela //Ya!!
		
		//Gran Bretaña
		territorios.agregarArista(1,  buscarTerritorio("Gran Bretaña"),  buscarTerritorio("Islandia"));
		territorios.agregarArista(1,  buscarTerritorio("Gran Bretaña"),  buscarTerritorio("Escandinavia"));
		territorios.agregarArista(1,  buscarTerritorio("Gran Bretaña"),  buscarTerritorio("Europa del Norte"));
		territorios.agregarArista(1,  buscarTerritorio("Gran Bretaña"),  buscarTerritorio("Europa Occidental"));
		//Islandia
		territorios.agregarArista(1, buscarTerritorio("Islandia"), buscarTerritorio("Escandinavia"));
		
		//Europa del Norte
		territorios.agregarArista(1,buscarTerritorio("Europa del Norte"), buscarTerritorio("Escandinavia"));
		territorios.agregarArista(1, buscarTerritorio("Europa del Norte"),buscarTerritorio("Ucrania"));
		territorios.agregarArista(1,buscarTerritorio("Europa del Norte"), buscarTerritorio("Europa del Sur"));
		territorios.agregarArista(1,buscarTerritorio("Europa del Norte"), buscarTerritorio("Europa Occidental"));
		
		//Escandinavia 
		territorios.agregarArista(1, buscarTerritorio("Escandinavia"), buscarTerritorio("Ucrania"));
		
		//Europa del sur
		territorios.agregarArista(1, buscarTerritorio("Europa del Sur"),buscarTerritorio("Europa Occidental"));
		territorios.agregarArista(1, buscarTerritorio("Europa del Sur"), buscarTerritorio("Ucrania"));
		territorios.agregarArista(1, buscarTerritorio("Europa del Sur"),buscarTerritorio("Egipto"));
		territorios.agregarArista(1, buscarTerritorio("Europa del Sur"), buscarTerritorio("África del Norte"));
		territorios.agregarArista(1, buscarTerritorio("Europa del Sur"),buscarTerritorio("Oriente Medio"));
		
		//Ucrania
		
		territorios.agregarArista(1,  buscarTerritorio("Ucrania"),  buscarTerritorio("Oriente Medio"));
		territorios.agregarArista(1,  buscarTerritorio("Ucrania"), buscarTerritorio("Afganistán"));
		territorios.agregarArista(1,  buscarTerritorio("Ucrania"), buscarTerritorio("Ural"));
		
		//Europa Occidental
		territorios.agregarArista(1, buscarTerritorio("Europa Occidental"),  buscarTerritorio("África del Norte"));
	
		//Congo
		territorios.agregarArista(1, buscarTerritorio("Congo"),buscarTerritorio("África Oriental"));
		territorios.agregarArista(1, buscarTerritorio("Congo"),buscarTerritorio("Sudáfrica"));
		territorios.agregarArista(1,buscarTerritorio("Congo"),buscarTerritorio("África del Norte"));
		
		//África Oriental
		territorios.agregarArista(1, buscarTerritorio("África Oriental"),  buscarTerritorio("Egipto"));
		territorios.agregarArista(1, buscarTerritorio("África Oriental"), buscarTerritorio("África del Norte"));
		territorios.agregarArista(1, buscarTerritorio("África Oriental"), buscarTerritorio("Sudáfrica"));
		territorios.agregarArista(1,buscarTerritorio("África Oriental"), buscarTerritorio("Madagascar"));
		
		//Egipto
		territorios.agregarArista(1,  buscarTerritorio("Egipto"),  buscarTerritorio("África del Norte"));
		territorios.agregarArista(1,  buscarTerritorio("Egipto"),  buscarTerritorio("Oriente Medio"));
		
		
		//Madagascar
		territorios.agregarArista(1,  buscarTerritorio("Madagascar"),  buscarTerritorio("Sudáfrica"));
		
		//África del Norte//Ya!!
		
		//Sudáfrica// Ya!!
		
		//Afganistán
		territorios.agregarArista(1, buscarTerritorio("Afganistán"), buscarTerritorio("India"));
		territorios.agregarArista(1, buscarTerritorio("Afganistán"), buscarTerritorio("Oriente Medio"));
		territorios.agregarArista(1, buscarTerritorio("Afganistán"), buscarTerritorio("China"));
		territorios.agregarArista(1, buscarTerritorio("Afganistán"), buscarTerritorio("Ural"));
		
		//China
		territorios.agregarArista(1, buscarTerritorio("China"),  buscarTerritorio("Mongolia"));
		territorios.agregarArista(1, buscarTerritorio("China"), buscarTerritorio("India"));
		territorios.agregarArista(1, buscarTerritorio("China"),  buscarTerritorio("Siam"));		
						
		//India
		territorios.agregarArista(1, buscarTerritorio("India"),  buscarTerritorio("Siam"));
		territorios.agregarArista(1, buscarTerritorio("India"), buscarTerritorio("Oriente Medio"));
		
		//Irkutsk
		
		territorios.agregarArista(1, buscarTerritorio("Irkutsk"), buscarTerritorio("Kamchatka"));
		territorios.agregarArista(1, buscarTerritorio("Irkutsk"), buscarTerritorio("Yakutsk"));
		territorios.agregarArista(1, buscarTerritorio("Irkutsk"), buscarTerritorio("Siberia"));
		territorios.agregarArista(1, buscarTerritorio("Irkutsk"), buscarTerritorio("Mongolia"));
		
		//Japón
		territorios.agregarArista(1, buscarTerritorio("Japón"), buscarTerritorio("Mongolia"));
		territorios.agregarArista(1, buscarTerritorio("Japón"), buscarTerritorio("Kamchatka"));
		
		//Kamchatka
		territorios.agregarArista(1,  buscarTerritorio("Kamchatka"),  buscarTerritorio("Yakutsk"));
		territorios.agregarArista(1,  buscarTerritorio("Kamchatka"), buscarTerritorio("Mongolia"));
		
		//Oriente Medio // Ya!!
		
		//Mongolia
		territorios.agregarArista(1,  buscarTerritorio("Mongolia"),  buscarTerritorio("Siberia"));
		
		//Siam
		territorios.agregarArista(1, buscarTerritorio("Siam"), buscarTerritorio("Indonesia"));
		
		//Siberia
		territorios.agregarArista(1,buscarTerritorio("Siberia"),buscarTerritorio("Yakutsk"));
		territorios.agregarArista(1, buscarTerritorio("Siberia"),buscarTerritorio("Ural"));
		territorios.agregarArista(1, buscarTerritorio("Siberia"),buscarTerritorio("China"));
				
		//Ural //ya!!
		
		//Yakutsk // Ya!!
		
		//Australia Oriental
		territorios.agregarArista(1, buscarTerritorio("Australia Oriental"), buscarTerritorio("Nueva Guinea"));
		territorios.agregarArista(1, buscarTerritorio("Australia Oriental"),  buscarTerritorio("Australia Occidental"));
		
		//Indonesia
		territorios.agregarArista(1, buscarTerritorio("Indonesia"), buscarTerritorio("Nueva Guinea"));
		territorios.agregarArista(1, buscarTerritorio("Indonesia"), buscarTerritorio("Australia Occidental"));
		
		//Nueva Guinea
		territorios.agregarArista(1, buscarTerritorio("Nueva Guinea"), buscarTerritorio("Australia Occidental"));
		
		//Australia Occidental //Ya!!!
	}
	
	/**
	 * Metodo que se encarga de inicializar las cartas mision del juego y 
	 * les introduce la lista de terriotorios necesario para ganar el juego
	 * 
	 * pos:queda inicializadas las cartas mision
	 */
	private void inicializarCartaMision(){ 
				
		String cadena ="Se debe conquistar  ";
		
		ListaDoble<Integer> lista1=new ListaDoble<Integer>();
		
		for (int i = 0; i < 9; i++) {
			lista1.agregar(i);
		}
		
		ListaDoble<Integer> lista2=new ListaDoble<Integer>();
		
		for(int i=9;i<13;i++){ 
		lista2.agregar(i);
			
		}
		
		ListaDoble<Integer> lista3=new ListaDoble<Integer>();
		for(int i=13;i<20;i++){ 
			lista3.agregar(i);
		}
		
		
		ListaDoble<Integer> lista4=new ListaDoble<Integer>();
		for (int i = 20; i < 26; i++) {
			lista4.agregar(i);
		}
		
		ListaDoble<Integer> lista5=new ListaDoble<Integer>();
		for(int i=26;i<38;i++){ 
			lista5.agregar(i);
		}
		
		ListaDoble<Integer> lista6=new ListaDoble<Integer>();
		for(int i=38;i<42;i++){ 
			lista6.agregar(i);
		}
		
		ListaDoble<Integer> lista7=new ListaDoble<Integer>();
		for(int i=0;i<13;i++){ 
			lista7.agregar(i);
				
			}
		ListaDoble<Integer> lista8=new ListaDoble<Integer>();
		for(int i=13;i<26;i++){ 
			lista8.agregar(i);
		}
		
		ListaDoble<Integer> lista9=new ListaDoble<Integer>();
		for(int i=26;i<42;i++){ 
			lista9.agregar(i);
		}
		
		ListaDoble<Integer> lista10=new ListaDoble<Integer>();
		for (int i = 0; i < 20; i++) {
			lista10.agregar(i);
		}
		
		ListaDoble<Integer> lista11=new ListaDoble<Integer>();
		for (int i = 20; i < 42; i++) {
			lista11.agregar(i);
		}
		
		ListaDoble<Integer> lista12=new ListaDoble<Integer>();
		for (int i = 0; i < 42; i++) {
			lista11.agregar(i);
		}
		
		CartaMision[] carta = new CartaMision[12];
		
		 carta[0]=new CartaMision(CARTA_MISION, cadena+"América del Norte",lista1 );
		 carta[1]=new CartaMision(CARTA_MISION, cadena+"América del Sur", lista2);
		 carta[2]=new CartaMision(CARTA_MISION, cadena+"Europa", lista3);
		 carta[3]=new CartaMision(CARTA_MISION, cadena+"África ", lista4);
		 carta[4]=new CartaMision(CARTA_MISION, cadena+ "Asia", lista5);
		 carta[5]=new CartaMision(CARTA_MISION, cadena+ "Oceanía", lista6);
		 carta[6]=new CartaMision(CARTA_MISION, cadena+ "América del Norte y América del Sur", lista7);
		 carta[7]=new CartaMision(CARTA_MISION, cadena+"Europa y África Oriental", lista8);
		 carta[8]=new CartaMision(CARTA_MISION, cadena+"Asia y Oceanía " , lista9);
		 carta[9]=new CartaMision(CARTA_MISION, cadena+"América del Norte, América del Sur y Europa ", lista10);
		 carta[10]=new CartaMision(CARTA_MISION, cadena+ "África Oriental,Asia y Oceanía", lista11);
		 carta[11]=new CartaMision(CARTA_MISION, cadena+ "El mundo" , lista12);
		
		ArrayList<CartaMision> listica=new ArrayList<CartaMision>();
		for (int i = 0; i < carta.length; i++) {
			listica.add(carta[i]);
		}
		Collections.shuffle(listica);
		
		for (int i = 0; i < listica.size(); i++) {
			cartasMision.push(listica.get(i));
		}
	}
	
	
	/**
	 * Metodo que se encarga de inicializar las cartas territorio del la tabla risk
	 * 
	 * Estas cartas pueden ser cambiadas por soldados
	 */
	private void inicializarCartasTerritorio(){ 
		
		for (int i = 0; i < 13; i++) {
			String nombreTerritorio=territorios.getVertice(i).getNombre();
			cartasTerritorios.push(new CartaTerritorio(CARTA_TERRITORIO,nombreTerritorio, "INFANTERIA"));
			
		}
		
		for (int i = 13; i < 27; i++) {
			String nombreTerritorio=territorios.getVertice(i).getNombre();
			cartasTerritorios.push(new CartaTerritorio(CARTA_TERRITORIO, nombreTerritorio, "ARTILLERIA"));
		}
		
		for (int i = 27; i < 41; i++) {
			String nombreTerritorio=territorios.getVertice(i).getNombre();
			cartasTerritorios.push(new CartaTerritorio(CARTA_TERRITORIO, nombreTerritorio, "CABALLERIA"));
		}
				
	}
	
	/**
	 * Metodo que agrega jugadores al juego, y hace verificacion de si ya esta el jugador agregado en el juego y
	 * verifica tambien si ya se llego al maximo numero de jugadores acordados
	 * 
	 * @param nombre del jugador
	 * @param colorTropas color elejido por jugador
	 * @throws Exception si a existe el jugador escogido ó se alcanzo el numero maximo de jugadores permitidos
	 */
	public void agregarJugador(String nombre, String colorTropas)throws Exception{
		
		
		if(jugadores.darLongitud()==numJugadores){ 
			throw new Exception("Ya se completo el número de jugadores");
		}
		if(buscarJugador(nombre)!=null){ 
			throw new Exception("Ya se agrego un jugador con el mismo nombre");
		}
		
		int numTropasDisponiblesU = (numJugadores==3)? 35: (numJugadores==4)? 30: (numJugadores==5)? 25: 20;
		
		jugadores.agregar(new Jugador(nombre, colorTropas, numTropasDisponiblesU, cartasMision.pop()));
		
	}
	
	/**
	 * Metodo que busca un jugador en la lista de jugadores de tabkarisk
	 * 
	 * @param nombre del jugador a buscar
	 * @return Jugador buscado, null si no lo encuentra
	 */
	public Jugador buscarJugador(String nombre){
	
		for (int i = 0; i < jugadores.darLongitud(); i++) {
			if(jugadores.darElemento(i).getNombre().equalsIgnoreCase(nombre)){ 
				return jugadores.darElemento(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo que busca un territorio en la lista de vertices del grafo territorios
	 * 
	 * @param nombreTerritorio
	 * @return Territorio buscado por el nombre, null si no lo encuentra
	 */
	public Territorio buscarTerritorio(String nombreTerritorio){
		
		ListaDoble<Territorio> teri=territorios.getVertices();
		
		for (int i = 0; i < teri.darLongitud(); i++) {
			if(teri.darElemento(i).getNombre().equals(nombreTerritorio)){ 
				return teri.darElemento(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo agrega un terriotorio a un jugador
	 * 
	 * @param nombreJugador
	 * @param nombreTerritorio a agregar
	 */
	public void agregarTerritorioAJugador(String nombreJugador, String nombreTerritorio){
			try {
				Jugador j = buscarJugador(nombreJugador);
				j.agregarTerritiorio(buscarTerritorio(nombreTerritorio));
			} catch (Exception e) {
				e.printStackTrace();//si el territorio a agregar por el usuario ya existe entonces no hace nada
			}
	}

	
	/**
	 * Metodo que agrega el numero de tropas pasado por parametro al territorio del jugador pasado por parametro
	 * 
	 * @param nombreJugador
	 * @param nombreTerritorio
	 * @param numeroDeTropas a agregar
	 */
	public void agregarTropaATerritorio(String nombreJugador,String nombreTerritorio, int numeroDeTropas){
		buscarJugador(nombreJugador).agregarTropa(nombreTerritorio, numeroDeTropas);;
	}
	
	
	/**
	 * Metodo que mueve tropas de un territorio de un jugador a otro territorio del mismo jugador
	 * 
	 * @param territorioOrigen
	 * @param territorioDestino
	 * @param numeroTropasAmover
	 */
	//Arroja exception cuando se desee mover de tropas a un territorio no adyacente, y cuando no se posea el numero de tropas requerido para mover
	public void reforzarTropas(String territorioOrigen, String territorioDestino, int numeroTropasAmover){	
		getJugadorActual().reforzarTropasEnTerritorio(territorioOrigen, territorioDestino, numeroTropasAmover);	
	}
	
	
	/**
	 * Se mira cual es el mejor territorio a atacar desde un sitio indicado, tomando en cuanta las sgts condiciones:
	 * 
	 * @pre: el terriotorio a calcular el mejor ataque debe ser un territoio poseido por el jugador 
	 * 
	 * Porque	tienen	una	mayor	cantidad	de	ejércitos	que	sus	vecinos	(los	vecinos	son	de	otro	jugador)
     * Porque	hay	un	territorio	o	más	del	jugador	(permiten	respaldar	un	ataque	de	revancha)
     * Porque	le	ayuda	a	cumplir	su	misión
     * 
     * @param jugadorAtacante jugador que ataca
	 * @param nombreTerritorioOrigenAtaque , territorio de donde se va a originar el ataque
	 * @return Lista de territorios al cual se podra atacar y tener menos posibilidad de perder, 
	 * 		   Lista vacia si el territorio pasado por parametro no pertenece al jugador
	 */
	public ListaDoble<Territorio> getMejorTerritorioAatacar(String jugadorAtacante, String nombreTerritorioOrigenAtaque){
		return buscarJugador(jugadorAtacante).calcularMejoresTerritorioAtacar(nombreTerritorioOrigenAtaque);
	}

	/**verificarTropasPorTerritorio
	 * este método se encarga de verificar que en cada territorio tenga 1 tropa
	 * 
	 * @return boolean que indica si cada territorio tiene 1 tropa
	 */
	public boolean verificarTropaPorTerritorio(){ 
		ListaDoble<Territorio> terri= territorios.getVertices();
		int contador=0;
		
		for (int i = 0; i < terri.darLongitud(); i++) {
			if(terri.darElemento(i).getNumTropasOcupandoTerritorio()==1){ 
				contador++;
			} 
		}
		if(contador==terri.darLongitud()){ 
			return true;
		}
		return false;
	}
	


	/**verificarTodosJugadoresTienenTropasUbicadas
	 * Este método valida si todos los jugadores no tienen tropas a ubicar
	 * @return boolean que indica si todos los jugadores tienen tropas ubicadas
	 */
	public boolean verificarTodosJugadoresTienenTropasUbicadas(){ 
		for (int i = 0; i < numJugadores; i++) {
			if(jugadores.darElemento(i).getNumTropasDisponiblesAUbicar()!=0){ 
			return false;
			}
		}
		return true;	}
	
	/**CalcularNumTropasAumentar
	 * este método se encarga de calcular el numero de tropas que puede agregar el jugador que se encuentra en el turno actual y modifica el atributo de numero de tropas a ubicar, teniendo 
	 * en cuenta el numero de territorios ocupados, la cantidad por defecto que se le agregar en cada turno y la cantidad de continentes que tiene
	 * ocupados
	 * 
	 * @param jugador que se encuentra en el turno actual
	 */
	public void aumentarNumTropasDisponibles(Jugador jugador){
		//por defecto
		int defecto=3;
		//por territorios ocupados
		int contador2=(int)jugador.getTerritoriosOcupados().darLongitud()/3;
		//Valor de continentes de risk que tenga
		int contador3=0;
		//Continentes
		int contadorAmericaNorte=0 , contadorAmericaSur=0, contadorEuropa=0, contadorAsia=0, contadorAfrica=0, contadorAustralia=0;
		
		ListaDoble<Territorio> lista=jugador.getTerritoriosOcupados();
		
		for (int i = 0; i < lista.darLongitud(); i++) {
			String actual=lista.darElemento(i).getContinente();
			
			switch (actual) {
			case "América del Norte":
				contadorAmericaNorte++;
				break;
			case "América del Sur":
				contadorAmericaSur++;
				break;
			case "Europa":
				contadorEuropa++;
				break;
			case "África Oriental":
				contadorAfrica++;
				break;
			case "Asia":
				contadorAsia++;
				break;
			case "Oceanía":
				contadorAustralia++;
				break;
			}
		}
		
		
	if(contadorAmericaNorte==9) 
		contador3+=5;
	if(contadorAmericaSur==4) 
		contador3+=2;
	if(contadorEuropa==7) 
		contador3+=5;
	if(contadorAfrica==6) 
		contador3+=3;
	if(contadorAsia==12)
		contador3+=7;
	if(contadorAustralia==4) 
		contador3+=2;
	
	jugador.setNumTropasDisponiblesAUbicar(defecto+contador2+contador3);
	
	}
	
	/**
	 * Metodo principal del los turnos que pasa turno, cambia el jugador actual y 
	 * si se reunen las condiciones necesarias cambia de estapa el juego
	 * 
	 * pre:true
	 * pos:ha cambiado de jugador actual, y si se reunen las condiciones necesarias se cambia de estapa el juego
	 * @throws Exception 
	 */
	public void pasarTurno() throws Exception{
				
			jugadorActual++;
			
			if(jugadorActual>=jugadores.darLongitud()){
				jugadorActual = 0;
			}
			comprobarJugadorActualTieneDemasiadasCartas();
			comprobarGanadorJuego();
			
			comprobarEtapaDelJuego();
				
	}
	
	/**
	 * Metodo que retorna el dueno de un territorio
	 * 
	 * @param nombre del terriotorio a buscar
	 * @return Jugador dueno del territorio
	 * 
	 */
	public Jugador darDuenoTerritorio(String nombre){
		return buscarTerritorio(nombre).getPropietario();
	}
	
	/**
	 * Metodo que dice con cuantos dados de puede atacar desde un territorio espeficico
	 * 
	 * @param nomTerritorioAtacante
	 * @return numero de dados maximos con que se puede atacar desde el territorio pasado por parametro
	 */
	public int numDadosConLosQueSePuedeAtacar(String nomTerritorioAtacante){
		Territorio atacante = buscarTerritorio(nomTerritorioAtacante);		
		return (atacante.getNumTropasOcupandoTerritorio()>3)? 3: (atacante.getNumTropasOcupandoTerritorio()-1>=0)? atacante.getNumTropasOcupandoTerritorio()-1: 0;
	}
	
	/**
	 * Metodo que dice con cuantos dados de puede defender desde un territorio espeficico
	 * 
	 * @param nomTerritorioDefensor
	 * @return numero de dados maximos con que se puede defender desde el territorio pasado por parametro
	 */
	public int numDadosConLosQueSePuedeDefender(String nomTerritorioDefensor){
		Territorio defensor = buscarTerritorio(nomTerritorioDefensor);		
		return (defensor.getNumTropasOcupandoTerritorio()>2)? 2: 1;
	}
	
	/**
	 *Metodo que tira los dados de del jugador atacante y el jugador defensor, este metodo sirve para que en la interfaz conozca cual fue el resultado 
	 *de los dados tirados por los jugadores y se puedan pintar en pantalla 
	 * 
	 * @param terrAtacante Nombre del territorio desde el que se ataca
	 * @param terrDefensor Nombre del territorio desde el que se defiende
	 * @param numDadosAtacante numero de dados con los que se desea atacar
	 * @param numDadosDefensor numero de dados con los que se desea defender
	 * @return 2 listas ordenadas, la primera es los dados del atacante y la segunda los dados del defensor
	 * @throws Exception si no se puede tirar los dados que se desean porque no hay suficientes tropas para respaldar los dados
	 */
	public ListaDoble<ListaOrdenada<Integer>> tirarDados(String terrAtacante, String terrDefensor, int numDadosAtacante, int numDadosDefensor)throws Exception{
		
		Territorio territorioAtacante = buscarTerritorio(terrAtacante);
		Territorio territorioDefensor = buscarTerritorio(terrDefensor);
		
//		if(territorioAtacante.getNumTropasOcupandoTerritorio()<numDadosAtacante || numDadosAtacante>3){
//			throw new Exception("No se puede atacar tantos dados, puede atacar hasta con: "+(territorioAtacante.getNumTropasOcupandoTerritorio()-1));
//		}
//		
//		if(territorioDefensor.getNumTropasOcupandoTerritorio()<numDadosAtacante|| numDadosDefensor>2){
//			throw new Exception("No se puede defender con tantos dados, puede defender hasta con: "+(territorioDefensor.getNumTropasOcupandoTerritorio()-1));
//
//		}
		
		ListaOrdenada<Integer> actacante = territorioAtacante.getPropietario().tirarDados(numDadosAtacante);
		ListaOrdenada<Integer> defensor =  territorioDefensor.getPropietario().tirarDados(numDadosDefensor);
		
		ListaDoble<ListaOrdenada<Integer>> respuesta = new ListaDoble<ListaOrdenada<Integer>>();
		
		respuesta.agregar(actacante);
		respuesta.agregar(defensor);
		
		return respuesta;
	}
	
	/**
	 * Metodo que representa cuando dos jugadores tiran dados y devuelve el resultado de la batalla, 
	 * este resultado es un int[] que tiene el resultado de haber tirado el dado del atacante y el de el defensor, 
	 * por ejemplo si se tira 3 dados a atacar y 2 defienden, sera un int[] de tamano dos donde muestra en la pimera 
	 * posicion el resultado enfrentar el dado con mayor valor del atacante y el dado con mayor valor del defensor. Sera siempre un int[]
	 * de tamano del numero de dados que tira el defensor.
	 * 
	 * IMPORTANTE: cada posicion tiene numero mayor que 0 si el atacante gano la contienda (esto quiere decir que se le disminuira 
	 * una tropa al jugador atacante en su territorio de atacaque ), 0 o menor que 0 si el defensor gano la contienda (si hay mas de una tropa 
	 * en el territorio se le disminuye una tropa al defensor, o sino se le quita el territorio y se le pasa al atacante
	 * 
	 * Este retorno sirve para que en el interfaz se muestre el resultado de la batalla 
	 * 
	 * @param nomTerritorioAtacante
	 * @param nomTerritorioDefensor
	 * @param dadosAtacante numero de dados con que se desea atacar
	 * @param dadosDefensor numero de dados con los que se defendera
	 * @return int[] un arreglo de resultados, numero mayor que 0 si el atacante gano la contienda, 0 o menor que 0 si el defensor gano la contienda
	 * @throws Exception si el territorio que ataca no es adyacente del que es atacado, o si se intenta usar un numero de dados que no tiene respaldo de tropas 
	 */
	public int[] atacar(String  nomTerritorioAtacante, String nomTerritorioDefensor, ListaOrdenada<Integer> dadosAtacante, ListaOrdenada<Integer> dadosDefensor) throws Exception{
		
		Territorio atacante = buscarTerritorio(nomTerritorioAtacante);
		Territorio defensor = buscarTerritorio(nomTerritorioDefensor);
		
		if(!defensor.esAdyacente(atacante)){
			throw new Exception("No se puede atacar al territorio seleccionado, no es adyacente");
		}
		
		if(atacante.getNumTropasOcupandoTerritorio()<dadosAtacante.darLongitud()){
			throw new Exception("No se puede atacar tantos dados, puede atacar hasta con: "+(atacante.getNumTropasOcupandoTerritorio()-1));
		}
		
		if(defensor.getNumTropasOcupandoTerritorio()<dadosDefensor.darLongitud()){
			throw new Exception("No se puede defender con tantos dados, puede defender hasta con: "+(defensor.getNumTropasOcupandoTerritorio()-1));
		}
		
		int[] respuesta = new int[dadosDefensor.darLongitud()];
		for (int i = 0; i < respuesta.length; i++) {
			respuesta[i] = dadosAtacante.darElemento(i) - dadosDefensor.darElemento(i);
		}
		
		boolean perdioTerritorio = false;
		for (int i = 0; i < respuesta.length && atacante.getNumTropasOcupandoTerritorio()>1 && !perdioTerritorio; i++) {
			if(respuesta[i]>0){
				try {
					defensor.eliminarTropas(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(defensor.getNumTropasOcupandoTerritorio()==0){
					defensor.getPropietario().eliminarTerritiorio(defensor);
					defensor.setPropietario(atacante.getPropietario());
					atacante.getPropietario().agregarTerritiorio(defensor);
					reforzarTropas(atacante.getNombre(), defensor.getNombre(), atacante.getNumTropasOcupandoTerritorio()-1);
					perdioTerritorio = true;
					//esto le da una unica carta en una sola ronda y aumenta el numero de canjeados
					if(!getJugadorActual().isGanoTerritorio()){
						darBonificacion(getJugadorActual());
						getJugadorActual().setGanoTerritorio(true);
						numCanjeosHastaElMomento++;
					}
				}	
			}else{
					try {
						atacante.eliminarTropas(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}

		}
		
		
		return respuesta;
	}
	
	/**
	 * Meotodo auxiliar da una bonificacion de carta a un jugador pasado por parametro
	 * @param j Jugador en mension
	 */
	public void darBonificacion(Jugador j){
		
		try {
			j.agregarCartaTerritorio(cartasTerritorios.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que verifica y da tropas, segun el numero de canjes que haya habido y si no hay suficientes tira exception
	 * 
	 * @param nombreJugador al cual canjearle las cartas
	 * @throws Exception si no hay suficiente cartas y se desea canjear 
	 */
	public void canjearCartasPorTropas(String nombreJugador) throws Exception{
		Jugador actual = buscarJugador(nombreJugador);
		
		if(actual.getCartasBonus().darLongitud()<=2){
			throw new Exception("Todavia no se reune la suficiente cantidad de cartas, siga atacando para conseguir mas cartas bonus");
		}
		
		int numTropasAumentar = (numCanjeosHastaElMomento>=1 && numCanjeosHastaElMomento<=5)? 4 + (numCanjeosHastaElMomento-1)*2 : 
								(numCanjeosHastaElMomento>5)? 12 + (numCanjeosHastaElMomento-5)*5 : 2;
		
		int contINFANTERIA = 0 ,contARTILLERIA = 0,contCABALLERIA = 0;
		
		ListaDoble<CartaTerritorio> aux = actual.getCartasBonus();
		
		for (int i = 0; i < aux.darLongitud(); i++) {
			if (aux.darElemento(i).getTipoTropa().equals("INFANTERIA")){
				contINFANTERIA++;
			}else if (aux.darElemento(i).getTipoTropa().equals("ARTILLERIA")){
				contARTILLERIA++;
			}else if (aux.darElemento(i).getTipoTropa().equals("CABALLERIA")) {
				contCABALLERIA++;
			}
		}
		
		if(contARTILLERIA>=3){
			actual.setNumTropasDisponiblesAUbicar(numTropasAumentar);
			actual.eliminarCartasBonus("ARTILLERIA", 3);
		}else if(contCABALLERIA>=3){
			actual.setNumTropasDisponiblesAUbicar(numTropasAumentar);
			actual.eliminarCartasBonus("CABALLERIA", 3);
		}else if(contINFANTERIA>=3){
			actual.setNumTropasDisponiblesAUbicar(numTropasAumentar);
			actual.eliminarCartasBonus("INFANTERIA", 3);
		}else if(contARTILLERIA>=1 && contARTILLERIA>=1 && contINFANTERIA>=1) {
			actual.setNumTropasDisponiblesAUbicar(numTropasAumentar);
			actual.eliminarCartasBonus("INFANTERIA", 1);
			actual.eliminarCartasBonus("CABALLERIA", 1);
			actual.eliminarCartasBonus("INFANTERIA", 1);
		}	
		
	}
	
	/**
	 * El metodo comprueba si alguien gano el juego al finalizar una ronda, 
	 * este metodo verifica si el jugador actual es el unico jugador del juego o si cumplio su mision
	 * 
	 * @throws Exception explicando que el el jugador actual ganó
	 */
	public void comprobarGanadorJuego() throws Exception{
		
		if(getJugadorActual().misionCumplida()  || jugadores.darLongitud()==1){
			throw new Exception(getJugadorActual().getNombre()+" has ganado el juego");
		}	
	}
	
	/**
	 * Metodo que compueba que si el jugador actual tiene demasiadas cartas bonus, si es asi canjea automaticamente sus cartas
	 */
	public void comprobarJugadorActualTieneDemasiadasCartas(){
		
		getJugadorActual().setGanoTerritorio(false);
			
			if(getJugadorActual().getCartasBonus().darLongitud()==5){
				try {
					canjearCartasPorTropas(getJugadorActual().getNombre());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public void comprobarEtapaDelJuego(){
		
		if(etapaJuego == 1 && verificarTropaPorTerritorio()){
			this.etapaJuego = 2;
		
		}if(etapaJuego == 2 && verificarTodosJugadoresTienenTropasUbicadas()){
			this.etapaJuego = 3;
		}
		
		if(etapaJuego==3){
			aumentarNumTropasDisponibles(getJugadorActual());
		}
		
	}
	
	public void comprobarSiAlguienPerdio()throws Exception{
		for (int i = 0; i < jugadores.darLongitud(); i++) {
			if(jugadores.darElemento(i).getNumTropasDisponiblesAUbicar()==0 && jugadores.darElemento(i).getNumTropasUbicadas()==0 ){
				try {
					String nombre = jugadores.darElemento(i).getNombre();
					jugadores.eliminar(i);
					throw new Exception(nombre+ " ha sido eliminado");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	
	public int getEtapaJuego() {
		return etapaJuego;
	}

	public void setEtapaJuego(int etapaJuego) {
		this.etapaJuego = etapaJuego;
	}
	
	public Pila<CartaTerritorio> getCartasTerritorios() {
		return cartasTerritorios;
	}

	public Jugador getJugadorActual() {
		return jugadores.darElemento(jugadorActual) ;
	}

	public void setJugadorActual(int jugadorActual) {
		this.jugadorActual = jugadorActual;
	}
	
	public ListaSimple<Jugador> getJugadores(){
		return this.jugadores;
	}
	
	public ListaDoble<Territorio> getTerritorios(){
		return territorios.getVertices();
	}
	
	
	public ListaDoble<CartaMision> getListaCartasMision(){ 
	ListaDoble<CartaMision> lista=new ListaDoble<>();
	
	while(!cartasMision.isEmpty()){ 
		try {
			lista.agregar(cartasMision.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return lista;
	
	}
	
	
	
	
}
