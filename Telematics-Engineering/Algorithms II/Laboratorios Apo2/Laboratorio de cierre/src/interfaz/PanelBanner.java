package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel{
	public PanelBanner(){
		setLayout(new BorderLayout());
		JLabel banner = new JLabel(new ImageIcon("data/imgs/banner.jpg"));
		add(banner,BorderLayout.CENTER);
	}
}
