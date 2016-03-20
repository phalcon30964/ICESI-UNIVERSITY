package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InterfazTeclado extends JFrame{
	
	//Relaciones hacia los paneles
	private PanelPantalla panelPantalla;
	private PanelAdic panelAdic;
	private PanelAbecedario panelAbecedario;
	private PanelBanner panelBanner;
	
	public InterfazTeclado(){
		setTitle("Teclado :: Desarrollado por Pepito Pérez");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panelPantalla = new PanelPantalla();
		panelAdic = new PanelAdic();
		panelAbecedario = new PanelAbecedario();
		panelBanner = new PanelBanner();
		
		JPanel panelInterno = new JPanel();
		panelInterno.setLayout(new BorderLayout());
		panelInterno.add(panelBanner,BorderLayout.NORTH);
		panelInterno.add(panelPantalla,BorderLayout.CENTER);
		
		
		add(panelInterno,BorderLayout.NORTH);
		//add(panelPantalla,BorderLayout.NORTH);
		add(panelAdic,BorderLayout.WEST);
		add(panelAbecedario,BorderLayout.CENTER);
		
		//setSize(600,200);
		pack();
	}
	
	
	public static void main(String[] args){
		InterfazTeclado ventana;
		ventana = new InterfazTeclado();
		ventana.setVisible(true);
	}
}
