package com.intensio.beans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
@IdClass(ReviewID.class)
public class Review {

    @Id
    @JoinColumn(name = "movie_id")
    @ManyToOne
    @Lazy
    private Movie movie;

    @Id
    @JoinColumn(name = "user_id")
    @ManyToOne
    @Lazy
    private User user;

    private String review;
    private int mark;
    private String ownerName;

}
