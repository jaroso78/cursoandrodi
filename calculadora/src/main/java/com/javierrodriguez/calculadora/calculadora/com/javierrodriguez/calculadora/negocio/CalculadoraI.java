package com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio;

/**
 * Created by androidm on 11/05/2015.
 */
public interface CalculadoraI {


    public void sumar(String numero);

    public void resta(String numero);

    public void multiplica(String numero);

    public void division(String numero);

    public void borrar();

    public void almacena();

    public void restamemoria(String numero);

    public String muestramemoria();

    public void eliminarmemoria();

    public String cambiarsigno();

    public String raiz();

    public String resultado(String numero);
}
