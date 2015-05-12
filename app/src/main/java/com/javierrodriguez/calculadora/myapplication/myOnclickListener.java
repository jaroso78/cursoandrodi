package com.javierrodriguez.calculadora.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by androidm on 07/05/2015.
 */
public class myOnclickListener   implements View.OnClickListener{


    public myOnclickListener() {
        super();
    }

    public myOnclickListener(Button miBotton) {
        this.miBotton = miBotton;
    }

    private Button miBotton;

    public void setMiBotton(Button miBotton) {
        this.miBotton = miBotton;
    }

    public Button getMiBotton() {
        return miBotton;
    }

    @Override
    public void onClick(View v) {
        Log.i("MI_APP", "Click!");

    }
}
