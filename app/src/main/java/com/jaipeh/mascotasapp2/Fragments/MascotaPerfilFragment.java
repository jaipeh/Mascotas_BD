package com.jaipeh.mascotasapp2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaipeh.mascotasapp2.Clases.Mascota;
import com.jaipeh.mascotasapp2.R;
import com.jaipeh.mascotasapp2.Adapters.MascotaAdapter;

import java.util.ArrayList;

public class MascotaPerfilFragment extends Fragment {

    ArrayList<Mascota> miMascota;
    private RecyclerView fotosMiMascota;


    public MascotaPerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mascota_perfil, container, false);

        fotosMiMascota = (RecyclerView) view.findViewById(R.id.recyclerFragmentMiMascota);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        fotosMiMascota.setLayoutManager(gridLayoutManager);

        inicializarListaMiMascota();
        inicializarAdaptador();

        // Inflate the layout for this fragment
        return view;
    }

    public void inicializarListaMiMascota(){

        miMascota = new ArrayList<Mascota>();

        miMascota.add(new Mascota(R.drawable.gato1, "5"));
        miMascota.add(new Mascota(R.drawable.gato1, "3"));
        miMascota.add(new Mascota(R.drawable.gato3, "9"));
        miMascota.add(new Mascota(R.drawable.gato3, "1"));
    }


    public void inicializarAdaptador(){

        MascotaAdapter adaptador = new MascotaAdapter(miMascota, getActivity());
        fotosMiMascota.setAdapter(adaptador);

    }

}

