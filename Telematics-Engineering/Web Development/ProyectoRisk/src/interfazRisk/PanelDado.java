package interfazRisk;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import TadLista.ListaDoble;
import TadLista.ListaOrdenada;



public class PanelDado extends JFrame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelDado() {
		getContentPane().setBackground(Color.GREEN);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(500, 200);
		
		final JLabel DadoAtacante1 = new JLabel("");
		DadoAtacante1.setBackground(Color.CYAN);
		DadoAtacante1.setBounds(31, 34, 63, 31);
		ImageIcon img3 = new ImageIcon(".\\data\\6R.png");
		Icon icono3 = new ImageIcon( img3.getImage().getScaledInstance(DadoAtacante1.getWidth(), DadoAtacante1.getHeight(), Image.SCALE_DEFAULT));
		DadoAtacante1.setIcon(icono3);
		getContentPane().add(DadoAtacante1);
		
		JLabel DadoAtacante2 = new JLabel("");
		DadoAtacante2.setBounds(31, 76, 63, 31);
		getContentPane().add(DadoAtacante2);
		DadoAtacante2.setIcon(icono3);
		
		JLabel DadoAtacante3 = new JLabel("");
		DadoAtacante3.setBounds(31, 118, 63, 31);
		getContentPane().add(DadoAtacante3);
		DadoAtacante3.setIcon(icono3);
		
//		JLabel ImgResultado = new JLabel("");
//		ImgResultado.setBounds(161, 118, 63, 30);
//		ImgResultado.setIcon(icono3);
//		getContentPane().add(ImgResultado);
		
		JLabel DadoDefensor1 = new JLabel("");
		DadoDefensor1.setBounds(264, 34, 63, 31);
		getContentPane().add(DadoDefensor1);
		DadoDefensor1.setIcon(icono3);
		
		JLabel DadoDefensor2 = new JLabel("");
		DadoDefensor2.setBounds(264, 87, 63, 31);
		getContentPane().add(DadoDefensor2);
		DadoDefensor2.setIcon(icono3);
		
		JLabel DadoDefensor3 = new JLabel("");
		DadoDefensor3.setBounds(264, 135, 63, 31);
		getContentPane().add(DadoDefensor3);
		DadoDefensor3.setIcon(icono3);
		
		final JLabel[] ImgResultado = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			ImgResultado[i] = new JLabel();
		}
		ImgResultado[0].setBounds(161, 34, 63, 31);
		add(ImgResultado[0]);
		ImgResultado[1].setBounds(161, 76, 63, 31);
		add(ImgResultado[1]);
		ImgResultado[2].setBounds(161, 118, 63, 31);
		add(ImgResultado[2]);
		
		int[] ejm = {1,-1};
		
		for (int j = 0; j < ejm.length; j++) {
			ImageIcon imgf = new ImageIcon(".\\data\\Gana.jpg");
			final Icon icof = new ImageIcon( imgf.getImage().getScaledInstance(ImgResultado[0].getWidth(), ImgResultado[0].getHeight(), Image.SCALE_DEFAULT));
			
//		if(ejm[j]>0){
//			ImageIcon imgf = new ImageIcon(".\\data\\Gana.jpg");
//			final Icon icof = new ImageIcon( imgf.getImage().getScaledInstance(ImgResultado[0].getWidth(), ImgResultado[0].getHeight(), Image.SCALE_DEFAULT));
//			ImgResultado[j].setIcon(icof);
//		}
//		else{
//			ImageIcon imgf = new ImageIcon(".\\data\\Pierde.jpg");
//			final Icon icof = new ImageIcon( imgf.getImage().getScaledInstance(ImgResultado[0].getWidth(), ImgResultado[0].getHeight(), Image.SCALE_DEFAULT));
//			ImgResultado[j].setIcon(icof);
//		}
		
			if(ejm[j]>0)
				ImgResultado[j].setIcon(icof); if(ejm[j]<0) ImgResultado[j].removeAll();
					
			
	}
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(383, 118, 91, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			new Thread(){
				@Override
				public void run() {
					super.run();
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					DadoAtacante1.setIcon(null);
				}
			
				
			}.start();
				
			
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(161, 76, 63, 31);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(161, 118, 63, 31);
		getContentPane().add(label_1);
		}
	
	public static void main(String[] args) {

		PanelDado frame = new PanelDado();
		frame.setVisible(true);

	}
}
