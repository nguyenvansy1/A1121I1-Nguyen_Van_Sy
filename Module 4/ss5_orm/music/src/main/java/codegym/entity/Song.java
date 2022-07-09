package codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "Song")

public class Song {
    @Id
    @Column(name = "song", columnDefinition = "nvarchar(20)")
    private String song;

    @Column(name = "singer", columnDefinition = "nvarchar(50)")
    private String singer;
    private String genre;
    private String link_file;

    public Song() {
    }

    public Song(String song, String singer, String genre, String link_file) {
        this.song = song;
        this.singer = singer;
        this.genre = genre;
        this.link_file = link_file;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink_file() {
        return link_file;
    }

    public void setLink_file(String link_file) {
        this.link_file = link_file;
    }
}
