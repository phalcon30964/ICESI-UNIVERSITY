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

	/**
	 * Nombre: agregarArticulo
	 * 
	 * <b>Descripcion: </b> este metodo se encarga de crear y cargar un nuevo
	 * articulo a–adiendolo la contenedora de tamano fijo de articulos.
	 * <b>pre: </b>La contenedora de articulos est‡ inicializada <br/>
	 * <b>pos: </b> se a–adi— en nuevo articulo a la contenedora de articulos<br/>
	 * 
	 * @param descripcion
	 *            - String que contiene la descripcion 
	 *            del articulo  descripcion != null
	 * @param pesoKilogramos
	 *            - double que indica el peso del articulo
	 * @param esFragil
	 *            - boolean que indica si el articulo es fragil (true) o si no
	 *            es fragil (false)
	 * @throws Exception
	 *             si el valor del peso en kilogramos es inferior a 0.1
	 *             kilogramos
	 * @throws Exception
	 *             si el valor del peso en kilogramos de todos los articulos mas
	 *             es el que se quiere cargar supera el valor maximo permitido
	 *             indicado en PESO_MAXIMO_KILOGRAMOS
	 * 
	 * @throws Exception
	 *             si el numero de articulos mas el que se quiere cargar supera
	 *             el tope de articulos que se pueden llevar en el trasteo. Este
	 *             limite esta indicado en NUMERO_MAXIMO_ARTICULOS
	 * 
	 * 
	 */
	public void agregarArticulo(String descripcion, double pesoKilogramos,
			boolean esFragil) throws Exception {
		if (pesoKilogramos < 0.1) {
			throw new Exception(
					"El peso no puede ser inferior a 0.1 kilogramos");
		}
		double acumulado = pesoKilogramos;
		int cuantos = 0;
		int libre = -1;
		for (int i = 0; i < articulos.length
				&& acumulado <= PESO_MAXIMO_KILOGRAMOS && libre == -1; i++) {
			if (articulos[i] != null) {
				acumulado += articulos[i].darPesoKilogramos();
				cuantos++;
			} else {
				libre = i;
			}
		}
		if (acumulado > PESO_MAXIMO_KILOGRAMOS) {
			throw new Exception(
					"No se puede cargar el nuevo articulo porque se supera el peso maximo permitido.");
		}
		if (cuantos == NUMERO_MAXIMO_ARTICULOS) {
			throw new Exception(
					"No se puede cargar el nuevo articulo porque se supera el tope de articulos permitido.");
		}

		articulos[libre] = new Articulo(descripcion, pesoKilogramos,
				esFragil);
	}

}
