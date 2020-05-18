package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_fegyverek")
public class Fegyverek {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String fegyvernev;
    private  String sebzes;
    private String kategoria;
    private int se;
    private int ve;
    private int ke;
    private String suly;
    private String ar;
    private String leiras;

    public Fegyverek(String fegyvernev, String sebzes, String kategoria, int se, int ve, int ke, String suly, String ar, String leiras) {
        this.fegyvernev = fegyvernev;
        this.sebzes = sebzes;
        this.kategoria = kategoria;
        this.se = se;
        this.ve = ve;
        this.ke = ke;
        this.suly = suly;
        this.ar = ar;
        this.leiras = leiras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFegyvernev() {
        return fegyvernev;
    }

    public void setFegyvernev(String fegyvernev) {
        this.fegyvernev = fegyvernev;
    }

    public String getSebzes() {
        return sebzes;
    }

    public void setSebzes(String sebzes) {
        this.sebzes = sebzes;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getSe() {
        return se;
    }

    public void setSe(int se) {
        this.se = se;
    }

    public int getVe() {
        return ve;
    }

    public void setVe(int ve) {
        this.ve = ve;
    }

    public int getKe() {
        return ke;
    }

    public void setKe(int ke) {
        this.ke = ke;
    }

    public String getSuly() {
        return suly;
    }

    public void setSuly(String suly) {
        this.suly = suly;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
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
        return fegyvernev;
    }
}
