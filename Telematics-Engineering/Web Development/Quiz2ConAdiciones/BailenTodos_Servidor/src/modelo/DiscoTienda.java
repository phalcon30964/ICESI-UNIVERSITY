package modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class DiscoTienda {
	
	private AdministradorBD adminBD;

	public DiscoTienda() {
		this.adminBD = new AdministradorBD();
	}
	
	/**
	 * Metodo que registra un artista en la base de datos
	 * 
	 * @param nombreCompleto
	 * @param nombreArtistico
	 * @param tipoId
	 * @param id
	 * @param imagen
	 * @param dirresidencia
	 * @param ciudresidencia
	 * @param dirCorrespondencia
	 * @param ciudCorrespondencia
	 * @param telefono
	 * @param numContacto
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean registrarArtista(String nombreCompleto,
			String nombreArtistico, String tipoId, String id, ImageIcon imagen,
			String dirresidencia, String ciudresidencia,
			String dirCorrespondencia, String ciudCorrespondencia,
			String telefono, String numContacto) {
		
		return adminBD.registrarArtista(nombreCompleto, nombreArtistico, tipoId, id, toBufferedImage(imagen.getImage()), dirresidencia, 
			   ciudresidencia, dirCorrespondencia, ciudCorrespondencia, telefono, numContacto);
		
	}
	
	/**
	 * Metodo que crea un nuevo disco en la base de datos
	 * @param nombre
	 * @param genero
	 * @param imagen
	 * @param disponibles
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean registraDiscos(String nombre, String genero, ImageIcon imagen, String disponibles) {
		return adminBD.registraDiscos(nombre, genero, toBufferedImage(imagen.getImage()), disponibles);
	}
	
	/**
	 * Metodo que referencia que a un artista de la base de datos como autor principal del disco registrandose
	 * @param nombreDisco
	 * @param artistas
	 * @returnboolean true si fue exitoso el registro false si no
	 */
	public boolean agregarArtistaADisco(String nombreDisco, String artistas) {
		return adminBD.agregarArtistaADisco(nombreDisco, artistas);
	}
	
	/**
	 * Metodo que registra una cancion en la base de datos
	 * @param nombre
	 * @param duracion
	 * @param nombreDisco
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean registrarCancion(String nombre, String duracion,
			String nombreDisco) {
		return adminBD.registrarCancion(nombre, duracion, nombreDisco);
	}
	
	/**
	 * Metodo que registra a un artista existente en la base de datos como artista de una cancion
	 * @param nombreCancion
	 * @param artistas
	 * @return boolean true si fue exitoso el registro false si no
	 */
	public boolean agregarArtistaACancion(String nombreCancion, String artistas) {
		return adminBD.agregarArtistaACancion(nombreCancion, artistas);
	}
	
	/**
	 * Metodo que registra la venta de discos en la base de datos 
	 * @param nombreDisco
	 * @param cantidad
	 * @return  boolean true si fue exitoso el registro false si no
	 */
	public boolean venderDisco(String nombreDisco,String cantidad) {
		return adminBD.venderDisco(nombreDisco,cantidad);
	}
	
	/**
	 * Metodo que consulta en la base de datos el total de los discos vendidos
	 * @return int discos vendidos
	 */
	public int numeroDeDiscosVendidos() {
		return adminBD.numeroDeDiscosVendidos();
	}
	
	/**
	 * Metodo que consulta en la base de datos el total de los discos disponibles
	 * @return int discos disponibles
	 */
	public int numeroDeDiscosDisponibles() {
		return adminBD.numeroDeDiscosDisponibles();
	}
	
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre de parametro
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorNombre(String nombreDisco){
		return adminBD.consultarDiscoPorNombre(nombreDisco);
	}
	
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre de parametro
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorCancion(String nombreCancion) {
		return adminBD.consultarDiscoPorCancion(nombreCancion);
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el nombre del artista
	 * @return ArrayList de discos
	 */
	public ArrayList<Disco> consultarDiscoPorArtista(String nombreArtista) {
		return adminBD.consultarDiscoPorArtista(nombreArtista);
	}
	/**
	 * Metodo que consulta en la base de datos los discos para veder con el genero por parametro
	 * @return ArrayList de discos
	 */	
	public ArrayList<Disco> consultarDiscoPorGenero(String gen) {
		return adminBD.consultarDiscoPorGenero(gen);
	}
	
	/**
	 * Metodo que consulta el nombre todos los discos de la base de datos
	 * @return ArrayList con el nombre de todos los discos
	 */
	public ArrayList<String> consultarDiscos() {
		return adminBD.consultarDiscos();
	}
	
	/**
	 * Metodo que consulta el nombre todos los artistas de la base de datos
	 * @return ArrayList con el nombre de todos los artistas
	 */
	public ArrayList<String> consultarArtistas() {
		return adminBD.consultarArtistas();
	}
	
	/**
	 * Meotdo elabora un array con la estadistica de discos vendidos y disponibles en inventario de un disco
	 * @return arraylist
	 */
	public ArrayList<String> estadisticaPorDisco (){
		return adminBD.estadisticaPorDisco();
	}
	
	/**
	 * Meotodo que convierte un image en buferredimage
	 * @param img
	 * @return BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    return bimage;
	}
	
	public ImageIcon consultarFoto(String nombreArtista){
		return adminBD.consultarFoto(nombreArtista);
	}
	public ImageIcon consultarCaratula(String nombreDisco){
		return adminBD.consultarCaratula(nombreDisco);
	}
	

}
