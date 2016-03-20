package mundo;

public class Usuario {

	private String nombre;
	private String ip;

	public Usuario(String nom, String i){
		
		nombre = nom;
		ip = i;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getIp() {
		return ip;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
