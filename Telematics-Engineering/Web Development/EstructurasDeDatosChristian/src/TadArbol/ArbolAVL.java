package TadArbol;

public class ArbolAVL<K extends Comparable<K>,T> extends ArbolABB<K, T>{
	
	public void agregar(K key, T contenido) throws Exception{
		NodoAVL<K, T> nuevo = new NodoAVL<K, T>(key, contenido);
		super.agregar(nuevo);
		balancear(nuevo);
		
	}
	
	public void eliminar(K key) {
		INodoArbol<K, T> nodoAEliminar = buscarNodo(key);
		if (nodoAEliminar != null) {
			eliminar(nodoAEliminar);
		}
		
		balancear((NodoAVL<K, T>)nodoAEliminar);
		
	}
	
	
	//pre//tiene que ser hoja
	public void balancear(NodoAVL<K, T> nodo){
		
		NodoAVL<K,T> actual = nodo;
		NodoAVL<K,T> padre = (NodoAVL<K, T>)actual.getPadre();
		
		boolean balanceado = false;
		
		
		while(padre!=null && !balanceado ){
			
			if(padre.getIzq()==actual){
				padre.setFactorBalanceo(padre.getFactorBalanceo()-1);
				if(padre.getFactorBalanceo()==0){
					balanceado = true;
				}
			}else{
				padre.setFactorBalanceo(padre.getFactorBalanceo()+1);
				if(padre.getFactorBalanceo()==0){
					balanceado = true;
				}
			}
			
			if(padre.getFactorBalanceo()==2){
				if(actual.getFactorBalanceo()==1){
					rotarIzq(padre);
					balanceado = true;
				}
			}
			
			if(padre.getFactorBalanceo()==-2){
				if(actual.getFactorBalanceo()==-1){
					rotarDer(padre);
					balanceado = true;
					
				}
			}
			
			if(padre.getFactorBalanceo()==2){
				if(actual.getFactorBalanceo()==-1){
					rotarDerIzq(padre);
					balanceado = true;
					//izq al actual y derecha al padre
				}
			}
			
			if(padre.getFactorBalanceo()==-2){
				if(actual.getFactorBalanceo()==1){
					rotarIzqDer(padre);
					balanceado = true;
					//dercho al actual y izquierdo al padre
				}
			}
			
			actual = (NodoAVL<K, T>) actual.getPadre();
			padre = (NodoAVL<K, T>) padre.getPadre();
		}
	}
	
	public void rotarDer(NodoAVL<K, T> nodo){ 
		
		NodoAVL<K,T> aux = new NodoAVL<K,T>(nodo.getKey(), nodo.getContenido());
		
		aux.setDer(nodo.getDer());
		if(aux.getDer()!=null){aux.getDer().setPadre(aux);}
		aux.setIzq(nodo.getIzq().getDer());
		if(aux.getIzq()!=null){aux.getIzq().setPadre(aux);}
		
		nodo.setContenido(nodo.getIzq().getContenido());
		nodo.setKey(nodo.getIzq().getKey());
		
		nodo.setDer(aux);
		aux.setPadre(nodo);
		
		nodo.setIzq(nodo.getIzq().getIzq());
		nodo.getIzq().setPadre(nodo);
		
		nodo.setFactorBalanceo(0);
		((NodoAVL<K, T>)nodo.getDer()).setFactorBalanceo(0);
	
	}
	
	public void rotarIzq(NodoAVL<K, T> nodo){ 
		
		NodoAVL<K,T> aux = new NodoAVL<K,T>(nodo.getKey(), nodo.getContenido());
		
		aux.setIzq(nodo.getIzq());
		if(aux.getIzq()!=null){aux.getIzq().setPadre(aux);}
		aux.setDer(nodo.getDer().getIzq());		
		if(aux.getDer()!=null){aux.getDer().setPadre(aux);}
		
		nodo.setContenido(nodo.getDer().getContenido());
		nodo.setKey(nodo.getDer().getKey());
		
		nodo.setIzq(aux);
		aux.setPadre(nodo);
		
		nodo.setDer(nodo.getDer().getDer());
		nodo.getDer().setPadre(nodo);
		
		nodo.setFactorBalanceo(0);
		((NodoAVL<K, T>)nodo.getIzq()).setFactorBalanceo(0);
		
	}
	
	public void rotarIzqDer(NodoAVL<K, T> nodo){
		
		NodoAVL<K, T> auxIzq = new NodoAVL<K, T>(nodo.getIzq().getKey(), nodo.getIzq().getContenido());
		auxIzq.setIzq(nodo.getIzq().getIzq());
		auxIzq.setDer(nodo.getIzq().getDer().getIzq());
		if(auxIzq.getDer()!=null){auxIzq.getDer().setPadre(auxIzq);}
		
		nodo.setIzq(nodo.getIzq().getDer());
		if(nodo.getIzq()!=null){
		nodo.getIzq().setPadre(nodo);
		}
		nodo.getIzq().setIzq(auxIzq);
		auxIzq.setPadre(nodo.getIzq());
		
		rotarDer(nodo);
		
		nodo.setFactorBalanceo(0);
		

		
	}
	
	public void rotarDerIzq(NodoAVL<K, T> nodo){
		
		NodoAVL<K, T> auxDer = new NodoAVL<K, T>(nodo.getDer().getKey(), nodo.getDer().getContenido());
		auxDer.setDer(nodo.getDer().getDer());
		auxDer.setIzq(nodo.getDer().getIzq().getDer());
		if(auxDer.getIzq()!=null){auxDer.getIzq().setPadre(auxDer);}

		
		nodo.setDer(nodo.getDer().getIzq());
		if(nodo.getDer()!=null){
		nodo.getDer().setPadre(nodo);
		}
		nodo.getDer().setDer(auxDer);
		auxDer.setPadre(nodo.getDer());
		
		rotarIzq(nodo);
		
		nodo.setFactorBalanceo(0);
		
	}
	
	
	
	
	/**
	 * 
	 */
}
