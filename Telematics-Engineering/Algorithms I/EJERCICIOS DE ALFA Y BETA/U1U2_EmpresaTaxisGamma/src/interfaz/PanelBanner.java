package interfaz;

import java.awt.BorderLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel{
	private JLabel labBanner;
	public PanelBanner(){
		setLayout(new BorderLayout());
		labBanner = new JLabel(new ImageIcon("data/img/bannerTaxis.png"));
		add(labBanner,BorderLayout.CENTER);
	}
}
