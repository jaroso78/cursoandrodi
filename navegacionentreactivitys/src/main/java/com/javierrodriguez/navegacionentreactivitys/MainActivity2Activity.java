package com.javierrodriguez.navegacionentreactivitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;


public class MainActivity2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);


        Informacion recuperamos_variable_string = (Informacion) getIntent().getSerializableExtra("dato");


        Toast toast1 = Toast.makeText(getApplicationContext(), recuperamos_variable_string.getNombre(), Toast.LENGTH_SHORT);

        toast1.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

            Intent intent= new Intent();
            intent.putExtra("resultado","el resultado es bueno");
            setResult(Activity.RESULT_OK,intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
