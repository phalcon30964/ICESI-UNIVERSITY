package mundo;

@SuppressWarnings("serial")
public class FormatoInvalidoException extends Exception {
	
	//Atributos de la exception
	
	private String nombreArchivo;
	
	private int numeroLineaPrimerError;
	
	//Constructor
	
	public FormatoInvalidoException(String msjCausa, String nombreArch, int numeroLineaError){
		
		super(msjCausa);
		nombreArchivo = nombreArch;
		numeroLineaPrimerError = numeroLineaError;
	}
	
	//Metodos
	
	public String darNombreArchivo(){
		return nombreArchivo;
	}
	
	public int darNumeroLineaPrimerError(){
		return numeroLineaPrimerError;
	}
	
	
	
	
}
