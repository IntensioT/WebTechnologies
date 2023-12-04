package org.intensio.service.impl;

import org.intensio.DAO.MovieDAO;
import org.intensio.DAO.ReviewDAO;
import org.intensio.DAO.exception.DatabaseQueryException;
import org.intensio.beans.Movie;
import org.intensio.beans.Review;
import org.intensio.beans.User;
import org.intensio.service.ReviewService;
import org.intensio.service.exception.ServiceException;
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
        try {

            Optional<Review> userReview = reviewDAO.getReviewByUserAndMovie(movie, user);
            if(userReview.isPresent()){
                Review obj = userReview.get();
                obj.setReview(review);
                obj.setMark(mark);
                reviewDAO.saveReview(obj, false);
            }
            else{
                reviewDAO.saveReview(
                        Review.builder()
                                .movie(movie)
                                .user(user)
                                .mark(mark)
                                .review(review)
                                .build()
                , true);
            }
            movie.setAverageMark(reviewDAO.getAverageMark(movie));
            movieDAO.updateMovieMark(movie);


        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
