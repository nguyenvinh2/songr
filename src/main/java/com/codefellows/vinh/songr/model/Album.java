package com.codefellows.vinh.songr.model;

import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;
    public String artist;
    public int songCount;
    public int length;
    public String imageUrl;

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }
}
