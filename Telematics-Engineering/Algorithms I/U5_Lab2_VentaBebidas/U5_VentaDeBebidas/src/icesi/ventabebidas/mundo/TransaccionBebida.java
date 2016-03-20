package icesi.ventabebidas.mundo;

public class TransaccionBebida {
	private String nombreBebida;
	private int cantidadVasos;
	private double costoTransaccion;
	
	public TransaccionBebida(String nb, int cv, double ct){
		nombreBebida     = nb;
		cantidadVasos    = cv;
		costoTransaccion = ct;
	}
	
	public String darNombreBebida(){
		return nombreBebida;
	}

	public int darCantidadVasos(){
		return cantidadVasos;
	}
	
	public double darCostoTransaccion(){
		return costoTransaccion;
	}
}
