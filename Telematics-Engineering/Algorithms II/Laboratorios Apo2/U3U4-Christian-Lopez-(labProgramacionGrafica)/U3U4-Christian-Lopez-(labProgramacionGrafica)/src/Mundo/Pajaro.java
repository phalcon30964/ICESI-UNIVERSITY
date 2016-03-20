package Mundo;

import java.awt.Color;
import java.util.Random;

public class Pajaro {
	
	//atributos
	
	private int id;
	
	private Color color;
	
	private int peso;
	
	private int posXCuerpo;
	
	private int posYCuerpo;

	private int posXOjo1;
	
	private int posXOjo2;
	
	private int posXPico;
	
	private int posXPupila;
	
	
	//constantes
	
	public static final Color AZUL = Color.BLUE;
	
	public static final Color ROJO = Color.RED;
	
	public static final Color AMARILLO = Color.YELLOW;
	
	//constructor
	
	public Pajaro(int ID, int posXC, int posYC, int posXO1, int posXO2, int posXPic, int posXPupi){
		id = ID;
		color = asignarColor();
		peso = asignarPeso();
		posXCuerpo = posXC;
		posYCuerpo = posYC;
		posXOjo1 = posXO1;
		posXOjo2 = posXO2;
		posXPico = posXPic;
		posXPupila = posXPupi;
		
	}
	
	public Color asignarColor(){
		
		Color respuesta = null;
		
		Random r = new Random();
		int aleatorio = r.nextInt(3);
		
		switch (aleatorio) {
		case 0:
			respuesta = AZUL;
			break;

		case 1:
			respuesta = ROJO;
			break;
			
		case 2:
			respuesta = AMARILLO;
			break;
	
		}
		
		return respuesta;
	}
	
	public int asignarPeso(){
		
		Random r = new Random();
		int aleatorio = r.nextInt(10)+1;
		Math.abs(aleatorio);
		
		return aleatorio;
		
	}
	
	public boolean estaAdentro(int x, int y){
		
		if((posXCuerpo+100)>=x && x>=posXCuerpo){
			if((posYCuerpo+100)>=y && y>=posYCuerpo){
				return true;
			}
		}
		
		return false;
	}

	public int darId() {
		return id;
	}

	public Color darColor() {
		return color;
	}

	public int darPeso() {
		return peso;
	}

	public int darPosXCuerpo() {
		return posXCuerpo;
	}

	public int darPosYCuerpo() {
		return posYCuerpo;
	}

	public int darPosXOjo1() {
		return posXOjo1;
	}

	public int darPosXOjo2() {
		return posXOjo2;
	}

	public int darPosXPico() {
		return posXPico;
	}

	public int darPosXPupila() {
		return posXPupila;
	}

	public void cambiarId(int id) {
		this.id = id;
	}

	public void cambiarColor(Color color) {
		this.color = color;
	}

	public void cambiarPeso(int peso) {
		this.peso = peso;
	}

	public void cambiarPosXCuerpo(int posXCuerpo) {
		this.posXCuerpo = posXCuerpo;
	}

	public void cambiarPosYCuerpo(int posYCuerpo) {
		this.posYCuerpo = posYCuerpo;
	}

	public void cambiarPosXOjo1(int posXOjo1) {
		this.posXOjo1 = posXOjo1;
	}

	public void cambiarPosXOjo2(int posXOjo2) {
		this.posXOjo2 = posXOjo2;
	}

	public void cambiarPosXPico(int posXPico) {
		this.posXPico = posXPico;
	}

	public void cambiarPosXPupila(int posXPupila) {
		this.posXPupila = posXPupila;
	}
	
	
	
}

	