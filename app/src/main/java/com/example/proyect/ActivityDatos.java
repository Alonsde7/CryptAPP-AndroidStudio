package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.proyect.BaseDeDatos.BaseDeDatos;
import com.example.proyect.BaseDeDatos.Datos;

import java.util.List;

public class ActivityDatos extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressbar;
    List<Datos> misDatos;
    TextView porcentajeAciertos;
    TextView porcentajeFallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        progressbar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);
        porcentajeAciertos = findViewById(R.id.porcentajeAciertos);
        porcentajeFallos = findViewById(R.id.porcentajeFallos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        misDatos = BaseDeDatos.getInstance(getBaseContext().getFilesDir().getPath())
                .getLista();

        AdapterDatos adapter = new AdapterDatos(misDatos);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        calcularPorcentajes(misDatos);
    }

    public void barraProgreso(float porcentaje) {

        runOnUiThread(() -> {
            progressbar.setProgress((int) porcentaje);

            porcentajeAciertos.setText(String.format("%s%%"
                    , Math.round(porcentaje * 100) / 100d));
            
            porcentajeFallos.setText(String.format("%s%%"
                    , Math.round((100 - porcentaje) * 100) / 100d));

        });
    }

    public void calcularPorcentajes(List<Datos> list) {
        new Thread(() -> {
            if (list.size() != 0) {
                float acumulador = 0;
                int size = list.size();
                if (list.get(list.size() - 1).getSuccess().equals("pendiente"))
                    size--;

                for (Datos datos : list)
                    if (datos.getSuccess().equals(datos.getForecast()))
                        acumulador++;

                barraProgreso((acumulador / size) * 100);
            }
        }).start();
    }
}