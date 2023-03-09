package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Room {
    private int roomId;
    private int roomType;
    private String roomCode;
    private double roomPricePerHour;
    private String roomDescription;
    private int roomStatus;
}
