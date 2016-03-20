package mundo;

import java.util.ArrayList;
import java.util.Collection;


public class Evento {
	
	//atributos
	
	public ArrayList<Participante> participantes ;
	public String ponente = "PONENTE";
	

	//Constructor
	
	public Evento(){
		participantes = new ArrayList<Participante>();
	}
	
	public boolean registrar(String nom, String tel, int tipo){
	
		if(participantes.add(new Participante( nom,  tel, tipo))){
			return true;
		}else{
			return false;
		}

	}
	
	public int consulta(){
		
		return this.participantes.size();
		
	}
	
	public int consulta2(){
		
		int contador = 0;
		
		for (int i = 0; i < participantes.size(); i++) {
			if(((participantes.get(i).getTipo())+"").equals(ponente)){
				contador++;
			}
		}
		
		return contador;
		
		
	}

}
