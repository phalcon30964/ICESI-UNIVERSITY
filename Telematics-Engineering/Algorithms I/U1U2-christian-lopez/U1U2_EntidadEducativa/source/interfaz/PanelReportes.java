package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.Curso;
import mundo.Profesor;

public class PanelReportes extends JPanel implements ActionListener{

	public static final String PROFESOR_MAS_CURSOS = "Profesor mas cursos";
	public static final String CURSO_MAS_DICTADO = "Curso mas dictado";
	public static final String PROFESOR_MAS_CREDITOS = "Profesor mas creditos";
	public static final String VALOR_PROMEDIO_HORA_CATEDRA_MIERCOLES = "Valor promedio hora catedra miercoles";
	public static final String PORCENTAJE_CURSOS_DIURNOS = "Porcentaje cursos diurnos";
	public static final String LISTA_PROFESORES_INICIAL_DIA_ACTUAL = "Listado profesores inicial dia actual";
	public static final String NOMBRE_CURSOS_LETRAS_PAR = "Nombre cursos letras par";
	public static final String TARIFAS_PROFESORES_TIEMPO_COMPLETO = "Tarifas profesores tiempo completo";
	
	private VentanaPrincipal principal;
	private JButton btn_profMasCursos;
	private JButton btn_cursoMasDictado;
	private JButton btn_profMasCreditos;
	private JButton btn_valorPromedioHoraCatedraMiercoles;
	private JButton btn_porcentajeCursosDiurnos;
	private JButton btn_listaProfInicialDiaActual;
	private JButton btn_nombreCursosLetrasPar;
	private JButton btn_profTiempoCompletoValores;
	private JTextField txt_profMasCursos;
	private JTextField txt_cursoMasDictado;
	private JTextField txt_profMasCreditos;
	private JTextField txt_valorPromedioHoraCatedraMiercoles;
	private JTextField txt_porcentajeCursosDiurnos;
	
