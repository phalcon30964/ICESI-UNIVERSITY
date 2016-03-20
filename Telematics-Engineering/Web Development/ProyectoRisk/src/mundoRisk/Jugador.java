package mundoRisk;

import java.io.Serializable;

import TadLista.ListaDoble;
import TadLista.ListaOrdenada;

public class Jugador implements Serializable {

	private static final long serialVersionUID = -1470349328723987454L;

	private String nombre;

	private String colorTropas;

	private int numTropasDisponiblesAUbicar;

	private int numTropasUbicadas;

	private CartaMision cartaMision;

	private ListaDoble<CartaTerritorio> cartasBonus;

	private ListaDoble<Territorio> territoriosOcupados;
	
	private boolean ganoTerritorio;


	/**
	 * Construtor de la clase Jugador, inicializa sus atributos con los valores recibidos por parametros y se crea una lista de cartaBonus y una cartaMision vacias
	 * @param nombre , nombre del jugador
	 * @param colorTropas , color de las fichas del jugador
	 * @param numTropasDisponiblesAUbicar,  Numero de tropas iniciales que recibo por defecto al inicial el juego
	 * @param cartaMision, CartaMision unica para cada jugador que debe de realizar durante su partida 
	 */

	public Jugador(String nombre, String colorTropas, int numTropasDisponiblesAUbicar , CartaMision cartaMision){

		this.nombre = nombre;
		this.colorTropas = colorTropas;
		this.numTropasDisponiblesAUbicar = numTropasDisponiblesAUbicar;
		this.numTropasUbicadas = 0;
		this.cartasBonus = new ListaDoble<CartaTerritorio>();
		this.cartaMision = cartaMision;
		this.territoriosOcupados = new ListaDoble<Territorio>();
		this.ganoTerritorio = false;

	}

	/**
	 * Se encarga de agregar un territorio al conjunto de territorios del jugador
	 * 
	 * @param territorio , Territorio a agregar al jugador
	 */
	public void agregarTerritiorio(Territorio territorio)throws Exception{
		boolean condicion=false;
		for (int i = 0; i < territoriosOcupados.darLongitud()&&!condicion; i++) {
			if(territoriosOcupados.darElemento(i).getNombre().equalsIgnoreCase(territorio.getNombre())){ 
				throw new Exception("Ya se tiene este territorio en la lista de territorios ocupados");
			}
		}
		
		territoriosOcupados.agregar(territorio);
		territorio.setPropietario(this);
		
	}
	
