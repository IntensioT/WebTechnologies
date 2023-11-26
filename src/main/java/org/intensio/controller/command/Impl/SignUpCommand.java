package org.intensio.controller.command.Impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.beans.Attributes;
import org.intensio.beans.UserPrincipal;
import org.intensio.controller.command.Command;
import org.intensio.service.ServiceFactory;
import org.intensio.service.UserService;
import org.intensio.service.exception.AlreadyExistException;
import org.intensio.service.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;


public class SignUpCommand implements Command {

    UserService userService = ServiceFactory.getInstance().getUserService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = new HashMap<>();
        String email = request.getParameter("email");
        if (email == null || email.length() == 0) {
            errors.put("email", "Incorrect email");
        }
        String password = request.getParameter("password");
        if (password == null || password.length() < 3) {
            errors.put("password", "Incorrect password, length should be more then 8");
        }
        String username = request.getParameter("username");
        if (username == null || username.length() < 3) {
            errors.put("username", "Incorrect username, length should be more then 8");
        }
        try {
            UserPrincipal newUser = userService.newUser(email,password,username);
            request.getSession().setAttribute(Attributes.USER_PRINCIPAL, newUser);
            request.setAttribute("role", newUser.getRole().toString());
            return "index.jsp";
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        } catch (AlreadyExistException e) {
            errors.put("error", "User already exist");
        }
        request.setAttribute("errors", errors);
        return "WEB-INF/view/signIn.jsp";
    }
}
