package com.js1603.app.controller.bill;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CheckoutController", value = "/checkout")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        dao.changeStatusBill(id, 1);
        response.sendRedirect("list-booking");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
