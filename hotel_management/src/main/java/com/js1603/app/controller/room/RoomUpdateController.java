package com.js1603.app.controller.room;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.model.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RoomUpdateController", value = "/room-update")
public class RoomUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        int roomId = Integer.parseInt(request.getParameter("id"));
        Room room = dao.getRoomById(roomId);
        request.setAttribute("room", room);
        request.getRequestDispatcher("./font/Admin_room_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        int roomId = Integer.parseInt(request.getParameter("id"));
        String roomCode = request.getParameter("roomCode");
        double roomPricePerHour = Double.parseDouble(request.getParameter("roomPricePerHour"));
        String roomDescription = request.getParameter("roomDescription");
        Room room = Room.builder()
                .roomId(roomId)
                .roomCode(roomCode)
                .roomPricePerHour(roomPricePerHour)
                .roomDescription(roomDescription)
                .build();
        dao.updateRoom(room);
        response.sendRedirect("room-list");
    }
}
