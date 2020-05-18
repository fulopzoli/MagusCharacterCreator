package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.Raktar.FegyverekRaktar;

import java.util.List;

public class FegyverekViewModel extends AndroidViewModel {

    FegyverekRaktar raktar;
    private MutableLiveData<List<Fegyverek>> fegyvernev;
    private LiveData<List<Fegyverek>> fegyverek;
    private MutableLiveData<Fegyverek> Fegyverekleiras;
    public FegyverekViewModel(@NonNull Application application) {
        super(application);
        raktar=new FegyverekRaktar(application);
        fegyverek = raktar.getFegyverekR();
        fegyvernev = raktar.getFegyverekNevLekerdezes();
        Fegyverekleiras=raktar.getFegyverekReszletLekerdezes();

    }

    //fegyverek
    public void fegyverhozzad(Fegyverek fegyverek) {
        raktar.fegyverhozzaadas(fegyverek);
    }

    public void fegyvertorles(Fegyverek fegyverek) {
        raktar.fegyvertorles(fegyverek);
    }

    public void fegyvermodosit(Fegyverek fegyverek) {
        raktar.fegyvermodositas(fegyverek);
    }
    public LiveData<List<Fegyverek>> getFegyverek() {
        return fegyverek;
    }

    public MutableLiveData<List<Fegyverek>> getFegyvernev() {
        return fegyvernev;
    }

    public void SetfegyvernevlekerdezesBycategory(String kategoria){raktar.Setfegyvernevlekerdezesbycategory(kategoria);}

    public void setFegyverekreszletleiras(String fegyvernev){raktar.SetfegyverekReszletlekerdezes(fegyvernev);}

    public MutableLiveData<Fegyverek> getFegyverekleiras() {
        return Fegyverekleiras;
    }
}
