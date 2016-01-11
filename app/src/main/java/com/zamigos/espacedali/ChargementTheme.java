package com.zamigos.espacedali;

import java.util.ArrayList;

/**
 * Created by pringuez on 11/01/2016.
 */
public class ChargementTheme {
    public static ArrayList<Theme> getTheme() {
        ArrayList<Theme> themes = new ArrayList<>();

        themes.add(new Theme(1,"sulpture", "http://lorempixel.com/g/400/200"));
        themes.add(new Theme(2,"peinture", "http://lorempixel.com/g/400/200"));
        themes.add(new Theme(3,"tableau", "http://lorempixel.com/g/400/200"));
        themes.add(new Theme(4,"film", "http://lorempixel.com/g/400/200"));
        themes.add(new Theme(5,"illustration", "http://lorempixel.com/g/400/200"));

        return themes;
    }
}
