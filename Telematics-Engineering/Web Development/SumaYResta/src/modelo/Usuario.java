package modelo;

public class Usuario {
	private String nombre;
	private int puntajeAcum;

	public Usuario(String nombre) {

		this.nombre = nombre;
		puntajeAcum = 0;
	}

	// Por cada respuesta acertada se suma un punto a su puntaje acumulado
	public void aumentarPuntaje() {
		puntajeAcum++;
	}

	// Por cada respuesta incorrecta se resta un punto a su puntaje acumulado
	public void bajarPuntaje() {
		puntajeAcum--;
	}

	public int getPuntajeAcum() {
		return puntajeAcum;
	}

	public void setPuntajeAcum(int puntajeAcum) {
		this.puntajeAcum = puntajeAcum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
