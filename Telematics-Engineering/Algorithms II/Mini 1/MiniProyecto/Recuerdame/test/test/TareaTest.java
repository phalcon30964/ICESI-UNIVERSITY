package test;
import java.sql.Date;

import Mundo.Recuerdame;
import Mundo.Tarea;
import junit.framework.TestCase;

public class TareaTest extends TestCase {
	
	// -------------------------------------------------------------------
	//ATRIBUTOS
	//--------------------------------------------------------------------
	private Tarea tarea;
	
	public void setupEscenario1(){
		
		@SuppressWarnings("deprecation")
		Date fecha = new Date(2014,04,2);
		Tarea tar= new Tarea("Cocinar","cumpleanos", fecha,"Recordatorios");
		
		
		
	}
	

	
}
