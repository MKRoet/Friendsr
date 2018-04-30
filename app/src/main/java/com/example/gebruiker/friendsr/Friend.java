package com.example.gebruiker.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    public String name;
    public String bio;
    private int drawableId;
    private float rating;

    // Constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Getters
    public String getName() {

        return name;
    }

    public String getBio() {

        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    // Setter to allow the user to change the rating.
    public void setRating(float rating) {
        this.rating = rating;
    }
}
