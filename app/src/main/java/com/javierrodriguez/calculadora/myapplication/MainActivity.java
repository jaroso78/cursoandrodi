package com.javierrodriguez.calculadora.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();


    }


    private void initialize(){
        button1 = (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);

       /*CASO 1
        myOnclickListener listener = new myOnclickListener();
        listener.setMiBotton(button2);
        button1.setOnClickListener(listener);*/


        /*CASO2
        button1.setOnClickListener(new myOnclickListener(button2));*/

        /*CASO3
        final String valor ="Valor";
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              button2.setText("Es una prueba");
            }

        });
*/

        button1.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        button2.setText("Aiva la Ostia");
    }
}
