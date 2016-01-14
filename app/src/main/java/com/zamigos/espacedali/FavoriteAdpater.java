package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Created by pringuez on 08/12/2015.
 */
public class FavoriteAdpater extends BaseAdapter {

    private TextView tvHiddenIdOeuvreFavorite;
    private ImageButton btnDeleteFavorite;
    private LayoutInflater layoutInflater;
    private List<Oeuvre> oeuvreList;
    private Context context;

    public FavoriteAdpater(LayoutInflater mInflater, List<Oeuvre> oeuvreList, Context context) {
        this.layoutInflater = mInflater;
        this.oeuvreList = oeuvreList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return oeuvreList.size();
    }

    @Override
    public Object getItem(int position) {
        return oeuvreList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.cell_favorite, null);

            viewHolder = new ViewHolder();
            viewHolder.ec_iv_image = (ImageView) rowView.findViewById(R.id.ivImageFavorite);
            viewHolder.ec_tv_title = (TextView) rowView.findViewById(R.id.tvTitleFavorite);
            viewHolder.ec_tv_id_oeuvre = (TextView) rowView.findViewById(R.id.tvHiddenIdOeuvreFavorite);

            rowView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        Oeuvre oeuvre = oeuvreList.get(position);

        viewHolder.ec_tv_title.setText(oeuvre.getTitle());
        viewHolder.ec_tv_id_oeuvre.setText(oeuvre.getId() + "");
        Picasso.with(rowView.getContext()).load(oeuvre.getImage()).into(viewHolder.ec_iv_image);


        btnDeleteFavorite = (ImageButton) rowView.findViewById(R.id.ibDeleteFavorite);
        btnDeleteFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = context.getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
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

                for (int i = 0; i < jsonFav.length(); i++) {
                    try {
                        if (jsonFav.getInt(i) == Integer.parseInt(viewHolder.ec_tv_id_oeuvre.getText().toString())) {
                            oeuvreList.remove(i);
                            jsonFav.remove(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                preferences.edit().putString("favorites", jsonFav.toString()).commit();
                notifyDataSetChanged();
            }
        });
        viewHolder.ec_tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                SharedPreferences preferences = context.getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                preferences.edit().putString("idOeuvre", viewHolder.ec_tv_id_oeuvre.getText().toString()).commit();

                context.startActivity(intent);
            }
        });
        viewHolder.ec_iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                SharedPreferences preferences = context.getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                preferences.edit().putString("idOeuvre", viewHolder.ec_tv_id_oeuvre.getText().toString()).commit();

                context.startActivity(intent);
            }
        });



        return rowView;
    }

    private static class ViewHolder {
        public TextView ec_tv_title, ec_tv_id_oeuvre;
        public ImageView ec_iv_image;
    }
}
