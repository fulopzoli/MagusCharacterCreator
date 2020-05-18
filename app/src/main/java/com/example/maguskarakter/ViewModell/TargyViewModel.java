package com.example.maguskarakter.ViewModell;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;
import com.example.maguskarakter.Raktar.Targyraktar;

import java.util.List;

public class TargyViewModel extends AndroidViewModel {
    private LiveData<List<Targy>> Targymindenadatlekerdez;
    private MutableLiveData<Targy> TargyLeirasLekerdez;
    private Targyraktar targyraktar;

    public TargyViewModel(@NonNull Application application) {
        super(application);
        targyraktar = new Targyraktar(application);
        Targymindenadatlekerdez = targyraktar.getMindentargylekerdez();
        TargyLeirasLekerdez=targyraktar.getTargyreszletlekerdez();
    }

    public MutableLiveData<Targy> getTargyLeirasLekerdez() {
        return TargyLeirasLekerdez;
    }

    public LiveData<List<Targy>> getTargymindenadatlekerdez() {
        return Targymindenadatlekerdez;
    }
    public void SetTargyReszletLekerdez(String Targynev){targyraktar.SetTargyreszlet(Targynev); }

    public void TargyBeszuras(Targy targy){targyraktar.Targyhozzaad(targy);}

    public void TargyFrissites(Targy targy){targyraktar.TargyFrissit(targy);}

    public void TargyTorol(Targy targy){targyraktar.Targytorol(targy);}

}
