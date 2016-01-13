package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Zagonine on 13/01/2016.
 */
public class HomeActivity extends MainActivity {

    private Button btnOeuvre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.content_main);


        SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);

        if(preferences.getString("favorites", "")!=null) {
            Log.v("FAV =================>", preferences.getString("favorites", ""));
        }


        btnOeuvre = (Button) findViewById(R.id.btnOeuvre);

        btnOeuvre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
