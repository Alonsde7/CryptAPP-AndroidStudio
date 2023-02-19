package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyect.BaseDeDatos.BaseDeDatos;
import com.example.proyect.rest.GeckoCoinAPI;
import com.example.proyect.rest.Picasso;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/*TODO:
 * - Crear notificaciones.
 * - Llenar mas la base de datos
 * - Actualización automatica del precio.
 * - Poner título a la activity de datos*/

public class MainActivity extends AppCompatActivity {

    private TextView dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagen = findViewById(R.id.Gráfico);
        ImageView imagenbtc = findViewById(R.id.imagenlogobitcoin);

        dinero = findViewById(R.id.PrecioCurrency);

        Picasso.picassoGraphic(imagen);
        Picasso.picassoBTCPhoto(imagenbtc);

        ObtenerPrecioNuevo();

        BaseDeDatos bd = BaseDeDatos.getInstance(getBaseContext().getFilesDir().getPath());

        comprbarBasedeDatos(bd);

    }

    public void ObtenerPrecioNuevo() {

        GeckoCoinAPI.getInstance()
                .obtenetDatosBtc("usd"
                        ,"bitcoin"
                        ,"market_cap_desc"
                        ,100
                        ,1
                        ,false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( datosBitcoins -> {
                    dinero.setText(String.format("%s $", datosBitcoins.get(0).getCurrentPrice().toString()));
                });
    }

    public void ActualizarPrecio(View view) {
        ObtenerPrecioNuevo();

    }

    public void ActivityDatos(View view) {

        Intent intent = new Intent(MainActivity.this, ActivityDatos.class);
        startActivity(intent);

    }

    public void ActivityApuesta(View view) {

        Intent intent = new Intent(MainActivity.this, ActivityApuesta.class);
        startActivity(intent);
    }

    public void comprbarBasedeDatos(BaseDeDatos baseDeDatos) {
        new Thread(baseDeDatos::comprobarApuesta).start();
    }
}