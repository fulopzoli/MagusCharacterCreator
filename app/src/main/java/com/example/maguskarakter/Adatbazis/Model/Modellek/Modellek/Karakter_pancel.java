package com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "table_karakterpancel")
public class    Karakter_pancel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String karakternev;
    private String karaterpancel;

    public Karakter_pancel(String karakternev, String karaterpancel) {
        this.karakternev = karakternev;
        this.karaterpancel = karaterpancel;
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

    public String getKaraterpancel() {
        return karaterpancel;
    }

    public void setKaraterpancel(String karaterpancel) {
        this.karaterpancel = karaterpancel;
    }
}
