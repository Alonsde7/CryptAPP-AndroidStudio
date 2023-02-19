package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyect.BaseDeDatos.BaseDeDatos;
import com.example.proyect.BaseDeDatos.Datos;
import com.example.proyect.rest.Picasso;

import java.util.Calendar;
import java.util.List;

public class ActivityApuesta extends AppCompatActivity {

    BaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuesta);

        ImageView imagen = (ImageView) findViewById(R.id.Imagengrafico);
        ImageView imagenbtc = findViewById(R.id.Imagenbtc);

        Picasso.picassoGraphic(imagen);
        Picasso.picassoBTCPhoto(imagenbtc);

        String path = getBaseContext().getFilesDir().getPath();

        bd = BaseDeDatos.getInstance(path);
    }

    public void ApuestaSubir(View view) {
        Toast toast = Toast.makeText(this.getBaseContext(), "Ya se ha hecho una apuesta diaria", Toast.LENGTH_SHORT);

        if (apuestaHecha()) {
            toast.show();
        } else
            new Thread(() -> hacerApuesta("1")).start();
    }

    public boolean apuestaHecha() {

        boolean respuesta = false;
        List<Datos> list = bd.getLista();

        if (list.size() > 0)
            respuesta = list.get(list.size() - 1).getSuccess().equals("pendiente");

        return respuesta;
    }

    public void ApuestaBajar(View view) {

        Toast toast = Toast.makeText(this.getBaseContext(), "Ya se ha hecho una apuesta diaria", Toast.LENGTH_SHORT);

        if (apuestaHecha()) {
            toast.show();
        } else
            new Thread(() -> hacerApuesta("0")).start();
    }

    public void hacerApuesta(String forecast) {
        Calendar calendar = Calendar.getInstance();

        Datos datos = new Datos(calendar.get(Calendar.DAY_OF_MONTH)
                , calendar.get(Calendar.MONTH) + 1
                , calendar.get(Calendar.YEAR)
                , forecast
                , "2");

        bd.add(datos);
    }
}