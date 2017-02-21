package com.trabajo.carlos.superejercicio.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Carlos Prieto on 21/02/2017.
 *
 *
 * Esta clase contiene los metodos para la BBDD
 */

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }

    /**
     * Metodo que abre una conexion
     */
    public void openDB()
    {
        try
        {

            db = helper.getWritableDatabase();

        }catch (SQLException e)
        {

        }
    }

    /**
     * Metodo que cierra la BBDD
     */
    public void closeDB()
    {
        try
        {

            helper.close();

        }catch (SQLException e)
        {

        }
    }

    /**
     * Metodo para insertar un nombre
     * @param name
     * @return
     */
    public boolean add(String name)
    {
        try
        {

            ContentValues cv = new ContentValues();
            cv.put(Constantes.ROW_NOMBRE, name);

            long result = db.insert(Constantes.TB_NAME, Constantes.ROW_ID, cv);

            if(result>0)
            {
                return true;
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Metodo que hace un select a la BBDD
     * @return
     */
    public Cursor retrieve()
    {
        String[] columns = {Constantes.ROW_ID, Constantes.ROW_NOMBRE};

        Cursor c = db.query(Constantes.TB_NAME, columns, null, null, null, null, null);
        return c;
    }

    /**
     * Metodo que actualiza un campo de la BBDD
     * @param newName
     * @param id
     * @return
     */
    public boolean update(String newName,int id)
    {
        try
        {

            ContentValues cv = new ContentValues();
            cv.put(Constantes.ROW_NOMBRE, newName);


            int result = db.update(Constantes.TB_NAME, cv, Constantes.ROW_ID + " =?", new String[]{String.valueOf(id)});

            if(result > 0)
            {
                return true;
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * Metodo que elimina un campo de la BBDD
     * @param id
     * @return
     */
    public boolean delete(int id)
    {
        try
        {

            int result = db.delete(Constantes.TB_NAME, Constantes.ROW_ID + " =?", new String[]{String.valueOf(id)});

            if(result > 0)
            {
                return true;
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

}
