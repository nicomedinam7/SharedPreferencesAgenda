package com.example.nicolas.sharedpreferencesagenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private EditText et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_datos = (EditText)findViewById(R.id.txt_datos);

    }

    // Metodo boton guardar

    public void Guardar (View view){

        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();

        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_SHORT).show();
    }

    // Metodo boton buscar

    public void Buscar (View view){

        String nombre = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos = preferencias.getString("nombre", "");

        if(datos.length()==0) {

            Toast.makeText(this," No se encontro ningun registro",Toast.LENGTH_SHORT).show();

        } else{

            et_datos.setText(datos);
        }

    }

}
