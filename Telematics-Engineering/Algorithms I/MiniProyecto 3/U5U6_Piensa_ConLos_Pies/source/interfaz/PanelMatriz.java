package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelMatriz extends JPanel implements ActionListener {
	
	//Relacion a la intefaz
	private InterfazJuego interfaz;
	
	//Atributos
	private JPanel pMatriz;
	private JButton[][] matriz;
	
	//Constantes
	
	public final static int TAMANO_PREDETERMINADO = 4;
	
	//Constructor
	
	public PanelMatriz(InterfazJuego v){
		//Inicializo la intefaz
		interfaz = v;
		
		//Configuracion del panel
		setLayout(new GridLayout(1,1));
		
		//Inicializo panel interno
		pMatriz = new JPanel();
		
		crearMatrizNueva(TAMANO_PREDETERMINADO);
		
		//Agrego el panel interno
		
		add(pMatriz);
	}
		
	//este metodo crea una matriz a partir del parametro de entrada, luego crea un nuevo panel interno y la asiga al atributo pMatriz
	//matriz queda inicializado
	//pMatriz queda inicializado
	//param: int tam, entero que dice el tamano con que se crea la matriz que se asignara al panel interno pMatriz
	
	public void crearMatrizNueva(int tam){
		
		pMatriz.removeAll();
		pMatriz.setLayout(new GridLayout(tam,tam));
		
		//Inicializo matriz con el parametro
		matriz = new JButton[tam][tam];
		
		//Inicializo posiciones
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = new JButton("");
				matriz[i][j].setActionCommand(i+""+j+"");
				matriz[i][j].addActionListener(this);
			}
		}
				
		//Agrego los elementos al panel interno
			for (int j = 0; j < matriz.length; j++) {
				for (int j2 = 0; j2 < matriz[0].length; j2++) {
					
					pMatriz.add(matriz[j][j2]);	
				}	
			}		
	}
	
	
	//pinta de rojo la casilla que tiene las cordenadas x, y que le entran como parametro
	
	//pre:ya debe haberse inicializado la matriz de botones y debe haberse creado todas sus posiciones
	//pos:queda pintada la casilla selecionada de rojo
	//param posisiciones en x y y enteros

	public void pintarRojo(int x, int y){
		
		if(matriz[x][y].getBackground().equals(Color.RED)){
			matriz[x][y].setBackground(null);
		}else{
			matriz[x][y].setBackground(Color.RED);
		}
	}
	
	//pinta de azul la matriz segun el patro que le entra como parametro, si la posicion es verdadero pinata la casilla 
	//correspondiente de la matriz de botones matriz de color azul.
	
	//pre: ya debe haberse inicializado la matriz de botones y debe haberse creado todas sus posiciones
	//pre: el patron debe coicidir con el tamano de la matriz 
	//pos: queda pintado la matriz con el patron dado
	//param: matris de boleanos que se usara como patron para pintar, true si el cuadra esta seccionado false si no
	
	public void pintarMatrizAzul(boolean[][] patron){
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				if(patron[i][j]==true){
					matriz[i][j].setBackground(Color.BLUE);
				}
				
			}
		}
		
	}
	
	//limpia la matriz de cualquier color que tenga
	
	//pre:la matriz debe estar inicializada
	//pre:las posiciones de la matriz deben estar inicializada
	//pos: todas las posiciones de la matriz estan sin fondo de color
	
	public void limpiarMatriz(){
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j].setBackground(null);	
			}
		}
	}
	
	//Da el patron seleccionado por el usuario
	
	//pre:la matriz matriz debe estar inicializada y con sus posiciones inicializadas
	//pre:el usuario ya debe haber seleccionado todo el patron
	//return patron seleccionado por el usuario en un boolean[][]
	
	public boolean[][] darPatronSeleccionado(){
		
		boolean[][] patron = new boolean[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				if(matriz[i][j].getBackground().equals(Color.RED)){
					patron[i][j] = true;
				}else{
					patron[i][j] = false;
				}
			}
		}
		
		return patron;
		
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String posicion = e.getActionCommand();
		
		int posicionX = Integer.parseInt(posicion.charAt(0)+"");
		int posicionY = Integer.parseInt(posicion.charAt(1)+"");
		
		pintarRojo(posicionX, posicionY);
	
		
	}

}
