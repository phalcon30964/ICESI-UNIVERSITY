package TadGrafo;

public class Arista<T>{
	
	private T vertice1;
	private T vertice2;
	private int peso;
	
	public Arista(int peso, T vertice1, T vertice2){
		this.peso = peso;
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}

	public T getVertice1() {
		return vertice1;
	}

	public T getVertice2() {
		return vertice2;
	}

	public int getPeso() {
		return peso;
	}

	public void setVertice1(T vertice1) {
		this.vertice1 = vertice1;
	}

	public void setVertice2(T vertice2) {
		this.vertice2 = vertice2;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * Compara si dos aristas son iguales
	 * 
	 * pre: el parametro debe ser una arista
	 * 
	 * @param la arista con cual comparar
	 * @return true si son iguales, false de lo contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Arista<?>){
			Arista<T> otra = (Arista<T>)obj;
			if(peso==otra.getPeso() && vertice1.equals(otra.vertice1) && vertice2.equals(otra.vertice2)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compara dos aristas IGUALES por peso
	 * 
	 * @param arista con la cual comprar
	 * @return 0 si son iguales los pesos, numero menor que 0 si se es menor, numero mayor que sero si se es mayor
	 */
	public int compareTo(Arista<T> arg0) {
        return peso - arg0.peso;
    }

}
