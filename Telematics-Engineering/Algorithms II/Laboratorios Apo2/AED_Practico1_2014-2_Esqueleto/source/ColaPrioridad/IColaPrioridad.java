package ColaPrioridad;

import Cola.ICola;

public interface IColaPrioridad<T> extends ICola<T> {
	
	public void enQueue(int prioridad, T valor);

}
