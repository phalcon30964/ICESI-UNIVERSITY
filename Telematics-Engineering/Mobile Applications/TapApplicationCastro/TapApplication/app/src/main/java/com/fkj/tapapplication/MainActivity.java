package com.fkj.tapapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    EditText AMnombre;
    Button AMavanzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AMnombre  = (EditText)findViewById(R.id.AMeditText);
        AMavanzar = (Button)findViewById(R.id.AMbutton);

        AMavanzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

        //if((AMnombre.getText().toString() != null) || (AMnombre.getText().toString() != "")) {
            //user.setNombre(AMnombre.getText().toString());

          //  AMnombre.setHint("Nooooooooooooooo");

       // }else{

            nombre = AMnombre.getText().toString();

            Intent i = new Intent(MainActivity.this, AnarkyActivity.class);

            i.putExtra("nombre", nombre);

            startActivity(i);

            }
           // }
        });
    }
}
