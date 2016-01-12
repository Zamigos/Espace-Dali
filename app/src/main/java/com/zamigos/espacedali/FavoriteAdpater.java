package com.zamigos.espacedali;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pringuez on 08/12/2015.
 */
public class FavoriteAdpater extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Oeuvre> oeuvreList;

    public FavoriteAdpater(LayoutInflater mInflater, List<Oeuvre> oeuvreList) {
        this.layoutInflater = mInflater;
        this.oeuvreList = oeuvreList;
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

        ViewHolder viewHolder;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.cell_favorite, null);

            viewHolder = new ViewHolder();
            viewHolder.ec_tv_title = (TextView) rowView.findViewById(R.id.tvTitle);

            rowView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        Oeuvre oeuvre = oeuvreList.get(position);

        viewHolder.ec_tv_title.setText(oeuvre.getTitle());

        return rowView;
    }

    private static class ViewHolder {
        public TextView ec_tv_title;
    }
}
