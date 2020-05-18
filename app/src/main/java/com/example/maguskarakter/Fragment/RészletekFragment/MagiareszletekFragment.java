package com.example.maguskarakter.Fragment.RészletekFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Varazslatok;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.Spellviewmodel;

public class MagiareszletekFragment extends Fragment {
    public MagiareszletekFragment() {
    }

    TextView magianev, manapont, erosseg, sebzes, varazslasideje, hatotav, idotartam, magiaellenallas, mozaikok, magialeiras,szfera;
    private Spellviewmodel spellviewmodel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magiareszletfragment, container, false);
        Bundle b = this.getArguments();
        magialeiras = view.findViewById(R.id.magialeiras);
        magianev = view.findViewById(R.id.magiareszletnev);
        manapont = view.findViewById(R.id.MagiareszletManapont);
        erosseg = view.findViewById(R.id.Magiareszleterosseg);
        sebzes = view.findViewById(R.id.Magiareszletsebzes);
        varazslasideje = view.findViewById(R.id.Varazslasidejeid);
        hatotav = view.findViewById(R.id.Magiareszlethatotav);
        szfera=view.findViewById(R.id.MagiaReszletSzvera);
        idotartam=view.findViewById(R.id.Magiareszletidotartam);
        magiaellenallas=view.findViewById(R.id.Magiareszletellenallas);
        mozaikok=view.findViewById(R.id.MagiareszletFelhasznaltmozaikok);
        if (b != null) {


            String spellnev = getArguments().getString(ReszletekActivity.VARAZSLATNEVATADASBUNDLE);
            spellviewmodel = new ViewModelProvider(this).get(Spellviewmodel.class);

            spellviewmodel.varaslatreszleteklekerdezes(spellnev);
            spellviewmodel.getVarazslatreszletlekerdezes().observe(getViewLifecycleOwner(), new Observer<Varazslatok>() {
                @Override
                public void onChanged(Varazslatok varazslatok) {
                    magianev.setText("Varázslat neve :  " + varazslatok.getMagianev());
                    magialeiras.setText(" "+varazslatok.getLeiras());
                    manapont.setText("Mana-pont : " +varazslatok.getManapont());
                    erosseg.setText("Erősség : "+varazslatok.getErosseg());
                    sebzes.setText("Sebzés : "+varazslatok.getSebzes());
                    varazslasideje.setText("Varazslás ideje : "+varazslatok.getVarazslasidelye());
                    hatotav.setText("Hatótáv : "+varazslatok.getHatotav());
                    idotartam.setText("Időtartam : "+varazslatok.getIdotartam());
                    magiaellenallas.setText("Mágiaellenállás : "+varazslatok.getMagiaellenallas());
                    mozaikok.setText("Felhasznált mozaikok : "+varazslatok.getFelhasznalt_mozaik());
                    szfera.setText("Szféra : "+varazslatok.getSzfera());

                }
            });
        } else {
            magianev.setText("Null érteken a bundle");

        }

        return view;
    }
}
