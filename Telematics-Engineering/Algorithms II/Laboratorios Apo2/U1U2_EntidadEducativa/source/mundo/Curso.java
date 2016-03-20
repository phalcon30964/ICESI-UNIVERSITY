package mundo;

public class Curso {
	
//Atributos
	
		private String nombre;
		private int creditos;
		private String jornada;
		private String diaSemana;
		private String hora;
		
// Constantes
		
		public static final String JORNADA_DIURNA="Diurna";
		public static final String JORNADA_NOCTURNA="Nocturna";
		public static final String LUNES="Lunes";
		public static final String MARTES="Martes";
		public static final String MIERCOLES="Miercoles";
		public static final String JUEVES="Jueves";
		public static final String VIERNES="Viernes";
		public static final String SABADO="Sabado";
		
//Metodos
		
		// Constructor
		
		public Curso(String elNombre,int losCreditos, String laJornada, String elDiaSemana, String laHora){
			nombre = elNombre;
			creditos = losCreditos;
			jornada = laJornada;
			diaSemana = elDiaSemana;
			hora = laHora;	
		}
		
		// Metodos dar()
		
		public String darNombre(){
			return nombre;
		}
		
		public int darCreditos(){
			return creditos;
		}
		
		public String darJornada(){
			return jornada;
		}
		
		public String darDiaSemana(){
			return diaSemana;
		}
		
		public String darHora(){
			return hora;
		}
		
		//Metodo toString
		
		public String toString(){
			String mensaje="";
			
			mensaje = nombre;
			
			return mensaje;
		}
		
//Fin

}
