package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelProfesores extends JPanel{

	private DefaultListModel lstm_profesores;
	private DefaultListModel lstm_prof_tcompleto;
	
	public PanelProfesores(){
		
		JPanel panelListas = new JPanel();
		panelListas.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel background=new JLabel(new ImageIcon("data/img/profesores.jpg"));
		add(background);
		gbc.insets = new Insets(1, 5, 1, 5);
		
		lstm_profesores = new DefaultListModel();
		JList lst_profesores = new JList(lstm_profesores);
		lst_profesores.setPreferredSize(new Dimension(200, 150));
		lst_profesores.setEnabled(false);
		lst_profesores.setBorder(new TitledBorder("Todos los Profesores"));
		
		lstm_prof_tcompleto = new DefaultListModel();
		JList lst_prof_tcompleto = new JList(lstm_prof_tcompleto);
		lst_prof_tcompleto.setPreferredSize(new Dimension(200, 150));
		lst_prof_tcompleto.setEnabled(false);
		lst_prof_tcompleto.setBorder(new TitledBorder("Profesores Tiempo Completo"));
		
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		panelListas.add(lbl_profesores, gbc);
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		panelListas.add(lbl_prof_tcompleto, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelListas.add(lst_profesores, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelListas.add(lst_prof_tcompleto, gbc);
		panelListas.setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		add(panelListas);
	}

	public DefaultListModel darLstm_profesores() {
		return lstm_profesores;
	}

	public DefaultListModel darLstm_prof_tcompleto() {
		return lstm_prof_tcompleto;
	}
	
	
}
