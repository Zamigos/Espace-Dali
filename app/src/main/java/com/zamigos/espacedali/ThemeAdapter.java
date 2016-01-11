package com.zamigos.espacedali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pringuez on 11/01/2016.
 */
public class ThemeAdapter extends BaseAdapter{
    private ArrayList<Theme> themeArrayList;
    private LayoutInflater mInflater;

    public ThemeAdapter(final Context context, ArrayList<Theme> themeArrayList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.themeArrayList = themeArrayList;
    }

    @Override
    public int getCount() {
        return themeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return themeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        //---------------------
        // inflate
        //-------------------------
        final ViewHolder viewHolder;
        if (rowView == null) {
            //creation
            rowView = mInflater.inflate(R.layout.cellule_theme, null);

            viewHolder = new ViewHolder();
            viewHolder.tvTheme = (TextView) rowView.findViewById(R.id.tvTheme);
            viewHolder.imgTheme = (ImageView) rowView.findViewById(R.id.imgTheme);

            rowView.setTag(viewHolder);
        }
        else {
            //recyclage
            viewHolder = (ViewHolder) rowView.getTag();
        }

        //---------------------
        // Remplissage
        //-------------------------

        //on remplit avec l'objet voulu
        final Theme theme = (Theme) getItem(position);

        viewHolder.tvTheme.setText(theme.getLabel() + "");
        Picasso.with(rowView.getContext()).load(theme.getImage()).into(viewHolder.imgTheme);

        return rowView;
    }

    //------------------
    // View Holder
    //------------------
    public static class ViewHolder {
        public TextView tvTheme;
        public ImageView imgTheme;
    }
}
