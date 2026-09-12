package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.SafetyStatus;
import com.safeseatai.safeseat_ai.repository.SafetyStatusRepository;

@Service
public class SafetyStatusService {
	 @Autowired
	    private SafetyStatusRepository repository;

	    public SafetyStatus checkSafety(SafetyStatus status) {

	        /*
	         * Child is considered left behind when:
	         * Route is completed AND child is still detected inside bus.
	         */
	        boolean leftBehind =
	                status.isRouteCompleted()
	                && status.isChildPresent();

	        status.setLeftBehind(leftBehind);

	        if (leftBehind) {
	            status.setAlertSent(true);
	        } else {
	            status.setAlertSent(false);
	        }

	        return repository.save(status);
	    }

	    public List<SafetyStatus> getAllSafetyStatus() {
	        return repository.findAll();
	    }
}
