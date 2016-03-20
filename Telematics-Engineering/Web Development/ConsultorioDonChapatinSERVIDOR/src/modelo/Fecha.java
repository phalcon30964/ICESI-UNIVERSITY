package modelo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;


public class Fecha implements Comparable<Fecha>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825297933754216048L;
	private String fecha;
	private TreeSet<Cita> citas;

	public Fecha(String ano, String mes, String dia) {
		this.citas = new TreeSet<Cita>();
		llenarHorario();
		fecha = (ano+"/"+mes+"/"+dia);
	}
	
	public void llenarHorario(){
		
		citas.add(new Cita("08:00",this));
		citas.add(new Cita("08:30",this));
		citas.add(new Cita("09:00",this));
		citas.add(new Cita("09:30",this));
		citas.add(new Cita("10:00",this));
		citas.add(new Cita("10:30",this));
		citas.add(new Cita("11:00",this));
		citas.add(new Cita("11:30",this));
		citas.add(new Cita("14:00",this));
		citas.add(new Cita("14:30",this));
		citas.add(new Cita("15:00",this));
		citas.add(new Cita("15:30",this));
		citas.add(new Cita("16:00",this));
		citas.add(new Cita("16:30",this));
		citas.add(new Cita("17:00",this));
				
	}
	
	public Cita searchCita(String hora){
		
		Iterator<Cita> it = citas.iterator();
		Cita actual = (Cita) it.next();
		
		while(actual!=null && !actual.getHora().equalsIgnoreCase(hora)){
			actual = (Cita) it.next();
		}
		
		return actual;
	}
	
	public boolean addCita(Paciente paciente, String hora){
		
		Cita cita = searchCita(hora);
		
		if(cita!=null && cita.getPaciente()==null){
			cita.setPaciente(paciente);
			return true;
		}
		
		return false;
	}
	
	public boolean removeCita(String hora){
		
		Cita cita = searchCita(hora);

		if(cita!=null && cita.getPaciente()!=null){
			cita.setPaciente(null);
			return true;
		}
		
		return false;
	}
	
	public String getCitasNoOcupadas(){
		
		String msj = "";
		
		try {
			
			Iterator<Cita> it = citas.iterator();
			Cita actual = (Cita) it.next();
			
			while(actual!=null){
				if(actual.getPaciente()==null){
					msj += actual.getHora()+"-";
				}
				actual = (Cita)it.next();
			}	
		} catch (Exception e) {
		}
	
		msj = (msj.equals(""))? msj : msj.substring(0, msj.length());
		
		return msj;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public TreeSet<Cita> getCitas() {
		return citas;
	}

	public void setCitas(TreeSet<Cita> citas) {
		this.citas = citas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fecha;
	}

	@Override
	public int compareTo(Fecha o) {
		// TODO Auto-generated method stub
		return fecha.compareToIgnoreCase(o.getFecha());
	}
	
}
