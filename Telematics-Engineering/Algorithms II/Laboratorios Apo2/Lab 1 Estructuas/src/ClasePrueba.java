import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ClasePrueba {
	
	public final static int[] n = {10,	100,	1000,	10000,	100000,	
		200000,	300000,	400000,	500000,	600000,	700000,	800000,	900000,	1000000,	2000000,	3000000,	
		4000000,	5000000,	6000000,	7000000,	8000000,	9000000,	10000000};
	
	public int[] darN(){
		 return n;
	}
	

	public  int algoritmo1(int n){ 
		
		int contador=0;
		
		int respuesta=n*(n+1)/2;
		
		//suma intrucciones respuesta=n*(n+1)/2
		contador+=7;
		
		return contador;
	}
	
	public  int algoritmo2(int n){ 
		
		int contador=0;
		
		
		int respuesta=0;
		
		//suma instruccion respuesta=0
		contador+=1;
		
		int i=0;
		//suma instruccion i=1
		contador+=2;
		
		for(i=1;i<=n;i++){ 
			
			//suma evaluacion de i<=n y lectura de i,n
			contador+=3;
			
			respuesta=respuesta+i;
			
			//suma instruccion respuesta=respuesta+i, lectura de respuesta y i
			contador+=3;
			
			//suma de avance i=i+1, lectura suma y asignacion
			contador+=3;
			
		}
		
		//suma evaluacion i<=n por ultima vez
		contador+=1;
		
		return contador;
	}
	
	public int algoritmo3(int n){
		
	int contador=0;
	
		int respuesta=0;
		
		//suma asignacion respuesta=0
		contador+=1;
		
		int i=0;
		
		//suma de creacion y asignacion i=1
		contador+=2;
		
		for(i=1;i<=n;i++){
			
			//suma evaluacion condicion i<=n y letura de n,i
			contador+=3;
			
			int j=0;
			
			//suma de creacion, asignacion de j=i y lectura de i
			contador+=3;
			
			for(j=i;j<=n;j++){ 
				
				//suma evaluacion condicion j<=n y letura de n,j
				contador+=3;
				
				respuesta=respuesta+i;
				
				//suma lectura de respuesta y i, suma y asignacion
				contador+=4;
				
				//suma de avance j=j+1, lectura suma y asignacion
				contador+=3;
			
			}
			
			//suma ultima condicion j<=n y letura de n,j
			contador+=3;
			
			//suma de avance i=i+1, lectura suma y asignacion
			contador+=3;
		}
		
		//suma ultima evaluacion condicion i<=n y letura de n,i
		contador+=3;
		
		return contador;
	}
	
	public int algoritmo4(int n){ 
		
		int contador=0;
	
		int respuesta=0;
		
		//suma de creacion respuesta y asignacion respuesta=0
		contador+=2;
		
		int i=0;
		
		//suma de creacion y asignacion i=1
		contador+=2;
		
		for(i=1;i<=n;i++){
			
			//suma evaluacion condicion i<=n y letura de n,i
			contador+=3;
			
			int var=(int) Math.pow(2, i);
			
			//suma de crecion var y llamada metodo pow lectura de i (falta saber que complejidad tiene pow
			contador+=3;
			
			int j=0;
			
			//suma de creacion, asignacion de j=i y lectura de i
			contador+=3;
			

			for(j=1;j<=var;j++){ 
				
				//evaluacion condicion j<=var y letura de var,j
				contador+=3;
				
				respuesta=respuesta+i;
				
				//suma lectura de respuesta y i, suma y asignacion
				contador+=4;
				
				//suma de avance j=j+1, lectura suma y asignacion
				contador+=3;
				
			}
			
			//suma ultima evaluacion condicion j<=var y letura de var,j
			contador+=3;
			
			//suma de avance i=i+1, lectura suma y asignacion
			contador+=3;
			
		}
		
		//suma  ultima evaluacion condicion i<=n y letura de n,i
		contador+=3;
		
		return contador;
		
	}
	
	
	public int algoritmo5(int n){
		
		int contador=0;
		
		int resultado=0;
		//creacion respuesta y asignacion 0
		contador+=2;
		
		int i=2;
		
		//suma de creacion y asignacion i=2
		contador+=2;

		while(i<n){
			
			//suma evaluacion condicion i<=n y letura de n,i
			contador+=3;
			
			resultado=resultado+1;
			
			//suma lectura de respuesta suma y asignacion
			contador+=3;
			
			i=i*2;
			
			//suma lectura de i, multiplicacion y asignacion (avance)
			contador+=3;
			
		}
		
		//suma ultima evaluacion condicion i<=n y letura de n,i
		contador+=3;
		
		
		return contador;
		
	}
	
	
	public int algoritmo6(int n){
		
		int contador=0;
			
		int resultado=0;
		//creacion respuesta y asignacion 0
		contador+=2;
		
		
		int i=0;
		//suma de creacion y asignacion i=1
		contador+=2;
		
		for(i=1;i<=n;i++){ 
			
			//suma evaluacion condicion i<=n y letura de n,i
			contador+=3;
			
			
			for(int j=n;j<=1;j++){ 
				
				//suma evaluacion condicion j<=1 y letura de j
				contador+=2;
				
				int k=2;
				
				//suma creacion k y asignacion
				contador+=2;
				
				while(k<n){
					
					//suma evaluacion condicion k<n y letura de k,n
					contador+=3;
					
					resultado=resultado+1;
					//suma lectura de respuesta suma y asignacion
					contador+=3;
					
					k=k+2;
					//suma de lectura de k suma 2 y asignacion
					contador+=3;
				}
				
				//suma ultima evaluacion condicion k<n y letura de k,n
				contador+=3;
				
				//suma de avance j=j+1, lectura suma y asignacion
				contador+=3;
				
			}
			
			//suma ultima evaluacion condicion j<=1 y letura de j
			contador+=2;
			
			//suma de avance i=i+1, lectura suma y asignacion
			contador+=3;
		}
		
		//suma ultima evaluacion condicion j<=1 y letura de j
		contador+=2;
		
		
		return contador;
		
		}
	
	
	//metodo que imprime en archivo
	public void imprimir(String cadena){

		File archivo=new File("archivo.txt");
		
			try {
				FileWriter escritor=new FileWriter(archivo,true);
				BufferedWriter colador=new BufferedWriter(escritor);
				colador.write(cadena);
				colador.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}		

}
