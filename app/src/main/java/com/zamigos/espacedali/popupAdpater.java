package com.zamigos.espacedali;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

class PopupAdapter implements InfoWindowAdapter {
    private View popup=null;
    private LayoutInflater inflater=null;

    PopupAdapter(LayoutInflater inflater) {
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return(null);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getInfoContents(Marker marker) {
        if (popup == null) {
            popup=inflater.inflate(R.layout.popup, null);
            if(inflater.getContext().getClass().toString().contains("InfoActivity")){
                ImageView imgPopup = (ImageView)popup.findViewById(R.id.imgPopup);
                imgPopup.setImageResource(R.drawable.logo_daliparis);
            }
        }

        TextView tv=(TextView)popup.findViewById(R.id.title);

        tv.setText(marker.getTitle());
        tv=(TextView)popup.findViewById(R.id.snippet);
        tv.setText(marker.getSnippet());

        return(popup);
    }
}
