package com.js1603.app.controller.room;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.impl.RoomDAOImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RoomDeleteController", value = "/room-delete")
public class RoomDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        int roomId = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        dao.changeStatusRoom(roomId, status);
        response.sendRedirect("room-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
