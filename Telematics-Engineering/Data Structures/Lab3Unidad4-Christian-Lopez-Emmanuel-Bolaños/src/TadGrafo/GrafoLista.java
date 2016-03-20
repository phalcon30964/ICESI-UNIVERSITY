package TadGrafo;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;

import TadCola.Cola;
import TadColaPrioridad.ColaPrioridad;
import TadLista.ListaDoble;
import TadPila.Pila;


public class GrafoLista<T> implements IGrafo<T>, IGraph<T>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static int MAX_VERTICES = 42;
	
	private int numVertices;
	
	private int numAristas;
	
	private T[] vertices;
	
	private ListaDoble<Arista<T>>[] aristas;
	
	private boolean isDirigido;
	
	/**
	 * Constructor de la clase grafo, crea un grafo vacio de tamaño MAX_VERTICES, recibe un booleano para indicar
	 * si el grafo a crear es dirigido o no
	 * 
	 * pre:true
	 * 
	 * @param isDirigido true si el grafo a crear es dirigido, false si en no dirigido
	 */
	@SuppressWarnings("unchecked")
	public GrafoLista(boolean isDirigido) {
	
		numVertices = 0;
		numAristas = 0;
		vertices = (T[])new Object[MAX_VERTICES];
		aristas = (ListaDoble<Arista<T>>[])Array.newInstance(ListaDoble.class, MAX_VERTICES);
		
		this.isDirigido = isDirigido;
		
	}
	

	/**
	 * Metodo que adiciona un nuevo elemento a la lista de vertices, el metodo ademas 
	 * crea una lista de adyacencias correspondiente al vertice que se esta agregando.
	 * Ademas aumenta el indicador de vertices en 1
	 * 
	 * pre:true 
	 * pos:se ha agregado un nuevo vertice al arreglo de vertices
	 *     se ha inicializado una lista de aristas para representar la lista de adyacencias del vertice insertado
	 *     se ha actualizado el indicador de vertices en +1
	 * 
	 * @param vertice Elemento a agregar al grafo
	 * @throws Exception si ya existe el vertice que se trata de agregar
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void agregarVertice(T vertice)throws Exception{
		
		if(existeVertice(vertice)){
			throw new Exception("Ya existe el vertice a agregar");
		}
		
		int pos = 0;
		T actual = vertices[pos];
		
		while(actual!=null){
			pos++;
			actual = vertices[pos];
		}
		
		if(pos<MAX_VERTICES && pos>=0){
			vertices[pos] = vertice;
			aristas[pos] = new ListaDoble<Arista<T>>();
		}else{
			
			T[] temp = (T[])new Object[MAX_VERTICES*2];
			for (int i = 0; i < MAX_VERTICES; i++) {
				temp[i] = vertices[i]; 
			}
			
			ListaDoble<Arista<T>>[] temp2 = (ListaDoble<Arista<T>>[])Array.newInstance(ListaDoble.class, MAX_VERTICES*2);
			
			for (int i = 0; i < MAX_VERTICES; i++) {
				temp2[i] = aristas[i]; 
			}
			
			vertices = temp;
			aristas = temp2;
			
			vertices[pos] = vertice;
			aristas[pos] = new ListaDoble<Arista<T>>();
			
		}
		
		numVertices++;
	}
	
	/**
	 * Metodo que verifica si un vertice ya existe en el de vertices del grafo, es decir en el arreglo de vertices.
	 * 
	 * pre: la clase que hace de vertice tiene el equals() implementado
	 *      vertices[]!= null
	 * 
	 * @param vertice el vertice a verificar si existe en el grafo
	 * @return true si ya existe el elemento, false de lo contrario
	 */
	@Override
	public boolean existeVertice(T vertice){
		for (int i = 0; i < vertices.length; i++) {
			if(vertices[i]!=null && vertices[i].equals(vertice)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Metodo que agrega una arista a la lista de arristas, la cual tiene como inicio el vertice1 y 
	 * fin el vertice 2 pasado por parametro, ademas se agrega el atributo peso para indicar la importancia de la arista
	 * 
	 * pre: los vertices 1 y 2 deben existir en el conjunto de vertices
	 * pos: se ha creado una nueva arista en el arreglo de aristas
	 * 
	 * @param peso peso de la arista
	 * @param vertice1 vertice origen de la arista
	 * @param vertice2 vertice final de la arista
	 * @throws Exception si ya existe la arista a crear
	 */
	@Override
	public void agregarArista(int peso, T vertice1, T vertice2)throws Exception {
		
		if(existeArista(peso, vertice1, vertice2)){
			throw new Exception("Arista ya existe");
		}
		
		int posV1 = buscarPosVertice(vertice1);
		Arista<T> nueva = new Arista<T>(peso, vertice1, vertice2);
		
	
			aristas[posV1].agregar(nueva);
			
		if(!isDirigido){// si no es dirigido ademas debe hacer esto
			int posV2 = buscarPosVertice(vertice2);
			Arista<T> nueva1 = new Arista<T>(peso, vertice2, vertice1);
			
			aristas[posV2].agregar(nueva1);
			numAristas++;
		}
		numAristas++;
	}
	
	/**
	 * Metodo que se encarga de revizar si existe una arista que comience en el parametro
	 * vertice1 y termine en el parametro vertice2
	 * 
	 * pre: la lista de aristas debe estar inicializada
	 *      los vertices parametro deben estar en el grafo
	 * 
	 * @param vertice1 vertice origen de la arista
	 * @param vertice2 vertice final de la arista
	 * @return true si existe una arista entre vertice1 y vertice2, false de lo contrario
	 */
	@Override
	public boolean existeArista(int peso, T vertice1, T vertice2) {
			int posV1 = buscarPosVertice(vertice1);
			if(posV1!=-1){
				for (int i = 0; i < aristas[posV1].darLongitud(); i++) {
					if(aristas[posV1].darElemento(i).getVertice2().equals(vertice2) && aristas[posV1].darElemento(i).getPeso()==peso){
						return true;
					}
				}
			}
		return false;
	}
	
	/**
	 * Metodo que busca la posicion de un vertice en el arreglo de vertices
	 * 
	 * pre: el arreglo de vertices esta inicilizado
	 * 
	 * @param vertice elemento a buscar posicion
	 * @return int posicion del elemento buscado, -1 si no se encuentra
	 */
	private int buscarPosVertice(T vertice){
		for (int i = 0; i < vertices.length; i++) {
			if(vertices[i]!=null && vertices[i].equals(vertice)){
				return i;
			}
		}
		return -1;	
	}
	
	/**
	 * Metodo que elemina un vertice del grafo con todos sus aristas
	 * 
	 * pre: vertice !=null
	 *      vertices[] != null
	 * pos: se ha disminuido un vertice en el grado
	 * 
	 * @param vertice a eliminar del grafo
	 */
	public void eliminarVertice(T vertice){
		
		int posV = buscarPosVertice(vertice);
		
		vertices[posV] = null;
		aristas[posV] = null;
		
		for (int i = 0; i < aristas.length; i++) {
			if(aristas[i]!=null){
				for (int j = 0; j < aristas[i].darLongitud(); j++) {
					if(aristas[i].darElemento(j).getVertice2().equals(vertice)){
						try {
							aristas[i].eliminar(j);
							numAristas--;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		numVertices--;
	}
	
	/**
	 * Metodo que elimina una arista del grafo
	 * 
	 * pre: vertice1 != null && vertice2 !=  null
	 * pos: el grafo ahora tiene 1 arista menos
	 * 
	 * @param vertice1 vertice origen de la arista
	 * @param vertice2 vertice final de la arista
	 * @peso int peso de la arista
	 */
	public void eliminarArista(int peso, T vertice1, T vertice2){
		if(existeArista(peso, vertice1, vertice2)){
			
			int posV = buscarPosVertice(vertice1);
			Arista<T> temp = new Arista<T>(peso,vertice1,vertice2);
			boolean eliminada = false;
			
			//si es dirigido hace esto
				for (int i = 0; i < aristas[posV].darLongitud() && !eliminada ; i++) {
					if(aristas[posV].darElemento(i).equals(temp)){
						try {
							aristas[posV].eliminar(i);
							eliminada =true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				
			// si no es dirigido hace esto ademas
				
				if(!isDirigido){
					
					
				eliminada = false;
				int posV2 = buscarPosVertice(vertice2);
				Arista<T> temp2 = new Arista<T>(peso, vertice2, vertice1);
				
					for (int i = 0; i < aristas[posV2].darLongitud() && !eliminada ; i++) {
						if(aristas[posV2].darElemento(i).equals(temp2)){
							try {
								aristas[posV].eliminar(i);
								eliminada =true;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				numAristas--;
				}
				
				numAristas--;
				
			}		
	}
	
	/**
	 * Metodo que devuelve la lista de vertices adyacentes a un vertice
	 * 
	 * pre: vetice!=null
	 * 
	 * @param vertice al cual se desea obtener sus adyacentes
	 * @return ListaDoble<T> de vertices adyacentes
	 */
	@Override
	public ListaDoble<T> getAdyacentes(T vertice) {
		
		int posV = buscarPosVertice(vertice);
		ListaDoble<T> lista = new ListaDoble<T>();
	
		if(posV!=-1){	
			for (int i = 0; i < aristas[posV].darLongitud(); i++){
				lista.agregar((T) aristas[posV].darElemento(i).getVertice2());
			}
		}

		return lista;
	}

	/**
	 * Retorna el numero de vertices en el grafo
	 * 
	 * @return int numero de vertices
	 */
	@Override
	public int getNumVertices() {
		return this.numVertices;
	}

	/**
	 * Retorna el numero de aristas del grafo
	 * 
	 * @return int numero de aristas 
	 */
	@Override
	public int getNumAristas() {
		return this.numAristas;
	}

	/**
	 * Retorna un booleano que indica si el grafo es dirigido o no
	 * 
	 * @return boolean true, si el grafo es dirigido , false si no lo es
	 */
	@Override
	public boolean isDirigido() {
		return this.isDirigido;
	}

	/**
	 * Retorna el arreglo de vertices del grafo
	 * 
	 * @return T[] arreglo de vertices
	 */
	@Override
	public ListaDoble<T> getVertices() {
		
		ListaDoble<T> recorrido = new ListaDoble<T>();
		for (int i = 0; i < MAX_VERTICES; i++) {
			if(vertices[i]!=null){
			 recorrido.agregar(vertices[i]);
			}
			
		}
		return recorrido;
	}
	
	public T getVertice(int i){
		return vertices[i];
	}

	/**
	 * Devuelve el arreglo de lista de aristas de los vertices
	 * 
	 * @return ListaDoble<Arista>[] de los vertices
	 */
	@Override
	public ListaDoble<Arista<T>> getAristas() {
		
		ListaDoble<Arista<T>> lista = new ListaDoble<Arista<T>>();
		for (int i = 0; i < aristas.length; i++) {
			if(aristas[i]!=null){
				for (int j = 0; j < aristas[i].darLongitud(); j++) {
					if(aristas[i].darElemento(j)!=null){
						lista.agregar(aristas[i].darElemento(j));
					}
				}
			}
		}
		
		return lista;
	}

	@Override
	public ListaDoble<T> getCamino(T vertice1, T vertice2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUnilateralmenteConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompletamenteConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAciclico() {
 
		//recorro en amplitud, y si encuento uno que esta ya visitado pero en la distancia en la lista desde el que estoy visitando es mayor que 
		// 1 significa que no es el que acabo de encontrar y por lo tanto 
		
		return false;
	}

	/**
	 * Metodo que recorre el grafo en amplitud , es decir primero se visita  a los vertices 
	 * adyacentes antes de considerar recorrer los adyacentes de sus vecinos
	 * 
	 * pre: vertice!=null
	 *      vertice debe existir en la lista de vertices
	 * 
	 * @param vertice fuente desde donde se empezará el recorrido
	 */
	@Override
	public ListaDoble<T> recorridoAmplitud(T vertice) {
		
		Hashtable<T,Boolean> tablaMarcados = new Hashtable<T,Boolean>();
		Cola<T> colaVisitados = new Cola<T>();
		ListaDoble<T> recorrido = new ListaDoble<T>();
		
		if(numVertices!=0){
			for (int i = 0; i < numVertices; i++) {
				if(vertices[i]!=null){
					tablaMarcados.put(vertices[i], false);
				}
				
			}
					
			recorrido.agregar(vertice);
			colaVisitados.enQueue(vertice);
			tablaMarcados.put(vertice, true);
			
			
			while(!colaVisitados.isEmpty()){
				
				T actual = colaVisitados.deQueue();
				
				if(!tablaMarcados.get(actual)){
					recorrido.agregar(actual);
					tablaMarcados.put(actual, true);
				}
				
				ListaDoble<T> adyacentesDeActual = getAdyacentes(actual);
				
				for (int i = 0; i < adyacentesDeActual.darLongitud(); i++) {
					if(!tablaMarcados.get(adyacentesDeActual.darElemento(i))){
					colaVisitados.enQueue(adyacentesDeActual.darElemento(i));
					}
				}
			}
		}
		
		return recorrido;
	}

	/**
	 * Metodo que recorre el grafo en profundidad, primero recorre el camino mas largo que pueda antes de 
	 * considerar un camino alternativo
	 * 
	 * pre: vertice!=null
	 *      vertice debe existir en la lista de vertices
	 *      
	 * @param vertices fuente desde donde comienza el recorrido
	 * 
	 */
	@Override
	public ListaDoble<T> recorridoProfundidad(T vertice) {

		Hashtable<T,Boolean> tablaMarcados = new Hashtable<T,Boolean>();
		Pila<T> pilaVisitados = new Pila<T>();
		ListaDoble<T> recorrido = new ListaDoble<T>();
		
		if(numVertices!=0){
		//creo tabla de marcar con todos en desactivado
			for (int i = 0; i < numVertices; i++) {
				if(vertices[i]!=null){
					tablaMarcados.put(vertices[i], false);
				}
				
			}
				
			//ingreso al primero lo agrego a la lista de recorrido y lo marco como visitado
			recorrido.agregar(vertice);
			pilaVisitados.push(vertice);
			tablaMarcados.put(vertice, true);
			
			
			while(!pilaVisitados.isEmpty()){
				
				//saco elemento, miro si ya fue visitado, si no esta marcado 
				//entonces los agrego a los ya visitados y lo marco como visitado
				T actual = null;
				
				try {
					actual = pilaVisitados.pop();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(!tablaMarcados.get(actual)){
					recorrido.agregar(actual);
					tablaMarcados.put(actual, true);
				}
				
				//agrego sus adyacentes a la pila
				ListaDoble<T> adyacentesDeActual = getAdyacentes(actual);
				
				for (int i = 0; i < adyacentesDeActual.darLongitud(); i++) {
					if(!tablaMarcados.get(adyacentesDeActual.darElemento(i))){
						pilaVisitados.push(adyacentesDeActual.darElemento(i));
						}
				}
			
			}
		}
		
		return recorrido;

	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public TreeSet<Arista<T>> generarConjuntoAristas(){
		TreeSet<Arista<T>> arbol = new TreeSet<Arista<T>>();
		ListaDoble<Arista<T>> lista = getAristas();
		for(int i = 0; i < lista.darLongitud(); i++){
			arbol.add(lista.darElemento(i));
		}
		return arbol;
	}
	
	public TreeSet<Arista<T>> encontrarConjunto(T vertice, ArrayList<TreeSet<Arista<T>>> conjuntos)
    {
        for(int i=0; i<conjuntos.size(); i++)
        {
            TreeSet<Arista<T>> ar = conjuntos.get(i);
            Iterator<Arista<T>> it = ar.iterator();
            while(it.hasNext())
            {
                Arista<T> arista = it.next();
                if(arista.getVertice1().equals(vertice) || arista.getVertice2().equals(vertice))
                    return ar;
            }
        }
        return null;
    }
	
	private void unirArboles(TreeSet<Arista<T>> ar1, Arista<T> arista, TreeSet<Arista<T>> ar2, ArrayList<TreeSet<Arista<T>>> conjuntos)
    {
        ar1.addAll(ar2);
        ar1.add(arista); 
        conjuntos.remove(ar2);
    }
	
	public TreeSet<Arista<T>> kruskal()
	{
		TreeSet<Arista<T>> aristas = generarConjuntoAristas();
		ArrayList<TreeSet<Arista<T>>> conjuntos = new ArrayList<>();
		Iterator<Arista<T>> it = aristas.iterator();
		while(it.hasNext())
		{
			Arista<T> arista = it.next();
			T vertice1 = arista.getVertice1();
			T vertice2 = arista.getVertice2();

			TreeSet<Arista<T>> t1 = encontrarConjunto(vertice1, conjuntos);
			TreeSet<Arista<T>> t2 = encontrarConjunto(vertice2, conjuntos);   

			if((t1 != null && t2 != null) && t1 != t2)
				unirArboles(t1, arista, t2, conjuntos);
			else if(t1 == null || t2 == null)
			{
				if(t1 != null)                            
					t1.add(arista);
				else if(t2 != null)
					t2.add(arista);
				else
				{
					TreeSet<Arista<T>> t = new TreeSet<Arista<T>>();
					t.add(arista);
					conjuntos.add(t);
				}
			}
		}
		TreeSet<Arista<T>> res = new TreeSet<>();
		for(int i = 0; i<conjuntos.size();i++)
			res.addAll(conjuntos.get(i));
		return res;
	}


	@Override
	public Collection<IVertex<T>> getVerticesList() {
		
		ArrayList<IVertex<T>> lista = new ArrayList<IVertex<T>>();
		ListaDoble<T> vertices = getVertices();
		for (int i = 0; i < vertices.darLongitud(); i++) {
			lista.add(new Vertex<T>(vertices.darElemento(i).toString(), vertices.darElemento(i)));
			
		}
		
		return lista;
		
	}
	
	@Override
	public Collection<IEdge<T>> getEdges() {
//		ListaDoble<T> lista = recorridoAmplitud(vertices[0]);
//		ArrayList<IEdge<T>> aristas =new ArrayList<IEdge<T>>();
//		
//		for (int i = 0; i < lista.darLongitud(); i++) {
//			
//			aristas.add(new Edge<GrafoLista.T>(iv, tv))
//			
//		}
		
		return null;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------


	@Override
	public int countVertex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int countEdges() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Metodo que devuelve la primera arista que encuentre en el grafo que comience en el vertice1 y que llega hasta el vertice2
	 *  
	 * @param vertice1 incio de la arista
	 * @param vertice2 fin de la arista
	 * @return Arista buscada
	 */
	private Arista<T> getArista(T vertice1, T vertice2){
		
		int posV1 = buscarPosVertice(vertice1);
		int posV2 = buscarPosVertice(vertice2);
		
		if(posV1!=-1 && posV2!=-1){
		
			for (int i = 0; i < aristas[posV1].darLongitud(); i++) {
				if (aristas[posV1].darElemento(i).getVertice2().equals(vertice2)) {
					return aristas[posV1].darElemento(i);
				}
			}	
		}
		return null;
	}
	
	/**
	 * Prim, metodo que devuelve un subgrafo del grafo con las aristas que conectan
	 * todos los vertices con menor peso
	 * 
	 * pre:el vertice pasado por parametro!=null
	 *        vertice pasado por parametro pertenece al grafo
	 *        
	 * @param T vertice desde el cual comenzar el recorrido
	 * @return Grafo, subgrafo MST
	 */
	 public GrafoLista<T> prim(T verticeFuente){

		 GrafoLista<T> MST = new GrafoLista<T>(false);
		 
		 int posFuente = buscarPosVertice(verticeFuente);
	 
		 
		 if(posFuente!=-1){
			//copio todos los vertices del grafo original MST
			 ListaDoble<T> verticesDelOrginal = getVertices();
			 for (int i = 0; i < verticesDelOrginal.darLongitud(); i++) {
				try {
					MST.agregarVertice(verticesDelOrginal.darElemento(i));
				} catch (Exception e) {e.printStackTrace();}
			}
			 
			 //Creo arreglo de padres y distancia, y la cola de minima prioridad
			 int[] padres = new int[numVertices];
			 int[] distancias = new int[numVertices];
			 ColaPrioridad<T> noVisitados = new ColaPrioridad<T>();
			 
			 //Inicilizo padres con null "-1" y distancias infinito ".MaxValue"
			 for (int i = 0; i < numVertices; i++) {
				padres[i] =  -1; 
				distancias[i] = Integer.MAX_VALUE;
			 }
			 
			 //Indico que la distancia del vertice fuente es 0
			 distancias[posFuente] = 0;
			 
			 //Inicializo la cola de prioridades metiendo cada vertice en la cola de prioridades 
			 //y poniendole como prioridad su distancia
			 
			 
			 ListaDoble<T> vertices = getVertices();
			 
			 for (int i = 0; i < vertices.darLongitud(); i++) {
				 noVisitados.enQueue(distancias[i], vertices.darElemento(i));
			 }
			 
			 //Aqui empieza el algoritmo de prim			 
			 while (!noVisitados.isEmpty()) {
				 //U es el vertice con menor prioridad de la cola, en cada iteracion y el se eliminar de ella en cada iteracion
				 T u = noVisitados.deQueue();
				 int posU = buscarPosVertice(u);
				 
				 if(padres[posU]!=-1){
					 Arista<T>  a = getArista(u,getVertice(padres[posU]));
					 try {
						MST.agregarArista(a.getPeso(), a.getVertice1(), a.getVertice2());
					} catch (Exception e) {
						e.printStackTrace();
					}
				 }
				 
				 ListaDoble<T> adyacentes =  getAdyacentes(u);
				 
				 for (int i = 0; i < adyacentes.darLongitud(); i++) {
					 
					 T v = adyacentes.darElemento(i);
					 int posV = buscarPosVertice(v);
					 Arista<T>  a = getArista(u, v);
					 
					 //si el nodo adyacente que acabo de sacar esta en la cola y el peso de la arista que va desde el elemento que saque de la
					 //cola hasta el vertices adyacente i que tiene posicion posv es menor que el la prioridad del adyacente i dentro de la cola
					 if(noVisitados.buscarElemento(v)!=null && a.getPeso()<distancias[posV]){
						 
						 //el padre del adyacente es el ultimo elemento sacado de la cola
						 padres[posV] = posU;
						 //la prioridad del adyacente es la de la arista 
						 distancias[posV] = a.getPeso();
						 //agrego la arista al nuevo grafo
					 }
					 
				}
				 
				 //actualizar la cola, saco todos los elementos de la cosa y los vuelvo a meter con la prioridad indicada por el arrego de distancias 
				 ListaDoble<T> aux = new ListaDoble<T>();
				 
				 for (int i = 0; !noVisitados.isEmpty(); i++) {
					 aux.agregar(noVisitados.deQueue());
				}

				 for (int j = 0; j < aux.darLongitud(); j++) {
					T temp = aux.darElemento(j);
					int pos = buscarPosVertice(temp);
					noVisitados.enQueue(distancias[pos], temp);
				 }
				 
			} 
		 }
		 
		 
		 return MST;		 
	 } 
	 
	 
	 public int getPeso(){
		 int peso = 0;
		 
		 for (int i = 0; i < aristas.length; i++) {
				if(aristas[i]!=null){
					for (int j = 0; j < aristas[i].darLongitud(); j++) {
						peso +=  aristas[i].darElemento(j).getPeso();
					}
				}
			}
		 
		 return (isDirigido)? peso: (peso/2);
	 }

}
