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

        themes.add(new Theme(1,Context.getString(R.string.txt_theme_sculpture), "http://news.upperplayground.com/wp-content/uploads/2015/01/Kazuhiro-tsuji-hyperreal-sculpture-001.png"));
        themes.add(new Theme(2, Context.getString(R.string.txt_theme_paint), "https://s-media-cache-ak0.pinimg.com/736x/21/b1/2e/21b12e181adc3396f64d6abc3179069d.jpg"));
        themes.add(new Theme(3,Context.getString(R.string.txt_theme_cinema), "http://france3-regions.francetvinfo.fr/corse/sites/regions_france3/files/styles/top_big/public/assets/images/2014/10/08/le_cinema_selon_dali.jpg?itok=2K2qibyD"));
        themes.add(new Theme(4,Context.getString(R.string.txt_theme_design), "https://i.guim.co.uk/img/static/sys-images/Arts/Arts_/Pictures/2009/1/23/1232705631748/Salvador-Dalis-Mae-West-L-001.jpg?w=700&q=85&auto=format&sharp=10&s=0f30279d55dfbd70a87f3b544d40bf22"));
        themes.add(new Theme(5, Context.getString(R.string.txt_theme_illustration) , "https://s-media-cache-ak0.pinimg.com/736x/0d/2b/70/0d2b705c2758f49cab786357b8b97673.jpg"));

        return themes;
    }
}
