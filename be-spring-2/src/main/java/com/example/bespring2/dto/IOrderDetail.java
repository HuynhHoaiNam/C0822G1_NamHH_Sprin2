package com.example.bespring2.dto;

public interface IOrderDetail {
    Long getIdOrder();

    Long getIdWatch();

    String getWatchName();

    double getPrice();

    int getQuantity();

    double getMoney();
}
