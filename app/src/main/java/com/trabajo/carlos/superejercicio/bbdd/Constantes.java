package com.trabajo.carlos.superejercicio.bbdd;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase contiene todas las constantes relacionadas con la BBDD
 */

public class Constantes {

    //Columnas
    static final String ROW_ID = "id";
    static final String ROW_NOMBRE = "nombre";

    //Propiedades
    static final String DB_NAME = "nombres.db";
    static final String TB_NAME = "nombre";
    static final int DB_VERSION = 1;

    //Crear tabla
    static final String CREATE_TB = "CREATE TABLE " + TB_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ROW_NOMBRE + " TEXT NOT NULL);";

    //Borrar tabla
    static final String DROP_TB = "DROP TABLE IF EXISTS " + TB_NAME;

}
