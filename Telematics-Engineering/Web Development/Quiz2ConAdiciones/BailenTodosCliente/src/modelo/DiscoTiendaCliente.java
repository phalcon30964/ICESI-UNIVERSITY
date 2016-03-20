package modelo;

import java.util.ArrayList;

public class DiscoTiendaCliente {
	
	private ArrayList<Disco> listadoDiscos;
	private ArrayList<Cancion> listadoCancion;

	public ArrayList<Disco> getListadoDiscos() {
		return listadoDiscos;
	}

	public void setListadoDiscos(ArrayList<Disco> listadoDiscos) {
		this.listadoDiscos = listadoDiscos;
	}
	
	
	public ArrayList<Cancion> getListadoCancion() {
		return listadoCancion;
	}

	public void setListadoCancion(ArrayList<Cancion> listadoCancion) {
		this.listadoCancion = listadoCancion;
	}

	/**
	 * metodo que busca un disco entre el listado de discos buscados para la venta
	 * @param nombre
	 * @return disco buscado
	 */
	public Disco buscarDisco(String nombre){
		for (int i = 0; i < listadoDiscos.size(); i++) {
			if(listadoDiscos.get(i).getNombre().equals(nombre)){
				return listadoDiscos.get(i);
			}
		}
		return null;
	}
	
	/**
	 * metodo que cancion un disco entre el listado de canciones buscadas para la venta
	 * @param nombre
	 * @return
	 */
	public Cancion buscarCancion(String nombre){
		
		for (int i = 0; i < listadoCancion.size(); i++) {
			if(listadoCancion.get(i).getNombre().equals(nombre)){
				return listadoCancion.get(i);
			}
		}
		return null;
	}

}
