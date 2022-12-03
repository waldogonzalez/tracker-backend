package com.inendev.tracker.domain;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @SequenceGenerator(name = "device_id_seq",
            sequenceName = "device_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "device_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

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
}
