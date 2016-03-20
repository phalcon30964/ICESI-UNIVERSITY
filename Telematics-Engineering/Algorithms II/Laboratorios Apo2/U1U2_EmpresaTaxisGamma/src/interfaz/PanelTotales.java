package interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelTotales extends JPanel{
	private JLabel labSemana;
	private JLabel labIngresos;
	private JLabel labGastos;
	private JLabel labBalance;
	private JLabel labAhorros;
	
	private JLabel labSemanaNm;
	private JTextField txtIngresos;
	private JTextField txtGastos;
	private JTextField txtBalance;
	private JTextField txtAhorros;
	
	public PanelTotales(){		
		setBorder(new TitledBorder("Totales"));
		setLayout(new GridLayout(0,2));
		setPreferredSize(new Dimension(150,120));
		
		labSemana = new JLabel("Semana:");
		labIngresos = new JLabel("Ingresos:");
		labGastos   = new JLabel("Gastos:");
		labBalance  = new JLabel("Balance:");
		labAhorros  = new JLabel("Ahorros:");
		
		labSemanaNm = new JLabel("");
		txtIngresos = new JTextField("");
		txtGastos   = new JTextField("");
		txtBalance  = new JTextField("");
		txtAhorros  = new JTextField("");
		
		labSemanaNm.setFont(new Font("Serif", Font.BOLD, 24));
		labSemanaNm.setForeground(Color.GREEN);
		txtIngresos.setEditable(false);
		txtGastos.setEditable(false);
		txtBalance.setEditable(false);
		txtAhorros.setEditable(false);

		add(labSemana);
		add(labSemanaNm);
		add(labIngresos);
		add(txtIngresos);
		add(labGastos);
		add(txtGastos);
		add(labBalance);
		add(txtBalance);
		add(labAhorros);
		add(txtAhorros);		
	}
	
	public void cambiarSemana(int semana){labSemanaNm.setText(""+semana);}
	public void cambiarIngresos(double ing){txtIngresos.setText("$"+ing);}
	public void cambiarGastos(double gas){txtGastos.setText("$"+gas);}
	public void cambiarBalance(double bal){txtBalance.setText("$"+bal);}
	public void cambiarAhorros(double aho){txtAhorros.setText("$"+aho);}
}
