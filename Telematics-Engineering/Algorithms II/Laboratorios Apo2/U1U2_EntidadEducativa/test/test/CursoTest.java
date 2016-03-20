package test;

import static org.junit.Assert.*;

import mundo.Curso;

import org.junit.Test;

public class CursoTest {

	private Curso curso;
	
	public void setupEscenario1(){
		curso = new Curso("Ingesoft", 3, Curso.JORNADA_DIURNA, Curso.MIERCOLES, "16:00");
	}
	
	public void setupEscenario2(){
		curso = new Curso("Algoritmos I", 3, Curso.JORNADA_DIURNA, Curso.LUNES, "08:00");
	}
	
	public void setupEscenario3(){
		curso = new Curso("Redes y Comunicaciones", 4, Curso.JORNADA_DIURNA, Curso.VIERNES, "14:00");
	}
	
	@Test
	public void testCurso() {
		setupEscenario1();
		assertEquals("El nombre no está siendo asignado correctamente", "Ingesoft", curso.darNombre());
		assertEquals("Los créditos del país no están siendo asignados correctamente", 3, curso.darCreditos());
		assertEquals("La jornada está no siendo asignada correctamente", Curso.JORNADA_DIURNA, curso.darJornada());
		assertEquals("El día de la semana no está siendo asignado correctamente", Curso.MIERCOLES, curso.darDiaSemana());
		assertEquals("La hora no está siendo asignada correctamente", "16:00", curso.darHora());
		
		setupEscenario2();
		assertEquals("El nombre no está siendo asignado correctamente", "Algoritmos I", curso.darNombre());
		assertEquals("Los créditos del país no están siendo asignados correctamente", 3, curso.darCreditos());
		assertEquals("La jornada está no siendo asignada correctamente", Curso.JORNADA_DIURNA, curso.darJornada());
		assertEquals("El día de la semana no está siendo asignado correctamente", Curso.LUNES, curso.darDiaSemana());
		assertEquals("La hora no está siendo asignada correctamente", "08:00", curso.darHora());
		
		setupEscenario3();
		assertEquals("El nombre no está siendo asignado correctamente", "Redes y Comunicaciones", curso.darNombre());
		assertEquals("Los créditos del país no están siendo asignados correctamente", 4, curso.darCreditos());
		assertEquals("La jornada está no siendo asignada correctamente", Curso.JORNADA_DIURNA, curso.darJornada());
		assertEquals("El día de la semana no está siendo asignado correctamente", Curso.VIERNES, curso.darDiaSemana());
		assertEquals("La hora no está siendo asignada correctamente", "14:00", curso.darHora());
	}

	@Test
	public void testToString() {
		setupEscenario1();
		assertEquals("El método toString no retorna lo que se espera", "Ingesoft", curso.toString());
		
		setupEscenario2();
		assertEquals("El método toString no retorna lo que se espera", "Algoritmos I", curso.toString());
		
		setupEscenario3();
		assertEquals("El método toString no retorna lo que se espera", "Redes y Comunicaciones", curso.toString());
	}

}
