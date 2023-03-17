package com.js1603.app.controller.homepage;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.UserDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.UserDAOImpl;
import com.js1603.app.model.Bill;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HomeDashBoard", value = "/home-dash-board")
public class HomeDashBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAOImpl();
        BillDAO daob = new BillDAOImpl();
        int numberUser = dao.getUserNumber();
        int numberBill = daob.getNumberBills();
        int numberService = daob.getNumberService();

        request.setAttribute("numberUser", numberUser);
        request.setAttribute("numberBill", numberBill);
        request.setAttribute("numberService", numberService);

        request.getRequestDispatcher("./font/Home_dash_board.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
