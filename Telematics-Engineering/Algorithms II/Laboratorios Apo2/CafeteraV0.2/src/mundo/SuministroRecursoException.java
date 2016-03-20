package mundo;

import java.io.Serializable;

public class SuministroRecursoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	//Declaracion de atributos
	
	//la cantidad cuando se genero la exception
	private  double cantidadActual;
	//La cantidad maxima de alamacenamiento
	private  double maximo;
	//El nombre del recurso que produjo exception
	private  String nombreRecurso;
	//Cuanto se inteto suministrar
	private double suministro;
	
	public SuministroRecursoException(String causa, String nomRec, double cantAct, double sumi, double max){
		
		//Llamo al constructo de Exception
		super(causa);
		
		//Inicializo los atributos
		nombreRecurso = nomRec;
		cantidadActual = cantAct;
		maximo = max;
		suministro = sumi;
		
	}
	
	//metodos dar

	public double darCantidadActual() {
		return cantidadActual;
	}


	public double darMaximo() {
		return maximo;
	}


	public String darNombreRecurso() {
		return nombreRecurso;
	}

	public double darSuministro() {
		return suministro;
	}

	
	
	
}
