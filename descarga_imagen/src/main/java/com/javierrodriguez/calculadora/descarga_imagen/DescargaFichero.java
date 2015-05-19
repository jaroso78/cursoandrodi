package com.javierrodriguez.calculadora.descarga_imagen;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by androidm on 19/05/2015.
 */
public class DescargaFichero extends AsyncTask <String,Integer, Bitmap> {

    private ImageView imageView;
    private ProgressDialog progressDialog;


    public DescargaFichero(ImageView imageView, ProgressDialog progressDialog){
        this.imageView = imageView;
        this.progressDialog = progressDialog;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        //Aquí es donde se realiza la tarea de larga duración.

        try {
            URL uri =new URL(params[0]);

            //Indicamos la conexion y le pasamos un Cast para comprobar que la dirección es correcta.
           URLConnection con= (HttpURLConnection)uri.openConnection();

            //Con esta sentencia nos permite saber el tamaño total del archivo a bajar.
            int tamano = con.getContentLength();

           //Indicamos InputStream
          InputStream is= con.getInputStream();

            //Buffer de los bytes de lectura en tamaño.
            byte[] buffer = new byte[512];
            byte[] imagen= new byte[tamano];


            //PROCESO DE LECTURA Y ALMACENANDO EN LA IMAGEN.
            for(int bytestotalesLeidos =0; bytestotalesLeidos< tamano;){

                int bytesLeidos = is.read(buffer);

                System.arraycopy(buffer, 0, imagen, bytestotalesLeidos, bytesLeidos);

                bytestotalesLeidos += bytesLeidos;


                //  PARA VER EL PROGRESO DE LO LEIDO.
                publishProgress(bytestotalesLeidos*100/tamano);



            }

          // CONVERTIMOS A BITMAP el array leido.

            return BitmapFactory.decodeByteArray(imagen,0,tamano);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }


        return null;
    }

    //METODOS QUE SE ENEJUCTA EN EL MAIN THREAD.



    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null){
            imageView.setImageBitmap(bitmap);
            progressDialog.hide();

        }


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);


    }
}
