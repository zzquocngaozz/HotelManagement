package com.js1603.app.controller.bill;
/**
 * @author VuBQ5
 */

import com.js1603.app.dao.BillDAO;
import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.BillDAOImpl;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import com.js1603.app.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServiceToBill", value = "/add-service-to-bill")
public class AddServiceToBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int billId = Integer.parseInt(request.getParameter("id"));
        ServiceDAO dao = new ServiceDAOImpl();
        List<Service> list = dao.getAllActiveServices();
        request.setAttribute("billId",billId);
        request.setAttribute("list", list);
        request.getRequestDispatcher("./font/Add_service_bill.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int billId = Integer.parseInt(request.getParameter("billNumber"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        BillDAO billDAO = new BillDAOImpl();
        billDAO.addServiceToBill(billId,serviceId);
        response.sendRedirect("list_service_by_bill?id="+billId);
    }
}
