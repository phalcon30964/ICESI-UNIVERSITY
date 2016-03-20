package modular;

public class modulo {

	public static void main(String[] args) {
		
		int i = 1;
		while((Math.pow(5,i)-1) % 64 != 0)
		{
		i++;
		System.out.println(i);
		}
		System.out.println(i);
		
	}
	

}
