package com.fkj.tapapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import Modelo.Juego;
import Modelo.Personaje;
import Modelo.Usuario;
import Modelo.hilo;

public class AnarkyActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat gDetector;

    private String userName;

    private TextView gestureTextView, tv_userName, tv_puntaje;

    private ImageView im;

    Juego juego;

    Usuario usuario;
    int puntajeI;
    String puntaje;
    private String mensajePantalla;


    public ImageView getIm() {
        return im;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anarky);

        Intent L = getIntent();

        userName = L.getStringExtra("nombre");

        juego = new Juego(userName);

        //usuario = new Usuario(userName);



        Personaje p = juego.crearPersonaje();

        gestureTextView = (TextView)findViewById(R.id.CGA_TV_Gesture);

        tv_userName = (TextView)findViewById(R.id.tv_userName);
        tv_puntaje = (TextView)findViewById(R.id.tv_puntaje);

        im = (ImageView)findViewById(R.id.imageView);
        im.getLayoutParams().width=128;
        im.getLayoutParams().height=128;



        tv_userName.setText(userName);
       // puntajeI=Integer.parseInt(puntaje);
       // tv_puntaje.setText(puntaje);


        this.gDetector = new GestureDetectorCompat(this,this);

        gDetector.setOnDoubleTapListener(this);

      //  ImageView i = new ImageView(this);
      // hilo h= new hilo(this,juego);
       // h.start();
/*
            new Thread(



        new Runnable() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {


                            @Override
                            public void run() {


                                Personaje personaje = juego.crearPersonaje();
                                im.setImageResource(R.drawable.f);
                                im.setX((float) personaje.getPosX());
                                im.setY((float) personaje.getPosY());




                            }
                        });

                    }
                }
        ).start();
*/

        tareaAsincrona tarea= new tareaAsincrona(juego,im,this);
        tarea.execute();





        //Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.humano);
        //im.setImageBitmap(bImage);



        //im.setBackgroundDrawable(Drawable.createFromPath("/Users/estudiante/Desktop/TapApplication/app/src/main/res/drawable/kus.png"));

        //this.setContentView(im);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        // gestureText.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        //gestureText.setText("onLongPress");

    }


    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        //gestureText.setText("onSingleTapUp");

        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        //gestureText.setText("onDoubleTap");

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        //gestureText.setText("onDoubleTapEvent");

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {

        juego.setTapX((int)event.getX());
        juego.setTapY((int)event.getY());

        float x= event.getX();
        float y= event.getY();

        juego.cambiarPuntaje(x,y);
        juego.crearPersonaje();



       gestureTextView.setText(String.valueOf(juego.getUsuario().getPuntaje()));

        return true;
    }

    //Metodo que crea las notificaciones
    private void mostrarNotificacion(String mensajeMostrar) {

        mensajePantalla = mensajeMostrar;

        //Crear un hilo en el proceso de diseño
        runOnUiThread(new Runnable() {

            //---HILO---
            @Override
            public void run() {

                //Notificacion dependiente de un mensaje
                Toast.makeText(getApplicationContext(), mensajePantalla, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
