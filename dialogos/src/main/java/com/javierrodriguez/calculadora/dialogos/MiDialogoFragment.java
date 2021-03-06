package com.javierrodriguez.calculadora.dialogos;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MiDialogoFragment extends DialogFragment {


      private   DialogInterface.OnClickListener listenBotonPositive;
      private   DialogInterface.OnClickListener listenBotonNegative;






   // private  AlertDialog.Builder factoria;
    public MiDialogoFragment() {
        // Required empty public constructor



    }


    //PATRONES FACTORIA.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
                //Necesitamos una factoria.
      factoria = new AlertDialog.Builder(getActivity());

                //Configuramos la factoria

        factoria.setMessage("Desea continuar");
       factoria.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(),"Se acepto",Toast.LENGTH_SHORT).show();

            }
        });


        factoria.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"No se acepto",Toast.LENGTH_SHORT).show();
            }
        });

                //Creamos el dialogo.
        AlertDialog alertDialog = factoria.create();
        */
    }



    //Cuando me cree la factoria.

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Necesitamos una factoria.
        AlertDialog.Builder factoria = new AlertDialog.Builder(getActivity());

        //Configuramos la factoria

        factoria.setMessage("Desea continuar");

        factoria.setPositiveButton("Si",listenBotonPositive);
        factoria.setNegativeButton("No",listenBotonNegative);

        /*factoria.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(),"Se acepto",Toast.LENGTH_SHORT).show();

            }
        });


        factoria.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"No se acepto",Toast.LENGTH_SHORT).show();
            }
        });*/

        return factoria.create();

    }

    public void setOnClickListenerPositive(DialogInterface.OnClickListener listener){

        this.listenBotonPositive= listener;

}



    public void setOnClickListenerNegative(DialogInterface.OnClickListener listener){
        this.listenBotonNegative= listener;
    }

}
