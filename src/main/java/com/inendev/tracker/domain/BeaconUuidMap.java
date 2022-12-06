package com.inendev.tracker.domain;

import javax.persistence.*;

@Entity
@Table(name = "beacon_uuid_map")
public class BeaconUuidMap {
    @Id
    @SequenceGenerator(name = "device_uuid_map_id_seq",
            sequenceName = "device_uuid_map_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "device_uuid_map_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
