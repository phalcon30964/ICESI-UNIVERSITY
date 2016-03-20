package TestTADSortedSet;

import TADSortedSet.SortedSet;
import junit.framework.TestCase;

import org.junit.Test;

public class testSortedSet extends TestCase {

	private SortedSet<Integer> conjunto1;
	private SortedSet<Integer> conjunto2;

	private void setUpEscenario1() {

		conjunto1 = new SortedSet<Integer>();

		try {
			conjunto1.add(15);
			conjunto1.add(5);
			conjunto1.add(10);
			conjunto1.add(20);
			conjunto1.add(24);
			conjunto1.add(7);
			conjunto1.add(12);
			conjunto1.add(16);
			conjunto1.add(3);
			conjunto1.add(11);
			conjunto1.add(23);
		} catch (Exception e) {

		}

	}

	private void setUpEscenario2() {

		conjunto2 = new SortedSet<Integer>();

	}

	private void setUpEscenario3() {

		conjunto2 = new SortedSet<Integer>();

		try {
			conjunto2.add(15);
			conjunto2.add(5);
			conjunto2.add(10);
			conjunto2.add(20);
			conjunto2.add(24);
			conjunto2.add(7);
			conjunto2.add(12);
		} catch (Exception e) {
		}

	}

	private void setUpEscenario4() {

		conjunto2 = new SortedSet<Integer>();

		try {
			conjunto2.add(16);
			conjunto2.add(3);
			conjunto2.add(11);
			conjunto2.add(23);
			conjunto2.add(78);
			conjunto2.add(1);
			conjunto2.add(9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testAdd() {
		
		//caso1
		
		setUpEscenario1();

		assertEquals("No se esta agregando en orden",
				"3 5 7 10 11 12 15 16 20 23 24 ", conjunto1.getSet());

		//caso2
		
		setUpEscenario1();
		try {
			conjunto1.add(15);
			assertEquals("Permite agregar elementos repetidos", true, false);
			;
		} catch (Exception e) {
			assertEquals("Permite agregar elementos repetidos", true, true);
			;
		}
	}

	@Test
	public void testRemove() {
		
		//caso1

		setUpEscenario2();

		try {
			conjunto2.remove(80);
			assertEquals("Permite eliminar con conjunto vacio", true, false);
			;
		} catch (Exception e) {
			assertEquals("Permite eliminar con conjunto vacio", true, true);
			;
		}
		
		//caso2

		setUpEscenario1();

		try {
			conjunto1.remove(80);
			assertEquals("Permite eliminar que no estan en el conjunto", true,
					false);
			;
		} catch (Exception e) {
			assertEquals("Permite eliminar que no estan en el conjunto", true,
					true);
			;
		}

		
		//caso 3
		
		setUpEscenario1();
		
		try {
			conjunto1.remove(12);
			assertEquals("No se esta elimando en orden",
					"3 5 7 10 11 15 16 20 23 24 ", conjunto1.getSet());

			conjunto1.remove(7);
			assertEquals("No se esta elimando en orden",
					"3 5 10 11 15 16 20 23 24 ", conjunto1.getSet());

			conjunto1.remove(23);
			assertEquals("No se esta elimando en orden",
					"3 5 10 11 15 16 20 24 ", conjunto1.getSet());

			conjunto1.remove(24);
			assertEquals("No se esta elimando en orden", "3 5 10 11 15 16 20 ",
					conjunto1.getSet());

			conjunto1.remove(15);
			assertEquals("No se esta elimando en orden", "3 5 10 11 16 20 ",
					conjunto1.getSet());
		} catch (Exception e) {

		}
	}

	@Test
	public void testIsElement() {

		setUpEscenario1();

		assertEquals("No esta identificando bien los elementos pertenecientes",
				false, conjunto1.isElement(80));
		assertEquals("No esta identificando bien los elementos pertenecientes",
				false, conjunto1.isElement(100));
		assertEquals("No esta identificando bien los elementos pertenecientes",
				false, conjunto1.isElement(-2));

		assertEquals("No esta identificando bien los elementos pertenecientes",
				true, conjunto1.isElement(15));
		assertEquals("No esta identificando bien los elementos pertenecientes",
				true, conjunto1.isElement(3));
		assertEquals("No esta identificando bien los elementos pertenecientes",
				true, conjunto1.isElement(20));
		assertEquals("No esta identificando bien los elementos pertenecientes",
				true, conjunto1.isElement(10));
	}

	@Test
	public void testIntersection() {

		// caso 1

		setUpEscenario1();
		setUpEscenario3();

		SortedSet<Integer> interseccion = conjunto1.intersection(conjunto2);

		assertEquals("No se esta intersectando bien los conjuntos",
				"5 7 10 12 15 20 24 ", interseccion.getSet());

		// caso 2

		setUpEscenario2();

		SortedSet<Integer> interseccion2 = conjunto1.intersection(conjunto2);

		assertEquals("No se esta intersectando bien los conjuntos", "",
				interseccion2.getSet());

		// caso 3

		setUpEscenario4();

		SortedSet<Integer> interseccion3 = conjunto1.intersection(conjunto2);

		assertEquals("No se esta intersectando bien los conjuntos",
				"3 11 16 23 ", interseccion3.getSet());

	}

	@Test
	public void testUnion() {

		// caso 1
		setUpEscenario1();
		setUpEscenario4();

		SortedSet<Integer> union = conjunto1.union(conjunto2);

		assertEquals("No se esta uniendo bien los conjuntos",
				"1 3 5 7 9 10 11 12 15 16 20 23 24 78 ", union.getSet());

		// caso 2
		setUpEscenario1();
		setUpEscenario2();

		SortedSet<Integer> union2 = conjunto1.union(conjunto2);

		assertEquals("No se esta uniendo bien los conjuntos",
				"3 5 7 10 11 12 15 16 20 23 24 ", union2.getSet());

		// caso 3
		setUpEscenario1();
		setUpEscenario3();

		SortedSet<Integer> union3 = conjunto1.union(conjunto2);

		assertEquals("No se esta uniendo bien los conjuntos",
				"3 5 7 10 11 12 15 16 20 23 24 ", union3.getSet());

	}

}
