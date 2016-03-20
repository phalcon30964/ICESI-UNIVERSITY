package TadTablaHash;

import java.lang.reflect.Array;

public class TablaHash<K,E> implements IntefaceTablaHash<K,E>{
	
	private int capacidad;
	
	private int tama�o;
	
	private double factorCarga;
	
	private double limiteFactorCarga;
	
	private bucket<K,E>[] tabla;
	
	public TablaHash(int capacidad, double limiteFactorCarga){
		
		this.capacidad = capacidad;
		this.limiteFactorCarga = limiteFactorCarga;
//		this.tabla = new bucket[capacidad];
		final bucket<K,E>[] temp = (bucket<K,E>[])Array.newInstance(bucket.class, capacidad);
		this.tabla=temp;
		
		//factor de carga debe estar entre 0 y 1
	}
	
	public int hashFunction(K key){
		return (int)(tama�o*((key.hashCode()*0.61803)%1));
	}
	
	//buscar 

	@Override
	//si la clase del objeto que entra como key no tiene sobreescrito el metodo hashcode, puede ocurrir que dos claves iguales den 2 direcciones diferentes
	
	//este metodo agregara con direccionamiento directo y sondeo lineal
	public void agregar(K key, E elemento) {
		
		int pos = hashFunction(key);
		//
		
		//se 
	
		
		
	}
	

	@Override
	public void eliminar(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E buscar(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCapacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getFactorCarga() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
