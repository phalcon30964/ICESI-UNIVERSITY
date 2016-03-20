package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelBanner extends JPanel{
	
	//Atributos
	private JLabel labImagen;
	
	//Constructor
	public PanelBanner(){
		
		//Configuracion del panel
		setLayout(new BorderLayout());
		
		//Inicializacion de atributos
		ImageIcon img = new ImageIcon("data/img/titulo.png");
		labImagen = new JLabel(img);
		
		//Adicion de elementos
		add(labImagen);
	}
	

}
