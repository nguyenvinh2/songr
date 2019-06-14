package com.codefellows.vinh.songr.model;

import javax.persistence.*;

@Entity
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;
    public int trackNumber;

    public Song(String title, int trackNumber, int length, Album album) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.length = length;
        this.album = album;
    }

    public int length;

    public Song(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="album_id", nullable = false)
    public Album album;

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song() {
    }
}
