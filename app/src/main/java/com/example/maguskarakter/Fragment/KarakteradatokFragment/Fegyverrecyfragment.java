package com.example.maguskarakter.Fragment.KarakteradatokFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterFegyverRecyclerAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.List;


public class Fegyverrecyfragment extends Fragment {

    private MagusViewmodell magusViewmodell;


    public Fegyverrecyfragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    String nev;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fegyverrecyfragment, container, false);
        RecyclerView recy = view.findViewById(R.id.karakterfegyverlistaID);
        final KarakterFegyverRecyclerAdapter adapter = new KarakterFegyverRecyclerAdapter(container.getContext());
        recy.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recy.setAdapter(adapter);

        nev = getArguments().getString("KariFegyveresnev");

        magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
        magusViewmodell.SetKarakterfegyverlekerdezes(nev);
        magusViewmodell.getKarakterfegyverlekerdezes().observe(getViewLifecycleOwner(), new Observer<List<Karakter_fegyver>>() {
            @Override
            public void onChanged(List<Karakter_fegyver> karakter_fegyvers) {
                adapter.setKarifegyver(karakter_fegyvers);
                adapter.setKarakternev(nev);
            }
        });
        adapter.torlesgomrakattint(new KarakterFegyverRecyclerAdapter.deleteclicklistener() {
            @Override
            public void torlesgom(final Karakter_fegyver karakter_fegyver) {
            magusViewmodell.karakterfegyvertorol(karakter_fegyver);
            fragmentfrissit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void fragmentfrissit() {
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().detach(this).attach(this).commit();
    }
}
