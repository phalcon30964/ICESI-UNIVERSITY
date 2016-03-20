package TadGrafo;

import java.util.Collection;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public interface IGraph<T> {
    public Collection<IVertex<T>> getVerticesList();
    public Collection<IEdge<T>> getEdges();
    public int countVertex();
    public int countEdges();
    public boolean isWeighted();
    public boolean isDirected();
}
