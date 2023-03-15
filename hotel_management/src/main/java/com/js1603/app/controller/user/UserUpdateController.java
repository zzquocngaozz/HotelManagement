package com.js1603.app.controller.user; /**
 * @author VuBQ5
 */

import com.js1603.app.dao.UserDAO;
import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserUpdateController", value = "/update-user")
public class UserUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO dao = new UserDAOImpl();
        User user = dao.getUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("./font/Admin_account_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAOImpl();
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        int userRole = Integer.parseInt(request.getParameter("userRole"));
        String userDob = request.getParameter("userDob");
        String userPhone = request.getParameter("userPhone");
        int userGender = Integer.parseInt(request.getParameter("userGender"));
        int userStatus = Integer.parseInt(request.getParameter("userStatus"));
        User user = User.builder()
                .userId(userId)
                .userName(userName)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userRole(userRole)
                .userDob(userDob)
                .userPhone(userPhone)
                .userGender(userGender)
                .userStatus(userStatus)
                .build();
        dao.updateUser(user);
        response.sendRedirect("user-list");
    }
}
