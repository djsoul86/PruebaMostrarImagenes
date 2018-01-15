package com.example.dj_so.pruebamostrarimagenes;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> lista = new ArrayList<>();
        lista.add("images");
        lista.add("sample");
        ImageView imagen = (ImageView)findViewById(R.id.imageView);
        ImageClass img = new ImageClass();
        img.setUrls(lista);
        img.setImagen(imagen);
        new DescargarImagen().execute(img);
    }

    static class DescargarImagen extends AsyncTask<Object,Void,ArrayList<Bitmap>>{
        ImageView imagen;
        Bitmap bitm;

        @Override
        protected ArrayList<Bitmap> doInBackground(Object... params) {
            ImageClass n = new ImageClass();
            n = (ImageClass)params[0];
            imagen = n.getImagen();
            ArrayList<String> lst = new ArrayList<>();
            ArrayList<Bitmap> images = new ArrayList<>();
            lst = n.getUrls();
            for(int i=0;i<lst.size();i++) {
                try {
                    URL imageUrl = new URL("http://10.0.2.2/RequestManagement/files/" + lst.get(i) + ".jpg");
                    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    bitm = BitmapFactory.decodeStream(conn.getInputStream());
                    images.add(bitm);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return images;
        }
        @Override
        protected  void onPostExecute(ArrayList<Bitmap> result){
            for(int i=0;i<result.size();i++){
                imagen.setImageBitmap(result.get(i));
                super.onPostExecute(result);
            }
        }
    }
}
