package test;

import static org.junit.Assert.*;

import mundo.Curso;
import mundo.Profesor;
import org.junit.Test;

public class ProfesorTest {

	private Profesor profesor;
	private Curso curso1;
	private Curso curso2;
	private Curso curso3;
	private Curso curso4;
	
	String mensaje="";
	
	public void setupEscenario1(){
		profesor = new Profesor("Angela", "112342", "10/01/2008", "3144322156", Profesor.NIVEL_ACADEMICO_MAGISTER, 2, Profesor.TIEMPO_COMPLETO);	
	}
	
	public void setupEscenario2(){
		profesor = new Profesor("Hugo", "43355734", "10/09/2005", "3132123567", Profesor.NIVEL_ACADEMICO_DOCTOR, 10, Profesor.TIEMPO_COMPLETO);	
		configurarCursos();
	}
	
	public void setupEscenario3(){
		profesor = new Profesor("David", "2353475", "10/09/2008", "3152961268", Profesor.NIVEL_ACADEMICO_PROFESIONAL, 1, Profesor.HORA_CATEDRA);	
		configurarCursos();
		agregarCursos();
	}
	
	private void agregarCursos() {
		profesor.agregarCurso(curso1);
		profesor.agregarCurso(curso2);
		profesor.agregarCurso(curso3);
	}

	public void configurarCursos(){
		curso1 = new Curso("Ingesoft", 3, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "16:00");
		curso2 = new Curso("Algoritmos I", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "08:00");
		curso3 = new Curso("Redes y Comunicaciones", 4, Curso.JORNADA_DIURNA, Curso.VIERNES, "14:00");
		curso4 = new Curso("Seguridad", 3, Curso.JORNADA_DIURNA, Curso.MARTES, "14:00");
	}

	@Test
	public void testProfesor() {
		setupEscenario1();
		assertEquals("El nombre no está siendo asignado correctamente", "Angela", profesor.darNombre());
		assertEquals("La cédula no está siendo asignada correctamente", "112342", profesor.darCedula());
		assertEquals("La fecha de vinculación no está siendo asignada correctamente", "10/01/2008", profesor.darFechaVinculacion());
		assertEquals("El celular no está siendo asignado correctamente", "3144322156", profesor.darCelular());
		assertEquals("El nivel académico del profesor no está siendo asignada correctamente", Profesor.NIVEL_ACADEMICO_MAGISTER, profesor.darNivelAcademico());
		assertEquals("La cantidad de publicaciones no está siendo asignada correctamente", 2, profesor.darCantidadPublicaciones());
		assertEquals("El tipo de contrato no está siendo asignado correctamente", Profesor.TIEMPO_COMPLETO, profesor.darTipoContrato());	
	}

	@Test
	public void testDarCursosDictados() {
		setupEscenario3();
		assertEquals("No se están dando los nombres de los cursos dictados en el formato correcto", "Ingesoft,Algoritmos I,Redes y Comunicaciones,", profesor.darCursosDictados());
	}

	@Test
	public void testDarTotalCreditosDados() {
		setupEscenario3();
		assertEquals("No se está retornando el número correcto de créditos dictados", 10, profesor.darTotalCreditosDados());
	}

	@Test
	public void testDarTotalCursosDictados() {
		setupEscenario3();
		assertEquals("No se está retornando el número correcto de cursos dictados", 3, profesor.darTotalCursosDictados());
	}

	@Test
	public void testAgregarCurso() {
		setupEscenario2();
		assertEquals("El curso 1 no se está agregando correctamente", true, profesor.agregarCurso(curso1));
		assertEquals("Se agregó el curso 1 repetido al profesor", false, profesor.agregarCurso(curso1));
		assertEquals("El curso 2 no se está agregando correctamente", true, profesor.agregarCurso(curso2));
		assertEquals("El curso 3 no se está agregando correctamente", true, profesor.agregarCurso(curso3));
		assertEquals("Se agregó un curso más al profesor, no debe tener capacidad", false, profesor.agregarCurso(curso4));
	}

	@Test
	public void testToString() {
		setupEscenario1();
		assertEquals("El método toString no retorna lo que se espera", "Angela-112342", profesor.toString());
		
		setupEscenario2();
		assertEquals("El método toString no retorna lo que se espera", "Hugo-43355734", profesor.toString());
		
		setupEscenario3();
		assertEquals("El método toString no retorna lo que se espera", "David-2353475", profesor.toString());
	}

	@Test
	public void testCalcularTarifaHoraTiempoCompleto() {
		setupEscenario1();
		assertEquals(49000, profesor.calcularTarifaHoraTiempoCompleto(), 0);
		
		setupEscenario2();
		assertEquals(96000, profesor.calcularTarifaHoraTiempoCompleto(), 0);
		
		setupEscenario3();
		assertEquals(30000, profesor.calcularTarifaHoraTiempoCompleto(), 0);
	}

}
