package com.cimakasky.songr;

import com.cimakasky.songr.database.Album;
import com.cimakasky.songr.database.Song;
import com.cimakasky.songr.database.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongRepository repo;

    //create single song
    @PostMapping("/create")
    public RedirectView createSong(@RequestParam String title,@RequestParam long length, @RequestParam int trackNumber,
                                   @RequestParam Album album){
        Song song = new Song();
        song.title = title;
        song.length = length;
        song.trackNumber = trackNumber;
        song.album = album;
        song = this.repo.save(song);
        return new RedirectView("'/Album/' + ${song.album.id}");
    }

    @PutMapping("/update/{id}")
    public RedirectView updateSong(@PathVariable long id, @RequestBody Song song) {
        Optional<Song> repoSong = this.repo.findById(id);

        if (repoSong.isPresent()) {
            Song foundSong = repoSong.get();

            foundSong.title = song.title;
            foundSong.length = song.length;
            foundSong.trackNumber = song.trackNumber;
            foundSong.album = song.album;

            foundSong = this.repo.save(foundSong);
        }
        return new RedirectView("'song/'+ ${song.id}");
    }
        //return all songs in repository
        @GetMapping("/all")
        public String getSongs(Model model){
            List<Song> songs = this.repo.findAll();
            model.addAttribute("song", songs);
            return "song";
        }


    }

