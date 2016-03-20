
public class Tarea {
	
	/*1) + calcularValorTotalCompra():int de la clase CarroCompras
	Que se encarga de sumar el valor total de todos los ítems de compra
	del carro de compras actual.
	
	
	*/
	
	
	public int calcularValorTotalCompra(){
		int valorTotal = 0;
		int tam = itemsCompra.size();
		
			for (int i = 0; i < tam ; i++) {
			valorTotal += itemsCompra.get(i).calcularSubtotalItem();
			}
		
		return valorTotal;
	}
	
/*

	2) + calcularCantidadTotalVendida():int de la clase TiendaLibros
	Que se encarga de sumar las cantidades de libros vendidos en todos
	los carros de compra de la tienda de libro. Tenga en cuenta que la 
	cantidad de libros vendidos en un carro de compra es la suma de la
	cantidad de libros de cada ítem de compra del carro.
	Recuerde que ahora podemos tener muchos carros de compra. 
	
*/
	public int calcularCantidadTotalVendida(){
		int cantidadTotal = 0;
		int tam = carritos.size();
		
			for(int j = 0; j < tam ; j++){
				int tam2 = itemsCompra.size()
				
						for(int m = 0; m < tam2 ; m++){
						cantidadTotal += carritos.get(j).itemscompra(m).darCantidadSolicitada();
						}
			}
		return cantidadTotal;
	}
	
/*

	3) + libroHaSidoComprado(l:Libro):boolean de la clase TiendaLibros
	Que revisa en todos los ítems de compra, de todos los carros de
	compra, si existe el libro pasado por parámetro.

	La entrega debe hacerse en papel (puede ser manuscrita pero legible,
	sin tachones, ni borrones).

	Fecha de Entrega: Viernes 27 de Septiembre de 2013 en Horario de Clase
*/
	public boolean libroHaSidoComprado (Libro Li){
		boolean respuesta = false;
		
			for(int j = 0; j < carritos.size() && respuesta == false ; j++){
				
					if(carritos.get(j).buscarItemCompraLibro(Li.darISBN())!=null){
					respuesta = true;
					}
			}
		return respuesta;
	}

}
