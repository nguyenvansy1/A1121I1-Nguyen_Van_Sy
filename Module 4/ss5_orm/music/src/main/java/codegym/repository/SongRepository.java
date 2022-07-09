package codegym.repository;

import codegym.entity.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SongRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Song song) {
        entityManager.persist(song);
    }

    public void updateSong(Song song) {
        entityManager.merge(song);
    }

    public void remove(Song song){
        entityManager.remove(entityManager.merge(song));
    }

    public List<Song> getList() {
        return entityManager.createQuery("Select s from Song s").getResultList();
    }

    public Song findBySong(String song) {
        return entityManager.find(Song.class, song);
    }

    public List<Song> findSongByName(String song) {
        List<Song> songs = entityManager.createQuery(
                "select s from Song s where s.song like : name")
                .setParameter("name", "%" + song + "%")
                .getResultList();
        return songs;
    }
}
