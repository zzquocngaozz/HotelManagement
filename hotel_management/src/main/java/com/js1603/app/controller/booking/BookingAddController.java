package com.js1603.app.controller.booking;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.model.Bill;
import com.js1603.app.model.Room;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookingAddController", value = "/add-booking")
public class BookingAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./font/Admin_booking_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
