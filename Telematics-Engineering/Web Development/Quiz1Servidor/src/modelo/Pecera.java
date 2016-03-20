package modelo;

import java.util.Random;

public class Pecera {
	
	private int numeroPecez;
	private int[] x;
	private int[] y;
	private int[] r;
	private int[] g;
	private int[] b;
	private int[] accion;
	private boolean ocupado;
	
	public final static int SUBIR = 0;
	public final static int BAJAR = 1;
	public final static int IZQUIERDA = 2;
	public final static int DERECHA = 3;

	
	public Pecera() {
		Random ran = new Random();
		//peces del 1 al 5
		numeroPecez = (ran.nextInt(5)+1);

		x = new int[numeroPecez];
		y = new int[numeroPecez];
		r = new int[numeroPecez];
		g = new int[numeroPecez];
		b = new int[numeroPecez];
		accion = new int[numeroPecez];
		

		//prisicion inicial
		for (int i = 0; i < numeroPecez; i++) {
			x[i] = ran.nextInt(801);		
		}
		for (int i = 0; i < numeroPecez; i++) {
			y[i] = ran.nextInt(601);
		}
		for (int j = 0; j < numeroPecez; j++) {
			r[j]= ran.nextInt(256);
		}
		for (int i = 0; i < numeroPecez; i++) {
			g[i] = ran.nextInt(256);
		}
		for (int i = 0; i < numeroPecez; i++) {
			b[i] = ran.nextInt(256);
		}
		//accion o movimiento determinado
		for (int i = 0; i < numeroPecez; i++) {
			accion[i] = ran.nextInt(4);
		}
		
		ocupado = false;
	}
	
	//mueven peces
	public void subirPez(int pos){
		x[pos] = (x[pos]-5);
	}
	
	public void bajarPez(int pos){
		x[pos] = (x[pos]+5);
	}
	
	public void moverIzquierdaPez(int pos){
		y[pos] = (y[pos]-5);
	}
	
	public void moverDerechaPez(int pos){
		y[pos] = (y[pos]+5);
	}
	
	//Getters String
	public String getPosX(){
		String msj = "";
		for (int i = 0; i < numeroPecez; i++) {
			msj += (x[i]+"/");
		}
		return msj.substring(0, msj.length());
	}
	public String getPosY(){
		String msj = "";
		for (int i = 0; i < numeroPecez; i++) {
			msj += (y[i]+"/");
		}
		return msj.substring(0, msj.length());
	}
	public String getRed(){
		String msj = "";
		for (int i = 0; i < numeroPecez; i++) {
			msj += (r[i]+"/");
		}
		return msj.substring(0, msj.length());
	}
	public String getGreen(){
		String msj = "";
		for (int i = 0; i < numeroPecez; i++) {
			msj += (g[i]+"/");
		}
		return msj.substring(0, msj.length());
	}
	public String getBlue(){
		String msj = "";
		for (int i = 0; i < numeroPecez; i++) {
			msj += (b[i]+"/");
		}
		return msj.substring(0, msj.length());
	}
	
	//getters y setters normales

	public int getNumeroPecez() {
		return numeroPecez;
	}

	public void setNumeroPecez(int numeroPecez) {
		this.numeroPecez = numeroPecez;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public int[] getR() {
		return r;
	}

	public void setR(int[] r) {
		this.r = r;
	}

	public int[] getG() {
		return g;
	}

	public void setG(int[] g) {
		this.g = g;
	}

	public int[] getB() {
		return b;
	}

	public void setB(int[] b) {
		this.b = b;
	}

	public int[] getAccion() {
		return accion;
	}

	public void setAccion(int[] accion) {
		this.accion = accion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}
