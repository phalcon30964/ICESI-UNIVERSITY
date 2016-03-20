package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mundo.Curso;
import mundo.EntidadEducativa;
import mundo.Profesor;

import org.junit.Test;

public class EntidadEducativaTest {

	private EntidadEducativa entidadEducativa;
	private Curso curso1;
	private Curso curso2;
	private Curso curso3;
	private Curso curso4;
	private Curso curso5;
	private Curso curso6;
	private Curso curso7;
	private Profesor profesor1;
	private Profesor profesor2;
	private Profesor profesor3;
	private Profesor profesor4;
	private Profesor profesor5;
	
	public void setupEscenario1(){
		entidadEducativa = new EntidadEducativa();
		configurarProfesores();
	}
	
	public void setupEscenario2(){
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		configurarProfesores();
		
		profesor1.agregarCurso(curso1);
		profesor1.agregarCurso(curso3);
		profesor2.agregarCurso(curso5);
		profesor2.agregarCurso(curso2);
		profesor2.agregarCurso(curso6);
		profesor3.agregarCurso(curso1);
		profesor4.agregarCurso(curso7);
		profesor4.agregarCurso(curso6);
		profesor4.agregarCurso(curso5);
		profesor5.agregarCurso(curso3);
		profesor5.agregarCurso(curso1);
		profesor5.agregarCurso(curso4);
	}
	
	public void setupEscenario3(){
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		configurarProfesores();
		
		profesor1.agregarCurso(curso4);
		profesor1.agregarCurso(curso3);
		profesor2.agregarCurso(curso6);
		profesor3.agregarCurso(curso2);
		profesor4.agregarCurso(curso6);
		profesor4.agregarCurso(curso5);
		profesor5.agregarCurso(curso3);
		profesor5.agregarCurso(curso1);
		profesor5.agregarCurso(curso4);
	}
	
	public void setupEscenario4(){
		entidadEducativa = new EntidadEducativa();
		
		entidadEducativa.agregarProfesor("Angela", "112342", "10/01/2008", "3144322156", Profesor.NIVEL_ACADEMICO_MAGISTER, 2, Profesor.TIEMPO_COMPLETO, 0);
		entidadEducativa.agregarProfesor("Hugo", "43355734", "10/09/2005", "3132123567", Profesor.NIVEL_ACADEMICO_DOCTOR, 10, Profesor.TIEMPO_COMPLETO, 0);
		entidadEducativa.agregarProfesor("David", "2353475", "10/09/2008", "3152961268", Profesor.NIVEL_ACADEMICO_PROFESIONAL, 1, Profesor.HORA_CATEDRA, 20000);		
		
		entidadEducativa.agregarCurso("Redes y Comunicaciones", 4, Curso.JORNADA_NOCTURNA, Curso.VIERNES, "14:00");
		entidadEducativa.agregarCurso("Seguridad", 3, Curso.JORNADA_NOCTURNA, Curso.MARTES, "14:00");
	}
	
	public void configurarCursos(){
		entidadEducativa.agregarCurso("Ingesoft", 3, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "16:00");
		entidadEducativa.agregarCurso("Algoritmos I", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "08:00");
		entidadEducativa.agregarCurso("Redes y Comunicaciones", 4, Curso.JORNADA_NOCTURNA, Curso.VIERNES, "14:00");
		entidadEducativa.agregarCurso("Seguridad", 3, Curso.JORNADA_NOCTURNA, Curso.MARTES, "14:00");
		entidadEducativa.agregarCurso("Fisica", 3, Curso.JORNADA_DIURNA, Curso.JUEVES, "11:00");
		entidadEducativa.agregarCurso("Calculo Integral", 4, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "14:00");
		entidadEducativa.agregarCurso("Bases de Datos", 3, Curso.JORNADA_NOCTURNA, Curso.LUNES, "16:00");
		
		curso1 = entidadEducativa.darCurso1();
		curso2 = entidadEducativa.darCurso2();
		curso3 = entidadEducativa.darCurso3();
		curso4 = entidadEducativa.darCurso4();
		curso5 = entidadEducativa.darCurso5();
		curso6 = entidadEducativa.darCurso6();
		curso7 = entidadEducativa.darCurso7();
	}
	
