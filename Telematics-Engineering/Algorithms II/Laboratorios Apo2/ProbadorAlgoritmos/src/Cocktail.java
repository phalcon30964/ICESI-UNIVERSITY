
public class Cocktail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arreglo1 = {10,9,8,7,6,5,4,3,2,1};
		int[] arreglo = {58,71,64,26,37,92,1,11,14,83,57,39};
		
		boolean intercambio = false;
		int tam = arreglo.length;
		
		//
		int iteraciones = 0;
		//
		
		while(tam>0 && !intercambio){
			
			int control = 0;
			
			for (int i = 0; i < arreglo.length-1 ; i++) {
				//
				iteraciones++;
				//
				if (arreglo[i]>arreglo[i+1]) {
					int temp = arreglo[i];
					arreglo[i]=arreglo[i+1];
					arreglo[i+1]=temp;
					control++;
				}
			}
			
			
			if (control>0) {
				
				control=0;
				
				for (int j = arreglo.length-1 ; j > 0 ; j--) {
					//
					iteraciones++;
					//
					if (arreglo[j-1]>arreglo[j]) {
						int temp = arreglo[j-1];
						arreglo[j-1]=arreglo[j];
						arreglo[j]=temp;
						control++;	
					}	
				}	
			}
			
			
			if (control==0) {
				intercambio = true;
			}
			
			tam--;
			
		}
		
		String t ="";
		for (int i = 0; i < arreglo.length; i++) {
			t+= " - "+arreglo[i];
		}
		System.out.println(t);
		//
		
		System.out.println("se hizo en: "+iteraciones+" numero de iteraciones");
	}

}
