package com.galvanize.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Customers")
public class Customers {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "requestNumber")
        private long requestNumber;
        @Column(name = "requestDateTime")
        private Timestamp requestDateTime;
        @Column(name = "customerName")
        private String customerName;
        @Column(name = "customerAddress")
        private String customerAddress;
        @Column(name = "phoneNumber")
        private String phoneNumber;
        @Column(name = "description")
        private String description;
        @Column(name = "technician")
        private String technician;
        @Column(name = "appointmentDateTime")
        private Timestamp appointmentDateTime;
        @Enumerated(EnumType.STRING)
        private String status;

        public Customers() {
        }

    public Customers(Timestamp requestDateTime, String customerName, String customerAddress, String phoneNumber, String description, String technician, Timestamp appointmentDateTime, Status Status) {
        this.requestDateTime = requestDateTime;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.technician = technician;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    public Customers(long requestNumber, Timestamp requestDateTime, String customerName, String customerAddress, String phoneNumber, String description, String technician, Timestamp appointmentDateTime, String status, List<Note> notes) {
        this.requestNumber = requestNumber;
        this.requestDateTime = requestDateTime;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.technician = technician;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    public Customers(Timestamp valueOf, String test_customer, String s, String s1, String s2) {
    }

    public long getRequestNumber() {
            return requestNumber;
        }

        public void setRequestNumber(long requestNumber) {
            this.requestNumber = requestNumber;
        }

        public Timestamp getRequestDateTime() {
            return requestDateTime;
        }

        public void setRequestDateTime(Timestamp requestDateTime) {
            this.requestDateTime = requestDateTime;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTechnician() {
            return technician;
        }

        public void setTechnician(String technician) {
            this.technician = technician;
        }

        public Timestamp getAppointmentDateTime() {
            return appointmentDateTime;
        }

        public void setAppointmentDateTime(Timestamp appointmentDateTime) {
            this.appointmentDateTime = appointmentDateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customers that = (Customers) o;
            return getRequestNumber() == that.getRequestNumber() &&
                    Objects.equals(getRequestDateTime(), that.getRequestDateTime()) &&
                    Objects.equals(getCustomerName(), that.getCustomerName()) &&
                    Objects.equals(getCustomerAddress(), that.getCustomerAddress()) &&
                    Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                    Objects.equals(getDescription(), that.getDescription()) &&
                    Objects.equals(getTechnician(), that.getTechnician()) &&
                    Objects.equals(getAppointmentDateTime(), that.getAppointmentDateTime()) &&
                    Objects.equals(getStatus(), that.getStatus());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRequestNumber(), getRequestDateTime(), getCustomerName(), getCustomerAddress(), getPhoneNumber(), getDescription(), getTechnician(), getAppointmentDateTime(), getStatus());
        }
    }
