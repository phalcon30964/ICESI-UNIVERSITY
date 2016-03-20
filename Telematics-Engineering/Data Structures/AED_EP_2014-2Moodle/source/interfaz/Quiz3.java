package interfaz;

import mundo.GraphAdmin;

/**
 * Principal Class in the project AEDQuiz3
 * This is the controller Class 
 * @author Angela
 *
 */
public class Quiz3 {
	
	/**
	 * Connection with the model
	 */
	private GraphAdmin admin;
	
	/**
	 * Constructor method
	 * @param path is a String with the filepath
	 */
	public Quiz3 (String path){
		try {
			admin=new GraphAdmin(path);
		} catch (Exception e) {
			System.out.println("An error ocurred when opening the file in the path "+ path);
			e.printStackTrace();
		}
	}
	
	/**
	 * This method starts the input evaluation
	 */
	public void evaluate(){
		admin.floydWarshallParents();
	}
	
	/**
	 * This method prints in the standard output the evaluation results
	 */
	public void showAnswers(){
		admin.printAllPaths();
	
	}
	/**
	 * Main method, it creates a Quiz3 class' object, then starts the input evaluation and print the answers 
	 * @param args
	 */
	public static void main(String[] args) {
		String filename="data/quiz3.in";
		try{
			Quiz3 quizObj= new Quiz3(filename);
			quizObj.evaluate();
			quizObj.showAnswers();
			System.out.println("terminando");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("wrong file name: " + filename);
		}
	}

}
