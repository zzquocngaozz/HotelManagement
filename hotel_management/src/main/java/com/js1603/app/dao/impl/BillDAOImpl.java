package com.js1603.app.dao.impl;

import com.js1603.app.dao.BillDAO;
import com.js1603.app.model.Bill;
import com.js1603.app.model.Room;
import com.js1603.app.model.Service;
import com.js1603.app.model.User;
import com.js1603.app.util.DBContext;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl extends DBContext implements BillDAO {
    @Override
    public List<Bill> getAllBill() {
        List<Bill> billList = new ArrayList<>();
        String sql = "SELECT bill_id, user_name, user_phone,room_code, bill_pre_price, check_in_date, check_out_date FROM bill join user\n" +
                "on bill.user_id = user.user_id\n" +
                "join room\n" +
                "on bill.room_id = room.room_id";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = Bill.builder()
                        .billId(rs.getString(1))
                        .user(User.builder().userName(rs.getString(2)).userPhone(rs.getString(3)).build())
                        .room(Room.builder().roomCode(rs.getString(4)).build())
                        .billPrePrice(rs.getDouble(5))
                        .checkInDate(rs.getString(6))
                        .checkOutDate(rs.getString(7))
                        .build();
                billList.add(bill);
            }

            System.out.println(billList);
            return billList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addBill(Bill bill) {

        String sql = "INSERT INTO `hotel_management`.`bill`\n" +
                "(`check_in_date`,\n" +
                "`check_out_date`,\n" +
                "`bill_pre_price`,\n" +
                "`room_id`,\n" +
                "`user_id`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?);\n";
        try {
            ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(bill.getCheckInDate()+" 00:00:00"));
            ps.setTimestamp(2, Timestamp.valueOf(bill.getCheckOutDate()+" 00:00:00"));
            ps.setDouble(3, bill.getBillPrePrice());
            ps.setInt(4, bill.getUser().getUserId());
            ps.setInt(5, bill.getRoom().getRoomId());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBill(Bill bill) {

        System.out.println("update bill " + bill);
        String sql = "UPDATE `hotel_management`.`bill`\n" +
                "SET\n" +
                "`check_in_date` = ?, " +
                "`check_out_date` = ?, " +
                "`room_id` = ?, " +
                "`user_id` = ? " +
                "WHERE `bill_id` = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(bill.getCheckInDate()+ " 00:00:00"));
            ps.setTimestamp(2, Timestamp.valueOf(bill.getCheckOutDate()+ " 00:00:00"));
            ps.setInt(3, bill.getRoom().getRoomId());
            ps.setInt(4, bill.getUser().getUserId());
            ps.setInt(5, Integer.parseInt(bill.getBillId()));
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean changeStatusBill(int billId, int status) {
        return false;
    }

    @Override
    public Bill getBillById(int billId) {
        String sql = "SELECT * FROM bill WHERE bill_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = Bill.builder()
                        .billId(rs.getInt(1)+ "" )
                        .user(User.builder().userId(rs.getInt(5)).build())
                        .room(Room.builder().roomId(rs.getInt(6)).build())
                        .checkInDate(rs.getString(2))
                        .checkOutDate(rs.getString(3))
                        .build();
                return bill;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void DeleteBill(int billId) {
        String sql = "DELETE FROM `hotel_management`.`bill`\n" +
                "WHERE bill_id = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, billId);
            ps.executeUpdate() ;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BillDAOImpl dao = new BillDAOImpl();
        System.out.println(dao.getAllBill());
//        Service service = Service.builder()
//                .serviceId(8)
//                .serviceName("Banh Mi")
//                .servicePrice(150000)
//                .serviceDescription("No description")
//                .serviceStatus(1)
//                .build();
//        dao.updateService(service);
//        dao.deleteService(8);
        System.out.println(dao.getBillById(1));
    }
}
