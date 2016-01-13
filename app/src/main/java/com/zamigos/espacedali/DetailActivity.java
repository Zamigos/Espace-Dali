package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

                Integer arrayFav[];
                JSONArray jsonFav = new JSONArray();

                if (!strFavorites.isEmpty()) {
                    try {
                        jsonFav = new JSONArray(strFavorites);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                jsonFav.put(Integer.parseInt(preferences.getString("idOeuvre", "")));
                preferences.edit().putString("favorites", jsonFav.toString()).commit();
            }
        });
    }
}
