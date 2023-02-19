package com.example.proyect.rest;

import com.example.proyect.rest.models.ICoingeckoEndPoint;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeckoCoinAPI {

    private static final String URLAPI = "https://api.coingecko.com/api/v3/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URLAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    private static final ICoingeckoEndPoint service = retrofit.create(ICoingeckoEndPoint.class);

    public static ICoingeckoEndPoint getInstance(){
        return service;
    }
}
