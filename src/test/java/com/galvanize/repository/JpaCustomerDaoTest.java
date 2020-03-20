package com.galvanize.repository;

import com.galvanize.entities.Customers;
import com.galvanize.repositories.JpaCustomerDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class JpaCustomerDaoTest {
    @Autowired
    JpaCustomerDao jpaCustomerDao;

    @Test
    public void save(){
        Customers customers = new Customers(Timestamp.valueOf(LocalDateTime.now()), "Test Customer", "123 Some Address", "+1-234-567-890", "This is a test request.");
        Customers save = jpaCustomerDao.save(customers);
        assertEquals(1, save.getRequestNumber());
    }
}
