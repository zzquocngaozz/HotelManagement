package com.js1603.app.dao;

import com.js1603.app.model.Room;

import java.util.List;

public interface RoomDAO {
    public List<Room> getAllRooms();
    public boolean addRoom(Room room);
    public boolean updateRoom(Room room);
    public boolean deleteRoom(int roomId);

    Room getRoomById(int roomId);
}
