package com.example.maguskarakter.Fragment.KarakteradatokFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.Fragment.Dialog.Harcertekdialogfragment;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class KarakteradatokFragment extends Fragment implements Harcertekdialogfragment.harcertekdialoglistener {

    private KarakterViewModel karakterViewModel;

 private ImageView kepikep;

    TextView karnev, karikor, vallas, faj, jellem, kaszt,
            szint, ero, gyorsasag, ugyesseg, allokepesseg,
            egeszseg, szepseg, inteligencia, akaratero, asztral,
            ke, te, ve, ce, mana, pszi, mgt, maxep, maxfp;

    private int id,varmana,varalapszi, varep, varfp;;
    ;
    private String nev;
    private Karakter karakters;

    public  Karakter getKarakters() {
        return karakters;
    }

    private   Button modositas;
   private Harcertekdialogfragment harcertekdialogfragment = new Harcertekdialogfragment();

    public KarakteradatokFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View myview = inflater.inflate(R.layout.fragment_karakteradatok, container, false);
        kepikep=myview.findViewById(R.id.Karakteradatkep);


        karnev = myview.findViewById(R.id.karakternevStat);
        karikor = myview.findViewById(R.id.karakterKorStat);
        vallas = myview.findViewById(R.id.karakterVallasStat2);
        faj = myview.findViewById(R.id.KarakterFajStat);
        jellem = myview.findViewById(R.id.karakterJellemStat3);
        kaszt = myview.findViewById(R.id.karakterKasztStat);
        szint = myview.findViewById(R.id.karakterSzintStat);
        ero = myview.findViewById(R.id.KarakterEroSrat);
        gyorsasag = myview.findViewById(R.id.KarakterGyorsasagStat);
        ugyesseg = myview.findViewById(R.id.KarakterÜgyessegStat);
        allokepesseg = myview.findViewById(R.id.KarakterAllokepesegStat);
        egeszseg = myview.findViewById(R.id.KarakterEgesegStat);
        szepseg = myview.findViewById(R.id.KarakterSzepsegStat);
        inteligencia = myview.findViewById(R.id.KarakterInteligenciaStat);
        akaratero = myview.findViewById(R.id.KarakterAkaratSrat);
        asztral = myview.findViewById(R.id.KaraakterAsztralStat);
        ke = myview.findViewById(R.id.karakterKESestat);
        ce = myview.findViewById(R.id.karakterCEstat);
        ve = myview.findViewById(R.id.karakterVESestat2);
        te = myview.findViewById(R.id.karakterTEestat);
        mana = myview.findViewById(R.id.ManaMaxmana);
        pszi = myview.findViewById(R.id.PsziMaxpszi);
        mgt = myview.findViewById(R.id.karaktermgt);
        maxep = myview.findViewById(R.id.Epmaxep);
        maxfp = myview.findViewById(R.id.Fpmaxfp);
        //Button
        modositas = myview.findViewById(R.id.ModositasEpFpMpPszi);

        id = getArguments().getInt("KariID");
        nev = getArguments().getString("Karinev");



        karakterViewModel = new ViewModelProvider(requireActivity()).get(KarakterViewModel.class);
        karakterViewModel.karakteradatoklekerdez(id);
        karakterViewModel.getKarakteradateredmeny().observe(getViewLifecycleOwner(), new Observer<Karakter>() {
            @Override
            public void onChanged(Karakter karakter) {
                if (karakter == null) {
                    Toast.makeText(getContext(), "NUll értékű az object ", Toast.LENGTH_LONG).show();
                }
                else {

                    karakters=karakter;
                    karnev.setText(karakter.getNev());
                    karikor.setText(karakter.getKor() + " éves");
                    vallas.setText(karakter.getVallas());
                    faj.setText(karakter.getFaj());
                    jellem.setText(karakter.getJellem());
                    kaszt.setText(karakter.getKaszt());
                    szint.setText(karakter.getSzint() + ". Szint");

                    ero.setText(String.valueOf(karakter.getEro()));
                    gyorsasag.setText(String.valueOf(karakter.getGyorsasag()));
                    ugyesseg.setText(String.valueOf(karakter.getUgyesseg()));
                    allokepesseg.setText(String.valueOf(karakter.getAllokepeseg()));
                    egeszseg.setText(String.valueOf(karakter.getEgeszseg()));
                    szepseg.setText(String.valueOf(karakter.getSzepseg()));
                    inteligencia.setText(String.valueOf(karakter.getInteligencia()));
                    akaratero.setText(String.valueOf(karakter.getAkaratero()));
                    asztral.setText(String.valueOf(karakter.getAsztral()));

                    kepikep.setImageResource(karakter.getKarakterkep()  );


                    ke.setText("Ké : " + String.valueOf(karakter.getKe()));
                    ve.setText("Vé : " + String.valueOf(karakter.getVe()));
                    te.setText("Té : " + String.valueOf(karakter.getTe()));
                    ce.setText("Cé : " + String.valueOf(karakter.getCe()));
                    mgt.setText("Mgt : " + String.valueOf(karakter.getMgt()));


                    mana.setText(String.valueOf(karakter.getMana()) + " / " + String.valueOf(karakter.getMaxmana()));
                    pszi.setText(String.valueOf(karakter.getAlapAsztral()) + " / " + String.valueOf(karakter.getMaxAsztral()));


                    maxep.setText((String.valueOf(karakter.getEp()) + " / " + String.valueOf(karakter.getMaxep())));
                    maxfp.setText((String.valueOf(karakter.getFp()) + " / " + String.valueOf(karakter.getMaxfp())));
                }

                modositas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        opendialog();
                    }
                });


            }
        });

        return myview;
    }

    private void opendialog() {

        harcertekdialogfragment.setMaxpszialapszi(karakters.getMaxAsztral());
        harcertekdialogfragment.setMaxmana(karakters.getMaxmana());
        harcertekdialogfragment.setMaxep(karakters.getMaxep());
        harcertekdialogfragment.setMaxfp(karakters.getMaxfp());
        harcertekdialogfragment.setAktep(karakters.getEp());
        harcertekdialogfragment.setAktfp(karakters.getFp());
        harcertekdialogfragment.setAktpszi(karakters.getAlapAsztral());
        harcertekdialogfragment.setAktmana(karakters.getMana());
        harcertekdialogfragment.setTargetFragment(KarakteradatokFragment.this,1);
        harcertekdialogfragment.show(getFragmentManager(), "Harcertekdialog");


    }
    @Override
    public void ertekek(int aktep, int aktfp, int aktmana, int aktpszi) {
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
        karakters.setEp(aktep);
        karakters.setFp(aktfp);
        karakters.setMana(aktmana);
        karakters.setAlapAsztral(aktpszi);
        karakterViewModel.karatermodositas(karakters);

    }
}
