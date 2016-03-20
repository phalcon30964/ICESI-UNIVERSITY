package mundo;

public class Pelicula {
	
	private String nombre;
	private String genero;
	private String sinopsis;
	private String idioma;
	private String pais;
	private int duracion;
	
	public Pelicula(String nombre, String genero, String sin, String idioma, String pais, int dur){
		this.nombre = nombre;
		this.genero = genero;
		sinopsis = sin;
		this.idioma = idioma;
		this.pais = pais;
		duracion = dur;
	}
	
	public String darNombre(){
		return nombre;
	}
	public String darGenero(){
		return genero;
	}

	public String darSinopsis(){
		return sinopsis;
	}

	public String darPais(){
		return pais;
	}

	public String darIdioma(){
		return idioma;
	}

	public int darDuracion(){
		return duracion;
	}
	public void cambiarNombre(String nom){
		nombre = nom;
		
	}
	public void cambiarGenero(String gen){
		genero = gen; 
		
	}
	public void cambiarIdioma(String idi){
		idioma = idi; 
		
	}
	public void cambiarSinopsis(String sin){
		sinopsis = sin; 
		
	}
	public void cambiarPais(String pais){
		this.pais = pais; 
		
	}
	public void cambiarDuracion(int dur){
		duracion = dur; 
		
	}
}
