package com.example.maguskarakter.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.maguskarakter.Adapter.PagerAdapter.KarakterpagerAdapter;
import com.example.maguskarakter.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Karakternezet extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem Adatok, Kepessegek, Felszereles;
    private KarakterpagerAdapter karakterpagerAdapter;
    private TextView nezegeto;

    public static final String IDATADAS = "com.example.maguskarakter.EXTRA_ID";
    public static final String NEVATADAS = "com.example.maguskarakter.EXTRA_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakternezet);
        tabLayout = findViewById(R.id.karakteradattablayout);
        viewPager = findViewById(R.id.karakterviewpager);
        Adatok = findViewById(R.id.KarakteradatokTab);
        Kepessegek = findViewById(R.id.Karakterkepessegektab);
        Felszereles = findViewById(R.id.KarakterFelszerelestab);
        Bundle bundle = getIntent().getExtras();


        String name = bundle.getString(NEVATADAS);
        setTitle(name);

        karakterpagerAdapter = new KarakterpagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        karakterpagerAdapter.setId(bundle.getInt(IDATADAS));
        karakterpagerAdapter.setNev(name);

        viewPager.setAdapter(karakterpagerAdapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    karakterpagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
                    karakterpagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 2) {
                    karakterpagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }


}

