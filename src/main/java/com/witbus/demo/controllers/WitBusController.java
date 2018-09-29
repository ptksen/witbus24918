package com.witbus.demo.controllers;

import com.witbus.demo.dao.models.Bus;
import com.witbus.demo.dto.BusDTO;
import com.witbus.demo.dto.Bus_OwnerDTO;
import com.witbus.demo.dto.SeatDTO;
import com.witbus.demo.services.WitBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class WitBusController {
    @Autowired
    private WitBusService witBusService;

    //=================================== BUS - OWNER =================================================//
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bus", witBusService.findAll());
        return "bus-owner";
    }
//    @GetMapping(value = "/bus-owner")
////    public ModelAndView busOwner(){
////        ModelAndView mav = new ModelAndView();
////        mav.setViewName("bus-owner");
////        return mav;
////    }
    @GetMapping("/bus-owner")
    public String busOwner(Model model) {
        model.addAttribute("bus", witBusService.findAll());
        return "bus-owner";
    }
    @GetMapping(value = "/bus-owner/create")
    public ModelAndView addBusOwner(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("owner", new Bus_OwnerDTO());
        mav.setViewName("add-bus-owner");
        return mav;
    }

    @PostMapping(value = "/busowner/save")
    public ModelAndView addBusOwner(@Valid Bus_OwnerDTO bus_ownerDTO,BindingResult result, Model model){
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.setViewName("add-bus-owner");
            return mav;
        }
        model.addAttribute("owner", new Bus_OwnerDTO());
        witBusService.addBusOwner(bus_ownerDTO);

        mav.setViewName("redirect:/bus-owner");
        return mav;
    }
//    @GetMapping(value = "/bus-owner/edit")
//    public ModelAndView editBusOwner(){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("owner", new Bus_OwnerDTO());
//        mav.setViewName("redirect:/bus-owner");
//        return mav;
//    }
    @GetMapping("/busowner/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("owner", witBusService.findOne(id));
        return "/add-bus-owner";
    }
    @GetMapping("/busowner/{id}/delete")
    public String delete(@PathVariable long id) {
        witBusService.delete(id);
        return "redirect:/bus-owner";
    }


//    @GetMapping("/busowner/{id}/edit")
//    public String edit(@PathVariable long id, Model model) {
//        model.addAttribute("contact", witBusService.findOne(id));
//        return "add-bus-owner";
//    }
//    @GetMapping("/contact/search")
//    public String search(@RequestParam("q") String q, Model model) {
//        if (q.equals("")) {
//            return "redirect:/contact";
//        }
//
//        model.addAttribute("contacts", contactService.search(q));
//        return "list";
//    }
//    @GetMapping("/bus-owner/create")
//    public String create(Model model) {
//        model.addAttribute("contact", new Bus_OwnerDTO());
//        return "form";
//    }
//    @PostMapping("/busowner/save")
//    public String save(@Valid Bus_OwnerDTO bus_ownerDTO, BindingResult result, RedirectAttributes redirect) {
//        if (result.hasErrors()) {
//            return "form";
//        }
//        witBusService.addBusOwner(bus_ownerDTO);
//        redirect.addFlashAttribute("success", "Saved contact successfully!");
//        return "redirect:/contact";
//    }
    //=================================== BUS =================================================//



    @GetMapping(value = "/bus")
    public ModelAndView bus(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("bus");
        return mav;
    }
    @GetMapping(value = "/add-bus")
    public ModelAndView addBus(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bus", new BusDTO());
        mav.setViewName("add-bus");
        return mav;
    }
    @PostMapping(value = "/add-bus-process")
    public ModelAndView addBus(BusDTO busDTO, HttpSession session){
        System.out.println(busDTO);
        session.setAttribute("bus", busDTO);
        witBusService.addBus(busDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/bus-owner");
        return mav;
    }
    //=================================== SEAT =================================================//

    @GetMapping(value = "/seat")
    public ModelAndView seat(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("seat");
        return mav;
    }
    @GetMapping(value = "/add-seat")
    public ModelAndView addSeat(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("seat", new SeatDTO());
        mav.setViewName("add-seat");
        return mav;
    }
    @PostMapping(value = "/add-seat-process")
    public ModelAndView addSeat(SeatDTO seatDTO, HttpSession session){
        System.out.println(seatDTO);
        session.setAttribute("seat", seatDTO);
        witBusService.addSeat(seatDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/seat");
        return mav;
    }


//
//    @PostMapping(value = "/bus")
//    public @ResponseBody String addBus(@RequestBody BusDTO busDTO){
//        witBusService.addBus(busDTO);
//        return "Ok";
//    }
//
//    @GetMapping(value = "/bus_owner")
//    public @ResponseBody
//    List<Bus_OwnerDTO> getBusOwner(){
//        return witBusService.listBusOwner();
//    }
//
//
//
//    @GetMapping(value = "/seat")
//    public @ResponseBody
//    List<SeatDTO> getSeat(){
//        return witBusService.listSeat();
//    }
//
//    @PostMapping(value = "/seat")
//    public @ResponseBody String addBusOwner(@RequestBody SeatDTO seatDTO){
//        witBusService.addSeat(seatDTO);
//        return "Ok";
//    }
}
