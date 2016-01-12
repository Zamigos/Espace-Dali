package com.zamigos.espacedali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pringuez on 11/01/2016.
 */
public class OeuvreAdpater extends BaseAdapter {
    private ArrayList<Oeuvre> oeuvreArrayList;
    private LayoutInflater mInflater;

    public OeuvreAdpater(final Context context, ArrayList<Oeuvre> oeuvreArrayList) {
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
        View rowView = convertView;

        //---------------------
        // inflate
        //-------------------------
        final ViewHolder viewHolder;
        if (rowView == null) {
            //creation
            rowView = mInflater.inflate(R.layout.cellule_oeuvre, null);

            viewHolder = new ViewHolder();
            viewHolder.gvOeuvre = (GridView) rowView.findViewById(R.id.gvOeuvre);
            viewHolder.tvHiddenOeuvre = (TextView) rowView.findViewById(R.id.tvHiddenOeuvre);
            viewHolder.imgOeuvreGrid = (ImageView) rowView.findViewById(R.id.imgOeuvreGrid);

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
        final Oeuvre oeuvre = (Oeuvre) getItem(position);

        viewHolder.tvHiddenOeuvre.setText(oeuvre.getId() + "");
        Picasso.with(rowView.getContext()).load(oeuvre.getImage()).into(viewHolder.imgOeuvreGrid);

        return rowView;
    }

    //------------------
    // View Holder
    //------------------
    public static class ViewHolder {
        public GridView gvOeuvre;
        public TextView tvHiddenOeuvre;
        public ImageView imgOeuvreGrid;
    }
}
