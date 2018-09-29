package com.witbus.demo.dto;

import java.util.List;

public class BusDTO {
    private Long bus_id;


    private String bus_plate;
    private String bus_name;
    private String start_location;
    private String end_location;
    private String start_time;
    private String end_time;
    private Integer distance_time;
    private Double price_default;
    private Bus_OwnerDTO bus_owner;
    private List<SeatDTO> seats;

    @Override
    public String toString() {
        return "BusDTO{" +
                "bus_id=" + bus_id +
                ", bus_plate='" + bus_plate + '\'' +
                ", bus_name='" + bus_name + '\'' +
                ", start_location='" + start_location + '\'' +
                ", end_location='" + end_location + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", distance_time=" + distance_time +
                ", price_default=" + price_default +
                ", bus_owner=" + bus_owner +
                ", seats=" + seats +
                '}';
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }

    public Bus_OwnerDTO getBus_owner() {
        return bus_owner;
    }

    public void setBus_owner(Bus_OwnerDTO bus_owner) {
        this.bus_owner = bus_owner;
    }

    public Long getBus_id() {
        return bus_id;
    }

    public void setBus_id(Long bus_id) {
        this.bus_id = bus_id;
    }


    public String getBus_plate() {
        return bus_plate;
    }

    public void setBus_plate(String bus_plate) {
        this.bus_plate = bus_plate;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public void setEnd_location(String end_location) {
        this.end_location = end_location;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getDistance_time() {
        return distance_time;
    }

    public void setDistance_time(Integer distance_time) {
        this.distance_time = distance_time;
    }

    public Double getPrice_default() {
        return price_default;
    }

    public void setPrice_default(Double price_default) {
        this.price_default = price_default;
    }


}
