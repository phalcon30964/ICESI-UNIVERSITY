import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interfaz extends JFrame {
	
	JLabel img ;
	
	
	public Interfaz(){
		
		
		setLayout(new BorderLayout());
		setTitle("Laboratorio de cierre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		ImageIcon icon = new ImageIcon("./data/postes.jpg");
		JLabel imagenDeFondo = new JLabel(icon);
		
		
		add(imagenDeFondo);
		
		pack();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Interfaz inter = new Interfaz();
		inter.setVisible(true);
		
		// TODO Auto-generated method stub

	}

}
