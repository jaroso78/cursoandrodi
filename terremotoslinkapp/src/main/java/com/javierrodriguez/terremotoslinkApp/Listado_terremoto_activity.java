package com.javierrodriguez.terremotoslinkApp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Listado_terremoto_activity extends ActionBarActivity {

    private ListView terremotoslv;
    private  List<Tarea> datos = new LinkedList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_terremoto_activity);

        terremotoslv= (ListView) findViewById(R.id.terremotosListView);


       datos.add(new Tarea("Correr", "Salir a correr", 1, new Date()));
        datos.add(new Tarea("Nadar", "Salir a nadar a la playa", 2, new Date()));
        datos.add(new Tarea("Ir en bicicleta", "Salir con bici", 3, new Date()));


        TareasAdapter tareasAdapter = new TareasAdapter(this, R.layout.listview_listadoterremotos, datos);
        terremotoslv.setAdapter(tareasAdapter);

        //Vamos a registrar contextMenu en la vista.
        registerForContextMenu(terremotoslv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado_terremoto_activity, menu);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.terremotosListView) {

            getMenuInflater().inflate(R.menu.menu_main, menu);

            //Obtenermos la posición del menu info.
            int posicion = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;


            //Extaemos la tarea de la posición.
            Tarea terremoto = (Tarea) ((AdapterView) v).getAdapter().getItem(posicion);
            menu.setHeaderTitle(terremoto.getNombre());

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        int itemId = item.getItemId();


        if (itemId == R.id.action_settings) {
            //Obtenemos la información del menu.
            ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();


            //Obtenermos la posición del menu info.
            int posicion = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;


            Tarea terremoto = (Tarea) terremotoslv.getAdapter().getItem(posicion);


            //TODO: Comprobar si se encuentra en tableta o en smartphone


            // Fragment_detalle_terremoto fragmentDetails =(Detalle_frament) getFragmentManager().findFragmentById(R.id.fragmentDetalle_large);

            //  if(fragmentDetails !=null)
            {
                //Tablet
                //   fragmentDetails.Actualizar_detalle(tarea);


                //}else
                //{
                //mobile
                Intent intent = new Intent(this, Activity_detalle_terremoto.class);
                intent.putExtra("terremoto", terremoto);
                startActivity(intent);

                //}

                // Toast.makeText(MainActivity.this, "Funciona: " + tarea.getNombre(), Toast.LENGTH_SHORT).show();


            }
        }

        return super.onContextItemSelected(item);


    }
}
