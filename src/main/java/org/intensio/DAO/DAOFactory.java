package org.intensio.DAO;

import lombok.Getter;
import org.intensio.DAO.impl.MovieDAOImpl;
import org.intensio.DAO.impl.ReviewDAOImpl;
import org.intensio.DAO.impl.UserDAOImpl;

public class DAOFactory {
    private final static DAOFactory Instance;

    static{
        Instance = new DAOFactory();
    }

    private DAOFactory(){
        movieDAO = new MovieDAOImpl();
        userDAO = new UserDAOImpl();
        reviewDAO = new ReviewDAOImpl();
    }

    public static DAOFactory getInstance(){
        return Instance;
    }

    @Getter
    private final MovieDAO movieDAO;
    @Getter
    private final UserDAO userDAO;
    @Getter
    private final ReviewDAO reviewDAO;

}
