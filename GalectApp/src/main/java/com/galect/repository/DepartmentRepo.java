package com.galect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galect.bean.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	List<Department> findAll();
	List<Department> findByCollegeID(Integer id);
}
