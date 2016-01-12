package com.zamigos.espacedali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Console;

public class DetailActivity extends AppCompatActivity {

    private Button btnComment;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvDescription;
    private ImageView ivImage;
    private int idOeuvre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnComment = (Button) findViewById(R.id.btnComments);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        if(getIntent().getExtras()!=null) {
            idOeuvre = Integer.parseInt(getIntent().getExtras().getString("idTheme"));
        }

        Oeuvre oeuvre = ChargementOeuvre.findOeuvreById(idOeuvre);

        tvTitle.setText(oeuvre.getTitle());
        tvDate.setText(Integer.toString(oeuvre.getDate()));
        tvDescription.setText(oeuvre.getDescription());

        Picasso.with(this).load(oeuvre.getImage()).into(ivImage);

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CommentActivity.class);
                startActivity(intent);
                setContentView(R.layout.activity_comments);
            }
        });
    }
}
