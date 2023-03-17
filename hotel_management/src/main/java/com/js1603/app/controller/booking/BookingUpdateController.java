package com.js1603.app.controller.booking;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import com.js1603.app.model.Bill;
import com.js1603.app.model.Room;
import com.js1603.app.model.Service;
import com.js1603.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "BookingUpdateController", value = "/update-booking")
public class BookingUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        int billId = Integer.parseInt(request.getParameter("id"));
        Bill bill = dao.getBillById(billId);
        request.setAttribute("bill", bill);
        request.getRequestDispatcher("./font/Admin_booking_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        String billId = request.getParameter("billId");
        int name = Integer.parseInt(request.getParameter("bookingNameId"));
        int room = Integer.parseInt(request.getParameter("bookingRoomId"));
        String  cki = request.getParameter("bookingCki");
        String  cko = request.getParameter("bookingCkout");
        Bill bill = Bill.builder()
                .billId(billId)
                .user(User.builder().userId(name).build())
                .room(Room.builder().roomId(room).build())
                .checkInDate(cki)
                .checkOutDate(cko)
                .build();
        System.out.println(bill);
        dao.updateBill(bill);
        response.sendRedirect("list-booking");
    }
}
