package com.intensio.service;

import com.intensio.beans.Movie;
import com.intensio.beans.User;
import com.intensio.service.exception.ServiceException;

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

}
