/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * Modificación: Pablo Barvo 25-Ago-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.carrocompralibro.interfaz;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import uniandes.cupi2.carrocompralibro.mundo.CarroCompras;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;
import uniandes.cupi2.carrocompralibro.mundo.Libro;

/**
 * Modelo de datos del carro de compras para el despliegue en tablas
 */
public class TablaModeloCarroCompras extends AbstractTableModel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Títulos de columnas
     */
    private String[] nombresColumnas;

    /**
     * El carro de compras
     */
    private CarroCompras carrito;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el modelo del catálogo a partir de la tienda.
     * @param unCarrito Carro de compras a desplegar. unCarrito != null.
     */
    public TablaModeloCarroCompras( CarroCompras unCarrito )
    {
        carrito = unCarrito;
        String[] nombresColumnasAux = { "ISBN", "Título", "Cantidad", "Subtotal" };
        nombresColumnas = nombresColumnasAux;

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Sobrecarga el método de Table Model y retorna el número de filas para ajustar la tabla de Compras.
     * @return total de las compras en el carro. total >= 0.
     */
    public int getRowCount( )
    {
        int cuenta = carrito.darListaCompra( ).size( );
        return cuenta;
    }

    /**
     * Sobrecarga el método de Table Model y retorna el número de columnas para ajustar la tabla de Compras.
     * @return total de las compras. total >= 0
     */
    public int getColumnCount( )
    {
        int cuenta = nombresColumnas.length;
        return cuenta;
    }

    /**
     * Sobrecarga el método de Table Model y retorna el objeto de la casilla actual.
     * @param rowIndex Índice de la fila. rowIndex >= 0
     * @param columnIndex Índice de la columna. columIndex >= -1
     * @return dato de la tabla. si el columnIndex es -1 retorna el objeto completo.
     */
    public Object getValueAt( int rowIndex, int columnIndex )
    {

        Object datoItem = null;
        Object[] items = carrito.darListaCompra( ).toArray( );
        ItemCompra item = ( ItemCompra )items[ rowIndex ];
        Libro libroItem = item.darLibro( );

        if( columnIndex == -1 )
            datoItem = item;
        else if( columnIndex == 0 )
            datoItem = libroItem.darISBN( );
        else if( columnIndex == 1 )
            datoItem = libroItem.darTitulo( );
        else if( columnIndex == 2 )
            datoItem = new Integer( item.darCantidadSolicitada( ) );
        else if( columnIndex == 3 )
            datoItem = formatearValor( item.calcularSubtotalItem( ) );

        return datoItem;
    }

    /**
     * Sobrecarga el método de Table Model y retorna el nombre de la columna.
     * @param col Columna de la cual se quiere saber el nombre. col >= 0.
     * @return nombre de la columna
     */
    public String getColumnName( int col )
    {
        String nombre = nombresColumnas[ col ];
        return nombre;
    }

    /**
     * Sobrecarga el método de Table Model y dice si la celda se puede editar.
     * @param fila Índice de la fila. fila >= 0.
     * @param col Índice de la columna. col >=0 .
     * @return true si se puede editar, false en caso contrario.
     */
    public boolean isCellEditable( int fila, int col )
    {
        return false;
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz.
     * @param valor Valor numérico a ser formateado.
     * @return cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

}