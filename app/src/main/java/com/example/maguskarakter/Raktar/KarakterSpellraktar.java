package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;

import java.util.List;

public class KarakterSpellraktar {

    MutableLiveData<List<Karakter_spell>> karakterspelllekerdez=new MutableLiveData<>();

    Magusdao magusdao;
    public KarakterSpellraktar(Application application) {
        Adatbaziskez adatbaziskez=Adatbaziskez.getPancelallpot(application);
        magusdao=adatbaziskez.magusdao();
    }
    //Karakterspelllekerdez******************************************************************************************************************************
    //bemenet es asynctask ertekadas
    public void setKarakterspelllekerdez(String karakternev){karakterspelllekerdezasync a=new karakterspelllekerdezasync(magusdao);
    a.karakterSpellraktar=this;
    a.execute(karakternev);}
    //A hatterszalbol kapott adat bealitasa
    public void passdatatolivedata(List<Karakter_spell> karakter_spells){karakterspelllekerdez.setValue(karakter_spells);}
    //getter
    public MutableLiveData<List<Karakter_spell>> getKarakterspelllekerdez() {
        return karakterspelllekerdez;
    }
    //hatterszal inditasa
    private static class karakterspelllekerdezasync extends AsyncTask<String,Void,List<Karakter_spell>>{
        KarakterSpellraktar karakterSpellraktar=null;
        Magusdao magusdao;

        public karakterspelllekerdezasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected List<Karakter_spell> doInBackground(String... strings) {
     return       magusdao.karakterspel_lekerdez(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Karakter_spell> karakter_spells) {
           karakterSpellraktar.passdatatolivedata(karakter_spells);
        }
    }

    //KARAKTERSPELLHOZAADAS************************************************************************************************************************************

    public void kerakterspellhozzaadas(Karakter_spell varazslatok){ new karakterspellhozzaadasync(magusdao).execute(varazslatok); }
    public static class karakterspellhozzaadasync extends AsyncTask<Karakter_spell,Void,Void>{
        Magusdao magusdao;

        public karakterspellhozzaadasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_spell... karakter_spells) {
            magusdao.karakterspellhozzaad(karakter_spells[0]);
            return null;
        }
    }

    //Karakterspellmodositas******************************************************************************************************************************************

    public void karakterspellmodositas(Karakter_spell karakter_spell){new karakterspellmodositasasync(magusdao).execute(karakter_spell);}
    private static class karakterspellmodositasasync extends AsyncTask<Karakter_spell,Void,Void>{
        Magusdao magusdao;

        public karakterspellmodositasasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_spell... karakter_spells) {
            magusdao.karakterspellupdate(karakter_spells[0]);
            return null;
        }
    }

    //Karakterspelltorol***************************************************************************************************************************************************

    public void Karakterspelltorles(Karakter_spell karakter_spell){new Karakterspelltorlesasync(magusdao).execute(karakter_spell);}
    private static class Karakterspelltorlesasync extends AsyncTask<Karakter_spell,Void,Void>{
        Magusdao magusdao;

        public Karakterspelltorlesasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_spell... karakter_spells) {
            magusdao.Karakterspelltorol(karakter_spells[0]);
            return null;
        }
    }
}
