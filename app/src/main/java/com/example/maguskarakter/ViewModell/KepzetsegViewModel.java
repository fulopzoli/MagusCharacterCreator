package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;
import com.example.maguskarakter.Raktar.Kepzetsegraktar;

import java.util.List;

public class KepzetsegViewModel extends AndroidViewModel {
    private Kepzetsegraktar kepzetsegraktar;
    private MutableLiveData<Kepzetseg> kepzetseglekerdezbynev;
    private LiveData<List<Kepzetseg>> osszeskepzetsegadat;

    public KepzetsegViewModel(@NonNull Application application) {
        super(application);
        kepzetsegraktar = new Kepzetsegraktar(application);
        kepzetseglekerdezbynev = kepzetsegraktar.getKepzetsegreszletlekerdez();
        osszeskepzetsegadat = kepzetsegraktar.osszeskepzetsegadatlekerdez();
    }

    public void KepzetsegHozzaadas(Kepzetseg kepzetseg) {
        kepzetsegraktar.kepzetseghozzaadas(kepzetseg);
    }

    public void KepzetsegModositas(Kepzetseg kepzetseg) {
        kepzetsegraktar.kepzetsegmodositas(kepzetseg);
    }

    public void Kepzetsegtorles(Kepzetseg kepzetseg) {
        kepzetsegraktar.kepzetsegtorles(kepzetseg);
    }

    public  void KepzetsegKereses(String nev){kepzetsegraktar.setKeopzetsegreszletlekerdezes(nev);}

    public MutableLiveData<Kepzetseg> getKepzetseglekerdezbynev() {
        return kepzetseglekerdezbynev;
    }

    public LiveData<List<Kepzetseg>> getOsszeskepzetsegadat() {
        return osszeskepzetsegadat;
    }
}
