package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Driver;
import com.safeseatai.safeseat_ai.repository.DriverRepository;

@Service
public class DriverService {
	  private final DriverRepository driverRepository;

	    public DriverService(DriverRepository driverRepository) {
	        this.driverRepository = driverRepository;
	    }

	    public List<Driver> getAllDrivers() {
	        return driverRepository.findAll();
	    }

	    public Driver getDriverById(Long id) {
	        return driverRepository.findById(id).orElse(null);
	    }

	    public Driver saveDriver(Driver driver) {
	        return driverRepository.save(driver);
	    }

	    public void deleteDriver(Long id) {
	        driverRepository.deleteById(id);
	    }
}
