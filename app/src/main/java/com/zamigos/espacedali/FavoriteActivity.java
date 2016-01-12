package com.zamigos.espacedali;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    private ArrayList<Oeuvre> favoriteArrayList;
    private FavoriteAdpater favoriteAdpater;
    private ListView lvFavorite;
    private InitFavorite initFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        lvFavorite = (ListView) findViewById(R.id.lvFavorite);
        favoriteArrayList = new ArrayList<>();

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        favoriteAdpater = new FavoriteAdpater(mInflater, favoriteArrayList);

        lvFavorite.setAdapter(favoriteAdpater);

        initFavorite = new InitFavorite();
        initFavorite.execute();
    }

    public class InitFavorite extends AsyncTask {

        private ArrayList<Oeuvre> result = null;

        @Override
        protected Object doInBackground(Object[] params) {
            result = ChargementOeuvre.getFavorite();
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (result != null) {
                favoriteArrayList.clear();
                favoriteArrayList.addAll(result);
                favoriteAdpater.notifyDataSetChanged();
            }
        }
    }
}
