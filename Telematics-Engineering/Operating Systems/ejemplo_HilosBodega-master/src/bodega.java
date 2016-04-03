/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author distribuidos
 */
public class bodega {

    int capacidadBodega;
    public final static int TIPO1 = 1;
    public final static int TIPO2 = 2;
    int tipoArticulo;
    int volumen;
    int cantidadTipo1;
    int cantidadTipo2;
    private final int volumenTipo1;
    private final int volumenTipo2;

    public bodega() {
        capacidadBodega = 0;
        cantidadTipo1 = 0;
        cantidadTipo2 = 0;
        volumenTipo1 = 10;
        volumenTipo2 = 15;        
        System.out.println("Bodega creada con");
        imprimir();
    }

    public void descargarArticulo(int tipoArticulo) {
        System.out.println("empieza descarga de tipo  " + tipoArticulo);
        if (tipoArticulo == TIPO1) {
            while(capacidadBodega > 190);
            capacidadBodega += volumenTipo1;
            cantidadTipo1++;
        }
        if (tipoArticulo == TIPO2) {            
            while(capacidadBodega > 185);
            capacidadBodega += volumenTipo2;
            cantidadTipo2++;
        }
        imprimir();
        System.out.println("termina descarga de tipo  " + tipoArticulo);
    }

    public void crearPaquete() {
        System.out.println("Empieza a empacar paquete");   
           if(cantidadTipo2 >= 4 && cantidadTipo1 >= 3 ){
            cantidadTipo1 -= 3;
            cantidadTipo2 -= 4;
            capacidadBodega -= (3*volumenTipo1 + 4*volumenTipo2);
            imprimir();
           }
        System.out.println("Se empaco paquete");   
    }
    
    public void imprimir(){
        System.out.println(cantidadTipo1);
        System.out.println(cantidadTipo2);
        System.out.println(capacidadBodega);
    }

}
