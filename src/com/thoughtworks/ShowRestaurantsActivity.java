package com.thoughtworks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ShowRestaurantsActivity extends Activity implements View.OnClickListener{
    private static final String TAG = ShowRestaurantsActivity.class.getSimpleName();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewGroup layout = (ViewGroup) findViewById(R.id.list_of_restaurants);

        List<String> restaurants = new ArrayList<String>();
        restaurants.add("Restaurant 1");
        restaurants.add("Restaurant 2");

        for(String restaurantName : restaurants) {
            addRestaurantButton(layout, restaurantName);
        }
    }

    private void addRestaurantButton(ViewGroup layout, String restaurantName) {
        Button restaurantButton = new Button(this);
        restaurantButton.setOnClickListener(this);
        restaurantButton.setText(restaurantName);
        layout.addView(restaurantButton);
    }

    @Override
    public void onClick(View eventView) {
        Intent intent = new Intent(this, ListMenuAction.class);
        startActivity(intent);

    }
}
