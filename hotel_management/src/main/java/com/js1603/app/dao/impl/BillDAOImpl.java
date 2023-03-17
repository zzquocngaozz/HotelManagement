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
        String sql = "SELECT \n" +
                "b.bill_id,\n" +
                "u.user_name,\n" +
                "u.user_phone,\n" +
                "r.room_code,\n" +
                "b.check_in_date,\n" +
                "b.check_out_date,\n" +
                "b.bill_pre_price,\n" +
                "b.bill_status\n" +
                "FROM user u JOIN bill b\n" +
                "\tON u.user_id = b.user_id\n" +
                "    JOIN room r ON r.room_id = b.room_id;";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = Bill.builder()
                        .billId(rs.getInt(1))
                        .user(User.builder().userName(rs.getString(2)).userPhone(rs.getString(3)).build())
                        .room(Room.builder().roomCode(rs.getString(4)).build())
                        .checkInDate(rs.getString(5))
                        .checkOutDate(rs.getString(6))
                        .billPrePrice(rs.getDouble(7))
                        .billStatus(rs.getInt(8))
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

        String sql = "INSERT INTO `hotel_management`.`bill` " +
                "(`check_in_date`, `check_out_date`, `room_id`, `user_id`) VALUES (?, ?, ?, ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, bill.getCheckInDate());
            ps.setString(2, bill.getCheckOutDate());
            ps.setInt(3, bill.getRoom().getRoomId());
            ps.setInt(4, bill.getUser().getUserId());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBill(Bill bill) {
        String sql = "UPDATE `hotel_management`.`bill`  SET  `check_out_date` = ?," +
                " `bill_pre_price` = ? WHERE (`bill_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, bill.getCheckOutDate());
            ps.setDouble(2, bill.getBillPrePrice());
            ps.setInt(3, bill.getBillId());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean changeStatusBill(int billId, int status) {
        String sql = "UPDATE `hotel_management`.`bill`\n" +
                "SET`bill_status` = ?\n" +
                "WHERE `bill_id` = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status == 0 ? 1 : 0);
            ps.setInt(2, billId);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bill getBillById(int billId) {
        String sql = "SELECT \n" +
                "\tu.user_name,\n" +
                "    r.room_code,\n" +
                "    b.check_in_date,\n" +
                "\tb.check_out_date,\n" +
                "\tb.bill_pre_price,\n" +
                "    b.bill_id\n" +
                "FROM user u JOIN bill b\n" +
                "\tON u.user_id = b.user_id\n" +
                "    JOIN room r ON r.room_id = b.room_id\n" +
                "    WHERE b.bill_id = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = Bill.builder()
                        .billId(rs.getInt(6))
                        .user(User.builder().userName(rs.getString(1)).build())
                        .room(Room.builder().roomCode(rs.getString(2)).build())
                        .checkInDate(rs.getString(3))
                        .checkOutDate(rs.getString(4))
                        .billPrePrice(rs.getDouble(5))
                        .build();
                return bill;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean addServiceToBill(int billId, int serviceId) {
        String sql = "INSERT INTO `hotel_management`.`service_item`\n" +
                "(`bill_id`,\n" +
                "`sevice_id`)\n" +
                "VALUES\n" +
                "(?,?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, billId);
            ps.setInt(2,serviceId);
            return  ps.executeUpdate() ==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public int getNumberBills() {
        String sql = "SELECT COUNT(*) FROM bill WHERE bill_status = 1";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getNumberService() {
        String sql = "SELECT COUNT(*) FROM service WHERE service_status = 1";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        BillDAOImpl dao = new BillDAOImpl();
        System.out.println(dao.getAllBill());
    }
}
