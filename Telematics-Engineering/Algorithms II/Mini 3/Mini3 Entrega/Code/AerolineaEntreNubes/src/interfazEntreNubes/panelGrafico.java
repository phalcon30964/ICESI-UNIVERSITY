package interfazEntreNubes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Box.Filler;

import mundo.Ciudad;
import mundo.EntreNubes;

public class panelGrafico extends  JPanel{

    private static final int ANCHO = 100;

   
    private static final int ALTO = 50;

   
    private static final int BORDE_X = 5;

    private static final int BORDE_Y = 20;

    
    private static final Color COLOR_BORDE = Color.BLACK;

    private static final Color COLOR_FONDO = new Color( 255, 254, 170 );

 
    private static final Color COLOR_FONDO_SELECCIONADO = new Color( 139, 219, 245 );

    
    private static final Color COLOR_LINEAS = new Color( 89, 89, 89 );
    
    private BufferedImage imagenRutas;
    
    private BufferedImage imagenTurista;
    
	private EntreNubes raiz;
	
	private interfazEntreNube principal;
	
	
	
	private String nombre;
	
	
	public panelGrafico(EntreNubes nube){
		
		
		
		setDoubleBuffered(true);
		raiz = nube;
		try {
			imagenTurista = ImageIO.read(new File ("./data/plane.png"));
		} catch (IOException e) {
			imagenTurista =  new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dibujarRutas(g);
	}
	
	
	public void dibujarRutas( Graphics g){
		

		g.setColor(Color.white);
		g.fillRect( 0, 0, getWidth( ), getHeight( ) );
		
        
        if( imagenRutas == null ){
        	 actualizarImagen( );
        }
           
         
        if( imagenRutas.getWidth( ) > getWidth( ) ){
        	
        	 g.drawImage( imagenRutas, 0, 0, null );
        	 
        }else {
        	
            g.drawImage( imagenRutas, ( getWidth( ) - imagenRutas.getWidth( ) ) / 2, 0, null );
        }
    }
	
		
	public void actualizarImagen( ){
        if( raiz != null )
        {
            Ciudad principal = raiz.darRaizRuta( );
            if( principal != null )
            {
                imagenRutas = dibujarRutasConCiudades( principal );
                setPreferredSize( new Dimension( imagenRutas.getWidth( ), imagenRutas.getHeight( ) ) );
                setSize( new Dimension( imagenRutas.getWidth( ), imagenRutas.getHeight( ) ) );
            }
            else
            {
                imagenRutas = new BufferedImage( 1, 1, BufferedImage.TYPE_INT_RGB );
                setSize( new Dimension( getWidth( ) - 1, getHeight( ) - 1 ) );

            }
        }
    }
	 private BufferedImage dibujarRutasConCiudades( Ciudad elem )
	    {
	        if( elem.esHoja( ) )
	        {
	            return dibujarRuta( elem );
	        }
	        else
	        {
	            ArrayList hijos = elem.darCiudadesHijas( );
	            ArrayList imagenes = new ArrayList( );

	            int ancho = 0;
	            int alto = 0;

	            for( int i = 0; i < hijos.size( ); i++ )
	            {
	                Ciudad hijo = ( Ciudad )hijos.get( i );
	                BufferedImage imagenHijo = dibujarRutasConCiudades( hijo );
	                ancho += imagenHijo.getWidth( );
	                alto = Math.max( alto, imagenHijo.getHeight( ) );
	                imagenes.add( imagenHijo );
	            }

	            alto += ALTO + BORDE_Y * 2;
	            BufferedImage imagenElemento = dibujarRuta( elem );

	           
	            BufferedImage imagenCompleta = new BufferedImage( ancho, alto, BufferedImage.TYPE_INT_RGB );
	            Graphics2D superficie = imagenCompleta.createGraphics( );
	            superficie.setColor( Color.WHITE );
	            superficie.fillRect( 0, 0, ancho, alto );

	          
	            int posElemento = ( ancho / 2 ) - ( ANCHO / 2 ) - BORDE_X;
	            superficie.drawImage( imagenElemento, posElemento, 0, null );

	           
	            int posXActual = 0;
	            int posYActual = ALTO + BORDE_Y * 2;

	            for( int i = 0; i < imagenes.size( ); i++ )
	            {
	                BufferedImage imagenHijo = ( BufferedImage )imagenes.get( i );
	                superficie.drawImage( imagenHijo, posXActual, posYActual, null );
	                int anchoHijo = imagenHijo.getWidth( );

	                posXActual += anchoHijo;
	            }

	            posXActual = 0;
	          
	            for( int i = 0; i < imagenes.size( ); i++ )
	            {
	                BufferedImage imagenHijo = ( BufferedImage )imagenes.get( i );
	                int anchoHijo = imagenHijo.getWidth( );
	                superficie.setPaint( COLOR_LINEAS );
	                superficie.drawLine( ancho / 2, ALTO + BORDE_Y, posXActual + anchoHijo / 2, posYActual + BORDE_Y );
	                posXActual += anchoHijo;
	            }

	            return imagenCompleta;
	        }

	    }


		
	 private BufferedImage dibujarRuta( Ciudad ruta ){
	    
	        BufferedImage imagen = new BufferedImage( ANCHO + BORDE_X * 2, ALTO + BORDE_Y * 2, BufferedImage.TYPE_INT_RGB );
	        Graphics2D g = imagen.createGraphics( );
	        g.setColor( Color.WHITE );
	        g.fillRect( 0, 0, ANCHO + BORDE_X * 3, ALTO + BORDE_Y * 3 );

	   
	        Rectangle2D rec = new Rectangle2D.Double( BORDE_X, BORDE_Y, ANCHO, ALTO );
	        if( ruta.darNombre( ).equals( nombre ) )
	        {
	            g.setPaint( COLOR_FONDO_SELECCIONADO );
	        }
	        else
	        {
	            g.setPaint( COLOR_FONDO );
	        }
	        g.fill( rec );
	        g.setPaint( COLOR_BORDE );
	        g.draw( rec );
	        String texto2 = "";
	        String texto3 = "";

/*	        if( ruta != null ){
	            g.drawImage( imagenRutas, 5, 15, null );
	            texto2 = ruta.darAeropuertoLlegada().substring(0,Math.min(18, ruta.darAeropuertoLlegada().length()));
	            texto3 = ruta.darDistanciaVuelo()+"";
	        }
	        
	        
	       String texto = ruta.darNombre().substring(0,Math.min(18, ruta.darNombre().length()));
*/        
	        String texto = ruta.darNombre().toUpperCase();
	        
	        ruta.darNombre();
	        int centroX = Math.abs( ANCHO + BORDE_X * 2 ) / 2;
	        int centroY = Math.abs( ALTO + BORDE_Y * 2 ) / 2;

	        Font fuente = new Font( "Arial", Font.PLAIN, 11 );
	        g.setFont( fuente );
	        g.setColor( Color.BLACK );

	        FontMetrics metrics = g.getFontMetrics( );
	        int ancho = metrics.stringWidth( texto );
	        g.drawString( texto, centroX - ancho / 2, centroY + 5 );
	        if( ruta.darNombre() != null ){
	            g.setColor( Color.BLUE );
	            int ancho2 = metrics.stringWidth( texto2 );
	            int ancho3 = metrics.stringWidth( texto3 );
	            g.drawString( texto2, centroX - ancho2 / 2, centroY - 9 );
	            g.drawString( texto3, centroX - ancho3 / 2, centroY + 19 );
	        }
	        return imagen;
	    }
	
	

}
