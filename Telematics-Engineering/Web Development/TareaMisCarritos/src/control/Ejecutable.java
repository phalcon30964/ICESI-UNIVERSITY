package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InterfaceAddress;
import java.util.Date;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import vista.EditorC;
import vista.EditorP;
import vista.Vista;
import modelo.Carro;
import modelo.CarroLujo;
import modelo.Cliente;
import modelo.Concesionario;
import modelo.Empleado;
import modelo.Persona;

public class Ejecutable {

	private static Concesionario misCarritos;

	private static Vista intefazMisCarritos;

	public static void main(String[] args) {

		misCarritos = new Concesionario();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					intefazMisCarritos = new Vista();
					intefazMisCarritos.setVisible(true);
					escucharBotonAgregar();
					escucharBotonLimpiar();
					actualizarItems();
					escucharBotonRegistrarAuto();
					escucharLimpiarAuto();
					escucharBuscarPersona();
					escucharBuscarAuto();
					escucharCalcularPrecio();
					escucharEditarInformacionPersona();
					escucharEditarInformacionCarro();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void escucharBotonAgregar() {

		intefazMisCarritos.getBtnAgregarPersona().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String nomb = intefazMisCarritos.getTextFieldNombre().getText();
						String apell = intefazMisCarritos.getTextFieldApellido().getText();
						String id = intefazMisCarritos.getTextFieldCedula().getText();
						String tel = intefazMisCarritos.getTextFieldTelefono().getText();
						String dir = intefazMisCarritos.getTextFieldDireccion().getText();
						String ciudad = intefazMisCarritos.getTextFieldCiudad().getText();
						String ultimaV = intefazMisCarritos.getTextFieldUltimaVenta().getText();
						String ultimaC = intefazMisCarritos.getTxtUltimacompra().getText();
						
						if (!nomb.equals("") && !apell.equals("")
								&& !id.equals("") && !tel.equals("")
								&& !dir.equals("") && !ciudad.equals("")) {

							if (!intefazMisCarritos.getChckbxEmpleado().isSelected()) {
								String[] fechaUltComp = ultimaC.split("-");
								Date fechaUC = new Date(Integer.parseInt(fechaUltComp[2]), Integer.parseInt(fechaUltComp[1]), Integer.parseInt(fechaUltComp[0]));
								misCarritos.addCliente(nomb, apell, id, tel,dir, ciudad,fechaUC);
								JOptionPane.showMessageDialog(null,"Se agregó correctamente");
								limpiar();
							} else {
								String comsion = intefazMisCarritos.getTextFieldComision().getText();
								if (!comsion.equals("")) {
									try{
										double comision = Double.parseDouble(comsion);
										String[] fechaUltV = ultimaV.split("-");
										Date fechaV = new Date(Integer.parseInt(fechaUltV[2]), Integer.parseInt(fechaUltV[1]), Integer.parseInt(fechaUltV[0]));

									misCarritos.addEmpleado(nomb, apell, id,tel, dir, comision,fechaV);
									JOptionPane.showMessageDialog(null,"Se agregó correctamente");
									limpiar();
									}catch(Exception e3){
										JOptionPane.showMessageDialog(null,	"Debe Ingresar valores numericos");
									}
									
								} else {
									JOptionPane.showMessageDialog(null,"Algunos campos se encuentran vacios");
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(null,	"Algunos campos se encuentran vacios");
						}
						}
				});
	}

	
	public static void limpiar(){
		intefazMisCarritos.getTextFieldNombre().setText("");
		intefazMisCarritos.getTextFieldApellido().setText("");
		intefazMisCarritos.getTextFieldCedula().setText("");
		intefazMisCarritos.getTextFieldTelefono().setText("");
		intefazMisCarritos.getTextFieldDireccion().setText("");
		intefazMisCarritos.getTextFieldCiudad().setText("");
		intefazMisCarritos.getTextFieldUltimaVenta().setText("");
		intefazMisCarritos.getTxtUltimacompra().setText("");
		intefazMisCarritos.getTextFieldComision().setText("");
	}
	public static void escucharBotonLimpiar() {
		intefazMisCarritos.getBtnLimpiarPersona().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						limpiar();

					}
				});
	}

	public static void escucharBotonRegistrarAuto() {
		intefazMisCarritos.getBtnRegistrarAuto().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = intefazMisCarritos.getTextFieldIdCarro().getText();
						String model = intefazMisCarritos.getTextFieldModelo().getText();
						String costo = intefazMisCarritos.getTextFieldCosto().getText();
						String combus = (String) intefazMisCarritos.getComboBoxCombustible().getSelectedItem();
						String tracc = (String) intefazMisCarritos.getComboBoxTraccion().getSelectedItem();
						String trans = (String) intefazMisCarritos.getComboBoxTransmision().getSelectedItem();
						String accesorios = intefazMisCarritos.getTextFieldAccesorios().getText();

						if (!id.equals("") && !model.equals("")&& !costo.equals("") && !combus.equals("")) {
							try {
								int refer = Integer.parseInt(id);
								int mode = Integer.parseInt(model);
								int cost = Integer.parseInt(costo);
								if (intefazMisCarritos.getChckbxLujo().isSelected()) {
									double impuesto = Double.parseDouble(intefazMisCarritos.getTextFieldImpuesto().getText());
									if (impuesto!=0 && !accesorios.equals("")) {
										misCarritos.addCarroLujo(refer, cost, mode, combus, tracc, trans, impuesto);
										limpiarAuto();
										JOptionPane.showMessageDialog(null,"Se agregó correctamente");
									} else {
										JOptionPane.showMessageDialog(null,"Algunos campos se encuentran vacios del auto de lujo");
									}

								} else {
									misCarritos.addCarro(refer, cost, mode, combus, tracc, trans);
									JOptionPane.showMessageDialog(null,"Se agregó correctamente");
									limpiarAuto();
								}

							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,	"Debe Ingresar valores numericos");
							}
						} else {
							JOptionPane.showMessageDialog(null,	"Algunos campos se encuentran vacios");

						}

					}
				});
	}
	
	public static void limpiarAuto(){
		intefazMisCarritos.getTextFieldIdCarro().setText("");
						intefazMisCarritos.getTextFieldModelo().setText("");
						intefazMisCarritos.getTextFieldCosto().setText("");
						intefazMisCarritos.getTextFieldImpuesto().setText("");
						intefazMisCarritos.getTextFieldAccesorios().setText("");
	}

	public static void escucharLimpiarAuto() {
		intefazMisCarritos.getBtnLimpiarAuto().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarAuto();

					}
				});
	}

	public static void actualizarItems() {
		intefazMisCarritos.getComboBoxCombustible().addItem(misCarritos.COMB_GASOLINA);
		intefazMisCarritos.getComboBoxCombustible().addItem(misCarritos.COMB_DIESEL);
		intefazMisCarritos.getComboBoxTraccion().addItem(misCarritos.TRAC_4X4);
		intefazMisCarritos.getComboBoxTraccion().addItem(misCarritos.TRAC_2X4);
		intefazMisCarritos.getComboBoxTransmision().addItem(misCarritos.MANUAL);
		intefazMisCarritos.getComboBoxTransmision().addItem(misCarritos.AUTOMATICO);

	}
	
	public static void escucharBuscarPersona(){
		intefazMisCarritos.getBtnBuscarPersona().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pers=intefazMisCarritos.getTextFieldConsultarPersona().getText();
				if(!pers.equals("")){
					Persona cont=misCarritos.searchPersona(pers);
					if(cont!=null){
						String mensa="Nombre: "+cont.getNombre()+"\n"+"Apellido: "+cont.getApellido()+"\n"
								+"Cedula: "+cont.getCedula()+"\n"+"Telefono: "+cont.getNumContacto()+"\n"+
								"Dirección: "+cont.getDireccion();
						
						if(cont instanceof Empleado){
							Empleado conAux = (Empleado)cont;
							
							mensa += "\nComision :"+conAux.getComision()+"\nUltimaCompra :"
							         +conAux.getUltimaCompra().toString()+"\nTotalVentas :"+conAux.getTotalVentas();
						}else{
							Cliente conAux1 = (Cliente)cont;
							
							mensa += "\nUltimaCompra :"+conAux1.getUltimaCompra().toString() +"\nCiudadDespacho :"+conAux1.getCiudadDespacho();
						}
						
						intefazMisCarritos.getTextPaneResultadoConsulta().setText(mensa);
								
					}else{
						JOptionPane.showMessageDialog(null,	"El contacto no se encuentra ");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,	"No se ha escrito nada");
				}
				
			}
		});
	}
	
	public static void escucharBuscarAuto(){
		intefazMisCarritos.getBtnBuscarAuto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String auto=intefazMisCarritos.getTextFieldConsultarAuto().getText();
				if(!auto.equals("")){
					try{
					int valor=Integer.parseInt(auto);
					Carro car=misCarritos.searchCarro(valor);
					String men="Referencia :"+car.getNumReferencia()+"\n"+"Modelo: "+car.getModelo()
							+"\n"+"Costo: "+car.getCosto()+"\n"+"Combustible: "+
							car.getTipoCombustion()+"\n"+"Tracción: "+car.getTipoTraccion()+"\n"+"Transmision: "+car.getTipoTransmision();
					
					if(car instanceof CarroLujo){
						CarroLujo aux = (CarroLujo)car;
						men += "\nImpuestos :"+ aux.getImpuestos()+"\nAccesorios :"+aux.getAccesorios();
					}
					
					intefazMisCarritos.getTextPaneResultadoCarro().setText(men);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,	"Debe Ingresar valores numericos");
				}
					
				}
				else{
					JOptionPane.showMessageDialog(null,	"No se ha escrito nada");
				}
				
			}
		});
	}
	
	public static void escucharCalcularPrecio(){
		intefazMisCarritos.getBtnCalcularPrecio().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String auto=intefazMisCarritos.getTextFieldConsultarAuto().getText();
				if(!auto.equals("")){
					try{
					int valor=Integer.parseInt(auto);
					Carro car=misCarritos.searchCarro(valor);
					String men=car.costoTotal()+"";
					
					JOptionPane.showMessageDialog(null,	"El precio total del auto es: "+men);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,	"Debe Ingresar valores numericos");
				}
					
				}
				else{
					JOptionPane.showMessageDialog(null,	"No se ha escrito nada");
				}
			}
		});
	}
	
	public static void escucharEditarInformacionCarro(){
		intefazMisCarritos.getButtonEditarInfoAuto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ref = intefazMisCarritos.getTextFieldConsultarAuto().getText();
				if(!ref.equals("")){
					final Carro cont=misCarritos.searchCarro(Integer.parseInt(ref));
					if(cont!=null){
						try {
							final EditorC dialog = new EditorC(cont.getNumReferencia(), cont.getCosto(), cont.getModelo(), 
									cont.getTipoCombustion(), cont.getTipoTraccion(), cont.getTipoTransmision());
							
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							
							dialog.getOkButton().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									
									int numReferencia = Integer.parseInt(dialog.getTextFieldNumRefEd().getText());
									int costo = Integer.parseInt(dialog.getTextFieldCostoEd().getText());
									int modelo = Integer.parseInt(dialog.getTextFieldModeloEd().getText());
									String tipoCombustion = dialog.getTextFieldTipCombEd().getText();
									String tipoTraccion = dialog.getTextFieldTipTraccEd().getText();
									String tipoTransmision = dialog.getTextFieldTipTrasEd().getText();
									
									cont.setNumReferencia(numReferencia);
									cont.setCosto(costo);
									cont.setModelo(modelo);
									cont.setTipoCombustion(tipoCombustion);
									cont.setTipoTransmision(tipoTransmision);
									cont.setTipoTraccion(tipoTraccion);
					
									dialog.dispose();
									intefazMisCarritos.getTextPaneResultadoCarro().setText("");
									intefazMisCarritos.getTextFieldConsultarAuto().setText("");

									
								}
							});;
							
							dialog.getCancelButton().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									dialog.dispose();
									intefazMisCarritos.getTextPaneResultadoCarro().setText("");
									intefazMisCarritos.getTextFieldConsultarAuto().setText("");
								}
							});
							
						} catch (Exception u) {
							u.printStackTrace();
						}
					}
				
				}else{
					JOptionPane.showMessageDialog(null, "No ha introducido ningun id para editar");
				}

			}
		});
		
		
	}
	
	
	public static void escucharEditarInformacionPersona(){
		intefazMisCarritos.getBtnEditarInfoPersona().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = intefazMisCarritos.getTextFieldConsultarPersona().getText();
				if(!id.equals("")){
					final Persona cont=misCarritos.searchPersona(id);
					if(cont!=null){
						try {
							final EditorP dialog = new EditorP(cont.getNombre(), cont.getApellido(), cont.getCedula(), cont.getNumContacto(), cont.getDireccion());
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							
							dialog.getAceptarButton().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									
									String nom = dialog.getTextFieldNombreEd().getText();
									String ape = dialog.getTextFieldApellidoEd().getText();
									String ced = dialog.getTextFieldCedulaEd().getText();
									String nC = dialog.getTextFieldNumContactoEd().getText();
									String dir = dialog.getTextFieldDireccionEd().getText();
									
									
									cont.setNombre(nom);
									cont.setApellido(ape);
									cont.setCedula(ced);
									cont.setNumContacto(nC);
									cont.setDireccion(dir);
									
									dialog.dispose();
									intefazMisCarritos.getTextPaneResultadoConsulta().setText("");
									intefazMisCarritos.getTextFieldConsultarPersona().setText("");

									
								}
							});;
							
							dialog.getCancelButton().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									dialog.dispose();
									intefazMisCarritos.getTextPaneResultadoConsulta().setText("");
									intefazMisCarritos.getTextFieldConsultarPersona().setText("");
								}
							});
							
						} catch (Exception u) {
							u.printStackTrace();
						}
					}
				
				}else{
					JOptionPane.showMessageDialog(null, "No ha introducido ningun id para editar");
				}

			}
		});
		
		
	}
}