	public PanelReportes(VentanaPrincipal principal){
		this.principal = principal;
		
		JPanel panelReportes = new JPanel();
		panelReportes.setLayout(new GridBagLayout());
		panelReportes.setBorder(new TitledBorder("Reportes"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel background=new JLabel(new ImageIcon("data/img/reportes.jpeg"));
		add(background);
		
		gbc.insets = new Insets(1, 5, 1, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		btn_profMasCursos = new JButton("Profesor que más dicta cursos");
		btn_profMasCursos.setActionCommand(PROFESOR_MAS_CURSOS);
		btn_profMasCursos.addActionListener(this);
		panelReportes.add(btn_profMasCursos, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		txt_profMasCursos = new JTextField(15);
		txt_profMasCursos.setEnabled(false);
		panelReportes.add(txt_profMasCursos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		btn_cursoMasDictado = new JButton("Curso más dictado");
		btn_cursoMasDictado.setActionCommand(CURSO_MAS_DICTADO);
		btn_cursoMasDictado.addActionListener(this);
		panelReportes.add(btn_cursoMasDictado, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txt_cursoMasDictado = new JTextField(15);
		txt_cursoMasDictado.setEnabled(false);
		panelReportes.add(txt_cursoMasDictado, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		btn_profMasCreditos = new JButton("Profesor que más créditos dicta");
		btn_profMasCreditos.setActionCommand(PROFESOR_MAS_CREDITOS);
		btn_profMasCreditos.addActionListener(this);
		panelReportes.add(btn_profMasCreditos, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		txt_profMasCreditos = new JTextField(15);
		txt_profMasCreditos.setEnabled(false);
		panelReportes.add(txt_profMasCreditos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		btn_valorPromedioHoraCatedraMiercoles = new JButton("Valor Promedio Hora Cátedra Miércoles");
		btn_valorPromedioHoraCatedraMiercoles.setActionCommand(VALOR_PROMEDIO_HORA_CATEDRA_MIERCOLES);
		btn_valorPromedioHoraCatedraMiercoles.addActionListener(this);
		panelReportes.add(btn_valorPromedioHoraCatedraMiercoles, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		txt_valorPromedioHoraCatedraMiercoles = new JTextField(15);
		txt_valorPromedioHoraCatedraMiercoles.setEnabled(false);
		panelReportes.add(txt_valorPromedioHoraCatedraMiercoles, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		btn_porcentajeCursosDiurnos = new JButton("Porcentaje de Cursos Diurnos");
		btn_porcentajeCursosDiurnos.setActionCommand(PORCENTAJE_CURSOS_DIURNOS);
		btn_porcentajeCursosDiurnos.addActionListener(this);
		panelReportes.add(btn_porcentajeCursosDiurnos, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		txt_porcentajeCursosDiurnos = new JTextField(15);
		txt_porcentajeCursosDiurnos.setEnabled(false);
		panelReportes.add(txt_porcentajeCursosDiurnos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		btn_listaProfInicialDiaActual = new JButton("Listado de profesores con inicial del día actual");
		btn_listaProfInicialDiaActual.setActionCommand(LISTA_PROFESORES_INICIAL_DIA_ACTUAL);
		btn_listaProfInicialDiaActual.addActionListener(this);
		panelReportes.add(btn_listaProfInicialDiaActual, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		btn_nombreCursosLetrasPar = new JButton("Listado de Cursos con total de letras par");
		btn_nombreCursosLetrasPar.setActionCommand(NOMBRE_CURSOS_LETRAS_PAR);
		btn_nombreCursosLetrasPar.addActionListener(this);
		panelReportes.add(btn_nombreCursosLetrasPar, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		btn_profTiempoCompletoValores = new JButton("Tarifas Profesores Tiempo Completo");
		btn_profTiempoCompletoValores.setActionCommand(TARIFAS_PROFESORES_TIEMPO_COMPLETO);
		btn_profTiempoCompletoValores.addActionListener(this);
		panelReportes.add(btn_profTiempoCompletoValores, gbc);
		
		panelReportes.setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		
		add(panelReportes);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{

			if(e.getActionCommand().equals(PROFESOR_MAS_CURSOS)){
				Profesor p = principal.darProfesorConMasCursosDictados();
				txt_profMasCursos.setText(p.toString());
			}
			if(e.getActionCommand().equals(CURSO_MAS_DICTADO)){
				Curso c = principal.darCursoMasDictado();
				txt_cursoMasDictado.setText(c.darNombre());
			}
			if(e.getActionCommand().equals(PROFESOR_MAS_CREDITOS)){
				Profesor p = principal.darProfesorConMasCreditosDados();
				txt_profMasCreditos.setText(p.toString());
			}
			if(e.getActionCommand().equals(VALOR_PROMEDIO_HORA_CATEDRA_MIERCOLES)){
				double v = principal.valorPromedioProfesoresHoraCatedraCursoMiercoles();
				txt_valorPromedioHoraCatedraMiercoles.setText("$"+v);
			}
			if(e.getActionCommand().equals(PORCENTAJE_CURSOS_DIURNOS)){
				double p = principal.porcentajeCursosDiurnos();
				txt_porcentajeCursosDiurnos.setText((p*100)+"%");
			}
			if(e.getActionCommand().equals(LISTA_PROFESORES_INICIAL_DIA_ACTUAL)){
				String lista = principal.profesoresQueContienenInicialDiaActual();
				JOptionPane.showMessageDialog(null, lista, "Listado", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getActionCommand().equals(NOMBRE_CURSOS_LETRAS_PAR)){
				String lista = principal.darNombreCursosConNombreConTotalDeLetrasPar();
				JOptionPane.showMessageDialog(null, lista, "Listado", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getActionCommand().equals(TARIFAS_PROFESORES_TIEMPO_COMPLETO)){
				String lista = principal.darTarifasProfesoresTiempoCompleto();
				JOptionPane.showMessageDialog(null, lista, "Tarifas Tiempo Completo", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e1){
			
		}
	}

}
