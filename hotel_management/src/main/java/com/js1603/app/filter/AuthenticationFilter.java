package com.js1603.app.filter;

import com.js1603.app.dao.UserDAO;
import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter ", urlPatterns = {"/"})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        UserDAO dao = new UserDAOImpl();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        //check account
        User user = (User) session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            //check cookie
            Cookie[] cookies = req.getCookies();
            String emailCookie = null;
            String passwordCookie = null;
            for (Cookie c : cookies) {
                if (c.getName().equals("email")) {
                    emailCookie = c.getValue();
                }
                if (c.getName().equals("password")) {
                    passwordCookie = c.getValue();
                }
                if (emailCookie != null && passwordCookie != null) {
                    break;
                }
            }
            if (emailCookie != null && passwordCookie != null) {
                User user1 = dao.login(emailCookie, passwordCookie);
                if (user1 != null) { // cookie hop le
                    session.setAttribute("employee", user1);
                    session.setMaxInactiveInterval(60 * 60 * 24 * 365);
                    chain.doFilter(request, response);
                    return;
                }
            }
            res.sendRedirect("login");
        }
    }

}
