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

@WebServlet(name = "UserAddController", value = "/add-user")
public class UserAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./font/Admin_account_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAOImpl();
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        int userRole = Integer.parseInt(request.getParameter("userRole"));
        String userDob = request.getParameter("userDob");
        String userPhone = request.getParameter("userPhone");
        int userGender = Integer.parseInt(request.getParameter("userGender"));
        int userStatus = Integer.parseInt(request.getParameter("userStatus"));
        User user = User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userRole(userRole)
                .userDob(userDob)
                .userPhone(userPhone)
                .userGender(userGender)
                .userStatus(userStatus)
                .build();
        dao.addUser(user);
        response.sendRedirect("user-list");
    }
}
