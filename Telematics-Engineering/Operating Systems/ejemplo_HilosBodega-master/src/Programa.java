/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author distribuidos
 */
public class Programa {
    
     public static void main(String main[]){

        bodega bode = new bodega();

        descargador procesoDescarga = new descargador(bode);
        empacador procesoCarga=new empacador(bode);

        procesoCarga.start();
        procesoDescarga.start();
       

    }
    
}
