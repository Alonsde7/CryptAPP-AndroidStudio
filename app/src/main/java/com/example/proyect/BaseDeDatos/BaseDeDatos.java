package com.example.proyect.BaseDeDatos;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import com.example.proyect.rest.GeckoCoinAPI;
import com.example.proyect.rest.models.modelsday.Datosdia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


// Supongo que todas las llamadas se tendran que hacer en un thread nuevo

public class BaseDeDatos {

    private List<Datos> list = null;
    private File BASEDEDATOS = null;

    private static BaseDeDatos INSTANCE = null;


    @SuppressLint("SdCardPath")
    private BaseDeDatos(String path) {

        BASEDEDATOS = new File(path + "BaseDeDatos.csv");

        try {
            if (BASEDEDATOS.createNewFile())

                Log.e("Base de Datos", "Fichero creado");


        } catch (IOException e) {
            e.printStackTrace();
        }

        list = fileToList();
    }

    public static BaseDeDatos getInstance(String path) {
        if (INSTANCE == null)
            INSTANCE = new BaseDeDatos(path);
        return INSTANCE;
    }

    public List<Datos> getLista() {
        return list;
    }

    public File getBASEDEDATOS() {
        return BASEDEDATOS;
    }


    private ArrayList<Datos> fileToList() {

        String linea;
        ArrayList<Datos> aux = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(BASEDEDATOS);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((linea = bufferedReader.readLine()) != null)


                aux.add(new Datos(linea.substring(0, 2)
                        , linea.substring(3, 5)
                        , linea.substring(6, 10)
                        , linea.substring(11, 12)
                        , linea.substring(13, 14)));


            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return aux;
    }

    public void add(Datos datos) {


        try {
            FileWriter fileWriter = new FileWriter(BASEDEDATOS, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(datos.toString());

            printWriter.flush();
            printWriter.close();
            fileWriter.close();

            list.add(datos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFichero(List<Datos> list) {


        try {
            FileWriter fileWriter = new FileWriter(BASEDEDATOS);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Datos datos : list)
                printWriter.println(datos.toString());

            printWriter.flush();
            printWriter.close();
            fileWriter.close();

            this.list = list;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeAll() {
        setFichero(new ArrayList<Datos>());
    }

    public void notifyDataSetChange() {
        setFichero(list);
    }

    public void comprobarApuesta() {

        if (list.size() > 0) {
            Datos datos = list.get(list.size() - 1);

            if (datos.getSuccess().equals("pendiente") && datos.esfechaAnterior()) {

                Double[] preciodia = {0.0};
                Double[] precioSiguiente = {0.0};

                GeckoCoinAPI.getInstance()
                        .obtenerDatosBtcDia(
                                "bitcoin"
                                , datos.getFecha()
                                , false)
                        .subscribe(datosdia -> {
                            preciodia[0] = datosdia.getMarketData().getCurrentPrice().getUsd();
                        });

                if (!datos.nextFecha().isToday())

                    GeckoCoinAPI.getInstance()
                            .obtenerDatosBtcDia(
                                    "bitcoin"
                                    , datos.nextFecha().getFecha()
                                    , false)
                            .subscribe(datosdia -> {
                                precioSiguiente[0] = datosdia
                                        .getMarketData()
                                        .getCurrentPrice()
                                        .getUsd();
                            });
                else
                    GeckoCoinAPI.getInstance().obtenetDatosBtc("usd"
                            , "bitcoin"
                            , "market_cap_desc"
                            , 100
                            , 1
                            , false)
                            .subscribe(datosBitcoin -> {
                                precioSiguiente[0] = datosBitcoin.get(0).getCurrentPrice();
                            });

                if (preciodia[0] < precioSiguiente[0])
                    datos.setSuccess(1);

                else datos.setSuccess(0);

                this.notifyDataSetChange();
            }
        }
    }
}
