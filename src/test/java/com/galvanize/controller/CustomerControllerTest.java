package com.galvanize.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Customers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CustomerControllerTest {
    @Autowired
    MockMvc mvc;

    ObjectMapper mapper = new ObjectMapper();

    //POST Method
    @Test
    public void addCustomer() throws Exception {
        String input = "{\"customerName\":\"Some Customer\",\"customerAddress\":\"123 Any Street, SomeCity, ST, 99999\",\"phoneNumber\":\"111-222-3333\",\"description\":\"it's broke and I need it fixed!\"}";
        mvc.perform(post("/api/customers").content(input).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.customerName").value("Some Customer"));
    }

    //GET ALL Customers method
    @Test
    public void getAllCustomers() throws Exception {
        String input = "{\"requestNumber\":\"124\",\"requestDateTime\":\"01/20/2020 08:30AM\",\"customerName\":\"Some Customer\",\"customerAddress\":\"123 Any Street, SomeCity, ST, 99999\",\"phoneNumber\":\"111-222-3333\",\"description\":\"it's broke and I need it fixed!\",\"status\":\"PEMDING\"}";
        mvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(15)))
                .andDo(print());
        //Teardown
    }

    //GET ALL Customers with a technician and Description method
    @Test
    public void getAllCustomersWithTechnician() throws Exception {
        String input = "{\"requestNumber\":\"124\",\"requestDateTime\":\"01/20/2020 08:30AM\",\"customerName\":\"Some Customer\",\"customerAddress\":\"123 Any Street, SomeCity, ST, 99999\",\"phoneNumber\":\"111-222-3333\",\"description\":\"it's broke and I need it fixed!\",\"technician\":\"Johnny Fixer\"\"appointmentDateTime\":\"11/11/2019\"\"status\":\"RESOLVED\"}";
        mvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(15)))
                .andDo(print());
        //Teardown
    }

    //GET Customers By RequestNumber
//    @Test
//    public void getByRequestNumber() throws Exception {
//        mvc.perform(get("/api/customers/15"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.last").value("David"))
//                .andDo(print());
//    }
//
//    //UPDATE Customer
//    @Test
//    public void insertCustomer() throws Exception{
//        mvc.perform(put("/api/customers/1"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
}