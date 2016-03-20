package mundo;

public class ImposiblePrepararCafeException extends Exception {
	private String recursoAgotado;

	public ImposiblePrepararCafeException(String mensaje, String recursoAgotado) {
		super(mensaje);
		this.recursoAgotado = recursoAgotado;
	}
}
