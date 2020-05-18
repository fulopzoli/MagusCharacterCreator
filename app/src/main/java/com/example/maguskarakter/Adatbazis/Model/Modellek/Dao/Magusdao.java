package com.example.maguskarakter.Adatbazis.Model.Modellek.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fajok;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kasztok;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;

import java.util.List;


@Dao
public interface Magusdao {


    // Fajok
    @Insert
    void Fajfeltolt(Fajok fajok);

    @Update
    void Fajmodosit(Fajok fajok);

    @Delete
    void Fajtorles(Fajok fajok);

    @Query("SELECT * FROM table_fajok")
    LiveData<List<Fajok>> mindenfajadat();

    @Query("SELECT Fajnev FROM table_fajok")
    LiveData<List<String>> fajnevlekerdez();


    // kasztok

    @Insert
    void kasztfeltolt(Kasztok kasztok);

    @Update
    void kasztmodositas(Kasztok kasztok);

    @Delete
    void kaszttorles(Kasztok kasztok);

    @Query("SELECT * FROM table_kasztok")
    LiveData<List<Kasztok>> kasztmindenadat();

    @Query("SELECT fokaszt FROM table_kasztok")
    LiveData<List<String>> fokasztoklekerdez();

    @Query("SELECT alkaszt FROM table_kasztok")
    LiveData<List<String>> alkasztlekerdez();


    // Fegyverek
    @Insert
    void Fegyverfeltolt(Fegyverek fegyverek);

    @Update
    void Fegyvermodosit(Fegyverek fegyverek);

    @Delete
    void Fegyvertorles(Fegyverek fegyverek);

    @Query("SELECT * FROM table_fegyverek")
    LiveData<List<Fegyverek>> fegyverosszesadat();

    @Query("Select * FROM  table_fegyverek WHERE kategoria LIKE :kategoria")
    List<Fegyverek> fegyvernevek(String kategoria);

    @Query("SELECT * FROM table_fegyverek WHERE fegyvernev LIKE :fegyvernev ")
    Fegyverek fegyverleiras(String fegyvernev);


    // pancelok
    @Insert
    void Panceéfeétolt(Pancel pancel);

    @Update
    void pancelmodositas(Pancel pancel);

    @Delete
    void panceltorles(Pancel pancel);

    @Query("SELECT * FROM table_pancel")
    LiveData<List<Pancel>> getallpanceladat();

    @Query("SELECT * FROM table_pancel WHERE nev LIKE :panceltipus")
    Pancel pancelLekerdezes(String panceltipus);


    // Kepzetsegek
    @Insert
    void Kepzetsegfeltolt(Kepzetseg kepzetseg);

    @Update
    void kepzetsegmodositas(Kepzetseg kepzetseg);

    @Delete
    void kepzetsegtorles(Kepzetseg kepzetseg);

    @Query("SELECT * FROM table_kepzetseg")
    LiveData<List<Kepzetseg>> kepzetsegosszeslekerdez();

    @Query("SELECT * FROM table_kepzetseg WHERE nev LIKE :nev ")
    Kepzetseg kepzetsegreszleteklekerdez(String nev);
    //Targyak

    @Insert
    void Targyhozzaad(Targy targy);

    @Update
    void Targymodositas(Targy targy);

    @Delete
    void Targytorol(Targy targy);

    @Query("SELECT * FROM table_targy WHERE targynev LIKE :targynev")
    Targy Targylekerdezesnev(String targynev);

    @Query("SELECT * FROM table_targy")
    LiveData<List<Targy>> TargyMinden();


    // Karakter
    @Insert
    void karakterfeltolt(Karakter karakter);

    @Delete
    void karaktertorles(Karakter karakter);

    @Update
    void karifrissites(Karakter karakter);

    @Query("SELECT * FROM table_karakter ORDER BY id")
    LiveData<List<Karakter>> mindenkarakteradat();

