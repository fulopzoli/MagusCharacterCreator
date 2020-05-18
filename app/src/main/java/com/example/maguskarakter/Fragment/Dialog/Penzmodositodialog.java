package com.example.maguskarakter.Fragment.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.maguskarakter.R;

public class Penzmodositodialog extends AppCompatDialogFragment {

    EditText Aranyedit, EzustEdit, RezEdit;
    TextView Aranytext, Ezusttext, Reztext;
    int arany, rez, ezust;

    public void setArany(int arany) {
        this.arany = arany;
    }

    public void setRez(int rez) {
        this.rez = rez;
    }

    public void setEzust(int ezust) {
        this.ezust = ezust;
    }

    public interface penzmodositodialoginterface {
        void penzertekek(int arany, int ezust, int rez);
    }

    private penzmodositodialoginterface penzmodosito;
    int aranya, ezusta, reza;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.penzmodositdialog, null);
        Aranyedit = view.findViewById(R.id.aranydialogedittext);
        EzustEdit = view.findViewById(R.id.ezustdialogedittext);
        RezEdit = view.findViewById(R.id.rezdialogedittext);


        Aranytext = view.findViewById(R.id.Aranydialogtext);
        Ezusttext = view.findViewById(R.id.EzustDialogtext);
        Reztext = view.findViewById(R.id.Rezdialogtext);
        Aranytext.setText("Arany : " + String.valueOf(arany));
        Ezusttext.setText("Ezust : " + ezust);
        Reztext.setText("Réz : " + rez);


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setPositiveButton("Mentés", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (TextUtils.isEmpty(Aranyedit.getText().toString())) {
                    aranya = arany;
                } else {
                    aranya = Integer.parseInt(Aranyedit.getText().toString());
                }
                if (TextUtils.isEmpty(EzustEdit.getText().toString())) {
                    ezusta = ezust;
                } else {
                    ezusta = Integer.parseInt(EzustEdit.getText().toString());
                }
                if (TextUtils.isEmpty(RezEdit.getText().toString())) {
                    reza = rez;
                } else {
                    reza = Integer.parseInt((RezEdit.getText().toString()));
                }

                penzmodosito.penzertekek(aranya, ezusta, reza);

            }
        }).setNegativeButton("Mégse", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        penzmodosito = (penzmodositodialoginterface) getTargetFragment();
    }
}
