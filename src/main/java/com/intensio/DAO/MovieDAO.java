package com.intensio.DAO;

import com.intensio.beans.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie, Integer> {

    Movie getMovieByName(String name);
    Movie getMovieById(int id);

}
