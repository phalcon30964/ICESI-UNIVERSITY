package mundo;

public class Candidato {
	private String codigo;
	private String nombre;
	private String partido;
	private int votos;
	
	public Candidato(String cod, String nom, String par, int vot){
		codigo  = cod;
		nombre  = nom;
		partido = par;
		votos   = vot;
	}
	public Candidato(int cod, String nom, String par, int vot){
		codigo  = ""+cod;
		nombre  = nom;
		partido = par;
		votos   = vot;
	}
	
	public String darCodidgo(){
		return codigo;
	}
	
	public String darNombre(){
		return nombre;
	}
	
	public String darPartido(){
		return partido;
	}
	
	public int darVotos(){
		return votos;
	}
	
	public void votar(){
		votos++;
	}
}
