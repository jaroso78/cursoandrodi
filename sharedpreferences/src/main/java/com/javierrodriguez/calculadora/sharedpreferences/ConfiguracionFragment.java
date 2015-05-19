package com.javierrodriguez.calculadora.sharedpreferences;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionFragment extends PreferenceFragment {


    public ConfiguracionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);  }




}
