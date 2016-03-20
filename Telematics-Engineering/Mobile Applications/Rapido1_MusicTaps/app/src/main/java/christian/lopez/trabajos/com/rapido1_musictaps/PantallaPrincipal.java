package christian.lopez.trabajos.com.rapido1_musictaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import modelo.Juego;

public class PantallaPrincipal extends AppCompatActivity {

    private Juego modelo;
    public static String JUEGO = "christian.lopez.trabajos.com.rapido1_musictaps.JUEGO";
    String recibo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        //cada pixel real es 2,461 pixeles de android
        //el ancho tiene un error de 42 pixeles
        //el alto tiene un error de  240
        recibo = getIntent().getStringExtra("hola");
        modelo = new Juego(549, 910, 150, 150);


        ImageView burbGanadora = (ImageView) findViewById(R.id.imageViewInstruccion);
        if(modelo.getNotaGanadora()==0){
            burbGanadora.setImageResource(R.drawable.trasnsol);
        }else if(modelo.getNotaGanadora()==1){
            burbGanadora.setImageResource(R.drawable.trasncorchea);
        }else if(modelo.getNotaGanadora()==2){
            burbGanadora.setImageResource(R.drawable.trasnunion);
        }

            }

    public void comenzarJuego(View view){
        Intent intentPantallaPrincipal = new Intent(this,PantallaJuego.class);
        intentPantallaPrincipal.putExtra(JUEGO,modelo);
        startActivity(intentPantallaPrincipal);
    }
}
