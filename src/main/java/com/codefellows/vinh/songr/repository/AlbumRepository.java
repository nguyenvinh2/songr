package com.codefellows.vinh.songr.repository;

import com.codefellows.vinh.songr.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
}
