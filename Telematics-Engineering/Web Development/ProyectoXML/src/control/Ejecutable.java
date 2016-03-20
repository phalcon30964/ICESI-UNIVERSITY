package control;

import modelo.Institucion;

public class Ejecutable {

	public static void main(String[] args) {
		Institucion i = new Institucion();
		i.addSecretaria("lina", "quintero", "1", "cra 1a 77-23", "12345", "a", "1000000");
		i.addSecretaria("lina2", "quintero", "2", "cra 1a 77-23", "12345", "a", "1000000");
		i.addSecretaria("lina3", "quintero", "3", "cra 1a 77-23", "12345", "a", "1000000");
		i.addSecretaria("lina4", "quintero", "4", "cra 1a 77-23", "12345", "a", "1000000");
		i.addSecretaria("lina5", "quintero", "5", "cra 1a 77-23", "12345", "a", "1000000");
		System.out.println(i.getNombresSecretarias());
	}

}
