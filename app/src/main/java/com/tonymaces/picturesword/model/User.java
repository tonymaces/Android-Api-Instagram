package com.tonymaces.picturesword.model;

/**
 * Created by Tony Macavilca Estrada on 13/08/2016.
 */
public class User {
    private  String id;
    private  String fullName;
    private  String urlImage;
    private int likes = 0;

    public User(String id, String fullName, String urlImage, int likes) {
        this.id = id;
        this.fullName = fullName;
        this.urlImage = urlImage;
        this.likes = likes;
    }

    public  User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
