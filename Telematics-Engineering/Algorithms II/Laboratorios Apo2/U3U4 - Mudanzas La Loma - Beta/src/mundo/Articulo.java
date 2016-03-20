package mundo;

public class Articulo {
	
	private String descripcion;

	private double pesoKilogramos;

	private boolean fragil;

	public Articulo(String descripcion, double pesoKilogramos, boolean fragil) {
		this.descripcion = descripcion;
		this.pesoKilogramos = pesoKilogramos;
		this.fragil = fragil;
	}

	public String darDescripcion() {
		return descripcion;
	}

	public void cambiarDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double darPesoKilogramos() {
		return pesoKilogramos;
	}

	public void cambiarPesoKilogramos(double pesoKilogramos) {
		this.pesoKilogramos = pesoKilogramos;
	}

	public boolean darFragil() {
		return fragil;
	}

	public void cambiarFragil(boolean fragil) {
		this.fragil = fragil;
	}

}
