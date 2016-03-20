package mundo;

import java.util.ArrayList;

public class Tarjeton {
	private ArrayList<Candidato> candidatos;
	
	public Tarjeton(){
		candidatos = new ArrayList<Candidato>();
	}
	
	public void cambiarCandidatos(ArrayList<Candidato> cands){
		candidatos = cands;
	}
	
	public void agregarCandidato(String cod, String nom, String par, int vot){
		Candidato can = new Candidato(cod, nom, par, vot);
		candidatos.add(can);
	}
	
	public void votarCandidato(int pos){
		candidatos.get(pos).votar();
	}
	
	public int buscarCandidato(String cod){
		int pos = -1;
		for(int i=0;i<candidatos.size() && pos==-1;i++){
			Candidato can = candidatos.get(i);
			if(can.darCodidgo().equals(cod)){
				pos = i;
			}
		}
		return pos;
	}
	
	public Candidato darCandidato(int pos){
		return candidatos.get(pos);
	}
	
	public int darTotalCandidatos(){
		return candidatos.size();
	}
}
