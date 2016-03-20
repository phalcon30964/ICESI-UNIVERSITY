package TADSortedSet;

import java.util.TreeSet;

import TADArbolBinario.ArbolABB;
import TADArbolBinario.INodoArbol;
import TADListaDoble.ListaDoble;

public class SortedSet<T extends Comparable<T>> implements ISortedSet<T> {
	
	/**
	 * Nombre: arbol
	 * 
	 * Atributo auxiliar que maneja la organizacion interna de los elementos del conjunto ordenado
	 */
	private ArbolABB<T,T> arbol;  
	
	/**
	 * Nombre: Crear
	 * 
	 * El metodo crear un nuevo SortedSet vacio
	 * 
	 * pos: Se ha creado una instacia de la clase SortedSet de longitud 0
	 */
	public SortedSet() {
		arbol = new ArbolABB<T,T>();
	}

	/**
	 * Metodo que permite agregar un elemento al conjunto ordenado, si el elemento ya existe entonces no se añade
	 * 
	 * pos: Se ha agregado un nuevo elemento al conjunto ordenado, y 
	 *      ha quedado despues del elemento menor mas cercano a el ya existente en el conjunto
	 * 
	 * @param e elemento a agregar
	 * @throws exception si el elemento que se intenta agregar ya existe en el conjunto
	 */
	@Override
	public void add(T e) throws Exception {
		 if (arbol.buscar(e)!=null) {
			throw new Exception("Elemento ya existe en el conjunto");
		}else{
		arbol.agregar(e, e);
		}
	}

	/**
	 * Metodo que permite eliminar un elemento del conjunto ordenado
	 * 
	 * pos: Se ha eliminado un elemento del conjunto y su longitud a disminuido en 1
	 * 
	 * @param e elemento a eliminar
	 * @throws exception si el conjunto es vacio 
	 * @throws exception si el elemento a eliminar no existe en el conjunto 
	 */
	@Override
	public void remove(T e) throws Exception {
		if(arbol.buscar(e)==null || arbol.getRaiz()==null){
			throw new Exception("No se pudo eliminar elemento");
		}
		arbol.eliminar(e);
	}

	/**
	 * Metodo que permie verrificar si un elemento pertenece al conjunto ordenado
	 *
	 * @param elemento a verificar si esta dentro del conjunto
	 * @return boolean false si el conjunto es vacio, o si el elemento no pertenece al conjunto.
	 *                 true si el elemento pertenece al conjunto
	 */
	@Override
	public boolean isElement(T e) {
		boolean respuesta = false;
		
		if(arbol.buscar(e)!=null){
			respuesta = true;
		}
		
		return  respuesta;
	}

	
	/**
	 * Metodo que permite genera un string con el toString de todos los elementos del conjunto
	 * 
	 * @param elemento a verificar si esta dentro del conjunto
	 * @return String con el toString de los objetos guardados en el conjunto, vacio si no hay elementos
	 * 
	 */
	@Override
	public String getSet() {
		return arbol.cadenaInorden();
	}

	/**
	 * Metodo que genera un SortedSet con los elementos del SortedSet pasado por parmetro y 
	 * los elementos del conjunto sobre el cual se invoca el metodo
	 * 
	 * @param s2 SortedSet a unir 
	 * @return SortedSet con los elementos del conjunto y el sortedset pasado por parametro
	 */
	@Override
	public SortedSet<T> intersection(SortedSet<T> s2) {
		
	SortedSet<T> copiaConjunto2 = null;
	
		try {
			copiaConjunto2 = new SortedSet<T>() ;
			
			ListaDoble<T> Conjunto1 = arbol.inordenT();
			
			for (int i = 0; i < Conjunto1.darLongitud(); i++) {
				
				T actual = Conjunto1.darElemento(i); 
				
				if(s2.isElement(actual)==true){
					copiaConjunto2.add(actual);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	

		return copiaConjunto2;
		
	}

	/**
	 * Metodo que genera un SortedSet con los elementos del SortedSet pasado por parmetro y 
	 * los elementos del conjunto sobre el cual se invoca el metodo
	 * 
	 * @param s2 SortedSet a unir 
	 * @return SortedSet con los elementos del conjunto y el sortedset pasado por parametro
	 */
	@Override
	public SortedSet<T> union(SortedSet<T> s2) {
		
		
		SortedSet<T> copiaConjunto2 = null;
		
		try {
			copiaConjunto2 = s2.clone();
			
			ListaDoble<T> Conjunto1 = arbol.inordenT();
			
			for (int i = 0; i < Conjunto1.darLongitud(); i++) {
				
				T actual = Conjunto1.darElemento(i); 
				
				if(copiaConjunto2.isElement(actual)==false){
					copiaConjunto2.add(actual);
				}
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		
		return copiaConjunto2;
	}
	
	
	/**
	 * Se sobre escribe el metodo clone de object para poder realizar copias del conjunto
	 * 
	 * @return SortedSet identico al sortedset sobre el que se invoca el metodo
	 */
	public SortedSet<T> clone(){
		
		SortedSet<T> clon = new SortedSet<T>();
		ListaDoble<T> lista = arbol.inordenT();
		
		for (int i = 0; i < lista.darLongitud(); i++) {
			
			try {
				clon.add(lista.darElemento(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return clon;
		
	}
	
}
