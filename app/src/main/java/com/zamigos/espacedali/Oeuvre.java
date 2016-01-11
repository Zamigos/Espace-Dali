package com.zamigos.espacedali;

import java.util.Date;

/**
 * Created by pringuez on 11/01/2016.
 */
public class Oeuvre {
    private int id;
    private String title;
    private int date;
    private String description;
    private String image;
    private int idTheme;

    public Oeuvre(int id, String title, int date, String description, String image, int idTheme) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.image = image;
        this.idTheme = idTheme;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
