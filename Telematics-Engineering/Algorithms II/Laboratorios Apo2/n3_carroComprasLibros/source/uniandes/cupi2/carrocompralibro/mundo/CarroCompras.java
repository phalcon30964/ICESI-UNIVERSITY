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
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.carrocompralibro.mundo;

import java.util.ArrayList;

/**
 * Carrito de compra de libros. Va guardando los libros que el cliente quiere comprar.
 */
public class CarroCompras
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /** Lista de los ítem de compra que se van añadiendo al carro */


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un carro de compra vacío (sin libros solicitados).
     */


    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Nombre: buscarItemCompraLibro
     * Retorna si existe un ítem de compra donde esté el libro con el ISBN dado.
     * @param isbnBuscado ISBN del libro buscado.
     * @return ítem de compra del libro o null si no lo encuentra.
     */
   


    /**
     * Nombre: adicionarCompra
     * Adiciona un nuevo ítem al carro de la compras si el libro ya no estaba en él, o adiciona la cantidad si el libro ya está incluido en otra compra. <br>
     * <b>post: </b> Si el libro no está en el carro de compras, se adiciona el libro y la cantidad de ejemplares o si ya existe se incrementa la cantidad de ejemplares a
     * comprar. <br>
     * @param libro Libro a comprar. libro != null.
     * @param cantidad Cantidad de libros a comprar. cantidad >= 0.
     */



    /**
     * Nombre: borrarItemCompra
     * Borra un ítem del carro de la compra. <br>
     * <b>post: </b> Se elimina el ítem de compra dado. <br>
     * @param unItem Ítem a buscar y eliminar. unItem != null.
     */
    




    /**
     * Nombre: darListaCompra
     * Retorna la lista de los ítem de compra.
     * @return Lista de los ítem de compra.
     */



    /**
     * Nombre: calcularValorTotalCompra
     * Calcula el total de la compra que lleva el carrito.
     * @return Total de la compra.
     */


    /**
     * Nombre: obtenerLibroCompradoMasBarato
     * Obtiene el libro del carro de compras más barato
     * @return un Libro.
     */
    
}