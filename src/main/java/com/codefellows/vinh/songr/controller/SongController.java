package com.codefellows.vinh.songr.controller;

import com.codefellows.vinh.songr.model.Album;
import com.codefellows.vinh.songr.model.Song;
import com.codefellows.vinh.songr.repository.AlbumRepository;
import com.codefellows.vinh.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;

@Controller
public class SongController {


    @Autowired
    AlbumRepository albums;

    @Autowired
    SongRepository songs;

    @RequestMapping(value="/song/{id}", method= RequestMethod.GET)
    public String song(@PathVariable int id, Model model) {
        Iterable<Song> songst = songs.findByAlbumId(id);
        model.addAttribute("songs", songst);
        model.addAttribute("albumId", id);
        return "songs";
    }

    @RequestMapping(value="song/{id}/add", method= RequestMethod.POST)
    public String addSong(@RequestParam int album_id, @ModelAttribute Song input) {
        Song newSong = new Song(input.title,input.trackNumber, input.length, albums.findById(album_id).get());
        songs.save(newSong);
        return "redirect:/song/"+album_id;
    }

    @RequestMapping(value="song/{id}/edit", method= RequestMethod.POST)
    public String editSong(@RequestParam int album_id, @ModelAttribute Song input) {
        Album getAlbum = albums.findById(album_id).get();
        input.setAlbum(getAlbum);
        songs.save(input);
        return "redirect:/song/"+album_id;
    }

    @RequestMapping(value="song/{id}/delete", method= RequestMethod.POST)
    public String deleteSong(@RequestParam int album_id, @ModelAttribute Song input) {
        System.out.println(input.getId());
        songs.deleteById(input.getId());
        return "redirect:/song/"+album_id;
    }
}
