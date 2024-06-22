package com.example.consesionariorodriguez;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Se instancias los botones

    Button Botonregister;

    Button BotonView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se localizan los autos
        Botonregister = findViewById(R.id.button_registrar_auto);
        BotonView = findViewById(R.id.button_ver_autos);



        Botonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoRegister();
            }
        });

        BotonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoView();
            }
        });

    }

    private void GotoView() {
        Intent i = new Intent(MainActivity.this, Vista.class);
        startActivity(i);
    }


    private void GotoRegister(){
        Intent i = new Intent(MainActivity.this, Registro.class);
        startActivity(i);
            }
}