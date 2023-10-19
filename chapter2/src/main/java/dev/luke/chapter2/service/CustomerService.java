package dev.luke.chapter2.service;

import dev.luke.chapter2.helper.DatabaseHelper;
import dev.luke.chapter2.model.Customer;
import dev.luke.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id,name,contact,telephone,email,remark FROM customer";
        Connection connection = DatabaseHelper.openConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error("execute sql failure.", e);
        } finally {
            DatabaseHelper.closeConnection(connection);
        }
        return customers;
    }
}
