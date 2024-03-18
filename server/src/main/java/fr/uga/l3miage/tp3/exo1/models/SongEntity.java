package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Duration;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity {
    @Id
    private String title;

    private Duration duration;

    @ManyToOne
    private AlbumEntity albumEntity;

    @ManyToOne
    private ArtistEntity artistEntity;
}
