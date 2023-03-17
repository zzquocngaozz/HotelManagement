package com.js1603.app.dao.impl;

import com.js1603.app.dao.ServiceItemDAO;
import com.js1603.app.model.Bill;
import com.js1603.app.model.Service;
import com.js1603.app.model.ServiceItem;
import com.js1603.app.util.DBContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceItemDAOImpl extends DBContext implements ServiceItemDAO {
    @Override
    public List<ServiceItem> getServiceByBill(int billId) {
        List<ServiceItem> itemList = new ArrayList<>();
        String sql = "SELECT si.bill_id, s.* FROM service_item si \n" +
                "JOIN service s \n" +
                "ON si.sevice_id = s.service_id \n" +
                "WHERE si.bill_id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,billId);
            rs = ps.executeQuery();
            while (rs.next()){
                ServiceItem serviceItem = ServiceItem.builder()
                        .bill(Bill.builder().billId(rs.getInt(1)).build())
                        .service(Service.builder().serviceName(rs.getString(3)).servicePrice(rs.getDouble(4)).build())
                        .build();

                itemList.add(serviceItem);

            }
            return itemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServiceItemDAO itemDAO = new ServiceItemDAOImpl();
        List<ServiceItem>list = itemDAO.getServiceByBill(1);
        System.out.println(list);
    }
}
