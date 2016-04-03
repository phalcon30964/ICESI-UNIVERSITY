
import static java.lang.Thread.sleep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author distribuidos
 */
public class descargador extends Thread {

    bodega bodega;

    public descargador(bodega bode) {

        this.bodega = bode;
    }

    public void run() {
        while (true) {
            int tiempo = 2;
            int tipo = 1 + (int) (Math.random() * 2);
            try {
                sleep(tiempo*1000);
            } catch (InterruptedException e) {
            }
            bodega.descargarArticulo(tipo);
        }
    }
}
