package com.medesta.service.impl;

import com.medesta.model.entity.Customer;
import com.medesta.model.enums.CustomerCategory;
import com.medesta.model.service.CustomerServiceModel;
import com.medesta.repository.CustomerRepository;
import com.medesta.service.CustomerService;
import com.medesta.utils.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.medesta.constant.Constant.CUSTOMER_CURRENT_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final FileUtil fileUtil;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(FileUtil fileUtil, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCurrentCustomer() throws IOException {

        if (customerRepository.count() == 0) {
            String[] fileLine = fileUtil.readFileContent(CUSTOMER_CURRENT_PATH);


            for (String line : fileLine) {

                String[] token = line.split("\\s+");
                String firstName = token[0];
                String lastName = token[1];
                String email = token[2];
                String phone = token[3];
                String category = token[4];

                CustomerCategory customerCategory = checkCategory(category);

                Customer customer = new Customer(firstName, lastName, email, phone, customerCategory);

                customerRepository.save(customer);
            }
        }
    }

    private CustomerCategory checkCategory(String category) {
        if (category.equals("GOOD")) {
            return CustomerCategory.GOOD;
        }
        if (category.equals("REGULAR")) {
            return CustomerCategory.REGULAR;
        }
        return CustomerCategory.VIP;
    }

    @Override
    public void addCustomer(CustomerServiceModel customerServiceModel) {

        Customer customer = modelMapper.map(customerServiceModel, Customer.class);

        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByFirstName(String firstName) {
        return null;
    }

}

