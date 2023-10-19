package dev.luke.chapter2.service;

import dev.luke.chapter2.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() {
        // TODO 初始化数据库
        // 但是 @Before 注解标记的方法会在每个测试方法执行前都执行一次，
        // 初始化数据库放在这里，是不是不太合适呢 🤔
    }

    @Test
    public void testGetCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }
}
