package com.javierrodriguez.calculadora.calculadora;

import android.app.*;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio.CalculadoraI;
import com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio.CalculadoraN;


public class CalculadoraActivity extends Activity implements View.OnClickListener {

    private Button button, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,  button11, button12, button13, button14, button15, button16,button17,button18, button20, button21, button22, button23;
    private TextView miTextView;
    private CalculadoraI calculadoran;
    private Boolean inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialite();
    }

    public void initialite(){


       com.javierrodriguez.calculadora.calculadora.Application miaplicacion = (com.javierrodriguez.calculadora.calculadora.Application) this.getApplication();
       calculadoran =miaplicacion.getCalculadora();





        inicio = true;

        miTextView = (TextView) findViewById(R.id.textView);


        //BOTONES NUMÉRICOS.
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.button5);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.button6);
        button5.setOnClickListener(this);
        button6 = (Button)findViewById(R.id.button7);
        button6.setOnClickListener(this);
        button8 = (Button)findViewById(R.id.button9);
        button8.setOnClickListener(this);
        button9 = (Button)findViewById(R.id.button10);
        button9.setOnClickListener(this);
        button10= (Button) findViewById(R.id.button11);
        button10.setOnClickListener(this);
        button14=(Button) findViewById(R.id.button14);
        button14.setOnClickListener(this);
        button20=(Button) findViewById(R.id.button20);
        button20.setOnClickListener(this);


        //OPERACIONES DE SUMA//
        button3 = (Button) findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           calculadoran.sumar(miTextView.getText().toString());
                miTextView.setText("");


            }
        });

        //OPERACIONES DE RESTA//
        button7 = (Button) findViewById(R.id.button8);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calculadoran.resta(miTextView.getText().toString());
                miTextView.setText("");

            }
        });

        //OPERACIONES DE MULTIPLICACIÓN//
        button11 = (Button) findViewById(R.id.button12);
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculadoran.multiplica(miTextView.getText().toString());
                miTextView.setText("");

            }
        });


        //OPERACIONES DE DIVISIÓN//
            button13 = (Button) findViewById(R.id.button15);
            button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadoran.division(miTextView.getText().toString());
                miTextView.setText("");
            }
        });


        //OPERACIONES DE RESULTADO//
        button12 = (Button) findViewById(R.id.button13);
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String resultado = calculadoran.resultado(miTextView.getText().toString());
                miTextView.setText(resultado);

            }
        });

        //OPERACIÓN DE BORRADO//
        button15 =(Button) findViewById(R.id.button16);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTextView.setText("0.0");
                calculadoran.borrar();
                inicio=true;

            }
        });


        //OPERACIÓN DE ALMACEN EN LA MEMORIA//
        button16 = (Button) findViewById(R.id.button17);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadoran.almacena();
                miTextView.setText("");
            }
        });

        //OPERACIÓN RESTA DE MEMORIA//
        button17 = (Button) findViewById(R.id.button18);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadoran.restamemoria(miTextView.getText().toString());
                miTextView.setText("");
            }
        });

        //OPERACIÓN MUESTRA MEMORIA//
        button18 = (Button) findViewById(R.id.button19);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = calculadoran.muestramemoria();
                miTextView.setText(resultado);
            }
        });

        //OPERACIÓN ELIMINAR MEMORIA//
    button21 = (Button)findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadoran.eliminarmemoria();
            }
        });


        //CAMBIO + - //
        button22 = (Button)findViewById(R.id.button22);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String resultado=  calculadoran.cambiarsigno();
                miTextView.setText(resultado);
            }
        });

        //OPERACION SQRT //
        button23 =(Button)findViewById(R.id.button23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado= calculadoran.raiz();
                miTextView.setText(resultado);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


if (inicio){
    miTextView.setText(((Button) v).getText());
    inicio=false;

}else{
           miTextView.append(((Button) v).getText());

    }
    }
}
