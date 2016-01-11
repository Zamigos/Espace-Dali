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

        comments.add(new Comment(1,"mail1@gmail.com","Robert", "11/01/2016 10:25", "Tout plein de text loul", 1));
        comments.add(new Comment(2,"mail1@gmail.com","Ginette", "11/01/2016 10:35", "Arretes de flood uesh", 1));
        comments.add(new Comment(3,"mail1@gmail.com", "Robert", "11/01/2016 10:47", "loul", 1));
        comments.add(new Comment(4,"mail1@gmail.com","BG_du_97", "11/01/2016 10:58", "komen el ta claaaaaashé", 1));
        comments.add(new Comment(5,"mail1@gmail.com","Ginette", "11/01/2016 11:17", "Ta gueule tu sais pas écrire", 1));

        return comments;
    }
}
