package com.example.proyect.BaseDeDatos;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class Datos {

    //la fecha es del dia en e lque se hizo la apuesta
    private String day;
    private String month;
    private String year;
    private String forecast;
    private String success;

    //forecast 0-> baja         1-> sube
    //sucess 0-> baja           1-> sube        2->nomirada


    public Datos(String day, String month, String year, String forecast, String success) {

        setDay(day);
        setMonth(month);
        setYear(year);

        setForecast(forecast);
        setSuccess(success);
    }

    public Datos(int day, int month, int year, String forecast, String success) {

        setDay(day);
        setMonth(month);
        setYear(year);

        setForecast(forecast);
        setSuccess(success);
    }

    public String getFecha() {
        return day + "-" + month + "-" + year;
    }

    public void setDay(String day) {

        if (day.length() == 1)
            day = "0" + day;

        this.day = day;
    }

    public void setDay(int day) {
        setDay(String.valueOf(day));
    }

    public void setMonth(String month) {
        if (month.length() == 1)
            month = "0" + month;

        this.month = month;
    }

    public void setMonth(int month) {
        setMonth(String.valueOf(month));
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setYear(int year) {
        this.year = String.valueOf(year);
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getForecast() {
        String resultado;
        if (forecast.equals("0"))
            resultado = "baja";
        else
            resultado = "sube";

        return resultado;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public void setForecast(int forecast) {
        setForecast(String.valueOf(forecast));
    }

    public String getSuccess() {
        String resultado;
        if (success.equals("0"))
            resultado = "baja";
        else if (success.equals("1"))
            resultado = "sube";
        else
            resultado = "pendiente";
        return resultado;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setSuccess(int success) {
        setSuccess(String.valueOf(success));
    }

    public boolean dateEquals(Datos datosAComparar) {

        return day.equals(datosAComparar.getDay()) &&
                month.equals(datosAComparar.getMonth()) &&
                year.equals(datosAComparar.getYear());
    }

    @Override
    public String toString() {

        return day + "," + month + "," + year + "," + forecast + "," + success;
    }

    public Datos nextFecha() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Integer.parseInt(year)
                , Integer.parseInt(month) - 1
                , Integer.parseInt(day));

        calendar.add(Calendar.DATE, 1);

        return new Datos(calendar.get(Calendar.DAY_OF_MONTH)
                , calendar.get(Calendar.MONTH) + 1
                , calendar.get(Calendar.YEAR)
                , forecast
                , success);
    }

    public boolean isToday() {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.HOUR,2); // se añaden 2h para que cuadre con la hora actual

        return Integer.parseInt(day) == (calendar.get(Calendar.DAY_OF_MONTH))
                && Integer.parseInt(month) == calendar.get(Calendar.MONTH) + 1
                && Integer.parseInt(year) == calendar.get(Calendar.YEAR);
    }

    public boolean esfechaAnterior(){

        //no hace falta añadir 2h porqque ambos calendarias estan en la misma zona horaria
        Calendar calendar = Calendar.getInstance(); //hoy
        Calendar compare = Calendar.getInstance(); //dia a partir del cual hay que comparar
        Datos datos = this.nextFecha();

        compare.set(Integer.parseInt(datos.getYear())
                ,Integer.parseInt(datos.getMonth())-1
                ,Integer.parseInt(datos.getDay()));

        return calendar.get(Calendar.YEAR)> compare.get(Calendar.YEAR)
                || calendar.get(Calendar.MONTH)>compare.get(Calendar.MONTH)
                || calendar.get(Calendar.DAY_OF_MONTH) >= compare.get(Calendar.DAY_OF_MONTH);
    }
}