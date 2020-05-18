package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;

import java.util.List;

public class Kepzetsegraktar {
    private MutableLiveData<Kepzetseg> kepzetsegreszletlekerdez=new MutableLiveData<>();
    private LiveData<List<Kepzetseg>> osszeskepzetsegadat;
    private Magusdao magusdao;

    public Kepzetsegraktar(Application application) {
        Adatbaziskez adatbaziskez = Adatbaziskez.getPancelallpot(application);
        magusdao = adatbaziskez.magusdao();
        osszeskepzetsegadat = magusdao.kepzetsegosszeslekerdez();

    }

    //KÉPZETSÉG HOZZÁADAÁS************************************************************************************************
    public void kepzetseghozzaadas(Kepzetseg kepzetseg) {
        new kepzetsegbeszuras(magusdao).execute();
    }

    private static class kepzetsegbeszuras extends AsyncTask<Kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public kepzetsegbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kepzetseg... kepzetsegs) {
            magusdao.Kepzetsegfeltolt(kepzetsegs[0]);
            return null;
        }
    }

    //KÉPZETSÉG MÓDOSÍTÁS *************************************************************************************************
    public void kepzetsegmodositas(Kepzetseg kepzetseg) {
        new kepzetsegmodositasasync(magusdao).execute();
    }

    private static class kepzetsegmodositasasync extends AsyncTask<Kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public kepzetsegmodositasasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kepzetseg... kepzetsegs) {
            magusdao.kepzetsegmodositas(kepzetsegs[0]);
            return null;
        }
    }

    //KÉPZETSÉGTÖRLÉS*******************************************************************************************************
    public void kepzetsegtorles(Kepzetseg kepzetseg) {
        new kepzetsegmodositasasync(magusdao).execute();
    }

    private static class kepzetsegtorlesasync extends AsyncTask<Kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public kepzetsegtorlesasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kepzetseg... kepzetsegs) {
            magusdao.kepzetsegtorles(kepzetsegs[0]);
            return null;
        }
    }

    //ÖSSZESADATLEKERDEZ*****************************************************************************************************
    public LiveData<List<Kepzetseg>> osszeskepzetsegadatlekerdez() {
        return osszeskepzetsegadat;
    }

    //KEPZETSEGADATBYNÉV******************************************************************************************************
    public void setKeopzetsegreszletlekerdezes(String nev) {
        Kepzetseglekerdezbynevasync a = new Kepzetseglekerdezbynevasync(magusdao);
        a.kepzetsegraktar = this;
        a.execute(nev);
    }

    public void kereseeredmenybeallitas(Kepzetseg eredmeny) {
        kepzetsegreszletlekerdez.setValue(eredmeny);
    }

    public MutableLiveData<Kepzetseg> getKepzetsegreszletlekerdez() {
        return kepzetsegreszletlekerdez;
    }

    private static class Kepzetseglekerdezbynevasync extends AsyncTask<String, Void, Kepzetseg> {
        private Magusdao magusdao;
        private Kepzetsegraktar kepzetsegraktar = null;

        public Kepzetseglekerdezbynevasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Kepzetseg doInBackground(String... strings) {
            return magusdao.kepzetsegreszleteklekerdez(strings[0]);
        }

        @Override
        protected void onPostExecute(Kepzetseg kepzetseg) {
            kepzetsegraktar.kereseeredmenybeallitas(kepzetseg);

        }
    }
}
