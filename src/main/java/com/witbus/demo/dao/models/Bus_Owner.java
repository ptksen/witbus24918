package com.witbus.demo.dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "bus_owner")
public class Bus_Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_owner_id")
    private Long bus_owner_id;

    @Column(name = "bus_owner_name")
    private String bus_owner_name;

    @OneToMany(mappedBy = "bus_owner", fetch = FetchType.EAGER)
    private Set<Bus> bus;



    public Long getBus_owner_id() {
        return bus_owner_id;
    }

    public void setBus_owner_id(Long bus_owner_id) {
        this.bus_owner_id = bus_owner_id;
    }

    public String getBus_owner_name() {
        return bus_owner_name;
    }

    public void setBus_owner_name(String bus_owner_name) {
        this.bus_owner_name = bus_owner_name;
    }

    public Set<Bus> getBus() {
        return bus;
    }

    public void setBus(Set<Bus> bus) {
        this.bus = bus;
    }
}
