package mundo;

public class Convertidor {
	
	private double centigrados;
	
	public Convertidor(){}
	
	public void cambiarCentigrados(double c){
		
		centigrados = c;
	}
	
	public double convertirAFahrenheit(){
		
		return (centigrados*1.8)+32;
	}
	
	public double convertirAKelvin(){
		
		return (centigrados-32)/1.8;
	}
	
	public double darCentigrados(){
		return centigrados;
	}

}
