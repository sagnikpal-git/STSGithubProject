package com.hcl.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
