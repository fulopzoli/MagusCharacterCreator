package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;

import java.util.List;

public class Karakterraktar {


    private MutableLiveData<Karakter> Karakteradatlekerdez=new MutableLiveData<>();

    private  LiveData<List<Karakter>>mindenkarakteradar;


    private Magusdao magusdao;
    public Karakterraktar(Application application) {
        Adatbaziskez adtatkez=Adatbaziskez.getPancelallpot(application);
        magusdao=adtatkez.magusdao();

        mindenkarakteradar=magusdao.mindenkarakteradat();

    }


    public LiveData<List<Karakter>> getMindenkarakteradarR() {
        return mindenkarakteradar;
    }

    //*****************************************************************************************************************
    //Karakter sql legkérdezés

    public void karakterlekerdez(int id){karakterlekerdezasync a=new karakterlekerdezasync(magusdao);a.dele=this;a.execute(id);}

    private void karakterkeresesasyc(Karakter Eredmeny){Karakteradatlekerdez.setValue(Eredmeny);}
    public MutableLiveData< Karakter> getKarakteradatlekerdez() {
        return Karakteradatlekerdez;
    }


    private  static class karakterlekerdezasync extends AsyncTask<Integer,Void, Karakter>{
        Magusdao magusdao;
        private Karakterraktar dele=null;

        public karakterlekerdezasync(Magusdao magusdao) { this.magusdao = magusdao; }

        @Override
        protected  Karakter doInBackground(Integer... strings) {

            return magusdao.Karakteradatlekerdez(strings[0]);}

        @Override
        protected void onPostExecute(Karakter karakters) {
            dele.karakterkeresesasyc(karakters);
        }
    }

    //*********************************************
    public  void karakterhozzaadas(Karakter karakter){new karakterbeszuras(magusdao).execute();}
    public  void karaktertorol(Karakter karakter){new karaktertorles(magusdao).execute();}
    public  void karaktermodositas(Karakter karakter){new karaktermodosit(magusdao).execute(karakter);}

    private static class karakterbeszuras extends AsyncTask<Karakter,Void,Void> {
        private Magusdao magusdao;

        public karakterbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter... karakters) {
            magusdao.karakterfeltolt(karakters[0]);
            return null;
        }
    }
    private static class karaktertorles extends AsyncTask<Karakter,Void,Void>{
        private Magusdao magusdao;

        public karaktertorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter... karakters) {
            magusdao.karaktertorles(karakters[0]);
            return null;
        }
    }
    private static class karaktermodosit extends AsyncTask<Karakter,Void,Void>{
        private Magusdao magusdao;

        public karaktermodosit(Magusdao magusdao) {this.magusdao = magusdao;}

        @Override
        protected Void doInBackground(Karakter... karakters) {
            magusdao.karifrissites(karakters[0]);
            return null;
        }
    }

}
