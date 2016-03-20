package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import mundo.Curso;
import mundo.EntidadEducativa;
import mundo.Profesor;

public class VentanaPrincipal extends JFrame{
	
	public static final String ADICIONAR = "Adicionar";
	public static final String CANCELAR = "Cancelar";
	public PanelCursos panelCursos;
	public PanelProfesores panelProfesores;
	public PanelReportes panelReportes;
	public PanelAdicionarCurso panelAdicionarCursos;
	public PanelAdicionarProfesor panelAdicionarProfesores;
	public static EntidadEducativa entidadEducativa;
	public PanelListaCursosProfesor panelListaCursosProfesor;

	public VentanaPrincipal(){
		setTitle("Entidad Educativa");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		entidadEducativa = new EntidadEducativa();
		
		JLabel background=new JLabel(new ImageIcon("data/img/titulo.png"));
		add(background, BorderLayout.NORTH);
		
		JTabbedPane tabs = new JTabbedPane();
		add(tabs,BorderLayout.CENTER);
		
		panelCursos = new PanelCursos(this);		
		panelProfesores = new PanelProfesores();
		panelReportes = new PanelReportes(this);
		panelAdicionarCursos = new PanelAdicionarCurso(this);
		panelAdicionarProfesores = new PanelAdicionarProfesor(this);
		panelListaCursosProfesor = new PanelListaCursosProfesor(this);		
		
		tabs.addTab("Adicionar Curso",null,panelAdicionarCursos,"Adicionar Curso");
		tabs.addTab("Adicionar Profesor",null,panelAdicionarProfesores,"Adicionar Profesor");
		tabs.addTab("Agregar Cursos a Profesor",null,panelListaCursosProfesor,"Agregar Cursos a Profesor");
		tabs.addTab("Cursos",null,panelCursos,"Cursos");
		tabs.addTab("Profesores",null,panelProfesores,"Profesores");
		tabs.addTab("Reportes",null,panelReportes,"Reportes");
		
		pack();
		
//		setSize(490, 560);
		setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();		
	}
	
	public Profesor darProfesorConMasCursosDictados(){
		return entidadEducativa.darProfesorConMasCursosDictados();
	}
	
	public Curso darCursoMasDictado(){
		return entidadEducativa.darCursoMasDictado();
	}
	
	public Profesor darProfesorConMasCreditosDados(){
		return entidadEducativa.darProfesorConMasCreditosDados();
	}
	
	public boolean adicionarCurso(String nombre, int creditos, String jornada, String diaSemana, String hora){
		return entidadEducativa.agregarCurso(nombre, creditos, jornada, diaSemana, hora);
	}
	
	public boolean adicionarProfesor(String nombre, String cedula, String fechaVinculacion, String celular, String nivelAcademico, int cantidadPublicaciones, String tipoContrato, double valorHora){
		return entidadEducativa.agregarProfesor(nombre, cedula, fechaVinculacion, celular, nivelAcademico, cantidadPublicaciones, tipoContrato, valorHora);
	}
	
	public Curso buscarCurso(String nombre){
		return entidadEducativa.buscarCurso(nombre);
	}
	
	public Profesor buscarProfesor(String cedula){
		return entidadEducativa.buscarProfesor(cedula);
	}
	
	public double valorPromedioProfesoresHoraCatedraCursoMiercoles(){
		return entidadEducativa.valorPromedioProfesoresHoraCatedraCursoMiercoles();
	}
	
	public double porcentajeCursosDiurnos(){
		return entidadEducativa.porcentajeCursosDiurnos();
	}
	
	public String profesoresQueContienenInicialDiaActual(){
		return entidadEducativa.profesoresQueContienenInicialDiaActual();
	}
	
	public String darNombreCursosConNombreConTotalDeLetrasPar(){
		return entidadEducativa.darNombreCursosConNombreConTotalDeLetrasPar();
	}
	
	public Curso darCursoPorNumero(int n){
		return entidadEducativa.darCursoPorNumero(n);
	}
	
	public String darTarifasProfesoresTiempoCompleto(){
		return entidadEducativa.darTarifasProfesoresTiempoCompleto();
	}
	
	public void actualizarPanelCursos(){
		panelCursos.darLstm_cursos().clear();
		panelCursos.darLstm_cursos_dia().clear();
		int size = panelListaCursosProfesor.darCmb_cursos().getItemCount();
		
		Curso curso1 = entidadEducativa.darCurso1();
		if(curso1 != null){
			panelCursos.darLstm_cursos().addElement(curso1.toString());
			if(size == 0)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso1.darNombre());
		}
		if(curso1 != null && curso1.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso1);
		
