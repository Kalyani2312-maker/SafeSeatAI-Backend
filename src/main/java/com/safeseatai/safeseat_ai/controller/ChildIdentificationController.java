package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.ChildIdentification;
import com.safeseatai.safeseat_ai.service.ChildIdentificationService;

@RestController
@RequestMapping("/api/identifications")
@CrossOrigin(origins = "*")
public class ChildIdentificationController {

    @Autowired
    private ChildIdentificationService identificationService;

    @PostMapping
    public ChildIdentification addIdentification(
            @RequestBody ChildIdentification identification) {

        return identificationService.addIdentification(identification);
    }

    @GetMapping
    public List<ChildIdentification> getAllIdentifications() {
        return identificationService.getAllIdentifications();
    }

    @GetMapping("/{id}")
    public ChildIdentification getIdentificationById(@PathVariable Long id) {
        return identificationService.getIdentificationById(id);
    }
}
