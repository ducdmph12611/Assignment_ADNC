package com.example.Assignment_ADNC.model;

public class ListRss {
    private String title, link;
    private int image;

    public ListRss() {
    }

    public ListRss(String title, String link, int image) {
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
