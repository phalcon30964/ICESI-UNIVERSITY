package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mundo.Profesor;

public class PanelListaCursosProfesor extends JPanel implements ActionListener{

	public static final String AGREGAR_CURSO_A_PROFESOR = "Agregar curso a profesor";
	public static final String CAMBIO_PROFESOR = "Cambio Profesor";
	
	private VentanaPrincipal principal;
	private DefaultListModel lst_cursos_dictados;
	private JButton btn_agregar;
	private JComboBox cmb_profesores;
	private JComboBox cmb_cursos;
	private JLabel lbl_profesores;
	private JLabel lbl_cursos;
	
	public PanelListaCursosProfesor (VentanaPrincipal principal){
		this.principal = principal;
		//setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		lst_cursos_dictados = new DefaultListModel();
		JList lst_cursos = new JList(lst_cursos_dictados);
		lst_cursos.setPreferredSize(new Dimension(200, 120));
		lst_cursos.setEnabled(false);
		lst_cursos.setBorder(new TitledBorder("Cursos dictados por el profesor seleccionado"));
		
		JLabel background=new JLabel(new ImageIcon("data/img/cursos_profesores.jpg"));
		add(background);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new GridBagLayout());
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new TitledBorder("Agregar Curso a Profesor"));
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		lbl_profesores = new JLabel("Profesores");
		panelDatos.add(lbl_profesores, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		cmb_profesores = new JComboBox();
		cmb_profesores.setActionCommand(CAMBIO_PROFESOR);
		cmb_profesores.addActionListener(this);
		panelDatos.add(cmb_profesores, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		lbl_cursos = new JLabel("Cursos");
		panelDatos.add(lbl_cursos, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		cmb_cursos = new JComboBox();
		panelDatos.add(cmb_cursos, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		btn_agregar = new JButton("Agregar curso a profesor");
		btn_agregar.setActionCommand(AGREGAR_CURSO_A_PROFESOR);
		btn_agregar.addActionListener(this);
		panelDatos.add(btn_agregar, gbc);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(panelDatos);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
//		gbc.gridwidth = 2;
		panel.add(lst_cursos, gbc);
		panel.add(panelDatos);
		
		setBackground(Color.WHITE);
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(AGREGAR_CURSO_A_PROFESOR)){
			try{
				String idProfesor = cmb_profesores.getSelectedItem().toString();
				String cedula = idProfesor.split("-")[1].trim();
				String nombreCurso = cmb_cursos.getSelectedItem().toString();
				principal.adicionarCursoAProfesor(cedula, nombreCurso);
				principal.actualizarPanelCursosProfesores();
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "Debe elegirse al menos un profesor y un curso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals(CAMBIO_PROFESOR)){
			principal.actualizarPanelCursosProfesores();
		}
	}

	public DefaultListModel darLst_cursos_dictados() {
		return lst_cursos_dictados;
	}

	public JButton darBtn_agregar() {
		return btn_agregar;
	}

	public JComboBox darCmb_profesores() {
		return cmb_profesores;
	}

	public JComboBox darCmb_cursos() {
		return cmb_cursos;
	}
}
