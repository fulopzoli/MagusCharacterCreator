package com.example.maguskarakter.Fragment.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.maguskarakter.Activity.Karakternezet;
import com.example.maguskarakter.Adatbazis.Model.Modellek.Modellek.Karakter;
import com.example.maguskarakter.R;
import com.example.maguskarakter.ViewModell.KarakterViewModel;

public class  Harcertekdialogfragment extends AppCompatDialogFragment {

    private KarakterViewModel karakterViewModel;
    private int id, maxmana,aktmana,maxpszialapszi,aktpszi, maxep,aktep, maxfp,aktfp;
   NumberPicker ep,fp,mana,pszi;

   private harcertekdialoglistener listener;
    public KarakterViewModel getKarakterViewModel() {
        return karakterViewModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaxmana(int maxmana) {
        this.maxmana = maxmana;
    }

    public void setMaxpszialapszi(int maxpszialapszi) {
        this.maxpszialapszi = maxpszialapszi;
    }

    public void setMaxep(int maxep) {
        this.maxep = maxep;
    }

    public void setMaxfp(int maxfp) {
        this.maxfp = maxfp;
    }

    public void setAktmana(int aktmana) {
        this.aktmana = aktmana;
    }

    public void setAktpszi(int aktpszi) {
        this.aktpszi = aktpszi;
    }

    public void setAktep(int aktep) {
        this.aktep = aktep;
    }

    public void setAktfp(int aktfp) {
        this.aktfp = aktfp;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.dialogepmodosit,null);
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        ep=view.findViewById(R.id.epnumberpickerdialog);
        fp=view.findViewById(R.id.fpnumberpickerdialog);
        mana=view.findViewById(R.id.mananumberpickerdialog);
        pszi=view.findViewById(R.id.pszinumberpickerdialog);

        ep.setMaxValue(maxep);
        fp.setMaxValue(maxfp);
        mana.setMaxValue(maxmana);
        pszi.setMaxValue(maxpszialapszi);

        ep.setValue(aktep);
        fp.setValue(aktfp);
        mana.setValue(aktmana);
        pszi.setValue(aktpszi);


        builder.setView(view)
                .setPositiveButton("Mentés", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),"mentesgomb lenyomva",Toast.LENGTH_LONG);

                        int eps=0+ep.getValue();
                        int fps=0+fp.getValue();
                        int manas=0+mana.getValue();
                        int pszis=0+pszi.getValue();



                      listener.ertekek(eps,fps,manas,pszis);

                    }
                }).
                setNegativeButton("Mégse", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),"megsegomb lenyomva",Toast.LENGTH_LONG);
                        dismiss();

                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

            listener=(harcertekdialoglistener)getTargetFragment() ;

    }

    public interface harcertekdialoglistener{
        void ertekek (int aktep,int aktfp,int aktmana,int aktpszi);
    }
}
