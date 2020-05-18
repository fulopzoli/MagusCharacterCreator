package com.example.maguskarakter.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maguskarakter.R;

public class Karakterkeszito extends AppCompatActivity {
    TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakterkeszito);
        a = findViewById(R.id.asdf);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        String s="EÖE"+bundle.getString("KK"," ");
        a.setText(s);



    }
}
