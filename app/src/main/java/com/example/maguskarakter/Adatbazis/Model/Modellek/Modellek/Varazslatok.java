package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "table_spell")
public class Varazslatok {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String pszivagyspell;
    private String magianevnev;// papi tuzvarazslos varazslo  stb
    private String magia_kaszt;// donvik pap boszorkany stb
    private String magianev;
    private String tipus;
    private String manapont;
    private String sebzes;
    private String erosseg;
    private String varazslasidelye;
    private String hatotav;
    private String idotartam;
    private String magiaellenallas;
    private String felhasznalt_mozaik;
    private String leiras;
    private String szfera;

    public Varazslatok(String pszivagyspell, String magianevnev, String magia_kaszt, String magianev, String tipus, String manapont, String sebzes, String erosseg, String varazslasidelye, String hatotav, String idotartam, String magiaellenallas, String felhasznalt_mozaik, String leiras, String szfera) {
        this.pszivagyspell = pszivagyspell;
        this.magianevnev = magianevnev;
        this.magia_kaszt = magia_kaszt;
        this.magianev = magianev;
        this.tipus = tipus;
        this.manapont = manapont;
        this.sebzes = sebzes;
        this.erosseg = erosseg;
        this.varazslasidelye = varazslasidelye;
        this.hatotav = hatotav;
        this.idotartam = idotartam;
        this.magiaellenallas = magiaellenallas;
        this.felhasznalt_mozaik = felhasznalt_mozaik;
        this.leiras = leiras;
        this.szfera = szfera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPszivagyspell() {
        return pszivagyspell;
    }

    public void setPszivagyspell(String pszivagyspell) {
        this.pszivagyspell = pszivagyspell;
    }

    public String getMagianevnev() {
        return magianevnev;
    }

    public void setMagianevnev(String magianevnev) {
        this.magianevnev = magianevnev;
    }

    public String getMagia_kaszt() {
        return magia_kaszt;
    }

    public void setMagia_kaszt(String magia_kaszt) {
        this.magia_kaszt = magia_kaszt;
    }

    public String getMagianev() {
        return magianev;
    }

    public void setMagianev(String magianev) {
        this.magianev = magianev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getManapont() {
        return manapont;
    }

    public void setManapont(String manapont) {
        this.manapont = manapont;
    }

    public String getSebzes() {
        return sebzes;
    }

    public void setSebzes(String sebzes) {
        this.sebzes = sebzes;
    }

    public String getErosseg() {
        return erosseg;
    }

    public void setErosseg(String erosseg) {
        this.erosseg = erosseg;
    }

    public String getVarazslasidelye() {
        return varazslasidelye;
    }

    public void setVarazslasidelye(String varazslasidelye) {
        this.varazslasidelye = varazslasidelye;
    }

    public String getHatotav() {
        return hatotav;
    }

    public void setHatotav(String hatotav) {
        this.hatotav = hatotav;
    }

    public String getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(String idotartam) {
        this.idotartam = idotartam;
    }

    public String getMagiaellenallas() {
        return magiaellenallas;
    }

    public void setMagiaellenallas(String magiaellenallas) {
        this.magiaellenallas = magiaellenallas;
    }

    public String getFelhasznalt_mozaik() {
        return felhasznalt_mozaik;
    }

    public void setFelhasznalt_mozaik(String felhasznalt_mozaik) {
        this.felhasznalt_mozaik = felhasznalt_mozaik;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getSzfera() {
        return szfera;
    }

    public void setSzfera(String szfera) {
        this.szfera = szfera;
    }
}
