package com.js1603.app.controller.service;

import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import com.js1603.app.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceListController", value = "/service-list")
public class ServiceListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAOImpl();
        List<Service> serviceList = dao.getAllServices();
        request.setAttribute("list", serviceList);
        request.getRequestDispatcher("./font/Admin_service_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
