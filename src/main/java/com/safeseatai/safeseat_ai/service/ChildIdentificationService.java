package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.ChildIdentification;
import com.safeseatai.safeseat_ai.repository.ChildIdentificationRepository;

@Service
public class ChildIdentificationService {
	  @Autowired
	    private ChildIdentificationRepository identificationRepository;

	    public ChildIdentification addIdentification(ChildIdentification identification) {
	        return identificationRepository.save(identification);
	    }

	    public List<ChildIdentification> getAllIdentifications() {
	        return identificationRepository.findAll();
	    }

	    public ChildIdentification getIdentificationById(Long id) {
	        return identificationRepository.findById(id).orElse(null);
	    }
}
