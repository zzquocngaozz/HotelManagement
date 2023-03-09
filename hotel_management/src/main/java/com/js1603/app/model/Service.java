package com.js1603.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Service {
    private int serviceId;
    private String serviceName;
    private double servicePrice;
    private String serviceDescription;
    private int serviceStatus;
}
