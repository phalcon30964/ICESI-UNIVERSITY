package Mundo;

import java.util.ArrayList;

public class Dibujador {
	
	//atributos y relaciones
	private ArrayList <Pajaro> pajaros;
	
	private int pesoTotal;
	
	private int numeroPajaros;
	
	private boolean seLleno;

	
	//Constantes
	
	public static final int PESO_MAXIMO = 30;
	
	//Constructor
	
	public Dibujador(){
		pajaros = new ArrayList<Pajaro>();
		pesoTotal = 0;
		numeroPajaros = 0;
		seLleno = false;
	}
	
	//Metodos
	
	public void agregarPajaro(int posXC, int posYC, int posXO1, int posXO2, int posXPic, int posXPupi){
		
		Pajaro p = new Pajaro(numeroPajaros+1, posXC, posYC, posXO1 , posXO2, posXPic, posXPupi );
		
		if(pesoTotal+p.darPeso()>30 && !seLleno){
			p.cambiarPeso(30-pesoTotal);
			seLleno = true;
		}
		
		if(pesoTotal+p.darPeso()<=30 && numeroPajaros<=5){
			pajaros.add(p);
			numeroPajaros++;
			pesoTotal = pesoTotal + p.darPeso();
		}
		
	}
	
	public void eliminarPajaro(int x, int y){
		
		for (int i = 0; i < pajaros.size(); i++) {
			if(pajaros.get(i).estaAdentro(x, y)){
				pesoTotal -= pajaros.get(i).darPeso();
				pajaros.remove(i);
				
			}	
		}
		
	}

	public ArrayList<Pajaro> darPajaros() {
		return pajaros;
	}

	public int darPesoTotal() {
		return pesoTotal;
	}

	public int darNumeroPajaros() {
		return numeroPajaros;
	}

	public void cambiarPajaros(ArrayList<Pajaro> pajaros) {
		this.pajaros = pajaros;
	}

	public void cambiarPesoTotal(int pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public void cambiarNumeroPajaros(int numeroPajaros) {
		this.numeroPajaros = numeroPajaros;
	}

}
