package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Operaciones {
	private boolean suma;
	private boolean resta;
	private int numeroUno;
	private int numeroDos;
	private Usuario usuarioActual;
	private ArrayList usuarios;

	public Operaciones() {
		generarOperación();
		usuarios = new ArrayList<Usuario>();

	}
	public void definirJugador(String nombre){
		String nombreEstandar=nombre.toLowerCase();
		usuarioActual= buscarJugador(nombreEstandar);
				
	}
private Usuario buscarJugador(String nombre){
	Usuario temporal=null;
	boolean encontro=false;
	if(usuarios.size()>0){
		for(int index=0; index< usuarios.size() && !encontro; index++){
			temporal= (Usuario)usuarios.get(index);
			if(temporal.getNombre().equals(nombre)){
				encontro= true;
			}
		}
	}
	if(!encontro){
		temporal=crearJugador(nombre);
	}
	return temporal;
}	
 private Usuario crearJugador(String nombre){
	 Usuario nuevo= new Usuario(nombre);
	 usuarios.add(nuevo);
	 return nuevo;
 }
	
	// Se encarga de generar los numeros (entre 0 y 9) y la operación de manera
	// aleatoria.
	public void generarOperación() {
		Random aleatorio = new Random();
		numeroUno = aleatorio.nextInt(10);
		numeroDos = aleatorio.nextInt(10);
		boolean operación = aleatorio.nextBoolean();
		if (operación) {
			suma = true;
			resta = false;
		} else {
			resta = true;
			suma = false;
		}
	}
 public boolean validarResultado(int resultadoUsuario){
	 int resultadoOk=0;
	 boolean acerto=false; 
	 //Se calcula el resultado correcto
	 if(suma){
		 resultadoOk=numeroUno+numeroDos;
	 }else{
		 resultadoOk=numeroUno-numeroDos;
	 }
	 
	 //Comparar si el resultado del usuario es igual al resultado correcto
	 if(resultadoOk==resultadoUsuario){
		 //El usuario acertó, se debe sumar 1 punto a su puntaje.
		 usuarioActual.aumentarPuntaje();
		 acerto=true;
	 }else{
		 //El usuario se equivocó, se debe restar 1 punto de su puntaje.
		 usuarioActual.bajarPuntaje();
	 }
	 return acerto;
 }
	public boolean isSuma() {
		return suma;
	}

	public void setSuma(boolean suma) {
		this.suma = suma;
	}

	public boolean isResta() {
		return resta;
	}

	public void setResta(boolean resta) {
		this.resta = resta;
	}

	public int getNumeroUno() {
		return numeroUno;
	}

	public void setNumeroUno(int numeroUno) {
		this.numeroUno = numeroUno;
	}

	public int getNumeroDos() {
		return numeroDos;
	}

	public void setNumeroDos(int numeroDos) {
		this.numeroDos = numeroDos;
	}
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	public ArrayList getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList usuarios) {
		this.usuarios = usuarios;
	}
}
