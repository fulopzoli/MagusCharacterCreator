package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_kasztok")

public class Kasztok {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String fokaszt;
    private String alkaszt ;
    private String kealap;
    private String tealap;
    private String vealap;
    private String cealap;
    private String kpalap;
    private String epalap;
    private String fpalap;
    private String fpszint;
    private String hmszint;
    private String kpszint;
    private String manaperszint;
    private String psziperszint;

    public Kasztok(String fokaszt, String alkaszt, String kealap, String tealap, String vealap, String cealap, String kpalap, String epalap, String fpalap, String hmszint, String kpszint, String manaperszint, String psziperszint ,String fpszint) {
        this.fokaszt = fokaszt;
        this.alkaszt = alkaszt;
        this.kealap = kealap;
        this.tealap = tealap;
        this.vealap = vealap;
        this.cealap = cealap;
        this.kpalap = kpalap;
        this.fpszint=fpszint;
        this.epalap = epalap;
        this.fpalap = fpalap;
        this.hmszint = hmszint;
        this.kpszint = kpszint;
        this.manaperszint = manaperszint;
        this.psziperszint = psziperszint;
    }

    public int getId() {
        return id;
    }

    public String getFpszint() {
        return fpszint;
    }

    public void setFpszint(String fpszint) {
        this.fpszint = fpszint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFokaszt() {
        return fokaszt;
    }

    public void setFokaszt(String fokaszt) {
        this.fokaszt = fokaszt;
    }

    public String getAlkaszt() {
        return alkaszt;
    }

    public void setAlkaszt(String alkaszt) {
        this.alkaszt = alkaszt;
    }

    public String getKealap() {
        return kealap;
    }

    public void setKealap(String kealap) {
        this.kealap = kealap;
    }

    public String getTealap() {
        return tealap;
    }

    public void setTealap(String tealap) {
        this.tealap = tealap;
    }

    public String getVealap() {
        return vealap;
    }

    public void setVealap(String vealap) {
        this.vealap = vealap;
    }

    public String getCealap() {
        return cealap;
    }

    public void setCealap(String cealap) {
        this.cealap = cealap;
    }

    public String getKpalap() {
        return kpalap;
    }

    public void setKpalap(String kpalap) {
        this.kpalap = kpalap;
    }

    public String getEpalap() {
        return epalap;
    }

    public void setEpalap(String epalap) {
        this.epalap = epalap;
    }

    public String getFpalap() {
        return fpalap;
    }

    public void setFpalap(String fpalap) {
        this.fpalap = fpalap;
    }

    public String getHmszint() {
        return hmszint;
    }

    public void setHmszint(String hmszint) {
        this.hmszint = hmszint;
    }

    public String getKpszint() {
        return kpszint;
    }

    public void setKpszint(String kpszint) {
        this.kpszint = kpszint;
    }

    public String getManaperszint() {
        return manaperszint;
    }

    public void setManaperszint(String manaperszint) {
        this.manaperszint = manaperszint;
    }

    public String getPsziperszint() {
        return psziperszint;
    }

    public void setPsziperszint(String psziperszint) {
        this.psziperszint = psziperszint;
    }
}
