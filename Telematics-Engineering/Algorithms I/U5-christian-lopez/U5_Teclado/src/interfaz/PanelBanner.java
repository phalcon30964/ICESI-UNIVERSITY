package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel{
	private JLabel labImagen;
	
	public PanelBanner(){
		setLayout(new BorderLayout());
		
		ImageIcon imagen = new ImageIcon("data/imgs/BannerAbecedario.png");
		labImagen = new JLabel(imagen);
		
		add(labImagen, BorderLayout.CENTER);
	}
}
