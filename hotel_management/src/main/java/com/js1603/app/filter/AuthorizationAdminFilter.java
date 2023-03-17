package com.js1603.app.filter;

import com.js1603.app.dao.UserDAO;
import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthorizationAdminFilter",
        urlPatterns = {"/user-list", "/add-user", "/delete-user", "/update-user", "/home-dash-board"})

public class AuthorizationAdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        UserDAO dao = new UserDAOImpl();

        HttpSession session = req.getSession();
        //check account
        User user = (User) session.getAttribute("user");
        if (user != null && user.getUserRole() == 1) {
            chain.doFilter(request, response);
        }
        else {
            res.sendRedirect("error");
        }

    }
}
