package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends MainActivity {

    private ArrayList<Oeuvre> searchArrayList;
    private EditText etSearch;
    private ListView lvSearch;
    private FavoriteAdpater favoriteAdpater;
    private InitSearch initSearch;
    private String key;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_search);

        lvSearch = (ListView) findViewById(R.id.lvSearch);
        btnReset = (Button) findViewById(R.id.btnReset);
        searchArrayList = new ArrayList<>();

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        favoriteAdpater = new FavoriteAdpater(mInflater, searchArrayList, this);

        lvSearch.setAdapter(favoriteAdpater);

        ((EditText)findViewById(R.id.etSearch)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                key = s.toString();
                initSearch = new InitSearch();
                initSearch.execute();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == ' ') {
                    //dp something
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) findViewById(R.id.etSearch)).setText("");
                searchArrayList.clear();
                favoriteAdpater.notifyDataSetChanged();
            }
        });
    }

    public class InitSearch extends AsyncTask {

        private ArrayList<Oeuvre> result = null;

        @Override
        protected Object doInBackground(Object[] params) {
            result = ChargementOeuvre.findOeuvreByWord(key);
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (result != null) {
                searchArrayList.clear();
                searchArrayList.addAll(result);
                favoriteAdpater.notifyDataSetChanged();
            }
        }
    }
}
