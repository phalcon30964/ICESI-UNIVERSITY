import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelSencillo extends JPanel{

	
	/** Se sobreescribe el método paintComponent para realizar un dibujo */ 
	public void paintComponent(Graphics gráfico) { 
	super.paintComponent(gráfico); 
	gráfico.drawRect(20,20,150,50); 
	gráfico.setColor(Color.blue); 
	Font a = new Font("Serif",Font.BOLD,14);
	gráfico.setFont(a); 
	gráfico.drawString("H O L A",70,50); 
	
	//lineas
	gráfico.drawLine(1, 1, 60, 60);
	
//	drawChars(char[ ], int, int, int, int): Este método, en lugar de recibir una cadena como parámetro, 
//	recibe un arreglo de caracteres. En los siguientes parámetros se indica cuál es el primer carácter 
//	en el arreglo a dibujar y el número de caracteres, a partir de este, que se dibujan. Los últimos 
//	valores equivalen a las coordenadas x,y a partir de las cuales se dibujan los caracteres. 

	//rectangulo redondeado
	gráfico.drawRoundRect (5, 7, 111, 111, 10, 10);
	
	//rectangulo 3d
	gráfico.draw3DRect(20, 20, 30, 30, false);
	gráfico.fill3DRect(20,20,70,50,true);
	
	//camabia backgroud
	this.setBackground(Color.lightGray);
	
	//poligonos
	int[] valoresX = {40,50,70,50,40,30,10,30}; 
	int[] valoresY= {10,30,40,50,70,50,40,30};
	gráfico.drawPolygon(valoresX,valoresY,valoresX.length); 
	
	int[] coordX = {80,60,60,70,100}; 
	int[] coordY = {90,70,60,60,80}; 
	gráfico.drawPolyline(coordX,coordY,5); 
	
	Polygon polígono = new Polygon(); 
	polígono.addPoint(10,10); 
	polígono.addPoint(10,30); 
	polígono.addPoint(20,20); 
	gráfico.drawPolygon(polígono); 
	
	//imagenes
	
	
		Toolkit ambiente = Toolkit.getDefaultToolkit(); 
		Image imágen = ambiente.getImage(""); 
		gráfico.drawImage(imágen,20,20,this); 
	



	} 
	public static void main(String[] args) { 
	JFrame ventana = new JFrame("Panel Sencillo"); 
	ventana.setSize(200,150); 
	// Adiciona el lienzo que tiene el método paint sobreescrito 
	ventana.getContentPane().add(new PanelSencillo()); 
	/* Al hacer visible el frame el ambiente de ejecución llamará al método paint de todos los 
	componentes */ 
	ventana.setVisible(true); 
	} 


}
