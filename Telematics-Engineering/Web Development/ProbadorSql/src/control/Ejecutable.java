package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Interfaz;
import modelo.ConectorMySql;


public class Ejecutable {
	
	private static ConectorMySql conexion;
	private static Interfaz interfaz;
	
	public static void main(String[] args) {

		interfaz = new Interfaz();
		interfaz.frame.setVisible(true);
		
		try {
			conexion = new ConectorMySql("P09728_1_3","KA0EuM0V","200.3.193.22","3306");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void escucharEjecutarComando(){
		interfaz.getBtnEjecutarComando().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					conexion.ejecutarActualizacion(interfaz.getTextField().getText());
					interfaz.getTextResultado().setText("Se ejecutó bien el comando");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo ejecutar el comando");
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void escucharEjecutarConsulta(){
		interfaz.getBtnEjecutarConsulta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet resultado = conexion.ejecutarConsulta(interfaz.getTextField().getText());
					
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo ejecutar la consulta");
					e1.printStackTrace();
				}
			}
		});
	}
}
