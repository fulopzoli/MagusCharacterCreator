package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;

import java.util.List;

// pancelok Repository
public class Raktar {
    private MutableLiveData<List<Karakter_targy>> Karaktertargylekerdez = new MutableLiveData<>();
    private MutableLiveData<Karakter_targy> Karaktertargyreszletlekerdez = new MutableLiveData<>();
    private MutableLiveData<List<Karakter_kepzetseg>> Karakterkepzetseglekrdez = new MutableLiveData<>();
    private MutableLiveData<List<Karakter_fegyver>> Karakterfegyverlekerdezes = new MutableLiveData<>();
    private MutableLiveData<List<Karakter_pancel>> KarakterpancelLekerdezes = new MutableLiveData<>();
    private MutableLiveData<Karakter_targy> KaraktertargylekerdezesByID = new MutableLiveData<>();

    private Magusdao magusdao;

    //teljes adatok
    private LiveData<List<Kepzetseg>> mindenkepzetsegadat;

    // reszleges adatok

    private LiveData<List<String>> kepzetsegnev;


    public Raktar(Application application) {
        Adatbaziskez adtatkez = Adatbaziskez.getPancelallpot(application);
        magusdao = adtatkez.magusdao();
        //összesadatok


        mindenkepzetsegadat = magusdao.kepzetsegosszeslekerdez();

        //reszleges adatok


    }
// Képzetségek


    public LiveData<List<Kepzetseg>> getMindenkepzetsegadatR() {
        return mindenkepzetsegadat;
    }

    public LiveData<List<String>> getKepzetsegnevR() {
        return kepzetsegnev;
    }

    public void kepzetseghazzadas(Kepzetseg kepzetseg) {
        new kepzetsegbeszuras(magusdao).execute();
    }

    public void kepzetsegtorol(Kepzetseg kepzetseg) {
        new kepzetsegtorles(magusdao).execute();
    }

