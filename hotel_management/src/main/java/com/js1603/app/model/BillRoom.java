package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class BillRoom {
    private int billId;
    private String roomCode;
    private double roomPricePerHour;
    private int hourIn;
    private double billPrePrice;
    private double summaryRoom;
}
