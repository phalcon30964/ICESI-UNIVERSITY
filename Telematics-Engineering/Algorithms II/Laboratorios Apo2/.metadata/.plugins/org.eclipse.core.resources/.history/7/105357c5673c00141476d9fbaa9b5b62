package TadCola;

public class Pruebas {

	public static void main(String[] args) {
		//Cola<String> cola= new Cola<String>();
		
		ColaPrioridad<WrapCadena> colap= new ColaPrioridad<WrapCadena>();
		
		WrapCadena v1= new WrapCadena(1,"v1");
		WrapCadena v2= new WrapCadena(5,"v2");
		WrapCadena v3= new WrapCadena(10,"v3");
		WrapCadena v4= new WrapCadena(15,"v4");
		WrapCadena v5= new WrapCadena(20,"v5");
		WrapCadena v11= new WrapCadena(1,"v1.1");
		WrapCadena v12= new WrapCadena(1,"v1.2");
		WrapCadena v13= new WrapCadena(1,"v1.3");
		WrapCadena v31= new WrapCadena(10,"v3.1");
		WrapCadena v32= new WrapCadena(10,"v3.2");
		WrapCadena v33= new WrapCadena(10,"v3.3");
		//WrapCadena v11= new WrapCadena(1,"v1.1");
		
		
		//v1,v1.1,v1.2,v1.3,v3,v3.1,v3.2,v3.3,v4,v5,
		
	    colap.print();
	    
	    System.out.println("No debe haber nada antes de aqui");
	    
	    colap.enQueue(v1);
		colap.enQueue(v2);
		colap.enQueue(v3);
		colap.enQueue(v4);
		colap.enQueue(v5);
		colap.enQueue(v11);
		colap.enQueue(v12);
		colap.enQueue(v13);
		colap.enQueue(v31);
		colap.enQueue(v32);
		colap.enQueue(v33);
		
		System.out.println("hasta aqui debia ir asi v1,v1.1,v1.2,v1.3,v3,v3.1,v3.2,v3.3,v4,v5,");
		
		colap.print();
		
		System.out.println("Ahora debe ir al contrario");
		
		colap.printback();
		
		System.out.println("Ahora debe ir asi v1.3,v3,v3.1,v3.2,v3.3,v4,v5 ");
//		
		colap.deQueue();
		colap.deQueue();
		colap.deQueue();
		
		colap.print();
		
		System.out.println("Ahora debe ir al contrario");
		
		colap.printback();
		
		System.out.println("Ahora debe ir asi v2,v3,v3,v3.1,v3.1,v3.1,v3.2,v3.3,v3.3,v3.3,v4,v5 ");
		
		colap.enQueue(v1);
		colap.enQueue(v2);
		colap.enQueue(v3);
		colap.deQueue();
		colap.deQueue();
		colap.enQueue(v31);
		colap.enQueue(v31);
		colap.enQueue(v33);
		colap.enQueue(v33);
		
		
		colap.print();
		
		System.out.println("Ahora debe ir al contrario");
		
		colap.printback();
	

		
		
		





	}

}
