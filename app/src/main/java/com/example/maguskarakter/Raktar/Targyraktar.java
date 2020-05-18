package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;

import java.util.List;

public class Targyraktar {

    private Magusdao magusdao;
    private LiveData<List<Targy>> mindentargylekerdez;
    private MutableLiveData<Targy> targyreszletlekerdez = new MutableLiveData<>();

    public Targyraktar(Application application) {
        Adatbaziskez adtatkez = Adatbaziskez.getPancelallpot(application);
        magusdao = adtatkez.magusdao();
        mindentargylekerdez = magusdao.TargyMinden();

    }

    public LiveData<List<Targy>> getMindentargylekerdez() {
        return mindentargylekerdez;
    }

    public void Targyhozzaad(Targy targy) {
        new TargyhozzaadAsync(magusdao).execute(targy);
    }

    private static class TargyhozzaadAsync extends AsyncTask<Targy, Void, Void> {
        private Magusdao magusdao;

        public TargyhozzaadAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Targy... targies) {
            magusdao.Targyhozzaad(targies[0]);
            return null;
        }
    }

    public void TargyFrissit(Targy targy) {
        new TargyFrissitesascync(magusdao).execute(targy);
    }

    private static class TargyFrissitesascync extends AsyncTask<Targy, Void, Void> {
        private Magusdao magusdao;

        public TargyFrissitesascync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Targy... targies) {
            magusdao.Targymodositas(targies[0]);
            return null;
        }
    }

    public void Targytorol(Targy targy) {
        new TargytorolAsync(magusdao).execute(targy);
    }

    private static class TargytorolAsync extends AsyncTask<Targy, Void, Void> {
        private Magusdao magusdao;

        public TargytorolAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Targy... targies) {
            magusdao.Targytorol(targies[0]);
            return null;
        }
    }

    private void Targylistafeltolt(Targy targy) {
        targyreszletlekerdez.setValue(targy);
    }

    public MutableLiveData<Targy> getTargyreszletlekerdez() {
        return targyreszletlekerdez;
    }

    public void SetTargyreszlet(String targynev) {
        TargyreszletlekerdezAsync a = new TargyreszletlekerdezAsync(magusdao);
        a.targyraktar=this;
        a.execute(targynev);
    }

    private static class TargyreszletlekerdezAsync extends AsyncTask<String, Void, Targy> {
        private Magusdao magusdao;
        Targyraktar targyraktar = null;

        public TargyreszletlekerdezAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Targy doInBackground(String... strings) {
            return magusdao.Targylekerdezesnev(strings[0]);
        }

        @Override
        protected void onPostExecute(Targy targy) {
            targyraktar.Targylistafeltolt(targy);
        }
    }
}
