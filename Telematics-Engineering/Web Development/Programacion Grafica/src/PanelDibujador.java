import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelDibujador extends JPanel{
	
	//Relacion al mundo del pajaro
	
	private MundoPajaro ojo;
	
	//atributos de los ojos
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	//color del pajaro
	private Color color;
	
	//constructor
	public PanelDibujador(MundoPajaro o){
		ojo = o;
		x1 = o.getOjo1X();
		y1 = o.getOjo1Y();
		x2 = o.getOjo2X();
		y2 = o.getOjo2Y();
	}
	
	//metodo pintador

	public void paintComponent(Graphics grafico) { 
		
	super.paintComponent(grafico);  
	
	//Pongo la imagen de fondo
	Toolkit imágenes = Toolkit.getDefaultToolkit();
	Image logo = imágenes.getImage("./data/postes.jpg");
	grafico.drawImage(logo, 0, 0, this); 
	
	//Dibujo pajaro
	grafico.setColor(color); 
	grafico.fillOval(0, 70, 100, 80);
	grafico.setColor(Color.YELLOW);
	grafico.fillArc(80, 100, 40, 30, 30, 90);
	//ojos 
	grafico.setColor(Color.WHITE);
	grafico.fillOval(90, 70, 20, 20);
	grafico.fillOval(110, 70, 20, 20);
	//bolita ojo
	grafico.setColor(Color.BLUE);
//	grafico.fillOval(105, 80, 5, 5);
//	grafico.fillOval(125, 80, 5, 5);
	
	grafico.fillOval(x1, y1, 5, 5);
	grafico.fillOval(x2, y2, 5, 5);
	
	} 
	

	
	public static void main(String[] args){
		
		JFrame ventana = new JFrame("Panel Hola");
		ventana.setSize(633,574);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MundoPajaro posicion = new MundoPajaro(105, 80, 125, 80, 90, 80, 110, 80);
		
		PanelDibujador animacion = new PanelDibujador(posicion);
		
		ventana.getContentPane().add(animacion);
		ventana.setVisible(true);
		
		int c = 1;
		
		while(true){
			
			
			
			if(animacion.getX1()== posicion.getOjo1X()){
				
				animacion.setX1(posicion.getOjo3X());
				animacion.setY1(posicion.getOjo3Y());
				animacion.setX2(posicion.getOjo4X());
				animacion.setY2(posicion.getOjo4Y());
				animacion.color = Color.RED;
				
				ventana.repaint();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				System.out.println(c++);
				
				
				
			}else if(animacion.getX1()== posicion.getOjo3X()){
				
				animacion.setX1(posicion.getOjo1X());
				animacion.setY1(posicion.getOjo1Y());
				animacion.setX2(posicion.getOjo2X());
				animacion.setY2(posicion.getOjo2Y());
				animacion.color = Color.BLACK;
				
				ventana.repaint();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
				System.out.println(c++);
			}
			
			
			
		}
	}

	public MundoPajaro getOjo() {
		return ojo;
	}

	public void setOjo(MundoPajaro ojo) {
		this.ojo = ojo;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	
	
}
