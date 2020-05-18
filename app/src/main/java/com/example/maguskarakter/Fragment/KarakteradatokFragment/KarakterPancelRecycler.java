package com.example.maguskarakter.Fragment.KarakteradatokFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Adapter.RecyclerViewAdapter.KarakterPancelRecyclerAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.List;


public class KarakterPancelRecycler extends Fragment {
    private MagusViewmodell magusViewmodell;
    private String nev;

    public KarakterPancelRecycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karakter_pancel_recycler, container, false);
        nev = getArguments().getString("Karipancel");
        if (nev != null) {
            RecyclerView recyclerView=view.findViewById(R.id.karakterPancellistaRecyclerid);
            final KarakterPancelRecyclerAdapter adapter=new KarakterPancelRecyclerAdapter(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
            recyclerView.setAdapter(adapter);

            magusViewmodell=new ViewModelProvider(this).get(MagusViewmodell.class);
            magusViewmodell.Karakterpancellekerdezes(nev);
            magusViewmodell.getKarakterpancelLekerdez().observe(getViewLifecycleOwner(), new Observer<List<Karakter_pancel>>() {
                @Override
                public void onChanged(List<Karakter_pancel> karakter_pancels) {
                    adapter.setKarakter_pancelList(karakter_pancels);
                    adapter.torlesgomb(new KarakterPancelRecyclerAdapter.DeleteClickListener() {
                        @Override
                        public void torol(Karakter_pancel karakter_pancel) {
                            magusViewmodell.karakterpanceltorol(karakter_pancel);
                            Fragmentfrissites();
                        }
                    });

                }
            });
        }
        // Inflate the layout for this fragment
        return view;
    }
    private void Fragmentfrissites(){
        FragmentManager fm =getFragmentManager();
        fm.beginTransaction().detach(this).attach(this).commit();
    }
}
