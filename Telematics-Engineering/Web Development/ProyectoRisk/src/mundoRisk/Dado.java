package mundoRisk;

import java.io.Serializable;

import TadLista.ListaOrdenada;

public class Dado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo estatico de la clase dado, el cual se encarga de generar un numero aletario 
	 * entre 0 y 6, representando asi el comportamiento natural de un dado real 
	 * 
	 * @return numero aleatorio entre 1 y 6
	 */
	public static final ListaOrdenada<Integer> tirarDados(int numDados){
		ListaOrdenada<Integer>  dados = new ListaOrdenada<Integer>(false);
		for (int i = 0; i < numDados; i++) {
			dados.agregar((int)((Math.random()*6)+1));
		}
		return dados;
	}
	
}
