package com.inendev.tracker.dto;

import java.math.BigDecimal;

public class DeviceDTO {
    private Long id;
    private String name;
    private BigDecimal battery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBattery() {
        return battery;
    }

    public void setBattery(BigDecimal battery) {
        this.battery = battery;
    }
}
