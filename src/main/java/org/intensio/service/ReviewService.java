package org.intensio.service;

import org.intensio.beans.Movie;
import org.intensio.beans.Review;
import org.intensio.beans.User;
import org.intensio.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {

    /**
     *
     * @param movie
     * @param user
     * @param mark
     * @param review
     * @throws ServiceException
     */
    void addOrChangeReview(Movie movie, User user, int mark, String review) throws ServiceException;

    /**
     *
     * @param movie
     * @return
     * @throws ServiceException
     */
    List<Review> getMoviesReviews(Movie movie) throws ServiceException;
}
