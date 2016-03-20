package modelo;

public class Usuarios {

	private String nombre;
	private String ip;
	private String puerto;
	public Usuarios(String nombre, String ip, String puerto) {
		super();
		this.nombre = nombre;
		this.ip = ip;
		this.puerto = puerto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Usuarios && ((Usuarios)obj).getNombre().equals(this.nombre) 
				&& ((Usuarios)obj).getIp().equals(this.ip)
				&& ((Usuarios)obj).getPuerto().equals(this.puerto)){
			return true;
		}
		return false;
	}
	
	
	
}
