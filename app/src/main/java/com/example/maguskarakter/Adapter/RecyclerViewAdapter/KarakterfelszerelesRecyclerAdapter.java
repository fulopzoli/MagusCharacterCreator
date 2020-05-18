package com.example.maguskarakter.Adapter.RecyclerViewAdapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maguskarakter.Activity.ReszletekActivity;
import com.example.maguskarakter.Activity.TargykeszitesActivity;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.Fragment.RészletekFragment.Targyleirasreszletek;
import com.example.maguskarakter.R;

import java.util.ArrayList;
import java.util.List;

public class KarakterfelszerelesRecyclerAdapter extends RecyclerView.Adapter<KarakterfelszerelesRecyclerAdapter.holder> {
    List<Karakter_targy> targylista = new ArrayList<>();
    private String karakternev=" ";
    Context context;
    DeleteClickListener listener;



    public KarakterfelszerelesRecyclerAdapter(Context context,String karakternev) {
        this.context = context;
        this.karakternev=karakternev;
    }

    public void setTargylista(List<Karakter_targy> targylista) {
        this.targylista = targylista;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == targylista.size()) ? R.layout.targyhozzaadasitem : R.layout.targylistarecycleritemitem;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View karaktertargyview;
        LayoutInflater inf = LayoutInflater.from(context);


        if (viewType == R.layout.targylistarecycleritemitem) {
            karaktertargyview = inf.inflate(R.layout.targylistarecycleritemitem, parent, false);
        } else {
            karaktertargyview = inf.inflate(R.layout.targyhozzaadasitem, parent, false);
        }
        return new holder(karaktertargyview);
    }


    @Override
    public void onBindViewHolder(@NonNull holder holder, final int position) {
        if (position == targylista.size()) {
            holder.hozzadkep.setImageResource(R.drawable.karakter_add);
            holder.Targyhozzaditem.setText("Tárgy hozzáadása  ");
            holder.Targyhozzaad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, TargykeszitesActivity.class);
                    intent.putExtra(TargykeszitesActivity.KARAKTERNEVRECYCLERFTARGY,karakternev);
                    intent.putExtra(TargykeszitesActivity.TARGYKESZITES,2);
                    context.startActivity(intent);


                }
            });
        } else {

            holder.Targyreszlet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ReszletekActivity.class);
                    intent.putExtra(ReszletekActivity.VALTITARGYLEIRAS, 3);
                    intent.putExtra(Targyleirasreszletek.KARAKTERFEGYVERLEKERDEZBYIDTOMODOSITAS,targylista.get(position).getId());
                    intent.putExtra(ReszletekActivity.TARGYLEIRASRECYCLER, targylista.get(position).getTargy());
                    context.startActivity(intent);
                }
            });

            holder.Kukakepitem.setImageResource(R.drawable.ic_delete_black_);
            holder.Kukakepitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder a=new AlertDialog.Builder(context);
                    a.setTitle("Törlés");
                    a.setMessage("Biztosan törölni akarod ? ");
                    a.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                         listener.torol(targylista.get(position));

                        }
                    });
                    a.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    a.show();
                }
            });
            holder.TargyMennyisegItemID.setText(String.valueOf( targylista.get(position).getMennyiseg())+" db");
            holder.targynev.setText(targylista.get(position).getTargy());

        }

    }

    @Override
    public int getItemCount() {
        return targylista.size() + 1;
    }

    class holder extends RecyclerView.ViewHolder {

        TextView targynev, Targyhozzaditem,TargyMennyisegItemID;
        ImageView hozzadkep,Kukakepitem;
        CardView Targyhozzaad, Targyreszlet;

        public holder(@NonNull View itemView) {
            super(itemView);
            targynev = itemView.findViewById(R.id.targyhozzaditem);
            Targyreszlet=itemView.findViewById(R.id.targyitemcardid);
            hozzadkep = itemView.findViewById(R.id.targyhozzaaditemkep);
            Targyhozzaad = itemView.findViewById(R.id.targyhozzaadascard);
            Targyhozzaditem = itemView.findViewById(R.id.Targyhozzaditem);
            Kukakepitem=itemView.findViewById(R.id.Kukakepitem);
            TargyMennyisegItemID=itemView.findViewById(R.id.TargyMennyisegItemID);

        }
    }
    public interface DeleteClickListener{
        void torol(Karakter_targy karakter_targy);
    }
    public void torlesgomb(DeleteClickListener delete){
        this.listener=delete;
    }

}
