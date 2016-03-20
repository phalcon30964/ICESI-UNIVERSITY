package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelDatos extends JPanel{
	
	//Atributos
	
	private JLabel labTamano;
	private JLabel labSize;
	private JLabel labIntentos;
	private JLabel labAttempts;
	private JLabel labPuntaje;
	private JLabel labScore;
	
	
	//Constructor
	
	public PanelDatos(){
		
		//Configuracion del panel
		setBorder(new TitledBorder("Datos"));
		setLayout(new GridLayout(1,7,5,0));
		
		//Inicializacion de los atributos (los inicializo con los valores por defecto de la ventana pero luego se cambiar al actualizarse el jeuego
		
		labTamano = new JLabel("Tamaño:");
		labSize = new JLabel("Pequeño");
		labIntentos = new JLabel(" Intentos:");
		labAttempts = new JLabel("0");
		labPuntaje = new JLabel(" Puntaje:");
		labScore = new JLabel("0");
		
		//adiciono de los elementos al panel
		
		add(new JLabel("          "));
		add(labTamano);
		add(labSize);
		add(new JLabel(""));
		add(labIntentos);
		add(labAttempts);
		add(labPuntaje);
		add(labScore);
		add(new JLabel("          "));
	}
	
	public void refrescarSize(int s){
		
		switch(s){
		case 4:
				labSize.setText("Pequeño");
				break;
		case 5: 
				labSize.setText("Normal");
				break;
		case 6:
				labSize.setText("Mediano");
				break;
		case 7: 
				labSize.setText("Grande");
				break;
		}	
	}
	
	public void refrescarAttepmts(int s){

		labAttempts.setText((s-1)+"");
	}

	public void refrescarScore(int s){
		
		labScore.setText(s+"");
	}

}
