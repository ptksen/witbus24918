package com.witbus.demo.dto;

import java.util.List;

public class Bus_OwnerDTO {
    @Override
    public String toString() {
        return "Bus_OwnerDTO{" +
                "bus_owner_id=" + bus_owner_id +
                ", bus_owner_name='" + bus_owner_name + '\'' +
                ", bus=" + bus +
                '}';
    }

    private Long bus_owner_id;
    private String bus_owner_name;
    private List<BusDTO> bus;


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

    public List<BusDTO> getBus() {
        return bus;
    }

    public void setBus(List<BusDTO> bus) {
        this.bus = bus;
    }
}
