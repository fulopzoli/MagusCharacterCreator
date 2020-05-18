package com.example.maguskarakter.Fragment.HozzáadásFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.Karakternezet;
import com.example.maguskarakter.Activity.TargykeszitesActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Targy;
import com.example.maguskarakter.Fragment.RészletekFragment.Targyleirasreszletek;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;
import com.example.maguskarakter.ViewModell.TargyViewModel;

import java.util.List;


public class UjTargyhozzaadasFragment extends Fragment {
    private MagusViewmodell magusViewmodell;
    private TargyViewModel targyViewModel;
    private Spinner TargyvalasztoSpinnerID;
    private Button MentesTargybutton;
    private String nev,targynev;
    private int Mennyisegint;
    private EditText MennyisegTargySablonID;

    public UjTargyhozzaadasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_uj_targyhozzaadas, container, false);

        TargyvalasztoSpinnerID = view.findViewById(R.id.TargyvalasztoSpinnerID);
        MentesTargybutton = view.findViewById(R.id.MentesTargybutton);
        MennyisegTargySablonID=view.findViewById(R.id.MennyisegTargySablonID);

        targyViewModel = new ViewModelProvider(this).get(TargyViewModel.class);
        magusViewmodell = new ViewModelProvider(this).get(MagusViewmodell.class);
        nev = getArguments().getString(TargykeszitesActivity.KARAKTERNEVBUNDLE);

        targyViewModel.getTargymindenadatlekerdez().observe(getViewLifecycleOwner(), new Observer<List<Targy>>() {
            @Override
            public void onChanged(List<Targy> targies) {
                ArrayAdapter<Targy> adapter = new ArrayAdapter<Targy>(getContext(), R.layout.spinneritem, targies);
                TargyvalasztoSpinnerID.setAdapter(adapter);


            }
        });
        //   bundle.putString("TargykeszitesKarakternevBundle");
        TargyvalasztoSpinnerID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment targyleiras = new Targyleirasreszletek();
                FragmentManager fm = getFragmentManager();
                Bundle bundle = new Bundle();
                targynev=TargyvalasztoSpinnerID.getItemAtPosition(i).toString();
                bundle.putString("TargynevToREszlet", targynev);
                targyleiras.setArguments(bundle);
                fm.beginTransaction().replace(R.id.UjtargyHozzaadasReszletId, targyleiras).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        MentesTargybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MennyisegTargySablonID.getText().toString().isEmpty()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                    builder.setMessage("Adj meg mennyiséget ");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
                else {
                Mennyisegint= Integer.parseInt( MennyisegTargySablonID.getText().toString());

                Karakter_targy karitargy=new Karakter_targy(nev,targynev,Mennyisegint);
                magusViewmodell.karaktertargyhozzaadas(karitargy);

                Intent intent=new Intent(getContext(), Karakternezet.class);
                getContext().startActivity(intent);}
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void Spinnerfeltolt() {


    }
}
