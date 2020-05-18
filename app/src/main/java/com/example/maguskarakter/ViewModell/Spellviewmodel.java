package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;
import com.example.maguskarakter.Raktar.Spellraktar;

public class Spellviewmodel extends AndroidViewModel {


    private Spellraktar spellraktar;
    private MutableLiveData<Varazslatok> Varazslatreszletlekerdezes;


    public Spellviewmodel(@NonNull Application application) {
        super(application);
        spellraktar=new Spellraktar(application);
        Varazslatreszletlekerdezes=spellraktar.getvarazslatreszletlekerdez();
    }

    public void varaslatreszleteklekerdezes(String spellnev){
        spellraktar.setVarazslatreszletlekerdezese(spellnev);
    }

    public MutableLiveData<Varazslatok> getVarazslatreszletlekerdezes() {
        return Varazslatreszletlekerdezes;
    }
}