	public void configurarProfesores(){
		entidadEducativa.agregarProfesor("Angela", "112342", "10/01/2008", "3144322156", Profesor.NIVEL_ACADEMICO_MAGISTER, 2, Profesor.TIEMPO_COMPLETO, 0);
		entidadEducativa.agregarProfesor("Hugo", "43355734", "10/09/2005", "3132123567", Profesor.NIVEL_ACADEMICO_DOCTOR, 10, Profesor.TIEMPO_COMPLETO, 0);
		entidadEducativa.agregarProfesor("David", "2353475", "10/09/2008", "3152961268", Profesor.NIVEL_ACADEMICO_PROFESIONAL, 1, Profesor.HORA_CATEDRA, 20000);
		entidadEducativa.agregarProfesor("Daniel", "6532356", "10/05/2009", "3113446789", Profesor.NIVEL_ACADEMICO_DOCTOR, 15, Profesor.HORA_CATEDRA, 40000);
		entidadEducativa.agregarProfesor("Alvaro", "885456432", "10/09/2006", "3136677542", Profesor.NIVEL_ACADEMICO_DOCTOR, 6, Profesor.TIEMPO_COMPLETO, 0);

		profesor1 = entidadEducativa.darProfesor1();
		profesor2 = entidadEducativa.darProfesor2();
		profesor3 = entidadEducativa.darProfesor3();
		profesor4 = entidadEducativa.darProfesor4();
		profesor5 = entidadEducativa.darProfesor5();
	}
	
	@Test
	public void testDarProfesorConMasCursosDictados() {
		setupEscenario1();
		assertEquals("No se está identificando el profesor con más cursos dictados correctamente", profesor1.darNombre(), entidadEducativa.darProfesorConMasCursosDictados().darNombre());
		
		setupEscenario2();
		assertEquals("No se está identificando el profesor con más cursos dictados correctamente", profesor2.darNombre(), entidadEducativa.darProfesorConMasCursosDictados().darNombre());
	
		setupEscenario3();
		assertEquals("No se está identificando el profesor con más cursos dictados correctamente", profesor5.darNombre(), entidadEducativa.darProfesorConMasCursosDictados().darNombre());
	}

	@Test
	public void testDarCursoMasDictado() {
		setupEscenario1();
		assertEquals("No se está identificando el curso más dictado correctamente", null, entidadEducativa.darCursoMasDictado());
		
		setupEscenario2();
		assertEquals("No se está identificando el curso más dictado correctamente", curso1.darNombre(), entidadEducativa.darCursoMasDictado().darNombre());
	
		setupEscenario3();
		assertEquals("No se está identificando el curso más dictado correctamente", curso3.darNombre(), entidadEducativa.darCursoMasDictado().darNombre());
	}

	@Test
	public void testDarProfesoresTiempoCompleto() {
		setupEscenario1();
		assertEquals("No se están identificando los profesores de tiempo completo correctamente", "Angela-112342,Hugo-43355734,Alvaro-885456432,", entidadEducativa.darProfesoresTiempoCompleto());
		
		entidadEducativa = new EntidadEducativa();		
		assertEquals("No se están identificando los profesores de tiempo completo correctamente", "", entidadEducativa.darProfesoresTiempoCompleto());
	
		setupEscenario4();
		assertEquals("No se están identificando los profesores de tiempo completo correctamente", "Angela-112342,Hugo-43355734,", entidadEducativa.darProfesoresTiempoCompleto());
	}

	@Test
	public void testDarCursosDiurnos() {
		setupEscenario2();
		assertEquals("No se están identificando los cursos diurnos correctamente", "Ingesoft,Algoritmos I,Fisica,Calculo Integral,", entidadEducativa.darCursosDiurnos());
		
		setupEscenario4();
		assertEquals("No se están identificando los cursos diurnos correctamente", "", entidadEducativa.darCursosDiurnos());
	}

	@Test
	public void testDarProfesorConMasCreditosDados() {
		entidadEducativa = new EntidadEducativa();	
		assertEquals("No se está identificando el profesor que más créditos dicta correctamente", null, entidadEducativa.darProfesorConMasCreditosDados());

		setupEscenario2();
		assertEquals("No se está identificando el profesor que más créditos dicta correctamente", "Hugo-43355734", entidadEducativa.darProfesorConMasCreditosDados().toString());
		
		setupEscenario3();
		assertEquals("No se está identificando el profesor que más créditos dicta correctamente", "Alvaro-885456432", entidadEducativa.darProfesorConMasCreditosDados().toString());
	
		setupEscenario4();
		assertEquals("No se está identificando el profesor que más créditos dicta correctamente", "Angela-112342", entidadEducativa.darProfesorConMasCreditosDados().toString());
	}

