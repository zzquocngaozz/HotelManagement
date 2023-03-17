package com.js1603.app.controller.homepage;

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

@WebServlet(name = "HomePageRoom", value = "/home-page-room")
public class HomePageRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAOImpl();
        List<Room> listRooms = dao.getRoomByStatus(1);
        request.setAttribute("list", listRooms);
        request.getRequestDispatcher("./font/Home_page_room.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        RoomDAO daor = new RoomDAOImpl();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("error");
            return;
        }

        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        int roomId = Integer.parseInt(request.getParameter("roomId"));

        Bill bill = Bill.builder()
                .checkInDate(checkin)
                .checkOutDate(checkout)
                .room(Room.builder().roomId(roomId).build())
                .user(User.builder().userId(user.getUserId()).build())
                .build();

        daor.changeStatusRoom(roomId, 1);

        dao.addBill(bill);
        response.sendRedirect("home-page-room");
    }
}
