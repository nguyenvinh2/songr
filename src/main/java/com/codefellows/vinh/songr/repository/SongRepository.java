package com.codefellows.vinh.songr.repository;

import com.codefellows.vinh.songr.model.Song;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SongRepository extends CrudRepository<Song, Integer> {
    public Iterable<Song> findByAlbumId(int id);
    public void deleteByAlbumId(int id);
}
