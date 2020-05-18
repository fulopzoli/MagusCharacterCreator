package com.example.maguskarakter.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Adapter.RecyclerViewAdapter.FooldalRecyccleAdapter;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterViewModel;

import java.util.List;

public class Fooldal extends AppCompatActivity {


    private KarakterViewModel karakterViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.fooldalCim);

        final RecyclerView recy = findViewById(R.id.FooldalRecycleView);
        final FooldalRecyccleAdapter adapter = new FooldalRecyccleAdapter(this);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);


        karakterViewModel = new ViewModelProvider(this).get(KarakterViewModel.class);
        karakterViewModel.getMindenkarakteradat().observe(this, new Observer<List<Karakter>>() {
            @Override
            public void onChanged(List<Karakter> karakters) {
               adapter.setKarakter(karakters);

            }

        });


    }




}
