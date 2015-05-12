package com.javierrodriguez.calculadora.calculadora.com.javierrodriguez.calculadora.negocio;

/**
 * Created by androidm on 11/05/2015.
 */
public class Calculadora implements CalculadoraI {
    private double acarreo, memoria;
    private Operacion operador;


    public enum Operacion{ SUMAR("+"),RESTAR("-"),MULTIPLICAR("*"), DIVIDIR ("/");
        private String operacion;
        Operacion(String operador){
            this.operacion = operador;
        }
        @Override
        public String toString(){
            return operacion;
        }
    }




    @Override
    public void  sumar(String numero){
        operador = Operacion.SUMAR;


        acarreo = Double.valueOf(numero);
    }

    @Override
    public void resta (String numero){
       /* operador= "resta";*/
        operador = Operacion.RESTAR;
        acarreo = Double.valueOf(numero);


    }

    @Override
    public void multiplica (String numero) {
       /* operador="multiplica";*/
        operador = Operacion.MULTIPLICAR;
        acarreo = Double.valueOf(numero);

    }

    @Override
    public void division (String numero) {
       /* operador="divide";*/
        operador = Operacion.DIVIDIR;
        acarreo = Double.valueOf(numero);

    }


    @Override
    public void borrar(){
        acarreo = 0.0;
    }

    @Override
    public void almacena()
    {
        memoria = memoria + acarreo;
    }

    @Override
    public void restamemoria(String numero) {

        memoria = memoria - Double.valueOf(numero);
    }




    @Override
    public String muestramemoria(){
        /*return memoria.toString();*/
        return String.valueOf(memoria);

    }

    @Override
    public void eliminarmemoria(){
        memoria= 0.0;
    }


    @Override
    public String cambiarsigno(){

        acarreo = acarreo * -1;
        return String.valueOf(acarreo);

    }

    @Override
    public String raiz()
    {
        acarreo=  Math.sqrt(acarreo);
        return String.valueOf(acarreo);

    }


    @Override
    public String resultado( String numero){

        switch (operador)
        {
            case SUMAR:  acarreo = acarreo + Double.valueOf(numero);
                break;
            case RESTAR:  acarreo = acarreo - Double.valueOf(numero);
                break;
            case MULTIPLICAR: acarreo = acarreo * Double.valueOf(numero);
                break;
            case DIVIDIR: acarreo = acarreo / Double.valueOf(numero);
                break;

        }

        return String.valueOf(acarreo);
    }

}


