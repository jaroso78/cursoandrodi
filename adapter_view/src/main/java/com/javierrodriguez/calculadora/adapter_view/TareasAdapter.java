package com.javierrodriguez.calculadora.adapter_view;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return null;
    }
}
