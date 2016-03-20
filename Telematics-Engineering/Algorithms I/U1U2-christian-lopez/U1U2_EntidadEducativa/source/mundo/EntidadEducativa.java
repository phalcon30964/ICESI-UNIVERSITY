package mundo;

import java.util.Calendar;

public class EntidadEducativa {

//Relaciones

	private Profesor profesor1;
	private Profesor profesor2;
	private Profesor profesor3;
	private Profesor profesor4;
	private Profesor profesor5;

	private Curso curso1;
	private Curso curso2;
	private Curso curso3;
	private Curso curso4;
	private Curso curso5;
	private Curso curso6;
	private Curso curso7;

//Contructor

	public EntidadEducativa(){
	}

//METODOS

	public Profesor darProfesorConMasCursosDictados(){

		Profesor respuestaProfesor = null;

		int profesor1Cursos = 0;
		int profesor2Cursos = 0;
		int profesor3Cursos = 0;
		int profesor4Cursos = 0;
		int profesor5Cursos = 0;


//asignacion de valores a la variables de los profesores
		
		if(profesor1!=null){
			profesor1Cursos = profesor1.darTotalCursosDictados();
		}
		if(profesor2!=null){
			profesor2Cursos = profesor2.darTotalCursosDictados();
		}
		if(profesor3!=null){
			profesor3Cursos = profesor3.darTotalCursosDictados();
		}
		if(profesor4!=null){
			profesor4Cursos = profesor4.darTotalCursosDictados();
		}
		if(profesor5!=null){
			profesor5Cursos = profesor5.darTotalCursosDictados();
		}

//Comparacion

		int profesorM = 0;



		if(profesor1Cursos>=profesorM){
			profesorM = profesor1Cursos;
			respuestaProfesor = profesor1;
		}

		if(profesor2Cursos>profesorM){
			profesorM = profesor2Cursos;
			respuestaProfesor = profesor2;
		}

		if(profesor3Cursos>profesorM){
			profesorM = profesor3Cursos;
			respuestaProfesor = profesor3;
		}

		if(profesor4Cursos>profesorM){
			profesorM = profesor4Cursos;
			respuestaProfesor = profesor4;
		}

		if(profesor5Cursos>profesorM){
			profesorM = profesor5Cursos;
			respuestaProfesor = profesor5;
		}


		return respuestaProfesor;
	}

