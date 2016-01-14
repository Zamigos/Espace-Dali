package com.zamigos.espacedali;

/**
 * Created by Nicolas on 11/01/2016.
 */
public class Comment {
    private int id;
    private String email;
    private String name;
    private String date;
    private String content;
    private String avatar;
    private int idOeuvre;
    // Avatar ?

    public Comment(int id, String email, String name, String date, String content, int idOeuvre, String avatar) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.date = date;
        this.content = content;
        this.idOeuvre = idOeuvre;
        this.avatar = avatar;
    }

    public Comment(int id, String email, String name, String date, String content, int idOeuvre) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.avatar = avatar;
        this.date = date;
        this.content = content;
        this.idOeuvre = idOeuvre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
