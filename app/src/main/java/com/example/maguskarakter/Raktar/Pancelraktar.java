package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Pancel;

import java.util.List;

public class Pancelraktar {

    private LiveData<List<Pancel>> pancelok;
    private Magusdao magusdao;

    private MutableLiveData<Pancel> Pancellekerdezes=new MutableLiveData<>();

    public Pancelraktar(Application application) {
        Adatbaziskez adtatkez = Adatbaziskez.getPancelallpot(application);
        magusdao = adtatkez.magusdao();

        pancelok = magusdao.getallpanceladat();



    }
    // Pnacelok
    public LiveData<List<Pancel>> getPancelokR() {
        return pancelok;
    }
    public void pancelhozzadas(Pancel pancel){new pancelbeszuras(magusdao).execute(pancel);}
    public void panceltorol(Pancel pancel){new panceltorles(magusdao).execute(pancel);}
    public void pancelmodositas(Pancel pancel){new pancelmodosit (magusdao).execute(pancel);}

    public void setPancellekerdezea(String pancelnev){
        Pncellekerdezasync a=new Pncellekerdezasync(magusdao);
        a.raktar=this;
        a.execute(pancelnev);
    }
    private void Pancellekerdezfeltolt(Pancel pancel){Pancellekerdezes.setValue(pancel);}

    public MutableLiveData<Pancel> getPancellekerdezes() {
        return Pancellekerdezes;
    }

    private static class Pncellekerdezasync extends AsyncTask<String,Void,Pancel>{
        private Magusdao magusdao;
        private Pancelraktar raktar = null;

    public Pncellekerdezasync(Magusdao magusdao) {
        this.magusdao = magusdao;
    }

    @Override
    protected void onPostExecute(Pancel pancel) {
        raktar.Pancellekerdezfeltolt(pancel);
    }

    @Override
    protected Pancel doInBackground(String... strings) {
        return magusdao.pancelLekerdezes(strings[0]);
    }
}
    private static class pancelbeszuras extends AsyncTask<Pancel,Void,Void> {
        private Magusdao magdao;


        public pancelbeszuras(Magusdao magdao) {
            this.magdao = magdao;
        }


        @Override
        protected Void doInBackground(Pancel... pancels) {
            magdao.Panceéfeétolt(pancels[0]);
            return null;
        }
    }
    private static class panceltorles extends AsyncTask<Pancel,Void,Void>{
        private Magusdao magdao;


        public panceltorles(Magusdao magdao) {
            this.magdao = magdao;
        }


        @Override
        protected Void doInBackground(Pancel... pancels) {
            magdao.panceltorles(pancels[0]);
            return null;
        }
    }
    private static class pancelmodosit extends AsyncTask<Pancel,Void,Void>{
        private Magusdao magdao;


        public pancelmodosit(Magusdao magdao) {
            this.magdao = magdao;
        }


        @Override
        protected Void doInBackground(Pancel... pancels) {
            magdao.pancelmodositas(pancels[0]);
            return null;
        }
    }


}
