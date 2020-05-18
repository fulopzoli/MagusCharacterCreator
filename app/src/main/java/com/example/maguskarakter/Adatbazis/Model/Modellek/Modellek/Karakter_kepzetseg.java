package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_karakterkepz")
public class Karakter_kepzetseg {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String karakternev;
    private String kepzetsegnev;
    private String fok;
    private String szazalek;
    private boolean csukva;

    public boolean isCsukva() {
        return csukva;
    }

    public void setCsukva(boolean csukva) {
        this.csukva = csukva;
    }

    public Karakter_kepzetseg(String karakternev, String kepzetsegnev, String fok, String szazalek) {
        this.karakternev = karakternev;
        this.kepzetsegnev = kepzetsegnev;
        this.fok = fok;
        this.szazalek = szazalek;
        csukva=false;
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

    public String getKepzetsegnev() {
        return kepzetsegnev;
    }

    public void setKepzetsegnev(String kepzetsegnev) {
        this.kepzetsegnev = kepzetsegnev;
    }

    public String getFok() {
        return fok;
    }

    public void setFok(String fok) {
        this.fok = fok;
    }

    public String getSzazalek() {
        return szazalek;
    }

    public void setSzazalek(String szazalek) {
        this.szazalek = szazalek;
    }
}
