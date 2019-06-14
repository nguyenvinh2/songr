package com.codefellows.vinh.songr.controller;

import com.codefellows.vinh.songr.model.Album;
import com.codefellows.vinh.songr.model.Song;
import com.codefellows.vinh.songr.repository.AlbumRepository;
import com.codefellows.vinh.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albums;

    @Autowired
    SongRepository songs;

    int count = 0;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        if (count == 0) {
            Album jonas = new Album("Happiness Begins", "Jonas Brothers", 14, 2623, "https://www.gannett-cdn.com/presto/2019/06/07/PKNS/b1af208c-10f8-49ce-b56c-8795ec152194-JonasBrothers.jpg?width=540&height=&fit=bounds&auto=webp");
            Album dylan = new Album("The Rolling Thunder Revue: The 1975 Live Recordings", "Bob Dylan", 25, 30345, "https://cdn-s3.allmusic.com/release-covers/500/0005/057/0005057564.jpg");
            albums.save(jonas);
            albums.save(dylan);

            Song testSong = new Song("hey hey by", jonas);
            Song testSong2 = new Song("all the am by", jonas);
            Song testSong3 = new Song("things", jonas);
            songs.save(testSong);
            songs.save(testSong2);
            songs.save(testSong3);

            Song test3 = new Song("hoo hye", dylan);
            Song test5 = new Song("hoo h3rye", dylan);
            Song test4 = new Song("hw2 hye", dylan);

            songs.save(test3);
            songs.save(test4);
            songs.save(test5);

            count++;
        }
        model.addAttribute("albums", albums.findAll());
        model.addAttribute("album", Album.class);
        return "index";
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String create(@ModelAttribute Album input) {
        Album createAlbum = new Album(input.title, input.artist, input.songCount, input.length, input.imageUrl);
        albums.save(createAlbum);
        return "redirect:/";
    }

    @RequestMapping(value="/edit", method= RequestMethod.POST)
    public String edit(@ModelAttribute Album input) {
        albums.save(input);
        return "redirect:/";
    }


    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public String delete(@ModelAttribute Album input) {
        albums.delete(input);
        return "redirect:/";
    }

}
