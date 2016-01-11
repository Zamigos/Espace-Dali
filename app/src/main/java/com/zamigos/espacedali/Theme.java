package com.zamigos.espacedali;

/**
 * Created by pringuez on 11/01/2016.
 */
public class Theme {
    private int id;
    private String label;
    private String image;

    public Theme(int id, String label, String image) {
        this.id = id;
        this.label = label;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
