package com.thoughtworks.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MenuDBOpenHelper extends SQLiteOpenHelper {


    public static final String DATABASE_TABLE = "MenuList";
    public static final String DATABASE_NAME = "MenuChampion.db";

    public static String KEY_ID = "_id";

    public static final String MENU_ITEM_NAME_COLUMN = "menu_item_name";
    public static final String DATABASE_CREATE_SCRIPT = "create table " +
            DATABASE_TABLE + " (" + KEY_ID + " integer primary key autoincrement, " +
            MENU_ITEM_NAME_COLUMN + " text not null);";

    public MenuDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MenuDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("----------------------", "Creating table" + DATABASE_CREATE_SCRIPT)        ;
        db.execSQL(DATABASE_CREATE_SCRIPT);
        insertItem(db, "Item 1");
        insertItem(db, "Item 2");
        insertItem(db, "Item 3");

    }

    private void insertItem(SQLiteDatabase db, String menuItem) {
        db.execSQL("insert into " + DATABASE_TABLE + "("+ MENU_ITEM_NAME_COLUMN + ") values ('" + menuItem + "')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
}
