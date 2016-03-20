package mundo;

public class Profesor {
	
//Atributos
	
		private String nombre;
		private String cedula;
		private String fechaVinculacion;
		private String celular;
		private String nivelAcademico;
		private int cantidadPublicaciones;
		private String tipoContrato;
		private double valorHora;
		
//Constantes
		
		public static final String TIEMPO_COMPLETO="Tiempo Completo";
		public static final String HORA_CATEDRA="Hora Catedra";
		public static final String NIVEL_ACADEMICO_PROFESIONAL="Profesional";
		public static final String NIVEL_ACADEMICO_MAGISTER="Magister";
		public static final String NIVEL_ACADEMICO_DOCTOR="Doctor";
		
//Relaciones
		 
		public Curso curso1;
		public Curso curso2;
		public Curso curso3;
		
		
//Metodos
		
		//Constructor
		
		public Profesor(String elNombre, String laCedula, String laFecha, String elCelular, String elNivel, int laCantidad, String elTipoContrato){
			nombre = elNombre;
			cedula = laCedula;
			fechaVinculacion = laFecha;
			celular = elCelular;
			nivelAcademico = elNivel;
			cantidadPublicaciones = laCantidad;
			tipoContrato = elTipoContrato;
		}
		
		//Metodos cambiar
		
		public void cambiarValorHora(double laHora){
			valorHora = laHora;
		}
		
		//Metodos dar
		
		public String darNombre(){
			return nombre;
		}
		
		public String darCedula(){
			return cedula;
		}
		
		public String darFechaVinculacion(){
			return fechaVinculacion;
		}
		
		public String darCelular(){
			return celular;
		}
		
		public String darTipoContrato(){
			return tipoContrato;	
		}
		
		public double darValorHora(){
			return valorHora;
		}
		
		public String darNivelAcademico(){
			return nivelAcademico;
		}
		
		public int darCantidadPublicaciones(){
			return cantidadPublicaciones;
		}
		
		
		//Metos de reporte
		
	    public String darCursosDictados(){
			
			String cursosDictados = "";
			
			if(curso1!=null){
				cursosDictados += curso1.darNombre()+","; 
			}
			
			if(curso2!=null){
				cursosDictados += curso2.darNombre()+",";
			}
			
			if(curso3!=null){
				cursosDictados += curso3.darNombre()+",";
			} 	
				return cursosDictados;	
		}
	    
	    public int darTotalCreditosDados(){
	    	
			int totalCreditos = 0;
			
			if(curso1!=null){
				totalCreditos += curso1.darCreditos();
			}
			if(curso2!=null){
				totalCreditos += curso2.darCreditos();
			}
			if(curso3!=null){
				totalCreditos += curso3.darCreditos();
			}
			
			return totalCreditos;
		}
		
		public boolean dictaCurso(String nombre){
			
			boolean dicta;
			
			if(curso1!=null && curso1.darNombre().equalsIgnoreCase(nombre)){
				dicta=true;
			}else if(curso2!=null && curso2.darNombre().equalsIgnoreCase(nombre)){
				dicta=true;
			}else if(curso3!=null && curso3.darNombre().equalsIgnoreCase(nombre)){
				dicta=true;
			}else{ 
				dicta=false;
			}
			
			return dicta;
		}
		
		public int darTotalCursosDictados(){
			int totalCursos = 0;
			
			if(curso1!=null){
				totalCursos++;
			}
			
			if(curso2!=null){
				totalCursos++;
			}
			if(curso3!=null){
				totalCursos++;
			}
			
			return totalCursos;
		}
		
		public boolean agregarCurso(Curso curso){
			boolean agregoCurso;
			
			if(curso1==null){
				curso1=curso;
				agregoCurso=true;
			}else if(curso2==null && !curso1.darNombre().equals(curso.darNombre())){
				curso2=curso;
				agregoCurso=true;	
			}else if(curso3==null && !curso1.darNombre().equals(curso.darNombre()) && !curso2.darNombre().equals(curso.darNombre())){
				curso3=curso;
				agregoCurso=true;
			}else{agregoCurso=false;
			}
			
			return agregoCurso;	
		}
		
		public String toString(){
			String mensaje="";
			
			mensaje = nombre+"-"+cedula;
			
			return mensaje;
			
		//da el nombre y la cedula del profesor separadas por un -
		}
		
		public double calcularTarifaHoraTiempoCompleto(){
			
			double tarifaPorHora = 0;
			
			String a= fechaVinculacion.charAt(fechaVinculacion.length()-1)+"";
			String b= fechaVinculacion.charAt(fechaVinculacion.length()-2)+"";
			String c= fechaVinculacion.charAt(fechaVinculacion.length()-3)+"";
			String d= fechaVinculacion.charAt(fechaVinculacion.length()-4)+"";
			
			int anioVinculacion =  Integer.parseInt(d+c+b+a);
			
			if(nivelAcademico.equals(NIVEL_ACADEMICO_PROFESIONAL)){
				tarifaPorHora = (cantidadPublicaciones*2000) + ((2013 - anioVinculacion)*2000) + 18000;
			}else if(nivelAcademico.equals(NIVEL_ACADEMICO_MAGISTER)){
				tarifaPorHora = (cantidadPublicaciones*2000) + ((2013 - anioVinculacion)*2000) + 35000;
			}else if( nivelAcademico.equals(NIVEL_ACADEMICO_DOCTOR)){
				tarifaPorHora = (cantidadPublicaciones*2000) + ((2013 - anioVinculacion)*2000) + 60000;
			}
			
			return tarifaPorHora;
		}
		
		//Metodos darCurso
		
		public Curso darCurso1(){
		return curso1;
		}

		public Curso darCurso2(){
		return curso2;
		}

		public Curso darCurso3(){
		return curso3;
		}	
		
//Fin
}
