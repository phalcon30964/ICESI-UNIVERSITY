package JHashTableDinamic;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		HashTableDinamic<Integer, Integer> tabla = new HashTableDinamic<>();
		for (int i = 0; i < 13; i++) {
			Random a = new Random(1000);
			try {
				tabla.insert(i,a.nextInt());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
