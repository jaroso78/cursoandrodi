package com.javierrodriguez.terremotoslinkApp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private ImageButton boton_cal;
    private Button boton_bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializa();
    }


    public void inicializa(){
        boton_cal = (ImageButton) findViewById(R.id.button_calen);

        boton_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoPersonalizadoCalendario dialogo = new DialogoPersonalizadoCalendario();
                 //dialogo.show(fragmentManager,"prueba");
                dialogo.show(fragmentManager,"prueba");

            }
        });

        boton_bus= (Button) findViewById(R.id.button_busqueda);
        boton_bus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent miIntenListadoterremotos = new Intent(MainActivity.this , Listado_terremoto_activity.class);
                startActivity(miIntenListadoterremotos);

            }
        });




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



        switch (id) {
            case R.id.action_settings:
                Intent miIntsettings = new Intent(this, SettingsActivity.class);
                startActivity(miIntsettings);
                break;
            case R.id.help:
                Intent miInt = new Intent(this, HelpActivity.class);
                startActivity(miInt);
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
