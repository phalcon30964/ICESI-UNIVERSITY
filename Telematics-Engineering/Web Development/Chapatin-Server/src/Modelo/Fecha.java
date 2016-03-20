package Modelo;

public class Fecha {

	
	private String dia;
	private String mes;
	private String año;
	private Cita[] citas;
	
	public Fecha(String nDia,String nMes, String nAño){
		
		dia = nDia;
		mes = nMes;
		año = nAño;
		citas = new Cita[15];
		String fecha = dia+"-"+mes+"-"+año;
		for(int i=0;i<citas.length;i++){
			citas[i] = new Cita(fecha,i);
			
		}
		
	}
	
	public void cancelarCita(int num){
		
		citas[num].desocupar();
		
	}
	
	public void crearCita(Paciente p, int num){
		
		if(!(citas[num].estaOcuapada())){
			
			citas[num].ocupar(p);
		}
		
	}
	
	public String[] darDisponibilidad(){
		
		String[] estados = new String[15];
		String ocu = "No disponible";
		String des = "Disponible";
		
		for(int i =0; i< citas.length;i++){
			
			if(citas[i].estaOcuapada()){
				estados[i]=ocu;
			}
			else{
				estados[i]=des;
			}
		}
		
		return estados;
		
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public Cita[] getCitas() {
		return citas;
	}

	public void setCitas(Cita[] citas) {
		this.citas = citas;
	}
	
	
	
	
}
