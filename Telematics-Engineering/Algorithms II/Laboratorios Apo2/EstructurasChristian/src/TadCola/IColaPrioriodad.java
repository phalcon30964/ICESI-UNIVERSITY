package TadCola;

public interface IColaPrioriodad<T> extends ICola<T> {

	public void enQueue(int prioridad, T elemento)throws Exception;

}
