package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.Raktar.KarakterSpellraktar;

import java.util.List;

public class KarakterspellViewModel extends AndroidViewModel {
    private MutableLiveData<List< Karakter_spell>> karakterspellek=new MutableLiveData<>();
    KarakterSpellraktar spellraktar;
    public KarakterspellViewModel(@NonNull Application application) {
        super(application);
        spellraktar=new KarakterSpellraktar(application);
        karakterspellek=spellraktar.getKarakterspelllekerdez();
    }

    public  void karakterspellhozzaad(Karakter_spell karakter_spell){
        spellraktar.kerakterspellhozzaadas(karakter_spell);
    }
    public void karakterkpelmodosit(Karakter_spell karakter_spell){spellraktar.karakterspellmodositas(karakter_spell);}
    public void karakterspelltorles(Karakter_spell karakter_spell){spellraktar.Karakterspelltorles(karakter_spell);}
    public void karakterspelllekerdezes(String karakternev){spellraktar.setKarakterspelllekerdez(karakternev);}
    public MutableLiveData<List<Karakter_spell>> karakterspelllekerdezeredmeny() {
        return karakterspellek;
    }
}
