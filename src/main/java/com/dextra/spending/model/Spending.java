package com.dextra.spending.model;

import com.dextra.spending.enums.PaymentTypes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(collection = "SPENDING")
public class Spending implements Serializable {

    private Long id;

    private String customerName;

    private String date;

    private String time;

    private BigDecimal price;

    private String type;

    private String place;

    private PaymentTypes paymentType;

    private boolean isFixedSpending;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public PaymentTypes getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypes paymentType) {
        this.paymentType = paymentType;
    }
}
