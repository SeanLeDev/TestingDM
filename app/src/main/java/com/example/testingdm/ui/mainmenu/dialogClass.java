package com.example.testingdm.ui.mainmenu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.testingdm.R;

public class dialogClass extends AppCompatDialogFragment {
    private EditText editTextDelete;
    private deleteDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View rootview = inflater.inflate(R.layout.layout_deletedialog,null);

        builder.setView(rootview);
        builder.setTitle("Delete");
        builder.setNegativeButton("I refuse!", new DialogInterface.OnClickListener() { //sets up button title
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("BEGONE!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String characterDeleteName = editTextDelete.getText().toString();
                listener.applyTexts(characterDeleteName);
            }
        });
        editTextDelete = rootview.findViewById(R.id.editTextDelete);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (deleteDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+ "must implement delete");
        }
    }

    public interface deleteDialogListener{
        void applyTexts(String characterDeleteName);
    }
}
