package com.js1603.app.controller.bill;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.RoomDAO;
import com.js1603.app.dao.ServiceItemDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.RoomDAOImpl;
import com.js1603.app.dao.impl.ServiceItemDAOImpl;
import com.js1603.app.model.Bill;
import com.js1603.app.model.BillRoom;
import com.js1603.app.model.BillService;
import com.js1603.app.model.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BillController", value = "/bill")
public class BillController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO dao = new BillDAOImpl();
        ServiceItemDAO daoi = new ServiceItemDAOImpl();
        int id = Integer.parseInt(request.getParameter("id"));

        Bill bill = dao.getBillById(id);

        BillRoom billRoom = dao.showBillRoomByBillId(id);
        List<BillService> billServiceList = daoi.getListBillServiceByBillId(id);
        double summaryService = daoi.summaryServiceByBillId(id);
        double totalAll = summaryService + billRoom.getSummaryRoom() - bill.getBillPrePrice();

        request.setAttribute("billRoom", billRoom);
        request.setAttribute("billServiceList", billServiceList);
        request.setAttribute("summaryService", summaryService);
        request.setAttribute("total", totalAll);

        request.getRequestDispatcher("./font/Admin_booking_view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
