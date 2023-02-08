package com.example.listadeenemigos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {

    TextView nombreTV;
    TextView edadTV;
    TextView descripcionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundapantalla);

        nombreTV = findViewById(R.id.nombre2);
        edadTV = findViewById(R.id.edad2);
        descripcionTV = findViewById(R.id.descripcion2);

        Intent intent = getIntent();
        String nombre2 = intent.getStringExtra("Nombre");
        int edad2 = intent.getIntExtra("Edad", 0);
        String descripcion2 = intent.getStringExtra("Descripcion");

        Toast.makeText(this, " Este es el perfil ", Toast.LENGTH_LONG).show();

        nombreTV.setText(nombre2);
        edadTV.setText(""+ edad2);
        descripcionTV.setText(descripcion2);

    }

}
