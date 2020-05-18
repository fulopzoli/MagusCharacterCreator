package com.example.maguskarakter.Adapter.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.Karakterkeszito;
import com.example.maguskarakter.Activity.Karakternezet;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.R;
import com.example.maguskarakter.Raktar.Raktar;
import com.example.maguskarakter.ViewModell.KarakterViewModel;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.nio.BufferUnderflowException;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

public class FooldalRecyccleAdapter extends RecyclerView.Adapter<FooldalRecyccleAdapter.viewholder> {

    private KarakterViewModel karakterViewModel;
    private MagusViewmodell magusViewmodell;
    List<Karakter> karakter = new ArrayList<>();
    Context context;



    // private onitemclickliste listener;


    public FooldalRecyccleAdapter(Context context) {
        this.context = context;
    }

    public Karakter karakterat(int pozicio) {
        return karakter.get(pozicio);
    }

    public void setKarakter(List<Karakter> karakter) {
        this.karakter = karakter;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return (position == karakter.size()) ? R.layout.fooladkarakterhozzaad : R.layout.fooldal_recycle_item;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View fooldalKarakterView;


        if (viewType == R.layout.fooldal_recycle_item) {
            LayoutInflater inf = LayoutInflater.from(context);
            fooldalKarakterView = inf.inflate(R.layout.fooldal_recycle_item, parent, false);


        } else {
            LayoutInflater inf = LayoutInflater.from(context);
            fooldalKarakterView = inf.inflate(R.layout.fooladkarakterhozzaad, parent, false);
        }

        return new viewholder(fooldalKarakterView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

        if (position == karakter.size()) {
            holder.hozzadkep.setImageResource(R.drawable.karakter_add);
            holder.Karakterhozzad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        } else {


            holder.karakternev.setText(karakter.get(position).getNev());
            holder.karakterfaj.setText("Faj : " + karakter.get(position).getFaj());
            holder.karakterKor.setText("Életkor : " + karakter.get(position).getKor() + " év");
            holder.karakterkaszt.setText("Kaszt : " + karakter.get(position).getKaszt());
            holder.karakterszint.setText("Szint : " + String.valueOf(karakter.get(position).getSzint() + ". "));
            holder.karakterkep.setImageResource(karakter.get(position).getKarakterkep());

            holder.CardvieW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Karakternezet.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt(Karakternezet.IDATADAS,karakter.get(position).getId());
                    bundle.putString(Karakternezet.NEVATADAS,karakter.get(position).getNev());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return karakter.size()+1;
    }
    class viewholder extends RecyclerView.ViewHolder {

        ImageView hozzadkep,karakterkep;
        TextView karakternev;
        TextView karakterfaj;
        TextView karakterKor;
        TextView karakterkaszt;
        TextView karakterszint;
        CardView CardvieW;
        CardView Karakterhozzad;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            karakterkep=itemView.findViewById(R.id.Fooldalkarakterkep);
            Karakterhozzad = itemView.findViewById(R.id.Fooldalkarakterhozzad);
            CardvieW = itemView.findViewById(R.id.FooldalRecycleViewItem);
            hozzadkep = itemView.findViewById(R.id.hozzaadkep);
            karakternev = itemView.findViewById(R.id.recyckeKarakternevItem);
            karakterfaj = itemView.findViewById(R.id.recycleKarakerFajIttem);
            karakterKor = itemView.findViewById(R.id.recycleKarakterKorItem);
            karakterkaszt = itemView.findViewById(R.id.recycleKarakterKasztItem);
            karakterszint = itemView.findViewById(R.id.recycleKarakterSzintitem);


        }


    }



}
