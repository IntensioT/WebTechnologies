package com.intensio.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;


    private String name;
    private String author;
    private String description;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "averagemark")
    private double averageMark;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Review> reviewList;
}
