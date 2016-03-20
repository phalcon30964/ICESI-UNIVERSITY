
public class comparador {
	
	public static void main(String[] args) {
		
	
		String a = "2012/8/10";
		String b = "2012/2/10";
		String c = "2014/8/10";
		String d = "2011/08/10";
		String e = "2011/10/09";


		if (a.compareToIgnoreCase(b)>0) {
			System.out.println("a vs b funciono ");
		}else{
			System.out.println("a vs b no funciono ");
		}
		
		if (a.compareToIgnoreCase(c)<0) {
			System.out.println("a vs c funciono ");
		}else{
			System.out.println("a vs c no funciono ");
		}
		
		if (a.compareToIgnoreCase(d)>0) {
			System.out.println("a vs d funciono ");
		}else{
			System.out.println("a vs d no funciono ");
		}
		if (a.compareToIgnoreCase(e)>0) {
			System.out.println("a vs e funciono ");
		}else{
			System.out.println("a vs e no funciono ");
		}
		
		if (b.compareToIgnoreCase(c)<0) {
			System.out.println("b vs c funciono ");
		}else{
			System.out.println("b vs c no funciono ");
		}
		
		if (b.compareToIgnoreCase(d)>0) {
			System.out.println("b vs d funciono ");
		}else{
			System.out.println("b vs d no funciono ");
		}
		if (b.compareToIgnoreCase(e)>0) {
			System.out.println("b vs e funciono ");
		}else{
			System.out.println("b vs e no funciono ");
		}
		if (c.compareToIgnoreCase(d)>0) {
			System.out.println("c vs d funciono ");
		}else{
			System.out.println("c vs d no funciono ");
		}
		if (c.compareToIgnoreCase(e)>0) {
			System.out.println("c vs e funciono ");
		}else{
			System.out.println("c vs e no funciono ");
		}
		if (d.compareToIgnoreCase(e)>0) {
			System.out.println("d vs e funciono ");
		}else{
			System.out.println("d vs e no funciono ");
		}

		

	}

}
