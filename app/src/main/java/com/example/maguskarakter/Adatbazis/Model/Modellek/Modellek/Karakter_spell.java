package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_karakterspell")
public class Karakter_spell {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String karakternev;
    private String kpellnev;



    public Karakter_spell(String karakternev, String kpellnev) {
        this.karakternev = karakternev;
        this.kpellnev = kpellnev;

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

    public String getKpellnev() {
        return kpellnev;
    }

    public void setKpellnev(String kpellnev) {
        this.kpellnev = kpellnev;
    }


}


