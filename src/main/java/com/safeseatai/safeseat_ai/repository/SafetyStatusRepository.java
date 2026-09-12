package com.safeseatai.safeseat_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.SafetyStatus;

public interface SafetyStatusRepository extends JpaRepository<SafetyStatus, Long>{

}
