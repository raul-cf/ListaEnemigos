package com.example.listadeenemigos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText nombreET;
    EditText edadET;
    EditText descripcionET;
    ListView lista;

    ArrayList<String> nombreEnemigos = new ArrayList<>();
    ArrayList<Enemigo> enemigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreET = findViewById(R.id.nombre);
        edadET = findViewById(R.id.edad);
        descripcionET = findViewById(R.id.descripcion);
        lista = findViewById(R.id.lista);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreEnemigos);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
    }


    public void anadir(View view) {

        if (nombreET.getText().length() > 0) {


            if (Integer.parseInt(edadET.getText().toString()) > 0 && Integer.parseInt(edadET.getText().toString()) < 150) {
                Toast.makeText(this, " Enemigo añadido ", Toast.LENGTH_LONG).show();
                Enemigo malo = new Enemigo(nombreET.getText().toString(), Integer.parseInt(edadET.getText().toString()), descripcionET.getText().toString());
                enemigos.add(malo);

                nombreEnemigos.add(nombreET.getText().toString());
                ArrayAdapter adapter = (ArrayAdapter) lista.getAdapter();
                adapter.notifyDataSetChanged();
            }
        } else if (nombreET.getText().length() < 1) {
            Toast.makeText(this, " Falta nombre ", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Enemigo enemigo1 = new Enemigo("",0, "");
        enemigo1 = enemigos.get(i);

        Intent intent = new Intent(this, SegundaPantalla.class);
        intent.putExtra("Nombre", enemigo1.nombre);
        intent.putExtra("Edad", enemigo1.edad);
        intent.putExtra("Descripcion", enemigo1.descripcion);
        startActivity(intent);

    }


}