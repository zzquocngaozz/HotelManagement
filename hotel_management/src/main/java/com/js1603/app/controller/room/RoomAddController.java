package com.js1603.app.controller.room;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.model.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RoomAddController", value = "/room-add")
public class RoomAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./font/Admin_room_add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        String roomCode = request.getParameter("roomCode");
        double roomPricePerHour = Double.parseDouble(request.getParameter("roomPricePerHour"));
        String roomDescription = request.getParameter("roomDescription");
        Room room = Room.builder()
                .roomCode(roomCode)
                .roomPricePerHour(roomPricePerHour)
                .roomDescription(roomDescription)
                .build();
        dao.addRoom(room);
        response.sendRedirect("room-list");
    }
}
