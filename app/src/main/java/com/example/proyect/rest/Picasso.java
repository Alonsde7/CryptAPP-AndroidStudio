package com.example.proyect.rest;

import android.widget.ImageView;

//https://s3.coinmarketcap.com/generated/sparklines/web/1d/usd/1.png     ->   grafico
//https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579  -> imagen btc

public class Picasso {

    public static void picassoGraphic(ImageView imagen){

        String URLFoto = "https://s3.coinmarketcap.com/generated/sparklines/web/1d/usd/1.png";
        com.squareup.picasso.Picasso.get()
                .load(URLFoto)
                .resize(135*8,50*6)
                .into(imagen);
    }

    public static void picassoBTCPhoto(ImageView imagen){

        String URLFoto = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579";
        com.squareup.picasso.Picasso.get()
                .load(URLFoto)
                .into(imagen);

    }
}