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
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_pancel;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter_targy;
import com.example.maguskarakter.R;

import java.util.ArrayList;
import java.util.List;

public class KarakterPancelRecyclerAdapter extends RecyclerView.Adapter<KarakterPancelRecyclerAdapter.Holder> {


    Context context;
    private List<Karakter_pancel> karakter_pancelList=new ArrayList<>();
    DeleteClickListener listener;

    public KarakterPancelRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setKarakter_pancelList(List<Karakter_pancel> karakter_pancelList) {
        this.karakter_pancelList = karakter_pancelList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return (position==karakter_pancelList.size())? R.layout.targyhozzaadasitem:R.layout.targylistarecycleritemitem;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(context);
        if(viewType==R.layout.targylistarecycleritemitem) {
            view=inflater.inflate(R.layout.targylistarecycleritemitem,parent,false);

        }
        else {
            view = inflater.inflate(R.layout.targyhozzaadasitem, parent, false);

        }
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        if(position==karakter_pancelList.size()){
            holder.hozzadkep.setImageResource(R.drawable.karakter_add);
            holder.Targyhozzaditem.setText("Páncél hozzáadása ");
        }
        else {
            holder.Kukakepitem.setImageResource(R.drawable.ic_delete_black_);
            holder.Targyhozzadite.setText(karakter_pancelList.get(position).getKaraterpancel());
            holder.targyitemcardi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(context, ReszletekActivity.class);
                    intent.putExtra(ReszletekActivity.VALTIPANCELLEIRAS,5);
                    intent.putExtra(ReszletekActivity.PANCELNEVRECYCLER,karakter_pancelList.get(position).getKaraterpancel());
                    context.startActivity(intent);
                }
            });
            holder.Kukakepitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder a=new AlertDialog.Builder(context);
                    a.setTitle("Törlés");
                    a.setMessage("Biztosan törölni akarod ? ");
                    a.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            listener.torol(karakter_pancelList.get(position));

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
        }
    }

    @Override
    public int getItemCount() {
        return karakter_pancelList.size()+1;
    }

    public class  Holder extends RecyclerView.ViewHolder{
        TextView Targyhozzadite,Targyhozzaditem;
        CardView targyitemcardi,Targyhozzaad;
        ImageView hozzadkep,Kukakepitem;

        public Holder(@NonNull View itemView) {
            super(itemView);
            hozzadkep=itemView.findViewById(R.id.targyhozzaaditemkep);
            Targyhozzadite=itemView.findViewById(R.id.targyhozzaditem);
            targyitemcardi=itemView.findViewById(R.id.targyitemcardid);
            Targyhozzaad=itemView.findViewById(R.id.targyhozzaadascard);
            Targyhozzaditem=itemView.findViewById(R.id.Targyhozzaditem);
            Kukakepitem=itemView.findViewById(R.id.Kukakepitem);
        }
    }
    public interface DeleteClickListener{
        void torol(Karakter_pancel karakter_pancel);
    }
    public void torlesgomb(DeleteClickListener delete){
        this.listener=delete;
    }
}
