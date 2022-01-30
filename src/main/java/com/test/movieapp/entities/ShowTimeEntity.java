package com.test.movieapp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "SHOW_TIMES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ID_MOVIE")
    private Integer idMovie;
    @Column(name = "SHOW_TIME")
    private OffsetDateTime showTime;

}
