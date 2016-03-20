package Modelo;

import android.app.Activity;
import android.widget.ImageView;

import com.fkj.tapapplication.AnarkyActivity;
import com.fkj.tapapplication.MainActivity;
import com.fkj.tapapplication.R;

/**
 * Created by felipeAvendanoBarbosa on 2/6/16.
 */
public class hilo extends Thread {

    private ImageView im;
    private Juego juego;
    private AnarkyActivity anarkyActivity;

    public hilo(AnarkyActivity a, Juego juego){
        anarkyActivity=a;
        this.im=a.getIm();
        this.juego=juego;
    }
    @Override
    public void run(){
        anarkyActivity.runOnUiThread(new Runnable() {


            @Override
            public void run() {

                while (juego.getVidas() != 0) {
                    Personaje personaje = juego.crearPersonaje();
                    im.setImageResource(R.drawable.f);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    im.setX((float) personaje.getPosX());
                    im.setY((float) personaje.getPosY());
                }

            }
        });






    }

}
