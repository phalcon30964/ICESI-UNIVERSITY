package mundo;

import java.util.ArrayList;
/**
 * IGraphQuiz is the interface for the wrap class needed in the quiz3 solution
 * @author Angela
 *
 */
public interface IGraphQuiz{

	/**
	 * This method adds a vertex in the graph, the parameter is a String
	 * @param labVertex, the vertex type is String  
	 */
	public void addVertex(String labVertex);
	
	/**
	 * This method adds an edge in the graph.
	 * @param start, is a String
	 * @param end, is a String
	 */
	public void addEdge(String start, String end, double w);
	
//	/**
//	 * This method gets the graph's vertices list
//	 * All vertices are Strings 
//	 * @return ArrayList with the graph's vertices
//	 */
//	public ArrayList<String> getVertices();
	
	/**
	 * Find the position of a vertex into the vertices table 
	 * @param v the vertex
	 * @return an int with the position 
	 */
	public int vertexToInt( String v);
	
	/**
	 * returns the String associated to a vertex in the vertices table
	 * @param pos int with the position
	 * @return String 
	 */
	
	public String vertextoString(int pos);
	

	

	/**
	 * This method generates a graph's weight matrix
	 * @return double[][] representing the graph's weight matrix.  Each [i][j] position represents 
	 * the weight for vertices i,j  
	 */
	public double[][] getPaths();
	
	
	/**
	 * Return how many vertices are in the grap
	 * @return int cant of vertices
	 */
	public int cantVertices();
	
	
	
	
}
