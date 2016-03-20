package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import Modelo.Consultorio;

public class HiloServer extends Thread{

	private Socket canal;
	private BufferedReader lector;
	private PrintWriter escritor;
	private Consultorio consultorio;
	private final static String VC="VERIFICAR_CEDULA";
	private final static String CEDULA="CEDULA";
	private final static String EXISTE="EXISTE";
	private final static String YA="YA";
	private final static String NO_CITAS="NO CITAS";
	private final static String NO_SE_ENCUENTRA="NO SE ENCUENTRA";
	private final static String RP="REGISTRAR PACIENTE";
	private final static String DATOS="DATOS";
	private final static String CC="CC";
	private final static String RC="RC";
	private final static String CHAO="CHAO";


	private boolean termino;

	public HiloServer(Socket canalCliente, Consultorio consul) {
		super();
		this.canal = canalCliente;
		this.consultorio = consul;
		this.termino = false;
		try {
			lector = new BufferedReader(new InputStreamReader(canal.getInputStream()));
			escritor = new PrintWriter(canal.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {

		String datos;
		String lectura;

		try {
			while(!termino){
				lectura = lector.readLine();
				if(lectura!=null){

					//En Caso de verificar Cedula VC
					if(lectura.equals(VC)){
						escritor.println(CEDULA);
						escritor.flush();
						lectura = lector.readLine();

						if(consultorio.existePaciente(lectura)){
							escritor.println(EXISTE);
							escritor.flush();
							String[] arregloInfo = consultorio.darInfoPaciente(lectura);
							ArrayList<String> arrayInfo=consultorio.darCitasPaciente(lectura);
							String info1 = arregloInfo[0]+";"+arregloInfo[1]+";"+arregloInfo[2];	
							escritor.println(info1);
							escritor.flush();

							if(lector.readLine().equals(YA)){
								if(!arrayInfo.isEmpty()){
									String info2=""+arrayInfo.size()+"/";
									for(int i =0; i<arrayInfo.size();i++){
										info2 += ";"+arrayInfo.get(i);
									}
									escritor.println(info2);
								}
								else{
									escritor.println(NO_CITAS);
								}						
								escritor.flush();
							}	
						}

						else{
							escritor.println(NO_SE_ENCUENTRA);
						}

						escritor.flush();
					}

					//En Caso de Registrar Paciente RP
					if(lectura.equals(RP)){


						escritor.println(DATOS);				
						escritor.flush();
						datos = lector.readLine();


						String[] datosPa = new String[7];
						datosPa = datos.split(";");
						try{
							consultorio.registrarPaciente(datosPa[0],datosPa[1],datosPa[2],datosPa[3],datosPa[4],datosPa[5],datosPa[6]);
							escritor.println("SI");
						}catch(Exception e){
							escritor.println("NO");
						}

						escritor.flush();

					}
					//CASO D Disponible
					if(lectura.equals("DD")){

						escritor.println("FECHA");
						escritor.flush();
						String fecha = lector.readLine();
						System.out.println("Fecha");
						String[] dma = new String[3];
						dma = fecha.split("-");
						String[] disp = new String[15];
						disp = consultorio.darDisponibilidad(dma[0], dma[1], dma[2]);
						String c = disp[0]+";"+disp[1]+";"+disp[2]+";"+disp[3]+";"+disp[4]+";"+disp[5]+";"+disp[6]+";"+disp[7]+";"+disp[8]+";"+disp[9]+";"+disp[10]+";"+disp[11]+";"+disp[12]+";"+disp[13]+";"+disp[14];
						escritor.println(c);
					}


					if(lectura.equals(CC)){
						escritor.println("INFO");
						escritor.flush();
					}
					if(lectura.equals("DIFU")){
						
						escritor.println("DEME_MENSAJE");
						escritor.flush();
						
						String mensaje = lector.readLine();
						Ejecutable.enviarMensaje(mensaje);
						
					}
					
					if(lectura.equals(RC)){

						escritor.println("HORA");
						escritor.flush();
						lectura = lector.readLine();
						String[] abc = new String[5];
						abc=lectura.split("-");
						int i = Integer.parseInt(abc[0]);
						consultorio.nuevaCita(i, abc[1], abc[2],abc[3], abc[4]);

					}

					if(lectura.equals(CHAO)){

						termino = true;

					}

				}
			}
		}	
		catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}


	}

}



