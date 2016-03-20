package TadArbol;

import TadLista.ListaDoble;


/**
 * Interface Nodo de un Árbol Binario
 * @author Juan Manuel Reyes <juan.reyes@correounivall.edu.co>
 */
public interface IBSTNode <K extends Comparable<K>,T>{
    public K getKey();
    public IBSTNode<K,T> getP();
    public IBSTNode<K,T> getLeft();
    public IBSTNode<K,T> getRight();
    public int getFactorBalanceo();
}
