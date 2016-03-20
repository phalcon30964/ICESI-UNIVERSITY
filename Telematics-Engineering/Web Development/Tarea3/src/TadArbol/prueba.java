package TadArbol;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import TadLista.*;

public class prueba {
	
	public static void main(String[] args) {
		
		ArbolAVL<Integer ,Integer > arbol = new ArbolAVL<Integer, Integer>();
//		JFrame dibujo = DrawBST.draw(arbol);
		
		try {
//
//			int[] n = {50,30,20,60,70,55,57,58};
//			
//			for (int i = 0; i < n.length; i++) {
//				JOptionPane.showMessageDialog(null, "Se va a agregar "+ n[i] );
//				arbol.agregar(n[i] ,n[i] );
//				dibujo.revalidate();
//			  	
//			}
		
			
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		for (int i = 0; i < 10000; i++) {
			numeros.add(i);

		}
		
		Collections.shuffle(numeros);
		
			
		for (int i = 1; i <=1000; i++) {
			arbol.agregar((int)numeros.get(i),(int)numeros.get(i));
		}
		
		System.out.println(arbol.cadenaInorden());
			
//		for (int i = 0; i < 30; i++) {
//			arbol.agregar(i,i);
//		}
		
//		dibujo.revalidate();

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
