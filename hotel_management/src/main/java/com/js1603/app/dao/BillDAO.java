package com.js1603.app.dao;

import com.js1603.app.model.Bill;
import com.js1603.app.model.BillRoom;
import com.js1603.app.model.Room;
import com.js1603.app.model.Service;

import java.util.List;

public interface BillDAO {
    public List<Bill> getAllBill();
    public boolean addBill(Bill bill);
    public boolean updateBill(Bill bill);
    public boolean changeStatusBill(int billId, int status);
    public Bill getBillById(int billId);
    public boolean addServiceToBill(int billId, int serviceId);
    public void DeleteBill(int billId);
    public int getNumberBills();
    public int getNumberService();
    public BillRoom showBillRoomByBillId(int billId);
}
