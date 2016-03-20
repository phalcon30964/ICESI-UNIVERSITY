package TadGrafo;


/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public class Vertex<T> implements IVertex<T>{
    private String label;
    private T value;

    public Vertex(String lab){
        label = lab;
    }
    
    public Vertex(String lab, T val){
        label = lab;
    	value = val;
    }
    
    public void setValue(T val){
    	value = val;
    }

    public String getLabel(){
        return label;
    }

    public T getValue(){
        return value;
    }
    /*
    public boolean equals(Object other){
        return ((Vertex)other).getLabel().equals(label);
    }*/
}
