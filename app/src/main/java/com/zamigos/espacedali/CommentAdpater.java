package com.zamigos.espacedali;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pringuez on 08/12/2015.
 */
public class CommentAdpater extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Comment> eleveList;

    public CommentAdpater(LayoutInflater mInflater, List<Comment> eleveList) {
        this.layoutInflater = mInflater;
        this.eleveList = eleveList;
    }

    @Override
    public int getCount() {
        return eleveList.size();
    }

    @Override
    public Object getItem(int position) {
        return eleveList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.cell_comment, null);

            viewHolder = new ViewHolder();
            viewHolder.ec_tv_name = (TextView) rowView.findViewById(R.id.tvName);
            viewHolder.ec_tv_content = (TextView) rowView.findViewById(R.id.tvContent);
            viewHolder.ec_tv_date = (TextView) rowView.findViewById(R.id.tvDate);

            rowView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        Comment comment = eleveList.get(position);

        viewHolder.ec_tv_name.setText(comment.getName());
        viewHolder.ec_tv_content.setText(comment.getContent());
        viewHolder.ec_tv_date.setText(comment.getDate());

        return rowView;
    }

    private static class ViewHolder {
        public TextView ec_tv_name, ec_tv_content, ec_tv_date;
    }
}
