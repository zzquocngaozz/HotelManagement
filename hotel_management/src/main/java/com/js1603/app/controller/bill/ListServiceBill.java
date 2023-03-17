package com.js1603.app.controller.bill;
/**
 * @author VuBQ5
 */

import com.js1603.app.dao.ServiceItemDAO;
import com.js1603.app.dao.impl.ServiceItemDAOImpl;
import com.js1603.app.model.ServiceItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServiceBill", value = "/list_service_by_bill")
public class ListServiceBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int billId = Integer.parseInt(request.getParameter("id"));
        ServiceItemDAO dao = new ServiceItemDAOImpl();
        List<ServiceItem> itemList = dao.getServiceByBill(billId);
        HttpSession session = request.getSession();
        session.setAttribute("billId",billId);
        request.setAttribute("itemList",itemList);
        request.getRequestDispatcher("./font/Admin_list_service_by_bill.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