		Curso curso2 = entidadEducativa.darCurso2();
		if(curso2 != null){
			panelCursos.darLstm_cursos().addElement(curso2.toString());
			if(size == 1)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso2.darNombre());
		}
		if(curso2 != null && curso2.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso2);
		
		Curso curso3 = entidadEducativa.darCurso3();
		if(curso3 != null){
			panelCursos.darLstm_cursos().addElement(curso3.toString());
			if(size == 2)	
				panelListaCursosProfesor.darCmb_cursos().addItem(curso3.darNombre());
		}
		if(curso3 != null && curso3.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso3);
		
		Curso curso4 = entidadEducativa.darCurso4();
		if(curso4 != null){
			panelCursos.darLstm_cursos().addElement(curso4.toString());
			if(size == 3)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso4.darNombre());
		}
		if(curso4 != null && curso4.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso4);
		
		Curso curso5 = entidadEducativa.darCurso5();
		if(curso5 != null){
			panelCursos.darLstm_cursos().addElement(curso5.toString());
			if(size == 4)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso5.darNombre());
		}
		if(curso5 != null && curso5.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso5);
		
		Curso curso6 = entidadEducativa.darCurso6();
		if(curso6 != null){
			panelCursos.darLstm_cursos().addElement(curso6.toString());
			if(size == 5)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso6.darNombre());
		}
		if(curso6 != null && curso6.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso6);
		
		Curso curso7 = entidadEducativa.darCurso7();
		if(curso7 != null){
			panelCursos.darLstm_cursos().addElement(curso7.toString());
			if(size == 6)
				panelListaCursosProfesor.darCmb_cursos().addItem(curso7.darNombre());
		}
		if(curso7 != null && curso7.darJornada().equals(Curso.JORNADA_DIURNA))
			panelCursos.darLstm_cursos_dia().addElement(curso7);
	}
	
	public void actualizarPanelProfesores(){
		panelProfesores.darLstm_prof_tcompleto().clear();
		panelProfesores.darLstm_profesores().clear();
		int size = panelListaCursosProfesor.darCmb_profesores().getItemCount();
		
		Profesor prof1 = entidadEducativa.darProfesor1();
		if(prof1 != null){
			panelProfesores.darLstm_profesores().addElement(prof1.toString());
			if(size == 0)
				panelListaCursosProfesor.darCmb_profesores().addItem(prof1.toString());
		}
		if(prof1 != null && prof1.darTipoContrato().equals(Profesor.TIEMPO_COMPLETO))
			panelProfesores.darLstm_prof_tcompleto().addElement(prof1.toString());
		
		Profesor prof2 = entidadEducativa.darProfesor2();
		if(prof2 != null){
			panelProfesores.darLstm_profesores().addElement(prof2.toString());
			if(size == 1)
				panelListaCursosProfesor.darCmb_profesores().addItem(prof2.toString());
		}
		if(prof2 != null && prof2.darTipoContrato().equals(Profesor.TIEMPO_COMPLETO))
			panelProfesores.darLstm_prof_tcompleto().addElement(prof2.toString());
		
		Profesor prof3 = entidadEducativa.darProfesor3();
		if(prof3 != null){
			panelProfesores.darLstm_profesores().addElement(prof3.toString());
			if(size == 2)
				panelListaCursosProfesor.darCmb_profesores().addItem(prof3.toString());
		}
		if(prof3 != null && prof3.darTipoContrato().equals(Profesor.TIEMPO_COMPLETO))
			panelProfesores.darLstm_prof_tcompleto().addElement(prof3.toString());
		
		Profesor prof4 = entidadEducativa.darProfesor4();
		if(prof4 != null){
			panelProfesores.darLstm_profesores().addElement(prof4.toString());
			if(size == 3)
				panelListaCursosProfesor.darCmb_profesores().addItem(prof4.toString());
		}
		if(prof4 != null && prof4.darTipoContrato().equals(Profesor.TIEMPO_COMPLETO))
			panelProfesores.darLstm_prof_tcompleto().addElement(prof4.toString());
		
		Profesor prof5 = entidadEducativa.darProfesor5();
		if(prof5 != null){
			panelProfesores.darLstm_profesores().addElement(prof5.toString());
			if(size == 4)
				panelListaCursosProfesor.darCmb_profesores().addItem(prof5.toString());
		}
		if(prof5 != null && prof5.darTipoContrato().equals(Profesor.TIEMPO_COMPLETO))
			panelProfesores.darLstm_prof_tcompleto().addElement(prof5.toString());
	}

	public void actualizarPanelCursosProfesores() {
		panelListaCursosProfesor.darLst_cursos_dictados().clear();
		String idProfesor = panelListaCursosProfesor.darCmb_profesores().getSelectedItem().toString();
		Profesor p = buscarProfesor(idProfesor.split("-")[1].trim());
		String[] cursosDictados = p.darCursosDictados().split(",");
		
		for (String curso : cursosDictados) {
			panelListaCursosProfesor.darLst_cursos_dictados().addElement(curso);
		}
	}

	public void adicionarCursoAProfesor(String cedula, String nombreCurso) {
		Profesor p = buscarProfesor(cedula);
		p.agregarCurso(buscarCurso(nombreCurso));
	}
}
