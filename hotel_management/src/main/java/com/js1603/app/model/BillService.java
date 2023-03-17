package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class BillService {
    private int billId;
    private String serviceName;
    private double servicePrice;
}
