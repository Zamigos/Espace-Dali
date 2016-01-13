package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    private InitTheme initTheme;
    private ArrayList<Theme> themeArrayList;
    private ThemeAdapter themeAdapter;
    private ListView lvTheme;
    public ImageView imgTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        lvTheme = (ListView) findViewById(R.id.lvTheme);
        imgTheme = (ImageView) findViewById(R.id.imgTheme);
        themeArrayList = new ArrayList<>();

        themeAdapter = new ThemeAdapter(this, themeArrayList);
        lvTheme.setAdapter(themeAdapter);
        initTheme = new InitTheme();
        initTheme.execute();

        lvTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ThemeActivity.this, OeuvreActivity.class);

                SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                preferences.edit().putString("idTheme", ((TextView) view.findViewById(R.id.tvHidden)).getText().toString()).commit();

                startActivity(intent);
                setContentView(R.layout.activity_oeuvre);
            }
        });
    }

    public class InitTheme extends AsyncTask {

        private ArrayList<Theme> result = null;

        @Override
        protected Object doInBackground(Object[] params) {
            result = ChargementTheme.getTheme();
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (result != null) {
                themeArrayList.clear();
                themeArrayList.addAll(result);
                themeAdapter.notifyDataSetChanged();
            }
        }
    }
}
