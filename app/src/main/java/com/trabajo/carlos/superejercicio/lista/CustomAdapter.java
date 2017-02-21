package com.trabajo.carlos.superejercicio.lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.trabajo.carlos.superejercicio.R;
import com.trabajo.carlos.superejercicio.datos.Persona;

import java.util.ArrayList;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase es el adaptador que rellena la lista con los datos de la BBDD
 */

public class CustomAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Persona> personas;
    private LayoutInflater inflater;
    private Persona persona;

    public CustomAdapter(Context c, ArrayList<Persona> personas) {
        this.c = c;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(inflater == null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            //Inflamos la lista
            convertView = inflater.inflate(R.layout.fila_lista, parent, false);
        }

        //Bindeamos los datos
        MyViewHolder holder = new MyViewHolder(convertView);
        holder.txvNombre.setText(personas.get(position).getName());

        //Metodo de click de un elemento de la lista
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, personas.get(position).getId() + " " + personas.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //Metodo de click largo de un elemento de la lista
        holder.setLongClickListener(new MyLongClickListener() {
            @Override
            public void onItemLongClick() {

                persona = (Persona) getItem(position);

            }
        });

        return convertView;

    }

    public int getSelectedItemID()
    {
        return persona.getId();
    }
    public String getSelectedItemName()
    {
        return persona.getName();
    }
}
