package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_karakterfegyver")
public class Karakter_fegyver {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String karakternev;
    private String karakterfegyvernev;

    public Karakter_fegyver(String karakternev, String karakterfegyvernev) {
        this.karakternev = karakternev;
        this.karakterfegyvernev = karakterfegyvernev;
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

    public String getKarakterfegyvernev() {
        return karakterfegyvernev;
    }

    public void setKarakterfegyvernev(String karakterfegyvernev) {
        this.karakterfegyvernev = karakterfegyvernev;
    }
}
