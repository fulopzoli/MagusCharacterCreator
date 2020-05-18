package com.example.maguskarakter.Fragment.KarakteradatokFragment;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterfelszerelesRecyclerAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Fragment.Dialog.Penzmodositodialog;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterViewModel;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KarakterfelszerelesFragment extends Fragment implements Penzmodositodialog.penzmodositodialoginterface {

    private KarakterViewModel karakterViewModel;
    private MagusViewmodell magusViewmodell;
    private TextView Aranystat, EzüstStat, ReztStat;
    private String Karakternev,nev;
    private Penzmodositodialog penzmodositodialog=new Penzmodositodialog();
    private Karakter  karakteres;
    private Button fizetes;
    private Spinner Felszerlestipus;

    public KarakterfelszerelesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karakterfelszereles, container, false);

        int id = getArguments().getInt("KariID");
         nev=getArguments().getString("Karinev");


        Felszerlestipus=view.findViewById(R.id.Felszeresvalosztospinner);

        fizetes=view.findViewById(R.id.Fizetes);

        Aranystat = view.findViewById(R.id.Aranystat);
        EzüstStat = view.findViewById(R.id.EzüstStat);
        ReztStat = view.findViewById(R.id.ReztStat);

        targyvalasztospinner();
        Felszerlestipus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bun=new Bundle();
                FragmentManager fm = getFragmentManager();
                switch(i){
                    case 0:
                        Fragment Fegyve=new Fegyverrecyfragment();
                        bun.putString("KariFegyveresnev",getArguments().getString("Karinev"));
                        Fegyve.setArguments(bun);
                        fm.beginTransaction().replace(R.id.FelszerelésFramelayoutid,Fegyve).commit();

                        break;
                    case 1:
                        Fragment Karipancel=new KarakterPancelRecycler();
                        bun.putString("Karipancel",getArguments().getString("Karinev"));
                        Karipancel.setArguments(bun);
                        fm.beginTransaction().replace(R.id.FelszerelésFramelayoutid,Karipancel).commit();



                        break;
                    case 2:
                        Fragment egyebtargy=new EgyebfelszerelesitemFragment();
                        bun.putString("Karimarinev",getArguments().getString("Karinev"));
                        egyebtargy.setArguments(bun);
                        fm.beginTransaction().replace(R.id.FelszerelésFramelayoutid,egyebtargy).commit();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        karakterViewModel = new ViewModelProvider(this).get(KarakterViewModel.class);
        karakterViewModel.karakteradatoklekerdez(id);
        karakterViewModel.getKarakteradateredmeny().observe(getViewLifecycleOwner(), new Observer<Karakter>() {
            @Override
            public void onChanged(Karakter karakter) {
                if (karakter!=null){
                    karakteres=karakter;
                    Aranystat.setText("Arany : " + karakteres.getArany());
                    EzüstStat.setText("Ezüst : " + karakteres.getEzust());
                    ReztStat.setText("Réz : " + karakteres.getRez());}
                else{Aranystat.setText("nemjo");}
            }
        });

        fizetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    private void openDialog(){

        penzmodositodialog.setArany(karakteres.getArany());
        penzmodositodialog.setEzust(karakteres.getEzust());
        penzmodositodialog.setRez(karakteres.getRez());
        penzmodositodialog.setTargetFragment(KarakterfelszerelesFragment.this,2);
        penzmodositodialog.show(getFragmentManager(),"Penzmodositodialogtag");
    }

    @Override
    public void penzertekek(int arany, int ezust, int rez) {
        FragmentTransaction ft  = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
        karakteres.setArany(arany);
        karakteres.setEzust(ezust);
        karakteres.setRez(rez);
        karakterViewModel.karatermodositas(karakteres);

    }

    private void targyvalasztospinner(){
        ArrayAdapter<CharSequence> adapter;
        adapter=ArrayAdapter.createFromResource(getContext(),R.array.felszereles_tipus,R.layout.spinneritem);
        Felszerlestipus.setAdapter(adapter);
    }
}
