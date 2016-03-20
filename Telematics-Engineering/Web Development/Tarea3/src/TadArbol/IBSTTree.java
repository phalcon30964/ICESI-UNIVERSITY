package TadArbol;

import TadLista.ListaDoble;


/**
 * Interface Árbol Binario de Búsqueda
 * @author Juan Manuel Reyes <juan.reyes@correounivall.edu.co>
 */
public interface IBSTTree<K extends Comparable<K>,T> {
    public IBSTNode<K,T> getRoot();
    public boolean isNil(IBSTNode<K,T> node);
}
