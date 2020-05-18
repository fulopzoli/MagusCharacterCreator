package com.example.maguskarakter.Fragment.RészletekFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Kepzetseg;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KepzetsegViewModel;

import java.util.List;

import static com.example.maguskarakter.Activity.ReszletekActivity.KEPZETSEGNEVBUNDLE;

public class KepzetsegReszletFragment extends Fragment {

    private KepzetsegViewModel kepzetseg;

    public KepzetsegReszletFragment() {
        // Required empty public constructor
    }

    TextView neve,leiras;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kepzetseg_reszlet, container, false);
        // Inflate the layout for this fragment
        neve = view.findViewById(R.id.Kepzetsegreszletneveid);
        leiras=view.findViewById(R.id.Kepzetsegleiras);

        String nev = getArguments().getString(KEPZETSEGNEVBUNDLE);
        kepzetseg=new ViewModelProvider(this).get(KepzetsegViewModel.class);



        if (nev != null) {
        kepzetseg.KepzetsegKereses(nev);
        kepzetseg.getKepzetseglekerdezbynev().observe(getViewLifecycleOwner(), new Observer<Kepzetseg>() {
            @Override
            public void onChanged(Kepzetseg kepzetseg) {
             neve.setText("Képzetség neve : "+ kepzetseg.getNev());
             leiras.setText("Leírás : "+kepzetseg.getLeiras());

            }
        });}
        else{
            neve.setText("Üres a bundle");
        }


            return view;
        }
    }
