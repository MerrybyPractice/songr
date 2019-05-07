package com.cimakasky.songr;

import com.cimakasky.songr.database.Album;
import com.cimakasky.songr.database.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumRepository repo;

    //create single album
    @PostMapping("/create")
    public RedirectView createAlbum(@RequestParam String title,
                                    @RequestParam String artist,
                                    @RequestParam int songCount,
                                    @RequestParam long length,
                                    @RequestParam URL imageURL) {
        Album album = new Album();
        album.title = title;
        album.artist = artist;
        album.songCount = songCount;
        album.length = length;
        album.imageURL = imageURL;
        album = this.repo.save(album);
        return new RedirectView("/albums/all");
    }

    //update an existing album, currently throws an unhandled exception
    @PostMapping("/update/{id}")
    public RedirectView updateAlbum(@PathVariable long id,
                                    @RequestBody Album album) {
        Optional<Album> repoAlbum = this.repo.findById(id);

        if (repoAlbum.isPresent()) {
            Album foundAlbum = repoAlbum.get();

            foundAlbum.title = album.title;
            foundAlbum.artist = album.artist;
            foundAlbum.songCount = album.songCount;
            foundAlbum.length = album.length;
            foundAlbum.imageURL = album.imageURL;

            foundAlbum = this.repo.save(foundAlbum);
            return new RedirectView("/albums/album" + album.id);
        }
        throw new AlbumNotFoundException();
    }

    //return all albums in repository
    @GetMapping("/all")
    public String getAlbums(Model model) {
        List<Album> albums = this.repo.findAll();
        model.addAttribute("album", albums);
        return "album";
    }

    //return a single album in repository
    @GetMapping("/album/{id}")
    public String getAlbum(@PathVariable long id, Model model) {
        Optional<Album> album = this.repo.findById(id);
        if (album.isPresent()) {
            model.addAttribute("album", album.get());
            return "singleAlbum";
        } else {
            throw new AlbumNotFoundException();
        }
    }

    //delete a single album based on id
    @DeleteMapping("/delete/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        this.repo.deleteById(id);
    }
}
