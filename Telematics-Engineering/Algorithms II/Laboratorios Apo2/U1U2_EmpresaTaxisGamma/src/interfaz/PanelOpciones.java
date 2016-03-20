package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener{
	private JButton butAvanzar;
	private JButton butReporte1;
	private JButton butReporte2;
	
	public final static String AVANZAR   = "AVANZAR";
	public final static String REPORTE1  = "REPORTE1";
	public final static String REPORTE2  = "REPORTE2";
	
	private InterfazEmpresaTaxis principal;
	
	public PanelOpciones(InterfazEmpresaTaxis ventana){
		setBorder(new TitledBorder("Opciones"));
		setLayout(new GridLayout(0,3));
		
		principal = ventana;
		
		butAvanzar   = new JButton("Avanzar Semana >");
		butReporte1  = new JButton("Reporte 1");
		butReporte2  = new JButton("Reporte 2");
		add(butAvanzar);
		add(butReporte1);
		add(butReporte2);
		
		butAvanzar.setActionCommand(AVANZAR);
		butReporte1.setActionCommand(REPORTE1);
		butReporte1.setActionCommand(REPORTE2);
		
		butAvanzar.addActionListener(this);
		butReporte1.addActionListener(this);
		butReporte2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String comando = ev.getActionCommand();
		
		if(comando.equals(AVANZAR)){
			principal.avanzarSemana();
		}else if(comando.equals(REPORTE1)){
			
		}else if(comando.equals(REPORTE2)){
			
		}
	}
}
