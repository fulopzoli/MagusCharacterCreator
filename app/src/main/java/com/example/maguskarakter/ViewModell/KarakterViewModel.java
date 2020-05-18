package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.Raktar.Karakterraktar;

import java.util.List;


public class KarakterViewModel extends AndroidViewModel {

    private Karakterraktar karakterraktar;

    private LiveData<List<Karakter>> mindenkarakteradat;
    private MutableLiveData<Karakter> karakteradateredmeny;


    public KarakterViewModel(@NonNull Application application) {
        super(application);


        karakterraktar=new Karakterraktar(application);

        mindenkarakteradat=karakterraktar.getMindenkarakteradarR();
        karakteradateredmeny=karakterraktar.getKarakteradatlekerdez();

    }

    //karakter műveletek

    public void karaterhozzaadas(Karakter karakter) {
        karakterraktar.karakterhozzaadas(karakter);
    }


    public void karatertorles(Karakter karakter) {
        karakterraktar.karaktertorol(karakter);
    }


    public void karatermodositas(Karakter karakter) {karakterraktar.karaktermodositas(karakter);}

    public void  karakteradatoklekerdez(int id){karakterraktar.karakterlekerdez(id);}

    public LiveData<List<Karakter>> getMindenkarakteradat() {
        return mindenkarakteradat;
    }

    public MutableLiveData<Karakter> getKarakteradateredmeny() {
        return karakteradateredmeny;
    }


}
