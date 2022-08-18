package com.wircodeteam.ecommercedemo.Repo;

import com.wircodeteam.ecommercedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {

}
