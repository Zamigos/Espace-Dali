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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OeuvreActivity extends MainActivity {

    private GridView gvOeuvre;
    private ImageView imgOeuvreGrid;
    private TextView tvHiddenOeuvre;
    private ArrayList<Oeuvre> oeuvreArrayList;
    private OeuvreAdpater oeuvreAdapter;
    private InitOeuvre initOeuvre;
    private int idTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_oeuvre);

        SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);

        if(preferences.getAll()!=null) {
            idTheme = Integer.parseInt(preferences.getString("idTheme", ""));
        }

        gvOeuvre = (GridView) findViewById(R.id.gvOeuvre);
        imgOeuvreGrid = (ImageView) findViewById(R.id.imgOeuvreGrid);
        tvHiddenOeuvre = (TextView) findViewById(R.id.tvHiddenOeuvre);
        oeuvreArrayList = new ArrayList<>();

        oeuvreAdapter = new OeuvreAdpater(this, oeuvreArrayList);
        gvOeuvre.setAdapter(oeuvreAdapter);
        initOeuvre = new InitOeuvre();
        initOeuvre.execute();

        gvOeuvre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OeuvreActivity.this, DetailActivity.class);

                SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                preferences.edit().putString("idOeuvre", ((TextView) view.findViewById(R.id.tvHiddenOeuvre)).getText().toString()).commit();

                startActivity(intent);
            }
        });
    }

    public class InitOeuvre extends AsyncTask {

        private ArrayList<Oeuvre> result = null;
        private ChargementOeuvre chargementOeuvre = new ChargementOeuvre();

        @Override
        protected Object doInBackground(Object[] params) {
            //Convert
            result = chargementOeuvre.findOeuvreByTheme(idTheme);
            //result = ChargementOeuvre.getOeuvre();
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (result != null) {
                oeuvreArrayList.clear();
                oeuvreArrayList.addAll(result);
                oeuvreAdapter.notifyDataSetChanged();
            }
        }
    }
}
