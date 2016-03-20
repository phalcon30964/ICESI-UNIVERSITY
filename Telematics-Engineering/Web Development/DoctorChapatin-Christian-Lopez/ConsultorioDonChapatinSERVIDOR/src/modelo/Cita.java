package modelo;

import java.io.Serializable;

public class Cita implements Comparable<Cita>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5009727310600119265L;
	private Paciente paciente;
	private Fecha fecha;
	private String hora;
	
	public Cita(String hora, Fecha fech) {
		super();
		this.paciente = null;
		this.fecha = fech;
		this.hora = hora;
	}
	
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String toString(){
		return "[Hora:"+hora+"h Fecha:"+fecha.toString()+"]";
	}
	
	@Override
	public int compareTo(Cita o) {
		Cita cita = (Cita)o;
		return this.hora.compareToIgnoreCase(cita.getHora());
	}
	
}