	public Curso darCursoMasDictado(){


		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int c5 = 0;
		int c6 = 0;
		int c7 = 0;


		if (curso1!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso1.darNombre()))
				c1++;
			if (profesor2!=null && profesor2.dictaCurso(curso1.darNombre()))
				c1++;
			if (profesor3!=null && profesor3.dictaCurso(curso1.darNombre()))
				c1++;
			if (profesor4!=null && profesor4.dictaCurso(curso1.darNombre()))
				c1++;
			if (profesor5!=null && profesor5.dictaCurso(curso1.darNombre()))
				c1++;
		}
		if (curso2!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso2.darNombre()))
				c2++;
			if (profesor2!=null && profesor2.dictaCurso(curso2.darNombre()))
				c2++;
			if (profesor3!=null && profesor3.dictaCurso(curso2.darNombre()))
				c2++;
			if (profesor4!=null && profesor4.dictaCurso(curso2.darNombre()))
				c2++;
			if (profesor5!=null && profesor5.dictaCurso(curso2.darNombre()))
				c2++;
		}
		if (curso3!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso3.darNombre()))
				c3++;
			if (profesor2!=null && profesor2.dictaCurso(curso3.darNombre()))
				c3++;
			if (profesor3!=null && profesor3.dictaCurso(curso3.darNombre()))
				c3++;
			if (profesor4!=null && profesor4.dictaCurso(curso3.darNombre()))
				c3++;
			if (profesor5!=null && profesor5.dictaCurso(curso3.darNombre()))
				c3++;
		}
		if (curso4!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso4.darNombre()))
				c4++;
			if (profesor2!=null && profesor2.dictaCurso(curso4.darNombre()))
				c4++;
			if (profesor3!=null && profesor3.dictaCurso(curso4.darNombre()))
				c4++;
			if (profesor4!=null && profesor4.dictaCurso(curso4.darNombre()))
				c4++;
			if (profesor5!=null && profesor5.dictaCurso(curso4.darNombre()))
				c4++;
		}
		if (curso5!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso5.darNombre()))
				c5++;
			if (profesor2!=null && profesor2.dictaCurso(curso5.darNombre()))
				c5++;
			if (profesor3!=null && profesor3.dictaCurso(curso5.darNombre()))
				c5++;
			if (profesor4!=null && profesor4.dictaCurso(curso5.darNombre()))
				c5++;
			if (profesor5!=null && profesor5.dictaCurso(curso5.darNombre()))
				c5++;
		}
		if (curso6!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso6.darNombre()))
				c6++;
			if (profesor2!=null && profesor2.dictaCurso(curso6.darNombre()))
				c6++;
			if (profesor3!=null && profesor3.dictaCurso(curso6.darNombre()))
				c6++;
			if (profesor4!=null && profesor4.dictaCurso(curso6.darNombre()))
				c6++;
			if (profesor5!=null && profesor5.dictaCurso(curso6.darNombre()))
				c6++;
		}
		if (curso7!=null) {
			if (profesor1!=null && profesor1.dictaCurso(curso7.darNombre()))
				c7++;
			if (profesor2!=null && profesor2.dictaCurso(curso7.darNombre()))
				c7++;
			if (profesor3!=null && profesor3.dictaCurso(curso7.darNombre()))
				c7++;
			if (profesor4!=null && profesor4.dictaCurso(curso7.darNombre()))
				c7++;
			if (profesor5!=null && profesor5.dictaCurso(curso7.darNombre()))
				c7++;
		}


		//-----------------------------------------------------------------

		int cursoMayor = -1 ;
		Curso cursoMD = null;

		if(cursoMayor<c1){
			cursoMayor = c1;
			cursoMD = curso1;
		}

		if(cursoMayor<c2){
			cursoMayor = c2;
			cursoMD = curso2;
		}

		if(cursoMayor<c3){
			cursoMayor = c3;
			cursoMD = curso3;
		}

		if(cursoMayor<c4){
			cursoMayor = c4;
			cursoMD = curso4;
		}

		if(cursoMayor<c5){
			cursoMayor = c5;
			cursoMD = curso5;
		}

		if(cursoMayor<c6){
			cursoMayor = c6;
			cursoMD = curso6;
		}

		if(cursoMayor<c7){
			cursoMayor = c7;
			cursoMD = curso7;
		}

		return cursoMD;

	}

	public String darProfesoresTiempoCompleto(){
		String profesoresTC = "";

		if(profesor1!=null && profesor1.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
			profesoresTC += profesor1.darNombre() +"-"+profesor1.darCedula()+",";
		}

		if (profesor2!=null && profesor2.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
			profesoresTC += profesor2.darNombre() +"-"+profesor2.darCedula()+",";
		}

		if (profesor3!=null && profesor3.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
			profesoresTC += profesor3.darNombre() +"-"+profesor3.darCedula()+",";
		}

		if (profesor4!=null && profesor4.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
			profesoresTC += profesor4.darNombre() +"-"+profesor4.darCedula()+",";
		}

		if (profesor5!=null && profesor5.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
			profesoresTC += profesor5.darNombre() +"-"+profesor5.darCedula()+",";
		}

		return profesoresTC;

	}

	public String darCursosDiurnos(){
		String cursosD = "";

		if(curso1!=null && curso1.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso1.darNombre()+",";
		}
		if(curso2!=null && curso2.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso2.darNombre()+ ",";
		}
		if(curso3!=null && curso3.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso3.darNombre()+ ",";
		}
		if(curso4!=null && curso4.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso4.darNombre()+ ",";
		}
		if(curso5!=null && curso5.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso5.darNombre()+ ",";
		}
		if(curso6!=null && curso6.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso6.darNombre()+ ",";
		}
		if(curso7!=null && curso7.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
			cursosD += curso7.darNombre()+ ",";
		}

		return cursosD;
	}

	public Profesor darProfesorConMasCreditosDados(){

		Profesor respuestaProfesor = null;

		int profesorMasCreditos = 0;

		int profesor1Creditos = 0;
		int profesor2Creditos = 0;
		int profesor3Creditos = 0;
		int profesor4Creditos = 0;
		int profesor5Creditos = 0;


//asignacion de valores

		if(profesor1!=null){
			profesor1Creditos = profesor1.darTotalCreditosDados();
		}

		if(profesor2!=null){
			profesor2Creditos = profesor2.darTotalCreditosDados();
		}

		if(profesor3!=null){
			profesor3Creditos = profesor3.darTotalCreditosDados();
		}

		if(profesor4!=null){
			profesor4Creditos = profesor4.darTotalCreditosDados();
		}

		if(profesor5!=null){
			profesor5Creditos = profesor5.darTotalCreditosDados();
		}


//Comparacion

		if(profesor1Creditos>=profesorMasCreditos){
			profesorMasCreditos = profesor1Creditos;
			respuestaProfesor = profesor1;
		}

		if(profesor2Creditos>profesorMasCreditos){
			profesorMasCreditos = profesor2Creditos;
			respuestaProfesor = profesor2;
		}

		if(profesor3Creditos>profesorMasCreditos){
			profesorMasCreditos = profesor3Creditos;
			respuestaProfesor = profesor3;
		}

		if(profesor4Creditos>profesorMasCreditos){
			profesorMasCreditos = profesor4Creditos;
			respuestaProfesor = profesor4;
		}

		if(profesor5Creditos>profesorMasCreditos){
			profesorMasCreditos = profesor5Creditos;
			respuestaProfesor = profesor5;
		}

		return respuestaProfesor;
	}

