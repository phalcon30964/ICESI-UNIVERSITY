package christian.lopez.trabajos.com.tarea2_mathchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import modelo.Juego;

public class PantallaFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intentPantallaJuego = getIntent();

        Juego juego = (Juego) intentPantallaJuego.getSerializableExtra(PantallaJuego.JUEGO);

        TextView resultadoFinal = (TextView) findViewById(R.id.textViewMensajeFinal);

        if(juego.getUser().gano()) {
            resultadoFinal.setText("¡"+juego.getUser().getNombre()+" HAS GANADO! \nTuviste: "+juego.getUser().getAciertos()+" buenas. "+juego.getUser().getErrores()+" malas.");
        }else{
            resultadoFinal.setText("¡"+juego.getUser().getNombre()+" HAS PERDIDO! \nTuviste: "+juego.getUser().getAciertos()+" buenas. "+juego.getUser().getErrores()+" malas.");
        }
    }

}
