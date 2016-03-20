package Modelo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Consultorio {
	
	
	
	private ArrayList<Fecha> fechas;
	private ArrayList<Paciente> pacientes;
	
	
	
	
	public Consultorio() {
		
		fechas = new ArrayList<Fecha>();
		pacientes = new ArrayList<Paciente>();	
		
		
	}
	
	public void registrarPaciente(String nom,String ape,String ced,String dir,String tel, String cel, String fec)throws Exception{
		
		if(!existePaciente(ced)){
		
			Paciente p = new Paciente(nom, ape, ced, dir, tel, cel, fec);		
			pacientes.add(p);
		}
		else{
			throw new Exception("Ya existe un Paciente registrado con esta cedula");
		}
	}
	
	public boolean existePaciente(String ced){
		
		boolean existe = false;
		
		for(int i =0; i<pacientes.size()&&!existe;i++){
			
			Paciente p = pacientes.get(i);
			if(p.getCedula().equals(ced)){
				
				existe = true;
			}
		}
		
		return existe;
		
	}
	
	public String[] darInfoPaciente(String ced){
		
		String info[] = new String[3];
		
		Paciente p = darPaciente(ced);
		info[0] = p.getCedula();
		info[1] = p.getNombre();
		info[2] = p.getApellido();
		
		return info;
	}
	
	public ArrayList<String> darCitasPaciente(String ced){
		
		ArrayList<String> citasPa = new ArrayList<String>();
		
		Paciente p = darPaciente(ced);
		for(int i=0;i<p.getCitasPaciente().size();i++){
			Cita ci = p.getCitasPaciente().get(i);
			String st = ci.getFecha()+" Hora:"+cambiarAHora(ci.getHora());
			citasPa.add(st);
		}
		
		
		return citasPa;
	}
	
	public String cambiarAHora(int a){
		
		String hora ="";
		
		if(a==0){
			hora= "8:00";
		}
		else if(a==1){
			hora= "8:30";
		}
		else if(a==2){
			hora= "9:00";
		}
		else if(a==3){
			hora= "9:30";
		}
		else if(a==4){
			hora= "10:00";
		}
		else if(a==5){
			hora= "10:30";
		}
		else if(a==6){
			hora= "11:00";
		}
		else if(a==7){
			hora= "11:30";
		}
		else if(a==8){
			hora= "14:00";
		}
		else if(a==9){
			hora= "14:30";
		}
		else if(a==10){
			hora= "15:00";
		}
		else if(a==11){
			hora= "15:30";
		}
		else if(a==12){
			hora= "16:00";
		}
		else if(a==13){
			hora= "16:30";
		}
		else if(a==14){
			hora= "17:00";
		}
		
		return hora;
		
	}
	
	public Paciente darPaciente(String ced){
		
		Paciente pac = null;
		if(existePaciente(ced)){
			
			for(int i =0; i<pacientes.size();i++){
				
				Paciente p = pacientes.get(i);
				if(p.getCedula().equals(ced)){
					
					pac = p;
				}
			
			}					
		}
		return pac;	
	}
	
	
	public void registrarFecha(String dia,String mes, String año){
		
		Fecha nueva = new Fecha(dia, mes, año);
		fechas.add(nueva);
	}
	
	
	public boolean existeFecha(String dia,String mes, String año){
		
		boolean esta = false;
				
			for(int i=0;i<fechas.size()&& !esta;i++){
				
				Fecha fe = fechas.get(i);
				if(fe.getAño().equals(año)&&fe.getMes().equals(mes)&&fe.getDia().equals(dia)){
					esta= true;
				}
				
			}
				
		return esta;		
		
	}
	
	
	public Fecha darFecha(String dia,String mes, String año){
		
		Fecha fec = null;
		if(existeFecha(dia, mes, año)){
			
			for(int i=0;i<fechas.size();i++){
				
				Fecha fe = fechas.get(i);
				if(fe.getAño().equals(año)&&fe.getMes().equals(mes)&&fe.getDia().equals(dia)){
				
					fec= fe;
				}
				
			}
			
		}
		
		
		
		return fec;
		
	}
		
	

	public String[] darDisponibilidad(String dia,String mes, String año){
		
		Fecha fec = null;
		String[] dsip = new String[15];
		if(existeFecha(dia, mes, año)){
			fec = darFecha(dia, mes, año);
			dsip = fec.darDisponibilidad();
		}
		else{
			registrarFecha(dia, mes, año);
			dsip = darDisponibilidad(dia, mes, año);
		}
		
		
		
		return dsip;
	}
	
	public void nuevaCita(int i, String ced,String dia,String mes, String año){
		
		if(existePaciente(ced)){
			
			Paciente p = darPaciente(ced);
			Fecha f = darFecha(dia, mes, año);
			f.crearCita(p, i);			
			
		}
		
	}
	
	public void desocuparCita(String dia,String mes, String año,int i){
		
		Fecha f = darFecha(dia, mes, año);
		Cita[]cit = new Cita[15];
		cit = f.getCitas();
		Paciente p = cit[i].getPacienteCita();
		p.eliminarCitaDeLista(cit[i]);
		f.cancelarCita(i);
	}

	public ArrayList<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(ArrayList<Fecha> fechas) {
		this.fechas = fechas;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public boolean enviarMensajes(String mensajes){
		
		boolean resultado = false;
		try {
			DatagramSocket dSockecr = new DatagramSocket();
			DatagramPacket dPacket = null;
			InetAddress direccionGrupo = InetAddress.getByName("239.2.2");
			
			
			if(mensajes == null){
				resultado = false;
			
			}else{
				byte[] buf = mensajes.getBytes();
				dPacket = new DatagramPacket(buf,buf.length, direccionGrupo, 5000);
				
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultado;
		
	}
	
	

}
