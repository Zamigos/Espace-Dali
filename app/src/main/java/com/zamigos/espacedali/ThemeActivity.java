package com.zamigos.espacedali;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    private InitTheme initTheme;
    private ArrayList<Theme> themeArrayList;
    private ThemeAdapter themeAdapter;
    private ListView lvTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        lvTheme = (ListView) findViewById(R.id.lvTheme);
        themeArrayList = new ArrayList<>();

        themeAdapter = new ThemeAdapter(this, themeArrayList);
        lvTheme.setAdapter(themeAdapter);
        initTheme = new InitTheme();
        initTheme.execute();
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
