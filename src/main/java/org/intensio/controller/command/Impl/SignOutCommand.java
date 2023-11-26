package org.intensio.controller.command.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.intensio.beans.Attributes;
import org.intensio.beans.Role;
import org.intensio.controller.command.Command;

import java.io.IOException;

public class SignOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(Attributes.USER_PRINCIPAL);
        request.setAttribute("role", Role.NOT_AUTH.toString());
        return "index.jsp";
    }
}
