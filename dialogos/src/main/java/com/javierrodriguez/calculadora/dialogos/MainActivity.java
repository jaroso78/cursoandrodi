package com.javierrodriguez.calculadora.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    private MiDialogoFragment miDialogoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miDialogoFragment = new MiDialogoFragment();

        miDialogoFragment.setOnClickListenerPositive(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Se acepto 2 version", Toast.LENGTH_SHORT).show();
            }
        });

        miDialogoFragment.setOnClickListenerNegative(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Se cancelo 2 version", Toast.LENGTH_SHORT).show();

            }
        });




        FragmentTransaction  fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(miDialogoFragment, "MiDialogoFragment");

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


            miDialogoFragment.show(getFragmentManager(),"MiDialogoFragment");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
