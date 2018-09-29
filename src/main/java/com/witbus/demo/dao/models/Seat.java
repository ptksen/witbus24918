package com.witbus.demo.dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "seat")
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seat_id;

    @Column(name = "seat_name")
    private String seat_name;



    @Column(name = "seat_status")
    private Boolean seat_status;



    @Column(name = "seat_price")

    private Double seat_price;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @OneToMany(mappedBy = "seat", fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    public Long getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Long seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public Boolean getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(Boolean seat_status) {
        this.seat_status = seat_status;
    }

    public Double getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(Double seat_price) {
        this.seat_price = seat_price;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
