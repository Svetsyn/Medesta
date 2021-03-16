package com.medesta.service;

import com.medesta.model.service.CustomerServiceModel;

import java.io.IOException;

public interface CustomerService {

    void seedCurrentCustomer() throws IOException;

    void addCustomer(CustomerServiceModel customerServiceModel);
}
