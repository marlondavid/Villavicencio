package com.marlonortiz.villavicencio;

import android.os.Bundle;
import android.app.Activity;

public class layout_item extends Activity {
    private int idImage;
    private String accion;

    public layout_item(int idImage, String accion){
        this.idImage = idImage;
        this.accion = accion;
    }

    public int getIdImage(){
        return idImage;
    }

    public String getAccion(){
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_item);
    }



}
