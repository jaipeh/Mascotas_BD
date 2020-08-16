package com.jaipeh.mascotasapp2.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaipeh.mascotasapp2.Activities.MainActivity;
import com.jaipeh.mascotasapp2.Clases.Mascota;
import com.jaipeh.mascotasapp2.Modelos.ConstructorMascota;
import com.jaipeh.mascotasapp2.R;

import java.util.ArrayList;
import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    private List<Mascota> items;
    private ArrayList<Mascota> favoritos;
    private Context context;

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView raiting;
        public ImageView imageView2;

        public MascotaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            raiting = (TextView) v.findViewById(R.id.raiting);
            imageView2 = (ImageView) v.findViewById(R.id.imageView2);
        }

    }

    public MascotaAdapter(List<Mascota> items, Context context) {

        ConstructorMascota constructorPuppies = new ConstructorMascota(context);

        this.items = items;
        this.favoritos = constructorPuppies.obtenerFavoritos() ;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_mascota, viewGroup, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder viewHolder, final int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());

        ConstructorMascota constructorMascota = new ConstructorMascota(context);

        viewHolder.raiting.setText(String.valueOf(constructorMascota.obtenerRaitingMascota(items.get(i))));


        viewHolder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity ma = (MainActivity) context;

                ConstructorMascota constructorMascota = new ConstructorMascota(ma);
                constructorMascota.darRaitingMascota(items.get(i));

                int raiting = constructorMascota.obtenerRaitingMascota(items.get(i));

                items.get(i).setRaiting(raiting);
                viewHolder.raiting.setText(String.valueOf(items.get(i).getRaiting()));

                for (int z = 0; z < favoritos.size(); z++) {
                    if (favoritos.get(z).getNombre().equals(items.get(i).getNombre())) {
                        favoritos.remove(z);
                    }
                }

                favoritos.add(items.get(i));

                if (favoritos.size() > 5) {
                    favoritos.remove(0);
                }

                ma.setFavoritos(favoritos);
            }
        });

        viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity ma = (MainActivity) context;

                ConstructorMascota constructorMascota = new ConstructorMascota(ma);
                constructorMascota.darRaitingMascota(items.get(i));

                int raiting = constructorMascota.obtenerRaitingMascota(items.get(i));

                items.get(i).setRaiting(raiting);
                viewHolder.raiting.setText(String.valueOf(items.get(i).getRaiting()));

                for (int z = 0; z < favoritos.size(); z++) {
                    if (favoritos.get(z).getNombre().equals(items.get(i).getNombre())) {
                        favoritos.remove(z);
                    }
                }

                favoritos.add(items.get(i));

                if (favoritos.size() > 5) {
                    favoritos.remove(0);
                }

                ma.setFavoritos(favoritos);
            }

        });

    }
    public ArrayList<Mascota> getFavoritos() {
        return favoritos;
    }

}