package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Main class in the model, this class manages the graph and solves the quiz3 questions
 * @author Angela
 *
 */
public class GraphAdmin {

	
	//TODO This is a instance of the class GraphQuiz
	//     class GraphQuiz is a student's Graph ADT wrap Class 
	private GraphQuiz graph;
	
	private String[] answers;
	private String path;
	private BufferedReader reader;
	
	private int[][] padres;
	private double[][] paths;
	
	/**
	 * Constructor Method
	 * @param p, String with the path file
	 * @throws Exception if there is a problem when loading the file in the buffer reader
	 */
	public GraphAdmin(String p)throws Exception{
		path= p;
		reader = new BufferedReader(new FileReader(path));
		initGraphs();
		reader.close();
	}
	
	
	/**
	 * This method loads the input from the file into the array of QuizGraphs instances 
	 * @throws Exception when the file's format or the numbers are wrong
	 */
	public void initGraphs()throws Exception{
		graph= loadGraph(); 

	}
	
	/**
	 * This method load just one graph from the file
	 * @return a GraphQuiz class instance
	 * @throws Exception when file's format or the numbers are wrong
	 */
	private GraphQuiz loadGraph() throws Exception{
		GraphQuiz temp= new GraphQuiz();
		int cantVertices, cantEdges, direction;
		String line = reader.readLine(); // reading the line with the graph information
		String [] parts = line.split(" ");// splitting the String in pieces
		
		//Strings to ints
		cantVertices= Integer.parseInt(parts[0]);
		cantEdges= Integer.parseInt(parts[1]);
		//direction= Integer.parseInt(parts[2]);
		
		// assigning the graph's type
		//temp.setType(direction);
		
		// creating the graph's vertices
		for (int i = 0; i < cantVertices; i++) {
			//getting one vertex's information 
			line= reader.readLine();
			
			//adding one vertex
			temp.addVertex(line);
		}
		
		// creating the graph's edges
		for (int i = 0; i < cantEdges; i++) {
			//getting one edge's information 
			String start, end;
			double w;
			line= reader.readLine();
			String[] input= line.split(" ");
			start= input[0];
			end=input[1];
			w= Double.parseDouble(input[2]);
			
			//adding one edge
			temp.addEdge(start, end, w);
		}
		
		return temp;
	}
	

	

	//TODO quiz questions
	

	
	public void floydWarshallParents(){
		
		padres = new int[graph.cantVertices()][graph.cantVertices()];
		paths = graph.getPaths();
		 
		for (int l = 0; l < graph.cantVertices(); l++) {
			for (int m = 0; m < graph.cantVertices(); m++) {
				padres[l][m] = l;
			}
		}
		for (int k = 0; k < graph.cantVertices(); k++) {
			for (int i = 0; i < graph.cantVertices(); i++) {
				for (int j = 0; j < graph.cantVertices(); j++) {

					if(paths[i][k]+paths[k][j] < paths[i][j]){
						paths[i][j] = paths[i][k]+paths[k][j];
						padres[i][j] = padres[k][j];
					}
				}
			}
		}
		
		System.out.println("ejecutando Floyd-Warshall");
	}
	
	public void printAllPaths(){
		System.out.println("imprimiendo");

		for (int i = 0; i < graph.cantVertices(); i++) {
			for (int j = 0; j < graph.cantVertices(); j++) {
				printPath(i, j);
				System.out.print("\n");
			}
		}
	}
	
	public void printPath(int i,int j){
		if(i!=j){
			printPath(i,padres[i][j]);
		}
		System.out.print(j+" ");
		
	} 
}
