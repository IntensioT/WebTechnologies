package org.intensio.controller.command.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.beans.Attributes;
import org.intensio.beans.Movie;
import org.intensio.beans.User;
import org.intensio.beans.UserPrincipal;
import org.intensio.controller.command.Command;
import org.intensio.service.ReviewService;
import org.intensio.service.ServiceFactory;
import org.intensio.service.UserService;
import org.intensio.service.exception.ServiceException;

import java.io.IOException;
import java.util.Optional;

public class ReviewCommand implements Command {

    UserService userService = ServiceFactory.getInstance().getUserService();
    ReviewService reviewService = ServiceFactory.getInstance().getReviewService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserPrincipal userPrincipal = (UserPrincipal) request.getSession().getAttribute(Attributes.USER_PRINCIPAL);
        int mark = Integer.parseInt(request.getParameter("mark"));
        String review = request.getParameter("review");
        try {
            Optional<User> user = userService.getUserByUsername(userPrincipal.getUsername());
            if(user.isEmpty()){
                return "WEB-INF/view/signIn.jsp";
            }
            reviewService.addOrChangeReview((Movie) request.getSession().getAttribute(Attributes.MOVIE),user.get(),mark,review);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
