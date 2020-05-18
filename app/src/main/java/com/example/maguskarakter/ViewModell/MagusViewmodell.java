package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;
import com.example.maguskarakter.Raktar.Raktar;

import java.util.List;

public class MagusViewmodell extends AndroidViewModel {

    private Raktar raktar;

    //teljes adatok

    private LiveData<List<Kepzetseg>> mindenkepzetsegadat;

    // reszleges adatok


    private LiveData<List<String>> kepzetsegnev;
    private LiveData<List<String>> karakternev;
    private LiveData<List<String>> karakterfaj;


    //lekérdezések

    private MutableLiveData<List<Karakter_targy>> karaktertargylekerdezeredmeny;
    private MutableLiveData<Karakter_targy> Karaktertargyreszletlekerdez;
    private MutableLiveData<List<Karakter_fegyver>> Karakterfegyverlekerdezes;
    private  MutableLiveData<List<Karakter_pancel>> KarakterpancelLekerdez;
    private MutableLiveData<Karakter_targy> KarakterTargyLekerdezByID;

    private MutableLiveData<List<Karakter_kepzetseg>> karakterkepzetseglekepezeredmeny;


    public MagusViewmodell(@NonNull Application application) {
        super(application);
        raktar = new Raktar(application);
        //teljes

        mindenkepzetsegadat = raktar.getMindenkepzetsegadatR();

        //reszleges


        kepzetsegnev = raktar.getKepzetsegnevR();


        // Lekerdezesek


        karaktertargylekerdezeredmeny = raktar.getKaraktertargylekerdez();
        karakterkepzetseglekepezeredmeny = raktar.getKarakterkepzetseglekrdezR();
        Karaktertargyreszletlekerdez=raktar.getKaraktertargyreszletlekerdez();
        Karakterfegyverlekerdezes=raktar.getKarakterfegyverlekerdezes();
        KarakterpancelLekerdez=raktar.getKarakterpancelLekerdezes();
        KarakterTargyLekerdezByID=raktar.getKaraktertargylekerdezesByID();
    }


    //kepzetsegek
    public void kepzetsegbeszuras(Kepzetseg kepzetseg) {
        raktar.kepzetseghazzadas(kepzetseg);
    }

    public void kepzetsegtorles(Kepzetseg kepzetseg) {
        raktar.kepzetsegtorol(kepzetseg);
    }

    public void kepzetsegmodositas(Kepzetseg kepzetseg) {
        raktar.kepzetsegmodositas(kepzetseg);
    }


    //karakter felszereles

    public void SetKarakterfegyverlekerdezes(String Karinev){
        raktar.setkarakterfegyverlekerdez(Karinev);
    }

    public void karakterpancelhozzadas(Karakter_pancel karakter_pancel) {
        raktar.karaterpancelhaoozadas(karakter_pancel);
    }

    public void karakterpanceltorol(Karakter_pancel karakter_pancel) {
        raktar.karaterpanceltorl(karakter_pancel);
    }

    public void karakterfegyverhozzads(Karakter_fegyver karakter_fegyver) {
        raktar.karakterfegyverhozzadas(karakter_fegyver);
    }

    public void karakterfegyvertorol(Karakter_fegyver karakter_fegyver) {
        raktar.karakterfegyvertorol(karakter_fegyver);
    }

    public void karakterkepzetsegekhozzaadas(Karakter_kepzetseg karakter_kepzetseg) {
        raktar.karakterkepzetseghozzad(karakter_kepzetseg);
    }

    public void karakterkepzetsegtorol(Karakter_kepzetseg karakter_kepzetseg) {
        raktar.karakterkepzetsegtorol(karakter_kepzetseg);
    }

    public void karaktertargyhozzaadas(Karakter_targy karakter_targy) {
        raktar.karaktertargyhozzaadas(karakter_targy);
    }
    public void karaktertargymodosit(Karakter_targy karakter_targy){ raktar.karaktertargymodosit(karakter_targy);}

    public void karaktertargytorol(Karakter_targy karakter_targy) {
        raktar.karaktertargytorles(karakter_targy);
    }
    public  void Karakterpancellekerdezes(String name){raktar.setKarakterpancellekerdez(name);}

    public void KarakterKepzetseglekerdezes(String name) {
        raktar.karakterkepzetseglekerdez(name);
    }

    public void Karaktertargylekerdezes(String name) {
        raktar.karaktertargylekerdezs(name);
    }
    public  void Karaktertargyleiraskerdezes(String targynev){raktar.Karaktertargyleirasinput(targynev);}
    public void Karakterfegyvermodositas(Karakter_fegyver karakter_fegyver){raktar.karakterfegyvermodositas(karakter_fegyver);}


    public void SetKarakter_targyLekerdezesByID(int Id){raktar.SetKaraktertargylekerdezesByID(Id);}

    public MutableLiveData<Karakter_targy> getKarakterTargyLekerdezByID() {
        return KarakterTargyLekerdezByID;
    }
    //Listák


    public LiveData<List<Kepzetseg>> getMindenkepzetsegadat() {
        return mindenkepzetsegadat;
    }


    public Raktar getRaktar() {
        return raktar;
    }


    public LiveData<List<String>> getKepzetsegnev() {
        return kepzetsegnev;
    }

    public LiveData<List<String>> getKarakternev() {
        return karakternev;
    }

    public LiveData<List<String>> getKarakterfaj() {
        return karakterfaj;
    }

    public MutableLiveData<List<Karakter_targy>> getKaraktertargylekerdezeredmeny() {
        return karaktertargylekerdezeredmeny;
    }

    public MutableLiveData<List<Karakter_kepzetseg>> getKarakterkepzetseglekepezeredmeny() {
        return karakterkepzetseglekepezeredmeny;
    }

    public MutableLiveData<Karakter_targy> getKaraktertargyreszletlekerdez() {
        return Karaktertargyreszletlekerdez;
    }

    public MutableLiveData<List<Karakter_fegyver>> getKarakterfegyverlekerdezes() {
        return Karakterfegyverlekerdezes;
    }

    public MutableLiveData<List<Karakter_pancel>> getKarakterpancelLekerdez() {
        return KarakterpancelLekerdez;
    }
}
