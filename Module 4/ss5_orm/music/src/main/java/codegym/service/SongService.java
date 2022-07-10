package codegym.service;

import codegym.entity.Song;
import codegym.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public void save(Song song) {
        songRepository.save(song);
    }

    public void updateSong(Song song) {
        songRepository.updateSong(song);
    }

    public void remove(Song song){
        songRepository.remove(song);
    }

    public List<Song> getList() {
        return songRepository.getList();
    }

    public Song findBySong(String song) {
        return songRepository.findBySong(song);
    }

    public List<Song> findSongByName(String song) {
       return  songRepository.findSongByName(song);
    }
}
