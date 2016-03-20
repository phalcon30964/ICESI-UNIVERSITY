package christian.lopez.trabajos.com.rapido1_musictaps;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import modelo.Juego;

public class PantallaGanar extends AppCompatActivity implements View.OnClickListener {
TextView tiempo;
    ImageButton volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ganar);
        tiempo =(TextView) findViewById(R.id.tiempo);
        volver=(ImageButton) findViewById(R.id.vuelve);

        Typeface font = Typeface.createFromAsset(getAssets(),"Angelface.otf");
        tiempo.setTypeface(font);
        Intent intento= getIntent();
        Juego modelo = (Juego) intento.getSerializableExtra("modelo");
        tiempo.setText(modelo.getUsuarios().get(0).getTiempo()+"");

volver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, PantallaPrincipal.class);
        startActivity(i);
    }
}
