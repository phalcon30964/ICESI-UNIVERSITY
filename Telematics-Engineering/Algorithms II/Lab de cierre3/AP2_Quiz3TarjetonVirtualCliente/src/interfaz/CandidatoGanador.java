package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class CandidatoGanador extends JPanel implements ActionListener {

	/**
	 * @param args
	 */
	
	private JLabel lbClave;
	private JTextField txtClave;
	private JButton bnClave;
	private InterfazUrnaVotacion principal;
	
	public CandidatoGanador(InterfazUrnaVotacion i){
		
		principal = i;
		
		setBorder(new TitledBorder("Candidato Ganador"));
		setLayout(new GridLayout(1,3));
		
		lbClave = new JLabel("Clave de seguridad");
		txtClave = new JTextField();
		bnClave = new JButton("Consultar");
		bnClave.setActionCommand("Consultar");
		bnClave.addActionListener(this);
		
		add(lbClave);
		add(txtClave);
		add(bnClave);

	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this, principal.consultarGanador(txtClave.getText()));
		
		
	}

}
