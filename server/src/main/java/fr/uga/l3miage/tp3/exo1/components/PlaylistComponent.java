package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;
    public PlaylistEntity PlaylistComponent(PlaylistEntity playlistEntity){return this.playlistRepository.save(playlistEntity);}
    public PlaylistEntity updateDescription(String name, String description){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setDescription(description);
        return playlistRepository.save(playlistEntity);
    }
    public PlaylistEntity updateTotalDuration(String name, Duration totalDuration){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setTotalDuration(totalDuration);
        return playlistRepository.save(playlistEntity);
    }
    public PlaylistEntity updateSongEntities(String name, Set<SongEntity> songEntities){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setSongEntities(songEntities);
        return playlistRepository.save(playlistEntity);
    }
    public Set<PlaylistEntity> getPlaylistContain(SongEntity songEntity){
        return playlistRepository.findAllBySongEntitiesContaining(songEntity);
    }
}
