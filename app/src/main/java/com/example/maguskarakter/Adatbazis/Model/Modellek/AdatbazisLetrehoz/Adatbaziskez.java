package com.example.maguskarakter.Adatbazis.Model.Modellek.AdatbazisLetrehoz;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Dao.Magusdao;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fajok;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kasztok;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;
import com.example.maguskarakter.R;


@Database(entities = {Pancel.class, Kepzetseg.class, Kasztok.class, Karakter_pancel.class, Karakter_kepzetseg.class, Karakter_fegyver.class,
        Karakter.class, Fegyverek.class, Fajok.class, Karakter_targy.class, Karakter_spell.class, Varazslatok.class, Targy.class}, version = 1)
public abstract class Adatbaziskez extends RoomDatabase {

    private static Adatbaziskez allapot;

    public abstract Magusdao magusdao();

    public static synchronized Adatbaziskez getPancelallpot(Context context) {
        if (allapot == null) {
            allapot = Room.databaseBuilder(context.getApplicationContext(), Adatbaziskez.class, "magus_database")
                    .fallbackToDestructiveMigration().addCallback(roomcallback).build();
        }
        return allapot;
    }

    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populal(allapot).execute();


        }
    };

    private static class populal extends AsyncTask<Void, Void, Void> {

        private Magusdao magdao;

        public populal(Adatbaziskez db) {
            this.magdao = db.magusdao();

        }


        @Override
        protected Void doInBackground(Void... voids) {
// alappancelok
            String s;
            magdao.Panceéfeétolt(new Pancel("a", "Acél", "200 arany","Mi a Lorem Ipsum?\n" +
                    "A Lorem Ipsum egy egyszerû szövegrészlete, szövegutánzata a betûszedõ és nyomdaiparnak. A Lorem Ipsum az 1500-as évek óta standard szövegrészletként szolgált az iparban; mikor egy ismeretlen nyomdász összeállította a betûkészletét és egy példa-könyvet vagy szöveget nyomott papírra, ezt használta. Nem csak 5 évszázadot élt túl, de az elektronikus betûkészleteknél is változatlanul megmaradt. Az 1960-as években népszerûsítették a Lorem Ipsum részleteket magukbafoglaló Letraset lapokkal, és legutóbb softwarekkel mint például az Aldus Pagemaker.\n" +
                    "\n" +
                    "Miért használjuk?\n" +
                    "Ez egy régóta elfogadott tény, miszerint egy olvasót zavarja az olvasható szöveg miközben a szöveg elrendezését nézi. A Lorem Ipsum használatának lényege, hogy többé-kevésbé rendezettebb betûket tartalmaz, ellentétben a Tartalom helye, Tartalom helye-féle megoldással. Sok desktop szerkesztõ és weboldal szerkesztõ használja a Lorem Ipsum-ot mint alapbeállítású szövegmodellt, és egy keresés a lorem ipsum-ra sok félkész weboldalt fog eredményezni.\n" +
                    "\n" ,8, 6, 35));

//alapfegyverek
            magdao.Fegyverfeltolt(new Fegyverek("Odachi", "1k6+1","Szúró/Vágófegyverek" ,13, 14, 8, "1,8", "1a 3e","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in eros vitae odio tincidunt iaculis sit amet in leo. Aenean ac neque et massa euismod gravida vitae at turpis. Cras fermentum vestibulum magna, vel interdum erat egestas vel. Etiam non leo nec massa euismod pellentesque eget ut augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce consequat lectus mauris, quis ultrices mauris auctor quis. Fusce tempus metus sit amet laoreet tristique.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Pellentesque scelerisque justo eu diam aliquet, id facilisis dolor varius. In faucibus blandit pulvinar. Donec vehicula in tellus ut volutpat. In mollis, ex nec ultrices consectetur, ex nibh tristique magna, s"));

            magdao.Fegyverfeltolt(new Fegyverek("Hosszúkard", "1k6+1","Szúró/Vágófegyverek" ,13, 14, 8, "1,8", "1a 3e","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in eros vitae odio tincidunt iaculis sit amet in leo. Aenean ac neque et massa euismod gravida vitae at turpis. Cras fermentum vestibulum magna, vel interdum erat egestas vel. Etiam non leo nec massa euismod pellentesque eget ut augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce consequat lectus mauris, quis ultrices mauris auctor quis. Fusce tempus metus sit amet laoreet tristique.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Pellentesque scelerisque justo eu diam aliquet, id facilisis dolor varius. In faucibus blandit pulvinar. Donec vehicula in tellus ut volutpat. In mollis, ex nec ultrices consectetur, ex nibh tristique magna, s"));



            //kasztok
            magdao.kasztfeltolt(new Kasztok("Harcos", "Harcos", "9", "20", "75", "0", "10", "7",
                    "6", "11", "14", "0", "0", "K6+4"));
            //Kepzetseg

            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));
            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));
            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));
            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));
            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));
            magdao.karakterkepzetsegfeltolt(new Karakter_kepzetseg("Konti","Alkimia","Mf"," - "));

            magdao.karakterfegyverfeltolt(new Karakter_fegyver("Konti","Odachi"));

            magdao.varazslathozzad(new Varazslatok("Spell","Varazshasználó","Tűzvarázsló",
                    "A Sárkány lehellete","","42","10k6","19","7 szegmens"," - ",
            "5 Perc ","-"," - ","Fireeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeebaaaaaaaaaaaaaaallll","-"));

           magdao.karakterspellhozzaad(new Karakter_spell("Konti","A Sárkány lehellete"));

            magdao.Kepzetsegfeltolt(new Kepzetseg("Alkimia", "Mesteralkimia"));
            magdao.Kepzetsegfeltolt(new Kepzetseg("Élettan","Alapélettan"));

            magdao.karaktertargyhozzaad(new Karakter_targy("Konti", "Cipő",5));

            magdao.Targyhozzaad(new Targy("Fáklya","kuthtsthsvuthhrgcmcgruhgvijfabgcraithvt"));
            magdao.Targyhozzaad(new Targy("Cipő","ksjachlsmcflas"));

            magdao.Fegyverfeltolt(new Fegyverek("Gladius", "1k6+1","Szúró/Vágófegyverek" ,13, 14, 8, "1,8", "1a 3e","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in eros vitae odio tincidunt iaculis sit amet in leo. Aenean ac neque et massa euismod gravida vitae at turpis. Cras fermentum vestibulum magna, vel interdum erat egestas vel. Etiam non leo nec massa euismod pellentesque eget ut augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce consequat lectus mauris, quis ultrices mauris auctor quis. Fusce tempus metus sit amet laoreet tristique.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Pellentesque scelerisque justo eu diam aliquet, id facilisis dolor varius. In faucibus blandit pulvinar. Donec vehicula in tellus ut volutpat. In mollis, ex nec ultrices consectetur, ex nibh tristique magna, s"));
            magdao.Fegyverfeltolt(new Fegyverek("Buzogány", "1k6+1","Zúzófegyverek" ,13, 14, 8, "1,8", "1a 3e","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in eros vitae odio tincidunt iaculis sit amet in leo. Aenean ac neque et massa euismod gravida vitae at turpis. Cras fermentum vestibulum magna, vel interdum erat egestas vel. Etiam non leo nec massa euismod pellentesque eget ut augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce consequat lectus mauris, quis ultrices mauris auctor quis. Fusce tempus metus sit amet laoreet tristique.\\n\" +\n" +
                    "                    \"\\n\" +\n" +

                    "                    \"Pellentesque scelerisque justo eu diam aliquet, id facilisis dolor varius. In faucibus blandit pulvinar. Donec vehicula in tellus ut volutpat. In mollis, ex nec ultrices consectetur, ex nibh tristique magna, s"));

            magdao.Fegyverfeltolt(new Fegyverek("Buzogány", "1k6+1","Zúzófegyverek" ,13, 14, 8, "1,8", "1a 3e","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in eros vitae odio tincidunt iaculis sit amet in leo. Aenean ac neque et massa euismod gravida vitae at turpis. Cras fermentum vestibulum magna, vel interdum erat egestas vel. Etiam non leo nec massa euismod pellentesque eget ut augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce consequat lectus mauris, quis ultrices mauris auctor quis. Fusce tempus metus sit amet laoreet tristique.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Pellentesque scelerisque justo eu diam aliquet, id facilisis dolor varius. In faucibus blandit pulvinar. Donec vehicula in tellus ut volutpat. In mollis, ex nec ultrices consectetur, ex nibh tristique magna, s"));

            // karakterpancel

            magdao.karakterpancelfeltolt(new Karakter_pancel("Konti","a"));
//peldakarakter
          magdao.karakterfeltolt(new Karakter("Konti","Tűzvarázsló","Elf","Élet,Káosz","Piaron","Piaron"," - ",
                  5,20,20,20,20,20,20,20,20,20,20,
                  20,20,2,20,20,20,20,20,20,20,20,20,20,20,20,
          20,0,R.drawable.ic_a));



            return null;
        }
    }

}
