package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelEncabezado extends JPanel{
	
	//atributos
	private JLabel banner;
	
	public PanelEncabezado(){
		
		//Configuracion del panel
		
		setLayout(new BorderLayout());
		
		//Inicializacion de atributos
		
		ImageIcon ban = new ImageIcon("img/banner.png");
		banner = new JLabel(ban);
		
		//Agregar atributos
		
		add(banner, BorderLayout.CENTER);
		
	}

}
