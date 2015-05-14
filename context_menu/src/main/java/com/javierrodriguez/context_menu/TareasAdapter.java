package com.javierrodriguez.context_menu;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by androidm on 13/05/2015.
 */
public class TareasAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Tarea> coleccion;



    public TareasAdapter(Context context, int layout, List<Tarea> coleccion) {
        this.context = context;
        this.layout = layout;
        this.coleccion = coleccion;
    }

    public List<Tarea> getColeccion() {
        return coleccion;
    }

    @Override
    public int getCount() {

        return coleccion.size();

    }

    @Override
    public Object getItem(int position) {

        return coleccion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        /**** para crear programaticamente
        TextView textView = new TextView(context);
        Button button = new Button(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        */

        //TODO: Prueba



        //OBTENEMOS LA ESTRUCTURA DEL ARBOL DE OBJETOS DIBUJADOS EN LA PANTALLA.
        if (convertView== null) { //Sólo dibujo si es la primera vez o no dispone del convertView.
            //Recuperamos el layaout inflater.
            LayoutInflater layaoutinflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Obtenemos el view que hemos inflado.
            convertView = layaoutinflate.inflate(layout, null);
        }

        coleccion.get(position);


       final Tarea item = (Tarea) getItem(position);

        TextView txNombre = (TextView) convertView.findViewById(R.id.txNombre);
        TextView txDescripcion = ( TextView) convertView.findViewById(R.id.txDescripcion);
        /*Button button = (Button)convertView.findViewById(R.id.button);*/

        //button.setOnClickListener(new click());


        txNombre.setText(item.getNombre());
        txDescripcion.setText(item.getDescripcion());



        return convertView;
    }
}
