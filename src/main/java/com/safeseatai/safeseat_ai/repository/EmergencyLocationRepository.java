package com.safeseatai.safeseat_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.EmergencyLocation;

public interface EmergencyLocationRepository  extends JpaRepository<EmergencyLocation, Long> {

}
