package heap;

public class prueba {

	public static void main(String[] args) {

		Heap<Integer, Integer> c = new Heap<>(10, 0);

		try {
			c.add(5, 5);
			c.add(3, 3);
			c.add(12, 12);
			c.add(25, 25);
			c.add(7, 7);
			c.add(17, 17);
			c.add(20, 20);
			c.add(8, 8);
			c.add(4, 4);

			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.heapSort();
		
		System.out.println(c);

//		System.out.println(c);
//		try {
//			c.maxHeapInsert(35, 90);
//		} catch (HeapException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(c);

	}
}
