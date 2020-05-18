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
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Pancel;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.PancelviewModel;


public class PancelReszletFragment extends Fragment {

    private PancelviewModel pancelviewModel;
    private TextView PancelreszletPancelnevID,PancelreszletAnyaga,PancelreszletAra,PancelreszletMGT,PancelreszletSFE,
            PancelreszletSuly,PancelreszletLeiras;
    private String pancelnev;

    public PancelReszletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pancel_reszlet, container, false);

        PancelreszletPancelnevID=view.findViewById(R.id.PancelreszletPancelnevID);
        PancelreszletAnyaga=view.findViewById(R.id.PancelreszletAnyaga);
        PancelreszletAra=view.findViewById(R.id.PancelreszletAra);
        PancelreszletMGT=view.findViewById(R.id.PancelreszletMGT);
        PancelreszletSFE=view.findViewById(R.id.PancelreszletSFE);
        PancelreszletSuly=view.findViewById(R.id.PancelreszletSuly);
        PancelreszletLeiras=view.findViewById(R.id.PancelreszletLeiras);



        pancelnev = getArguments().getString(ReszletekActivity.PANCELBUNDLE);

        if (pancelnev != null) {
            pancelviewModel = new ViewModelProvider(this).get(PancelviewModel.class);
            pancelviewModel.setPancelreszletrekerdez("a");
            pancelviewModel.getPancelreszletrekerdez().observe(getViewLifecycleOwner(), new Observer<Pancel>() {
                @Override
                public void onChanged(Pancel pancel) {
                    PancelreszletPancelnevID.setText("Név : "+pancel.getNev());
                    PancelreszletAnyaga.setText("Anyaga : "+pancel.getAnyaga());
                    PancelreszletAra.setText("Ára : "+pancel.getAr());
                    PancelreszletMGT.setText("Mgt : "+pancel.getMgt());
                    PancelreszletSFE.setText("Sfe : "+pancel.getSfE());
                    PancelreszletSuly.setText("Súly : "+pancel.getSuly());
                    PancelreszletLeiras.setText("Leírás : "+pancel.getLeiras());






                }
            });
        }
        // Inflate the layout for this fragment
        return view;
    }
}
