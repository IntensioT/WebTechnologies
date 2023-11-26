package org.intensio.service.impl;

import org.intensio.DAO.DAOFactory;
import org.intensio.DAO.MovieDAO;
import org.intensio.DAO.ReviewDAO;
import org.intensio.DAO.UserDAO;
import org.intensio.DAO.exception.DatabaseQueryException;
import org.intensio.beans.Movie;
import org.intensio.beans.Review;
import org.intensio.beans.User;
import org.intensio.service.ReviewService;
import org.intensio.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService {

    ReviewDAO reviewDAO = DAOFactory.getInstance().getReviewDAO();
    UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
    MovieDAO movieDAO = DAOFactory.getInstance().getMovieDAO();

    @Override
    public void addOrChangeReview(Movie movie, User user, int mark, String review) throws ServiceException {
        try {

            Optional<Review> userReview = reviewDAO.getReviewByUserAndMovie(movie, user);
            if(userReview.isPresent()){
                Review obj = userReview.get();
                obj.setReview(review);
                obj.setMark(mark);
                reviewDAO.updateReview(obj);
            }
            else{
                reviewDAO.saveReview(
                        Review.builder()
                                .movie_id(movie.getId())
                                .user_id(user.getId())
                                .mark(mark)
                                .review(review)
                                .build()
                );
            }
            movie.setAverageMark(reviewDAO.getAverageMark(movie));
            movieDAO.updateMovieMark(movie);

            //ServiceFactory.getInstance().getUserService().updateRate();

        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Review> getMoviesReviews(Movie movie) throws ServiceException {
        try {
            return reviewDAO.getReviewsByMovie(movie);
        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
