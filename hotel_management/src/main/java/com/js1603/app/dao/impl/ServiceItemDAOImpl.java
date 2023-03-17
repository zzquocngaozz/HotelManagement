package com.js1603.app.dao.impl;

import com.js1603.app.dao.ServiceItemDAO;
import com.js1603.app.model.Bill;
import com.js1603.app.model.BillService;
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

    @Override
    public List<BillService> getListBillServiceByBillId(int billId) {
        List<BillService> list = new ArrayList<>();
        String sql = "SELECT\n" +
                "\tb.bill_id,\n" +
                "    s.service_name,\n" +
                "    s.service_price\n" +
                "FROM service s JOIN service_item si\n" +
                "\tON s.service_id = si.sevice_id\n" +
                "    JOIN bill b ON b.bill_id = si.bill_id WHERE b.bill_id = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,billId);
            rs = ps.executeQuery();
            while (rs.next()){
                BillService billService = BillService.builder()
                        .billId(rs.getInt(1))
                        .serviceName(rs.getString(2))
                        .servicePrice(rs.getDouble(3))
                        .build();
                list.add(billService);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double summaryServiceByBillId(int billId) {
        String sql = "SELECT\n" +
                "\tSUM(s.service_price)\n" +
                "FROM service s JOIN service_item si\n" +
                "\tON s.service_id = si.sevice_id\n" +
                "    JOIN bill b ON b.bill_id = si.bill_id WHERE b.bill_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,billId);
            rs = ps.executeQuery();
            while (rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        ServiceItemDAO itemDAO = new ServiceItemDAOImpl();
//        List<ServiceItem>list = itemDAO.getServiceByBill(1);
//        System.out.println(list);
        System.out.println(itemDAO.getServiceByBill(1));
    }
}
