package com.intensio.DAO;

import com.intensio.beans.Movie;
import com.intensio.beans.Review;
import com.intensio.beans.ReviewID;
import com.intensio.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewDAO extends JpaRepository<Review, ReviewID> {

    @Query("SELECT avg (mark) from Review where movie.id = :id")
    double getAverageMark(@Param(value = "id")int id);
    Review getReviewByMovieAndUser(Movie movie, User user);

}
