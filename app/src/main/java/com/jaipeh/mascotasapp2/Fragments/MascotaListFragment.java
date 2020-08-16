package com.jaipeh.mascotasapp2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaipeh.mascotasapp2.Activities.MainActivity;
import com.jaipeh.mascotasapp2.Adapters.MascotaAdapter;
import com.jaipeh.mascotasapp2.Clases.Mascota;
import com.jaipeh.mascotasapp2.Modelos.ConstructorMascota;
import com.jaipeh.mascotasapp2.R;

import java.util.ArrayList;
import java.util.List;

public class MascotaListFragment extends Fragment {

    private MascotaAdapter adapter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;


    public MascotaListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota_list, container, false);

        ConstructorMascota constructorMascota = new ConstructorMascota(getActivity());

        List items = constructorMascota.obtenerDatos();

        MainActivity ma = (MainActivity) getActivity();
        ma.setFavoritos(constructorMascota.obtenerFavoritos());

        recycler = (RecyclerView) v.findViewById(R.id.mascotaslist);

        if (recycler != null) {
            recycler.setHasFixedSize(true);
        }

        layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);

        adapter = new MascotaAdapter(items, getActivity());

        recycler.setAdapter(adapter);

        return v;
    }

    public ArrayList<Mascota> getMascotasFavoritos(){
        return adapter.getFavoritos();
    }

}
