package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelInfoSillas extends JPanel {
	
	//atributos
	
	private JLabel labSillasReservadas;
	private JLabel labSillasVendidas;
	private JLabel labPorcentajeOcupacion;
	private JLabel labFilaDisponibleEnGeneral;
	
	private JTextField txtSillasReservadas;
	private JTextField txtSillasVendidas;
	private JTextField txtPorcentajeOcupacion;
	private JTextField txtFilaDisponibleEnGeneral;
	
	//contructor
	
	public PanelInfoSillas(){
		
		//configuracion panel
		
		setBorder(new TitledBorder("Informacion de sillas"));
		setLayout(new GridLayout(4,2));
		
		//inicializacion atributos
		
		  labSillasReservadas = new JLabel("Sillas Reservadas:");
		  labSillasVendidas = new JLabel("Sillas Vendidas:");
		  labPorcentajeOcupacion = new JLabel("Porcentaje ocupacion:");
		  labFilaDisponibleEnGeneral = new JLabel("Fila disponible en General:");
		
		  txtSillasReservadas = new JTextField();
		  txtSillasReservadas.setEditable(false);
		  txtSillasVendidas = new JTextField();
		  txtSillasVendidas.setEditable(false);
		  txtPorcentajeOcupacion = new JTextField();
		  txtPorcentajeOcupacion.setEditable(false);
		  txtFilaDisponibleEnGeneral = new JTextField();
		  txtFilaDisponibleEnGeneral.setEditable(false);
		  
		  
		 //adicion de los elementos
		  
		  add(labSillasReservadas);
		  add(txtSillasReservadas);
		  add(labSillasVendidas);
		  add(txtSillasVendidas);
		  add(labPorcentajeOcupacion);
		  add(txtPorcentajeOcupacion);
		  add(labFilaDisponibleEnGeneral);
		  add(txtFilaDisponibleEnGeneral);
	}
	
	public void refrescarSillasReservadas(String entrada){
		
		txtSillasReservadas.setText(entrada);
	}
	
	public void refrescarSillasVendidas(String entrada){
		
		txtSillasVendidas.setText(entrada);
	}

	public void refrescarPorcentajeOcupacion(String entrada){
	
	txtPorcentajeOcupacion.setText(entrada);
	}

	public void refrescarFilaDisponibleEnGeneral(String entrada){
	
	txtFilaDisponibleEnGeneral.setText(entrada);
	}


}
