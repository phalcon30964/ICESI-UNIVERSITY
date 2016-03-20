package TADLista;

public class PruebasLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doble<String> listad= new Doble<String>();
		
		listad.agregar("a");
		listad.print();
		
		listad.agregar("b");
		listad.agregar("c");
		listad.agregar("d");
		listad.print();
		listad.printback();
		
		listad.eliminar(0);
		listad.eliminar(0);

		listad.print();
		listad.printback();
		
		
		
		
		

	}

}
