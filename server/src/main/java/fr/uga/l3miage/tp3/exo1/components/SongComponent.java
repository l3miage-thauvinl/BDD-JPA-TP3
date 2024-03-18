package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity SongComponent(SongEntity songEntity) {
        return this.songRepository.save(songEntity);
    }

    public SongEntity getSong(String title){return songRepository.findById(title).orElseThrow();}

    /*public SongEntity createSong(){
        SongEntity songEntity = SongEntity
                .builder()
                .title("title")
                .duration(Duration.ZERO)
                .albumEntity(new AlbumEntity())
                .artistEntity(new ArtistEntity())
                .build();
        return songRepository.save(songEntity);
    }*/
    public SongEntity updateDuration(String title, Duration duration){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setDuration(duration);
        return songRepository.save(songEntity);
    }
    public SongEntity updateAlbumEntity(String title, AlbumEntity album){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setAlbumEntity(album);
        return songRepository.save(songEntity);
    }
    public SongEntity updateArtistEntity(String title, ArtistEntity artist){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setArtistEntity(artist);
        return songRepository.save(songEntity);
    }
    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

    public Set<SongEntity> getSongIsInInterval(Duration d1, Duration d2){
        return songRepository.findAllByDurationBetween(d1,d2);
    }

}
