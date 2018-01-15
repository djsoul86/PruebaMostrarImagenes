package com.example.dj_so.pruebamostrarimagenes;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Dj_So on 15/01/2018.
 */

public class ImageClass {
    public ImageView imagen;
    public ArrayList<String> urls;

    public ArrayList<String> getUrls() {
        return urls;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}
