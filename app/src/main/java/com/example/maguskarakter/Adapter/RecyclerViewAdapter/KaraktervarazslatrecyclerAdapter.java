package com.example.maguskarakter.Adapter.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_spell;
import com.example.maguskarakter.R;

import java.util.ArrayList;
import java.util.List;

public class KaraktervarazslatrecyclerAdapter extends RecyclerView.Adapter<KaraktervarazslatrecyclerAdapter.ViewHolderem> {

    private List<Karakter_spell> karispell=new ArrayList<>();

    public void setKarispell(List<Karakter_spell> karispell) {
        this.karispell = karispell;
        notifyDataSetChanged();
    }
    Context context;

    public KaraktervarazslatrecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View karakterkepzetsegview;
        LayoutInflater inflater = LayoutInflater.from(context);
        karakterkepzetsegview = inflater.inflate(R.layout.karakterkepessegekrecycleitem, parent, false);
        return new ViewHolderem(karakterkepzetsegview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderem holder, final int position)  {
        holder.KarakterKepessegnevitemnezet.setText(karispell.get(position).getKpellnev());
        holder.KarakterKepzetseg.setText(" ");
        holder.cardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReszletekActivity.class);
                String spellnev = karispell.get(position).getKpellnev();
                intent.putExtra(ReszletekActivity.VALTIMALTI1, 1);
                intent.putExtra(ReszletekActivity.VARAZSLATNEVATADAS, spellnev);
                context.startActivity(intent);}});

    }

    @Override
    public int getItemCount() {
        return karispell.size();
    }

    public class ViewHolderem extends RecyclerView.ViewHolder{

        CardView cardi;
        TextView KarakterKepessegnevitemnezet;
        TextView KarakterKepzetseg;

        public ViewHolderem(@NonNull View itemView) {
            super(itemView);
            cardi = itemView.findViewById(R.id.Karakterkepessegitem);
            KarakterKepzetseg = itemView.findViewById(R.id.KarakterKepzetseg);
            KarakterKepessegnevitemnezet = itemView.findViewById(R.id.KarakterKepessegnevitemnezet);
        }
    }
}
