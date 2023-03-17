package com.js1603.app.dao;

import com.js1603.app.model.BillService;
import com.js1603.app.model.ServiceItem;

import java.util.List;

public interface ServiceItemDAO {
    public List<ServiceItem> getServiceByBill(int billId);
    public List<BillService> getListBillServiceByBillId(int billId);

    public double summaryServiceByBillId(int billId);
}
