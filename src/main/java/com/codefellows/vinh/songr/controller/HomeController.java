package com.codefellows.vinh.songr.controller;

import com.codefellows.vinh.songr.model.Album;
import com.codefellows.vinh.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albums;
    int count = 0;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        if (count == 0) {
            Album jonas = new Album("Happiness Begins", "Jonas Brothers", 14, 2623, "https://rovimusic.rovicorp.com/image.jpg?c=2P9-GJSqE8oq6reBtjbzogSijaXJlYnq0St31qpAJWo=&f=5");
            Album dylan = new Album("The Rolling Thunder Revue: The 1975 Live Recordings", "Bob Dylan", 25, 30345, "https://cdn-s3.allmusic.com/release-covers/500/0005/057/0005057564.jpg");
            albums.save(jonas);
            albums.save(dylan);
            count++;
        }
        model.addAttribute("albums", albums.findAll());
        model.addAttribute("album", Album.class);
        return "index";
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String create(@RequestParam String id, @ModelAttribute() Album input) {
        Album createAlbum = new Album(input.title, input.artist, input.songCount, input.length, input.imageUrl);
        albums.save(createAlbum);
        return "redirect:/";
    }

    @RequestMapping(value="/edit", method= RequestMethod.POST)
    public String edit(@RequestParam String id, @ModelAttribute() Album input) {
        albums.save(input);
        return "redirect:/";
    }


    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public String delete(@RequestParam String id, @ModelAttribute() Album input) {
        albums.delete(input);
        return "redirect:/";
    }

}