	/**
	 * Se encarga de eliminar un territorio al conjunto de territorios del jugador
	 * 
	 * @param territorio , Territorio a agregar al jugador
	 */
	public void eliminarTerritiorio(Territorio territorio){
		try {
			territoriosOcupados.eliminar(territorio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se encarga de agregar al territorio especificado por parametro la cantidad de tropas especificada
	 * 
	 * @param nombreTerritorio Territorio al cual agregar las tropas
	 * @param int numero de tropas a agregar
	 */
	public void agregarTropa(String nombreTerritorio, int numeroDeTropasAgregar){
		
		if(numTropasDisponiblesAUbicar-numeroDeTropasAgregar>=0 && buscarTerritorioDelJugador(nombreTerritorio)!=null){
			buscarTerritorioDelJugador(nombreTerritorio).agregarTropas(numeroDeTropasAgregar);
			numTropasUbicadas += numeroDeTropasAgregar; 
			numTropasDisponiblesAUbicar -= numeroDeTropasAgregar;
		}
	}

	/**
	 * Se recoge la cartaTerritorio que se gano durante la conquista de un territorio en la ronda
	 * 
	 * @param carta, Carta del territorios ganado
	 */
	public void agregarCartaTerritorio(CartaTerritorio carta){
		cartasBonus.agregar(carta);	
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
	 * @param nombreTerritorioOrigenAtaque , territorio de donde se va a originar el ataque
	 * @return Lista de territorios al cual se podra atacar y tener menos posibilidad de perder, 
	 * 		   Lista vacia si el territorio pasado por parametro no pertenece al jugador
	 */
	public ListaDoble<Territorio> calcularMejoresTerritorioAtacar(String nombreTerritorioOrigenAtaque){
		
		Territorio origen = buscarTerritorioDelJugador(nombreTerritorioOrigenAtaque);
		ListaDoble<Territorio> respuesta = new ListaDoble<Territorio>();
		
		if(origen!=null){
			ListaDoble<Territorio> territoriosAdyacentesOrigen =  TablaRisk.territorios.getAdyacentes(origen);
			
			for (int i = 0; i < territoriosAdyacentesOrigen.darLongitud(); i++) {
				Territorio actual = territoriosAdyacentesOrigen.darElemento(i);
				
				if(!actual.getPropietario().getNombre().equals(nombre)){
					
					if(respuesta.esVacia() && !(actual.getNumTropasOcupandoTerritorio() < origen.getNumTropasOcupandoTerritorio() &&
							(cartaMision.territorioAyudaCumplirMision(actual) || hayTerritoriosParaRevancha(actual)))){
						respuesta.agregar(actual);
					}
					
					if( actual.getNumTropasOcupandoTerritorio() < origen.getNumTropasOcupandoTerritorio() &&
							(cartaMision.territorioAyudaCumplirMision(actual) || hayTerritoriosParaRevancha(actual))){
						respuesta.agregar(actual);
					}
				}
			}
		}
		return respuesta;
	}
	
	/**
	 * Metdodo auxiliar de calcularMejoresTerritorioAtacar que calcula si el territorio oponente tiene adyacentesd el jugardor 
	 * que puedan respaldar un ataque en caso de que el oponente iguale fuerzar con el terriorio atacante
	 * 
	 * @param oponenteAtacar territorio al que se desea atacar
	 * @return true si hay territorios adyacentes que puedan atacar en revancha
	 */
	public boolean hayTerritoriosParaRevancha(Territorio oponenteAtacar){
		ListaDoble<Territorio> lista = TablaRisk.territorios.getAdyacentes(oponenteAtacar);
		
		for (int i = 0; i < lista.darLongitud(); i++) {
			ListaDoble<Territorio> lista1 = TablaRisk.territorios.getAdyacentes(lista.darElemento(i));
			for (int j = 0; j < lista1.darLongitud(); j++) {
				if(lista1.darElemento(j).getPropietario().getNombre().equals(nombre) && lista1.darElemento(j).getNumTropasOcupandoTerritorio()>1){
					return true;
				}
			}
		}
		
		return false;
	}
	

	/***
	 * Se mueven tropas entre territorios del jugador , sino no hace nada
	 * 
	 * @pre: ambos territorios origen y destino deben ser del jugador
	 * 
	 * @param nombreTerritorio, territorio desde el que se desea mover tropas
	 * @param cantidadTropasACanjear, numero de tropas a pasar
	 */
	public void reforzarTropasEnTerritorio(String nombreTerritorioOrigen,String nombreTerritorioDestino, int cantidadTropasAPasar){
		Territorio origen = buscarTerritorioDelJugador(nombreTerritorioOrigen);
		Territorio destino = buscarTerritorioDelJugador(nombreTerritorioDestino);
		
		if(origen!= null && destino!=null){
			
			if(origen.getNumTropasOcupandoTerritorio() - cantidadTropasAPasar>=1){
				try {
					origen.eliminarTropas(cantidadTropasAPasar);
					destino.agregarTropas(cantidadTropasAPasar);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metodo que busca en todo el conjunto de territorios del jugador uno de ellos especificado por parametro
	 * 
	 * @param nombreTerritorio, territorio a buscar
	 * @return territorio buscado, null si no pertence al jugador
	 */
	public Territorio buscarTerritorioDelJugador(String nombreTerritorio){

		for (int i = 0; i < territoriosOcupados.darLongitud(); i++) {
			if(territoriosOcupados.darElemento(i).getNombre().equals(nombreTerritorio)){
				return territoriosOcupados.darElemento(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo que representa cuando un jugador tira dados
	 * 
	 * @param numeroDeDados a tirar por el jugador
	 * @return ListaOrdenada de dados de mayor a menor 
	 */
	public ListaOrdenada<Integer> tirarDados(int numeroDeDados){
		return Dado.tirarDados(numeroDeDados);
	}
	
	/**
	 * SE verifica si la mision del jugador se ha cumplido 
	 * 
	 * @return true en caso de que se haya cumplido encaso contrario False.
	 */
	public boolean misionCumplida(){
		return cartaMision.seCumplioMision(nombre);
	}
	
	/**
	 * Este metodo se encarga de eliminar una carta bonus de la lista de carta bonus de un jugador.
	 * 
	 * @param tipoTropa tipo de tropa de la carta a eliminar
	 * @param num numero de cartas que se desea eliminar 
	 */
	public void eliminarCartasBonus(String tipoTropa, int num){
		for (int k = 0; k < num; k++) {
			boolean elimino = false;
			for (int i = 0; i < cartasBonus.darLongitud() && !elimino; i++) {
				if(cartasBonus.darElemento(i).getTipoTropa().equals(tipoTropa)){
					try {
						cartasBonus.eliminar(i);
						elimino = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getColorTropas() {
		return colorTropas;
	}

	public int getNumTropasDisponiblesAUbicar() {
		return numTropasDisponiblesAUbicar;
	}

	public int getNumTropasUbicadas() {
		return numTropasUbicadas;
	}

	public CartaMision getCartaMision() {
		return cartaMision;
	}
	
	
	public void setCartaMision(CartaMision cartaMision) {
		this.cartaMision = cartaMision;
	}

	public ListaDoble<CartaTerritorio> getCartasBonus() {
		return cartasBonus;
	}

	public ListaDoble<Territorio> getTerritoriosOcupados() {
		return territoriosOcupados;
	}

	public void setNumTropasDisponiblesAUbicar(int numTropasDisponiblesAUbicar) {
		this.numTropasDisponiblesAUbicar = numTropasDisponiblesAUbicar;
	}

	public void setNumTropasUbicadas(int numTropasUbicadas) {
		this.numTropasUbicadas = numTropasUbicadas;
	}

	public void setTerritoriosOcupados(ListaDoble<Territorio> territoriosOcupados) {
		this.territoriosOcupados = territoriosOcupados;
	}

	public boolean isGanoTerritorio() {
		return ganoTerritorio;
	}

	public void setGanoTerritorio(boolean ganoTerritorio) {
		this.ganoTerritorio = ganoTerritorio;
	}
	




}
