package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Bill {
    private String billId;
    private String checkInDate;
    private String checkOutDate;
    private double billPrePrice;
    private Room room;
    private User user;
}
