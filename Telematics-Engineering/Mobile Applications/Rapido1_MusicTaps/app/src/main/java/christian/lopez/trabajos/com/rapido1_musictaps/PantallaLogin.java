package christian.lopez.trabajos.com.rapido1_musictaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PantallaLogin extends AppCompatActivity implements View.OnClickListener {

    ImageButton uno ;
    String saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
         saludo="comienza";
        uno = (ImageButton)findViewById(R.id.jugarUno);
        uno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.jugarUno){
            Intent intento =  new Intent(this,PantallaPrincipal.class);
            intento.putExtra("hola",saludo);
            startActivity(intento);
        }
    }
}
