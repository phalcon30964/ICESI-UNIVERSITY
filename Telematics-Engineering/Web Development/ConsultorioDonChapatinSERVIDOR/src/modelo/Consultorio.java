package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Consultorio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5779945908209061446L;
	private ArrayList<Paciente> pacientes;
	private TreeSet<Fecha> agenda;
	private ArrayList<Usuarios> usuarios;
	
	public Consultorio() {
		pacientes = new ArrayList<Paciente>();
		agenda = new TreeSet<Fecha>();
		usuarios = new ArrayList<Usuarios>();
	}
	
	public Paciente searchPaciente(int id){
		for (int i = 0; i < pacientes.size(); i++) {
			if(pacientes.get(i).getId()==id){
				return pacientes.get(i);
			}
		}
		return null;
	}

	public boolean addPaciente(String nombre, String apellido, String direccion,
			int telefono, int celular, int id, String fechaNacimiento){
		
		if(searchPaciente(id)!=null){
			return false;
		}

		return pacientes.add(new Paciente(nombre, apellido, direccion, telefono, celular, id, fechaNacimiento));	
	}
	
	public boolean removePaciente(int id){
		
		return pacientes.remove(searchPaciente(id));
	}
	
	public Fecha searchFecha(String ano, String mes, String dia){
		
		try {
			
			Iterator<Fecha> it = agenda.iterator();
			Fecha actual = (Fecha) it.next();
			
			while(actual!=null && !actual.getFecha().equalsIgnoreCase(ano+"/"+mes+"/"+dia)){
				actual = (Fecha)it.next();
			}
			return actual;
			
		} catch (Exception e) {
		}
		
		return null;
	}
	
	public boolean addFecha(String ano, String mes, String dia){
		return agenda.add(new Fecha(ano, mes, dia));
	}
	
	public boolean removeFecha(String ano, String mes, String dia){
		
		return agenda.remove(searchFecha(ano, mes, dia));
	}
	
	public Cita searchCita (String ano, String mes, String dia, String hora){
		
		Fecha f = searchFecha(ano, mes, dia);
		
		return (f!=null)? f.searchCita(hora):null;
		
	}
	
	public boolean addCita(int id, String ano, String mes, String dia, String hora){
		
		Paciente p = searchPaciente(id);
		Fecha f = searchFecha(ano, mes, dia);
		if(f!=null && p!=null ){
		Cita c = f.searchCita(hora);
		
			if(c!=null && f.addCita(p, hora)){
			p.addCitaPendiente(c);
			return true;
			}
		}
		return false;	
	}
	
	public boolean removeCita (int id, String ano, String mes, String dia, String hora){
		
		Paciente p = searchPaciente(id);
		Fecha f = searchFecha(ano, mes, dia);
		Cita c = (f!=null)? f.searchCita(hora):null;
		
		if(c!=null && c.getPaciente()!=null){
			c.setPaciente(null);
			p.removeCitaPendiente(c);
			return true;
		}
		
		return false;	
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public TreeSet<Fecha> getAgenda() {
		return agenda;
	}

	public void setAgenda(TreeSet<Fecha> agenda) {
		this.agenda = agenda;
	}

	public ArrayList<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	

}
