package src.util.listas;

import src.util.Nods.DoubleNod;

public class DoubleLinkedList<T> implements List<T> {

	private DoubleNod<T> first;
	private DoubleNod<T> last;

	public DoubleLinkedList() {
		first = null;
		last = null;
	}

	public DoubleLinkedList(T e) {
		first = new DoubleNod<T>(e);
		last = first;
	}

	public T get(int i) {
		DoubleNod<T> actual;

		if (isEmpty()) {
			actual = null;
		} else if (i > getSize() - 1) {
			actual = null;
		}else if(i>=getSize()){
						
			throw new IndexOutOfBoundsException();
			
		}else if (i <= (getSize() / 2) - 1) {
			actual = first;
			int contador = 0;
			while (i > contador) {
				actual = actual.getNext();
				contador++;
			}
		} else {
			actual = last;
			int contador = 1;
			while (getSize()-i > contador) {
				actual =  actual.getPrev();
				contador++;
			}

		}
		return (T) actual.getData();

	}

	public boolean isEmpty() {

		return (first == null) ? true : false;
	}

	

	public int getSize() {
		int contador = 0;
		DoubleNod<T> actual = first;
		while (actual != null) {
			actual = actual.getNext();
			contador++;
		}

		return contador;
	}

	public void add(T e) {
		DoubleNod<T> nuevo=new DoubleNod<T>(e);
		if(isEmpty()){
			first=nuevo;
			last=nuevo;
		}
		else{
			nuevo.setPrev(last);
			last.setNext(nuevo);
			last=nuevo;
		}
		

	}

	public void remove(int i) {
		if(i==0){
			first=first.getNext();
		}else if(i==getSize()-1){
			last=last.getPrev();			
		}else if(i>=getSize()){
			throw new IndexOutOfBoundsException();
		}else if(isEmpty()){
		
		}else{
			DoubleNod<T> actual;
		
			 if (i <= (getSize() / 2) - 1) {
				actual = first;
				int contador = 0;
				while (i > contador) {
					actual = actual.getNext();
					contador++;
				}
				actual.getNext().setPrev(actual.getPrev());
				actual.getPrev().setNext(actual.getNext());
			} else {
				actual = last;
				int contador = 0;
				while (getSize()-i > contador) {
					actual =  actual.getPrev();
					contador++;
				}
				actual.getPrev().setNext(actual.getNext());
				actual.getNext().setPrev(actual.getPrev());			
			}	
		}
		

	}

}
