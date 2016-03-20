package christian.lopez.trabajos.com.tarea2_mathchallenge;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import modelo.Juego;

public class PantallaJuego extends AppCompatActivity {

    private Juego juego;
    public static String JUEGO = "christian.lopez.trabajos.com.tarea2_mathchallenge.JUEGO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        juego = (Juego) intent.getSerializableExtra(PantallaPrincipal.JUEGO);

        TextView operacion = (TextView) findViewById(R.id.textViewOperacion);

        operacion.setText(juego.getCalculadora().generarOperacion());
    }

    public void jugar(View view){

        EditText operacion = (EditText) findViewById(R.id.editTextRespuestaOperacion);

        try {
            int respuesta = Integer.parseInt(operacion.getText().toString());

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Respuesta");

            if(respuesta==juego.getCalculadora().getResultado()) {
                alertDialog.setMessage("¡" + juego.getUser().getNombre() + " has acertado!");
                juego.getUser().aumentarAciertos();
                operacion.setText("");
            }else{
                alertDialog.setMessage("¡"+juego.getUser().getNombre() + " has fallado! la respuesta era: "+juego.getCalculadora().getResultado());
                juego.getUser().aumentarErrores();
                operacion.setText("");
            }

            alertDialog.show();

            if(juego.getUser().getNumJugadas()<7){
                TextView op = (TextView) findViewById(R.id.textViewOperacion);
                op.setText(juego.getCalculadora().generarOperacion());
            }else{

                Intent intentPantallaFinal = new Intent(this,PantallaFinal.class);
                intentPantallaFinal.putExtra(JUEGO,juego);
                startActivity(intentPantallaFinal);

            }
        }catch (Exception e){
            Toast.makeText(this,"No introdujo un numero, por favor vuelva a intentar",Toast.LENGTH_SHORT ).show();
        }




    }

}
