package com.js1603.app.controller.service;

import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import com.js1603.app.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServiceUpdateController", value = "/service-update")
public class ServiceUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAOImpl();
        int serviceId = Integer.parseInt(request.getParameter("id"));
        Service service = dao.getServiceById(serviceId);
        request.setAttribute("service", service);
        request.getRequestDispatcher("./font/Admin_service_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAOImpl();
        int serviceId = Integer.parseInt(request.getParameter("id"));
        String serviceName = request.getParameter("serviceName");
        double servicePrice = Double.parseDouble(request.getParameter("servicePrice"));
        String serviceDescription = request.getParameter("serviceDescription");
        Service service = Service.builder()
                .serviceId(serviceId)
                .serviceName(serviceName)
                .servicePrice(servicePrice)
                .serviceDescription(serviceDescription)
                .build();
        dao.updateService(service);
        response.sendRedirect("service-list");
    }
}
