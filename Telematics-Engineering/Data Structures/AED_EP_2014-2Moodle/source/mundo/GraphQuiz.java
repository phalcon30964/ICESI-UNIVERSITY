package mundo;

import TadGrafo.GrafoLista;

public class GraphQuiz implements IGraphQuiz {
	
	private GrafoLista<String> grafo;
	
	public GraphQuiz() {
		grafo = new GrafoLista<String>(true);
	}

	@Override
	public void addVertex(String labVertex) {
		try {
			grafo.agregarVertice(labVertex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addEdge(String start, String end, double w) {
		try {
			grafo.agregarArista((int) w, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int vertexToInt(String v) {
		return grafo.buscarPosVertice(v);
	}

	@Override
	public String vertextoString(int pos) {
		return grafo.getVertice(pos).toString();
	}

	@Override
	public double[][] getPaths() {
		int[][] caminos = grafo.crearMatrizDePesos();
		double[][] paths  = new double[caminos.length][caminos.length];
		
		for (int i = 0; i < paths.length; i++) {
			for (int j = 0; j < paths.length; j++) {
				paths[i][j] = (double)caminos[i][j];
			}
		}
		return paths;
	}

	@Override
	public int cantVertices() {
		return grafo.getNumVertices();
	}

}
