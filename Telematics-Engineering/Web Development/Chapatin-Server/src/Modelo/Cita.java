package Modelo;

public class Cita {
	
	
	
	
	private String fecha;
	private int hora;
	private Paciente pacienteCita;
	
	
	
	
	public Cita(String fec, int hor){
		
		fecha = fec;
		hora = hor;
		pacienteCita = null;
		
	}

	
	public boolean estaOcuapada(){
		
		boolean esta = false;
		
		if( pacienteCita != null){
			
			esta = true;
		}
		
		return esta;
	}
	
	public void desocupar(){
		
		setPacienteCita(null);
		
	}
	
	public void ocupar(Paciente pac){
		
		setPacienteCita(pac);
		pacienteCita.agregarCitaALista(this);
	}

	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public Paciente getPacienteCita() {
		return pacienteCita;
	}




	public void setPacienteCita(Paciente pacienteCita) {
		this.pacienteCita = pacienteCita;
	}


	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
	
	
	

}
