package com.safeseatai.safeseat_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