//Metodos Agregar

	public boolean  agregarCurso(String elNombre,int losCreditos, String laJornada, String elDiaSemana, String laHora){
		boolean seAgregoCurso;
		Curso curso = new Curso(elNombre,losCreditos,laJornada, elDiaSemana, laHora);

		if(curso1==null){
			curso1 = curso;
			seAgregoCurso = true;
		}else if(curso2==null && !curso.darNombre().equals(curso1.darNombre())){
			curso2 = curso;
			seAgregoCurso = true;
		}else if(curso3==null && !curso.darNombre().equals(curso1.darNombre()) && !curso.darNombre().equals(curso2.darNombre())){
			curso3 = curso;
			seAgregoCurso = true;
		}else if(curso4==null && !curso.darNombre().equals(curso1.darNombre()) && !curso.darNombre().equals(curso2.darNombre()) && !curso.darNombre().equals(curso3.darNombre())){
			curso4 = curso;
			seAgregoCurso = true;
		}else if(curso5==null && !curso.darNombre().equals(curso1.darNombre()) && !curso.darNombre().equals(curso2.darNombre()) && !curso.darNombre().equals(curso3.darNombre()) && !curso.darNombre().equals(curso4.darNombre())){
			curso5 = curso;
			seAgregoCurso = true;
		}else if(curso6==null && !curso.darNombre().equals(curso1.darNombre()) && !curso.darNombre().equals(curso2.darNombre()) && !curso.darNombre().equals(curso3.darNombre()) && !curso.darNombre().equals(curso4.darNombre()) && !curso.darNombre().equals(curso5.darNombre())){
			curso6 = curso;
			seAgregoCurso = true;
		}else if(curso7==null && !curso.darNombre().equals(curso1.darNombre()) && !curso.darNombre().equals(curso2.darNombre()) && !curso.darNombre().equals(curso3.darNombre()) && !curso.darNombre().equals(curso4.darNombre()) && !curso.darNombre().equals(curso5.darNombre()) && !curso.darNombre().equals(curso6.darNombre())){
			curso7 = curso;
			seAgregoCurso = true;
		}else{ seAgregoCurso = false;
		}

		return seAgregoCurso;
	}

	public boolean agregarProfesor(String nombre,String cedula,String fVinculacion,String celular,String nAcademico,int cPublicaciones,String tContrato,double vHora){
		boolean respuesta=false;

		Profesor nuevoProfesor= new Profesor(nombre,cedula,fVinculacion,celular,nAcademico,cPublicaciones,tContrato);

		if(buscarProfesor(cedula)==null)	{
			if (profesor1==null)	{
				profesor1=nuevoProfesor;
				respuesta=true;
			}
			else 	{
				if(profesor2==null)	{
					profesor2=nuevoProfesor;
					respuesta=true;
				}
				else	{
					if(profesor3==null)	{
						profesor3=nuevoProfesor;
						respuesta=true;
					}
					else	{
						if(profesor4==null)	{
							profesor4=nuevoProfesor;
							respuesta=true;
						}
						else	{
							if(profesor5==null)	{
								profesor5=nuevoProfesor;
								respuesta=true;
							}
						}
					}
				}
			}
		}
		return respuesta;
	}


