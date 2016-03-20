package interfaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelBotones extends JPanel implements ActionListener {
	
	//Constantes
	public final static String CALCULAR = "CALCULAR";
	public final static String JUGAR = "JUGAR";
	public final static String COMPROBAR = "COMPROBAR";
	public final static String INICIAR = "INICIAR JUEGO";
	
	//Atributos
	private JButton butCalcular;
	private JButton butJugar;
	private JButton butComprobar;
	private JButton butIniciar;
	
	//Relaciones 
	private InterfazJuego interfaz;
	
	//Constructor
	
	public PanelBotones(InterfazJuego i){
		
		//Inicializo la relacion
		interfaz = i;
		
		//Configuro panel
		setBorder(new TitledBorder("Botones"));
		setLayout(new BorderLayout());
		
		
		//Inicializo atributos y los configuro
		
		butCalcular = new JButton("Calcular");
		butCalcular.setActionCommand(CALCULAR);
		butCalcular.addActionListener(this);
		deshabilitarButCalcular();
		
		butJugar = new JButton("Jugar");
		butJugar.setActionCommand(JUGAR);
		butJugar.addActionListener(this);
		deshabilitarButJugar();
		
		butComprobar = new JButton("Comprobar");
		butComprobar.setActionCommand(COMPROBAR);
		butComprobar.addActionListener(this);
		deshabilitarButComprobar();
		
		butIniciar = new JButton("Iniciar Juego");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener(this);
		
		JPanel v = new JPanel();
		v.setLayout(new GridLayout(4,1,0,5));
		v.add(butCalcular);
		v.add(butJugar);
		v.add(butComprobar);
		v.add(butIniciar);
		
		//Adiciono elementos
		add(new JLabel("                          "), BorderLayout.WEST);
		add(v, BorderLayout.CENTER);
		add(new JLabel("                          "), BorderLayout.EAST);
	}
	
	public void habilitarButCalcular(){
				//habilita el boton
				butCalcular.setEnabled(true);
		
	}
	
	public void habilitarButJugar(){
				//habilita el boton
				butJugar.setEnabled(true);
	
	}

	public void habilitarButComprobar(){
			//habilita el boton
			butComprobar.setEnabled(true);
	
	}

	public void habilitarButIniciar(){
			//habilita el boton
			butIniciar.setEnabled(true);
	
	}
	
	public void deshabilitarButCalcular(){
				//habilita el boton
				butCalcular.setEnabled(false);
		
	}
	
	public void deshabilitarButJugar(){
				//habilita el boton
				butJugar.setEnabled(false);
		
	}

	public void deshabilitarButComprobar(){
			//habilita el boton
			butComprobar.setEnabled(false);
	
	}

	public void deshabilitarButIniciar(){
			//habilita el boton
			butIniciar.setEnabled(false);
	
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String event = arg0.getActionCommand();
		
		if(event.equals(CALCULAR)){
			
			//Metodo que resuelve el requerimiento
			interfaz.calcular();
			
		}else if(event.equals(JUGAR)){
			
			//Metodo que resuelve el requerimiento
			interfaz.jugar();

		}else if(event.equals(COMPROBAR)){
			
			//Metodo que resuelve el requerimiento
			interfaz.comprobar();

		}else if(event.equals(INICIAR)){
			
			//Metodo que resuelve el requerimiento
			interfaz.iniciarJuego();
		}

	}
}
