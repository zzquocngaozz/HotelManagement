package com.js1603.app.controller.user; /**
 * @author VuBQ5
 */

import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListController", value = "/user-list")
public class CustomerListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList= new ArrayList<>();
        userList = userDAO.getAllUser();
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("./font/Admin_account_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