    public void kepzetsegmodositas(Kepzetseg kepzetseg) {
        new kepzetsegmodosit(magusdao).execute();
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

    private static class kepzetsegtorles extends AsyncTask<Kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public kepzetsegtorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kepzetseg... kepzetsegs) {
            magusdao.kepzetsegtorles(kepzetsegs[0]);
            return null;
        }
    }

    private static class kepzetsegmodosit extends AsyncTask<Kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public kepzetsegmodosit(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Kepzetseg... kepzetsegs) {
            magusdao.kepzetsegmodositas(kepzetsegs[0]);
            return null;
        }
    }

    //*************************************************************************************************
    //Karakteradatok
    public void karakterpancelmodositas(Karakter_pancel karakter_pancel) {
        new karakterpancelmodositasync(magusdao).execute(karakter_pancel);
    }

    public void karaterpancelhaoozadas(Karakter_pancel karakter_pancel) {
        new karakterpancelbeszuras(magusdao).execute(karakter_pancel);
    }

    public void karaterpanceltorl(Karakter_pancel karakter_pancel) {
        new karakterpanceltorles(magusdao).execute(karakter_pancel);
    }

    public void karakterpancellekerdezfeltoltes(List<Karakter_pancel> karakter_pancel) {
        KarakterpancelLekerdezes.setValue(karakter_pancel);
    }

    public void setKarakterpancellekerdez(String karakternev) {
        KarakterpancellekerdezesAsync a = new KarakterpancellekerdezesAsync(magusdao);
        a.raktar = this;
        a.execute(karakternev);
    }

    public MutableLiveData<List<Karakter_pancel>> getKarakterpancelLekerdezes() {
        return KarakterpancelLekerdezes;
    }

    private static class KarakterpancellekerdezesAsync extends AsyncTask<String, Void, List<Karakter_pancel>> {
        private Magusdao magusdao;
        Raktar raktar = null;

        public KarakterpancellekerdezesAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected List<Karakter_pancel> doInBackground(String... strings) {
            return magusdao.karakterpancellekerdezes(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Karakter_pancel> karakter_pancels) {
            raktar.karakterpancellekerdezfeltoltes(karakter_pancels);
        }
    }

    private static class karakterpancelmodositasync extends AsyncTask<Karakter_pancel, Void, Void> {
        private Magusdao magusdao;

        public karakterpancelmodositasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_pancel... karakter_pancels) {
            magusdao.karaktrpancekmodositas(karakter_pancels[0]);
            return null;
        }
    }

    private static class karakterpancelbeszuras extends AsyncTask<Karakter_pancel, Void, Void> {
        private Magusdao magusdao;

        public karakterpancelbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }


        @Override
        protected Void doInBackground(Karakter_pancel... karakter_pancels) {
            magusdao.karakterpancelfeltolt(karakter_pancels[0]);
            return null;
        }
    }

    private static class karakterpanceltorles extends AsyncTask<Karakter_pancel, Void, Void> {
        private Magusdao magusdao;

        public karakterpanceltorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }


        @Override
        protected Void doInBackground(Karakter_pancel... karakter_pancels) {
            magusdao.karakterpanceltorol(karakter_pancels[0]);
            return null;
        }
    }


    //Karakterkepzetségek

    public void karakterkepzetseghozzad(Karakter_kepzetseg karakter_kepzetseg) {
        new karaterkepzetsegbeszuras(magusdao).execute();
    }

    public void karakterkepzetsegtorol(Karakter_kepzetseg karakter_kepzetseg) {
        new karakterkepzetsegtorles(magusdao).execute();
    }

    public void karakterkepzetseglekerdez(String karakternev) {
        karakterkepzetseglekerdez a = new karakterkepzetseglekerdez(magusdao);
        a.raktar = this;
        a.execute(karakternev);
    }

    public MutableLiveData<List<Karakter_kepzetseg>> getKarakterkepzetseglekrdezR() {
        return Karakterkepzetseglekrdez;
    }


    private static class karaterkepzetsegbeszuras extends AsyncTask<Karakter_kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public karaterkepzetsegbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_kepzetseg... karakter_kepzetsegs) {
            magusdao.karakterkepzetsegfeltolt(karakter_kepzetsegs[0]);
            return null;
        }
    }

    private static class karakterkepzetsegtorles extends AsyncTask<Karakter_kepzetseg, Void, Void> {
        private Magusdao magusdao;

        public karakterkepzetsegtorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_kepzetseg... karakter_kepzetsegs) {
            magusdao.karakkterkepzetsegtorol(karakter_kepzetsegs[0]);
            return null;
        }
    }

    private void KarakterkepzetsegkeresesAsync(List<Karakter_kepzetseg> eredmeny) {
        Karakterkepzetseglekrdez.setValue(eredmeny);
    }

    private static class karakterkepzetseglekerdez extends AsyncTask<String, Void, List<Karakter_kepzetseg>> {
        private Magusdao magusdao;
        private Raktar raktar = null;

        public karakterkepzetseglekerdez(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected List<Karakter_kepzetseg> doInBackground(String... strings) {
            return magusdao.kepzetseglekerdez(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Karakter_kepzetseg> karakter_kepzetsegs) {
            raktar.KarakterkepzetsegkeresesAsync(karakter_kepzetsegs);
        }
    }

    //Karakterfegyver


    public void karakterfegyverhozzadas(Karakter_fegyver karakter_fegyver) {
        new karakterfegyverbeszuras(magusdao).execute(karakter_fegyver);
    }

    public void karakterfegyvertorol(Karakter_fegyver karakter_fegyver) {
        new karakterfegyvertorles(magusdao).execute(karakter_fegyver);
    }

    public void karakterfegyvermodositas(Karakter_fegyver karakter_fegyver) {
        new Karakterfegyvermodositas(magusdao).execute(karakter_fegyver);
    }

    private static class Karakterfegyvermodositas extends AsyncTask<Karakter_fegyver, Void, Void> {
        private Magusdao magusdao;

        public Karakterfegyvermodositas(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_fegyver... karakter_fegyvers) {
            magusdao.karakterfegyvermodositas(karakter_fegyvers[0]);
            return null;
        }
    }

    private static class karakterfegyverbeszuras extends AsyncTask<Karakter_fegyver, Void, Void> {
        private Magusdao magusdao;

        public karakterfegyverbeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_fegyver... karakter_fegyvers) {
            magusdao.karakterfegyverfeltolt(karakter_fegyvers[0]);
            return null;
        }
    }

    private static class karakterfegyvertorles extends AsyncTask<Karakter_fegyver, Void, Void> {
        private Magusdao magusdao;

        public karakterfegyvertorles(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_fegyver... karakter_fegyvers) {
            magusdao.karakkterfegyvertorol(karakter_fegyvers[0]);
            return null;
        }
    }

    public void setkarakterfegyverlekerdez(String nev) {
        karakterfegyverlekerdezes a = new karakterfegyverlekerdezes(magusdao);
        a.raktar = this;
        a.execute(nev);

    }

    private void Karakterfegyveradatatadas(List<Karakter_fegyver> karakter_fegyvers) {
        Karakterfegyverlekerdezes.setValue(karakter_fegyvers);
    }

    public MutableLiveData<List<Karakter_fegyver>> getKarakterfegyverlekerdezes() {
        return Karakterfegyverlekerdezes;
    }

    private static class karakterfegyverlekerdezes extends AsyncTask<String, Void, List<Karakter_fegyver>> {
        private Magusdao magusdao;
        private Raktar raktar = null;

        public karakterfegyverlekerdezes(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected List<Karakter_fegyver> doInBackground(String... strings) {
            return magusdao.karakterfegyverlekerdezes(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Karakter_fegyver> karakter_fegyvers) {
            raktar.Karakterfegyveradatatadas(karakter_fegyvers);
        }
    }


    public void karaktertargylekerdezs(String karakternev) {
        Karaktertargylekerdezasync a = new Karaktertargylekerdezasync(magusdao);
        a.delegate = this;
        a.execute(karakternev);
    }

    private void karaktertagykeresesasync(List<Karakter_targy> eredmeny) {
        Karaktertargylekerdez.setValue(eredmeny);
    }

    public MutableLiveData<List<Karakter_targy>> getKaraktertargylekerdez() {
        return Karaktertargylekerdez;
    }

    public void karaktertargyhozzaadas(Karakter_targy karakter_targy) {
        new karaktertagybeszuras(magusdao).execute(karakter_targy);
    }

    public void karaktertargytorles(Karakter_targy karakter_targy) {
        new karaktertargytorol(magusdao).execute(karakter_targy);
    }

    private static class karaktertagybeszuras extends AsyncTask<Karakter_targy, Void, Void> {
        private Magusdao magusdao;

        public karaktertagybeszuras(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_targy... karakter_targies) {
            magusdao.karaktertargyhozzaad(karakter_targies[0]);
            return null;
        }

    }

    private static class karaktertargytorol extends AsyncTask<Karakter_targy, Void, Void> {
        private Magusdao magusdao;

        public karaktertargytorol(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_targy... karakter_targies) {
            magusdao.karaktertargytorol(karakter_targies[0]);
            return null;
        }


    }


    public void karaktertargymodosit(Karakter_targy karakter_targy){new KaraktertargymodositAsync(magusdao).execute(karakter_targy);}
    private static class KaraktertargymodositAsync extends  AsyncTask<Karakter_targy ,Void,Void>{
        private Magusdao magusdao;

        public KaraktertargymodositAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Void doInBackground(Karakter_targy... karakter_targies) {
            magusdao.karaktertargymodosit(karakter_targies[0]);
            return null;
        }
    }




    public void SetKaraktertargylekerdezesByID(int ID) {
        KaraktertargylekerdezesByIDAsync a = new KaraktertargylekerdezesByIDAsync(magusdao);
        a.raktar = this;
        a.execute(ID);
    }

    private void KaraktertargylekerdezesByIDFeltolt(Karakter_targy karakter_targy) {
        KaraktertargylekerdezesByID.setValue(karakter_targy);
    }

    public MutableLiveData<Karakter_targy> getKaraktertargylekerdezesByID() {
        return KaraktertargylekerdezesByID;
    }

    private static class KaraktertargylekerdezesByIDAsync extends AsyncTask<Integer, Void, Karakter_targy> {
        Magusdao magusdao;
        Raktar raktar = null;

        public KaraktertargylekerdezesByIDAsync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Karakter_targy doInBackground(Integer... integers) {
            return magusdao.karakterTargylekerdezesbyID(integers[0]);
        }

        @Override
        protected void onPostExecute(Karakter_targy karakter_targy) {
            raktar.KaraktertargylekerdezesByIDFeltolt(karakter_targy);
        }
    }

    private static class Karaktertargylekerdezasync extends AsyncTask<String, Void, List<Karakter_targy>> {
        private Magusdao magusdao;
        private Raktar delegate = null;

        public Karaktertargylekerdezasync(Magusdao magusdao) {
            this.magusdao = magusdao;
        }


        @Override
        protected List<Karakter_targy> doInBackground(String... strings) {
            return magusdao.karaktertagylekeres(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Karakter_targy> listLiveData) {
            delegate.karaktertagykeresesasync(listLiveData);
        }
    }

    public void Karaktertargyleirasinput(String targynev) {
        Karaktertargyreszletek a = new Karaktertargyreszletek(magusdao);
        a.raktar = this;
        a.execute(targynev);
    }

    private void Karaktertargyreszletleiras(Karakter_targy karakterTargy) {
        Karaktertargyreszletlekerdez.setValue(karakterTargy);
    }

    public MutableLiveData<Karakter_targy> getKaraktertargyreszletlekerdez() {
        return Karaktertargyreszletlekerdez;
    }

    private static class Karaktertargyreszletek extends AsyncTask<String, Void, Karakter_targy> {
        private Magusdao magusdao;
        private Raktar raktar = null;

        public Karaktertargyreszletek(Magusdao magusdao) {
            this.magusdao = magusdao;
        }

        @Override
        protected Karakter_targy doInBackground(String... strings) {
            return magusdao.targyleiras(strings[0]);
        }

        @Override
        protected void onPostExecute(Karakter_targy karakter_targy) {
            raktar.Karaktertargyreszletleiras(karakter_targy);
        }
    }


}

