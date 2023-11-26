package org.intensio.controller.command.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.controller.command.Command;
import org.intensio.service.ServiceFactory;
import org.intensio.service.UserService;
import org.intensio.service.exception.ServiceException;

import java.io.IOException;

public class DeleteCommand implements Command {

    UserService userService = ServiceFactory.getInstance().getUserService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            userService.deleteUser(Integer.parseInt(request.getParameter("id")));
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        }
        return null;
    }
}
