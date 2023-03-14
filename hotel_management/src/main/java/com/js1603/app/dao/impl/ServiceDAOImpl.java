package com.js1603.app.dao.impl;

import com.js1603.app.dao.ServiceDAO;
import com.js1603.app.model.Service;
import com.js1603.app.util.DBContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl extends DBContext implements ServiceDAO {
    public List<Service> getAllServices() {
        List<Service> serviceList = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Service service = Service.builder()
                        .serviceId(rs.getInt(1))
                        .serviceName(rs.getString(2))
                        .servicePrice(rs.getDouble(3))
                        .serviceDescription(rs.getString(4))
                        .serviceStatus(rs.getInt(5))
                        .build();
                serviceList.add(service);
            }
            return serviceList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addService(Service service) {
        String sql = "INSERT INTO `service` (`service_name`, `service_price`, `service_description`," +
                " `service_status`) VALUES (?,?,?, 1);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getServicePrice());
            ps.setString(3, service.getServiceDescription());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateService(Service service) {
        String sql = "UPDATE `service` \n" +
                "SET `service_name` = ?, `service_price` = ?,\n" +
                " `service_description` = ? WHERE (`service_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getServicePrice());
            ps.setString(3, service.getServiceDescription());
            ps.setInt(4, service.getServiceId());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeStatusService(int serviceId, int status) {
        String sql = "UPDATE `service` SET `service_status` = ? WHERE (`service_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status == 0 ? 1 : 0);
            ps.setInt(2, serviceId);
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Service getServiceById(int serviceId) {
        String sql = "SELECT * FROM service WHERE service_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, serviceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Service service = Service.builder()
                        .serviceId(rs.getInt(1))
                        .serviceName(rs.getString(2))
                        .servicePrice(rs.getDouble(3))
                        .serviceDescription(rs.getString(4))
                        .serviceStatus(rs.getInt(5))
                        .build();
                return service;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ServiceDAOImpl dao = new ServiceDAOImpl();
        System.out.println(dao.getAllServices());
//        Service service = Service.builder()
//                .serviceId(8)
//                .serviceName("Banh Mi")
//                .servicePrice(150000)
//                .serviceDescription("No description")
//                .serviceStatus(1)
//                .build();
//        dao.updateService(service);
//        dao.deleteService(8);
        System.out.println(dao.getServiceById(1));
    }
}
