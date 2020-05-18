package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fajok;

import java.util.List;

public class FajokRaktar {

    Magusdao magusdao;

    private LiveData<List<Fajok>> mindenfajadat;


    public FajokRaktar(Application application) {
        Adatbaziskez adtatkez=Adatbaziskez.getPancelallpot(application);
        magusdao=adtatkez.magusdao();

        mindenfajadat=magusdao.mindenfajadat();

    }


    public LiveData<List<Fajok>> getMindenfajadatR() {
        return mindenfajadat;
    }


    public void fajhozzaadas (Fajok fajok){new fajbeszuras(magusdao).execute();}
    public void fajmodositas (Fajok fajok){new fajmodosit(magusdao).execute();}
    public void fajtorles (Fajok fajok){new Fajtorles(magusdao).execute();}


    private static class fajbeszuras extends AsyncTask<Fajok,Void,Void> {
        private Magusdao magdao;

        public fajbeszuras(Magusdao magdao) {
            this.magdao = magdao;
        }

        @Override
        protected Void doInBackground(Fajok... fajoks) {
            magdao.Fajfeltolt(fajoks[0]);
            return null;
        }
    }
    private static class fajmodosit extends AsyncTask<Fajok,Void,Void>{
        private Magusdao magdao;

        public fajmodosit(Magusdao magdao) {
            this.magdao = magdao;
        }

        @Override
        protected Void doInBackground(Fajok... fajoks) {
            magdao.Fajmodosit(fajoks[0]);
            return null;
        }
    }
    private static class Fajtorles extends AsyncTask<Fajok,Void,Void>{
        private Magusdao magdao;

        public Fajtorles(Magusdao magdao) {
            this.magdao = magdao;
        }

        @Override
        protected Void doInBackground(Fajok... fajoks) {
            magdao.Fajtorles(fajoks[0]);
            return null;
        }
    }
}
