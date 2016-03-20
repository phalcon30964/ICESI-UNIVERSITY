package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mundo.*;

public class InterfazAngryBirds extends JPanel implements MouseListener{
	
	//relacion al mundo
	
	private Dibujador mundo;
	
	//atributo
	
	private int posXCuerpo;
	
	private int posXOjo1;
	
	private int posXOjo2;
	
	private int posXPico;
	
	private int posXPupila;
	
	private JTextField txtPeso;
	
	//constructor
	
	public InterfazAngryBirds(){
		
		mundo = new Dibujador();
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		//pinto fondo
		Toolkit imágenes = Toolkit.getDefaultToolkit();
		Image fondo = imágenes.getImage("./data/p.jpg");
		g.drawImage(fondo, 0, 0, this);
		
		
		ArrayList <Pajaro> paj = (ArrayList <Pajaro>) mundo.darPajaros();
		
		for (int i = 0; i < paj.size(); i++) {
			
			Pajaro p = paj.get(i);
			
			if(p!=null){
					
			//pinto cuerpo de pajaro tam 100*100
			g.setColor(p.darColor()); 
			g.fillOval(p.darPosXCuerpo(), p.darPosYCuerpo(), 100, 100);
			
			//pinto ojos del pajaro tam 30*30
			g.setColor(Color.WHITE); 
			g.fillOval(p.darPosXOjo1(), 90, 30, 30);
			g.fillOval(p.darPosXOjo2(), 90, 30, 30);
			
			//pinto pupilas del pajaro
			g.setColor(Color.BLACK);
			g.fillOval(p.darPosXPupila(), 100, 10, 10);
			g.fillOval(p.darPosXPupila()+30, 100, 10, 10);
			
			//pinto pico tam 40*40 angI 45 y angF 90
			g.setColor(Color.GRAY);
			g.fillArc(p.darPosXPico(), 120, 40, 40, 45, 90);
			}
			
		}
		
		g.setColor(Color.BLACK); 
		g.setFont(new Font("Dialog",Font.ITALIC,25));
		g.drawString("Peso:",25,510); 
		g.drawString(mundo.darPesoTotal()+"",100,510);

	}
	
	public static void main(String[] args){
		
		JFrame ventana1 = new JFrame("Reunion AngryBirds");
		ventana1.setSize(653, 574);
		ventana1.getContentPane().add(new InterfazAngryBirds());
		ventana1.setVisible(true);
	}
	
	public void agregarNuevoPajaro(){
		
		
		if(mundo.darNumeroPajaros()==0){
		
		posXCuerpo = 0;
		posXOjo1 = 20;
		posXOjo2 = 50;
		posXPico = 30;
		posXPupila = 30;
			
		mundo.agregarPajaro(posXCuerpo, 60, posXOjo1, posXOjo2, posXPico, posXPupila);
		
		repaint();
		
		}else if(mundo.darNumeroPajaros()>0) {
			
		posXCuerpo = posXCuerpo + 100;
		posXOjo1 = posXOjo1+100;
		posXOjo2 = posXOjo2+100;
		posXPico = posXPico+100;
		posXPupila = posXPupila+100;
			
		mundo.agregarPajaro(posXCuerpo, 60, posXOjo1, posXOjo2, posXPico, posXPupila);
		repaint();
		
		}
	}
	
	public void eliminarPajaro(int x, int y){
		
		mundo.eliminarPajaro(x,y);
			
		repaint();
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if( e.getButton( ) == MouseEvent.BUTTON1 ){
		agregarNuevoPajaro();
		System.out.println(mundo.darPesoTotal());
		}
		
		if(e.getButton() == MouseEvent.BUTTON3){
		eliminarPajaro(e.getX(), e.getY());
		System.out.println(mundo.darPesoTotal());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
