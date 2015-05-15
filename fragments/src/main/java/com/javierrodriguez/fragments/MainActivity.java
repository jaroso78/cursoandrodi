package com.javierrodriguez.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    private ListView tareaslv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tareaslv = (ListView) findViewById(R.id.TareasListView);
      /*  String[] datos = new String[] {"Correr", "nadar", "comer"};

        ListAdapter adaptador = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,datos );
        tareas.setAdapter(adaptador);*/

        List<Tarea> datos = new LinkedList<>();
        datos.add (new Tarea("Correr", "Salir a correr",1, new Date()));
        datos.add (new Tarea ("Nadar", "Salir a nadar a la playa",2,new Date()));
        datos.add(new Tarea("Ir en bicicleta", "Salir con bici",3, new Date()));


        TareasAdapter tareasAdapter = new  TareasAdapter(this, R.layout.tareas_list_item, datos);
        tareaslv.setAdapter(tareasAdapter);



        //Vamos a registrar contextMenu en la vista.
        registerForContextMenu(tareaslv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Sobreescrivimos el onCreateContextMenu, ya que gestiona todos los métodos de creación de onctextview.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()== R.id.TareasListView){

            getMenuInflater().inflate(R.menu.menu_main, menu);

            //Obtenermos la posición del menu info.
            int posicion=  ((AdapterView.AdapterContextMenuInfo)menuInfo).position;


            //Extaemos la tarea de la posición.
            Tarea  tarea = (Tarea) ((AdapterView) v).getAdapter().getItem(posicion);
            menu.setHeaderTitle(tarea.getNombre());

        }



    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {



        //Obtenemos la información del menu.
        ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();



        //Obtenermos la posición del menu info.
        int posicion=  ((AdapterView.AdapterContextMenuInfo)menuInfo).position;


        Tarea tarea= (Tarea) tareaslv.getAdapter().getItem(posicion);


        Toast.makeText(MainActivity.this, "Funciona: " + tarea.getNombre(), Toast.LENGTH_SHORT).show();
        int itemId = item.getItemId();


        if (itemId == R.id.action_settings) {




        }



        return super.onContextItemSelected(item);


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


    @Override
    public void onClick(View v) {

    }
}
