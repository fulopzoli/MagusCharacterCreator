package com.example.maguskarakter.Fragment.RészletekFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;
import com.example.maguskarakter.Fragment.Dialog.Mennyisegmodositodialog;
import com.example.maguskarakter.Fragment.KarakteradatokFragment.KarakterfelszerelesFragment;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;
import com.example.maguskarakter.ViewModell.TargyViewModel;


public class Targyleirasreszletek extends Fragment implements Mennyisegmodositodialog.tagymennyisegmodosito {

    public static final String KARAKTERFEGYVERLEKERDEZBYIDTOMODOSITAS = "KarakterFegyverIdLekerdezesssek";

    public Targyleirasreszletek() {
        // Required empty public constructor
    }

    private TargyViewModel targyViewModel;
    private MagusViewmodell magusViewmodell;
    private Button MennyisegModositasButtonReszletID;
    private String karinev,targyleiras;
    Karakter_targy karakter_targyrrr;

    private Mennyisegmodositodialog mennyisegmodositodialog = new Mennyisegmodositodialog();


    TextView Targyleirasnev, Targyleirasleirasid, TargymennyisegModositasReszletID;
    String targynev;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_targyleirasreszletek, container, false);
        Targyleirasleirasid = view.findViewById(R.id.Tárgyleirasleirasid);
        Targyleirasnev = view.findViewById(R.id.Targyleirasnev);
        TargymennyisegModositasReszletID = view.findViewById(R.id.TargymennyisegModositasReszletID);
        MennyisegModositasButtonReszletID = view.findViewById(R.id.MennyisegModositasButtonReszletID);

        if (getArguments().getString(ReszletekActivity.TARGYLEIRASBUNDLE) != null) {
            targynev = getArguments().getString(ReszletekActivity.TARGYLEIRASBUNDLE);
        } else if (getArguments().getString("TargynevToREszlet") != null) {
            targynev = getArguments().getString("TargynevToREszlet");

        }

        if (targynev != null) {

            magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
            targyViewModel = new ViewModelProvider(this).get(TargyViewModel.class);

            int karakterid = getArguments().getInt(ReszletekActivity.TARGYLEIRASBUNDLEID, -1);
            String KarakterID = String.valueOf(getArguments().getInt(ReszletekActivity.TARGYLEIRASBUNDLEID, -1));
            if (getArguments().getInt(ReszletekActivity.TARGYLEIRASBUNDLEID) != -1) {


                magusViewmodell.SetKarakter_targyLekerdezesByID(karakterid);
                magusViewmodell.getKarakterTargyLekerdezByID().observe(getViewLifecycleOwner(), new Observer<Karakter_targy>() {
                    @Override
                    public void onChanged(Karakter_targy karakter_targy) {

                        karakter_targyrrr=karakter_targy;
                            MennyisegModositasButtonReszletID.setVisibility(View.VISIBLE);
                            TargymennyisegModositasReszletID.setVisibility(View.VISIBLE);
                            TargymennyisegModositasReszletID.setText("Mennyiség : " + String.valueOf(karakter_targy.getMennyiseg()) + "db");
                            karinev=karakter_targy.getKarakternev();
                            targyleiras=karakter_targy.getTargy();
                        MennyisegModositasButtonReszletID.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                modositodialog();
                            }
                        });

                    }
                });



            }
        }



        targyViewModel.SetTargyReszletLekerdez(targynev);
        targyViewModel.getTargyLeirasLekerdez().observe(getViewLifecycleOwner(), new Observer<Targy>() {
            @Override
            public void onChanged(Targy targy) {
                Targyleirasnev.setText("Név : " + targy.getTargynev());
                Targyleirasleirasid.setText("Leírás : " + targy.getLeiras());
            }
        });
        return view;

    }
    // Inflate the layout for this fragment
    private void modositodialog(){
        mennyisegmodositodialog.setTargetFragment(Targyleirasreszletek.this,9999);
        mennyisegmodositodialog.show(getFragmentManager(),"TargyMennyisegModositoDialog");
    }

    @Override
    public void darab(int db) {
        karakter_targyrrr.setMennyiseg(db);
        magusViewmodell.karaktertargymodosit(karakter_targyrrr);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
