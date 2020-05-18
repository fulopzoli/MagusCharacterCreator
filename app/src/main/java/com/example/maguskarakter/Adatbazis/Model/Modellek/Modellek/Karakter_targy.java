package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_karaktertargy")
public class Karakter_targy {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String karakternev;
    private String targy;
    private int mennyiseg;

    public Karakter_targy(String karakternev, String targy, int mennyiseg) {
        this.karakternev = karakternev;
        this.targy = targy;
        this.mennyiseg = mennyiseg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKarakternev() {
        return karakternev;
    }

    public void setKarakternev(String karakternev) {
        this.karakternev = karakternev;
    }

    public String getTargy() {
        return targy;
    }

    public void setTargy(String targy) {
        this.targy = targy;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    @NonNull
    @Override
    public String toString() {
        return targy;
    }
}
