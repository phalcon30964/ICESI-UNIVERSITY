package mundo;

public class Mudanza {
	public final static double PESO_MAXIMO_KILOGRAMOS = 1345.0;

	public final static int NUMERO_MAXIMO_ARTICULOS = 20;

	private static int consecutivo;

	private int numero;

	private Cliente cliente;

	private String direccionSalida, direccionLlegada;

	private boolean realizado;

	private Articulo[] articulos;

	public Mudanza(Cliente cli, String dirS,
			String dirL) {
		consecutivo++;
		numero = consecutivo;
		cliente = cli;
		direccionSalida = dirS;
		direccionLlegada = dirL;
		realizado=false;
		this.articulos = new Articulo[NUMERO_MAXIMO_ARTICULOS];
	}

	public int darNumero() {
		return numero;
	}

	public void cambiarNumero(int num) {
		numero = num;
	}

	public Cliente darCliente() {
		return cliente;
	}

	public void cambiarCliente(Cliente cli) {
		cliente = cli;
	}

	public String darDireccionSalida() {
		return direccionSalida;
	}

	public void cambiarDireccionSalida(String direccion) {
		direccionSalida = direccion;
	}

	public String darDireccionLlegada() {
		return direccionLlegada;
	}

	public void cambiarDireccionLlegada(String direccion) {
		direccionLlegada = direccion;
	}

	public boolean darRealizado() {
		return realizado;
	}

	public void cambiarRealizado(boolean real) {
		realizado = real;
	}

	public Articulo[] darArticulos() {
		return articulos;
	}

	public void cambiarArticulos(Articulo[] nuevoArticulos) {
		articulos = nuevoArticulos;
	}

	

}
