package christian.lopez.trabajos.com.rapido1_musictaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PantallaFinal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);
    }

    public void devolverse(View view){

        Intent i = new Intent(this, PantallaPrincipal.class);
        startActivity(i);


    }
}
