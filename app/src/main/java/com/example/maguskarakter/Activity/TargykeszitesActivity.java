package com.example.maguskarakter.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.maguskarakter.Fragment.HozzáadásFragment.FegyverhoaadasFragment;
import com.example.maguskarakter.Fragment.HozzáadásFragment.UjTargyhozzaadasFragment;
import com.example.maguskarakter.R;

public class TargykeszitesActivity extends AppCompatActivity {

    public static final String FEGYVERKESZITES = "com.example.maguskarakter.FEGYVERKESZITES";
    public static final String TARGYKESZITES = "com.example.maguskarakter.TARGYKESZITES";

    public static final String KARAKTERNEVBUNDLE = "com.example.maguskarakter.KARAKTERNEVBUNDLE";
    public static final String KARAKTERNEVRECYCLERFEGYVER = "com.example.maguskarakter.KARAKTERNEVRECYCLERFEGYVER";


    public static final String KARAKTERNEVRECYCLERFTARGY = "com.example.maguskarakter.KARAKTERNEVRECYCLERTARGY";


    public static final String FEGYVERNEVKESZITESBUNDLE = "com.example.maguskarakter.FEGYVERNEVKESZITESBUNDLE";

    private int feuletvalaszto;
    private String karakternev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targykeszites);
        Intent intent = getIntent();
        if (intent.getStringExtra(KARAKTERNEVRECYCLERFEGYVER) != null) {
            karakternev = intent.getStringExtra(KARAKTERNEVRECYCLERFEGYVER);
        }
        else if(intent.getStringExtra(KARAKTERNEVRECYCLERFTARGY)!=null){
            karakternev=intent.getStringExtra(KARAKTERNEVRECYCLERFTARGY);
        }
        else {
            karakternev = "Nem jött át név";
        }


        if (getIntent().getIntExtra(FEGYVERKESZITES, -1) != -1) {
            feuletvalaszto = getIntent().getIntExtra(FEGYVERKESZITES, -1);
        }
        else if(getIntent().getIntExtra(TARGYKESZITES,-1)!=-1){
            feuletvalaszto=getIntent().getIntExtra(TARGYKESZITES,-1);
        }

        Bundle bundle = new Bundle();
        FragmentManager ft = getSupportFragmentManager();

        switch (feuletvalaszto) {
            case 1:
                setTitle("Fegyver hozzáadása ");
                Fragment fegyverhozzaad = new FegyverhoaadasFragment();
                bundle.putString(KARAKTERNEVBUNDLE, karakternev);
                fegyverhozzaad.setArguments(bundle);
                ft.beginTransaction().replace(R.id.TargykeszitesFrameLayout, fegyverhozzaad).commit();

                break;
            case 2:
                setTitle("Tárgy hozzáadás ");
                Fragment targyhozzaadasfrag = new UjTargyhozzaadasFragment();
                bundle.putString(KARAKTERNEVBUNDLE, karakternev);
                targyhozzaadasfrag.setArguments(bundle);
                ft.beginTransaction().replace(R.id.TargykeszitesFrameLayout, targyhozzaadasfrag).commit();
                break;
            default:
                Toast.makeText(this, "Valami nem jó", Toast.LENGTH_SHORT).show();
        }
    }
}
