package org.intensio.controller.command.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.controller.command.Command;
import org.intensio.service.ServiceFactory;
import org.intensio.service.UserService;
import org.intensio.service.exception.ServiceException;

import java.io.IOException;

/**
 * @author inten
 * @version 0.5
 */
public class AdminPageCommand implements Command {

    UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users",userService.getUsers());
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        }
        return "WEB-INF/view/admin_page.jsp";
    }
}
