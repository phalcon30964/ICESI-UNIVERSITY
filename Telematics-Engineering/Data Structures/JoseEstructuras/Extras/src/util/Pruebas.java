package src.util;

import src.util.listas.SimpleLinkedList;

public class Pruebas {
	
	 

	public static void main(String[] args) {
		SimpleLinkedList<Integer>  lista=new SimpleLinkedList<Integer>();
		String prueba="H;I;";
		String[] pruebas=prueba.split(";");
		
			
		System.out.println(pruebas[0]);
	}	
}
