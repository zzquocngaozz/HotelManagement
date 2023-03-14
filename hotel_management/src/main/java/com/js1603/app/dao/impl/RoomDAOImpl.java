package com.js1603.app.dao.impl;

import com.js1603.app.dao.RoomDAO;
import com.js1603.app.model.Room;
import com.js1603.app.util.DBContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl extends DBContext implements RoomDAO {
    @Override
    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        String sql = "SELECT * FROM room";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = Room.builder()
                        .roomId(rs.getInt(1))
                        .roomCode(rs.getString(3))
                        .roomPricePerHour(rs.getDouble(4))
                        .roomDescription(rs.getString(5))
                        .roomStatus(rs.getInt(6))
                        .build();
                roomList.add(room);
            }
            return roomList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addRoom(Room room) {
        String sql = "INSERT INTO `room` (`room_code`, " +
                "`room_price_per_hour`, `room_description`, `room_status`) \n" +
                "VALUES (?,?,?,1);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, room.getRoomCode());
            ps.setDouble(2, room.getRoomPricePerHour());
            ps.setString(3, room.getRoomDescription());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        String sql = "UPDATE `room` SET \n" +
                "`room_code` = ?,\n" +
                "`room_price_per_hour` = ?,\n" +
                "`room_description` = ?,\n" +
                "`room_status` = ? WHERE (`room_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, room.getRoomCode());
            ps.setDouble(2, room.getRoomPricePerHour());
            ps.setString(3, room.getRoomDescription());
            ps.setInt(4, room.getRoomStatus());
            ps.setInt(5, room.getRoomId());
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        String sql = "UPDATE `room` SET `room_status` = 0 WHERE (`room_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomId);
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Room getRoomById(int roomId) {
        String sql = "SELECT * FROM room WHERE room_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = Room.builder()
                        .roomId(rs.getInt(1))
                        .roomCode(rs.getString(3))
                        .roomPricePerHour(rs.getDouble(4))
                        .roomDescription(rs.getString(5))
                        .roomStatus(rs.getInt(6))
                        .build();
                return room;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAOImpl();
//        System.out.println(dao.getAllRooms());
//        Room room = Room.builder()
//                .roomId(7)
//                .roomCode("HM103")
//                .roomPricePerHour(160000)
//                .roomDescription("No description")
//                .roomStatus(1)
//                .build();
//        dao.updateRoom(room);
        dao.deleteRoom(7);
    }
}
