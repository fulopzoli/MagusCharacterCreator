package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_kepzetseg")
public class Kepzetseg {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nev;
    private String leiras;


    public Kepzetseg(String nev, String leiras) {
        this.nev = nev;

        this.leiras = leiras;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}
