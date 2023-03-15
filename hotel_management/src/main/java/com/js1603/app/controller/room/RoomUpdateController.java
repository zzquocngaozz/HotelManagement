package com.js1603.app.controller.room;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.model.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RoomUpdateController", value = "/update-room")
public class RoomUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        Room room = dao.getRoomById(roomId);
        request.setAttribute("room", room);
        request.getRequestDispatcher("").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String roomCode = request.getParameter("roomCode");
        int roomPricePerHour = Integer.parseInt(request.getParameter("roomPricePerHour"));
        String roomDescription = request.getParameter("roomDescription");
        int roomStatus = Integer.parseInt(request.getParameter("roomStatus"));
        Room room = Room.builder()
                .roomId(roomId)
                .roomCode(roomCode)
                .roomPricePerHour(roomPricePerHour)
                .roomDescription(roomDescription)
                .roomStatus(roomStatus)
                .build();
        dao.updateRoom(room);
        response.sendRedirect("room-list");
    }
}
