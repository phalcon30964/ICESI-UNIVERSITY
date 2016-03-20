package mundoRisk;

import java.io.Serializable;

import TadLista.ListaDoble;

public class CartaMision implements Serializable {
	
	private static final long serialVersionUID = 1871661772735528699L;

	private String tipoCarta;
	
	private String descripcion;
	
	private ListaDoble<Integer> territoriosAConquistar;
	
	
/**
 * Constructor de la clase Carta Mision , clase que maneja las misiones de un jugador
 * 
 * @param tipoCarta tipo de carta CARTA_MISION ó CARTA_TERRITORIO
 * @param descripcion descripcion que aparecera en la interfaz sobre la mision a cumplir
 * @param territoriosAConquistar lista de los territorios que el jugador debe poseer para 
 *        haber cumplido la mision que aparece en la descripcion 
 */
	public CartaMision(String tipoCarta, String descripcion, ListaDoble<Integer> territoriosAConquistar) {
		this.tipoCarta = tipoCarta;
		this.descripcion = descripcion;
		this.territoriosAConquistar = territoriosAConquistar;
	}
	
	/**
	 * 
	 * Dice el tipo de carta que es, tipo de carta CARTA_MISION ó CARTA_TERRITORIO
	 * 
	 * @return tipo de carta 
	 */
	public String getTipoCarta() {
		return tipoCarta;
	}

	
	/**
	 * Dice cual es la mision a cumplir
	 */
	
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo que calcula si la mision especifica de la carta ya fue cumplida por el 
	 *        jugador que le entra como parametro
	 *        
	 * @param nombrePropietario nombre del jugador el cual se quiere saber si cumplio la mision
	 * @return boolean true si ya la cumplio, false si no
	 */
	public boolean seCumplioMision(String nombrePropietario){
		
		ListaDoble<Territorio > t = TablaRisk.territorios.getVertices();
		int contador = 0;
		for (int i = 0; i < territoriosAConquistar.darLongitud(); i++) {
			if(t.darElemento(territoriosAConquistar.darElemento(i)).getPropietario()!=null && t.darElemento(territoriosAConquistar.darElemento(i)).getPropietario().getNombre().equals(nombrePropietario)){
				contador++;
			}
		}
		
		if(contador==territoriosAConquistar.darLongitud()){
			return true;
		}
		
		return false;	
	}
	
	/**
	 * Metodo que verifica si un territorio ayuda a cumplir la mision de la carta mision actual
	 * 
	 * @param territorio territorio que se desea saber si ayuda a cumplir mision
	 * @return true si ayuda, false sino
	 */
	public boolean territorioAyudaCumplirMision(Territorio territorio){
		
		ListaDoble<Territorio > t = TablaRisk.territorios.getVertices();
		
		for (int i = 0; i < territoriosAConquistar.darLongitud(); i++) {
			if(t.darElemento(territoriosAConquistar.darElemento(i)).compareTo(territorio)==0){
				return true;
			}
		}
		return false;
	}
	

	

}
