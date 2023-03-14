package com.js1603.app.controller.room;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.model.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomListController", value = "/room-list")
public class RoomListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        List<Room> roomList = dao.getAllRooms();

        request.setAttribute("list", roomList);
        request.getRequestDispatcher("./font/Admin_booking_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
