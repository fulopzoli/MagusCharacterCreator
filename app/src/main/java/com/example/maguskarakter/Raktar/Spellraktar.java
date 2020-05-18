package com.example.maguskarakter.Raktar;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz.Adatbaziskez;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;

import java.util.List;

public class Spellraktar {
   private MutableLiveData<List<Varazslatok>>Spellvagypszi= new MutableLiveData<>();
   private MutableLiveData<Varazslatok>Varazslatreszletlekerdezes= new MutableLiveData<>();
   private MutableLiveData<List<Varazslatok>>Varazsslatok_kasztokkent= new MutableLiveData<>();

   private Magusdao magusdao;

    public Spellraktar(Application application){
       Adatbaziskez adatbaziskez=Adatbaziskez.getPancelallpot(application);
       magusdao=adatbaziskez.magusdao();
    }
    //SPELLVAGYPSZILEKERDEZ*************************************************************************************************


    //Lekerdez bemenet
   public void setSpellvagypszilekerdez(String spellvagypszi){ spellvagypsziasyc a =new spellvagypsziasyc(magusdao);
   a.spellraktar=this;
   a.execute(spellvagypszi);}

    //Lekerdezes Visszaadasa
    public  void spellvagypsikeresasync(List<Varazslatok> varazslatoks){Spellvagypszi.setValue(varazslatoks);}
    public MutableLiveData<List<Varazslatok>> getspellvagypsilekerdez(){return Spellvagypszi;}

    //Lekerdezes hatterszalon
    private static class spellvagypsziasyc extends AsyncTask<String,Void,List<Varazslatok>>{
      Magusdao magusdao;
      private Spellraktar spellraktar=null;

       public spellvagypsziasyc(Magusdao magusdao) {
          this.magusdao = magusdao;
       }

       @Override
       protected List<Varazslatok> doInBackground(String... strings) {
          return magusdao.spellvagypszi(strings[0]);
       }

       @Override
       protected void onPostExecute(List<Varazslatok> varazslatoks) {
          spellraktar.spellvagypsikeresasync(varazslatoks);
       }
    }

    //****************************************************************************************************************************

   //VARAZSLATRESZLETLEKERDEZES****************************************************************************************************
   //Lekerdez bemenet
   public void setVarazslatreszletlekerdezese(String varazslatnev){varazslatbynameasync a=new varazslatbynameasync(magusdao);
    a.spellraktar=this;
    a.execute(varazslatnev);}

   //Lekerdezes Visszaadasa
   public void varazslatbynameasync(Varazslatok varazslatok){Varazslatreszletlekerdezes.setValue(varazslatok);}
   public MutableLiveData<Varazslatok> getvarazslatreszletlekerdez(){return Varazslatreszletlekerdezes;}

   //Lekerdezes hatterszalon
   private static  class varazslatbynameasync extends AsyncTask<String,Void,Varazslatok>{
       Magusdao magusdao;
       Spellraktar spellraktar=null;

      public varazslatbynameasync(Magusdao magusdao) {
         this.magusdao = magusdao;
      }

      @Override
      protected Varazslatok doInBackground(String... strings) {
         return magusdao.magiareszlet(strings[0]);
      }

      @Override
      protected void onPostExecute(Varazslatok varazslatok) {
          spellraktar.varazslatbynameasync(varazslatok);
      }
   }

   //Spellhozzadas**********************************************************************************************************************************

   public void spellhozzaadas(Varazslatok varazslatok){new spellhozzaadasasync(magusdao).execute(varazslatok);}
   private static class  spellhozzaadasasync extends AsyncTask<Varazslatok,Void,Void>{
      Magusdao magusdao;

      public spellhozzaadasasync(Magusdao magusdao) {
         this.magusdao = magusdao;
      }

      @Override
      protected Void doInBackground(Varazslatok... varazslatoks) {
         magusdao.varazslathozzad(varazslatoks[0]);
         return null;
      }
   }

   //Spellmodositas**********************************************************************************************************************************

   public void spellmodositas(Varazslatok varazslatok){new spellmodositasync(magusdao).execute(varazslatok);}
   private static class spellmodositasync extends AsyncTask<Varazslatok,Void,Void>{
       Magusdao magusdao;

      public spellmodositasync(Magusdao magusdao) {
         this.magusdao = magusdao;
      }

      @Override
      protected Void doInBackground(Varazslatok... varazslatoks) {
         magusdao.varazslatmodositas(varazslatoks[0]);
         return null;
      }
   }

   //SPELLTÖRLES**************************************************************************************************************************************

   private void spelltorles(Varazslatok varazslatok){new spelltorlesasync(magusdao).execute(varazslatok);}
   private static class spelltorlesasync extends  AsyncTask<Varazslatok,Void,Void>{
       Magusdao magusdao;

      public spelltorlesasync(Magusdao magusdao) {
         this.magusdao = magusdao;
      }

      @Override
      protected Void doInBackground(Varazslatok... varazslatoks) {
         magusdao.varazslattorles(varazslatoks[0]);
         return null;
      }
   }








}
