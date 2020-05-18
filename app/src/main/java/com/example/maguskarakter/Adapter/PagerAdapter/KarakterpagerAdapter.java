package com.example.maguskarakter.Adapter.PagerAdapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.maguskarakter.Fragment.KarakteradatokFragment.KarakteradatokFragment;
import com.example.maguskarakter.Fragment.KarakteradatokFragment.KarakterfelszerelesFragment;
import com.example.maguskarakter.Fragment.KarakteradatokFragment.KarakterkepessegekFragment;


public class KarakterpagerAdapter extends FragmentPagerAdapter {

    private int tabokszama;

    public KarakterpagerAdapter(@NonNull FragmentManager fm, int tabokszama) {
        super(fm);
        this.tabokszama = tabokszama;
    }

    private int id;
    private String nev;

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("KariID", id);
        bundle.putString("Karinev", nev);


        switch (position) {
            case 0:
                KarakteradatokFragment A = new KarakteradatokFragment();
                A.setArguments(bundle);
                return A;
            case 1:
                KarakterkepessegekFragment C = new KarakterkepessegekFragment();
                C.setArguments(bundle);
                return C;
            case 2:
                KarakterfelszerelesFragment B = new KarakterfelszerelesFragment();
                B.setArguments(bundle);
                return B;

            default:
                return null;
        }

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return tabokszama;
    }
}
