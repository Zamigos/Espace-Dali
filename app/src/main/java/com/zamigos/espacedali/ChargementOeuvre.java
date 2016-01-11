package com.zamigos.espacedali;

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

        //SimpleDateFormat formater = new SimpleDateFormat("yyyy");
        //System.out.println(formater.format(aujourdhui));
        //DateFormat

        oeuvres.add(new Oeuvre(1, "Le Profil du temps", 1977, "", "http://daliparis.com/public/Galerie-Dali/profile-of-time-.jpg", 1));
        oeuvres.add(new Oeuvre(2, "L'éléphant spatial", 1971, "", "http://daliparis.com/public/Galerie-Dali/space-elephant.jpg", 1));
        oeuvres.add(new Oeuvre(3, "Newton surréaliste", 1977, "", "http://daliparis.com/public/Galerie-Dali/surrealist-newton-new.jpg", 1));
        oeuvres.add(new Oeuvre(4, "La Femme du temps", 1980, "", "http://daliparis.com/public/Galerie-Dali/woman-of-time.jpg", 1));
        oeuvres.add(new Oeuvre(5, "Lady Godiva aux papillons", 1976, "", "http://daliparis.com/public/Galerie-Dali/lady-godiva.jpg", 1));

        oeuvres.add(new Oeuvre(6, "La persistance de la mémoire",   1931, "", "http://media.topito.com/wp-content/uploads/2012/11/la-persistance-de-la-m%C3%A9moire1.jpg", 2));
        oeuvres.add(new Oeuvre(7, "Cygnes réfléchis en éléphants", 1931, "", "http://media.topito.com/wp-content/uploads/2012/11/Cygnes-r%C3%A9fl%C3%A9chis-en-%C3%A9l%C3%A9phants.jpg", 2));
        oeuvres.add(new Oeuvre(8, "Les éléphants, , ", 1948, "", "http://media.topito.com/wp-content/uploads/2012/11/les-%C3%A9l%C3%A9phants.jpg", 2));
        oeuvres.add(new Oeuvre(9, "Le sommeil", 1937, "", "http://media.topito.com/wp-content/uploads/2012/11/le-sommeil.jpg", 2));
        oeuvres.add(new Oeuvre(10, "Métamorphose de Narcisse", 1937, "", "http://media.topito.com/wp-content/uploads/2012/11/M%C3%A9tamorphose-de-Narcisse.jpg", 2));

        return oeuvres;
    }
}
