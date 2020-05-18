package com.example.maguskarakter.Fragment.KarakteradatokFragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterfelszerelesRecyclerAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.List;

public class EgyebfelszerelesitemFragment extends Fragment {


    public EgyebfelszerelesitemFragment() {
        // Required empty public constructor
    }

    MagusViewmodell magusViewmodell;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_egyebfelszerelesitem, container, false);

        String nev=getArguments().getString("Karimarinev");

        final RecyclerView recyclerView = view.findViewById(R.id.KarakterfelszerelesRecycleView);
        final KarakterfelszerelesRecyclerAdapter adaper = new KarakterfelszerelesRecyclerAdapter(container.getContext(),nev);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(adaper);

        //KariRez"
        magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
        magusViewmodell.Karaktertargylekerdezes(nev);
        magusViewmodell.getKaraktertargylekerdezeredmeny().observe(getViewLifecycleOwner(), new Observer<List<Karakter_targy>>() {
            @Override
            public void onChanged(List<Karakter_targy> karakter_targies) {

                    adaper.setTargylista(karakter_targies);
                    adaper.torlesgomb(new KarakterfelszerelesRecyclerAdapter.DeleteClickListener() {
                        @Override
                        public void torol(Karakter_targy karakter_targy) {
                            magusViewmodell.karaktertargytorol(karakter_targy);
                            fragmentfrissites();
                        }
                    });

            }

        });



        // Inflate the layout for this fragment
        return  view;
    }
    private void fragmentfrissites(){
        FragmentManager ft=getFragmentManager();
        ft.beginTransaction().detach(this).attach(this).commit();

    }
}
