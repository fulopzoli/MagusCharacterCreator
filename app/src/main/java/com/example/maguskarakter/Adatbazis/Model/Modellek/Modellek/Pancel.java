package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_pancel")
public class Pancel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nev;
    private String anyaga;
    private String ar;
    private String leiras;

    private int mgt;
    private int sfE;
    private int suly;

    public Pancel(String nev, String anyaga, String ar, String leiras, int mgt, int sfE, int suly) {
        this.nev = nev;
        this.anyaga = anyaga;
        this.ar = ar;
        this.leiras = leiras;
        this.mgt = mgt;
        this.sfE = sfE;
        this.suly = suly;
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

    public String getAnyaga() {
        return anyaga;
    }

    public void setAnyaga(String anyaga) {
        this.anyaga = anyaga;
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

    public int getMgt() {
        return mgt;
    }

    public void setMgt(int mgt) {
        this.mgt = mgt;
    }

    public int getSfE() {
        return sfE;
    }

    public void setSfE(int sfE) {
        this.sfE = sfE;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }
}