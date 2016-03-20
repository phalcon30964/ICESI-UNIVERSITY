package interfaz;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import mundo.Zona;

@SuppressWarnings("serial")
public class PanelSitios extends JPanel{
	private Zona zona;
	private InterfazTurismo principal;
	public PanelSitios(InterfazTurismo ventana, Zona z){
		zona = z;
		principal = ventana;
		setLayout(new FlowLayout(FlowLayout.LEADING));
		actualizarSitios();
	}
	
	public void actualizarSitios(){
		removeAll();
		if(zona.darSitioUno()!=null){
			add(new PanelSitio(principal,zona.darSitioUno(),zona));
		}
		if(zona.darSitioDos()!=null){
			add(new PanelSitio(principal,zona.darSitioDos(),zona));
		}
		if(zona.darSitioTres()!=null){
			add(new PanelSitio(principal,zona.darSitioTres(),zona));
		}
		if(zona.darSitioCuatro()!=null){
			add(new PanelSitio(principal,zona.darSitioCuatro(),zona));
		}
		if(zona.darSitioCinco()!=null){
			add(new PanelSitio(principal,zona.darSitioCinco(),zona));
		}
		revalidate();
		repaint();
	}
	
	public void eliminarPanelSitio(JPanel panelSitio){
		remove(panelSitio);
		revalidate();
		repaint();
	}
}
