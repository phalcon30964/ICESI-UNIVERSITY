package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements MouseListener{
	
	private Graphics g;
	
	
	public Menu(){
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics gra){
		
		g = gra;
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image archivo = tool.getImage("./data/bulb.png");
		Image ayuda = tool.getImage("./data/help.png");
		
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 30);
		g.drawImage(archivo, 0, 0, this);
		g.drawImage(ayuda, 110, 0, this);
		
		
		g.setColor(Color.BLACK); 
		g.setFont(new Font("Dialog",Font.ITALIC,20));
		g.drawString("Archivo",16,20); 
		g.drawString("Ayuda",126, 20);
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setSize(500,500);
		ventana.getContentPane().add(new Menu());
		ventana.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		if(e.getX()>0 && e.getX()<500){
//			if(e.getYOnScreen()>0 && e.getYOnScreen()<16){
				
				Toolkit tool = Toolkit.getDefaultToolkit();
				Image archivo = tool.getImage("./data/bulb.png");
				g.setColor(Color.BLUE);
				g.drawRect(0, 0, 110, 20);
				g.drawImage(archivo, 0, 0, this);
				g.setColor(Color.BLACK); 
				g.setFont(new Font("Dialog",Font.ITALIC,20));
				g.drawString("Archivo",16,20); 
				g.drawString("Ayuda",126, 20);
				
//			}	
//		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
