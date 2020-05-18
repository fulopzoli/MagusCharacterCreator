package com.example.maguskarakter.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.maguskarakter.Fragment.RészletekFragment.FegyverReszletelkFragment;
import com.example.maguskarakter.Fragment.RészletekFragment.KepzetsegReszletFragment;
import com.example.maguskarakter.Fragment.RészletekFragment.MagiareszletekFragment;
import com.example.maguskarakter.Fragment.RészletekFragment.PancelReszletFragment;
import com.example.maguskarakter.Fragment.RészletekFragment.Targyleirasreszletek;
import com.example.maguskarakter.R;

public class ReszletekActivity extends AppCompatActivity {

    public static final String VARAZSLATNEVATADAS = "com.example.maguskarakter.VARAZSLATNEV";
    public static final String VARAZSLATNEVATADASBUNDLE = "com.example.maguskarakter.VARAZSLATNEV";
    public static final String VARAZSLATRECYCLERNEVATADAS = "com.example.maguskarakter.VARAZSLATRECYCLER";
    public static final String KEPZETSEGNEVBUNDLE = "com.example.maguskarakter.KEPESSEGRECYCLERNEVBUNDLE";
    public static final String KEPZETSEGRECYCLERATADAS = "com.example.maguskarakter.KEPESSEGRECYCLERNEVATAADAS";


    public static final String FEGYVERNEVRECYCLER = "com.example.maguskarakter.FEGYVERNEVRECYCLER";
    public static final String FEGYVERNEVBUNDLE = "com.example.maguskarakter.FEGYVERBUDLE";

    public static final String PANCELBUNDLE = "com.example.maguskarakter.PANCELBUNDLE";
    public static final String PANCELNEVRECYCLER = "com.example.maguskarakter.PANCELRECYCLER";


    public static final String TARGYLEIRASBUNDLE = "com.example.maguskarakter.TARGYLEIRASBUNDLEATADAS";
    public static final String TARGYLEIRASBUNDLEID = "com.example.maguskarakter.TARGYLEIRASBUNDLEATADASID";
    public static final String TARGYLEIRASRECYCLER = "com.example.maguskarakter.TARGYLEIRASRECYCLER";


    public static final String VALTIMALTI1 = "com.example.maguskarakter.VALTI";
    public static final String VALTIMALTI2 = "com.example.maguskarakter.VALTI2";
    public static final String VALTITARGYLEIRAS = "com.example.maguskarakter.VALTI3";
    public static final String VALTIFEGYVERLEIRAS = "com.example.maguskarakter.VALTI4";
    public static final String VALTIPANCELLEIRAS = "com.example.maguskarakter.VALTI5";


    private int valt;
    private String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reszletek);
        if (getIntent().getIntExtra(VALTIMALTI1, -1) != -1) {

            valt = getIntent().getIntExtra(VALTIMALTI1, -1);
            extra = getIntent().getStringExtra(VARAZSLATNEVATADAS);

        } else if (getIntent().getIntExtra(VALTIMALTI2, -1) != -1) {
            valt = getIntent().getIntExtra(VALTIMALTI2, -1);
            extra = getIntent().getStringExtra(KEPZETSEGRECYCLERATADAS);
        } else if (getIntent().getIntExtra(VALTITARGYLEIRAS, -1) != -1) {
            valt = getIntent().getIntExtra(VALTITARGYLEIRAS, -1);
            extra = getIntent().getStringExtra(TARGYLEIRASRECYCLER);
        } else if ((getIntent().getIntExtra(VALTIFEGYVERLEIRAS, -1) != -1)) {
            valt = getIntent().getIntExtra(VALTIFEGYVERLEIRAS, -1);
            extra = getIntent().getStringExtra(FEGYVERNEVRECYCLER);
        }
        else if ((getIntent().getIntExtra(VALTIPANCELLEIRAS, -1) != -1)) {
            valt = getIntent().getIntExtra(VALTIPANCELLEIRAS, -1);
            extra = getIntent().getStringExtra(PANCELNEVRECYCLER);}
        else {
            Toast.makeText(this, "Félre ment valami ", Toast.LENGTH_SHORT).show();
        }
        Bundle bundle = new Bundle();
        FragmentManager ft = getSupportFragmentManager();



        switch (valt) {
            case 1:
                setTitle("Varázslat részletei ");
                Fragment spellreszlet = new MagiareszletekFragment();
                bundle.putString(VARAZSLATNEVATADASBUNDLE, extra);
                spellreszlet.setArguments(bundle);
                ft.beginTransaction().replace(R.id.magiareszletcontainer, spellreszlet).commit();
                break;
            case 2:
                setTitle("Képzetség részletei");
                Fragment KepzetsegReszlet = new KepzetsegReszletFragment();
                bundle.putString(KEPZETSEGNEVBUNDLE, extra);
                KepzetsegReszlet.setArguments(bundle);
                ft.beginTransaction().replace(R.id.magiareszletcontainer, KepzetsegReszlet).commit();
                break;

            case 3:
                setTitle("Tárgy leírása");
                Fragment targyleirasfragment = new Targyleirasreszletek();
                bundle.putString(TARGYLEIRASBUNDLE, extra);
                int ID=getIntent().getIntExtra(Targyleirasreszletek.KARAKTERFEGYVERLEKERDEZBYIDTOMODOSITAS,-1);
                bundle.putInt(TARGYLEIRASBUNDLEID,ID);
                targyleirasfragment.setArguments(bundle);
                ft.beginTransaction().replace(R.id.magiareszletcontainer, targyleirasfragment).commit();

                break;
            case 4:
                setTitle("Fegyver leírás");
                Fragment fegyverleiras = new FegyverReszletelkFragment();
                bundle.putString(FEGYVERNEVBUNDLE, extra);
                fegyverleiras.setArguments(bundle);
                ft.beginTransaction().replace(R.id.magiareszletcontainer, fegyverleiras).commit();
                break;
            case 5:
                setTitle("Páncél leírás");
                Fragment pancelleiras=new PancelReszletFragment();
                bundle.putString(PANCELBUNDLE,extra);
                pancelleiras.setArguments(bundle);
                ft.beginTransaction().replace(R.id.magiareszletcontainer,pancelleiras).commit();
                break;
            default:

                Toast.makeText(this, "Valami félrement", Toast.LENGTH_SHORT).show();


        }


    }
}
