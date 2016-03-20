package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class mkjhg extends JPanel{
	
private Graphics arg;

private int x;
private int y;


	public mkjhg() {
		
		x =0;
		y=0;
		
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		arg = arg0;
		
		super.paintComponent(arg0);
		arg0.drawString("jhgljhkg", 100, 10);
		arg0.setColor(Color.RED);
		arg0.fillArc(x, y, 20, 20, 0, 360);
	}
	
	
	public void cmn (){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x =50;
		y=50;
		repaint();
		
		
	}
	

}
