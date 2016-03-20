package visualkey;

import java.awt.*;

import javax.swing.*;

import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class KPanel extends JPanel {

	// Funtional elements
	private GridBagConstraints restriction;
	private GridBagLayout layout;
	protected int width;
	protected int height;

	private void initPanel(Dimension dimension){
		this.width = dimension.width;
		this.height = dimension.height;
		this.setPreferredSize(dimension);
		this.setSize(width,height);
		this.restriction = new GridBagConstraints();
		this.layout = new GridBagLayout();
		this.setLayout(layout);
	}

	// Constructores
	public KPanel(){
		this.initPanel(new Dimension());
	}

	public KPanel(Dimension dimension){
		this.initPanel(dimension);
	}

	public KPanel(int width, int height){
		this.initPanel(new Dimension(width, height));
	}

	/**
	 * Method to increment certain amount to a complete array, very usseful to work width the paintComponent.
	 * @param array: integer array
	 * @param increment: increment to be added.
	 * @return
	 */
	public int[] move(int[] array,int increment){
		for(int h=0;h<array.length;h++){
			array[h]+=increment;
		}
		return array;
	}

	/**
	 * Imports an Image from the path entered. The file has to be in the same package or subpackage of the class who inherits this function.
	 * @param path: Image path.
	 * @return
	 */
	public Image getImage(String path){
		return Toolkit.getDefaultToolkit().getImage(getClass().getResource(path));
	}

	/**
	 * Imports an ImageIcon from the path entered. The file has to be in the same package or subpackage of the class who inherits this function.
	 * @param path: Image path.
	 * @return
	 */
	public ImageIcon getImageIcon(String path){
		return new ImageIcon(this.getImage(path));
	}

	/**
	 * Automatic method to add a JLabel component width the specified configuration.
	 * @param text: The text in the JLabel component.
	 * @param row
	 * @param column
	 * @param ancho
	 * @param alto
	 * @param wightx
	 * @param weightx
	 * @param weighty
	 * @param centered
	 */
	public void addLabel(String text, int row, int column, int ancho, int alto, int wightx, int weightx, int weighty, boolean centered) {
		JLabel label = new JLabel(text);
		setRestriction(row, column, ancho, alto, wightx, weightx, centered);
		layout.setConstraints(label, restriction);
		this.add(label);
	}

	/**
	 * @param component: One of the swing components to add to the Frame.
	 * @param row: The row to add the element.
	 * @param column: The column to add the element.
	 * @param width: The columns that the component uses.
	 * @param height: The rows that the component uses.
	 */
	public void addComponent(Component component, int row, int column, int width, int height){
		this.addComponent(component, row, column, width, height, 1, 1, true);
	}

	/**
	 * @param component: One of the swing components to add to the Frame.
	 * @param row: The row to add the element.
	 * @param column: The column to add the element.
	 * @param width: The columns that the component uses.
	 * @param height: The rows that the component uses.
	 * @param centered: Whether or not the component is centered.
	 */
	public void addComponent(Component component, int row, int column, int width, int height, boolean centered){
		this.addComponent(component, row, column, width, height, 1, 1, centered);
	}

	/**
	 * @param component: One of the swing components to add to the Frame.
	 * @param row: The row to add the element.
	 * @param column: The column to add the element.
	 * @param width: The columns that the component uses.
	 * @param height: The rows that the component uses.
	 * @param nweightx: Ussually people use 1.
	 * @param nweighty: Ussually people use 1.
	 * @param centered: Whether or not the component is centered.
	 */
	public void addComponent(Component component, int row, int column, int width, int height, int nweightx, int nweighty, boolean centered){
		this.setRestriction(row, column, width, height, nweighty, nweightx, centered);
		this.layout.setConstraints(component, restriction);
		this.add(component);
	}

	public void setRestriction(int row, int column, int width, int height, int nweightx, int nweighty, boolean centrado) {
		restriction.gridx = column;
		restriction.gridy = row;
		restriction.gridwidth = width;
		restriction.gridheight = height;
		restriction.weightx = nweightx;
		restriction.weighty = nweighty;
		if(centrado){
			restriction.fill = restriction.CENTER;
		}else{
			restriction.fill = restriction.HORIZONTAL;
		}
	}

	/**
	 * @return: The width specified in the constructor.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return: The height specified in the constructor.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param msj: The message to show with JOptionPane.
	 */
	public void showMessage(String msj){
		JOptionPane.showMessageDialog(this,msj);
	}

	/**
	 * Supported format: WAV.
	 * @param sound: The source of the audio file. The file must be in the same package or subpackage of the class who inherits this function.
	 * @return true if the sound could be play or false if it doesn't.
	 */
	public boolean playSound(String sound){
		try {
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(getClass().getResource(sound)));
			sonido.start();
			return true;
		} catch (LineUnavailableException e) {
			System.out.println("IMPOSIBLE TO PLAY THIS SOUND: "+sound);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("FILE NOT FOUND: "+sound);
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			System.out.println("UNSUPPOTED AUDIO INPUT: "+sound);
			e.printStackTrace();
		}
		return false;
	}
}