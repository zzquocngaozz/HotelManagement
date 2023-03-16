package com.js1603.app.controller.booking;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.model.Bill;
import com.js1603.app.model.Room;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookingAddController", value = "/add-booking")
public class BookingAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./font/Admin_booking_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        String bookingName = request.getParameter("bookingName");
        String bookingCki = request.getParameter("bookingCki");
        String bookingCko = request.getParameter("bookingCkout");
        String bookingPayment = request.getParameter("bookingPayment");
        String bookingRoom = request.getParameter("bookingRoom");

        Bill bill = Bill.builder()
                .billPrePrice(Double.parseDouble(bookingPayment))
                .checkInDate(bookingCki)
                .checkOutDate(bookingCko)
                .room(Room.builder().roomId(Integer.parseInt(bookingRoom)).build())
                .user(User.builder().userId(Integer.parseInt(bookingName)).build())
                .build();
        System.out.println(bill);
        dao.addBill(bill);
        response.sendRedirect("list-booking");
    }
}
