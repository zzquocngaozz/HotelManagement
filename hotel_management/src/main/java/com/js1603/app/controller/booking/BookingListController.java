package com.js1603.app.controller.booking;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.model.Bill;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookingListController", value = "/list-booking")
public class BookingListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO billDAO = new BillDAOImpl();
        List<Bill> billList = billDAO.getAllBill();
        System.out.println(billList);
        request.setAttribute("list", billList);
        request.getRequestDispatcher("./font/Admin_booking_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
