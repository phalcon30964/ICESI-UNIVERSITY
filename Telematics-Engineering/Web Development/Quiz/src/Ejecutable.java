

import java.awt.EventQueue;

import javax.swing.JFrame;

import vista.Interfaz;

public class Ejecutable {
	
	private static Interfaz window;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Interfaz();
					window.frame.setVisible(true);
					
					bajar();
					bajar();
					bajar();
					bajar();
					bajar();
					bajar();
					bajar();
					bajar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void bajar(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.getPanel().setY((window.getPanel().getY()+5));
		window.frame.repaint();
		System.out.println("bajó");
	
	
	}
	
	public static void subir(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.getPanel().setY((window.getPanel().getY()-5));
		window.frame.repaint();

	}
	
	public static void moverDerecha(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.getPanel().setX((window.getPanel().getX()+5));
		window.frame.repaint();
	}
	
	public static void moverIzquierda(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.getPanel().setX((window.getPanel().getX()-5));
		window.frame.repaint();
	}

}
