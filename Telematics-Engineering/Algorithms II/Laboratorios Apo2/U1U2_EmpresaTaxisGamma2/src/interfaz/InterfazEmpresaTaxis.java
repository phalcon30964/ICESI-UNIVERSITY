package interfaz;

import java.awt.*;
import javax.swing.*;
import mundo.*;

@SuppressWarnings("serial")
public class InterfazEmpresaTaxis extends JFrame{
	
	private PanelBanner panelBanner;
	
	private PanelTaxi panelTaxiA;
	private PanelTaxi panelTaxiB;
	
	private PanelTotales panelTotales;
	
	private PanelConductor panelConductorAUno;
	private PanelConductor panelConductorBUno;
	private PanelConductor panelConductorBDos;
	
	private PanelOpciones panelOpciones;
	
	private EmpresaTaxis empresa;
	
	public InterfazEmpresaTaxis(){
		setTitle("Gestión de Taxis y Conductores");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		empresa = new EmpresaTaxis();

		panelBanner = new PanelBanner();
		
		panelTaxiA = new PanelTaxi("Taxi A");
		panelTaxiB = new PanelTaxi("Taxi B");
		
		panelTotales = new PanelTotales();
		
		panelConductorAUno = new PanelConductor("Taxi A: Conductor Uno");
		panelConductorBUno = new PanelConductor("Taxi B: Conductor Uno");
		panelConductorBDos = new PanelConductor("Taxi B: Conductor Dos");
		
		panelOpciones = new PanelOpciones(this);
		
		JPanel panArriba = new JPanel();
		panArriba.setLayout(new BorderLayout());
		panArriba.add(panelBanner,BorderLayout.NORTH);
		panArriba.add(panelTaxiA,BorderLayout.WEST);
		panArriba.add(panelTaxiB,BorderLayout.CENTER);
		panArriba.add(panelTotales,BorderLayout.EAST);
				
		JPanel panMedio = new JPanel();
		panMedio.setLayout(new GridLayout(0,3));
		panMedio.add(panelConductorAUno);
		panMedio.add(panelConductorBUno);
		panMedio.add(panelConductorBDos);

		add(panArriba,BorderLayout.NORTH);
		add(panMedio,BorderLayout.CENTER);
		add(panelOpciones,BorderLayout.SOUTH);
		pack();
		
		refrescar();
	}
	
	private void refrescar(){
		panelTaxiA.cambiarPlaca(empresa.darTaxiA().darPlaca());
		panelTaxiA.cambiarModelo(empresa.darTaxiA().darModelo());
		panelTaxiA.cambiarIngresos(empresa.darTaxiA().darIngresos());
		panelTaxiA.cambiarGastos(empresa.darTaxiA().darGastos());

		panelTaxiB.cambiarPlaca(empresa.darTaxiB().darPlaca());
		panelTaxiB.cambiarModelo(empresa.darTaxiB().darModelo());
		panelTaxiB.cambiarIngresos(empresa.darTaxiB().darIngresos());
		panelTaxiB.cambiarGastos(empresa.darTaxiB().darGastos());
		
		panelConductorAUno.cambiarNombre(empresa.darTaxiA().darConductorUno().darNombre());
		panelConductorAUno.cambiarTurno(empresa.darTaxiA().darConductorUno().darTurno());
		panelConductorAUno.cambiarAhorro(empresa.darTaxiA().darConductorUno().darAhorro());
		panelConductorAUno.limpiarRetiro();
		
		panelConductorBUno.cambiarNombre(empresa.darTaxiB().darConductorUno().darNombre());
		panelConductorBUno.cambiarTurno(empresa.darTaxiB().darConductorUno().darTurno());
		panelConductorBUno.cambiarAhorro(empresa.darTaxiB().darConductorUno().darAhorro());
		panelConductorBUno.limpiarRetiro();
		
		panelConductorBDos.cambiarNombre(empresa.darTaxiB().darConductorDos().darNombre());
		panelConductorBDos.cambiarTurno(empresa.darTaxiB().darConductorDos().darTurno());
		panelConductorBDos.cambiarAhorro(empresa.darTaxiB().darConductorDos().darAhorro());
		panelConductorBDos.limpiarRetiro();
		
		panelTotales.cambiarSemana(empresa.darSemanaActual());
		panelTotales.cambiarIngresos(empresa.calcularIngresosTotales());
		panelTotales.cambiarGastos(empresa.calcularGastosTotales());
		panelTotales.cambiarBalance(empresa.calcularBalanceTotal());
		panelTotales.cambiarAhorros(empresa.calcularAhorrosTotales());
	}
	
	private double leerRetiro(PanelConductor panelConductor) throws Exception{
		double retiro=0;
		try{
			String retAU = panelConductor.darRetiro();
			if(!retAU.trim().equals("")){
				retiro = Double.parseDouble(retAU);
			}
		}catch(Exception ex){
			throw new Exception("Si va a retirar debe digitar un valor numérico\nde lo contrario deje el campo vacío");
		}
		return retiro;
	}
	
	public void avanzarSemana(){
		try{
			double retiroAUno=leerRetiro(panelConductorAUno);
			double retiroBUno=leerRetiro(panelConductorBUno);
			double retiroBDos=leerRetiro(panelConductorBDos);
			
			empresa.avanzarSemana(retiroAUno, retiroBUno, retiroBDos);
			refrescar();
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	public static void main(String[] args){
		InterfazEmpresaTaxis ventana = new InterfazEmpresaTaxis();
		ventana.setVisible(true);
	}
}
