package com.trabajo.carlos.superejercicio.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.trabajo.carlos.superejercicio.R;
import com.trabajo.carlos.superejercicio.datos.Persona;

import java.util.ArrayList;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase es el adaptador que rellena el spinner con los datos de la BBDD
 */

public class SpinnerCustomAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Persona> personas;
    private LayoutInflater inflater;
    private Persona persona;

    public SpinnerCustomAdapter(Context c, ArrayList<Persona> personas) {
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
            //Inflamos el spinner con el mismo layout que la lista
            convertView = inflater.inflate(R.layout.fila_lista, parent, false);
        }

        //Bindeamos los datos
        MySpinnerViewHolder holder = new MySpinnerViewHolder(convertView);
        holder.txvNombreSp.setText(personas.get(position).getName());

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
