package com.js1603.app.dao;

import com.js1603.app.model.Bill;

import java.util.List;

public interface BillDAO {
    public List<Bill> getAllBill();
    public boolean addBill(Bill bill);
    public boolean updateBill(Bill bill);
    public boolean changeStatusBill(int billId, int status);
    public Bill getBillById(int billId);

    public void DeleteBill(int billId);
}
