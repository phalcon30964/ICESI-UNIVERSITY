package datagramas;

import java.net.InetAddress;

public class Archivo {
	
	private String nombre;
	private InetAddress propietario;
	
	
	public Archivo(String nombre, InetAddress propietario) {
		super();
		this.nombre = nombre;
		this.propietario = propietario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public InetAddress getPropietario() {
		return propietario;
	}


	public void setPropietario(InetAddress propietario) {
		this.propietario = propietario;
	}
	
	
	

}
