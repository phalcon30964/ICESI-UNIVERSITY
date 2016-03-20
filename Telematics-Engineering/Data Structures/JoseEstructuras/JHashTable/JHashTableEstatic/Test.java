package JHashTableEstatic;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		
		HashTablesEncadenada<Integer, String> e = new HashTablesEncadenada<>(10);
		
		e.insert(12, "dd");
		e.insert(23, "56kd");
		e.insert(3, "drd");
		e.insert(23, "2d");
		e.insert(232, "3d");
		e.insert(212, "jj");
		System.out.println(e);
		e.remove(3, "drd");
		System.out.println(e);
	}

}
