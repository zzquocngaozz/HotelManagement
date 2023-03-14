package com.js1603.app.dao;

import com.js1603.app.model.Service;

import java.util.List;

public interface ServiceDAO {
    public List<Service> getAllServices();
    public boolean addService(Service service);
    public boolean updateService(Service service);
    public boolean changeStatusService(int serviceId, int status);
    public Service getServiceById(int serviceId);
}
