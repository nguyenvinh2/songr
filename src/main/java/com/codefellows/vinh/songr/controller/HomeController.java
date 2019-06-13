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

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        Album jonas = new Album("Happiness Begins", "Jonas Brothers",14,2623,"https://rovimusic.rovicorp.com/image.jpg?c=2P9-GJSqE8oq6reBtjbzogSijaXJlYnq0St31qpAJWo=&f=5");
        Album dylan = new Album("The Rolling Thunder Revue: The 1975 Live Recordings","Bob Dylan",25,30345,"https://cdn-s3.allmusic.com/release-covers/500/0005/057/0005057564.jpg");
        albums.save(jonas);
        albums.save(dylan);
        Iterable<Album> songs = albums.findAll();
        model.addAttribute("albums", songs);
        return "index";
    }

}
