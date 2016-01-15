package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class DetailActivity extends MainActivity {

    private Button btnComment;
    private ImageButton btnFavoris;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvDescription;
    private ImageView ivImage;
    private int idOeuvre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_detail);

        SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);

        btnComment = (Button) findViewById(R.id.btnComments);
        btnFavoris = (ImageButton) findViewById(R.id.ibFavori);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        if(preferences.getAll() !=null) {
            idOeuvre = Integer.parseInt(preferences.getString("idOeuvre", ""));
        }

        Oeuvre oeuvre = ChargementOeuvre.findOeuvreById(idOeuvre);

        if (ChargementOeuvre.isFavorite(preferences, idOeuvre)) {
            btnFavoris.setImageResource(R.drawable.ic_menu_favorite_detail_active);
        }

        tvTitle.setText(oeuvre.getTitle());
        tvDate.setText(oeuvre.getDate());
        tvDescription.setText(oeuvre.getDescription());

        Picasso.with(this).load(oeuvre.getImage()).into(ivImage);

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });
        btnFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                String strFavorites = preferences.getString("favorites", "");

                JSONArray jsonFav = new JSONArray();
                RelativeLayout toolBar = (RelativeLayout) findViewById(R.id.detail_layout);

                if (!strFavorites.isEmpty()) {
                    try {
                        jsonFav = new JSONArray(strFavorites);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                if (ChargementOeuvre.isFavorite(preferences, idOeuvre)) {

                    for (int i = 0; i < jsonFav.length(); i++) {
                        try {
                            if (jsonFav.getInt(i) == Integer.parseInt(preferences.getString("idOeuvre", ""))) {
                                jsonFav.remove(i);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    preferences.edit().putString("favorites", jsonFav.toString()).commit();Crouton.showText(DetailActivity.this, getString(R.string.message_remove_favori), Style.ALERT, toolBar);
                    btnFavoris.setImageResource(R.drawable.ic_menu_favorite_detail);
                } else {
                    jsonFav.put(Integer.parseInt(preferences.getString("idOeuvre", "")));
                    btnFavoris.setImageResource(R.drawable.ic_menu_favorite_detail_active);
                    preferences.edit().putString("favorites", jsonFav.toString()).commit();
                    Crouton.showText(DetailActivity.this, getString(R.string.message_add_in_favorite), Style.INFO, toolBar);
                }
            }
        });
    }
}
