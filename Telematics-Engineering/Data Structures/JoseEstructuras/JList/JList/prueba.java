package JList;

import java.io.IOException;

public class prueba{

	public static void main(String[] args) throws IOException {

		JDobleList<Integer> nueva = new JDobleList<Integer>();

		for (int i = 1; i <= 10; i++) {
			nueva.add(i);
		}
		 nueva.removeIndex(1);
		 System.out.println(nueva);
		

		// nueva.addIndex(5, 123);
		// nueva.addIndex(12, 95);
	
		// System.out.print(nueva);
	}
}
