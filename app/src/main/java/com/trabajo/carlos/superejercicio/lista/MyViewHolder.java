package com.trabajo.carlos.superejercicio.lista;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.trabajo.carlos.superejercicio.R;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase definimos los metodos de la lista como el click largo y el menu emergente
 */

public class MyViewHolder implements View.OnLongClickListener,View.OnCreateContextMenuListener {

    TextView txvNombre;
    MyLongClickListener longClickListener;

    public MyViewHolder(View v) {
        txvNombre = (TextView) v.findViewById(R.id.txvNombre);

        v.setOnLongClickListener(this);
        v.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onLongClick(View v) {

        this.longClickListener.onItemLongClick();
        return false;

    }

    public void setLongClickListener(MyLongClickListener longClickListener)
    {

        this.longClickListener = longClickListener;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Acción : ");
        menu.add(0, 0, 0, "Borrar");

    }
}
