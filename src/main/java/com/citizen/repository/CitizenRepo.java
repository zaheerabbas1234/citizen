package com.citizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizen.model.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen,String>{

}
