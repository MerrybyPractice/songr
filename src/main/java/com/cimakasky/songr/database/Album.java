package com.cimakasky.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.URL;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue
    public long id;

    public String title;
    public String artist;
    public int songCount;
    public long length;
    public URL imageURL;

    @OneToMany(mappedBy="album")
    List<Song> songs;

}
