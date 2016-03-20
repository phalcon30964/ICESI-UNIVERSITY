package TadTurnos;

public interface ITurnos<T> {
	
	public void guardarTurno();
	
	public T restablecerTurno()throws Exception;
	
	public T restablecerRonda()throws Exception;

}
