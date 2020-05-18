package com.example.maguskarakter.Adapter.RecyclerViewAdapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_kepzetseg;
import com.example.maguskarakter.R;

import java.util.ArrayList;
import java.util.List;

public class KarakterkepzetsegRecycleAdaper extends RecyclerView.Adapter<KarakterkepzetsegRecycleAdaper.Viewholder> {

    private List<Karakter_kepzetseg> kepzetseg = new ArrayList<>();

    Context context;


    public KarakterkepzetsegRecycleAdaper(Context context) {
        this.context = context;
    }

    public void setKepzetseg(List<Karakter_kepzetseg> kepzetseg) {
        this.kepzetseg = kepzetseg;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View karakterkepzetsegview;
        LayoutInflater inflater = LayoutInflater.from(context);
        karakterkepzetsegview = inflater.inflate(R.layout.kepzetsegcsukhatolayout, parent, false);
        return new Viewholder(karakterkepzetsegview);


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        if (kepzetseg != null) {
            holder.KarakterKepessegnevitemnezet.setText(kepzetseg.get(position).getKepzetsegnev());
            holder.nyitocsukokep.setImageResource(R.drawable.arrowdown);
            boolean csukhato = kepzetseg.get(position).isCsukva();
            holder.csukhatoconstraint.setVisibility(csukhato ? View.VISIBLE : View.GONE);
            if (csukhato) {
                holder.szazalek.setText("Százalék : " + kepzetseg.get(position).getSzazalek());
                holder.fok.setText("Fok : " + kepzetseg.get(position).getFok());
                holder.nyitocsukokep.setImageResource(R.drawable.arrowup);
                holder.Leiras.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ReszletekActivity.class);
                        intent.putExtra(ReszletekActivity.KEPZETSEGRECYCLERATADAS, kepzetseg.get(position).getKepzetsegnev());
                        intent.putExtra(ReszletekActivity.VALTIMALTI2, 2);
                        context.startActivity(intent);

                    }
                });

            }
        } else {
            holder.KarakterKepessegnevitemnezet.setText("Üres a lista");
        }
    }


    @Override
    public int getItemCount() {
        if (kepzetseg != null) {
            return kepzetseg.size();
        } else {
            return 100
                    ;
        }
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        Spinner fokspinner;
        EditText szazalekEdit;
        Button Leiras;
        TextView KarakterKepessegnevitemnezet, fok, szazalek;
        ImageView nyitocsukokep;
        ConstraintLayout csukhatoconstraint, parent;

        public Viewholder(@NonNull final View itemView) {
            super(itemView);
            Leiras = itemView.findViewById(R.id.LeirasKepzetsegButtonID);
            parent = itemView.findViewById(R.id.parentconstraint);
            csukhatoconstraint = itemView.findViewById(R.id.expandablelayout);
            nyitocsukokep = itemView.findViewById(R.id.Nyitocsukokep);
            fok = itemView.findViewById(R.id.KepzetsegitemFokid);
            szazalek = itemView.findViewById(R.id.Szazalektextviewid);
            KarakterKepessegnevitemnezet = itemView.findViewById(R.id.Kepzetsegrecyclernevid);

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Karakter_kepzetseg karakter_kepzetseg = kepzetseg.get(getAdapterPosition());
                    karakter_kepzetseg.setCsukva(!karakter_kepzetseg.isCsukva());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}
