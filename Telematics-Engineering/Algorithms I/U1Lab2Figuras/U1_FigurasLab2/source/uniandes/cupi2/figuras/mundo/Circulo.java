package uniandes.cupi2.figuras.mundo;

public class Circulo {

	//atributos
	
	private double radio;
	
	//Relaciones
	
	private Punto centro;
	private Color colorLineas;
	private Color colorRelleno;
	
	// Metodos
	
	public Circulo(){} //Constructor
	
	public void inicializar(Punto elPunto,double elRadio, Color relleno, Color lineas){
		
	}
	
	public Color darColorLineas(){
		return colorLineas;
		
	}
	
	public double darPerimetro(){
		double perimetro;
		perimetro = 2 * 3.14159265359 * radio;
		return perimetro;
		
	}
	
	public double darArea(){
		double area;
		area = 3.14159265359 * radio * radio;
		return area;
		
	}
	
	public double darRadio(){
		return radio;	
	}
	
	public void cambiarRadio(double nRadio){ 
		//como es void no retorna nada y no le pongo nada en return	
	}
	/*
	public String metodo1(){
		return respuesta1;
		//me arroja error porque no he declarado en ningun lugar respuesta 1
	}
	
	public String metodo2(){
		return respuesta2;
		//me arroja error porque no he declarado en ningun lugar respuesta 2
	}
	*/
}
