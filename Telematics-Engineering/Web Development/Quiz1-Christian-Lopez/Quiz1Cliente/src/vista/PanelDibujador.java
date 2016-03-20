package vista;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDibujador extends JPanel {
	
	private int numPeces;
	private int[] posX;
	private int[] posY;
	private Color[] color;
	private int alto;
	private int ancho;
	private JFrame ventana;
	

	/**
	 * Create the panel.
	 */
	
	public PanelDibujador(int n, int[] x, int[] y, int[] r, int[] g, int[] b) {
		
		numPeces = n;
		posX=x;
		posY=y;
		color = new Color[numPeces];
		
		for (int i = 0; i < numPeces; i++) {
			color[i] = new Color(r[i], g[i], b[i]);
		}
		
		alto=20;
		ancho=20;

		ventana = new JFrame("Panel CHRISTIAN LOPEZ");
		ventana.setSize(820,640);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Toolkit imágenes = Toolkit.getDefaultToolkit();
		Image logo1 = imágenes.getImage("./Data/a.jpg");
		g.drawImage(logo1,0,0, this); 
		
		for (int i = 0; i < numPeces; i++) {
			g.setColor(color[i]);
			g.fillArc(posX[i], posY[i], alto, ancho, 0, 360);
			
			Image logo = imágenes.getImage("./Data/p.jpg");
			g.drawImage(logo, posX[i],posY[i], this); 
		}
		
	}

	public int getNumPeces() {
		return numPeces;
	}

	public void setNumPeces(int numPeces) {
		this.numPeces = numPeces;
	}

	public int[] getPosX() {
		return posX;
	}

	public void setPosX(int[] posX) {
		this.posX = posX;
		repaint();
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int[] getPosY() {
		return posY;
	}

	public void setPosY(int[] posY) {
		this.posY = posY;
		repaint();
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Color[] getColor() {
		return color;
	}

	public void setColor(Color[] color) {
		this.color = color;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public JFrame getVentana() {
		return ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

}
