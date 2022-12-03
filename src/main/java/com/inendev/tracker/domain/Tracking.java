package com.inendev.tracker.domain;

import com.inendev.tracker.auditing.CreationAuditable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "decoded_payload")
public class Tracking extends CreationAuditable {
    @Id
    @SequenceGenerator(name = "decoded_payload_id_seq",
            sequenceName = "decoded_payload_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "decoded_payload_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "raw")
    private String raw;

    @Column(name = "addr")
    private String addr;

    @Column(name = "alarm")
    private Long alarm;

    @Column(name = "batV")
    private BigDecimal batV;

    @Column(name = "major")
    private Long major;

    @Column(name = "minor")
    private Long minor;

    @Column(name = "rssi")
    private Long rssi;

    @Column(name = "step_count")
    private Long stepCount;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "ts")
    private Date timestamp;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
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
}
