package com.js1603.app.controller.authentication;

import com.js1603.app.dao.UserDAO;
import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAOImpl();
        HttpSession session = request.getSession();
        Cookie cookie[] = request.getCookies();
        String email = null, password = null;
        for (Cookie c : cookie) {
            if (c.getName().equals("email")) {
                email = c.getValue();
            }
            if (c.getName().equals("password")) {
                password = c.getValue();
            }
        }

        if (email != null && password != null) {
            User user = dao.login(email, password);
            if (user != null) {
                session.setAttribute("user", user);
                int role = user.getUserRole();
                if (role == 1) {
                    response.sendRedirect("");
                } else if (role == 2) {
                    response.sendRedirect("");
                } else if (role == 3) {
                    response.sendRedirect("");
                }
                return;
            } else {
                request.getRequestDispatcher("./font/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("./font/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO dao = new UserDAOImpl();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") != null;// #null = false else true
        User user = dao.login(email, password);
        if (user != null) {
            if (remember) {
                Cookie emailCookie = new Cookie("email", user.getUserEmail());
                emailCookie.setMaxAge(60 * 60 * 24 * 365);
                Cookie passwordCookie = new Cookie("password", user.getUserPassword());
                passwordCookie.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(emailCookie);
                response.addCookie(passwordCookie);
            }
            session.setAttribute("user", user);
            int role = user.getUserRole();
            if (role == 1) {
                response.sendRedirect("");
            } else if (role == 2) {
                response.sendRedirect("");
            } else if (role == 3) {
                response.sendRedirect("");
            }
        } else {
            request.setAttribute("error", "Email or password incorrect");
            request.setAttribute("email", email);
            request.getRequestDispatcher("./font/login.jsp").forward(request, response);
        }

    }
}
