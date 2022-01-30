package com.test.movieapp.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES")
@Setter
@Getter
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
}
