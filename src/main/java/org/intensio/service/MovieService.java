package org.intensio.service;

import org.intensio.beans.Movie;
import org.intensio.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    /**
     *
     * @param pageInd
     * @return
     * @throws ServiceException
     */
    List<Movie> getMovies(int pageInd) throws ServiceException;

    /**
     *
     * @param name
     * @return
     */
    Optional<Movie> getMovieByName(String name);

    /**
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Optional<Movie> getMovieById(int id) throws ServiceException;

    /**
     *
     * @return
     * @throws ServiceException
     */
    int getPageCount() throws ServiceException;
}
