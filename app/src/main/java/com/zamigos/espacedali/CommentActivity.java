package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class CommentActivity extends MainActivity {

    private ArrayList<Comment> commentArrayList;
    private CommentAdpater commentAdpater;
    private ListView lvComment;
    private InitComment initComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_comments);

        lvComment = (ListView) findViewById(R.id.lvComment);
        commentArrayList = new ArrayList<>();

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        commentAdpater = new CommentAdpater(mInflater, commentArrayList);

        lvComment.setAdapter(commentAdpater);

        initComment = new InitComment();
        initComment.execute();
    }

    public class InitComment extends AsyncTask {

        private ArrayList<Comment> result = null;

        @Override
        protected Object doInBackground(Object[] params) {
            result = LoadComment.getComment();
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (result != null) {
                commentArrayList.clear();
                commentArrayList.addAll(result);
                commentAdpater.notifyDataSetChanged();
            }
        }
    }
}
