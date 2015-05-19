package com.javierrodriguez.calculadora.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent intent = new Intent (this, ConfiguracionActivity.class);
            startActivity(intent);
            return true;
        }

        if (id ==R.id.leer_settings)
        {
            String mensaje = null;

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String preferencias = preferences.getString("Frecuencias", "0");
            String url = preferences.getString("Url", "https://www.google.com");

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Frecuencia","15");
            editor.putString("Url","http://www.elmundo.es");

            editor.commit();




            mensaje ="Los valores de preferencia son: " + url + " Frecuencia " + preferencias;


            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
