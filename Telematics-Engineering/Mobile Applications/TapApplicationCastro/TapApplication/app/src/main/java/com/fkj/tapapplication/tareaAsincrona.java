package com.fkj.tapapplication;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import Modelo.Juego;
import Modelo.Personaje;
import Modelo.TipoPersonaje;

/**
 * Created by Juan Pablo on 08/02/2016.
 */
public class tareaAsincrona extends AsyncTask<Void,Float,Boolean> {

    private Juego juego;
    private ImageView im;
    private AnarkyActivity a;

    public tareaAsincrona(Juego juego, ImageView im ,AnarkyActivity a){
        this.juego= juego;
        this.im=im;
        this.a=a;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}


        int contador=50;
        while(juego.getVidas()>0){
            Personaje personaje= juego.getPersonaje();
            publishProgress(personaje.getPosX(),personaje.getPosY());
            contador--;
        }
        return true;
    }
    @Override
    protected void onProgressUpdate(Float... values) {
        im.setImageResource(R.drawable.f);
        im.setX(values[0].floatValue());
        im.setY(values[1].floatValue());


    }
    @Override
    protected void onPostExecute(Boolean result) {
        if(result)
            Toast.makeText(a, "Tarea finalizada!",
                    Toast.LENGTH_SHORT).show();
    }


}
