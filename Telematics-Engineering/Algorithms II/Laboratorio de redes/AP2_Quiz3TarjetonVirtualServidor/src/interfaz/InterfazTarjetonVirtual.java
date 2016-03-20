package interfaz;

import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.Candidato;
import mundo.Tarjeton;

@SuppressWarnings("serial")
public class InterfazTarjetonVirtual extends JFrame{
	
	private Tarjeton miTarjeton;
	
	private PanelCandidatos panelCandidatos;
	
	private ServidorTarjeton servidorTarjeton;
	
	private AdminBD adminBD;
	
	public InterfazTarjetonVirtual(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servidor :: Tarjetón Virtual");
		setLayout(new BorderLayout());
		
		miTarjeton = new Tarjeton();
		adminBD    = new AdminBD();
		
		panelCandidatos = new PanelCandidatos();
		add(panelCandidatos, BorderLayout.CENTER);
		
		try{
			servidorTarjeton = new ServidorTarjeton(this);
		}catch(IOException excep){
			JOptionPane.showMessageDialog(this, "El servidor no puede iniciar.\n\nPosible Causa:\n"+excep.getMessage());
		}
		
		try{
			adminBD.abrirConexion();
		
		}catch(ClassNotFoundException excnotfound){
			JOptionPane.showMessageDialog(this, "Problemas al cargar el driver de la base de datos.\n\nPosible Causa:\n"+excnotfound.getMessage());
		}catch(SQLException excsql){
			JOptionPane.showMessageDialog(this, "Problemas al establecer la conexión con la base de datos.\n\nPosible Causa:\n"+excsql.getMessage());
		}
		
		try{
			miTarjeton.cambiarCandidatos(adminBD.consultarCandidatos());
			refrescarPanelCandidatos();
		}catch(SQLException excsql){
			JOptionPane.showMessageDialog(this, "Problemas al realizar la consulta de los candidatos en la base de datos.\n\nPosible Causa:\n"+excsql.getMessage());
		}
		
		//Para cargar candidatos sin conectarse a la base de datos:
		//crearEscenario();
		
		pack();		
	}
	
	/**
	 * Retorna el objeto del candidato por el cual se realizó la votación
	 * Retorna null en caso de que no exista un candidato con el código pasado por parámetro
	 */	
	public Candidato realizarVotacion(String codigoCandidato){
		Candidato candidatoVotado = null;
		
		int pos = miTarjeton.buscarCandidato(codigoCandidato);
		
		if(pos>-1){
			try{
			
				adminBD.actualizarVotosCandidato(codigoCandidato);
				
				miTarjeton.votarCandidato(pos);			
				candidatoVotado = miTarjeton.darCandidato(pos);
				panelCandidatos.actualizarVotos(pos, candidatoVotado.darVotos());
			}catch(SQLException excsql){
				JOptionPane.showMessageDialog(this, "Problemas al actualizar los votos del candidato '"+codigoCandidato+"' en la base de datos.\n\nPosible Causa:\n"+excsql.getMessage());				
			}
		}
		
		return candidatoVotado;
	}
	
	public void iniciarAtencionDelServidor(){
		if(servidorTarjeton!=null){
			try{
				servidorTarjeton.atenderCliente();
			}catch(IOException excep){
				JOptionPane.showMessageDialog(this, "Se ha interrumpido la atención del servidor.\n\nPosible Causa:\n"+excep.getMessage());
			}
		}
	}
	
	public void errorComunicacionConCliente(String msg){
		JOptionPane.showMessageDialog(null, msg);		
	}

	
	public void crearEscenario(){
		miTarjeton.agregarCandidato("1234", "Leonard Hofstadter", "Física Experimental", 0);
		miTarjeton.agregarCandidato("5678", "Sheldon Cooper", "Física Experimental", 0);
		miTarjeton.agregarCandidato("2468", "Penny", "Actuación", 0);
		miTarjeton.agregarCandidato("1357", "Howard Wolowitz", "Ingeniería Aeroespacial", 0);
		miTarjeton.agregarCandidato("1479", "Rajesh Koothrappali", "Astrofísica", 0);
		
		refrescarPanelCandidatos();
	}
	
	
	public void refrescarPanelCandidatos(){
		for(int i=0;i<miTarjeton.darTotalCandidatos();i++){
			Candidato can = miTarjeton.darCandidato(i);
			panelCandidatos.agregarCandidato(
					can.darCodidgo(),
					can.darNombre(),
					can.darPartido(),
					can.darVotos()
			);
		}
	}
	
	public static void main(String[] args){
		InterfazTarjetonVirtual ventana = new InterfazTarjetonVirtual();
		ventana.setVisible(true);
		ventana.iniciarAtencionDelServidor();
	}
}
