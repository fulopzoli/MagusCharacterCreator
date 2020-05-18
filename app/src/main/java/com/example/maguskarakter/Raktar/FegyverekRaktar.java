package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;

import java.util.List;

public class FegyverekRaktar {

    Magusdao magusdao;
    private LiveData<List<Fegyverek>> fegyverek;
    private MutableLiveData<Fegyverek> FegyverekReszletLekerdezes = new MutableLiveData<>();
    private MutableLiveData<List<Fegyverek>> FegyverekNevLekerdezes = new MutableLiveData<>();

    public FegyverekRaktar(Application application) {
        Adatbaziskez adtatkez = Adatbaziskez.getPancelallpot(application);
        magusdao = adtatkez.magusdao();
        fegyverek = magusdao.fegyverosszesadat();
    }


    public LiveData<List<Fegyverek>> getFegyverekR() {
        return fegyverek;
    }

    public void fegyverhozzaadas(Fegyverek fegyverek) {
        new fegyverbeszuras(magusdao).execute(fegyverek);
    }

    public void fegyvermodositas(Fegyverek fegyverek) {
        new fegyvermodosito(magusdao).execute(fegyverek);
    }

    public void fegyvertorles(Fegyverek fegyverek) {
        new fegyvertorles(magusdao).execute(fegyverek);
    }
//Fegyverlekerdezeskategoriakkent


    public void Setfegyvernevlekerdezesbycategory(String kategoria) {
        Fegyvernevlekerdezesbykategory a = new Fegyvernevlekerdezesbykategory(magusdao);
        a.raktar = this;
        a.execute(kategoria);
    }

    private void fegyverlistabeallitas(List<Fegyverek> lista) {
        FegyverekNevLekerdezes.setValue(lista);
    }

    public MutableLiveData<List<Fegyverek>> getFegyverekNevLekerdezes() {
        return FegyverekNevLekerdezes;
    }

    private static class Fegyvernevlekerdezesbykategory extends AsyncTask<String, Void, List<Fegyverek>> {
        private Magusdao magusdao;
        private FegyverekRaktar raktar = null;

        public Fegyvernevlekerdezesbykategory(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected List<Fegyverek> doInBackground(String... strings) {
            return magusdao.fegyvernevek(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Fegyverek> strings) {
            raktar.fegyverlistabeallitas(strings);
        }
    }

//Reszleteklekerdezes

    public void SetfegyverekReszletlekerdezes(String nev) {
        fegyverlekerdezesAsync a = new fegyverlekerdezesAsync(magusdao);
        a.rakter = this;
        a.execute(nev);
    }

    private void fegyverreklistatoltes(Fegyverek fegyverek) {
        FegyverekReszletLekerdezes.setValue(fegyverek);
    }

    public MutableLiveData<Fegyverek> getFegyverekReszletLekerdezes() {
        return FegyverekReszletLekerdezes;
    }

    public static class fegyverlekerdezesAsync extends AsyncTask<String, Void, Fegyverek> {
        private Magusdao magusdao;
        private FegyverekRaktar rakter = null;

        public fegyverlekerdezesAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Fegyverek doInBackground(String... strings) {
            return magusdao.fegyverleiras(strings[0]);
        }

        @Override
        protected void onPostExecute(Fegyverek fegyverek) {
            rakter.fegyverreklistatoltes(fegyverek);
        }
    }


//Maradek async


    private static class fegyverbeszuras extends AsyncTask<Fegyverek, Void, Void> {
        private Magusdao magusdao;

        public fegyverbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Fegyverek... fegyvereks) {
            magusdao.Fegyverfeltolt(fegyvereks[0]);
            return null;
        }
    }

    private static class fegyvermodosito extends AsyncTask<Fegyverek, Void, Void> {
        private Magusdao magusdao;

        public fegyvermodosito(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Fegyverek... fegyvereks) {
            magusdao.Fegyvermodosit(fegyvereks[0]);
            return null;
        }
    }

    private static class fegyvertorles extends AsyncTask<Fegyverek, Void, Void> {
        private Magusdao magusdao;

        public fegyvertorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Fegyverek... fegyvereks) {
            magusdao.Fegyvertorles(fegyvereks[0]);
            return null;
        }
    }


}
