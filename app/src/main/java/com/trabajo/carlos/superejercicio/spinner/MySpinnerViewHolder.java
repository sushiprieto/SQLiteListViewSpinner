package com.trabajo.carlos.superejercicio.spinner;

import android.view.View;
import android.widget.TextView;

import com.trabajo.carlos.superejercicio.R;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase definimos los metodos del spinner
 */

public class MySpinnerViewHolder {

    TextView txvNombreSp;

    public MySpinnerViewHolder(View v) {

        txvNombreSp = (TextView) v.findViewById(R.id.txvNombre);

    }

}
