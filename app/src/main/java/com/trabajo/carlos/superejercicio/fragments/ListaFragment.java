package com.trabajo.carlos.superejercicio.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.trabajo.carlos.superejercicio.R;
import com.trabajo.carlos.superejercicio.bbdd.DBAdapter;
import com.trabajo.carlos.superejercicio.datos.Persona;
import com.trabajo.carlos.superejercicio.lista.CustomAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 * Este fragment muestra una lista con los campos de la BBDD
 */
public class ListaFragment extends Fragment {

    ListView lsvLista;
    ArrayList<Persona> personas = new ArrayList<>();
    CustomAdapter adapter;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        lsvLista = (ListView)v.findViewById(R.id.lsvLista);

        //Inicializamos el adapter de la lista
        adapter = new CustomAdapter(getActivity(), personas);

        this.getPersonas();

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
        lsvLista.setAdapter(adapter);

    }

    /**
     * Metodo que borra un nombre de la BBDD
     */
    private void delete()
    {
        //Cogemos el id
        int id = adapter.getSelectedItemID();

        DBAdapter db = new DBAdapter(getActivity());
        db.openDB();

        boolean deleted = db.delete(id);
        db.closeDB();

        //Si se ha borrado bien
        if(deleted)
        {

            getPersonas();

        }else {

            Toast.makeText(getActivity(), "No se puede borrar", Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * Este es el metodo para cuando hacemos el longclick
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        CharSequence title = item.getTitle();
        if(title == "Borrar")
        {

            delete();


        }

        return super.onContextItemSelected(item);

    }

}
