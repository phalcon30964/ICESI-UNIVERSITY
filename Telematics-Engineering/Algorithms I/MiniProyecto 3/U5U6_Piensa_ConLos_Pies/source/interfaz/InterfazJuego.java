package interfaz;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import mundo.*;

public class InterfazJuego extends JFrame {
	
	//Atributos
	private PanelBanner panelBanner;
	private PanelDatos panelDatos;
	private PanelBotones panelBotones;
	private PanelMatriz panelMatriz;
	
	//relacion al mundo
	
	private Juego mundo;
	
	
	//Constructor
	public InterfazJuego(){
		
		//inicializacion del mundo
		mundo = new Juego();
		
		//Configuracion de la ventana principal
		setTitle("Piensa con los pies");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		//Inicializacion de atributos
		panelBanner = new PanelBanner();
		panelDatos = new PanelDatos();
		panelBotones = new PanelBotones(this);
		panelMatriz = new PanelMatriz(this);
		
		//Panel Interno
		JPanel interno2 = new JPanel();
		interno2.setLayout(new BorderLayout());
		interno2.add(panelMatriz, BorderLayout.WEST);
		interno2.add(panelBotones, BorderLayout.CENTER);
		
		//Adicion de elementos 
		add(panelBanner, BorderLayout.NORTH);
		add(panelDatos, BorderLayout.CENTER);
		add(interno2, BorderLayout.SOUTH);
		
		pack();
	}
	
	//Main
	public static void main(String[] args){
		InterfazJuego v = new InterfazJuego();
		v.setVisible(true);
		
	}
	
	public void calcular(){
		
		mundo.inicializarMatriz();
		boolean[][] patron = mundo.darPatronMatriz();
		panelMatriz.pintarMatrizAzul(patron);
		panelBotones.habilitarButJugar();
		panelBotones.deshabilitarButCalcular();
	
	}
	
	public void jugar(){
		
		panelMatriz.limpiarMatriz();
		panelBotones.deshabilitarButCalcular();
		panelBotones.deshabilitarButJugar();
		panelBotones.habilitarButComprobar();
		
	}
	
	public void comprobar(){
		boolean[][] patronSeleccionado = panelMatriz.darPatronSeleccionado();
		boolean esIgual = mundo.comprobarPatronMatriz(patronSeleccionado);
		
		try{
		
		if(esIgual==true){
			mundo.aumentarTamanoMatriz();
			mundo.aumentarPuntaje();
			panelMatriz.limpiarMatriz();
			panelMatriz.crearMatrizNueva(mundo.darTamanoActual());
			panelDatos.refrescarSize(mundo.darTamanoActual());
			panelDatos.refrescarAttepmts(mundo.darNumIntentos());
			panelDatos.refrescarScore(mundo.darPuntajeActual());
			panelBotones.deshabilitarButComprobar();
			panelBotones.habilitarButCalcular();
		}else{
			
			mundo.disminuirTamanoMatriz();
			panelDatos.refrescarSize(mundo.darTamanoActual());
			panelDatos.refrescarAttepmts(mundo.darNumIntentos());
			panelMatriz.limpiarMatriz();
			panelMatriz.crearMatrizNueva(mundo.darTamanoActual());
			panelBotones.deshabilitarButJugar();
			panelBotones.deshabilitarButComprobar();
			panelBotones.habilitarButCalcular();
			JOptionPane.showMessageDialog(this, "Se ha seleccionado al menos un cuadro incorrecto", "Fallaste", JOptionPane.ERROR_MESSAGE);

			
		}
		
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(this, e.getMessage());
			
			int respuesta = JOptionPane.showConfirmDialog(this, "Desea volver a jugar?");
			if(respuesta==JOptionPane.YES_OPTION){
				mundo.resetTamano();
				mundo.resetScore();
				mundo.resetNumIntentos();
				panelDatos.refrescarSize(mundo.darTamanoActual());
				panelDatos.refrescarAttepmts(mundo.darNumIntentos());
				panelDatos.refrescarScore(mundo.darPuntajeActual());
				panelMatriz.crearMatrizNueva(mundo.darTamanoActual());
				panelBotones.deshabilitarButComprobar();
				panelBotones.habilitarButIniciar();
			}else{
				System.exit(0);
			}
			
		}
		
	}
	
	public void iniciarJuego(){
		
		try{
			
			File archivo = seleccionarArchivo();
			mundo.cargarInfoJuego(archivo);

			
			panelBotones.habilitarButCalcular();
			panelBotones.deshabilitarButIniciar();
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
			
	}
	
	private File seleccionarArchivo()throws Exception{
		File salida = null;
		JFileChooser fc = new JFileChooser("./data");
		
		fc.setDialogTitle("Seleccione el archivo de configuración");
		int resultado = fc.showOpenDialog(this);
		
		if(resultado==JFileChooser.APPROVE_OPTION){
			salida = fc.getSelectedFile();
		}else{
			throw new Exception("No seleccionó nada, debe seleccionar una archivo para comenzar el juego");
		}
		
		return salida;
		
	}

}
