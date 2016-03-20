package TadTurnos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import TadPila.Pila;

public class Turnos<T extends Serializable> implements ITurnos<T>{
	
	public final static String RUTAPERSISTENCIA = "./data/turno";	
	
	private T mundo;
	private int numTurnos;
	private Pila<String> turnos;
	private int tamanoRonda;
	
	/**
	 * Constuctor de la clase turno que admnistra los estados de una aplicacion 
	 * 
	 * @param T instancia de la clase principal de la aplicacion a serializar
	 */
	public Turnos(T mundo, int tamanoRonda){	
		this.mundo = mundo;
		numTurnos = 0;
		turnos = new Pila<String>();
		this.tamanoRonda = tamanoRonda;
	}
	
	/**
	 * Metodo que guarda un estado de la aplicacion
	 * 
	 * pre:true
	 */
	public void guardarTurno(){
		
		if(turnos.size()==tamanoRonda){
			try {
				turnos.popFirst();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(numTurnos==3){
				numTurnos=1;
			}else{
				numTurnos++;
			}
			
		}else{
			numTurnos++;
		}
		
		try {
			File archivo = new File(RUTAPERSISTENCIA+(numTurnos));
			turnos.push(RUTAPERSISTENCIA+(numTurnos));
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(mundo);
			oos.close();
			System.out.println("Serializado en "+RUTAPERSISTENCIA+(numTurnos));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		

	}
	
	/**
	 * Meotodo que restablece un turno o estado, devuelve una instancia de la aplicacion
	 * que tiene el estado perteneciente al anterior turno
	 * 
	 * 
	 * @return T instancia de la aplicacion con un estado anterior
	 * @throws Exception si nunca se ha guardado un turno
	 */
	@SuppressWarnings("unchecked")
	public T restablecerTurno() throws Exception{
			
		File archivo = new File(turnos.pop());	
		
		T turno = null;
		
		if(archivo.exists()){
			
			ObjectInputStream ois;	
			ois = new ObjectInputStream(new FileInputStream(archivo));
			turno = (T)ois.readObject();
			ois.close();
			
		}
		
		return turno;
		
	}
	
	/**
	 * Metodo que restablece un turno del juego, este metodo recibe por parametro 
	 * el tamaño de la ronda, y devuelve una instancia de la aplicacion de como estaba 
	 * tantos numero de turnos atras como el tamano de ronda
	 *  
	 * @param tamañoRonda numero de turnos para el cual se considera es una ronda
	 * @return T instancia de la apliacion con el estado que tenia una ronda atras
	 * @throws Exception si nunca se ha guardado ni un solo turno
	 */
	@SuppressWarnings("unchecked")
	public T restablecerRonda() throws Exception{
		
		String ruta = turnos.pop();
		
		if(tamanoRonda>numTurnos){
			for (int i = 0; i < numTurnos; i++) {
				ruta = turnos.pop();
			}
		}else{
			for (int i = 0; i < tamanoRonda; i++) {
				ruta = turnos.pop();
			}
		}

		File archivo = new File(ruta);	
		
		T turno = null;
		
		if(archivo.exists()){
			
			ObjectInputStream ois;	
			ois = new ObjectInputStream(new FileInputStream(archivo));
			turno = (T)ois.readObject();
			ois.close();
			
		}
		return turno;	
	}

	

}
