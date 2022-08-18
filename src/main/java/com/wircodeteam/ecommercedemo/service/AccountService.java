package com.wircodeteam.ecommercedemo.service;

import com.wircodeteam.ecommercedemo.Repo.EmployeeRepo;
import com.wircodeteam.ecommercedemo.error.UserNotFoundException;
import com.wircodeteam.ecommercedemo.model.Employee;
import com.wircodeteam.ecommercedemo.model.User;
import com.wircodeteam.ecommercedemo.requests.AuthRequest;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class AccountService {
    private final EmployeeRepo employeeRepo;

    public AccountService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public boolean processLogin(AuthRequest authRequest) {
        boolean isAllowed;
        switch (authRequest.getUserType()) {
            case 0: {
                Employee employee = employeeRepo.findById(authRequest.getUsername()).orElseThrow(() -> new UserNotFoundException(authRequest.getUsername()));
                isAllowed= checkUserAccount(employee);
                break;
            }
            case 1: {
                isAllowed=false;
                break;
            }
            default:
                isAllowed=false;
        }
        return isAllowed;
    }

    public boolean checkUserAccount(User user) {
        Predicate<User> isDeleted = emp -> !emp.isDeleted();
        Predicate<User> isActive = emp -> emp.getStatus() == User.AccountStatus.ACTIVE;
        return isDeleted.and(isActive).test(user);
    }
}
