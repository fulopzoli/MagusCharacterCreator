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
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_fegyver;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.MagusViewmodell;

import java.util.ArrayList;
import java.util.List;

public class KarakterFegyverRecyclerAdapter extends RecyclerView.Adapter<KarakterFegyverRecyclerAdapter.MyViewHolder> {

    List<Karakter_fegyver> karifegyver = new ArrayList<>();
    private String Karakternev = " ";
    private MagusViewmodell magusViewmodell;
    private deleteclicklistener delete;


    Context context;

    public void setKarakternev(String karakternev) {
        Karakternev = karakternev;
        notifyDataSetChanged();
    }

    public Karakter_fegyver getKarifegyverAt(int position) {
        return karifegyver.get(position);
    }

    public List<Karakter_fegyver> getKarifegyver() {
        return karifegyver;
    }

    public void setKarifegyver(List<Karakter_fegyver> karifegyver) {
        this.karifegyver = karifegyver;
        notifyDataSetChanged();
    }

    public KarakterFegyverRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == karifegyver.size()) ? R.layout.targyhozzaadasitem : R.layout.targylistarecycleritemitem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == R.layout.targylistarecycleritemitem) {
            view = inflater.inflate(R.layout.targylistarecycleritemitem, parent, false);

        } else {
            view = inflater.inflate(R.layout.targyhozzaadasitem, parent, false);

        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if (position == karifegyver.size()) {
            holder.hozzadkep.setImageResource(R.drawable.karakter_add);
            holder.Targyhozzaditem.setText("Új Fegyver");
            holder.Targyhozzaad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int valaszto = 1;
                    Intent intent = new Intent(context, TargykeszitesActivity.class);
                    intent.putExtra(TargykeszitesActivity.FEGYVERKESZITES, valaszto);
                    intent.putExtra(TargykeszitesActivity.KARAKTERNEVRECYCLERFEGYVER, Karakternev);

                    context.startActivity(intent);
                }
            });

        } else {
            holder.Targyhozzadite.setText(karifegyver.get(position).getKarakterfegyvernev());
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
                            delete.torlesgom(karifegyver.get(position));

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
            holder.targyitemcardi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int Switch = 4;
                    Intent intent = new Intent(context, ReszletekActivity.class);
                    intent.putExtra(ReszletekActivity.VALTIFEGYVERLEIRAS, Switch);
                    intent.putExtra(ReszletekActivity.FEGYVERNEVRECYCLER, karifegyver.get(position).getKarakterfegyvernev());

                    context.startActivity(intent);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return karifegyver.size() + 1;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Targyhozzadite, Targyhozzaditem;
        CardView targyitemcardi, Targyhozzaad;
        ImageView hozzadkep, Kukakepitem;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hozzadkep = itemView.findViewById(R.id.targyhozzaaditemkep);
            Targyhozzadite = itemView.findViewById(R.id.targyhozzaditem);
            targyitemcardi = itemView.findViewById(R.id.targyitemcardid);
            Targyhozzaad = itemView.findViewById(R.id.targyhozzaadascard);
            Targyhozzaditem = itemView.findViewById(R.id.Targyhozzaditem);
            Kukakepitem = itemView.findViewById(R.id.Kukakepitem);

        }
    }

    public interface deleteclicklistener {
        void torlesgom(Karakter_fegyver karakter_fegyver);
    }

    public void torlesgomrakattint(deleteclicklistener delete) {
        this.delete = delete;
    }
}
