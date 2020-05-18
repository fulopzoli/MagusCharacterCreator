package com.example.maguskarakter.Fragment.KarakteradatokFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KaraktervarazslatrecyclerAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterspellViewModel;

import java.util.List;


public class Karaktervarazslatrecy extends Fragment {
    private String nev;

    Context context;
    Context coni;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public Karaktervarazslatrecy() {
        // Required empty public constructor
    }

    KarakterspellViewModel karakterspellViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karaktervarazslatrecy, container, false);
        if (context != null) {

            RecyclerView recyclerView = view.findViewById(R.id.Karaktervarazslatirecyclerid);
            final KaraktervarazslatrecyclerAdapter a = new KaraktervarazslatrecyclerAdapter(context);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(a);

            nev = getArguments().getString(ReszletekActivity.VARAZSLATRECYCLERNEVATADAS);

            karakterspellViewModel = new ViewModelProvider(this).get(KarakterspellViewModel.class);
            karakterspellViewModel.karakterspelllekerdezes(nev);

            karakterspellViewModel.karakterspelllekerdezeredmeny().observe(getViewLifecycleOwner(), new Observer<List<Karakter_spell>>() {
                @Override
                public void onChanged(List<Karakter_spell> karakter_spells) {
                    a.setKarispell(karakter_spells);
                }
            });
        } else {
            Toast.makeText(context, "Valami nem jó", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}
