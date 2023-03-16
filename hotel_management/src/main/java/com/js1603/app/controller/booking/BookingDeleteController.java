package com.js1603.app.controller.booking;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.model.Bill;
import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookingDeleteController", value = "/delete-booking")
public class BookingDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        int billId = Integer.parseInt(request.getParameter("id"));
        dao.DeleteBill(billId);
        response.sendRedirect("list-booking");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