//Metodos buscar

	public Curso buscarCurso(String elCurso){

		Curso cursoBuscado = null;

		if(curso1!=null && curso1.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso1;
		}else if(curso2!=null && curso2.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso2;
		}else if(curso3!=null && curso3.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso3;
		}else if(curso4!=null && curso4.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso4;
		}else if(curso5!=null && curso5.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso5;
		}else if(curso6!=null && curso6.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso6;
		}else if(curso7!=null && curso7.darNombre().equalsIgnoreCase(elCurso)){
			cursoBuscado = curso7;
		}

		return cursoBuscado;
	}

	public Profesor buscarProfesor(String cedula){

		Profesor profesorBuscado = null;

		if(profesor1!=null && profesor1.darCedula().equals(cedula)){
			profesorBuscado = profesor1;
		}else if(profesor2!=null && profesor2.darCedula().equals(cedula)){
			profesorBuscado = profesor2;
		}else if(profesor3!=null && profesor3.darCedula().equals(cedula)){
			profesorBuscado = profesor3;
		}else if(profesor4!=null && profesor4.darCedula().equals(cedula)){
			profesorBuscado = profesor4;
		}else if(profesor5!=null && profesor5.darCedula().equals(cedula)){
			profesorBuscado = profesor5;
		}

		return profesorBuscado;
	}

