package com.witbus.demo.dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long bus_id;

    @Column(name = "bus_plate")
    private String bus_plate;

    @Column(name = "bus_name")
    private String bus_name;

    @Column(name = "bus_start_location")
    private String start_location;

    @Column(name = "bus_end_location")
    private String end_location;

    @Column(name = "bus_start_time")
    private String start_time;

    @Column(name = "bus_end_time")
    private String end_time;

    @Column(name = "bus_distance_time")
    private Integer distance_time;

    @Column(name = "bus_price_default")
    private Double price_default;

    @ManyToOne
    @JoinColumn(name = "bus_owner_id")
    private Bus_Owner bus_owner;

    @OneToMany(mappedBy = "bus", fetch = FetchType.EAGER)
    private Set<Seat> seats;

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

    public Bus_Owner getBus_owner() {
        return bus_owner;
    }

    public void setBus_owner(Bus_Owner bus_owner) {
        this.bus_owner = bus_owner;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }




}
