package com.galect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galect.bean.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Integer>{

}
