package mundo;

import java.util.ArrayList;

public class Cafetera {
	private ArrayList<Recurso> ingredientes;
	private double dineroEnVentas;
	private int cafesVendidos15gr;
	private int cafesVendidos30gr;

	public static final double COSTO_CAFE15gr = 1000;
	public static final double COSTO_CAFE30gr = 1200;

	public Cafetera() {
		dineroEnVentas = 0;
		cafesVendidos15gr = 0;
		cafesVendidos30gr = 0;

		ingredientes = new ArrayList<Recurso>();

		// El identificador de cada recurso es la posición que ocupan en
		// el arreglo de ingredientes
		ingredientes.add(new Recurso(ingredientes.size(), "Cafe", 450, 0, 15,
				"kg"));
		ingredientes.add(new Recurso(ingredientes.size(), "Agua", 18900, 0, 10,
				"ml"));
		ingredientes.add(new Recurso(ingredientes.size(), "Vasos", 50, 0, 1,
				"unidades"));
		ingredientes.add(new Recurso(ingredientes.size(), "Azucar", 100, 0, 2,
				"unidades"));
		ingredientes.add(new Recurso(ingredientes.size(), "Pitillos", 50, 0,
				15, "unidades"));
	}

	public void venderCafe(double cantidadCafe)
			throws ImposiblePrepararCafeException, CafeIncompletoException {

		// Cada posición del arreglo indica la disponibilidad de un recurso.
		// Ejemplo: posición 0 indica la disponibilidad del café
		boolean[] disponibilidad = new boolean[5];
		for (int i = 0; i < ingredientes.size(); i++) {
			disponibilidad[i] = ingredientes.get(i).hayDisponibilidad();
		}
		
		if ((disponibilidad[0] || disponibilidad[1] || disponibilidad[2]) == false) {
			// Si no hay café o agua o vasos. Complete qué debe hacer la
			// aplicación en este caso

			
		} else if ((disponibilidad[3] || disponibilidad[4]) == false) {
			// Si no hay pitillos o azúcar. Complete qué debe hacer la
			// aplicación en este caso

			
		}

		if (cantidadCafe == 15) {
			cafesVendidos15gr++;
			dineroEnVentas+=COSTO_CAFE15gr;
		} else {
			cafesVendidos30gr++;
			dineroEnVentas+=COSTO_CAFE30gr;
		}
		
	}

	public void venderCafeIncompleto(double cantidadCafe) {
		// Agregue lo que haga falta para generar las excepciones
		// mas las instrucciones que son responsabilidad del método
	
	
	
	
	
		if (cantidadCafe == 15) {
			cafesVendidos15gr++;
			dineroEnVentas+=COSTO_CAFE15gr;
		} else {
			cafesVendidos30gr++;
			dineroEnVentas+=COSTO_CAFE30gr;
		}
	}

	
	/**
	 * @return the ingredientes
	 */
	public ArrayList<Recurso> getIngredientes() {
		return ingredientes;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(ArrayList<Recurso> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * @return the dineroEnVentas
	 */
	public double getDineroEnVentas() {
		return dineroEnVentas;
	}

	/**
	 * @param dineroEnVentas the dineroEnVentas to set
	 */
	public void setDineroEnVentas(double dineroEnVentas) {
		this.dineroEnVentas = dineroEnVentas;
	}

	/**
	 * @return the cafesVendidos15gr
	 */
	public int getCafesVendidos15gr() {
		return cafesVendidos15gr;
	}

	/**
	 * @param cafesVendidos15gr the cafesVendidos15gr to set
	 */
	public void setCafesVendidos15gr(int cafesVendidos15gr) {
		this.cafesVendidos15gr = cafesVendidos15gr;
	}

	/**
	 * @return the cafesVendidos30gr
	 */
	public int getCafesVendidos30gr() {
		return cafesVendidos30gr;
	}

	/**
	 * @param cafesVendidos30gr the cafesVendidos30gr to set
	 */
	public void setCafesVendidos30gr(int cafesVendidos30gr) {
		this.cafesVendidos30gr = cafesVendidos30gr;
	}


}