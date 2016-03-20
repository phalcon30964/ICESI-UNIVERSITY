package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DivisionEgresados implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	public final static String SEPARADOR = ";";
	private ArrayList<Egresado> egresados;
	
	public DivisionEgresados(){
		egresados = new ArrayList<Egresado>();
	}
	
	public void agregarEgresado(String nom, String ape, String ced, String tel, String correoE){
		Egresado e = new Egresado(nom,ape,ced,tel,correoE);
		egresados.add(e);
	}
	
	public ArrayList<Egresado> darEgresados(){
		return egresados;
	}
	
	public void cargarListaEgresados(String nombreArchivo) throws FormatoInvalidoException {
		
		egresados = null;
		egresados = new ArrayList <Egresado>();
		//Manejo excepciones que no sean FormatoInvalido y lanzo en su lugar un FormatoInvalido
		try{
		
		//Creo flujo
		BufferedReader lector = new BufferedReader(new FileReader(new File(nombreArchivo)));
		
		//Leo linea primera vez
		String linea = lector.readLine();
		
		//Empiezo ciclo lector hasta el final
		while(linea!=null){
			
			//Hago verificaciones de formato inciial
			if(!linea.startsWith("%")){
				if(!linea.startsWith(" ")){
					
					if(linea.contains(SEPARADOR)){
					
					String[] datos = linea.split(SEPARADOR);
					
						//Verifico que tenga el numero de datos completos 6
						if(datos.length == 6){
						
						String nom = datos[1];
						String ape = datos[2];
						String ced = datos[3];
						String tel = datos[4];
						String correoE = datos[5];
						//creo los objetos
						agregarEgresado(nom, ape, ced, tel, correoE);
						
						}else{
						throw new FormatoInvalidoException("Falló la carga del archivo!", nombreArchivo, Integer.parseInt(datos[0]));
						}
					}
				}
			}
			
				//Hago el avance, volviendo a leer.
				linea = lector.readLine();
		}
		
			//Al terminar el ciclo que cierre el lector
			lector.close();
			
		}catch(IOException e){
			
			throw new FormatoInvalidoException(e.getMessage(), nombreArchivo, 0);
		}catch(NumberFormatException e){
			
			throw new FormatoInvalidoException("La lista seleccionada no es serializada, escoja una lista de texto (.txt) por favor", nombreArchivo, 0);

		}
		
	}
	
	
	public void cargarListaEgresadosSerializada(String nombreArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//Creo el flujo
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(new File(nombreArchivo)));
		//Leo el objeto
		 
		egresados = (ArrayList<Egresado>)entrada.readObject();;
		//Cierro el flujo
		entrada.close();
		
	}
	
	
	public void asignarPuestoAInvitados(){
		
		//Creo un arraylist auxiliar para albergar numeros
		ArrayList <String> aux = new ArrayList<String>();
		//Lo relleno de numeros ordenados
		for (int i = 0; i < egresados.size(); i++) {
			String j = (i+1)+"";
			aux.add(j);
		}
		
		//Creo una instancia de random
		Random aleatorio = new Random();
		
		//Hago recorrido por el tamaño de egresados asignado numeros aleatorios
		for (int i = 0; i < egresados.size() ; i++) {
		
			//Le pido a random que me de una posicion aleatoria desde 0 hasta el tamaño de aux
			int posAleatoria = aleatorio.nextInt(aux.size());
			
			//Ahora saco el numero que haya en la posicion aleatoria y lo guardo
			int numeroAleatorio = Integer.parseInt(aux.get(posAleatoria));
			
			//Asigno en orden el numero aleatorio que acabo de sacar del arraylist aux
			egresados.get(i).cambiarNumeroPuesto(numeroAleatorio);
			
			//Borro el numero en la posicion aleatoria para que no lo pueda volver a escoger.
			aux.remove(posAleatoria);
			
		}
		
		//Ordeno para que se vea bien en el JTextArea
		
		for(int i = egresados.size() ; i > 0 ; i -- ){
			for (int j = 0; j < i-1 ; j++) {
				
				if (egresados.get(j).darNumeroPuesto()>egresados.get(j+1).darNumeroPuesto()) {
					
					Egresado temp = egresados.get(j);
					egresados.set(j, egresados.get(j+1));
					egresados.set(j+1 , temp);
				}
			}
		}
	}
	
	public String generaTarjetasInvitacion(){
		
		String retorno = "";
		
		//Creo un arraylist auxiliar para no desorganizar el que se muestra en el JTextArea de Invitados
		ArrayList <Egresado> egresados2 = new ArrayList <Egresado>();
		
		//Copio todos los elementos de egresados en el auxiliar
		for (int i = 0; i < egresados.size(); i++) {
			egresados2.add(egresados.get(i));
		}
		
		//Ordeno arraylist el auxiliar
		for (int i = 1; i < egresados2.size(); i++) {
			for (int j = i ; j > 0; j--) {
				
				if(egresados2.get(j-1).darApellidos().compareTo(egresados2.get(j).darApellidos())>0){
					
					Egresado a1 = egresados2.get(j-1);
					egresados2.set(j-1, egresados2.get(j));
					egresados2.set(j, a1);
				}
			}
		}
		
		
		for (int i = 0; i < egresados2.size(); i++) {
			Egresado aux = egresados2.get(i);
			
			retorno = retorno + "============  INVITADO "+(i+1)+"  ============" +"\nNombre: "+aux.darNombres()+" "+aux.darApellidos() 
					+"\nCedula: "+aux.darCedula()+ "\n Telefono: "+ aux.darTelefono()+ "\nCorreo eletronico: "+ aux.darCorreoElectronico()
					+"\n\n\nLa universidad icesi tiene el gusto de invitarlo a su aniversario.\nContamos con su importante asitencia!\n\n\n";
		}
		
		return retorno;
	}
	
	public void guardarTarjetasInvitacion(String nombreArchivo) throws IOException {
		
		//Creo un flujo de salida de datos ObjectOutputStream y le pongo por parametro un FileOutputStream que le entra por parametro un File
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(new File(nombreArchivo)));
		//Escribo el archivo de datos con witreObject
		salida.writeObject(egresados);
		//Cierro el ciclo
		salida.close();
		
	}
	
	public String obtenerCadenaInfoEgresados(){
		String infoEgresados = "Puesto - Nombres, Apellidos, Cedula, Telefono, Correo\n";
		for(int i=0;i<egresados.size();i++){
			
			infoEgresados += egresados.get(i) + "\n"; //Se aprovecha el metodo toString
		}
		return infoEgresados;
	}
	
	
	
}
