package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mundo.Convertidor;


public class InterfazConvertidor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanelEntrada panelEntrada;
	private PanelResultados panelResultados;
	private Convertidor convertidor;
	
	
	public InterfazConvertidor(){
		
		setTitle("ConvertidorTemperatura");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelEntrada = new PanelEntrada(this);
		panelResultados = new PanelResultados();
		convertidor = new Convertidor();
		
		setLayout(new BorderLayout());
		add(panelEntrada, BorderLayout.NORTH);
		add(panelResultados, BorderLayout.CENTER);
		
		pack();
	}
	
	public void gestionarConversion(double c){
		 convertidor.cambiarCentigrados(c);
		 
		 double f = convertidor.convertirAFahrenheit();
		 double k = convertidor.convertirAKelvin();
		 
		 panelResultados.refrescarFahrenheit(f);
		 panelResultados.refrescarKelvin(k);
	}
	
	public static void main(String[] args) {
		
		InterfazConvertidor ventana = new InterfazConvertidor();
		ventana.setVisible(true);
		
		
	}
}
