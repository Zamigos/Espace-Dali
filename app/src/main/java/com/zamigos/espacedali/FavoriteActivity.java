package com.zamigos.espacedali;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class FavoriteActivity extends MainActivity {
    private ArrayList<Oeuvre> favoriteArrayList;
    private FavoriteAdpater favoriteAdpater;
    private InitFavorite initFavorite;

    private ListView lvFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_favorite);

        lvFavorite = (ListView) findViewById(R.id.lvFavorite);
        favoriteArrayList = new ArrayList<>();

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        favoriteAdpater = new FavoriteAdpater(mInflater, favoriteArrayList, this);

        lvFavorite.setAdapter(favoriteAdpater);

        initFavorite = new InitFavorite();
        initFavorite.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        MenuItem item = menu.findItem(R.id.menu_item_share);
        item.setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_item_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            intent.putExtra(Intent.EXTRA_SUBJECT, "App Name");
            intent.putExtra(Intent.EXTRA_TEXT, "Check out this cool app http://market.android.com/details?id=com.example.yourpackagename");

            Intent chooser = Intent.createChooser(intent, getString(R.string.share_text));
            startActivity(chooser);
        }
        return true;
    }

    public class InitFavorite extends AsyncTask {

        private ArrayList<Oeuvre> result = null;

        @Override
        protected Object doInBackground(Object[] params) {
            SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
            result = ChargementOeuvre.getFavorite(preferences);
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

            if (result.isEmpty()) {
                RelativeLayout toolBar = (RelativeLayout) findViewById(R.id.favorite_layout);
                Crouton.showText(FavoriteActivity.this, getString(R.string.no_favorite), Style.INFO, toolBar);
            }
        }
    }
}
