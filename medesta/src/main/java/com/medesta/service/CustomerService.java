package com.medesta.service;

import com.medesta.model.entity.Customer;
import com.medesta.model.service.CustomerServiceModel;

import java.io.IOException;
import java.util.Optional;

public interface CustomerService {

    void seedCurrentCustomer() throws IOException;

    void addCustomer(CustomerServiceModel customerServiceModel);

    Customer findCustomerByFirstName(String firstName);
}
