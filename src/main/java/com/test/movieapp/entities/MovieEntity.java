package com.test.movieapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "PRICE")
  private String price;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "RELEASED_DATE")
  private String releasedDate;

  @Column(name = "IMDB_RATING")
  private String imdbRating;

  @Column(name = "RUNTIME")
  private String runtime;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "idMovie")
  private List<ShowTimeEntity> showTimes;
}
