package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.Curso;

public class PanelCursos extends JPanel implements ActionListener{
	
	public static final String BUSCAR_CURSO = "Buscar Curso";
	
	private VentanaPrincipal principal;
	private DefaultListModel lstm_cursos;
	private DefaultListModel lstm_cursos_dia;
	private JButton btn_buscarCurso;
	private JTextField txt_buscarCurso;
	private JLabel lbl_buscarCurso;
	
	public PanelCursos(VentanaPrincipal principal){
		this.principal = principal;
		
		JPanel panelListas = new JPanel();
		panelListas.setLayout(new GridBagLayout());
		
		JLabel background=new JLabel(new ImageIcon("data/img/cursos.png"));
		add(background);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
//		JLabel lbl_cursos = new JLabel("Todos los Cursos");
//		JLabel lbl_cursos_dia = new JLabel("Cursos Diurnos");
		
		lstm_cursos = new DefaultListModel();
		JList lst_cursos = new JList(lstm_cursos);
		lst_cursos.setPreferredSize(new Dimension(200, 150));
		lst_cursos.setEnabled(false);
		lst_cursos.setBorder(new TitledBorder("Todos los Cursos"));
		
		lstm_cursos_dia = new DefaultListModel();
		JList lst_cursos_dia = new JList(lstm_cursos_dia);
		lst_cursos_dia.setPreferredSize(new Dimension(200, 150));
		lst_cursos_dia.setEnabled(false);
		lst_cursos_dia.setBorder(new TitledBorder("Cursos Diurnos"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
//		panelListas.add(lbl_cursos, gbc);
		panelListas.add(lst_cursos, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
//		panelListas.add(lbl_cursos_dia, gbc);
		panelListas.add(lst_cursos_dia, gbc);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		panelListas.add(lst_cursos, gbc);
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		panelListas.add(lst_cursos_dia, gbc);
		
		JPanel panelBuscarCurso = new JPanel();
		panelBuscarCurso.setLayout(new GridBagLayout());
		panelBuscarCurso.setBorder(new TitledBorder("Buscar Curso"));
		panelBuscarCurso.setBackground(Color.WHITE);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lbl_buscarCurso = new JLabel("Nombre del Curso");
		panelBuscarCurso.add(lbl_buscarCurso, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		txt_buscarCurso = new JTextField(15);
		panelBuscarCurso.add(txt_buscarCurso, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.fill =GridBagConstraints.BOTH;
		btn_buscarCurso = new JButton("Dar Atributos del Curso");
		btn_buscarCurso.setActionCommand(BUSCAR_CURSO);
		btn_buscarCurso.addActionListener(this);
		panelBuscarCurso.add(btn_buscarCurso, gbc);
		
		gbc.fill =GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panelListas.add(panelBuscarCurso, gbc);
		
		panelListas.setBackground(Color.WHITE);
		add(panelListas);
		setBackground(Color.WHITE);
	}

	public DefaultListModel darLstm_cursos() {
		return lstm_cursos;
	}

	public DefaultListModel darLstm_cursos_dia() {
		return lstm_cursos_dia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(BUSCAR_CURSO)){
			try{
				String nombre = txt_buscarCurso.getText();
				Curso c = principal.buscarCurso(nombre);
				JOptionPane.showMessageDialog(null, "Nombre: "+c.darNombre()+"\n"+
				"Créditos: "+c.darCreditos()+"\nDía Semana: "+c.darDiaSemana()+"\n"+
						"Jornada: "+c.darJornada()+"\nHora: "+c.darHora(), "Información del Curso", JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Nombre incorrecto o vacío", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
}
