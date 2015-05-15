package com.javierrodriguez.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Detalle_frament extends Fragment {


    public Detalle_frament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_frament, container, false);
    }

    //Actualiza el arbol de componentes del fragment.
    public void Actualizar_detalle(Tarea tarea) {


        TextView txnombre = (TextView) getActivity().findViewById(R.id.txNombre);
        TextView txdescripcion = (TextView) getActivity().findViewById(R.id.txDescripcion);
        TextView txprioridad = (TextView) getActivity().findViewById(R.id.txPrioridad);
        TextView txfecha = (TextView) getActivity().findViewById(R.id.txFecha);

        txnombre.setText(tarea.getNombre());
        txdescripcion.setText(tarea.getDescripcion());
        txprioridad.setText(String.valueOf(tarea.getPrioridad()));
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
        txfecha.setText(formatDate.format(tarea.getFecha()));

    }

}
