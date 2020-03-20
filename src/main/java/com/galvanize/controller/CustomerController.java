package com.galvanize.controller;

import com.galvanize.entities.Customers;
import com.galvanize.repositories.JdbcCustomerDao;
import com.galvanize.repositories.JpaCustomerDao;
import com.galvanize.repositories.JpaNoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerController {

    @Autowired
    JpaCustomerDao jpaCustomerDao;

    @Autowired
    JdbcCustomerDao jdbcCustomerDao;

    @Autowired
    JpaNoteDao jpaNoteDao;

    //CREATE Customer
    @PostMapping("/customers")
    public Customers createCustomer(@RequestBody Customers customers){
        System.out.println(customers.toString());
        Customers updatedCustomer = jpaCustomerDao.save(customers);
        System.out.println(updatedCustomer.toString());
        return updatedCustomer;
    }

    //GET ALL Customers
    @GetMapping("/customers")
    public List<Customers> getAllCustomers(){
        return jpaCustomerDao.findAll();
    }

//    //GET Customer By Request Number
//    @GetMapping("/customers/{requestNumber}")
//    public Customers getByRequestNumber(@PathVariable int requestNumber) {
//        return jpaCustomerDao.findByRequestNumber(requestNumber);
//    }
}
