package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kasztok;
import com.example.maguskarakter.Raktar.KasztokRaktar;

import java.util.List;

public class KasztokViewmodel extends AndroidViewModel {

    private LiveData<List<Kasztok>> mindenkasztadat;
    private LiveData<List<String>> fokasztnev;
    private LiveData<List<String>> alkasztnev;
    private KasztokRaktar raktar;

    public KasztokViewmodel(@NonNull Application application) {
        super(application);
        raktar=new KasztokRaktar(application);

        mindenkasztadat = raktar.getMindenkasztadatR();

        fokasztnev = raktar.getFokasztnevR();
    }

    public void kaszthozzaadas(Kasztok kasztok) {
        raktar.kaszthozzaadas(kasztok);
    }

    public void kasztmodositas(Kasztok kasztok) {
        raktar.kasztmodositas(kasztok);
    }

    public void kaszttorles(Kasztok kasztok) {
        raktar.Kaszttorles(kasztok);
    }

    public LiveData<List<Kasztok>> getMindenkasztadat() {
        return mindenkasztadat;
    }

    public LiveData<List<String>> getFokasztnev() {
        return fokasztnev;
    }

    public LiveData<List<String>> getAlkasztnev() {
        return alkasztnev;
    }
}
