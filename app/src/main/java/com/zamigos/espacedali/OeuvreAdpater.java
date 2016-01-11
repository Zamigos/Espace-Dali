package com.zamigos.espacedali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by pringuez on 11/01/2016.
 */
public class OeuvreAdpater extends BaseAdapter {
    private ArrayList<Oeuvre> oeuvreArrayList;
    private LayoutInflater mInflater;

    public OeuvreAdpater(final Context context, ArrayList<Theme> themeArrayList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.oeuvreArrayList = oeuvreArrayList;
    }

    @Override
    public int getCount() {
        return oeuvreArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return oeuvreArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // A completer
        return null;
    }
}
