package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import mundo.Dia;

public class DialogoCrearMensaje extends JDialog implements ActionListener {
	
	//Constantes
	
	private final static String AGREGARMSJ = "1";
	private final static String CANCELAR = "2";
	
	//Atributos
	private JComboBox<Dia> combo;
	private JTextField txtMensaje;
	private JTextField txtAutor;
	private JButton butAgregar;
	private JButton butCancelar;
	private JLabel labCombo;
	private JLabel labMensaje;
	private JLabel labAutor;
	
	//relacion a la interfaz
	
	private InterfazEnergiaParaLaVida principal;
	
	//Constructor
	public DialogoCrearMensaje(InterfazEnergiaParaLaVida ventana){
		
		super(ventana,true);
		principal = ventana;
		setLayout(new BorderLayout());
		setTitle("Escoja un dia e ingrese mensaje");
		setPreferredSize(new Dimension(400,160));
		
		//Creacion del panel interno
		JPanel panelInterno = new JPanel();
		panelInterno.setBorder(new TitledBorder("Agregar mensaje"));
		panelInterno.setLayout(new GridLayout(3,2));
		
		JPanel panelInterno2 = new JPanel();
		panelInterno2.setLayout(new GridLayout(1,1));
		
		
		//Inicializacion de los atributos
		
		combo = new JComboBox<Dia>();
		txtMensaje = new JTextField();
		txtAutor = new JTextField();
		butAgregar = new JButton();
		butAgregar.setText("Agregar");
		butAgregar.setActionCommand(AGREGARMSJ);
		butAgregar.addActionListener(this);
		
		butCancelar = new JButton();
		butCancelar.setText("Cancelar");
		butCancelar.addActionListener(this);
		butCancelar.setActionCommand(CANCELAR);
		
		labCombo = new JLabel("Dia");
		labMensaje = new JLabel("Mensaje");
		labAutor  = new JLabel("Autor");
		
		
		//Los agrego al panel interno
		panelInterno.add(labCombo);
		panelInterno.add(combo);
		panelInterno.add(labMensaje);
		panelInterno.add(txtMensaje);
		panelInterno.add(labAutor);
		panelInterno.add(txtAutor);
		panelInterno2.add(butAgregar);
		panelInterno2.add(butCancelar);
		
		
		add(panelInterno,BorderLayout.CENTER);
		add(panelInterno2,BorderLayout.SOUTH);
		
		
		pack();
		refrescarCombo();
		
	}
	
	public void refrescarCombo(){
		
		combo.removeAllItems();
		
		ArrayList<Dia> list = (ArrayList<Dia>) principal.mundo.darListaDias();
		
		for (int i = 0; i < list.size(); i++) {
			combo.addItem((Dia)list.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	if(AGREGARMSJ.equals(e.getActionCommand()) ){
		
		
		if(txtMensaje.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Introduzca un mensaje");

		}else if(txtAutor.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Introduzca un autor");
			
		}else{
		
			Dia dia = (Dia)combo.getSelectedItem();
			
			String fecha = dia.darFecha();
			String autor = txtAutor.getText();
			String mensaje = txtMensaje.getText();
		
			try {
				principal.mundo.agregarMensajeADia(fecha, autor , mensaje );
				JOptionPane.showMessageDialog(this, "Se agrego mensaje exitosamente");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
		
			}
			
			txtAutor.setText("");
			txtMensaje.setText("");
			
			//refresco interfaz
			principal.refrescarPanelMensajesMotivaciones(principal.mundo.darDiaFechaMasCerca());
			principal.refrescarComboBoxDia();
			principal.serializar();
		
		}
	
	}else if(CANCELAR.equals(e.getActionCommand())){
		dispose();
	}
		
}
	


}
