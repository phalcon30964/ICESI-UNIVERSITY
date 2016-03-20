package TadGrafo;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public interface IEdge<T> {
    public IVertex<T> getInitialVertex();
    public IVertex<T> getTerminalVertex();
    public double getWeight();
}
