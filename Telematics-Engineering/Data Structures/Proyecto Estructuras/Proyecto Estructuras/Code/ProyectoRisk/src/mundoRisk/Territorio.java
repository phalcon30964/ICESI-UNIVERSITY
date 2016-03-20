package mundoRisk;

import java.io.Serializable;

import TadLista.ListaDoble;

public class Territorio implements Serializable, Comparable<Territorio>{

	private static final long serialVersionUID = 8649459999010685865L;

	private String nombre;
	
	private String continente;
	
	private int[] tropas;
	
	private int numTropasOcupandoTerritorio;
		
	private Jugador propietario;
	
	/**
	 * Constructor de la clase territorio 
	 * 
	 * @param nombre del territorio geografico
	 * @param continente al que pertenece el territorio
	 * @param territoriosVecinos lista de territorios adyacentes
	 */
	public Territorio(String nombre, String continente ) {
		this.nombre = nombre;
		this.continente = continente;
		this.tropas = new int[3];
		this.propietario = null;
	}
	
	/**
	 * Metodo que agrega una tropa al territorio
	 * 
	 * pre: el numero de tropas a agregar es != 0
	 *      el tipo de tropa debe ser un numero entre 0 y 2
	 * 
	 * @param numeroDeTropas numero de tropas a agregar en el territorio
	 */
	public void agregarTropas(int numeroDeTropasAgregar){
		
		numTropasOcupandoTerritorio+= numeroDeTropasAgregar;
		
		for (int i = 0; i < numeroDeTropasAgregar; i++) {
			
			if(tropas[0]<5){
				tropas[0]++;
			}else{
				tropas[0]=1;
				if(tropas[1]<6){
					
					tropas[1]++;
				}else{
					tropas[1] = 5;
					
					tropas[2]++;
				}
			}
		}
		
	}
	
	/**
	 * Metodo que elimina la cantidad de tropas pasada por parametro de la lista de tropas que ocupan el territorio
	 * 	
	 * @param numTropasAEliminar numero de tropas a eliminar
	 * @throws lanza exception cuando no hayan suficientes tropas para eliminar
	 * 
	 */
	public void eliminarTropas(int numTropasAEliminar)throws Exception{
		
		if((numTropasOcupandoTerritorio-numTropasAEliminar)<0){
			throw new Exception("No se puede eliminar el numero de tropas pasado por parametro");
		}
		
		numTropasOcupandoTerritorio -= numTropasAEliminar;
		
		for (int i = 0; i < numTropasAEliminar; i++) {
			
			if(tropas[0]==1 && tropas[1]== 0){
				tropas[0] = 0;
			}else{
				
				if(tropas[0]>1){
					tropas[0]--;
				}else{
					
					tropas[0]=5;
					
					if(tropas[1]==4 && tropas[2]>0){
						tropas[1]=5;
						tropas[2]--;
					}else{
						tropas[1]--;
					}
				}
			}
		}
	}
	

	/**
	 * Metodo que verifica si el territorio pasado por parametro es adyacente del territorio actual
	 * 
	 * @param territorio a verificar si es adyacente
	 * @return true si es adyacente, false de lo contrario
	 */
	public boolean esAdyacente(Territorio territorio){
		ListaDoble<Territorio> adyacentes = TablaRisk.territorios.getAdyacentes(this);
		
		for (int i = 0; i < adyacentes.darLongitud(); i++) {
			if(adyacentes.darElemento(i).compareTo(territorio)==0){
				return true;
			}
		}
		
		return false;
	}
	@Override
	public int compareTo(Territorio o) {
		return this.nombre.compareTo(o.getNombre());
	}

	public String getNombre() {
		return nombre;
	}

	public String getContinente() {
		return continente;
	}

	public int[] getTropas() {
		return tropas;
	}

	public int getNumTropasOcupandoTerritorio() {
		return numTropasOcupandoTerritorio;
	}

	public Jugador getPropietario() {
		return propietario;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public void setNumTropasOcupandoTerritorio(int numTropasOcupandoTerritorio) {
		this.numTropasOcupandoTerritorio = numTropasOcupandoTerritorio;
	}

	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}
	
	
	
}
