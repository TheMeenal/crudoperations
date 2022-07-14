package com.example.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.students.entity.Students;

@org.springframework.stereotype.Repository


public interface Repository extends JpaRepository <Students, Integer>{

}
