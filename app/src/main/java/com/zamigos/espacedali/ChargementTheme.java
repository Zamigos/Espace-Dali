package com.zamigos.espacedali;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import java.util.ArrayList;

/**
 * Created by pringuez on 11/01/2016.
 */
public class ChargementTheme {
    public static ArrayList<Theme> getTheme(Context Context) {
        ArrayList<Theme> themes = new ArrayList<>();



        themes.add(new Theme(1,Context.getString(R.string.txt_theme_sculpture), "http://lorempixel.com/g/900/300"));
        themes.add(new Theme(2, Context.getString(R.string.txt_theme_paint), "http://lorempixel.com/g/900/300"));
        themes.add(new Theme(3,Context.getString(R.string.txt_theme_cinema), "http://lorempixel.com/g/900/300"));
        themes.add(new Theme(4,Context.getString(R.string.txt_theme_design), "http://lorempixel.com/g/900/300"));
        themes.add(new Theme(5, Context.getString(R.string.txt_theme_illustration) , "http://lorempixel.com/g/900/300"));

        return themes;
    }
}
