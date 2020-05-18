package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "table_karakter")
public class Karakter {
    @PrimaryKey(autoGenerate = true)
    private int id;


    private String nev;
    private String kaszt;
    private String faj;
    private String jellem;
    private String vallas;
    private String szulofold;
    private String iskola;

    private int szint;
    private int kor;

    //statok
    private int ero;
    private int gyorsasag;
    private int ugyesseg;
    private int allokepeseg;
    private int egeszseg;
    private int szepseg;
    private int inteligencia;
    private int akaratero;
    private int asztral;
    private int maxAsztral;
    private int alapAsztral;
    private int mana;
    private int maxmana;

    //Pénz
    private int arany;
    private int ezust;
    private int rez;

    //harcstatok
    private int ke;
    private int te;
    private int ve;
    private int ce;
    private int hm;
    private int maxep;
    private int ep;
    private int maxfp;
    private int fp;
    private int mgt;

    private int karakterkep;

    public Karakter(String nev, String kaszt, String faj, String jellem, String vallas, String szulofold, String iskola, int szint, int kor, int ero, int gyorsasag, int ugyesseg, int allokepeseg, int egeszseg, int szepseg, int inteligencia, int akaratero, int asztral, int maxAsztral, int alapAsztral, int mana, int maxmana, int arany, int ezust, int rez, int ke, int te, int ve, int ce, int hm, int maxep, int ep, int maxfp, int fp, int mgt, int karakterkep) {
        this.nev = nev;
        this.kaszt = kaszt;
        this.faj = faj;
        this.jellem = jellem;
        this.vallas = vallas;
        this.szulofold = szulofold;
        this.iskola = iskola;
        this.szint = szint;
        this.kor = kor;
        this.ero = ero;
        this.gyorsasag = gyorsasag;
        this.ugyesseg = ugyesseg;
        this.allokepeseg = allokepeseg;
        this.egeszseg = egeszseg;
        this.szepseg = szepseg;
        this.inteligencia = inteligencia;
        this.akaratero = akaratero;
        this.asztral = asztral;
        this.maxAsztral = maxAsztral;
        this.alapAsztral = alapAsztral;
        this.mana = mana;
        this.maxmana = maxmana;
        this.arany = arany;
        this.ezust = ezust;
        this.rez = rez;
        this.ke = ke;
        this.te = te;
        this.ve = ve;
        this.ce = ce;
        this.hm = hm;
        this.maxep = maxep;
        this.ep = ep;
        this.maxfp = maxfp;
        this.fp = fp;
        this.mgt = mgt;
        this.karakterkep = karakterkep;
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

    public String getKaszt() {
        return kaszt;
    }

    public void setKaszt(String kaszt) {
        this.kaszt = kaszt;
    }

    public String getFaj() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj = faj;
    }

    public String getJellem() {
        return jellem;
    }

    public void setJellem(String jellem) {
        this.jellem = jellem;
    }

    public String getVallas() {
        return vallas;
    }

    public void setVallas(String vallas) {
        this.vallas = vallas;
    }

    public String getSzulofold() {
        return szulofold;
    }

    public void setSzulofold(String szulofold) {
        this.szulofold = szulofold;
    }

    public String getIskola() {
        return iskola;
    }

    public void setIskola(String iskola) {
        this.iskola = iskola;
    }

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
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

    public int getAsztral() {
        return asztral;
    }

    public void setAsztral(int asztral) {
        this.asztral = asztral;
    }

    public int getMaxAsztral() {
        return maxAsztral;
    }

    public void setMaxAsztral(int maxAsztral) {
        this.maxAsztral = maxAsztral;
    }

    public int getAlapAsztral() {
        return alapAsztral;
    }

    public void setAlapAsztral(int alapAsztral) {
        this.alapAsztral = alapAsztral;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxmana() {
        return maxmana;
    }

    public void setMaxmana(int maxmana) {
        this.maxmana = maxmana;
    }

    public int getArany() {
        return arany;
    }

    public void setArany(int arany) {
        this.arany = arany;
    }

    public int getEzust() {
        return ezust;
    }

    public void setEzust(int ezust) {
        this.ezust = ezust;
    }

    public int getRez() {
        return rez;
    }

    public void setRez(int rez) {
        this.rez = rez;
    }

    public int getKe() {
        return ke;
    }

    public void setKe(int ke) {
        this.ke = ke;
    }

    public int getTe() {
        return te;
    }

    public void setTe(int te) {
        this.te = te;
    }

    public int getVe() {
        return ve;
    }

    public void setVe(int ve) {
        this.ve = ve;
    }

    public int getCe() {
        return ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }

    public int getHm() {
        return hm;
    }

    public void setHm(int hm) {
        this.hm = hm;
    }

    public int getMaxep() {
        return maxep;
    }

    public void setMaxep(int maxep) {
        this.maxep = maxep;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getMaxfp() {
        return maxfp;
    }

    public void setMaxfp(int maxfp) {
        this.maxfp = maxfp;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getMgt() {
        return mgt;
    }

    public void setMgt(int mgt) {
        this.mgt = mgt;
    }

    public int getKarakterkep() {
        return karakterkep;
    }

    public void setKarakterkep(int karakterkep) {
        this.karakterkep = karakterkep;
    }
}