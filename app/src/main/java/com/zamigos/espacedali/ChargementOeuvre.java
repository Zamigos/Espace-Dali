package com.zamigos.espacedali;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;

/**
 * Created by pringuez on 11/01/2016.
 */
public class ChargementOeuvre {

    public static ArrayList<Oeuvre> getOeuvre() {
        ArrayList<Oeuvre> oeuvres = new ArrayList<>();

        oeuvres.add(new Oeuvre(1, "Le Profil du temps", "01/06/1977", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://daliparis.com/public/Galerie-Dali/profile-of-time-.jpg", 1));
        oeuvres.add(new Oeuvre(2, "L'éléphant spatial", "06/01/1971", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://daliparis.com/public/Galerie-Dali/space-elephant.jpg", 1));
        oeuvres.add(new Oeuvre(3, "Newton surréaliste", "25/04/1977", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://daliparis.com/public/Galerie-Dali/surrealist-newton-new.jpg", 1));
        oeuvres.add(new Oeuvre(4, "La Femme du temps", "30/06/1980", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://daliparis.com/public/Galerie-Dali/woman-of-time.jpg", 1));
        oeuvres.add(new Oeuvre(5, "Lady Godiva aux papillons", "14/01/1976", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://daliparis.com/public/Galerie-Dali/lady-godiva.jpg", 1));

        oeuvres.add(new Oeuvre(6, "La persistance de la mémoire", "08/04/1931", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://media.topito.com/wp-content/uploads/2012/11/la-persistance-de-la-m%C3%A9moire1.jpg", 2));
        oeuvres.add(new Oeuvre(7, "Cygnes réfléchis en éléphants", "27/11/1931", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://media.topito.com/wp-content/uploads/2012/11/Cygnes-r%C3%A9fl%C3%A9chis-en-%C3%A9l%C3%A9phants.jpg", 2));
        oeuvres.add(new Oeuvre(8, "Les éléphants,", "09/09/1948", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://media.topito.com/wp-content/uploads/2012/11/les-%C3%A9l%C3%A9phants.jpg", 2));
        oeuvres.add(new Oeuvre(9, "Le sommeil", "08/12/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://media.topito.com/wp-content/uploads/2012/11/le-sommeil.jpg", 2));
        oeuvres.add(new Oeuvre(10, "Métamorphose de Narcisse", "27/03/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://media.topito.com/wp-content/uploads/2012/11/M%C3%A9tamorphose-de-Narcisse.jpg", 2));

        // Cinema
        oeuvres.add(new Oeuvre(11, "Un chien Andalou", "08/04/1929", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://www.surrealiste.net/images/artistes/dalie-films.jpg", 3));
        oeuvres.add(new Oeuvre(12, "L'age d'or", "27/11/1931", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCAji7qGm84p7bmpizYAiEq6wEdxbF-Nrey9nLXzqAys_uD_a4", 3));
        oeuvres.add(new Oeuvre(13, "Impressions de la Haute Mongolie", "08/04/1931", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://www.fulltv.com.ar/images/peliculas/impresiones-de-la-alta-mongolia.jpg", 3));

        // Design
        oeuvres.add(new Oeuvre(14, "Canapé Lèvres de Mae West", "09/09/1948", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://bdbarcelona.com/system/products/images/products_5_thumb.jpg?1409833335", 4));
        oeuvres.add(new Oeuvre(15, "Vis-à-vis de la gala, black label", "08/12/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://bdbarcelona.com/system/products/images/products_94_thumb.jpg?1410263475", 4));
        oeuvres.add(new Oeuvre(16, "Leda low table-sculpture", "27/03/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://bdbarcelona.com/system/products/images/products_91_thumb.jpg?1410269340", 4));

        //Illustration
        oeuvres.add(new Oeuvre(14, "Mad Tea Party,", "09/09/1948", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://www.williambennettmodern.com/artists/dali/pictures/large%20v2/DALI1009.jpg", 5));
        oeuvres.add(new Oeuvre(15, "The Pool of Tears", "08/12/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://www.williambennettmodern.com/artists/dali/pictures/large%20v2/DALI1004.jpg", 5));
        oeuvres.add(new Oeuvre(16, "Down the Rabbit Hole", "27/03/1937", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur pulvinar ultrices. Donec et mi porttitor, egestas orci volutpat, faucibus elit. Cras sollicitudin ullamcorper massa sed tristique. Morbi ornare vulputate metus, et aliquet lectus pretium eget. Donec pulvinar tortor in justo hendrerit ultricies. Aenean nec tristique nisl. Sed ac luctus elit.", "http://www.williambennettmodern.com/artists/dali/pictures/large%20v2/DALI1003.jpg", 5));

        return oeuvres;
    }

    public static ArrayList<Oeuvre> getFavorite(SharedPreferences preferences){

        ArrayList<Oeuvre> oeuvres = ChargementOeuvre.getOeuvre();
        ArrayList<Oeuvre> result = new ArrayList<>();
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

        for(int i = 0; i < jsonFav.length(); i++){
            for (Oeuvre o : oeuvres) {
                try {
                    if(o.getId() == jsonFav.getInt(i)){
                        result.add(o);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public ArrayList<Oeuvre> findOeuvreByTheme(int idTheme){
        ArrayList<Oeuvre> oeuvres = ChargementOeuvre.getOeuvre();
        ArrayList<Oeuvre> result = new ArrayList<>();
        for (Oeuvre o : oeuvres) {
            if(o.getIdTheme() == idTheme){
                result.add(o);
            }
        }
        return result;
    }

    public static Oeuvre findOeuvreById(int idOeuvre) {
        ArrayList<Oeuvre> oeuvres = ChargementOeuvre.getOeuvre();
        Oeuvre oeuvre;
        for (Oeuvre o : oeuvres) {
            if (o.getId() == idOeuvre) {
                return o;
            }
        }
        return null;
    }
}
