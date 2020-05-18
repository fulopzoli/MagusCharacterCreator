package com.example.maguskarakter.Fragment.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.maguskarakter.R;

public class Mennyisegmodositodialog extends AppCompatDialogFragment {
    private tagymennyisegmodosito listener;
    private EditText MennyisegEditTargyID;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_targymodositas, null);


        MennyisegEditTargyID = view.findViewById(R.id.MennyisegEditTargyID);


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setView(view);
        builder.setTitle("Mennyiség módosítása");
        builder.setPositiveButton("Modosít", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int darabo = Integer.parseInt(MennyisegEditTargyID.getText().toString());

                    listener.darab(darabo);
            }
        });
        builder.setNegativeButton("Mégse", new DialogInterface.OnClickListener() {
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
        listener = (tagymennyisegmodosito) getTargetFragment();
    }

    public interface tagymennyisegmodosito {
        void darab(int db);
    }
}
