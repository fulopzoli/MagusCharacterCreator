package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fajok;
import com.example.maguskarakter.Raktar.FajokRaktar;

import java.util.List;

public class FajokViewModel extends AndroidViewModel {

    private LiveData<List<Fajok>> mindenfajadat;
    FajokRaktar fajokRaktar;

    public FajokViewModel(@NonNull Application application) {
        super(application);
        mindenfajadat =fajokRaktar.getMindenfajadatR() ;
    }

    //fajok
    public void fajhozzadas(Fajok fajok) {
        fajokRaktar.fajhozzaadas(fajok);
    }

    public void fajtorles(Fajok fajok) {
        fajokRaktar.fajtorles(fajok);
    }

    public void fajmodositas(Fajok fajok) {
        fajokRaktar.fajmodositas(fajok);
    }

    public LiveData<List<Fajok>> getMindenfajadat() {
        return mindenfajadat;
    }


}
