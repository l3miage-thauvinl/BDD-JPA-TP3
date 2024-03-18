package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;
    public AlbumEntity albumRepository(AlbumEntity albumEntity){
        return this.albumRepository.save(albumEntity);
    }

    public AlbumEntity updateSongEntities(String title, Set<SongEntity> songEntities){
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setSongEntities(songEntities);
        return albumRepository.save(albumEntity);
    }
    public AlbumEntity updateReleaseDate(String title, Date releaseDate){
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setReleaseDate(releaseDate);
        return albumRepository.save(albumEntity);
    }
    public AlbumEntity updateArtistEntity(String title, ArtistEntity artistEntity){
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setArtistEntity(artistEntity);
        return albumRepository.save(albumEntity);
    }
    public void deleteAlbum(String title){
        albumRepository.deleteById(title);
    }
}
