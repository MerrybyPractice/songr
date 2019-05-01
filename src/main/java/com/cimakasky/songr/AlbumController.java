package com.cimakasky.songr;

import com.cimakasky.songr.database.Album;
import com.cimakasky.songr.database.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Album")
public class AlbumController {

    @Autowired
    AlbumRepository repo;


    //create single album
    @PostMapping("/create")
    public Album createAlbum(@RequestBody Album album){
        album = this.repo.save(album);
        return album;
    }

    //update an exsisting album, currently throws an unhandled exception
    @PutMapping("/update/{id}")
    public Album updateAlbum(@PathVariable long id, @RequestBody Album album) throws AlbumNotFoundException {
        Optional<Album> repoAlbum = this.repo.findById(id);

        if(repoAlbum.isPresent()){
            Album foundAlbum = repoAlbum.get();

            foundAlbum.title = album.title;
            foundAlbum.artist = album.artist;
            foundAlbum.songCount = album.songCount;
            foundAlbum.length = album.length;
            foundAlbum.imageURL = album.imageURL;

            foundAlbum = this.repo.save(foundAlbum);
            return foundAlbum;
        }

        throw new AlbumNotFoundException();
    }

    //return all albums in repository
    @GetMapping("/All")
    public Iterable<Album> getAlbums(){
        Iterable<Album> albums = this.repo.findAll();
        return albums;
    }

    //return a single album in repository
    @GetMapping("/album/{id}")
    public Album getAlbum(@PathVariable long id) throws AlbumNotFoundException {
        Optional<Album> album = this.repo.findById(id);
        if(album.isPresent()){
            return album.get();
        } else {
            throw new AlbumNotFoundException();
        }
    }

    //delete a single album based on id
    @DeleteMapping("/delete/{id}")
    public void deleteBug(@PathVariable Long id){
        this.repo.deleteById(id);
    }


}
