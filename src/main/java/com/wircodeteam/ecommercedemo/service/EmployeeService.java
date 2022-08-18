package com.wircodeteam.ecommercedemo.service;

import com.wircodeteam.ecommercedemo.DTO.UserDTO;
import com.wircodeteam.ecommercedemo.Repo.EmployeeRepo;
import com.wircodeteam.ecommercedemo.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

//    public Employee create(UserDTO employeeDTO)  {
//        Employee employee = read(employeeDTO.getId());
//        if (employee!=null){
//            System.out.println("done");
//        }else {
//            employee=new Employee();
//        }
//        employee.setId(employeeDTO.getId());
//        employee.setName(employeeDTO.getName());
//        employee.setRole(Employee.Role.values()[employeeDTO.getRole()]);
//        return employeeRepo.save(employee);
//    }
//    public Employee read(String id){
//        return employeeRepo.findById(id).filter(employee -> !employee.isDeleted()).stream().findAny().orElse(null);
//    }
}