    @Query("Select nev from table_karakter")
    LiveData<List<String>> karakternev();

    @Query("Select faj from table_karakter")
    LiveData<List<String>> karakterfaj();

    @Query("select * from table_karakter where id like :id")
    Karakter Karakteradatlekerdez(int id);


    // karakterfegyver

    @Insert
    void karakterfegyverfeltolt(Karakter_fegyver karakter_fegyver);

    @Delete
    void karakkterfegyvertorol(Karakter_fegyver karakter_fegyver);

    @Update
    void karakterfegyvermodositas(Karakter_fegyver karakter_fegyver);

    @Query("SELECT * FROM table_karakterfegyver WHERE karakternev LIKE :karinev")
    List<Karakter_fegyver> karakterfegyverlekerdezes(String karinev);


    // karakter kepzetseg
    @Insert
    void karakterkepzetsegfeltolt(Karakter_kepzetseg karakter_kepzetseg);

    @Delete
    Void karakkterkepzetsegtorol(Karakter_kepzetseg karakter_kepzetseg);

    @Query("SELECT * From table_karakterkepz Where karakternev LIKE :karakternev ORDER BY kepzetsegnev ASC")
    List<Karakter_kepzetseg> kepzetseglekerdez(String karakternev);


    //Karakterpancel
    @Insert
    void karakterpancelfeltolt(Karakter_pancel karakter_pancel);

    @Delete
    void karakterpanceltorol(Karakter_pancel karakter_pancel);

    @Update
    void karaktrpancekmodositas(Karakter_pancel karakter_pancel);

    @Query("SELECT * FROM table_karakterpancel WHERE karakternev LIKE :nev")
    List<Karakter_pancel> karakterpancellekerdezes(String nev);

    //Karaktertargyak
    @Insert
    void karaktertargyhozzaad(Karakter_targy karakter_targy);

    @Delete
    void karaktertargytorol(Karakter_targy karakter_targy);

    @Update
    void karaktertargymodosit(Karakter_targy karakter_targy);

    @Query("Select * FROM table_karaktertargy WHERE karakternev LIKE :Karakternev Order BY targy ASC")
    List<Karakter_targy> karaktertagylekeres(String Karakternev);

    @Query("SELECT * FROM table_karaktertargy WHERE targy LIKE :targynev")
    Karakter_targy targyleiras(String targynev);

    @Query("SELECT * FROM table_karaktertargy WHERE id LIKE :id")
    Karakter_targy karakterTargylekerdezesbyID(int id);


    //Varzsizék

    @Insert
    void varazslathozzad(Varazslatok varazslatok);

    @Delete
    void varazslattorles(Varazslatok varazslatok);

    @Update
    void varazslatmodositas(Varazslatok varazslatok);

    @Query("Select * From table_spell where Pszivagyspell LIKE :pszivagyspell ")
    List<Varazslatok> varazslatlekerdez(String pszivagyspell);

    @Query("SELECT * FROM table_spell WHERE Magianevnev like :Magianevnev")
    List<Varazslatok> magiabykaszt(String Magianevnev);

    @Query("SELECT * FROM table_spell WHERE magianev like :magianev")
    Varazslatok magiareszlet(String magianev);

    @Query("SELECT * FROM table_spell")
    List<Varazslatok> oszzesspelllekerdez();

    @Query("SELECT * FROM table_spell WHERE Pszivagyspell LIKE :Pszivagyspell")
    List<Varazslatok> spellvagypszi(String Pszivagyspell);

//karakterspell

    @Insert
    void karakterspellhozzaad(Karakter_spell karakter_spell);

    @Delete
    void Karakterspelltorol(Karakter_spell karakter_spell);

    @Update
    void karakterspellupdate(Karakter_spell karakter_spell);

    @Query("SELECT * FROM table_karakterspell where karakternev LIKE :karakternev")
    List<Karakter_spell> karakterspel_lekerdez(String karakternev);


}
