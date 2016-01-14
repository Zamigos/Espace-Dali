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

        comments.add(new Comment(7,"mail1@gmail.com","Jean", "14/01/2016 15:51", "Génial ! Je cherchais justement de quoi faire mon éxposé ! Vraiment très pratique votre application ! :D", 1, "http://findicons.com/files/icons/1072/face_avatars/300/a04.png"));
        comments.add(new Comment(6,"mail1@gmail.com","Rose", "11/01/2016 11:27", "C'est tout naturel ;)", 1, "http://findicons.com/files/icons/1072/face_avatars/300/fh04.png"));
        comments.add(new Comment(5,"mail1@gmail.com","Mark", "11/01/2016 11:17", "Je te remercie Rose d'avoir pris le temps de me renseigner :)", 1, "http://findicons.com/files/icons/1072/face_avatars/300/d05.png"));
        comments.add(new Comment(4,"mail1@gmail.com","Rose", "11/01/2016 10:58", "Bonjour Mark, tu peu, à l'aide de l'application, accèder au plan des locaux !", 1, "http://findicons.com/files/icons/1072/face_avatars/300/fh04.png"));
        comments.add(new Comment(3,"mail1@gmail.com","Mark", "11/01/2016 10:47", "J'aimerais pouvoir voir cette oeuvre, dans quelle salle pouvons nous la trouver ?", 1, "http://findicons.com/files/icons/1072/face_avatars/300/d05.png"));
        comments.add(new Comment(2,"mail1@gmail.com","Rose", "11/01/2016 10:35", "Pour moi ce n'est pas la plus belle, mais je suis tout de même ravie de pouvoir la contempler depuis mon smartphone !", 1, "http://findicons.com/files/icons/1072/face_avatars/300/fh04.png"));
        comments.add(new Comment(1,"mail1@gmail.com","Henry", "11/01/2016 10:25", "Très belle oeuvre et très bonne description !", 1, "http://findicons.com/files/icons/1072/face_avatars/300/g04.png"));

        return comments;
    }
}
