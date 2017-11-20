package com.example.jorge.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView miCampo = (TextView) findViewById(R.id.textView);


        SharedPreferences misPreferencias = getSharedPreferences("Mis Preferencias", Activity.MODE_PRIVATE);
        String dia = misPreferencias.getString("dia","");
        String mes = misPreferencias.getString("mes","");
        String cantidad = misPreferencias.getString("cantidad","");


        miCampo.setText("Dia : "+dia +"\nMes: "+mes+ "\nCantidad: "+cantidad);


    }
}