package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelDibujo extends JPanel{

	public void paintComponent(Graphics grafico){
		
		super.paintComponent(grafico);
		this.setBackground(Color.WHITE);
		grafico.setColor(Color.BLACK);
		grafico.drawOval(500, 300, 100, 90);
		grafico.setColor(Color.RED);
		grafico.fillOval(500, 300, 100, 90);
	}
}
