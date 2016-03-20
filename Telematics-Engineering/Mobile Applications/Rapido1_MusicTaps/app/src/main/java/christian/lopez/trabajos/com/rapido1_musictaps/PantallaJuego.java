package christian.lopez.trabajos.com.rapido1_musictaps;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.Burbuja;
import modelo.HiloTiempo;
import modelo.Juego;

public class PantallaJuego extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private MediaPlayer mp;

    private Juego modelo;
    private GestureDetector detector = null;
    private TextView numero;
    private HiloTiempo cronometro;
    private RelativeLayout layout;
    private ArrayList <ImageView> burbujasA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        Typeface font = Typeface.createFromAsset(getAssets(),"Angelface.otf");

        numero = (TextView) findViewById(R.id.numero);
        numero.setTypeface(font);
        //Se recupera intastacia del modelo
        Intent intentPantallaPrincipal = getIntent();
        modelo = (Juego) intentPantallaPrincipal.getSerializableExtra(PantallaPrincipal.JUEGO);
        System.out.println(modelo.generarNotaGanadora()+" - "+((Burbuja)modelo.getBurbujas().get(0)).getIdPosX());
        detector = new GestureDetector(this);
//Se pone a sonas musica
        mp= MediaPlayer.create(PantallaJuego.this,R.raw.kalimba);
        mp.setLooping(true);
        mp.start();


//Se ponen imagenes
        modelo.setTiempoActivo(true);
        cronometro = new HiloTiempo(numero,modelo);
        layout = (RelativeLayout)findViewById(R.id.pantallaJuego);
        burbujasA = new ArrayList<ImageView>();
        refrescarBurbujas();
        cronometro.execute();

    }
    @Override
    public void onResume(){
        super.onResume();
        cronometro = new HiloTiempo(numero,modelo);
        cronometro.execute();


    }
    public void refrescarBurbujas(){

        for(int i =0; i<burbujasA.size();i++) {
            layout.removeView(burbujasA.get(i));
        }
        burbujasA = new ArrayList<ImageView>();

        for (int i=0;i<modelo.getNumBurbujas();i++){

            ImageView burb = new ImageView(this);
            if(modelo.getBurbujas().get(i).getColor()== 0&&modelo.getBurbujas().get(i).getNota()==0 ){
                burb .setImageResource(R.drawable.sola);
            }else if(modelo.getBurbujas().get(i).getColor()== 1&&modelo.getBurbujas().get(i).getNota()==0){
                burb .setImageResource(R.drawable.solaz);
            }else if(modelo.getBurbujas().get(i).getColor()== 2&&modelo.getBurbujas().get(i).getNota()==0){
                burb .setImageResource(R.drawable.solm);
            }


            if(modelo.getBurbujas().get(i).getColor()== 0&&modelo.getBurbujas().get(i).getNota()==1 ){
                burb .setImageResource(R.drawable.corcheaa);
            }else if(modelo.getBurbujas().get(i).getColor()== 1&&modelo.getBurbujas().get(i).getNota()==1){
                burb .setImageResource(R.drawable.corcheaaz);
            }else if(modelo.getBurbujas().get(i).getColor()== 2&&modelo.getBurbujas().get(i).getNota()==1){
                burb .setImageResource(R.drawable.corcheam);
            }


            if(modelo.getBurbujas().get(i).getColor()== 0&&modelo.getBurbujas().get(i).getNota()==2 ){
                burb .setImageResource(R.drawable.uniona);
            }else if(modelo.getBurbujas().get(i).getColor()== 1&&modelo.getBurbujas().get(i).getNota()==2){
                burb .setImageResource(R.drawable.unionaz);
            }else if(modelo.getBurbujas().get(i).getColor()== 2&&modelo.getBurbujas().get(i).getNota()==2){
                burb .setImageResource(R.drawable.unionm);
            }

            burb.setX(modelo.getBurbujas().get(i).getIdPosX());
            burb.setY(modelo.getBurbujas().get(i).getIdPosY());
            burbujasA.add(burb);

            layout.addView(burb);


        }
    }




    public boolean onTouchEvent(MotionEvent event) {
        if(this.detector.onTouchEvent(event)) {
            return true;
        }
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
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("Pos android");
        float x = e.getX()-42;
        float y = e.getY()-240;
        System.out.println(x);
        System.out.println(y);
        if(modelo.acertoEnBurbujaGanadora(x, y)&&modelo.getUsuarios().get(0).getAciertos()<10){
            System.out.println("Gano");
            modelo.getUsuarios().get(0).setAciertos(modelo.getUsuarios().get(0).getAciertos() + 1);
            modelo.jugar();
            refrescarBurbujas();

        }else if(modelo.acertoEnBurbujaGanadora(x,y)&&modelo.getUsuarios().get(0).getAciertos()>=10){
            Intent intento =  new Intent(this,PantallaGanar.class);
            mp.stop();
            intento.putExtra("modelo",modelo);
            modelo.setTiempoActivo(false);
            cronometro.cancel(true);
            cronometro = null;
            startActivity(intento);

            }else{

            System.out.println("Perdio");

               mp.stop();
                modelo.setTiempoActivo(false);
                cronometro.cancel(true);
                cronometro = null;
                Intent intento =  new Intent(this,PantallaFinal.class);

                startActivity(intento);


        }
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}