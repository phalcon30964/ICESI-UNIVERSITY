package TadGrafo;


public class Edge<T> implements IEdge<T>{
	private Vertex<T> initialVertex;
	private Vertex<T> terminalVertex;
	private double weight;
	private final static double DEFAULT_WEIGHT=1; 
	
	public Edge(Vertex<T> iv, Vertex<T> tv){
		initEdge(iv, tv, DEFAULT_WEIGHT);
	}
	
	public Edge(Vertex<T> iv, Vertex<T> tv, double w){
		initEdge(iv, tv, w);
	}
	
	private void initEdge(Vertex<T> iv, Vertex<T> tv, double w){
		initialVertex  = iv;
		terminalVertex = tv;
		weight = w;
	}
	
	public IVertex<T> getInitialVertex() {
		return initialVertex;
	}

	public IVertex<T> getTerminalVertex() {
		return terminalVertex;
	}

	public double getWeight() {
		return weight;
	}
}
