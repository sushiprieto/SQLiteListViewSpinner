package com.trabajo.carlos.superejercicio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trabajo.carlos.superejercicio.R;
import com.trabajo.carlos.superejercicio.bbdd.DBAdapter;
import com.trabajo.carlos.superejercicio.datos.Persona;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 * Este fragment añade campos a la BBDD
 */
public class AddFragment extends Fragment {

    private EditText edtAdd;
    private Button btnAdd;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add, container, false);

        edtAdd = (EditText)v.findViewById(R.id.edtAdd);
        btnAdd = (Button)v.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                save(edtAdd.getText().toString());

            }
        });

        return v;
    }

    /**
     * Metodo para guardar un nombre
     * @param name
     */
    private void save(String name)
    {

        DBAdapter db = new DBAdapter(getActivity());
        db.openDB();

        boolean saved = db.add(name);

        //Si se ha guardado bien reseteamos el eddittext, sino mostramos un error
        if(saved)
        {

            edtAdd.setText("");

        }else {

            Toast.makeText(getActivity(), "No se puede guardar", Toast.LENGTH_SHORT).show();

        }

    }

}
