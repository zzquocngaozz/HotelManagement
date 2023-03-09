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
        String sql = "SELECT * FROM room WHERE room_status = 1";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = Room.builder()
                        .roomId(rs.getInt(1))
                        .roomType(rs.getInt(2))
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
        String sql = "INSERT IINSERT INTO `room` (`room_type`, `room_code`, " +
                "`room_price_per_hour`, `room_description`, `room_status`) \n" +
                "VALUES (?,?,?,?,?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, room.getRoomType());
            ps.setString(2, room.getRoomCode());
            ps.setDouble(3, room.getRoomPricePerHour());
            ps.setString(4, room.getRoomDescription());
            ps.setInt(5, 1);
            return ps.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        String sql = "UPDATE `room` SET \n" +
                "`room_type` = ?,\n" +
                "`room_code` = ?,\n" +
                "`room_price_per_hour` = ?,\n" +
                "`room_description` = ?,\n" +
                "`room_status` = ? WHERE (`room_id` = ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, room.getRoomType());
            ps.setString(2, room.getRoomCode());
            ps.setDouble(3, room.getRoomPricePerHour());
            ps.setString(4, room.getRoomDescription());
            ps.setInt(5, 1);
            ps.setInt(6, room.getRoomId());
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
}
