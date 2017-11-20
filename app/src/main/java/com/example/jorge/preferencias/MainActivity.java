package com.example.jorge.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText dia, mes, cantidad;
    private TextView miPrefe1;
    private SharedPreferences misPreferencias;
    private SharedPreferences.Editor miEditorPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dia = (EditText) findViewById(R.id.dia);
        mes = (EditText) findViewById(R.id.mes);
        cantidad = (EditText) findViewById(R.id.cantidad);
        miPrefe1 = (TextView) findViewById(R.id.textView2);
        misPreferencias = getSharedPreferences("Mis Preferencias", Activity.MODE_PRIVATE);
        miEditorPreferencias = misPreferencias.edit();


        if(misPreferencias.getInt("primeraVez", 1) == 1) {
            String dia = misPreferencias.getString("dia","");
            String mes = misPreferencias.getString("mes","");
            String cantidad = misPreferencias.getString("cantidad","");

            miPrefe1.setText("Dia : "+dia +"\nMes: "+mes+ "\nCantidad: "+cantidad);
        }
        Button miButton = (Button) findViewById(R.id.button);

        miButton.setOnClickListener(new View.OnClickListener() { //añadimos al boton su listener
            @Override
            public void onClick(View v) {
                miEditorPreferencias.putString("Dia", dia.getText().toString());
                miEditorPreferencias.putString("Mes", mes.getText().toString());
                miEditorPreferencias.putString("Cantidad", cantidad.getText().toString());
                miEditorPreferencias.putInt("primeraVez", 1);
                miEditorPreferencias.commit();

                Intent miIntento = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(miIntento);
            }
        });


    }

}

