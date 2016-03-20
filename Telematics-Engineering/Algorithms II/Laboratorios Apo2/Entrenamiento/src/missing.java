import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class missing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String linea = in.nextLine();
		
		while(!linea.equals("0"))
		{
			String[] datos = linea.split(" ");
			
			int n = Integer.parseInt(datos[0]);
			int p = Integer.parseInt(datos[1]);
			
			int[] respuesta = new int[3];
			
			if(p%2!=0){
				respuesta[0]=(p+1);
				respuesta[1]=(n-p);
				respuesta[2]=(n-(p-1));
			}else{
				
				respuesta[0]=(p-1);
				respuesta[1]=(n-(p-1));
				respuesta[2]=(n-(p-2));
			}
			
			for (int i = respuesta.length-1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					
					if(respuesta[j]>respuesta[j+1]){
						int temp = respuesta[j];
						respuesta[j]= respuesta[j+1];
						respuesta[j+1]=temp;
					}
					
				}
				
			}
			
			System.out.println(respuesta[0]+" "+respuesta[1]+" "+respuesta[2]);
			
			linea = in.nextLine();
		} 
		
	}
	
}
