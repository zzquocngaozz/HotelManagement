package com.js1603.app.controller.service;

import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.dao.impl.ServiceDAOImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServiceDeleteController", value = "/service-delete")
public class ServiceDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAOImpl();
        int serviceId = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        dao.changeStatusService(serviceId, status);
        response.sendRedirect("service-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
