package com.zamigos.espacedali;

import android.content.Intent;
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

import java.util.ArrayList;

public class OeuvreActivity extends AppCompatActivity {

    private GridView gvOeuvre;
    private ImageView imgOeuvreGrid;
    private ArrayList<Oeuvre> oeuvreArrayList;
    private OeuvreAdpater oeuvreAdapter;
    private InitOeuvre initOeuvre;
    private int idTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oeuvre);


        Log.v("WARNING", "test1=" + idTheme);
        if(getIntent().getExtras()!=null) {
            idTheme = Integer.parseInt(getIntent().getExtras().getString("idTheme"));
        }

        gvOeuvre = (GridView) findViewById(R.id.gvOeuvre);
        imgOeuvreGrid = (ImageView) findViewById(R.id.imgOeuvreGrid);
        oeuvreArrayList = new ArrayList<>();

        oeuvreAdapter = new OeuvreAdpater(this, oeuvreArrayList);
        gvOeuvre.setAdapter(oeuvreAdapter);
        initOeuvre = new InitOeuvre();
        initOeuvre.execute();

        gvOeuvre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OeuvreActivity.this, DetailActivity.class);
                intent.putExtra("idTheme", ((TextView) view.findViewById(R.id.tvHiddenOeuvre)).getText().toString());
                startActivity(intent);
                setContentView(R.layout.activity_detail);
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
