package dev.luke.chapter2.service;

import dev.luke.chapter2.helper.DatabaseHelper;
import dev.luke.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList() {
        String sql = "SELECT id,name,contact,telephone,email,remark FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }
}
