package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HelloModel;

public interface HelloRepository extends JpaRepository<HelloModel,Integer> {

}
