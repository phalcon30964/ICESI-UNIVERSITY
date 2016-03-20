package src.util.listas;

import src.util.Nods.Nodo;
import src.util.Nods.SimpleNod;

public class SimpleLinkedList<T>implements List<T> {
	
	
	protected SimpleNod<T> first;
	private int size;

	
	public T get(int i) {
		if(isEmpty()){
			return null;
		}else if(i>size-1){
			return null;
		}
		else{			
		SimpleNod<T> actual=first;
		int contador=0;
		while(i>contador){
			actual=actual.getNext();
			contador++;
			
		}
		return actual.getData();
		}

	}
	
	public SimpleLinkedList(){
		first=null;
		size=0;
	}
	
	public SimpleLinkedList(T e){
		first= new SimpleNod<T>(e);	
		size=1;
	}
	
	
	/**
	 * 
	 * @param e
	 */
	public void addAtbeginning(T e) {
		if(isEmpty()){
			first=new SimpleNod<T>(e);
			
		}
		else{
			
			SimpleNod<T> nuevo=new SimpleNod<T>(e);
			nuevo.setNext(first);
			first=nuevo;
			
		}
		size++;

	}
	
	public boolean isEmpty() {
		
		return  (first==null)? true:false;
	}

	/**
	 * Method that at the object e at the end of the list
	 * @param: generic element e
	 * 
	 */
	public void add(T e) {
		if(isEmpty()){
			first=new SimpleNod<T>(e) ;
			
		}else{
			SimpleNod<T> actual=first;
			while(actual.getNext()!=null){
				actual=actual.getNext();
			}
			actual.setNext(new SimpleNod<T>(e));
		}
		size++;
		

	}

	
	public void remove(int i) {
		if(i==0){
			first=first.getNext();
			size--;
		}else if(i>=getSize()){
			throw new IndexOutOfBoundsException();
			
		}else if(isEmpty()){
			
		}
		else{
			SimpleNod<T> actual=first;
			int contador=0;
			while(i-1>contador){
				actual=actual.getNext();
				contador++;
			}
			actual.setNext(actual.getNext().getNext());
			size--;
			
		}

	}

	
	public int getSize() {
		
		return size;
		
	}
	
	public Nodo<T> getFirst(){
		return first;
	}

	

}
