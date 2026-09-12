package com.safeseatai.safeseat_ai.controller;

import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.Bus;
import com.safeseatai.safeseat_ai.service.BusService;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "http://localhost:5173")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @PostMapping
    public Bus saveBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }

    @PutMapping("/{id}")
    public Bus updateBus(
            @PathVariable Long id,
            @RequestBody Bus bus) {

        bus.setId(id);
        return busService.saveBus(bus);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
    }
}