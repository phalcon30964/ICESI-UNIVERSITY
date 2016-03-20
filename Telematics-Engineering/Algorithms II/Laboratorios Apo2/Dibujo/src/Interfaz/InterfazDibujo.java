package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazDibujo extends JFrame {
	private JPanel PanelDibujo;

	public InterfazDibujo(){
		PanelDibujo= new PanelDibujo();
		add(PanelDibujo);
		
	}
	
	public static void main(String[] args) {
		InterfazDibujo interfaz= new InterfazDibujo();
		interfaz.setSize(700,400);
		interfaz.setVisible(true);
	}
	
}
