package com.thoughtworks;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.thoughtworks.data.MenuDBOpenHelper;

public class ListMenuAction extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        SQLiteDatabase db = new MenuDBOpenHelper(getApplicationContext(), MenuDBOpenHelper.DATABASE_NAME, null, 1).getReadableDatabase();

        Cursor query = db.query(MenuDBOpenHelper.DATABASE_TABLE, new String[]{MenuDBOpenHelper.MENU_ITEM_NAME_COLUMN},
                null, null, null, null, null);

        ViewGroup container = (ViewGroup) findViewById(R.id.list_items);
        while (query.moveToNext()) {
            TextView item = new TextView(this);
            item.setTextAppearance(getApplicationContext(), R.style.normalText);
            item.setBackgroundResource(R.color.normalTextViewColor);
            item.setText(query.getString(0));
            container.addView(item);
        }

    }
}
