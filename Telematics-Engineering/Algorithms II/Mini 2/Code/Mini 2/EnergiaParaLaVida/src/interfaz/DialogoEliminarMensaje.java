package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mundo.Dia;
import mundo.EnergiaParaLaVida;
import mundo.Mensaje;

public class DialogoEliminarMensaje extends JDialog implements ActionListener, ItemListener{

	private InterfazEnergiaParaLaVida principal;
	private JButton btnEliminarMensaje;
	private JComboBox<Dia> comboDia;
	private JComboBox<Mensaje>comboMensaje;
	private JLabel labDia;
	private JLabel labMensaje;
	
	private final static String ELIMINAR_MENSAJE="1";
	private final static String COMBO_DIA_CAMBIO_ESTADO="1";
	
	
	public DialogoEliminarMensaje(InterfazEnergiaParaLaVida ventana){
		
		super(ventana,true);
		
		principal = ventana;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Eliminar Mensaje");
		setPreferredSize(new Dimension(400,140));

		
		JPanel panelInterno = new JPanel();
		panelInterno.setLayout(new GridLayout(2,2));
		
		
		btnEliminarMensaje = new JButton();
		btnEliminarMensaje.setText("Eliminar mensaje");
		btnEliminarMensaje.setActionCommand(ELIMINAR_MENSAJE);
		btnEliminarMensaje.addActionListener(this);

		
		comboDia = new JComboBox<Dia>();
		comboDia.setActionCommand(COMBO_DIA_CAMBIO_ESTADO);
		comboDia.addItemListener(this);
		
		comboMensaje = new JComboBox<Mensaje>();
		labDia = new JLabel("Dia");
		labMensaje = new JLabel("Mensaje");
		
		
		panelInterno.add(labDia);
		panelInterno.add(comboDia);
		panelInterno.add(labMensaje);
		panelInterno.add(comboMensaje);
		
		add(panelInterno,BorderLayout.CENTER);
		add(btnEliminarMensaje,BorderLayout.SOUTH);
	
		pack();
		refrescarComboDia();
	}
	
	public void refrescarComboDia(){
		comboDia.removeAllItems();
		
		ArrayList<Dia> list = (ArrayList<Dia>) principal.mundo.darListaDias();
		
		for (int i = 0; i < list.size(); i++) {
			comboDia.addItem((Dia)list.get(i));
		}
	}
	
	
	public void refrescarComboMensaje(){
		
		comboMensaje.removeAllItems();
		
		ArrayList<Mensaje> list = (ArrayList<Mensaje>) ((Dia)comboDia.getSelectedItem()).darListaMensajes();
		
		for (int i = 0; i < list.size(); i++) {
			comboMensaje.addItem((Mensaje)list.get(i));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if((Dia)comboDia.getSelectedItem()!=null && (Mensaje)comboMensaje.getSelectedItem()!=null){
				
			String dia = ((Dia)comboDia.getSelectedItem()).darFecha();
			String msj = ((Mensaje)comboMensaje.getSelectedItem()).darMsjMotivacion();
			
			//Elimina
			principal.mundo.eliminarMensajeADia(dia, msj);
			
			//refresca interfaz
			refrescarComboMensaje();
			principal.refrescarComboBoxDia();
			principal.refrescarPanelMensajesMotivaciones((Dia)(principal.comboBoxDia.getSelectedItem()));
			principal.serializar();
			
			}else{
				JOptionPane.showMessageDialog(this, "No hay mensajes para eliminar");
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(this, e1.getMessage());

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		refrescarComboMensaje();
	}
	
	public void dispose(){
		principal.refrescarComboBoxDia();
		principal.serializar();
		super.dispose( );
	}
	

}
