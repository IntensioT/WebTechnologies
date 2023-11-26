package org.intensio.service.impl;

import org.intensio.DAO.DAOFactory;
import org.intensio.DAO.MovieDAO;
import org.intensio.DAO.exception.DatabaseQueryException;
import org.intensio.beans.Movie;
import org.intensio.service.MovieService;
import org.intensio.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    MovieDAO movieDAO = DAOFactory.getInstance().getMovieDAO();

    private final int MOVIES_FOR_PAGE = 3;

    @Override
    public List<Movie> getMovies(int pageInd) throws ServiceException {
        List<Movie> res;
        try{
            pageInd *= MOVIES_FOR_PAGE;
            res = movieDAO.getMovies();
            int lastMovie = pageInd + MOVIES_FOR_PAGE;
            if( lastMovie >= res.size()){
                lastMovie = res.size();
            }
            res = res.subList(pageInd,lastMovie);

        }
        catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
        return res;
    }

    @Override
    public Optional<Movie> getMovieByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Movie> getMovieById(int id) throws ServiceException {
        try{
            return movieDAO.getMovieById(id);
        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int getPageCount() throws ServiceException {
        try{
            int size = movieDAO.getMovies().size();
            if(size % MOVIES_FOR_PAGE == 0){
                return size / MOVIES_FOR_PAGE - 1;
            }
            return size / MOVIES_FOR_PAGE;
        }
        catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
