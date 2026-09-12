package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Bus;
import com.safeseatai.safeseat_ai.repository.BusRepository;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

}
