package org.intensio.controller.command.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.controller.command.Command;

import java.io.IOException;

public class SignInPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "WEB-INF/view/signIn.jsp";
    }
}
