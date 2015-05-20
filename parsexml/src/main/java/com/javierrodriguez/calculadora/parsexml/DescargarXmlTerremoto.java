package com.javierrodriguez.calculadora.parsexml;

import android.os.AsyncTask;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by androidm on 20/05/2015.
 */
public class DescargarXmlTerremoto extends AsyncTask <String, Void,List<Terremoto>> {

    private ArrayAdapter<Terremoto> adapter;

    public DescargarXmlTerremoto(ArrayAdapter<Terremoto> adapter) {
        this.adapter = adapter;
    }

    @Override
    protected List<Terremoto> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);

            URLConnection con = url.openConnection();

            InputStream is = con.getInputStream();

            return parsearXML(is);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException xexc){
            xexc.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(List<Terremoto> terremotos) {
        super.onPostExecute(terremotos);

        adapter.addAll(terremotos);
        adapter.notifyDataSetChanged();



    }

    private List<Terremoto> parsearXML( InputStream is) throws XmlPullParserException, IOException {


        LinkedList <Terremoto> resultado = new LinkedList<>();

        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(is, "UTF-8");

        int event= parser.getEventType();




        Terremoto terremoto= null;

        while (event != XmlPullParser.END_DOCUMENT){
              String tag = parser.getName();

            if (event == XmlPullParser.START_TAG)
            {
                if (tag.equals("entry")){
                    terremoto = new Terremoto();
                } else if (terremoto!=null) {

                    if (tag.equals("id")){
                        terremoto.setId(parser.nextText());
                    } else if (tag.equals("title")){

                        String p = parser.nextText();
                        String[] split = p.split(" - ");
                        Float magnitud = Float.parseFloat(split[0].split(" ")[0]);
                       terremoto.setMagnitud(magnitud);
                      terremoto.setTitulo(split[1]);

                    } else if (tag.equals("update")){
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                        Date date = null;
                        try {
                            date = dateFormat.parse(parser.nextText());
                            terremoto.setFecha(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }




                    } else if (tag.equals("link")){

                        terremoto.setLink(parser.getAttributeValue(null, "href"));
                        String link = parser.getAttributeValue(null,"href");

                    } else if ( tag.equals("point")){

                        String[] latlon = parser.nextText().split(" ");
                        terremoto.setLongitud(Float.valueOf(latlon[0]));
                        terremoto.setLatitud(Float.valueOf(latlon[1]));
                    }

                }

            }else  if (event == XmlPullParser.END_TAG){
                if (tag.equals("entry")){
                    resultado.add(terremoto);
                    terremoto= null;
                }
            }






            event= parser.next();
        }

        return resultado;


    }
}
