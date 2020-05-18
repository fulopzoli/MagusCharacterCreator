package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_fajok")
public class Fajok {




    private String Fajnev;
    private int ero;
    private int gyorsasag;
    private int ugyesseg;
    private int allokepeseg;
    private int egeszseg;
    private int szepseg;
    private int inteligencia;
    private int akaratero;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Ignore
    public Fajok(String fajnev, int ero, int gyorsasag, int ugyesseg, int allokepeseg, int egeszseg, int szepseg, int inteligencia, int akaratero) {
        Fajnev = fajnev;
        this.ero = ero;
        this.gyorsasag = gyorsasag;
        this.ugyesseg = ugyesseg;
        this.allokepeseg = allokepeseg;
        this.egeszseg = egeszseg;
        this.szepseg = szepseg;
        this.inteligencia = inteligencia;
        this.akaratero = akaratero;
    }
    public Fajok(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFajnev() {
        return Fajnev;
    }

    public void setFajnev(String fajnev) {
        Fajnev = fajnev;
    }

    public int getEro() {
        return ero;
    }

    public void setEro(int ero) {
        this.ero = ero;
    }

    public int getGyorsasag() {
        return gyorsasag;
    }

    public void setGyorsasag(int gyorsasag) {
        this.gyorsasag = gyorsasag;
    }

    public int getUgyesseg() {
        return ugyesseg;
    }

    public void setUgyesseg(int ugyesseg) {
        this.ugyesseg = ugyesseg;
    }

    public int getAllokepeseg() {
        return allokepeseg;
    }

    public void setAllokepeseg(int allokepeseg) {
        this.allokepeseg = allokepeseg;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public void setEgeszseg(int egeszseg) {
        this.egeszseg = egeszseg;
    }

    public int getSzepseg() {
        return szepseg;
    }

    public void setSzepseg(int szepseg) {
        this.szepseg = szepseg;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAkaratero() {
        return akaratero;
    }

    public void setAkaratero(int akaratero) {
        this.akaratero = akaratero;
    }
}