	@Test
	public void testAgregarCurso() {
		entidadEducativa = new EntidadEducativa();
		
		assertEquals("El curso 1 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Ingesoft", 3, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "16:00"));
		assertEquals("El curso 2 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Algoritmos I", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "08:00"));
		assertEquals("El curso 2 se agregó repetido. Esto no debe ser posible", false, entidadEducativa.agregarCurso("Algoritmos I", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "08:00"));
		
		assertEquals("El curso 3 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Redes y Comunicaciones", 4, Curso.JORNADA_DIURNA, Curso.VIERNES, "14:00"));
		assertEquals("El curso 4 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Seguridad", 3, Curso.JORNADA_DIURNA, Curso.MARTES, "14:00"));
		assertEquals("El curso 5 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Fisica", 3, Curso.JORNADA_DIURNA, Curso.JUEVES, "11:00"));
		assertEquals("El curso 2 se agregó repetido. Esto no debe ser posible", false, entidadEducativa.agregarCurso("Fisica", 3, Curso.JORNADA_DIURNA, Curso.JUEVES, "11:00"));
		
		assertEquals("El curso 6 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Calculo Integral", 4, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "14:00"));
		assertEquals("El curso 7 no se está agregando correctamente", true, entidadEducativa.agregarCurso("Bases de Datos", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "16:00"));
		assertEquals("El curso 8 se agregó (más de lo permitido)", false, entidadEducativa.agregarCurso("Agua y Vida", 2, Curso.JORNADA_DIURNA, Curso.MARTES, "14:00"));		
	}

	@Test
	public void testAgregarProfesor() {
		entidadEducativa = new EntidadEducativa();
		
		assertEquals("El profesor 1 no se está agregando correctamente", true, entidadEducativa.agregarProfesor("Angela", "112342", "10/01/2008", "3144322156", Profesor.NIVEL_ACADEMICO_MAGISTER, 2, Profesor.TIEMPO_COMPLETO, 0));
		assertEquals("El profesor 1 se agregó repetido. Esto no debe ser posible", false, entidadEducativa.agregarProfesor("Angela", "112342", "10/01/2008", "3144322156", Profesor.NIVEL_ACADEMICO_MAGISTER, 2, Profesor.TIEMPO_COMPLETO, 0));		
		
		assertEquals("El profesor 2 no se está agregando correctamente", true, entidadEducativa.agregarProfesor("Hugo", "43355734", "10/09/2005", "3132123567", Profesor.NIVEL_ACADEMICO_DOCTOR, 10, Profesor.TIEMPO_COMPLETO, 0));
		assertEquals("El profesor 3 no se está agregando correctamente", true, entidadEducativa.agregarProfesor("David", "2353475", "10/09/2008", "3152961268", Profesor.NIVEL_ACADEMICO_PROFESIONAL, 1, Profesor.HORA_CATEDRA, 20000));
		assertEquals("El profesor 4 no se está agregando correctamente", true, entidadEducativa.agregarProfesor("Daniel", "6532356", "10/05/2009", "3113446789", Profesor.NIVEL_ACADEMICO_DOCTOR, 15, Profesor.HORA_CATEDRA, 40000));
		assertEquals("El profesor 4 se agregó repetido. Esto no debe ser posible", false, entidadEducativa.agregarProfesor("Daniel", "6532356", "10/05/2009", "3113446789", Profesor.NIVEL_ACADEMICO_DOCTOR, 15, Profesor.HORA_CATEDRA, 40000));
		
		assertEquals("El profesor 5 no se está agregando correctamente", true, entidadEducativa.agregarProfesor("Alvaro", "885456432", "10/09/2006", "3136677542", Profesor.NIVEL_ACADEMICO_DOCTOR, 6, Profesor.TIEMPO_COMPLETO, 0));
		assertEquals("El profesor 6 se agregó (más de lo permitido)", false, entidadEducativa.agregarProfesor("Camilo", "8764236", "10/09/2011", "3185465757", Profesor.NIVEL_ACADEMICO_PROFESIONAL, 1, Profesor.TIEMPO_COMPLETO, 0));
	}

	@Test
	public void testBuscarCurso() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se está encontrando un curso que no existe", null, entidadEducativa.buscarCurso("Ingesoft"));
		
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		assertEquals("No se está encontrando un curso que existe", "Redes y Comunicaciones", entidadEducativa.buscarCurso("Redes y Comunicaciones").darNombre());
		assertEquals("No se está encontrando un curso que existe", "Bases de Datos", entidadEducativa.buscarCurso("Bases de Datos").darNombre());
		assertEquals("Se está encontrando un curso que no existe", null, entidadEducativa.buscarCurso("Agua y Vida"));
		assertEquals("No se está encontrando un curso que existe", "Ingesoft", entidadEducativa.buscarCurso("Ingesoft").darNombre());
	}

	@Test
	public void testBuscarProfesor() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se está encontrando un profesor que no existe", null, entidadEducativa.buscarProfesor("1234"));
		
		entidadEducativa = new EntidadEducativa();
		configurarProfesores();
		assertEquals("No se está encontrando un profesor que existe", "Angela", entidadEducativa.buscarProfesor("112342").darNombre());
		assertEquals("No se está encontrando un profesor que existe", "Alvaro", entidadEducativa.buscarProfesor("885456432").darNombre());
		assertEquals("Se está encontrando un profesor que no existe", null, entidadEducativa.buscarProfesor("4567"));
		assertEquals("No se está encontrando un profesor que existe", "David", entidadEducativa.buscarProfesor("2353475").darNombre());
	}

	@Test
	public void testValorPromedioProfesoresHoraCatedraCursoMiercoles() {
		entidadEducativa = new EntidadEducativa();
		assertEquals(0, entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles(), 0);
	
		setupEscenario1();
		assertEquals(0, entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles(), 0);
		
		setupEscenario2();
		assertEquals(30000, entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles(), 0);
		
		setupEscenario3();
		assertEquals(40000, entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles(), 0);
		
		setupEscenario4();
		assertEquals(0, entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles(), 0);
	}

	@Test
	public void testPorcentajeCursosDiurnos() {
		entidadEducativa = new EntidadEducativa();
		assertEquals(0, entidadEducativa.porcentajeCursosDiurnos()*100, 0);
		
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		assertEquals(57, entidadEducativa.porcentajeCursosDiurnos()*100, 1428);
		
		setupEscenario4();
		assertEquals(0, entidadEducativa.porcentajeCursosDiurnos()*100, 0);
	}

	@Test
	public void testProfesoresQueContienenInicialDiaActual() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se están identificando profesores que no existen", "", entidadEducativa.profesoresQueContienenInicialDiaActual());
		
		setupEscenario1();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
		Date fecha = new Date();
		String diaActual = sdf.format(fecha);
		char inicialDiaActual = diaActual.toLowerCase().charAt(0);
		
		switch (inicialDiaActual) {
		case 'l':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "Angela\nDaniel\nAlvaro\n", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		case 'm':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		case 'j':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		case 'v':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "David\nAlvaro\n", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		case 's':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		case 'd':
			assertEquals("Se están identificando profesores que no contienen la inicial del día actual", "David\nDaniel\n", entidadEducativa.profesoresQueContienenInicialDiaActual());
			break;
		}
		
	}

	@Test
	public void testDarNombreCursosConNombreConTotalDeLetrasPar() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se están identificando cursos que no existen", "", entidadEducativa.darNombreCursosConNombreConTotalDeLetrasPar());
		
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		assertEquals("No se están identificando los cursos con total de letras par correctamente", "Ingesoft\nRedes y Comunicaciones\nFisica\nBases de Datos\n", entidadEducativa.darNombreCursosConNombreConTotalDeLetrasPar());
		
		setupEscenario4();
		assertEquals("No se están identificando los cursos con total de letras par correctamente", "Redes y Comunicaciones\n", entidadEducativa.darNombreCursosConNombreConTotalDeLetrasPar());
	}

	@Test
	public void testDarCursoPorNumero() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(0));
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(3));
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(9));
		
		entidadEducativa = new EntidadEducativa();
		configurarCursos();
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(0));
		assertEquals("Se está identificando un curso que no existe", "Redes y Comunicaciones", entidadEducativa.darCursoPorNumero(3).darNombre());
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(9));
		assertEquals("Se está identificando un curso que no existe", "Bases de Datos", entidadEducativa.darCursoPorNumero(7).darNombre());
		assertEquals("Se está identificando un curso que no existe", "Ingesoft", entidadEducativa.darCursoPorNumero(1).darNombre());
		
		setupEscenario4();
		assertEquals("Se está identificando un curso que no existe", null, entidadEducativa.darCursoPorNumero(3));
		assertEquals("Se está identificando un curso que no existe", "Seguridad", entidadEducativa.darCursoPorNumero(2).darNombre());
		assertEquals("Se está identificando un curso que no existe", "Redes y Comunicaciones", entidadEducativa.darCursoPorNumero(1).darNombre());
	}

	@Test
	public void testDarTarifasProfesoresTiempoCompleto() {
		entidadEducativa = new EntidadEducativa();
		assertEquals("Se están calculando tarifas que no existen", "", entidadEducativa.darTarifasProfesoresTiempoCompleto());
		
		setupEscenario1();
		assertEquals("Se están calculando mal las tarifas de los profesores de tiempo completo", "Angela, Tarifa: $49000.0\nHugo, Tarifa: $96000.0\nAlvaro, Tarifa: $86000.0", entidadEducativa.darTarifasProfesoresTiempoCompleto());
		
		setupEscenario4();
		assertEquals("Se están calculando mal las tarifas de los profesores de tiempo completo", "Angela, Tarifa: $49000.0\nHugo, Tarifa: $96000.0", entidadEducativa.darTarifasProfesoresTiempoCompleto());
	}

}
