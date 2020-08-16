package com.jaipeh.mascotasapp2.Modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.jaipeh.mascotasapp2.BaseDatos.ConstantesDB;
import com.jaipeh.mascotasapp2.BaseDatos.MascotaDB;
import com.jaipeh.mascotasapp2.Clases.Mascota;
import com.jaipeh.mascotasapp2.R;

import java.util.ArrayList;

public class ConstructorMascota {

    private static final int RAITING = 1;
    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        MascotaDB db = new MascotaDB(context);

        if (db.mascotaVacio()) {
            insertarOchoPuppies(db);
        }

        return  db.obtenerPuppies();
    }

    public ArrayList<Mascota> obtenerFavoritos() {
        MascotaDB db = new MascotaDB(context);
        return  db.obtenerPuppiesFavoritos();
    }


    public void darRaitingMascota(Mascota mascota){
        MascotaDB db = new MascotaDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_RAITING_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO, RAITING);
        db.insertarRaitingMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascota mascota){
        MascotaDB db = new MascotaDB(context);
        return db.obtenerRaitingMascota(mascota);
    }

    public void insertarOchoPuppies(MascotaDB db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Russy");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.cerdo);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Goloso");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.conejo);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Genius");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.gato);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Kike");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.jirafa);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Pochito");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.leon);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Galan");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.pez);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Duque");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.pinguino);

        db.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Donatto");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_IMAGEN, R.drawable.loro);

        db.insertarPuppy(contentValues);

    }


}
