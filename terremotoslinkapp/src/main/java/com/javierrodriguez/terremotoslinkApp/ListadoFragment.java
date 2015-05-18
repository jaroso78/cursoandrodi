package com.javierrodriguez.terremotoslinkApp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {


    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }



    //Se dispara cuando la actividad haya generado.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    //Registramos el OnClickListener.
    public void registerListViewTareaOnClikListener(View.OnClickListener listen){
       ListView ListView= (ListView) getActivity().findViewById(R.id.terremotosListView );
       ListView.setOnClickListener(listen);
    }
}
