package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class PanelEntrada extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazConvertidor principal;
	private JLabel labCent;
	private JTextField txtCent;
	private JButton butConvertir;
	
	public final static String CONVERTIDOR = "convertir";
	
	public PanelEntrada(InterfazConvertidor i){
		
		principal = i;
		
		labCent = new JLabel("   C:   ");
		txtCent = new JTextField();
		butConvertir = new JButton("Convertir");
		
		butConvertir.setActionCommand(CONVERTIDOR);
		butConvertir.addActionListener(this);
		
		setBorder(new TitledBorder("Entrada"));
		
		setLayout(new BorderLayout());
		
		add(labCent, BorderLayout.WEST);
		add(txtCent, BorderLayout.CENTER);
		add(butConvertir, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String temp = event.getActionCommand();

		if(temp.equals(CONVERTIDOR)){
			
			String m = txtCent.getText();
			double r = Double.parseDouble(m);
			principal.gestionarConversion(r);
		}
		
	}

}
