package com.example.proyect;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyect.BaseDeDatos.Datos;

import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {

    private final List<Datos> list;

    public AdapterDatos(List<Datos> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fecha.setText(list.get(position).getFecha());
        holder.apuesta.setText(list.get(position).getForecast());

        if (list.get(position).getSuccess().equals(list.get(position).getForecast())) {
            holder.fecha.setTextColor(Color.parseColor("#09FF00"));
            holder.apuesta.setTextColor(Color.parseColor("#09FF00"));

        } else if (!list.get(position).getSuccess().equals("pendiente")) {
            holder.fecha.setTextColor(Color.parseColor("#FF0000"));
            holder.apuesta.setTextColor(Color.parseColor("#FF0000"));
        }

        String URLFoto = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579";
        com.squareup.picasso.Picasso.get()
                .load(URLFoto)
                .resize(60,60)
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView fecha;
        private final TextView apuesta;
        private final ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha);
            apuesta = itemView.findViewById(R.id.sube);
            imagen = itemView.findViewById(R.id.imagenlogo);

        }
    }
}
