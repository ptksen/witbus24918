package com.witbus.demo.dto;

public class SeatDTO {
    private Long seat_id;
    private String seat_name;
    private Boolean seat_status;
    private Double seat_price;
    private BusDTO bus;
    @Override
    public String toString() {
        return "SeatDTO{" +
                "seat_id=" + seat_id +
                ", seat_name='" + seat_name + '\'' +
                ", seat_status=" + seat_status +
                ", seat_price=" + seat_price +
                ", bus=" + bus +
                '}';
    }

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

    public BusDTO getBus() {
        return bus;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }


}
