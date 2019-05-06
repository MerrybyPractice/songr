package com.cimakasky.songr.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue
    public long id;

    public String title;
    public long length;
    public int trackNumber;

    @ManyToOne
    public Album album;


}
