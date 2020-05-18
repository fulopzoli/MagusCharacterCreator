package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Pancel;
import com.example.maguskarakter.Raktar.Pancelraktar;

import java.util.List;

public class PancelviewModel extends AndroidViewModel {
    private Pancelraktar raktar;

    private LiveData<List<Pancel>> pancelok;
    private MutableLiveData<Pancel> Pancelreszletrekerdez;

    public PancelviewModel(@NonNull Application application) {
        super(application);
        raktar=new Pancelraktar(application);
        pancelok = raktar.getPancelokR();
        Pancelreszletrekerdez=raktar.getPancellekerdezes();

    }

    //pancelok
    public void pancelhozzad(Pancel pancel) {
        raktar.pancelhozzadas(pancel);
    }

    public void panceltorles(Pancel pancel) {
        raktar.panceltorol(pancel);
    }

    public void pancelmodositas(Pancel pancel) {
        raktar.pancelmodositas(pancel);
    }

    public LiveData<List<Pancel>> getPancelok() {
        return pancelok;
    }

    public void setPancelreszletrekerdez(String pancelnev){raktar.setPancellekerdezea(pancelnev);}

    public MutableLiveData<Pancel> getPancelreszletrekerdez() {
        return Pancelreszletrekerdez;
    }


}
