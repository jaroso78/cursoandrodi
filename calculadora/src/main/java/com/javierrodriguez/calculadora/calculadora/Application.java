package com.javierrodriguez.calculadora.calculadora;

import com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio.CalculadoraI;
import com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio.CalculadoraN;

/**
 * Created by androidm on 11/05/2015.
 */
public class Application extends android.app.Application {

    private CalculadoraI calculadora;

    @Override
    public void onCreate() {
        super.onCreate();

        calculadora = new CalculadoraN();
    }

    public CalculadoraI getCalculadora() {
        return calculadora;
    }
}
