package com.example.maguskarakter.Fragment.HozzáadásFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.Karakternezet;
import com.example.maguskarakter.Activity.TargykeszitesActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Fragment.RészletekFragment.FegyverReszletelkFragment;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.FegyverekViewModel;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.ArrayList;
import java.util.List;


public class FegyverhoaadasFragment extends Fragment {

    private Spinner Fokategoria, nev;
    private FegyverekViewModel fegyverekViewModel;
    private MagusViewmodell Magusfegyverek;
    private List<Fegyverek> fegyverek = new ArrayList<>();
    private Button buttonMentesFegyver,ButtonSajátFegyver;
    private String karakternev;
    private String fegyvernev;

    public FegyverhoaadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fegyverhoaadas, container, false);
        Fokategoria = view.findViewById(R.id.spinnerfegyverhozzadas_fokategoriaid);
        nev = view.findViewById(R.id.spinnerFegyverhozzadasNevID);
        buttonMentesFegyver = view.findViewById(R.id.buttonMentesFegyver);
        ButtonSajátFegyver=view.findViewById(R.id.ButtonSajátFegyver);

        karakternev=getArguments().getString(TargykeszitesActivity.KARAKTERNEVBUNDLE);

        fokategoriaspinner();
        Magusfegyverek=new ViewModelProvider(this).get(MagusViewmodell.class);
        fegyverekViewModel = new ViewModelProvider(this).get(FegyverekViewModel.class);

        final Bundle bundle = new Bundle();
        Fokategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {

                    String kategoria = Fokategoria.getItemAtPosition(i).toString();
                    fegyverekViewModel.SetfegyvernevlekerdezesBycategory(kategoria);
                    fegyverekViewModel.getFegyvernev().observe(getViewLifecycleOwner(), new Observer<List<Fegyverek>>() {
                        @Override
                        public void onChanged(List<Fegyverek> fegyvereks) {
                            fegyverek = fegyvereks;
                            nevspinnerfeltolt();

                        }
                    });

                } catch (Exception e) {

                    Toast.makeText(getContext(), "Válasz ki valamit ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getContext(), "Válasz ki valamit ", Toast.LENGTH_SHORT).show();
            }
        });
        nev.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle B = new Bundle();

                FragmentManager fm = getFragmentManager();

                Fragment fegyverLeiras = new FegyverReszletelkFragment();
                fegyvernev = nev.getItemAtPosition(i).toString();

                B.putString(TargykeszitesActivity.FEGYVERNEVKESZITESBUNDLE, fegyvernev);
                fegyverLeiras.setArguments(B);

                fm.beginTransaction().replace(R.id.FegyverReszletekinkeszitesID, fegyverLeiras).commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonMentesFegyver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Karakter_fegyver karakter_fegyver=new Karakter_fegyver(karakternev,fegyvernev);
                Magusfegyverek.karakterfegyverhozzads(karakter_fegyver);
                Intent intent=new Intent(getContext(),Karakternezet.class);
                getContext().startActivity(intent);
            }
        });

        ButtonSajátFegyver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment sajatfegyverkeszites=new FegyverSajatHozzaadasFragment();
                FragmentManager fm=getFragmentManager();
                Bundle bunddle=new Bundle();
                bunddle.putString("Sajatfegyverkarakternev",karakternev);
                sajatfegyverkeszites.setArguments(bunddle);
                fm.beginTransaction().replace(R.id.TargykeszitesFrameLayout,sajatfegyverkeszites).commit();
            }
        });
        return view;
    }

    public void fokategoriaspinner() {
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.Fegyver_tipusok, R.layout.spinneritem);
        Fokategoria.setAdapter(adapter);
    }

    public void nevspinnerfeltolt() {
        ArrayAdapter<Fegyverek> adapter = new ArrayAdapter<Fegyverek>(getContext(), R.layout.spinneritem, fegyverek);
        adapter.notifyDataSetChanged();
        nev.setAdapter(adapter);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this);
    }

}
