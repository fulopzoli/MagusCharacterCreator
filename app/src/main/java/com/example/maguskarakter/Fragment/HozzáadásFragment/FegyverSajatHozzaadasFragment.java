package com.example.maguskarakter.Fragment.HozzáadásFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.Karakternezet;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Fegyverek;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.FegyverekViewModel;
import com.example.maguskarakter.ViewModell.MagusViewmodell;


public class FegyverSajatHozzaadasFragment extends Fragment {


    private EditText editTextSajatfegyvernev, editTextSajatfegyfverSebzés, editTextSajatfegyfverSe, editTextSajatfegyfverVe, editTextSajatfegyfverKe, editTextSajatfegyfverSuly, editTextSajatfegyfverAr,
            editTextSajatfegyfverLeiras;
    private Button Sajatfegyvermentesbutton;
    private Spinner spinnerSajatfegyver;
    private MagusViewmodell magusViewmodell;
    private FegyverekViewModel fegyverekViewModel;

    private String karakternev, fegyverkategoria;

    public FegyverSajatHozzaadasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fegyver_sajat_hozzaadas, container, false);
        if (getArguments().getString("Sajatfegyverkarakternev") != null) {
            karakternev = getArguments().getString("Sajatfegyverkarakternev");

        } else {
            Toast.makeText(getContext(), "Hibás az oldal ", Toast.LENGTH_SHORT).show();
        }

        editTextSajatfegyvernev = view.findViewById(R.id.editTextSajatfegyvernev);
        editTextSajatfegyfverSebzés = view.findViewById(R.id.editTextSajatfegyfverSebzés);
        editTextSajatfegyfverSe = view.findViewById(R.id.editTextSajatfegyfverSe);
        editTextSajatfegyfverVe = view.findViewById(R.id.editTextSajatfegyfverVe);
        editTextSajatfegyfverKe = view.findViewById(R.id.editTextSajatfegyfverKe);
        editTextSajatfegyfverSuly = view.findViewById(R.id.editTextSajatfegyfverSuly);
        editTextSajatfegyfverAr = view.findViewById(R.id.editTextSajatfegyfverAr);
        editTextSajatfegyfverLeiras = view.findViewById(R.id.editTextSajatfegyfverLeiras);
        Sajatfegyvermentesbutton = view.findViewById(R.id.Sajatfegyvermentesbutton);
        spinnerSajatfegyver = view.findViewById(R.id.spinnerSajatfegyver);

        spinnerfeltolt();

        magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
        fegyverekViewModel = new ViewModelProvider(this).get(FegyverekViewModel.class);

        spinnerSajatfegyver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fegyverkategoria = spinnerSajatfegyver.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        Sajatfegyvermentesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String fegyvernev = editTextSajatfegyvernev.getText().toString();
                final String Sebzes = editTextSajatfegyfverSebzés.getText().toString();
                final int se = Integer.parseInt(editTextSajatfegyfverSe.getText().toString());
                final int ve=Integer.parseInt(editTextSajatfegyfverVe.getText().toString());
                final  int ke=Integer.parseInt(editTextSajatfegyfverKe.getText().toString());
                final String suly=editTextSajatfegyfverSuly.getText().toString();
                final String Ar=editTextSajatfegyfverAr.getText().toString();
                final String Leiras=editTextSajatfegyfverLeiras.getText().toString();

                Karakter_fegyver karakter_fegyver = new Karakter_fegyver(karakternev, fegyvernev);
                Fegyverek fegyverek = new Fegyverek(fegyvernev, Sebzes, fegyverkategoria, se,ve,ke,suly,Ar,Leiras );
                magusViewmodell.karakterfegyverhozzads(karakter_fegyver);
                fegyverekViewModel.fegyverhozzad(fegyverek);
                Intent intent=new Intent(getContext(), Karakternezet.class);
                getContext().startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void spinnerfeltolt() {
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.Fegyver_tipusok, R.layout.spinneritem);
        adapter.setDropDownViewResource(R.layout.spinneritem);
        spinnerSajatfegyver.setAdapter(adapter);
    }
}
