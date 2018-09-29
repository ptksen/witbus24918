package com.witbus.demo.services;

import com.witbus.demo.dao.models.Bus;
import com.witbus.demo.dao.models.Bus_Owner;
import com.witbus.demo.dao.models.Seat;
import com.witbus.demo.dao.repository.BusRepository;
import com.witbus.demo.dao.repository.Bus_OwnerRepository;
import com.witbus.demo.dao.repository.SeatRepository;
import com.witbus.demo.dto.BusDTO;
import com.witbus.demo.dto.Bus_OwnerDTO;
import com.witbus.demo.dto.SeatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WitBus_Service implements WitBusService {
    @Autowired
    private BusRepository busRepository;
    private Bus_OwnerRepository bus_ownerRepository;
    private SeatRepository seatRepository;

    public WitBus_Service (Bus_OwnerRepository bus_ownerRepository, BusRepository busRepository, SeatRepository seatRepository ){
        this.busRepository = busRepository;
        this.bus_ownerRepository = bus_ownerRepository;
        this.seatRepository = seatRepository;
    }
    @Override
    public List<BusDTO> listBus() {
        List<BusDTO> busDTOS = new ArrayList<>();
        List<Bus> buses = busRepository.findAll();
        for (Bus bus : buses) {
            BusDTO busDTO = new BusDTO();
            busDTO.setBus_id(bus.getBus_id());
            busDTO.setBus_name(bus.getBus_name());
            busDTO.setBus_plate(bus.getBus_plate());
            busDTO.setStart_location(bus.getStart_location());
            busDTO.setEnd_location(bus.getEnd_location());
            busDTO.setStart_time(bus.getStart_time());
            busDTO.setEnd_time(bus.getEnd_time());
            busDTO.setDistance_time(bus.getDistance_time());
            busDTO.setPrice_default(bus.getPrice_default());

            Bus_OwnerDTO bus_ownerDTO = new Bus_OwnerDTO();
            bus_ownerDTO.setBus_owner_id(bus.getBus_owner().getBus_owner_id());
            bus_ownerDTO.setBus_owner_name(bus.getBus_owner().getBus_owner_name());


            busDTO.setBus_owner(bus_ownerDTO);

            busDTOS.add(busDTO);
        }

        return busDTOS;

    }

    @Override
    public void addBus(BusDTO busDTO) {
//        Bank bank = new Bank();
//        bank.setBankName(bankDTO.getName());
//        bank.setBankAccount(bankDTO.getAccount());
//
//        Optional<User> userOptional = userRepository.findById(bankDTO.getUser().getId());
//
//        if (userOptional.isPresent()) {
//            bank.setUser(userOptional.get());
//            bankRepository.save(bank);
//        }
        Bus bus = new Bus();
        bus.setBus_name(busDTO.getBus_name());
        bus.setBus_plate(busDTO.getBus_plate());
        bus.setStart_location(busDTO.getStart_location());
        bus.setEnd_location(busDTO.getEnd_location());
        bus.setStart_time(busDTO.getStart_time());
        bus.setEnd_time(busDTO.getEnd_time());
        bus.setDistance_time(busDTO.getDistance_time());
        bus.setPrice_default(busDTO.getPrice_default());

        Optional<Bus_Owner> bus_ownerOptional = bus_ownerRepository.findById(busDTO.getBus_owner().getBus_owner_id());

        if (bus_ownerOptional.isPresent()) {
            bus.setBus_owner(bus_ownerOptional.get());
            busRepository.save(bus);
        }
    }

    @Override
    public List<Bus_OwnerDTO> listBusOwner() {
        List<Bus_OwnerDTO> bus_ownerDTOS = new ArrayList<>();
        List<Bus_Owner> bus_owners = bus_ownerRepository.findAll();
        for (Bus_Owner bus_owner:bus_owners ){
            Bus_OwnerDTO bus_ownerDTO = new Bus_OwnerDTO();
            bus_ownerDTO.setBus_owner_id(bus_owner.getBus_owner_id());
            bus_ownerDTO.setBus_owner_name(bus_owner.getBus_owner_name());
            for (Bus bus: bus_owner.getBus()){
                BusDTO busDTO = new BusDTO();
                busDTO.setBus_name(bus.getBus_name());
                busDTO.setBus_plate(bus.getBus_plate());
                busDTO.setStart_location(bus.getStart_location());
                busDTO.setEnd_location(bus.getEnd_location());
                busDTO.setStart_time(bus.getStart_time());
                busDTO.setEnd_time(bus.getEnd_time());
                busDTO.setDistance_time(bus.getDistance_time());
                busDTO.setPrice_default(bus.getPrice_default());
                bus_ownerDTO.getBus().add(busDTO);
            }
            bus_ownerDTOS.add(bus_ownerDTO);
        }
        return bus_ownerDTOS;

    }

    @Override
    public void addBusOwner(Bus_OwnerDTO bus_ownerDTO) {
        Bus_Owner bus_owner = new Bus_Owner();
        bus_owner.setBus_owner_name(bus_ownerDTO.getBus_owner_name());

        bus_ownerRepository.save(bus_owner);
    }

    @Override
    public List<SeatDTO> listSeat() {
        List<SeatDTO> seatDTOS = new ArrayList<>();
        List<Seat> seats = seatRepository.findAll();
        for (Seat seat : seats) {
            SeatDTO seatDTO = new SeatDTO();
            seatDTO.setSeat_id(seat.getSeat_id());
            seatDTO.setSeat_name(seat.getSeat_name());
            seatDTO.setSeat_price(seat.getSeat_price());
            seatDTO.setSeat_status(seat.getSeat_status());

            BusDTO busDTO = new BusDTO();
            busDTO.setBus_id(seat.getBus().getBus_id());
            busDTO.setBus_name(seat.getBus().getBus_name());
            busDTO.setBus_plate(seat.getBus().getBus_plate());
            busDTO.setStart_location(seat.getBus().getStart_location());
            busDTO.setEnd_location(seat.getBus().getEnd_location());
            busDTO.setStart_time(seat.getBus().getStart_time());
            busDTO.setEnd_time(seat.getBus().getEnd_time());
            busDTO.setDistance_time(seat.getBus().getDistance_time());
            busDTO.setPrice_default(seat.getBus().getPrice_default());

//            Bus_OwnerDTO bus_ownerDTO = new Bus_OwnerDTO();
//            bus_ownerDTO.setBus_owner_id(seat.getBus().getBus_owner().getBus_owner_id());
//            bus_ownerDTO.setBus_owner_name(seat.getBus().getBus_owner().getBus_owner_name());


            seatDTO.setBus(busDTO);


            seatDTOS.add(seatDTO);
        }

        return seatDTOS;

    }

    @Override
    public void addSeat(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setSeat_name(seatDTO.getSeat_name());
        seat.setSeat_price(seatDTO.getSeat_price());
        seat.setSeat_status(seatDTO.getSeat_status());

        Optional<Bus> busOptional = busRepository.findById(seatDTO.getBus().getBus_id());

        if (busOptional.isPresent()) {
            seat.setBus(busOptional.get());
            seatRepository.save(seat);
        }
    }

    @Override
    public List<Bus_Owner> findAll() {
        return bus_ownerRepository.findAll();
    }

    @Override
    public void delete(long id) {
        bus_ownerRepository.deleteById(id);
    }

    @Override
    public Object findOne(long id) {
        return bus_ownerRepository.findById(id);
    }
}
