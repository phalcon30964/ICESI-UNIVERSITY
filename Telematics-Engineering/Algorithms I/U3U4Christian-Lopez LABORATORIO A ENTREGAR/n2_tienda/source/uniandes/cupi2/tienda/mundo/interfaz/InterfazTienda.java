package uniandes.cupi2.tienda.mundo.interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazTienda extends JFrame {
	
	private PanelProductos panelProductos;
	private PanelOperaciones panelOperaciones;
	private PanelCalculos panelCalculos;
	
	public InterfazTienda(){
		
		setTitle("Latinoamericana : Tienda : Desarrollado por Christian David Lopez");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	    
	    panelProductos = new PanelProductos();
	    panelProductos.setBackground(Color.YELLOW);
	 
	    panelOperaciones = new PanelOperaciones();
	    panelOperaciones.setBackground(Color.BLUE);
	    
	    panelCalculos = new PanelCalculos();
	    panelCalculos.setBackground(Color.RED);
	    
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new BorderLayout());
	    //esto agrega espacios a los lados del panel central
	    panel1.add(new JLabel("                     "), BorderLayout.WEST);
	    panel1.add(new JLabel("                     "), BorderLayout.EAST);
	    panel1.add(panelProductos, BorderLayout.CENTER);
	    
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new BorderLayout());
	    //esto agrega espacios a los lados del panel central

	    panel2.add(new JLabel("                     "), BorderLayout.WEST);
	    panel2.add(new JLabel("                     "), BorderLayout.EAST);
	    panel2.add(panelOperaciones, BorderLayout.CENTER);
	    
	    JPanel panel3 = new JPanel();
	    panel3.setLayout(new BorderLayout());
	    //esto agrega espacios a los lados del panel central
	    panel3.add(new JLabel("                     "), BorderLayout.WEST);
	    panel3.add(new JLabel("                     "), BorderLayout.EAST);
	    panel3.add(panelCalculos, BorderLayout.CENTER);
	   

	    
		
	    setLayout (new BorderLayout());
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
		pack();
		setMinimumSize(new Dimension(getWidth(),getHeight()));
		
		//setSize(436, 331);
	}
	
	public static void main (String[] args){
		InterfazTienda ventana = new InterfazTienda();
		ventana.setVisible(true);
	}

}
