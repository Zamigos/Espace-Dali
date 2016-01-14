package com.zamigos.espacedali;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pringuez on 09/12/2015.
 */
public class LoadComment {

    public static ArrayList<Comment> getComment() {
        ArrayList<Comment> comments = new ArrayList<>();

        
        comments.add(new Comment(5,"mail1@gmail.com","Ginette", "11/01/2016 11:17", "La meilleure oeuvre de Dali !! J'étais scotché quand je suis arrivé devant.", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));
        comments.add(new Comment(4,"mail1@gmail.com","Bernard", "11/01/2016 10:58", "J'ai eu la même réaction Ginette. Mais je pense que c'est le éléphant ça meilleur oeuvre.", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));
        comments.add(new Comment(3,"mail1@gmail.com", "Robert", "11/01/2016 10:47", "Terrible ! A voir.", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));
        comments.add(new Comment(2,"mail1@gmail.com","Geneviève", "11/01/2016 10:35", "Hello, juste un mot pour dire que cette peinture a du chien !", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));
        comments.add(new Comment(1,"mail1@gmail.com","René", "11/01/2016 10:25", "Excellent", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));
        comments.add(new Comment(1,"mail1@gmail.com","Gilles", "11/01/2016 10:25", "I love this painting.", 1, "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"));

        return comments;
    }
}
