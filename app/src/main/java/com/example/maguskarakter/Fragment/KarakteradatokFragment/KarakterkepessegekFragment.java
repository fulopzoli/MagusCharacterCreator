package com.example.maguskarakter.Fragment.KarakteradatokFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterkepzetsegRecycleAdaper;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterspellViewModel;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

/**
 * A simple {@link Fragment} subclass.
 */
public class KarakterkepessegekFragment extends Fragment {

    private Spinner kepessegvalasztospinner;
    private MagusViewmodell magusViewmodell;
    private KarakterspellViewModel karakterspellViewModel;
    KarakterkepzetsegRecycleAdaper karakterkepzetsegRecycleAdaper;
    private int valt = 0;
    private  String nev;
    RecyclerView recyclerView;

    public KarakterkepessegekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karakterkepessegek, container, false);
        kepessegvalasztospinner = view.findViewById(R.id.karakterkepessegvalasztospinner);
        karakterkeppesegspinnerfeltolt();


        nev = getArguments().getString("Karinev");







        kepessegvalasztospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();

                switch (i) {
                    case 0:

                        Fragment Kepzetsegrecy=new KarakterKepzetsegrecyceler();
                        FragmentManager ft=getChildFragmentManager();
                        bundle.putString(ReszletekActivity.KEPZETSEGRECYCLERATADAS,nev);
                        Kepzetsegrecy .setArguments(bundle);
                        ft.beginTransaction().replace(R.id.Karakterkepessegekframe,Kepzetsegrecy).commit();

                        break;

                    case 1:

                        Fragment spellreszlet=new Karaktervarazslatrecy();
                        FragmentManager fts=getChildFragmentManager();
                        bundle.putString(ReszletekActivity.VARAZSLATRECYCLERNEVATADAS,nev);
                        spellreszlet .setArguments(bundle);
                        fts.beginTransaction().replace(R.id.Karakterkepessegekframe,spellreszlet).commit();


                        break;
                    default:

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Inflate the layout for this fragment

        return view;
    }

    private void karakterkeppesegspinnerfeltolt() {
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.Kepesseg_tipus, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinneritem);
        kepessegvalasztospinner.setAdapter(adapter);

    }


}