//Metodos dar Reporte

	public double valorPromedioProfesoresHoraCatedraCursoMiercoles(){

		double totalValores = 0;

		int numeroProfesores = 0;

		double valorPro = 0.0;

		if( profesor1!=null && esProfesorHoraCatedraDiaMiercoles(profesor1)){
			totalValores+= profesor1.darValorHora();
			numeroProfesores++;
		}

		if(profesor2!=null && esProfesorHoraCatedraDiaMiercoles(profesor2)){
			totalValores+= profesor2.darValorHora();
			numeroProfesores++;
		}

		if(profesor3!=null && esProfesorHoraCatedraDiaMiercoles(profesor3)){
			totalValores+= profesor3.darValorHora();
			numeroProfesores++;
		}

		if(profesor4!=null && esProfesorHoraCatedraDiaMiercoles(profesor4)){
			totalValores+= profesor4.darValorHora();
			numeroProfesores++;
		}

		if(profesor5!=null && esProfesorHoraCatedraDiaMiercoles(profesor5)){
			totalValores+= profesor5.darValorHora();
			numeroProfesores++;
		}

		if(numeroProfesores>0)
			valorPro = (totalValores / numeroProfesores);		

		return valorPro;
	}

	public boolean esProfesorHoraCatedraDiaMiercoles(Profesor profe){
		boolean esProfesor = false;
		Profesor p = profe;

		if (p!=null) {
			Curso c1 = p.darCurso1();
			if (c1!=null&&c1.darDiaSemana().equals(Curso.MIERCOLES)) {
				esProfesor = true;
			}
			Curso c2 = p.darCurso2();
			if (c2!=null&&c1.darDiaSemana().equals(Curso.MIERCOLES)) {
				esProfesor = true;
			}
			Curso c3 = p.darCurso3();
			if (c3!=null&&c1.darDiaSemana().equals(Curso.MIERCOLES)) {
				esProfesor = true;
			}
		}

		return esProfesor;
	}

	public double porcentajeCursosDiurnos(){

		double numeroCursos = 0;
		double sumaCursosDiurnos = 0;
		double porcentaje;


		if(curso1!=null){
			numeroCursos++;
			if(curso1.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
				sumaCursosDiurnos++;
			}
		}

		if(curso2!=null){
			numeroCursos++;
			if(curso2.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
				sumaCursosDiurnos++;
			}
		}

		if(curso3!=null){
			numeroCursos++;
			if(curso3.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
				sumaCursosDiurnos++;
			}
		}

		if(curso4!=null){
			numeroCursos++;
			if(curso4.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
				sumaCursosDiurnos++;
			}
		}

		if(curso5!=null){
			numeroCursos++;
			if(curso5.darJornada().equalsIgnoreCase(Curso.JORNADA_DIURNA)){
				sumaCursosDiurnos++;
			}
		}

		if(curso1==null && curso2==null && curso3==null && curso4==null && curso5==null && curso6==null && curso7==null){
			porcentaje = 0;
		}else{ porcentaje = (sumaCursosDiurnos/numeroCursos);
		}	

		return porcentaje;
	}

	public String profesoresQueContienenInicialDiaActual(){

		String profesores = "";

		char letraDia= darInicialDiaActual();

		if(profesor1!=null && profesor1.darNombre().toLowerCase().indexOf(letraDia)>=0){
			profesores+= profesor1.darNombre() + "\n" ;
		}

		if(profesor2!=null && profesor2.darNombre().toLowerCase().indexOf(letraDia)>=0){
			profesores+= profesor2.darNombre() + "\n" ;
		}

		if(profesor3!=null && profesor3.darNombre().toLowerCase().indexOf(letraDia)>=0){
			profesores+= profesor3.darNombre() + "\n" ;
		}

		if(profesor4!=null && profesor4.darNombre().toLowerCase().indexOf(letraDia)>=0){
			profesores+= profesor4.darNombre() + "\n" ;
		}

		if(profesor5!=null && profesor5.darNombre().toLowerCase().indexOf(letraDia)>=0){
			profesores+= profesor5.darNombre() + "\n" ;
		}
		
		return profesores;
	}

	public char darInicialDiaActual(){
		char inicial = ' ';
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

//valores de los dias que devuelve day of week segun la libreria de java consultada en internet.

		int SUNDAY = 1;
		int MONDAY = 2;
		int TUESDAY = 3;
		int WEDNESDAY = 4;
		int THURSDAY = 5;
		int FRIDAY = 6;
		int SATURDAY = 7;

		if(diaActual==SUNDAY){
			inicial = 'd';
		}else if(diaActual==MONDAY){
			inicial = 'l';
		}else if(diaActual==TUESDAY){
			inicial = 'm';
		}else if(diaActual==WEDNESDAY){
			inicial = 'm';
		}else if(diaActual==THURSDAY){
			inicial = 'j';
		}else if(diaActual==FRIDAY){
			inicial = 'v';
		}else if(diaActual==SATURDAY){
			inicial = 's';
		}

		return inicial;
	}

	public String darNombreCursosConNombreConTotalDeLetrasPar(){

		String mensaje = "";

		if(curso1!=null && removerEspacios(curso1.darNombre()).length()%2==0){
			mensaje+= curso1.darNombre() + "\n";
		}

		if(curso2!=null && removerEspacios(curso2.darNombre()).length()%2==0){
			mensaje+= curso2.darNombre() + "\n";
		}

		if(curso3!=null && removerEspacios(curso3.darNombre()).length()%2==0){
			mensaje+= curso3.darNombre() + "\n";
		}

		if(curso4!=null && removerEspacios(curso4.darNombre()).length()%2==0){
			mensaje+= curso4.darNombre() + "\n";
		}

		if(curso5!=null && removerEspacios(curso5.darNombre()).length()%2==0){
			mensaje+= curso5.darNombre() + "\n";
		}

		if(curso6!=null && removerEspacios(curso6.darNombre()).length()%2==0){
			mensaje+= curso6.darNombre() + "\n";
		}

		if(curso7!=null && removerEspacios(curso7.darNombre()).length()%2==0){
			mensaje+= curso7.darNombre() + "\n";
		}

		return mensaje;

	}

	public String removerEspacios(String cadena){

		String sinEspacios = "";
		sinEspacios = cadena.replaceAll(" ", "");
		return sinEspacios;
	}
	
	public Curso darCursoPorNumero(int n) {

		Curso cursoDado = null;

		int C1 = 1;
		int C2 = 2;
		int C3 = 3;
		int C4 = 4;
		int C5 = 5;
		int C6 = 6;
		int C7 = 7;

		if (C1==n){
			cursoDado = curso1;
		}else if(C2==n){
			cursoDado = curso2;
		}else if(C3==n){
			cursoDado = curso3;
		}else if(C4==n){
			cursoDado = curso4;
		}else if(C5==n){
			cursoDado = curso5;
		}else if(C6==n){
			cursoDado = curso6;
		}else if(C7==n){
			cursoDado = curso7;
		}

		return cursoDado;
	}

	public String darTarifasProfesoresTiempoCompleto() {

		String tarifasProfesores = "";


		if (profesor1!=null) {
			if(profesor1.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
				tarifasProfesores += profesor1.darNombre()+", Tarifa: $"+ profesor1.calcularTarifaHoraTiempoCompleto()+"\n";
			}			
		}

		if (profesor2!=null) {
			if(profesor2.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
				tarifasProfesores += profesor2.darNombre()
						+", Tarifa: $"
						+profesor2.calcularTarifaHoraTiempoCompleto()+"\n";
			}
		}

		if (profesor3!=null) {
			if(profesor3.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
				tarifasProfesores += profesor3.darNombre()+", Tarifa: $"+profesor3.calcularTarifaHoraTiempoCompleto()+"\n";
			}
		}

		if (profesor4!=null) {
			if(profesor4.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
				tarifasProfesores += profesor4.darNombre()+", Tarifa: $"+profesor4.calcularTarifaHoraTiempoCompleto()+"\n";
			}
		}

		if (profesor5!=null) {
			if(profesor5.darTipoContrato().equalsIgnoreCase(Profesor.TIEMPO_COMPLETO)){
				tarifasProfesores += profesor5.darNombre()+", Tarifa: $"+profesor5.calcularTarifaHoraTiempoCompleto()+"\n";
			}
		}
		if (tarifasProfesores.length()>0)
			tarifasProfesores = tarifasProfesores.substring(0,tarifasProfesores.length()-1);

		return tarifasProfesores;

	}

	//Metodos dar objetos

	public Curso darCurso1(){
		return curso1;
	}

	public Curso darCurso2(){
		return curso2;
	}

	public Curso darCurso3(){
		return curso3;
	}

	public Curso darCurso4(){
		return curso4;
	}

	public Curso darCurso5(){
		return curso5;
	}

	public Curso darCurso6(){
		return curso6;
	}

	public Curso darCurso7(){
		return curso7;
	}

	public Profesor darProfesor1(){
		return profesor1;
	}

	public Profesor darProfesor2(){
		return profesor2;
	}

	public Profesor darProfesor3(){
		return profesor3;
	}

	public Profesor darProfesor4(){
		return profesor4;
	}

	public Profesor darProfesor5(){
		return profesor5;
	}

}

