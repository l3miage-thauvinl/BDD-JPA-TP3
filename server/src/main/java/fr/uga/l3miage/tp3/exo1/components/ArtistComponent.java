package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;
    public ArtistEntity getArtist(String name){return artistRepository.findById(name).orElseThrow();}
    public ArtistEntity createArtist(){
        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .name("artist")
                .biography("bio")
                .genreMusical(GenreMusical.CLASSIC)
                .albumEntities(Set.of())
                .build();
        return artistRepository.save(artistEntity);
    }
    public ArtistEntity updateBiography(String name, String newBio){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setBiography(newBio);
        return artistRepository.save(artistEntity);
    }
    public ArtistEntity updateBiography(String name, GenreMusical genre){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setGenreMusical(genre);
        return artistRepository.save(artistEntity);
    }
    public void deleteArtist(String name){
        artistRepository.deleteById(name);
    }
    //Set<ArtistEntity> findAllByGenreMusical(String genre)
    public Set<ArtistEntity> getArtistsFromGenre(GenreMusical genre){
        return artistRepository.findAllByGenreMusical(genre);
    }
}
