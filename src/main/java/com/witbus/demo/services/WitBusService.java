package com.witbus.demo.services;

import com.witbus.demo.dao.models.Bus_Owner;
import com.witbus.demo.dto.BusDTO;
import com.witbus.demo.dto.Bus_OwnerDTO;
import com.witbus.demo.dto.SeatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WitBusService {
    List<BusDTO> listBus();

    void addBus(BusDTO busDTO);

    List<Bus_OwnerDTO> listBusOwner();

    void addBusOwner(Bus_OwnerDTO bus_ownerDTO);

    List<SeatDTO> listSeat();

    void addSeat(SeatDTO seatDTO);

    List<Bus_Owner> findAll();

    void delete(long id);

    Object findOne(long id);
}
