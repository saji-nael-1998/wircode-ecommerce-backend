package com.wircodeteam.ecommercedemo.service;

import com.wircodeteam.ecommercedemo.Repo.EmployeeRepo;
import com.wircodeteam.ecommercedemo.error.UserNotFoundException;
import com.wircodeteam.ecommercedemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findById(username).filter(emp -> !emp.isDeleted()).orElseThrow(() -> new UserNotFoundException(username));
        return new User(employee.getId(), employee.getPassword(), new ArrayList<>());
    }
}
