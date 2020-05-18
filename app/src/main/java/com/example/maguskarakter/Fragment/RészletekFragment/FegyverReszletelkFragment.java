package com.example.maguskarakter.Fragment.RészletekFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Activity.TargykeszitesActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.FegyverekViewModel;


public class FegyverReszletelkFragment extends Fragment {

    public FegyverReszletelkFragment() {
        // Required empty public constructor
    }

    private FegyverekViewModel fegyverekViewModel;
    String fegyvernev;
    TextView Nev, Sebzes, se, ve, ke, ar, leiras, Tipus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fegyver_reszletelk, container, false);
        Nev = view.findViewById(R.id.FegyverReszletekNevID);
        Sebzes = view.findViewById(R.id.fegyverReszletekSebzesID);
        se = view.findViewById(R.id.fegyverReszletekSebzOERTEKID);
        ve = view.findViewById(R.id.fegyverReszletekvedoertekID);
        ke = view.findViewById(R.id.fegyverReszletKezdoErtekID);
        ar = view.findViewById(R.id.fegyverReszletÁRID);
        leiras = view.findViewById(R.id.fegyverleirasFragmentID);
        Tipus = view.findViewById(R.id.fegyverReszletekTipusID);


        if (getArguments().getString(ReszletekActivity.FEGYVERNEVBUNDLE) != null) {

            fegyvernev = getArguments().getString(ReszletekActivity.FEGYVERNEVBUNDLE);

        } else if (getArguments().getString(TargykeszitesActivity.FEGYVERNEVKESZITESBUNDLE) != null) {

            fegyvernev = getArguments().getString(TargykeszitesActivity.FEGYVERNEVKESZITESBUNDLE);
        }
        if (fegyvernev != null) {
            fegyverekViewModel = new ViewModelProvider(this).get(FegyverekViewModel.class);
            fegyverekViewModel.setFegyverekreszletleiras(fegyvernev);


            fegyverekViewModel.getFegyverekleiras().observe(getViewLifecycleOwner(), new Observer<Fegyverek>() {
                @Override
                public void onChanged(Fegyverek fegyverek) {
                    Nev.setText("Név : " + fegyverek.getFegyvernev());
                    Sebzes.setText("Sebzés : " + fegyverek.getSebzes());
                    se.setText("Se : " + fegyverek.getSe());
                    ve.setText("Ve : " + fegyverek.getVe());
                    ke.setText("Ke : " + fegyverek.getKe());
                    ar.setText("Ár : " + fegyverek.getAr());
                    leiras.setText("Leírás : " + fegyverek.getLeiras());
                    Tipus.setText("Kategória : " + fegyverek.getKategoria());
                }
            });
        }

        // Inflate the layout for this fragment
        return view;
    }
}
