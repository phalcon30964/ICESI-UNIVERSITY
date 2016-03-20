package interfazRisk;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundoRisk.Jugador;
import mundoRisk.TablaRisk;
import mundoRisk.Territorio;
import TadGrafo.Arista;
import TadLista.ListaDoble;
import TadLista.ListaOrdenada;
import TadTurnos.Turnos;

public class InterfazRisk extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static int JUGADORES_3 = 3;
	public final static int JUGADORES_4 = 4;
	public final static int JUGADORES_5 = 5;
	public final static int JUGADORES_6 = 6;

	public final static String UN_DADO = "1";
	public final static String DOS_DADO = "2";
	public final static String TRES_DADO = "3";

	private JPanel contentPane;
	private JTextField txtNumeroDeJuagadores;
	private JTextField textNombre;
	private JTextField textField_JugadorActual;
	private JTextField textField_TropasUbicadas;
	private JTextField textField_CartasDisponibles;
	private JTextField textField_TropasAUbicar;
	private JTextField textField_Color;
	private JTextField textField_Mision;

	private int x;
	private int y;

	private TablaRisk mundo;
	private Turnos<TablaRisk> turnos;
	private JButton btnAtacar;
	private JButton btnReforzarTropas;
	private JButton btnObtenerTropas;
	private JButton btnCambiarTropas;
	private JButton btnPasarTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		InterfazRisk frame = new InterfazRisk();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public InterfazRisk() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 600);
		setResizable(false);
		setTitle("Juego Risk!! ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(128, 128, 128));
		tabbedPane.setBounds(0, 0, 1144, 580);
		contentPane.add(tabbedPane);

		JPanel Registro = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				Toolkit ambiente = Toolkit.getDefaultToolkit();
				Image img = ambiente.getImage("./data/risk.jpeg");
				g.drawImage(img, 0, 0, 1200, 590, this);
			}
		};
		Registro.setForeground(Color.BLACK);

		tabbedPane.addTab("Registro", null, Registro, null);
		tabbedPane.setDisabledIconAt(0, null);
		Registro.setLayout(null);

		txtNumeroDeJuagadores = new JTextField();
		txtNumeroDeJuagadores.setForeground(Color.WHITE);
		txtNumeroDeJuagadores.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumeroDeJuagadores.setOpaque(false);
		txtNumeroDeJuagadores.setBorder(null);
		txtNumeroDeJuagadores.setEditable(false);
		txtNumeroDeJuagadores.setFont(new Font("Algerian", Font.BOLD, 34));
		txtNumeroDeJuagadores.setText("Numero de Jugadores");
		txtNumeroDeJuagadores.setBounds(211, 31, 435, 34);
		Registro.add(txtNumeroDeJuagadores);
		txtNumeroDeJuagadores.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBackground(Color.LIGHT_GRAY);
		textNombre.setBounds(47, 220, 173, 34);
		Registro.add(textNombre);
		textNombre.setColumns(10);

		String[] listcombox = new String[4];

		listcombox[0] = JUGADORES_3 + "";
		listcombox[1] = JUGADORES_4 + "";
		listcombox[2] = JUGADORES_5 + "";
		listcombox[3] = JUGADORES_6 + "";

		final JComboBox comboBoxNumjugadores = new JComboBox(listcombox);
		comboBoxNumjugadores.setBackground(Color.LIGHT_GRAY);
		comboBoxNumjugadores.setForeground(Color.BLACK);
		comboBoxNumjugadores.setBounds(351, 89, 173, 38);
		Registro.add(comboBoxNumjugadores);

		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setForeground(Color.WHITE);
		lblNewLabelNombre.setFont(new Font("Algerian", Font.BOLD, 38));
		lblNewLabelNombre.setBounds(37, 159, 192, 50);
		Registro.add(lblNewLabelNombre);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBackground(Color.GRAY);
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Algerian", Font.BOLD, 41));
		lblColor.setBounds(629, 157, 204, 52);
		Registro.add(lblColor);

		final String[] listcombox2 = new String[6];

		listcombox2[0] = mundo.NARANJA.toString();
		listcombox2[1] = mundo.NEGRO.toString();
		listcombox2[2] = mundo.ROJO.toString();
		listcombox2[3] = mundo.AMARILLO.toString();
		listcombox2[4] = mundo.ROSADO.toString();
		listcombox2[5] = mundo.AZUL.toString();

		final JComboBox comboBox_Color = new JComboBox(listcombox2);
		comboBox_Color.setBackground(Color.LIGHT_GRAY);
		comboBox_Color.setBounds(639, 215, 157, 39);
		Registro.add(comboBox_Color);

		mundo = new TablaRisk(Integer.parseInt((String)
				comboBoxNumjugadores.getSelectedItem()));
		turnos = new Turnos<TablaRisk>(mundo,mundo.getNumJugadores());


		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Algerian", Font.BOLD, 25));
		btnAgregar.setBounds(332, 481, 192, 63);
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int numJugadores = Integer.parseInt((String) comboBoxNumjugadores.getSelectedItem());
				comboBoxNumjugadores.setEnabled(false);
				String nombre;
				String colorTropas;


				nombre = textNombre.getText();
				colorTropas = (String) comboBox_Color.getSelectedItem();
				comboBox_Color.removeItem(colorTropas);

				try {
					if (!nombre.equals(""))
						mundo.agregarJugador(nombre, colorTropas);
					else
						JOptionPane.showMessageDialog(null, "Ingresar el nombre del jugador", "ERROR",
								JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					textNombre.setText("");
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				textNombre.setText("");
				textNombre.requestFocus(true);
				if (mundo.getJugadores().darLongitud() == numJugadores) {
					btnAtacar.setEnabled(false);
					btnCambiarTropas.setEnabled(false);
					btnObtenerTropas.setEnabled(false);
					btnPasarTurno.setEnabled(false);
					btnReforzarTropas.setEnabled(false);
					actualizarPanelInformacion();
					tabbedPane.setEnabledAt(1, true);
				}
			}
		});
		Registro.add(btnAgregar);

		JPanel Juego = new JPanel();
		tabbedPane.addTab("Juego", null, Juego, null);
		Juego.setLayout(null);
		tabbedPane.setEnabledAt(1, false);

		JPanel panel_Informacion = new JPanel();
		panel_Informacion.setBorder(new TitledBorder(null, "Estadisticas", TitledBorder.LEFT, TitledBorder.TOP, null,
				null));
		panel_Informacion.setBounds(0, 0, 1139, 58);
		Juego.add(panel_Informacion);
		panel_Informacion.setLayout(null);

		textField_JugadorActual = new JTextField();
		textField_JugadorActual.setEditable(false);
		textField_JugadorActual.setBorder(new TitledBorder(null, "Jugador Actual", TitledBorder.LEFT, TitledBorder.TOP,
				null, null));
		textField_JugadorActual.setBounds(78, 14, 146, 36);
		panel_Informacion.add(textField_JugadorActual);
		textField_JugadorActual.setColumns(10);

		textField_TropasUbicadas = new JTextField();
		textField_TropasUbicadas.setBorder(new TitledBorder(null, "Tropas Ubicadas", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		textField_TropasUbicadas.setEditable(false);
		textField_TropasUbicadas.setBounds(234, 14, 146, 36);
		panel_Informacion.add(textField_TropasUbicadas);
		textField_TropasUbicadas.setColumns(10);

		textField_TropasAUbicar = new JTextField();
		textField_TropasAUbicar.setBorder(new TitledBorder(null, "Tropas A Ubicar", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		textField_TropasAUbicar.setEditable(false);
		textField_TropasAUbicar.setBounds(390, 14, 146, 36);
		panel_Informacion.add(textField_TropasAUbicar);
		textField_TropasAUbicar.setColumns(10);

		textField_Color = new JTextField();
		textField_Color.setBorder(new TitledBorder(null, "Color Jugador", TitledBorder.LEFT, TitledBorder.TOP, null,
				null));
		textField_Color.setEditable(false);
		textField_Color.setBounds(554, 14, 146, 36);
		panel_Informacion.add(textField_Color);
		textField_Color.setColumns(10);

		textField_Mision = new JTextField();
		textField_Mision.setBorder(new TitledBorder(null, "Mision a cumplir", TitledBorder.LEFT, TitledBorder.TOP,
				null, null));
		textField_Mision.setEditable(false);
		textField_Mision.setBounds(710, 14, 361, 36);
		panel_Informacion.add(textField_Mision);
		textField_Mision.setColumns(10);

		JPanel panel_Acciones = new JPanel();
		panel_Acciones
		.setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Acciones.setBounds(0, 209, 166, 243);
		Juego.add(panel_Acciones);
		panel_Acciones.setLayout(null);

		btnAtacar = new JButton("Atacar");
		btnAtacar.setFont(new Font("Algerian", Font.PLAIN, 11));
		btnAtacar.setBounds(34, 47, 99, 23);
		btnAtacar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				final JDialog JDialog_Atacar = new JDialog();
				JDialog_Atacar.setBounds(220, 200, 550, 400);
				JDialog_Atacar.setTitle("ATAQUE");
				JDialog_Atacar.getContentPane().setLayout(null);
				JDialog_Atacar.setResizable(false);

				final ImageIcon backgroundImage = new ImageIcon("./data/Atacar.jpg");
				final JPanel mainPanel = new JPanel() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(backgroundImage.getImage(), 0, -200, getWidth() + 200, getHeight() + 200, this);
					}

					@Override
					public Dimension getPreferredSize() {
						Dimension size = super.getPreferredSize();
						size.width = Math.max(backgroundImage.getIconWidth(), size.width);
						size.height = Math.max(backgroundImage.getIconHeight(), size.height);
						return size;
					}

				};
				mainPanel.setLayout(null);
				JDialog_Atacar.getContentPane().add(mainPanel);
				mainPanel.setBounds(0, 0, 550, 400);


				JLabel territorios = new JLabel("Origen del ataque ");
				territorios.setForeground(Color.WHITE);
				territorios.setBounds(16, 50, 210, 25);
				territorios.setFont(new Font("Algerian", Font.BOLD, 18));

				String[] listaTe = new String[mundo.getJugadorActual().getTerritoriosOcupados().darLongitud()];
				for (int i = 0; i < listaTe.length; i++) {
					listaTe[i] = mundo.getJugadorActual().getTerritoriosOcupados().darElemento(i).getNombre();
				}

				ordenarArreglo(listaTe);

				final JComboBox comboBox1 = new JComboBox(listaTe);
				comboBox1.setBounds(110, 80, 140, 22);

				JLabel territorios2 = new JLabel("Destino del ataque");
				territorios2.setForeground(Color.WHITE);
				territorios2.setBounds(16, 110, 210, 25);
				territorios2.setFont(new Font("Algerian", Font.BOLD, 18));

				ListaDoble<Territorio> auxL = mundo.getTerritorios();
				for (int i = 0; i < mundo.getJugadorActual().getTerritoriosOcupados().darLongitud(); i++) {
					try {
						auxL.eliminar(mundo.getJugadorActual().getTerritoriosOcupados().darElemento(i));
					} catch (Exception e) {e.printStackTrace();}
				}

				String[] listaTe2 = new String[auxL.darLongitud()];
				for (int i = 0; i < listaTe2.length; i++) {
					listaTe2[i] = auxL.darElemento(i).getNombre();
				}

				ordenarArreglo(listaTe2);

				final JComboBox comboBox2 = new JComboBox(listaTe2);
				comboBox2.setBounds(110, 140, 140, 22);

				final JPanel PanelDado = new JPanel(){
					{						
						setLayout(null);
						setSize(370, 230);

						final JLabel[] dadoAtacante = new JLabel[3];
						final JLabel[] dadoDefensor = new JLabel[3];
						final JLabel[] ImgResultado = new JLabel[3];

						for (int i = 0; i < 3; i++) {
							dadoAtacante[i]= new JLabel();
							dadoDefensor[i] = new JLabel();
							ImgResultado[i] = new JLabel();
						}

						dadoAtacante[0].setBounds(31, 34, 63, 31);	
						dadoAtacante[1].setBounds(31, 76, 63, 31);
						dadoAtacante[2].setBounds(31, 118, 63, 31);
						add(dadoAtacante[0]);
						add(dadoAtacante[1]);
						add(dadoAtacante[2]);



						ImgResultado[0].setBounds(161, 34, 63, 31);
						ImgResultado[1].setBounds(161, 76, 63, 31);
						ImgResultado[2].setBounds(161, 118, 63, 31);
						add(ImgResultado[0]);
						add(ImgResultado[1]);
						add(ImgResultado[2]);


						dadoDefensor[0].setBounds(264, 34, 63, 31);
						dadoDefensor[1].setBounds(264, 76, 63, 31);
						dadoDefensor[2].setBounds(264, 118, 63, 31);
						add(dadoDefensor[0]);
						add(dadoDefensor[1]);
						add(dadoDefensor[2]);

						JButton btnNewButton = new JButton("Atacar!!");
						btnNewButton.setBounds(383, 118, 91, 23);
						add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub

								int y = 34;
								for (int i = 0; i < dadoAtacante.length; i++) {
									dadoAtacante[i].setBounds(31, y, 63, 31);   
									add(dadoAtacante[i]);
									y+=42;
								}
								int y2 = 34;
								for (int j = 0; j < dadoDefensor.length; j++) {
									dadoDefensor[j].setBounds(264, y2, 63, 31);
									add(dadoDefensor[j]);
									y+=42;
								}

								final String territorioAtacante = (String) comboBox1.getSelectedItem();
								final String territorioDefensor =  (String) comboBox2.getSelectedItem();

								if (mundo.buscarTerritorio(territorioAtacante).getNumTropasOcupandoTerritorio()>1) {
									 int dad1 = mundo.numDadosConLosQueSePuedeAtacar(territorioAtacante);
									System.out.println(dad1 +" numero de dados a tirar el atacante");
									 int dad2 = mundo.numDadosConLosQueSePuedeDefender(territorioDefensor);
									System.out.println(dad2 +" numero de dados a tirar el atacante");
									if (dad1<dad2)
										dad2=dad1;
									
									final int dados1 = dad1;
									final int dados2 = dad2;
									
									try {
										final ListaDoble<ListaOrdenada<Integer> > lista =mundo.tirarDados(territorioAtacante, territorioDefensor, dados1, dados2);
										ImageIcon img3 = new ImageIcon(".\\data\\DadoRojo.gif");
										final Icon icono3 = new ImageIcon( img3.getImage().getScaledInstance(dadoAtacante[0].getWidth(), dadoAtacante[0].getHeight(), Image.SCALE_DEFAULT));

										for (int i = 0; i < dados1; i++) {
											dadoAtacante[i].setIcon(icono3);
										}
										for (int j = 0; j < dados2; j++) {
											dadoDefensor[j].setIcon(icono3);
										}

										new Thread(){
											@Override
											public void run() {
												super.run();
												ImageIcon im = new ImageIcon(".\\data\\Gira.jpg");
												final Icon ico = new ImageIcon( im.getImage().getScaledInstance(dadoAtacante[0].getWidth(), dadoAtacante[0].getHeight(), Image.SCALE_DEFAULT));
												ImgResultado[1].setIcon(ico);
												try {
													sleep(2000);
												} catch (InterruptedException e) {e.printStackTrace();}

												for (int i = 0; i < dados1; i++) {
													System.out.println(lista.darElemento(0).darElemento(i)+" -R , dado del atacante");
													ImageIcon img3 = new ImageIcon(".\\data\\"+lista.darElemento(0).darElemento(i)+"R.png");
													final Icon icono3 = new ImageIcon( img3.getImage().getScaledInstance(dadoAtacante[0].getWidth(), dadoAtacante[0].getHeight(), Image.SCALE_DEFAULT));
													dadoAtacante[i].setIcon(icono3);
												}

												for (int j = 0; j < dados2; j++) {
													System.out.println(lista.darElemento(1).darElemento(j)+" -B , dado del defensor");
													ImageIcon img3 = new ImageIcon(".\\data\\"+lista.darElemento(1).darElemento(j)+"B.png");
													final Icon icono3 = new ImageIcon( img3.getImage().getScaledInstance(dadoDefensor[0].getWidth(), dadoDefensor[0].getHeight(), Image.SCALE_DEFAULT));
													dadoDefensor[j].setIcon(icono3);
												}
												try {
													sleep(500);
												} catch (InterruptedException e1) {e1.printStackTrace();}
												try {
													int[] resul = mundo.atacar(territorioAtacante, territorioDefensor,lista.darElemento(0) ,lista.darElemento(1) );
													
													for (int i = 0; i < resul.length; i++) {
														if(resul[i]>0){
															System.out.println(resul[i] +" resul gano");
															ImageIcon imgf = new ImageIcon(".\\data\\Gana.jpg");
															final Icon icof = new ImageIcon( imgf.getImage().getScaledInstance(dadoAtacante[0].getWidth(), dadoAtacante[0].getHeight(), Image.SCALE_DEFAULT));
															ImgResultado[i].setIcon(icof);
														}
														else{
															System.out.println(resul[i] +" resul perdio");
															ImageIcon imgf = new ImageIcon(".\\data\\Pierde.jpg");
															final Icon icof = new ImageIcon( imgf.getImage().getScaledInstance(dadoAtacante[0].getWidth(), dadoAtacante[0].getHeight(), Image.SCALE_DEFAULT));
															ImgResultado[i].setIcon(icof);
														}
													}
													
													actualizarPanelInformacion();

												} catch (Exception e) {
													JOptionPane.showMessageDialog(null,e.getMessage()+"  ----2","Error",JOptionPane.ERROR_MESSAGE);
												}


											}
										}.start();


									} catch (Exception e2) {
										JOptionPane.showMessageDialog(null, e2.getMessage()+"  ----1","Error", JOptionPane.ERROR_MESSAGE);
									}

								}else{
									JOptionPane.showMessageDialog(null,"No se puede atacar desde el territorio, debe tener mas tropas");
								}
								
							}


						});
					}
					@Override 
					public void paintComponent(Graphics g){ 
						Graphics2D g2 = (Graphics2D) g;//transformar a 2d para permitir transparencia 

						g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
						AlphaComposite old = (AlphaComposite) g2.getComposite(); 
						g2.setComposite(AlphaComposite.SrcOver.derive(new Float(0.3))); 
						g2.setColor(this.getForeground()); //eliges el color de fondo..sigue siendo transparente. 
						g2.fillRoundRect(0, 0,getSize().width-1,getSize().height-1, 10, 10);
						g2.setComposite(old); 
					} 
				};
				PanelDado.setBounds(25, 170, 500, 200);

				mainPanel.add(territorios);
				mainPanel.add(territorios2);
				mainPanel.add(comboBox1);
				mainPanel.add(comboBox2);
				mainPanel.add(PanelDado);
				JDialog_Atacar.setVisible(true);
			}
		});
		panel_Acciones.add(btnAtacar);

		btnReforzarTropas = new JButton("Reforzar Tropas");
		btnReforzarTropas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JDialog JDialog_Reforzar = new JDialog();
				JDialog_Reforzar.setBounds(220, 200, 350, 250);
				JDialog_Reforzar.setTitle("Reforzar Territorios ");
				JDialog_Reforzar.getContentPane().setLayout(null);
				JDialog_Reforzar.setResizable(false);
				JDialog_Reforzar.setVisible(true);

				final ImageIcon backgroundImage = new ImageIcon("./data/Reforzar.jpg");
				JPanel mainPanel = new JPanel() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(backgroundImage.getImage(), -140, -100, getWidth() + 300, getHeight() + 150, this);
					}

					@Override
					public Dimension getPreferredSize() {
						Dimension size = super.getPreferredSize();
						size.width = Math.max(backgroundImage.getIconWidth(), size.width);
						size.height = Math.max(backgroundImage.getIconHeight(), size.height);
						return size;
					}
				};
				mainPanel.setLayout(null);
				JDialog_Reforzar.getContentPane().add(mainPanel);
				mainPanel.setBounds(0, 0, 350, 250);

				JLabel territorio1 = new JLabel("Territorio 1");
				territorio1.setForeground(Color.WHITE);
				territorio1.setBounds(16, 30, 180, 25);
				territorio1.setFont(new Font("Algerian", Font.BOLD, 20));

				String[] listaTerritorios = new String[mundo.getJugadorActual().getTerritoriosOcupados().darLongitud()];
				for (int i = 0; i < listaTerritorios.length; i++) {
					listaTerritorios[i] = mundo.getJugadorActual().getTerritoriosOcupados().darElemento(i).getNombre();
				}
				ordenarArreglo(listaTerritorios);

				final JComboBox comboBox1 = new JComboBox(listaTerritorios);
				comboBox1.setBounds(60, 50, 140, 22);

				final JTextField numTropas = new JTextField();
				numTropas.setBorder(new TitledBorder(null, "# Tropas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
				numTropas.setBounds(200, 75, 120, 40);
				numTropas.setForeground(Color.black);
				numTropas.setBackground(Color.LIGHT_GRAY);

				JLabel territorio2 = new JLabel("Terrtorio 2");
				territorio2.setForeground(Color.WHITE);
				territorio2.setBounds(16, 90, 180, 25);
				territorio2.setFont(new Font("Algerian", Font.BOLD, 20));

				final JComboBox comboBox2 = new JComboBox(listaTerritorios);
				comboBox2.setBounds(60, 120, 140, 22);

				JButton btnReforzar = new JButton("Reforzar");
				btnReforzar.setFont(new Font("Algerian", Font.PLAIN, 11));
				btnReforzar.setBounds(100, 170, 99, 26);
				btnReforzar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						String origen = (String) comboBox1.getSelectedItem();
						String Destino = (String) comboBox2.getSelectedItem();
						int numTro = 0 ;
						try {
							numTro = Integer.parseInt(numTropas.getText());
							try {
								mundo.getJugadorActual().reforzarTropasEnTerritorio(origen, Destino, numTro );
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Error",e2.getMessage(), JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception e2) {							
							JOptionPane.showMessageDialog(null, "Error","Ingrese un numero para la cantidad de tropas a cambiar", JOptionPane.ERROR_MESSAGE);
						}
					}
				});



				mainPanel.add(territorio1);
				mainPanel.add(comboBox1);
				mainPanel.add(numTropas);
				mainPanel.add(territorio2);
				mainPanel.add(comboBox2);
				mainPanel.add(btnReforzar);				

			}

		});
		btnReforzarTropas.setFont(new Font("Algerian", Font.PLAIN, 11));
		btnReforzarTropas.setBounds(10, 154, 146, 23);
		panel_Acciones.add(btnReforzarTropas);

		btnObtenerTropas = new JButton("canjear cartas");
		btnObtenerTropas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					mundo.canjearCartasPorTropas(textField_JugadorActual.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);

				}

			}

		});
		btnObtenerTropas.setFont(new Font("Algerian", Font.PLAIN, 11));
		btnObtenerTropas.setBounds(10, 120, 146, 23);
		panel_Acciones.add(btnObtenerTropas);

		btnCambiarTropas = new JButton("Cambiar Tropas");
		btnCambiarTropas.setFont(new Font("Algerian", Font.PLAIN, 11));
		btnCambiarTropas.setBounds(10, 86, 146, 23);
		panel_Acciones.add(btnCambiarTropas);
		btnCambiarTropas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog JDialogCambiarTropas = new JDialog();

				JDialogCambiarTropas.setTitle("Cambiar Tropas");
				JDialogCambiarTropas.getContentPane().setLayout(null);
				JDialogCambiarTropas.setBounds(100, 100, 450, 243);
				JDialogCambiarTropas.setResizable(false);
				JDialogCambiarTropas.setVisible(true);

				final ImageIcon backgroundImage = new ImageIcon("./data/CambiarTropas.jpg");
				JPanel mainPanel = new JPanel() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
					}

					@Override
					public Dimension getPreferredSize() {
						Dimension size = super.getPreferredSize();
						size.width = Math.max(backgroundImage.getIconWidth(), size.width);
						size.height = Math.max(backgroundImage.getIconHeight(), size.height);
						return size;
					}
				};

				mainPanel.setLayout(null);
				JDialogCambiarTropas.getContentPane().add(mainPanel);
				mainPanel.setBounds(0, 0, 450, 215);

				String[] listaTerritorios = new String[mundo.getTerritorios().darLongitud()];
				for (int i = 0; i < listaTerritorios.length; i++) {
					listaTerritorios[i] = mundo.getTerritorios().darElemento(i).getNombre();
				}

				JComboBox comboBox = new JComboBox(listaTerritorios);
				comboBox.setBounds(40, 56, 136, 22);
				mainPanel.add(comboBox);

				JLabel lblNewLabel = new JLabel("Territorio A Cambiar");
				lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 15));
				lblNewLabel.setBounds(10, 11, 198, 31);
				mainPanel.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("Tipo de Tropa a Cambiar");
				lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 15));
				lblNewLabel_1.setBounds(218, 8, 222, 37);
				mainPanel.add(lblNewLabel_1);

				String[] listaTerritorios2 = {"Soldados" , "Caballos", "Artilleria"};

				JComboBox comboBox_1 = new JComboBox(listaTerritorios2);
				comboBox_1.setBounds(285, 56, 96, 22);
				mainPanel.add(comboBox_1);

				JButton btnNewButton = new JButton("Cambiar");
				btnNewButton.setBounds(183, 144, 91, 37);
				btnNewButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {


					}
				});
				mainPanel.add(btnNewButton);

			}
		});

		btnPasarTurno = new JButton("Pasar Turno");

		btnPasarTurno.setBounds(10, 188, 146, 23);
		btnPasarTurno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mundo.pasarTurno();
					guardarTurno();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				actualizarPanelInformacion();
			}
		});
		panel_Acciones.add(btnPasarTurno);
		btnPasarTurno.setFont(new Font("Algerian", Font.PLAIN, 11));

		JPanel panel_Map = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				Toolkit ambiente = Toolkit.getDefaultToolkit();
				Image img = ambiente.getImage("./data/Map.png");
				g.drawImage(img, 3, 0, 971, 486, this);


				// ////////////////

				//				Toolkit solIm = Toolkit.getDefaultToolkit();
				//				Toolkit cañ = Toolkit.getDefaultToolkit();
				//				Toolkit cab = Toolkit.getDefaultToolkit();
				//				
				//				/** 5- 12
				//				 */	
				//				g.fillArc(870, 132, 15, 15, 0, 360);
				//				g.setColor(Color.WHITE);
				//				g.drawString("5", 876, 144);
				//				
				//				g.setColor(Color.black);
				//				g.fillArc(879,142, 15, 15, 0, 360);
				//				g.setColor(Color.WHITE);
				//				g.drawString("6", 884, 154);
				//				
				//				g.setColor(Color.black);
				//				g.fillArc(894, 144, 15, 15, 0, 360);
				//				g.setColor(Color.WHITE);
				//				g.drawString("6", 900, 156);
				//				/**
				//				 */
				//				Image draw = solIm.getImage("./data/SoldadoRojo.png");
				//				g.drawImage(draw, 860, 146, 30, 30, this);						
				//				/**17 - 10
				//				 * 9 -10    6-12
				//				 */
				//				Image cañon2 = cañ.getImage("./data/CañonRojo.png");	
				//				g.drawImage(cañon2, 877, 156 , 20, 20, this);				
				//				/**19-0
				//				 * 15-2   6- 12
				//				 */
				//				Image caballo2 = cab.getImage("./data/CaballoRojo.png");
				//				g.drawImage(caballo2, 896, 156, 20, 20, this);
				// //////////////

				try {
					Territorio territorio = mundo.buscarTerritorio("Alaska");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(40, 40, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 43, 53);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(52, 45, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1,  56, 56);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(70, 45, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 74, 58);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;


						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 20, 44, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 20, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 20, 44, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 20, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 20, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 20, 44, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 40, 60, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 60, 60, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Territorios del Noroeste");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(128, 40, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 134, 53);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(138,45, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 143, 58);
						}

						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(159, 45, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 164, 58);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);


						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 111, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:

							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 111, 44, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:

							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 111, 44, 30, 30, this);				
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:

							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 111, 44, 30, 30, this);			
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:

							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 111, 44, 30, 30, this);			
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:

							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 111, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 133, 58, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 154, 56, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Alberta");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(107, 70, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 112, 80);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(118,81, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 124, 93);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(134, 78, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 140, 92);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);


						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 95, 80, 30, 30, this);				
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:

							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 95, 80, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:

							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 95, 80, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:

							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 95, 80, 30, 30, this);				
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:

							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 95, 80, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:

							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 95, 80, 30, 30, this);				
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 115, 94, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 134, 87, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Ontario");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(183, 78, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 188, 88);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(191,84, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 197, 96);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(205, 88, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 210, 98);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 166, 88, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 166, 88, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 166, 88, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 166, 88, 30, 30, this);						
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 166, 88, 30, 30, this);					
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 166, 88, 30, 30, this);					
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 183, 97, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 200, 99, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Quebec");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(246, 60, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 251, 72);
						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(255,70, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 261, 82);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(270, 72, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 276, 84);
							g.setColor(Color.black);
						}

						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;


						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 233, 73, 30, 30, this);					
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 233, 73, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 233, 73, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 233, 73, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 233, 73, 30, 30, this);						
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 233, 73, 30, 30, this);						
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 250, 83, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 269, 83, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}
				try {
					Territorio territorio = mundo.buscarTerritorio("Groenlandia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(342, 7, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 347, 19);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(351,17, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 357, 29);
						}

						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(366, 19, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 372, 31);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);


						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 333, 18, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 333, 18, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 333, 18, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 333, 18, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 333, 18, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 333, 18, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 350, 28, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 369, 28, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Estados Unidos del Este");
					if (territorio.getTropas()[0] != 0) {

						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(87, 114, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 92, 126);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(96,124, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 102, 136);
						}

						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(111, 126, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 117, 138);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;


						switch (territorio.getPropietario().getColorTropas()) {

						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 77, 125, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 77, 125, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 77, 125, 30, 30, this);
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 77, 125, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 77, 125, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 77, 125, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 94, 135, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 113, 135, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				/***
				 */////---------------------Ejemplo --------------------/////
				/**/
				try {
					Territorio territorio = mundo.buscarTerritorio("Estados Unidos del Oeste");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(168, 133, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 173, 145);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(177,143, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 183, 155);
						}

						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(192, 145, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 198, 157);
							g.setColor(Color.black);
						}

						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 156, 144, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 156, 144, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 156, 144, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 156, 144, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 156, 144, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 156, 144, 30, 30, this);
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 173, 154, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 192, 154, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("México");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(112, 190, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 117, 202);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(121,200, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 127, 212);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(136, 202, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 142, 214);
							g.setColor(Color.black);
						}

						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 101, 200, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 118, 210, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 137, 210, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				/// America de sur 
				try {
					Territorio territorio = mundo.buscarTerritorio("Venezuela");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(197, 233, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 200, 245);
						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(206,243, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 212, 255);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(221, 245, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 227, 257);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 189, 244, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 206, 254, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 225, 254, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Brasil");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(270, 296, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 275, 308);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(279,306, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 285, 318);
						}

						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(294, 308, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 300, 320);
							g.setColor(Color.black);
						}

						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 259, 306, 30, 30, this);									

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 273, 316, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 292, 316, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Perú");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(199, 298, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 204, 310);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(208,308, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 214, 320);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(223, 310, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 229, 322);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);


						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:
							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:
							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:
							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:
							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:
							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 188, 310, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 205, 320, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 224, 320, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Argentina");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(231, 393, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 236, 405);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(240,403, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 246, 415);
						}
						if (territorio.getTropas()[1] != 0){

							g.setColor(Color.black);
							g.fillArc(255, 405, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 261, 417);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);	
							}
							if (territorio.getTropas()[2] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:

							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:

							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:

							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:

							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:

							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 220, 402, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 237, 412, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 256, 412, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				//////// ------- Europa -----------

				try {
					Territorio territorio = mundo.buscarTerritorio("Islandia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(389, 20, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 394, 32);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(403,30, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 409, 42);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(418, 32, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 424, 44);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:

							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:

							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:

							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:

							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:

							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 382, 35, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 399, 45, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 418, 45, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Gran Bretaña");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(400, 75, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 405, 87);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(409,85, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 415, 97);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(425, 87, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 430, 99);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);


						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 392, 85, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 409, 95, 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 428, 95, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Europa Occidental");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(414, 115, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 419, 127);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(423,125, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 429, 137);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(438, 127, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 444, 139);
							g.setColor(Color.black);

						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[2] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[2] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 403, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 420, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 439, 138, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Europa del Sur");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(483, 118, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 488, 130);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(492,128, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 498, 140);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(507, 130, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 513, 142);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 474, 128, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 491, 138, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 503, 138, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Europa del Norte");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(474, 74, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 479, 86);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(483,84, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 489, 96);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(498, 86, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 504, 98);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 464, 85, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 481, 95, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 500, 95, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Escandinavia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(481, 18, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 485, 30);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(490,28, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 495, 40);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(505, 30, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 506, 42);
							g.setColor(Color.black);
						}

						g.setColor(Color.black);
						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 468, 34, 30, 30, this);					

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 485, 44, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 504, 44, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Ucrania");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(552, 59, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 558, 71);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(568,69, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 574, 81);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(583, 71, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 589, 83);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 540, 70, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 557, 80, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 576, 80, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}
				///// ------------ Africa ---------
				try {
					Territorio territorio = mundo.buscarTerritorio("África del Norte");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(425, 179, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 431, 191);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(434,189, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 440, 201);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(449, 191, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 455, 203);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 412, 195, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 429, 205, 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 448, 205, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Egipto");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(501, 158, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 506, 170);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(510,168, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 515, 180);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(525, 170, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 530, 182);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}

							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 488, 172, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 505, 182, 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 524, 182, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Congo");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(497, 260, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 502, 272);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(506,270, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 512, 282);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(521, 272, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 527, 284);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 486, 275, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 503, 285, 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 522, 285, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Sudáfrica");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(506, 340, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 511, 352);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(515,350, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 521, 362);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(530, 352, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 536, 364);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 495, 355, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 512, 365 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 531, 365, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Madagascar");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(598, 328, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 604, 340);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(607,338, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 613, 350);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(622, 340, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 628, 352);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:


							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 587, 341, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 604, 351 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 620, 351, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("África Oriental");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(573, 226, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 579, 238);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(582,236, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 588, 248);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(597, 238, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 603, 250);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 561, 244, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 578, 256 , 20, 20, this);			
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 597, 256, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				//////---------------- Austria ---------

				try {
					Territorio territorio = mundo.buscarTerritorio("Indonesia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(805, 256, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 811, 268);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(822,266, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 828, 278);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(837, 268, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 843, 280);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 793, 271, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 810, 281 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 829, 281, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Nueva Guinea");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(902, 264, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 908, 276);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(911,274, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 917, 286);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(926, 276, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 932, 288);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 891, 276, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 908, 286 , 20, 20, this);						
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 927, 286, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Australia Oriental");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(893, 350, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 899, 362);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(902,360, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 908, 372);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(917, 362, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 923, 374);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 883, 359, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 900, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 919, 369, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Australia Occidental");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(801, 350, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 807, 362);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(810,360, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 816, 372);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(825, 362, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 831, 374);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 789, 359, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 806, 369 , 20, 20, this);					
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 821, 369, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				///// --------- Asia -----------


				try {
					Territorio territorio = mundo.buscarTerritorio("Siam");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(765, 213, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 771, 225);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(774,223, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 780, 235);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(789, 225, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 795, 237);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 755, 222, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this)	;	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 755, 222, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this)		;
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 755, 222, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this)		;
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 755, 222, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this)	;	
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 755, 222, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 755, 222, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 770, 232 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 785, 232, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("India");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(669, 185, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 675, 197);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(678,195, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 684, 207);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(693, 197, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 698, 209);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:



							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:



							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 659, 198, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 676, 208 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 695, 208, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Oriente Medio");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(577, 161, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 583, 173);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(586,171, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 592, 183);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(601, 173, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 607, 187);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 601, 184, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:




							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 601, 184, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:




							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 601, 184, 20, 0, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 601, 184, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:



							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 601, 184, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:



							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 565, 174, 30, 30, this);

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 582, 184 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 601, 184, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Afganistán");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(617, 109, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 623, 121);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(626,119, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 632, 131);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(641, 121, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 647, 133);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 607, 120, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 624, 130 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 643, 130, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}
				try {
					Territorio territorio = mundo.buscarTerritorio("China");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(737, 144, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 744, 156);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(754,154, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 760, 166);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(769, 156, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 775, 168);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 727, 153, 30, 30, this);	

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 744, 164 , 20, 20, this);				
							}
							if (territorio.getTropas()[1] != 0){
								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 764, 164, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Mongolia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";

						g.fillArc(752, 104, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 758, 116);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(761,114, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 767, 126);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(776, 116, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 782, 128);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 740, 114, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 757, 124 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 776, 124, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Ural");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(618, 46, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 624, 58);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(627,56, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 633, 68);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(642, 58, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 648, 70);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 607, 57, 30, 30, this);		

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 624, 67 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 644, 67, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}



				try {
					Territorio territorio = mundo.buscarTerritorio("Siberia");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(673, 36, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 679, 48);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(682,46, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 688, 58);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(697, 48, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 703, 60);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 666, 44, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 683, 54 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 702, 54, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Irkutsk");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(747, 68, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 751, 80);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(756,78, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 762, 90);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(771, 80, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 777, 92);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 736, 75, 30, 30, this);			

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 753, 85 , 20, 20, this);		
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 772, 85, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}

				try {
					Territorio territorio = mundo.buscarTerritorio("Yakutsk");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(759, 18, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 763, 30);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(768,28, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 774, 40);
						}
						if (territorio.getTropas()[1] != 0){
							g.setColor(Color.black);
							g.fillArc(783, 30, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 789, 42);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				
							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 748, 29, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 765, 39 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 784, 39, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Kamchatka");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(863, 37, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 869, 49);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(872,47, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 878, 59);
						}
						if (territorio.getTropas()[1] != 0){

							g.setColor(Color.black);
							g.fillArc(887, 47, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 893, 59);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 851, 48, 30, 30, this);				

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 868, 58 , 20, 20, this);
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 887, 58, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				try {
					Territorio territorio = mundo.buscarTerritorio("Japón");
					if (territorio.getTropas()[0] != 0) {
						Toolkit drawIm  = Toolkit.getDefaultToolkit();
						Toolkit cañon = Toolkit.getDefaultToolkit();
						Toolkit caballo = Toolkit.getDefaultToolkit();

						String num0 = territorio.getTropas()[0] + "";		
						String num1 = territorio.getTropas()[2] + "";
						String num2 = territorio.getTropas()[1] + "";


						g.fillArc(870, 132, 15, 15, 0, 360);
						g.setColor(Color.WHITE);
						g.drawString(num0, 876, 144);

						if (territorio.getTropas()[2] != 0){
							g.setColor(Color.black);
							g.fillArc(879,142, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num1, 884, 154);
						}
						if (territorio.getTropas()[1] != 0){

							g.setColor(Color.black);
							g.fillArc(894, 144, 15, 15, 0, 360);
							g.setColor(Color.WHITE);
							g.drawString(num2, 900, 156);
							g.setColor(Color.black);
						}
						g.setColor(Color.black);

						Image draw;
						Image cañon2;
						Image caballo2;

						switch (territorio.getPropietario().getColorTropas()) {
						case TablaRisk.ROJO:

							draw = drawIm.getImage("./data/SoldadoRojo.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRojo.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRojo.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						case TablaRisk.AMARILLO:



							draw = drawIm.getImage("./data/SoldadoAmarillo.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAmarillo.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAmarillo.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						case TablaRisk.AZUL:


							draw = drawIm.getImage("./data/SoldadoAzul.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonAzul.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoAzul.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						case TablaRisk.NARANJA:


							draw = drawIm.getImage("./data/SoldadoNaranja.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNaranja.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNaranja.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						case TablaRisk.NEGRO:


							draw = drawIm.getImage("./data/SoldadoNegro.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						


							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonNegro.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoNegro.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						case TablaRisk.ROSADO:


							draw = drawIm.getImage("./data/SoldadoRosado.png");
							g.drawImage(draw, 860, 146, 30, 30, this);						

							if (territorio.getTropas()[2] != 0){
								cañon2 = cañon.getImage("./data/CañonRosado.png");
								g.drawImage(cañon2, 877, 156 , 20, 20, this);	
							}
							if (territorio.getTropas()[1] != 0){

								caballo2 = caballo.getImage("./data/CaballoRosado.png");
								g.drawImage(caballo2, 896, 156, 20, 20, this);
							}
							break;
						}

					}
				} catch (Exception e) {
				}


				// Norte America y Central
				if (x >= 24 && x < 88 && y >= 48 && y < 75) {
					int x1[] = { 54, 50, 76 };
					int y1[] = { 42, 64, 52 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(55, 24, 110, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Alaska", 76, 42);
				} else if (x >= 115 && x < 192 && y >= 48 && y < 73) {
					int x1[] = { 145, 141, 167 };
					int y1[] = { 42, 64, 52 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(146, 24, 160, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Territorios del Noroeste", 157, 42);

				} else if (x >= 90 && x < 156 && y >= 74 && y < 108) {
					int x1[] = { 119, 114, 142 };
					int y1[] = { 60, 94, 85 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(120, 57, 110, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Alberta", 141, 75);

				} else if (x >= 170 && x < 213 && y >= 84 && y < 111) {
					int x1[] = { 190, 208, 188 };
					int y1[] = { 76, 89, 97 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(191, 62, 110, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Ontario", 212, 80);

				} else if (x >= 82 && x < 134 && y >= 110 && y < 151) {
					int x1[] = { 106, 123, 101 };
					int y1[] = { 114, 128, 133 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(107, 99, 155, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Estados Unidos del Este", 120, 117);

				} else if (x >= 77 && x < 134 && y >= 190 && y < 238) {
					int x1[] = { 121, 136, 117 };
					int y1[] = { 191, 203, 208 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(122, 174, 80, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("México", 140, 192);
				} else if (x >= 229 && x < 271 && y >= 80 && y < 115) {

					int x1[] = { 251, 266, 247 };
					int y1[] = { 78, 90, 94 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(251, 62, 80, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Quebec", 272, 80);

				} else if (x >= 159 && x < 214 && y >= 116 && y < 168) {
					int x1[] = { 176, 188, 175 };
					int y1[] = { 123, 138, 144 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(176, 109, 160, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Estados Unidos del Oeste", 190, 127);

				} else if (x >= 321 && x < 397 && y >= 18 && y < 46) {
					int x1[] = { 349, 362, 345 };
					int y1[] = { 15, 28, 36 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(349, 0, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Groenlandia", 364, 18);
				}
				// ----------- America Del Sur ------////
				else if (x >= 191 && x < 247 && y >= 240 && y < 286) {
					int x1[] = { 219, 235, 217 };
					int y1[] = { 237, 248, 255 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(220, 220, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Venezuela", 235, 238);

				} else if (x >= 187 && x < 249 && y >= 319 && y < 364) {
					int x1[] = { 229, 242, 229 };
					int y1[] = { 319, 329, 334 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(230, 301, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Perú", 245, 319);

				} else if (x >= 251 && x < 312 && y >= 296 && y < 329) {
					int x1[] = { 272, 289, 270 };
					int y1[] = { 299, 311, 317 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(272, 282, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Brasil", 287, 300);

				} else if (x >= 216 && x < 266 && y >= 383 && y < 416) {
					int x1[] = { 240, 252, 236 };
					int y1[] = { 376, 386, 393 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(239, 358, 90, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Argentina", 254, 376);
				}

				// / ------------ Europa -------------
				else if (x >= 389 && x < 421 && y >= 49 && y < 76) {
					// 2
					int x1[] = { 403, 418, 403 };
					int y1[] = { 37, 47, 54 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(404, 20, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Islandia", 419, 38);

				} else if (x >= 419 && x < 445 && y >= 81 && y < 105) {
					// 1
					int x1[] = { 435, 446, 432 };
					int y1[] = { 72, 80, 88 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(435, 53, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Gran Bretaña", 450, 71);

				} else if (x >= 419 && x < 461 && y >= 115 && y < 145) {
					// 7
					int x1[] = { 450, 462, 447 };
					int y1[] = { 109, 117, 124 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(449, 89, 120, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Europa Occidental", 464, 107);

				} else if (x >= 464 && x < 519 && y >= 52 && y < 74) {
					// 4
					int x1[] = { 489, 505, 486 };
					int y1[] = { 38, 46, 53 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(489, 19, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Escandinavia", 504, 37);

				} else if (x >= 462 && x < 500 && y >= 90 && y < 110) {
					// 3
					int x1[] = { 486, 495, 481 };
					int y1[] = { 76, 86, 95 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(484, 60, 120, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Europa del Norte", 499, 78);

				} else if (x >= 484 && x < 528 && y >= 126 && y < 148) {
					// 5
					int x1[] = { 512, 526, 511 };
					int y1[] = { 102, 115, 121 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(512, 88, 120, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Europa del Sur", 527, 106);

				} else if (x >= 517 && x < 577 && y >= 69 && y < 105) {
					// 6
					int x1[] = { 550, 563, 548 };
					int y1[] = { 68, 78, 84 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(550, 49, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Ucrania", 565, 67);
				}
				// /// -------------- Africa _-----------
				else if (x >= 494 && x < 534 && y >= 257 && y < 299) {
					// 1
					int x1[] = { 512, 524, 512 };
					int y1[] = { 257, 268, 274 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(512, 240, 80, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Congo", 527, 258);

				} else if (x >= 552 && x < 598 && y >= 235 && y < 272) {
					// 2
					int x1[] = { 577, 587, 573 };
					int y1[] = { 230, 240, 245 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(576, 212, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("África Oriental", 591, 230);
				} else if (x >= 455 && x < 535 && y >= 167 && y < 199) {
					// 3
					int x1[] = { 513, 525, 513 };
					int y1[] = { 162, 171, 177 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(513, 143, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Egipto", 528, 161);
				} else if (x >= 582 && x < 602 && y >= 332 && y < 364) {
					// 4
					int x1[] = { 596, 607, 593 };
					int y1[] = { 320, 334, 341 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(596, 306, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Madagascar", 611, 324);
				} else if (x >= 408 && x < 464 && y >= 189 && y < 234) {
					// 5
					int x1[] = { 439, 451, 440 };
					int y1[] = { 192, 204, 211 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(440, 176, 130, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Africa del Norte", 455, 194);
				} else if (x >= 492 && x < 540 && y >= 328 && y < 368) {
					// 6
					int x1[] = { 516, 527, 517 };
					int y1[] = { 329, 338, 347 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(517, 310, 100, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Sudáfrica", 532, 328);

				}
				// // ---------------- Australia -------------
				else if (x >= 888 && x < 929 && y >= 346 && y < 386) {
					// 1
					int x1[] = { 899, 916, 907 };
					int y1[] = { 359, 359, 371 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(860, 331, 110, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Australia Oriental", 868, 349);

				} else if (x >= 800 && x < 831 && y >= 260 && y < 289) {
					// 2
					int x1[] = { 815, 826, 813 };
					int y1[] = { 262, 269, 277 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(815, 241, 110, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Indonesia", 830, 259);

				} else if (x >= 893 && x < 926 && y >= 285 && y < 309) {
					// 3
					int x1[] = { 898, 914, 907 };
					int y1[] = { 289, 290, 296 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(874, 261, 90, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Nueva Guinea", 884, 279);

				} else if (x >= 808 && x < 853 && y >= 362 && y < 390) {
					// 4
					int x1[] = { 830, 841, 831 };
					int y1[] = { 356, 362, 370 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(831, 334, 128, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Australia Occidental", 842, 352);
				}

				// /// ------------------- Asia ----------------
				else if (x >= 611 && x < 665 && y >= 105 && y < 140) {
					// 1
					int x1[] = { 637, 650, 638 };
					int y1[] = { 105, 112, 121 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(638, 84, 90, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Afganistán", 650, 102);

				} else if (x >= 725 && x < 795 && y >= 145 && y < 181) {
					// 2
					int x1[] = { 760, 770, 761 };
					int y1[] = { 146, 157, 163 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(760, 127, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("China", 775, 145);

				} else if (x >= 654 && x < 724 && y >= 159 && y < 212) {
					// 3
					int x1[] = { 694, 707, 695 };
					int y1[] = { 176, 186, 195 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(695, 158, 65, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("India", 710, 176);

				} else if (x >= 731 && x < 778 && y >= 77 && y < 103) {
					// 4
					int x1[] = { 758, 772, 759 };
					int y1[] = { 73, 83, 88 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(760, 55, 65, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Irkutsk", 775, 73);

				} else if (x >= 868 && x < 892 && y >= 139 && y < 161) {
					// 5
					int x1[] = { 886, 894, 885 };
					int y1[] = { 132, 139, 148 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(886, 111, 65, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Japon", 901, 129);

				} else if (x >= 841 && x < 884 && y >= 51 && y < 72) {
					// 6
					int x1[] = { 855, 867, 852 };
					int y1[] = { 36, 45, 53 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(854, 18, 90, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Kamchatka", 869, 38);

				} else if (x >= 559 && x < 605 && y >= 145 && y < 185) {
					// 7
					int x1[] = { 579, 590, 578 };
					int y1[] = { 144, 152, 160 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(579, 124, 120, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Oriente Medio", 594, 142);

				} else if (x >= 743 && x < 793 && y >= 108 && y < 136) {
					// 8
					int x1[] = { 768, 781, 769 };
					int y1[] = { 103, 112, 120 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(769, 84, 90, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Mongolia", 784, 102);

				} else if (x >= 751 && x < 791 && y >= 211 && y < 234) {
					// 9
					int x1[] = { 780, 790, 780 };
					int y1[] = { 201, 212, 223 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(780, 184, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Siam", 795, 202);

				} else if (x >= 654 && x < 704 && y >= 41 && y < 70) {
					// 10
					int x1[] = { 690, 703, 689 };
					int y1[] = { 38, 46, 56 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(690, 18, 70, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Siberia", 705, 38);

				} else if (x >= 609 && x < 652 && y >= 54 && y < 89) {
					// 11
					int x1[] = { 635, 648, 634 };
					int y1[] = { 51, 60, 68 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(635, 32, 60, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Ural", 650, 50);

				} else if (x >= 732 && x < 808 && y >= 34 && y < 68) {
					// 12
					int x1[] = { 768, 780, 767 };
					int y1[] = { 35, 44, 52 };

					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(768, 16, 80, 29, 12, 10);
					g.fillPolygon(x1, y1, 3);

					g.setColor(Color.black);
					g.setFont(new Font("Tohama", Font.BOLD, 12));
					g.drawString("Yakutsk", 783, 34);

				}
			}

		};
		panel_Map.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
//				System.out.println(x + ", " + y)
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		panel_Map.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e){
				System.err.println(mundo.getEtapaJuego());
				x = e.getX();
				y = e.getY();

				// Norte America y Central
				if (x >= 24 && x < 88 && y >= 48 && y < 75) {
					// Alaska
					Territorio terri = mundo.buscarTerritorio("Alaska");
					System.err.println(mundo.getJugadorActual().getNombre());
					try {
						System.err.println(terri.getPropietario().getNombre());
					} catch (Exception e2) {
						// TODO: handle exception
					}

					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Alaska");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alaska",1);
						mundo.buscarTerritorio("Alaska").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alaska", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alaska", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 115 && x < 192 && y >= 48 && y < 73) {
					// North West Territory
					Territorio terri = mundo.buscarTerritorio("Territorios del Noroeste");

					System.err.println(mundo.getJugadorActual().getNombre());
					try {
						System.err.println(terri.getPropietario().getNombre());
					} catch (Exception e2) {
						// TODO: handle exception
					}

					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Territorios del Noroeste");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Territorios del Noroeste",1);
						mundo.buscarTerritorio("Territorios del Noroeste").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Territorios del Noroeste", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Territorios del Noroeste", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				} else if (x >= 90 && x < 156 && y >= 74 && y < 108) {
					// Alberta
					Territorio terri = mundo.buscarTerritorio("Alberta");

					System.err.println(mundo.getJugadorActual().getNombre());
					try {
						System.err.println(terri.getPropietario().getNombre());
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Alberta");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alberta",1);
						mundo.buscarTerritorio("Alberta").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alberta", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Alberta", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				} else if (x >= 170 && x < 213 && y >= 84 && y < 111) {
					// Ontario
					Territorio terri = mundo.buscarTerritorio("Ontario");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Ontario");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ontario",1);
						mundo.buscarTerritorio("Ontario").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ontario", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ontario", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				} else if (x >= 82 && x < 134 && y >= 110 && y < 151) {
					// Western United States
					Territorio terri = mundo.buscarTerritorio("Estados Unidos del Este");

					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Estados Unidos del Este");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Este",1);
						mundo.buscarTerritorio("Estados Unidos del Este").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Este", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Este", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				} else if (x >= 77 && x < 134 && y >= 190 && y < 238) {
					// Central America
					Territorio terri = mundo.buscarTerritorio("México");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "México");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "México",1);
						mundo.buscarTerritorio("México").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "México", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "México", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				} else if (x >= 229 && x < 271 && y >= 80 && y < 115) {
					// Quebec
					Territorio terri = mundo.buscarTerritorio("Quebec");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Quebec");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Quebec",1);
						mundo.buscarTerritorio("Quebec").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Quebec", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Quebec", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 159 && x < 214 && y >= 116 && y < 168) {
					// Eastern United States
					Territorio terri = mundo.buscarTerritorio("Estados Unidos del Oeste");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Estados Unidos del Oeste");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Oeste",1);
						mundo.buscarTerritorio("Estados Unidos del Oeste").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Oeste", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Estados Unidos del Oeste", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 321 && x < 397 && y >= 18 && y < 46) {
					// Greenland
					Territorio terri = mundo.buscarTerritorio("Groenlandia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Groenlandia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Groenlandia",1);
						mundo.buscarTerritorio("Groenlandia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Groenlandia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Groenlandia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}
				}

				// ----------- America Del Sur ------////
				else if (x >= 191 && x < 247 && y >= 240 && y < 286) {
					// Venezuela
					Territorio terri = mundo.buscarTerritorio("Venezuela");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						System.err.println();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Venezuela");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Venezuela",1);
						mundo.buscarTerritorio("Venezuela").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Venezuela", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Venezuela", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 187 && x < 249 && y >= 319 && y < 364) {
					// Perú
					Territorio terri = mundo.buscarTerritorio("Perú");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Perú");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Perú",1);
						mundo.buscarTerritorio("Perú").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Perú", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Perú", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 251 && x < 312 && y >= 296 && y < 329) {
					// Brasil
					Territorio terri = mundo.buscarTerritorio("Brasil");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Brasil");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Brasil",1);
						mundo.buscarTerritorio("Brasil").setPropietario(mundo.getJugadorActual());
						
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Brasil", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Brasil", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 216 && x < 266 && y >= 383 && y < 416) {
					// Argentina
					Territorio terri = mundo.buscarTerritorio("Argentina");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Argentina");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Argentina",1);
						mundo.buscarTerritorio("Argentina").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Argentina", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Argentina", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				}

				// / ------------ Europa -------------
				else if (x >= 389 && x < 421 && y >= 49 && y < 76) {
					// 2 Iceland
					Territorio terri = mundo.buscarTerritorio("Islandia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Islandia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Islandia",1);
						mundo.buscarTerritorio("Islandia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Islandia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Islandia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 419 && x < 445 && y >= 81 && y < 105) {
					// 1 Great Britan
					Territorio terri = mundo.buscarTerritorio("Gran Bretaña");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Gran Bretaña");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Gran Bretaña",1);
						mundo.buscarTerritorio("Gran Bretaña").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Gran Bretaña", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Gran Bretaña", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 419 && x < 461 && y >= 115 && y < 145) {
					// 7 Western Europe
					Territorio terri = mundo.buscarTerritorio("Europa Occidental");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Europa Occidental");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa Occidental",1);
						mundo.buscarTerritorio("Europa Occidental").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa Occidental", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa Occidental", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 464 && x < 519 && y >= 52 && y < 74) {
					// 4 Scandinavia
					Territorio terri = mundo.buscarTerritorio("Escandinavia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Escandinavia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Escandinavia",1);
						mundo.buscarTerritorio("Escandinavia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Escandinavia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Escandinavia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 462 && x < 500 && y >= 90 && y < 110) {
					// 3 Northern Europe
					Territorio terri = mundo.buscarTerritorio("Europa del Norte");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Europa del Norte");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Norte",1);
						mundo.buscarTerritorio("Europa del Norte").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Norte", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Norte", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 484 && x < 528 && y >= 126 && y < 148) {
					// 5 Southern Europe
					Territorio terri = mundo.buscarTerritorio("Europa del Sur");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Europa del Sur");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Sur",1);
						mundo.buscarTerritorio("Europa del Sur").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Sur", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Europa del Sur", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 124 && x < 577 && y >= 69 && y < 105) {
					// 6 Ukraine
					Territorio terri = mundo.buscarTerritorio("Ucrania");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Ucrania");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ucrania",1);
						mundo.buscarTerritorio("Ucrania").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ucrania", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ucrania", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				}
				// /// -------------- Africa _-----------
				else if (x >= 494 && x < 534 && y >= 257 && y < 299) {
					// 1 Congo
					Territorio terri = mundo.buscarTerritorio("Congo");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Congo");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Congo",1);
						mundo.buscarTerritorio("Congo").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Congo", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Congo", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 552 && x < 598 && y >= 235 && y < 272) {
					// 2 East Africa
					Territorio terri = mundo.buscarTerritorio("África Oriental");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "África Oriental");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África Oriental",1);
						mundo.buscarTerritorio("África Oriental").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África Oriental", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África Oriental", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 455 && x < 535 && y >= 167 && y < 199) {
					// 3 Egypt
					Territorio terri = mundo.buscarTerritorio("Egipto");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Egipto");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Egipto",1);
						mundo.buscarTerritorio("Egipto").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Egipto", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Egipto", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 582 && x < 602 && y >= 332 && y < 364) {
					// 4 Madagascar
					Territorio terri = mundo.buscarTerritorio("Madagascar");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Madagascar");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Madagascar",1);
						mundo.buscarTerritorio("Madagascar").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Madagascar", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Madagascar", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}


				} else if (x >= 408 && x < 464 && y >= 189 && y < 234) {
					// 5 North Africa
					Territorio terri = mundo.buscarTerritorio("África del Norte");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "África del Norte");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África del Norte",1);
						mundo.buscarTerritorio("África del Norte").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África del Norte", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "África del Norte", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 492 && x < 540 && y >= 328 && y < 368) {
					// 6 South Africa
					Territorio terri = mundo.buscarTerritorio("Sudáfrica");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Sudáfrica");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Sudáfrica",1);
						mundo.buscarTerritorio("Sudáfrica").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Sudáfrica", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Sudáfrica", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				}
				// // ---------------- Australia -------------
				else if (x >= 888 && x < 929 && y >= 346 && y < 386) {
					// 1 Eastern Australia
					Territorio terri = mundo.buscarTerritorio("Australia Oriental");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Australia Oriental");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Oriental",1);
						mundo.buscarTerritorio("Australia Oriental").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Oriental", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Oriental", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 800 && x < 831 && y >= 260 && y < 289) {
					// 2 Indonesia
					Territorio terri = mundo.buscarTerritorio("Indonesia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Indonesia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Indonesia",1);
						mundo.buscarTerritorio("Indonesia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Indonesia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Indonesia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 893 && x < 926 && y >= 285 && y < 309) {
					// 3 New Guinea
					Territorio terri = mundo.buscarTerritorio("Nueva Guinea");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Nueva Guinea");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Nueva Guinea",1);
						mundo.buscarTerritorio("Nueva Guinea").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Nueva Guinea", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Nueva Guinea", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 808 && x < 853 && y >= 362 && y < 390) {
					// 4 Western Australia
					Territorio terri = mundo.buscarTerritorio("Australia Occidental");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Australia Occidental");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Occidental",1);
						mundo.buscarTerritorio("Australia Occidental").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Occidental", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Australia Occidental", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}


				}

				// /// ------------------- Asia ----------------
				else if (x >= 611 && x < 665 && y >= 105 && y < 140) {
					// 1 Afghanistan
					Territorio terri = mundo.buscarTerritorio("Afganistán");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Afganistán");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Afganistán",1);
						mundo.buscarTerritorio("Afganistán").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Afganistán", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Afganistán", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 725 && x < 795 && y >= 145 && y < 181) {
					// 2 China
					Territorio terri = mundo.buscarTerritorio("China");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "China");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "China",1);
						mundo.buscarTerritorio("China").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "China", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "China", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 654 && x < 724 && y >= 159 && y < 212) {
					// 3 India
					Territorio terri = mundo.buscarTerritorio("India");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "India");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "India",1);
						mundo.buscarTerritorio("India").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "India", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "India", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 731 && x < 778 && y >= 77 && y < 103) {
					// 4 Irkutsk
					Territorio terri = mundo.buscarTerritorio("Irkutsk");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Irkutsk");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Irkutsk",1);
						mundo.buscarTerritorio("Irkutsk").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Irkutsk", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Irkutsk", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 868 && x < 892 && y >= 139 && y < 161) {
					// 5 Japan
					Territorio terri = mundo.buscarTerritorio("Japón");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Japón");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Japón",1);
						mundo.buscarTerritorio("Japón").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Japón", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Japón", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 841 && x < 884 && y >= 51 && y < 72) {
					// 6 Kamchatka
					Territorio terri = mundo.buscarTerritorio("Kamchatka");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Kamchatka");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Kamchatka",1);
						mundo.buscarTerritorio("Kamchatka").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Kamchatka", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Kamchatka", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}



				} else if (x >= 559 && x < 605 && y >= 145 && y < 185) {
					// 7 Middle East
					Territorio terri = mundo.buscarTerritorio("Oriente Medio");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Oriente Medio");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Oriente Medio",1);
						mundo.buscarTerritorio("Oriente Medio").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Oriente Medio", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Oriente Medio", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}


				} else if (x >= 743 && x < 793 && y >= 108 && y < 136) {
					// 8 Mongolia
					Territorio terri = mundo.buscarTerritorio("Mongolia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Mongolia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Mongolia",1);
						mundo.buscarTerritorio("Mongolia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Mongolia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Mongolia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}



				} else if (x >= 751 && x < 791 && y >= 211 && y < 234) {
					// 9 Slam
					Territorio terri = mundo.buscarTerritorio("Siam");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Siam");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siam",1);
						mundo.buscarTerritorio("Siam").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siam", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siam", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				} else if (x >= 654 && x < 704 && y >= 41 && y < 70) {
					// 10 Siberia
					Territorio terri = mundo.buscarTerritorio("Siberia");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Siberia");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siberia",1);
						mundo.buscarTerritorio("Siberia").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siberia", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Siberia", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}


				} else if (x >= 609 && x < 652 && y >= 54 && y < 89) {
					// 11 Ural
					Territorio terri = mundo.buscarTerritorio("Ural");
					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Ural");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ural",1);
						mundo.buscarTerritorio("Ural").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ural", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Ural", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}


				} else if (x >= 732 && x < 808 && y >= 34 && y < 68) {
					// 12 Yakutsk
					Territorio terri = mundo.buscarTerritorio("Yakutsk");

					if (mundo.getEtapaJuego() == 1 && terri.getPropietario()== null) {
						guardarTurno();
						mundo.agregarTerritorioAJugador(textField_JugadorActual.getText(), "Yakutsk");
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Yakutsk",1);
						mundo.buscarTerritorio("Yakutsk").setPropietario(mundo.getJugadorActual());
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					} else if (mundo.getEtapaJuego() == 2 && terri.getPropietario().getNombre().equals(mundo.getJugadorActual().getNombre())) {
						guardarTurno();
						mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Yakutsk", 1);
						try {
							mundo.pasarTurno();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						actualizarPanelInformacion();
					}
					else if(mundo.getEtapaJuego()==3){	
						guardarTurno();
						if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()!=0)
							mundo.agregarTropaATerritorio(textField_JugadorActual.getText(), "Yakutsk", 1); if(mundo.getJugadorActual().getNumTropasDisponiblesAUbicar()==0) activarBotones();

							actualizarPanelInformacion();
					}

				}
			}

		});
		panel_Map.setBounds(167, 58, 972, 486);
		Juego.add(panel_Map);
		panel_Map.setLayout(null);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(854, 454, 108, 23);
		btnAyuda.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				final JDialog JDialog_Ayuda = new JDialog();
				JDialog_Ayuda.setBounds(220, 200, 80, 80);
				JDialog_Ayuda.setTitle("AYUDA");
				JDialog_Ayuda.setVisible(true);
				JDialog_Ayuda.getContentPane().setLayout(new GridLayout(3, 1));
				JDialog_Ayuda.setResizable(false);
				
				JLabel terriLab = new JLabel("TERRITORIOS");
				JDialog_Ayuda.getContentPane().add(terriLab);
				
				ListaDoble<Territorio> territoriojugadores = mundo.buscarJugador(textField_JugadorActual.getText()).getTerritoriosOcupados();
				String[] listTeri= new String[territoriojugadores.darLongitud()];
				for (int i = 0; i < territoriojugadores.darLongitud(); i++) {
					listTeri[i] = territoriojugadores.darElemento(i).getNombre();
				}
				ordenarArreglo(listTeri);
				
				final JComboBox listTerrii = new JComboBox(listTeri);
				comboBoxNumjugadores.setBackground(Color.LIGHT_GRAY);
				comboBoxNumjugadores.setForeground(Color.BLACK);
				JDialog_Ayuda.getContentPane().add(listTerrii);
				
				final JButton buscar = new JButton("BUSCAR");
				buscar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ListaDoble<Territorio> list =  mundo.getMejorTerritorioAatacar(textField_JugadorActual.getText(), listTerrii.getSelectedItem()+"");
						String terri = "Los mejores territorios a atacar : "+"\n";
						for (int i = 0; i < list.darLongitud(); i++){
							terri += list.darElemento(i).getNombre() +"\n";
							if(i==list.darLongitud());
						}
						JOptionPane.showMessageDialog(null, terri);
					}
				});
				JDialog_Ayuda.getContentPane().add(buscar);
			}
		});
		panel_Map.add(btnAyuda);
		btnAyuda.setFont(new Font("Algerian", Font.PLAIN, 14));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Devolver", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 455, 166, 89);
		Juego.add(panel);
		panel.setLayout(null);

		JButton btnTurno = new JButton("Turno");
		btnTurno.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnTurno.setBounds(43, 21, 91, 23);
		btnTurno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deshacerTurno();
				actualizarPanelInformacion();
			}
		});
		panel.add(btnTurno);

		JButton btnRonda = new JButton("Ronda");
		btnRonda.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnRonda.setBounds(43, 55, 91, 23);
		btnRonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deshacerRonda();
				actualizarPanelInformacion();
			}
		});
		panel.add(btnRonda);

		textField_CartasDisponibles = new JTextField();
		textField_CartasDisponibles.setBounds(0, 58, 166, 154);
		Juego.add(textField_CartasDisponibles);
		textField_CartasDisponibles.setBorder(new TitledBorder(null, "Cartas Disponibles", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		textField_CartasDisponibles.setEditable(false);
		textField_CartasDisponibles.setColumns(10);
	}
	public void activarBotones(){
		btnAtacar.setEnabled(true);
		btnCambiarTropas.setEnabled(true);
		btnObtenerTropas.setEnabled(true);
		btnPasarTurno.setEnabled(true);
		btnReforzarTropas.setEnabled(true);
	}
	public void prueba(){
		mundo = new TablaRisk(3);
		try {
			mundo.agregarJugador("Emmanuel", TablaRisk.AMARILLO);
			mundo.buscarJugador("Emmanuel").setNumTropasDisponiblesAUbicar(70);
			mundo.agregarJugador("David", TablaRisk.AZUL);
			mundo.buscarJugador("David").setNumTropasDisponiblesAUbicar(70);
			mundo.agregarJugador("Christian", TablaRisk.ROJO);
			mundo.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(70);


			for (int i = 0; i < 14; i++) {
				mundo.agregarTerritorioAJugador("Christian",
						mundo.nombreTerritorios[i]);
				mundo.agregarTropaATerritorio("Christian",
						mundo.nombreTerritorios[i], 5);
				mundo.buscarTerritorio(mundo.nombreTerritorios[i]).setPropietario(mundo.buscarJugador("Christian"));
			}

			for (int i = 14; i < 28; i++) {
				mundo.agregarTerritorioAJugador("Emmanuel",
						mundo.nombreTerritorios[i]);
				mundo.agregarTropaATerritorio("Emmanuel",
						mundo.nombreTerritorios[i], 5);
				mundo.buscarTerritorio(mundo.nombreTerritorios[i]).setPropietario(mundo.buscarJugador("Emmanuel"));
			}

			for (int i = 28; i < 42; i++) {
				mundo.agregarTerritorioAJugador("David",
						mundo.nombreTerritorios[i]);
				mundo.agregarTropaATerritorio("David",
						mundo.nombreTerritorios[i], 5);
				mundo.buscarTerritorio(mundo.nombreTerritorios[i]).setPropietario(mundo.buscarJugador("David"));

			}
			mundo.setEtapaJuego(3);
			mundo.setJugadorActual(0);
			actualizarPanelInformacion();
		} catch (Exception e) {
		}
	}

	public void guardarTurno() {
		turnos.guardarTurno();
	}

	public void deshacerTurno() {
		try {
			mundo = (TablaRisk) turnos.restablecerTurno();
			actualizarPanelInformacion();
			repaint();
			/**
			 * refrescar paneles
			 */

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe jugar por lo menos un turno antes de deshacer turno");
		}
	}

	public void deshacerRonda() {
		try {
			mundo = (TablaRisk) turnos.restablecerRonda();
			actualizarPanelInformacion();
			repaint();
			/**
			 * refrescar paneles
			 */
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe jugar por lo menos un turno antes de deshacer turno");
		}
	}

	public void actualizarPanelInformacion() {
		Jugador actual = mundo.getJugadorActual();

		textField_JugadorActual.setText(actual.getNombre());
		textField_TropasUbicadas.setText(actual.getNumTropasUbicadas() + "");
		textField_TropasAUbicar.setText(actual.getNumTropasDisponiblesAUbicar() + "");
		textField_Color.setText(actual.getColorTropas());
		textField_Mision.setText(actual.getCartaMision().getDescripcion());
		
		String cartas = "";
		for (int i = 0; i <actual.getCartasBonus().darLongitud(); i++) {
			cartas += actual.getCartasBonus().darElemento(i).getTerritorio()+"\n";
		}
		textField_CartasDisponibles.setText(cartas);
	}

	private void ordenarArreglo(String[] lista){
		for(int i=0;i<(lista.length-1);i++){
			for(int j=i+1;j<lista.length;j++){
				if(lista[i].compareToIgnoreCase(lista[j])>0){
					//Intercambiamos valores
					String variableauxiliar=lista[i];
					lista[i]=lista[j];
					lista[j]=variableauxiliar;
				}
			}
		}
	}

}
