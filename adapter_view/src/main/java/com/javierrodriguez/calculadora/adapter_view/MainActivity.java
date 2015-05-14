package com.javierrodriguez.calculadora.adapter_view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView tareas = (ListView) findViewById(R.id.TareaslistView);
      /*  String[] datos = new String[] {"Correr", "nadar", "comer"};

        ListAdapter adaptador = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,datos );
        tareas.setAdapter(adaptador);*/

        List<Tarea> datos = new LinkedList<>();
        datos.add (new Tarea("Correr", "Salir a correr"));
        datos.add (new Tarea ("Nadar", "Salir a nadar a la playa"));
        datos.add( new Tarea ("Ir en bicicleta","Salir con bici"));


        TareasAdapter tareasAdapter = new  TareasAdapter(this, R.layout.tareas_list_item, datos);
        tareas.setAdapter(tareasAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}