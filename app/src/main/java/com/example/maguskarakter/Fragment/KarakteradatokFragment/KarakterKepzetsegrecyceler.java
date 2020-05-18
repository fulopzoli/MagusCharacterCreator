package com.example.maguskarakter.Fragment.KarakteradatokFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterkepzetsegRecycleAdaper;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.ArrayList;
import java.util.List;

public class KarakterKepzetsegrecyceler extends Fragment {

    public KarakterKepzetsegrecyceler() {
        // Required empty public constructor
    }

    private MagusViewmodell magusViewmodell;
    private Context context;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_karakter_kepzetsegrecyceler, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.karakterkepzetsegrecyclerid);
        final KarakterkepzetsegRecycleAdaper karakterkepzetsegRecycleAdaper = new KarakterkepzetsegRecycleAdaper(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(karakterkepzetsegRecycleAdaper);



        String nev = getArguments().getString(ReszletekActivity.KEPZETSEGRECYCLERATADAS);



        magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
        magusViewmodell.KarakterKepzetseglekerdezes(nev);
        magusViewmodell.getKarakterkepzetseglekepezeredmeny().observe(getViewLifecycleOwner(), new Observer<List<Karakter_kepzetseg>>() {
            @Override
            public void onChanged(List<Karakter_kepzetseg> karakter_kepzetsegs) {
               karakterkepzetsegRecycleAdaper.setKepzetseg(karakter_kepzetsegs);
            }
        });

        return view;
    }




}
