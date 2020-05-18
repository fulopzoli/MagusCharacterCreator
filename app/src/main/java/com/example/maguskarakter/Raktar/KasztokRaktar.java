package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kasztok;

import java.util.List;



public class KasztokRaktar {

    private LiveData<List<Kasztok>> mindenkasztadat;
    private  LiveData<List<String>> fokasztnev;
    private  LiveData<List<String>> alkasztnev;
    Magusdao magusdao;
    public KasztokRaktar(Application application) {

        Adatbaziskez adtatkez=Adatbaziskez.getPancelallpot(application);
        magusdao=adtatkez.magusdao();

        mindenkasztadat=magusdao.kasztmindenadat();
        fokasztnev=magusdao.fokasztoklekerdez();
        alkasztnev=magusdao.alkasztlekerdez();


    }

    public Magusdao getMagusdaoR() {
        return magusdao;
    }

    public LiveData<List<Kasztok>> getMindenkasztadatR() {
        return mindenkasztadat;
    }

    public LiveData<List<String>> getFokasztnevR() {
        return fokasztnev;
    }

    public LiveData<List<String>> getAlkasztnevR() {
        return alkasztnev;
    }
    public void kaszthozzaadas(Kasztok kasztok){new kasztbeszuras(magusdao).execute();}
    public void kasztmodositas(Kasztok kasztok){new kasztmosito(magusdao).execute();}
    public void Kaszttorles(Kasztok kasztok){new kaszttorol(magusdao).execute();}
    private static class  kasztbeszuras extends AsyncTask<Kasztok,Void,Void> {
        private Magusdao magusdao;

        public kasztbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kasztok... kasztoks) {

            magusdao.kasztfeltolt(kasztoks[0]);
            return null;
        }
    }
    private static class kasztmosito extends  AsyncTask<Kasztok,Void,Void>{
        private Magusdao magusdao;

        public kasztmosito(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kasztok... kasztoks) {

            magusdao.kasztmodositas(kasztoks[0]);
            return null;
        }
    }
    private static class kaszttorol extends  AsyncTask<Kasztok,Void,Void>{
        private Magusdao magusdao;

        public kaszttorol(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kasztok... kasztoks) {

            magusdao.kaszttorles(kasztoks[0]);
            return null;
        }
    }

}
