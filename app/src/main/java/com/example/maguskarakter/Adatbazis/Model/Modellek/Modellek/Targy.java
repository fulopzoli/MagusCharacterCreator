package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_targy")
public class Targy {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String targynev;
    private String leiras;

    public Targy(String targynev, String leiras) {
        this.targynev = targynev;
        this.leiras = leiras;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTargynev() {
        return targynev;
    }

    public void setTargynev(String targynev) {
        this.targynev = targynev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    @NonNull
    @Override
    public String toString() {
        return targynev;
    }
}
