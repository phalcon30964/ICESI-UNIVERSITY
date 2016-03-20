package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteEmergencias {

	public static void main(String[] args) {
		
		boolean escuchar = true;
		
		try{
			MulticastSocket mSock = new MulticastSocket(5000);
			InetAddress direccionGrupo = InetAddress.getByName("239.1.2.2");
			mSock.joinGroup(direccionGrupo);
			System.out.println(mSock.getLocalPort());
			
			while(escuchar){
				byte[] buf = new byte[1000];
				DatagramPacket recibe = new DatagramPacket(buf, buf.length);
				mSock.receive(recibe);
				
				String datos = new String(recibe.getData(),0,recibe.getLength());
				if(!datos.equals("FIN")){
					System.out.println(datos);
				}else{
					escuchar = false;
				}
			}
			
			mSock.leaveGroup(direccionGrupo);
			mSock.close();
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
