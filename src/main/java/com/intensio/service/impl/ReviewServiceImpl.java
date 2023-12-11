package com.intensio.service.impl;

import com.intensio.DAO.MovieDAO;
import com.intensio.DAO.ReviewDAO;
import com.intensio.beans.Movie;
import com.intensio.beans.Review;
import com.intensio.beans.User;
import com.intensio.service.ReviewService;
import com.intensio.service.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDAO reviewDAO;
    private final MovieDAO movieDAO;

    public ReviewServiceImpl(ReviewDAO reviewDAO, MovieDAO movieDAO) {
        this.reviewDAO = reviewDAO;
        this.movieDAO = movieDAO;
    }

    @Override
    public void addOrChangeReview(Movie movie, User user, int mark, String review) throws ServiceException {
        Optional<Review> userReview = Optional.ofNullable(reviewDAO.getReviewByMovieAndUser(movie, user));
        if(userReview.isPresent()){
            Review obj = userReview.get();
            obj.setReview(review);
            obj.setMark(mark);
            reviewDAO.save(obj);
        }
        else{
            reviewDAO.save(
                    Review.builder()
                            .movie(movie)
                            .user(user)
                            .mark(mark)
                            .review(review)
                            .build());
        }
        movie.setAverageMark(reviewDAO.getAverageMark(movie.getId()));
        movieDAO.save(movie);
    }
}
