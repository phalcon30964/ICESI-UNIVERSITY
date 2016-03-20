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

import mundo.Profesor;

public class PanelAdicionarProfesor extends JPanel implements ActionListener{

	private VentanaPrincipal principal;
	private JLabel lbl_nombre;
	private JLabel lbl_cedula;
	private JLabel lbl_fecha;
	private JLabel lbl_celular;
	private JLabel lbl_nivelAcademico;
	private JLabel lbl_cantidadPublicaciones;
	private JLabel lbl_tipoContrato;
	private JLabel lbl_valorHora;
	private JTextField txt_nombre;
	private JTextField txt_cedula;
	private JTextField txt_fecha;
	private JTextField txt_celular;
	private JTextField txt_valorHora;
	private JComboBox cmb_nivelAcademico;
	private JTextField txt_cantidadPublicaciones;
	private JComboBox cmb_tipoContrato;
	private JButton btn_adicionar;
	private JButton btn_cancelar;
	
	public PanelAdicionarProfesor (VentanaPrincipal principal){
		this.principal = principal;
		
		JPanel panelAdicionarProfesor = new JPanel();
		panelAdicionarProfesor.setLayout(new GridBagLayout());
		panelAdicionarProfesor.setBorder(new TitledBorder("Adicionar Profesor"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel background=new JLabel(new ImageIcon("data/img/profesor.jpg"));
		add(background);
		
		gbc.insets = new Insets(1, 5, 1, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		lbl_nombre = new JLabel("Nombre");
		panelAdicionarProfesor.add(lbl_nombre, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		txt_nombre = new JTextField(15);
		panelAdicionarProfesor.add(txt_nombre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lbl_cedula = new JLabel("Cédula");
		panelAdicionarProfesor.add(lbl_cedula, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txt_cedula = new JTextField(15);
		panelAdicionarProfesor.add(txt_cedula, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lbl_fecha = new JLabel("Fecha Vinculación (DD/MM/AAAA)");
		panelAdicionarProfesor.add(lbl_fecha, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		txt_fecha = new JTextField(15);
		panelAdicionarProfesor.add(txt_fecha, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		lbl_celular = new JLabel("Celular");
		panelAdicionarProfesor.add(lbl_celular, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		txt_celular = new JTextField(15);
		panelAdicionarProfesor.add(txt_celular, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		lbl_nivelAcademico =  new JLabel("Nivel Académico");
		panelAdicionarProfesor.add(lbl_nivelAcademico, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		cmb_nivelAcademico = new JComboBox();
		cmb_nivelAcademico.addItem(Profesor.NIVEL_ACADEMICO_PROFESIONAL);
		cmb_nivelAcademico.addItem(Profesor.NIVEL_ACADEMICO_MAGISTER);
		cmb_nivelAcademico.addItem(Profesor.NIVEL_ACADEMICO_DOCTOR);
		panelAdicionarProfesor.add(cmb_nivelAcademico, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		lbl_cantidadPublicaciones = new JLabel("Cantidad de Publicaciones");
		panelAdicionarProfesor.add(lbl_cantidadPublicaciones, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		txt_cantidadPublicaciones = new JTextField(15);
		panelAdicionarProfesor.add(txt_cantidadPublicaciones, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		lbl_tipoContrato =  new JLabel("Tipo Contrato");
		panelAdicionarProfesor.add(lbl_tipoContrato, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		cmb_tipoContrato = new JComboBox();
		cmb_tipoContrato.addItem(Profesor.HORA_CATEDRA);
		cmb_tipoContrato.addItem(Profesor.TIEMPO_COMPLETO);
		panelAdicionarProfesor.add(cmb_tipoContrato, gbc);
		cmb_tipoContrato.setActionCommand(Profesor.HORA_CATEDRA);
		cmb_tipoContrato.addActionListener(this);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		lbl_valorHora = new JLabel("Valor Hora Cátedra");
		panelAdicionarProfesor.add(lbl_valorHora, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		txt_valorHora = new JTextField(15);
		panelAdicionarProfesor.add(txt_valorHora, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.setActionCommand(VentanaPrincipal.ADICIONAR);
		btn_adicionar.addActionListener(this);
		panelAdicionarProfesor.add(btn_adicionar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setActionCommand(VentanaPrincipal.CANCELAR);
		btn_cancelar.addActionListener(this);
		panelAdicionarProfesor.add(btn_cancelar, gbc);
		
		panelAdicionarProfesor.setBackground(Color.WHITE);
		add(panelAdicionarProfesor);
		setBackground(Color.WHITE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(VentanaPrincipal.ADICIONAR)){
			try{
				String nombre = txt_nombre.getText();
				String cedula = txt_cedula.getText();
				String fecha = txt_fecha.getText();
				String celular = txt_celular.getText();
				String nivelAcademico = cmb_nivelAcademico.getSelectedItem().toString();
				int cantidadPublicaciones = Integer.parseInt(txt_cantidadPublicaciones.getText());
				String tipoContrato = cmb_tipoContrato.getSelectedItem().toString();
				double valorHora = 0;
				Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
				Matcher m = p.matcher(fecha);
				
				String valor = txt_valorHora.getText();
				if(valor!=null && !valor.equals(""))
					valorHora = Double.parseDouble(valor);
				
				if(m.find()){
					if(principal.adicionarProfesor(nombre, cedula, fecha, celular, nivelAcademico, cantidadPublicaciones, tipoContrato, valorHora))
						principal.actualizarPanelProfesores();
					else
						JOptionPane.showMessageDialog(null, "El profesor ya existe o no hay mas cupos disponibles", "Error", JOptionPane.ERROR_MESSAGE);
				
					clear();
				}else{
					JOptionPane.showMessageDialog(null, "Formato de Fecha Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Datos incorrectos o vacíos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals(VentanaPrincipal.CANCELAR)){
			clear();
		}
		if(e.getActionCommand().equals(Profesor.HORA_CATEDRA)){
			String text = cmb_tipoContrato.getSelectedItem().toString();
			if(text.equals(Profesor.HORA_CATEDRA)){
				lbl_valorHora.setVisible(true);
				txt_valorHora.setVisible(true);
			}else{
				lbl_valorHora.setVisible(false);
				txt_valorHora.setVisible(false);
			}
		}
	}
	
	public void clear(){
		txt_nombre.setText(null);
		txt_cedula.setText(null);
		txt_fecha.setText(null);
		txt_celular.setText(null);
		txt_cantidadPublicaciones.setText(null);
		txt_valorHora.setText(null);
	}

}
