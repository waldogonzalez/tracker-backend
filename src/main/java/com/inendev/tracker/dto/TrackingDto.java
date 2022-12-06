package com.inendev.tracker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TrackingDto {
    private Long id;

    private String addr;

    private Long alarm;

    private BigDecimal batV;

    private Long major;

    private Long minor;

    private Long rssi;

    private Long stepCount;

    private String uuid;

    private String deviceId;

    private Date timestamp;

    private String beaconName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getAlarm() {
        return alarm;
    }

    public void setAlarm(Long alarm) {
        this.alarm = alarm;
    }

    public BigDecimal getBatV() {
        return batV;
    }

    public void setBatV(BigDecimal batV) {
        this.batV = batV;
    }

    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    public Long getMinor() {
        return minor;
    }

    public void setMinor(Long minor) {
        this.minor = minor;
    }

    public Long getRssi() {
        return rssi;
    }

    public void setRssi(Long rssi) {
        this.rssi = rssi;
    }

    public Long getStepCount() {
        return stepCount;
    }

    public void setStepCount(Long stepCount) {
        this.stepCount = stepCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }
}
