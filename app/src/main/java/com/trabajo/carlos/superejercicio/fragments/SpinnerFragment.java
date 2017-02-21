package com.trabajo.carlos.superejercicio.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.trabajo.carlos.superejercicio.R;
import com.trabajo.carlos.superejercicio.bbdd.DBAdapter;
import com.trabajo.carlos.superejercicio.datos.Persona;
import com.trabajo.carlos.superejercicio.spinner.SpinnerCustomAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 * Este fragment muestra un spinner donde cargado con los datos de la BBDD
 */
public class SpinnerFragment extends Fragment {

    Spinner spnSpinner;
    ArrayList<Persona> personas = new ArrayList<>();
    SpinnerCustomAdapter adapter;

    public SpinnerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spinner, container, false);

        spnSpinner = (Spinner)v.findViewById(R.id.spnSpinner);

        adapter = new SpinnerCustomAdapter(getActivity(), personas);

        this.getPersonas();

        //Para saber que item esta seleccionado del spinner
        spnSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(), personas.get(i).getId() + " " + personas.get(i).getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

    /**
     * Metodo donde obtenemos todos los nombres de la BBDD
     */
    private void getPersonas()
    {

        personas.clear();
        DBAdapter db = new DBAdapter(getActivity());
        db.openDB();

        Cursor c = db.retrieve();
        Persona persona = null;

        //Va recorriendo el cursor en busca de datos
        while (c.moveToNext())
        {

            int id = c.getInt(0);
            String name = c.getString(1);

            persona = new Persona();
            persona.setId(id);
            persona.setName(name);

            personas.add(persona);

        }

        db.closeDB();

        //Añadimos a la lista
        spnSpinner.setAdapter(adapter);

    }

}
