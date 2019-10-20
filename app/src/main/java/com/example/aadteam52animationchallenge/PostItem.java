package com.example.aadteam52animationchallenge;

public class PostItem {
    String title;
    String author;
    int photo;


    public PostItem() {
    }

    public PostItem(String title, String author, int photo) {
        this.title = title;
        this.author = author;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPhoto() {
        return photo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
