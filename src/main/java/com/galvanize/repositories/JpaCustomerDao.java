package com.galvanize.repositories;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import com.galvanize.entities.Customers;

import javax.persistence.Id;

@Repository
public interface JpaCustomerDao<requestNumber> extends JpaRepository<Customers, requestNumber> {

    Customers findByRequestNumber(int requestNumber);
    Customers save(Customers customers);
    List<Customers> findAll();
}

