import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class panelHola extends JPanel{
	
	private cambiarOjos ojo;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	private Color color;
	
	public panelHola(cambiarOjos o){
		ojo = o;
		x1 = o.getOjo1X();
		y1 = o.getOjo1Y();
		x2 = o.getOjo2X();
		y2 = o.getOjo2Y();

	}

	public void paintComponent(Graphics gráfico) { 
	super.paintComponent(gráfico); 
	
	gráfico.setColor(color); 
	gráfico.fillOval(50, 50, 100, 80);
	gráfico.setColor(Color.YELLOW);
	gráfico.fillArc(80, 100, 40, 30, 30, 90);
	//ojos 
	gráfico.setColor(Color.WHITE);
	gráfico.fillOval(90, 70, 20, 20);
	gráfico.fillOval(110, 70, 20, 20);
	//bolita ojo
	gráfico.setColor(Color.BLUE);
//	gráfico.fillOval(105, 80, 5, 5);
//	gráfico.fillOval(125, 80, 5, 5);
	
	gráfico.fillOval(x1, y1, 5, 5);
	gráfico.fillOval(x2, y2, 5, 5);
	
	} 
	
	public static void main(String[] args){
		
		JFrame ventana = new JFrame("Panel Hola");
		ventana.setSize(250,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cambiarOjos posicion = new cambiarOjos(105, 80, 125, 80, 90, 80, 110, 80);
		
		panelHola animacion = new panelHola(posicion);
		
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
				
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				System.out.println(c++);
				
				
				
			}else if(animacion.getX1()== posicion.getOjo3X()){
				
				animacion.setX1(posicion.getOjo1X());
				animacion.setY1(posicion.getOjo1Y());
				animacion.setX2(posicion.getOjo2X());
				animacion.setY2(posicion.getOjo2Y());
				animacion.color = Color.BLACK;
				
				ventana.repaint();
				
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			
				System.out.println(c++);
			}
			
			
			
		}
	}

	public cambiarOjos getOjo() {
		return ojo;
	}

	public void setOjo(cambiarOjos ojo) {
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
