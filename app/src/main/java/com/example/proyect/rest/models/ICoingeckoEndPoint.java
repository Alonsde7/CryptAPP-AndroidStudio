package com.example.proyect.rest.models;

import com.example.proyect.rest.models.modelsday.Datosdia;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ICoingeckoEndPoint {

    @GET("coins/markets")
    Observable<List<DatosBitcoin>> obtenetDatosBtc(
            @Query("vs_currency") String vs_currency
            , @Query("ids") String ids
            , @Query("order") String order
            , @Query("per_page") int per_page
            , @Query("page") int page
            , @Query("sparkline") boolean sparkline);

    
    @GET("coins/{id}/history")
    Observable<Datosdia> obtenerDatosBtcDia(
            @Path("id") String id
            , @Query("date") String date
            , @Query("localization") Boolean localization);
}
