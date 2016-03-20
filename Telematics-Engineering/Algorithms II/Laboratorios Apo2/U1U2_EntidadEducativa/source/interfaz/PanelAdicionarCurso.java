package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import mundo.Curso;

public class PanelAdicionarCurso extends JPanel implements ActionListener{

	private VentanaPrincipal principal;
	private JLabel lbl_nombre;
	private JLabel lbl_creditos;
	private JLabel lbl_jornada;
	private JLabel lbl_diaSemana;
	private JLabel lbl_hora;
	private JTextField txt_nombre;
	private JTextField txt_creditos;
	private JComboBox cmb_jornada;
	private JComboBox cmb_diaSemana;
	private JTextField txt_hora;
	private JButton btn_adicionar;
	private JButton btn_cancelar;
	
	public PanelAdicionarCurso (VentanaPrincipal principal){
		this.principal = principal;
		
		JPanel panelAdicionarCurso = new JPanel();
		panelAdicionarCurso.setLayout(new GridBagLayout());
		panelAdicionarCurso.setBorder(new TitledBorder("Adicionar Curso"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel background=new JLabel(new ImageIcon("data/img/libros.jpg"));
		add(background);
		
		gbc.insets = new Insets(1, 5, 1, 5);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		lbl_nombre = new JLabel("Nombre");
		panelAdicionarCurso.add(lbl_nombre, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		txt_nombre = new JTextField(15);
		panelAdicionarCurso.add(txt_nombre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lbl_creditos = new JLabel("Créditos");
		panelAdicionarCurso.add(lbl_creditos, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txt_creditos = new JTextField(15);
		panelAdicionarCurso.add(txt_creditos, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lbl_jornada = new JLabel("Jornada");
		panelAdicionarCurso.add(lbl_jornada, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		cmb_jornada = new JComboBox();
		cmb_jornada.addItem(Curso.JORNADA_DIURNA);
		cmb_jornada.addItem(Curso.JORNADA_NOCTURNA);
		panelAdicionarCurso.add(cmb_jornada, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		lbl_diaSemana = new JLabel("Día Semana");
		panelAdicionarCurso.add(lbl_diaSemana, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		cmb_diaSemana = new JComboBox();
		cmb_diaSemana.addItem(Curso.LUNES);
		cmb_diaSemana.addItem(Curso.MARTES);
		cmb_diaSemana.addItem(Curso.MIERCOLES);
		cmb_diaSemana.addItem(Curso.JUEVES);
		cmb_diaSemana.addItem(Curso.VIERNES);
		cmb_diaSemana.addItem(Curso.SABADO);
		panelAdicionarCurso.add(cmb_diaSemana, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		lbl_hora = new JLabel("Hora Militar (HH:MM)");
		panelAdicionarCurso.add(lbl_hora, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		txt_hora = new JTextField(15);
		panelAdicionarCurso.add(txt_hora, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.setActionCommand(VentanaPrincipal.ADICIONAR);
		btn_adicionar.addActionListener(this);
		panelAdicionarCurso.add(btn_adicionar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setActionCommand(VentanaPrincipal.CANCELAR);
		btn_cancelar.addActionListener(this);
		panelAdicionarCurso.add(btn_cancelar, gbc);
		
		panelAdicionarCurso.setBackground(Color.WHITE);
		add(panelAdicionarCurso);
		setBackground(Color.WHITE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(VentanaPrincipal.ADICIONAR)){
			try{
				String nombre = txt_nombre.getText();
				int creditos = Integer.parseInt(txt_creditos.getText());
				String jornada = cmb_jornada.getSelectedItem().toString();
				String diaSemana = cmb_diaSemana.getSelectedItem().toString();
				String hora = txt_hora.getText();
				Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}");
				Matcher m = p.matcher(hora);
				
				if(m.find()){
					if(principal.adicionarCurso(nombre, creditos, jornada, diaSemana, hora))
						principal.actualizarPanelCursos();
					else
						JOptionPane.showMessageDialog(null, "El curso ya existe o no hay mas cupos disponibles", "Error", JOptionPane.ERROR_MESSAGE);
				
					clear();
				}else{
					JOptionPane.showMessageDialog(null, "Formato de Hora Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Datos incorrectos o vacíos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals(VentanaPrincipal.CANCELAR)){
			clear();
		}
	}
	
	public void clear(){
		txt_nombre.setText(null);
		txt_hora.setText(null);
		txt_creditos.setText(null);
	}

}
