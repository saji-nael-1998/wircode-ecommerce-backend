package com.wircodeteam.ecommercedemo;

import com.wircodeteam.ecommercedemo.Repo.EmployeeRepo;
import com.wircodeteam.ecommercedemo.model.Employee;
import com.wircodeteam.ecommercedemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EcommerceDemoApplication {
    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }
    @Component
    private static class Initializer implements CommandLineRunner {
        @Autowired
        private EmployeeRepo employeeRepo;


        @Override
        public void run(String... args) throws Exception {
            Employee employee = new Employee();
            employee.setId("admin");
            employee.setName("admin");
            employee.setRole(Employee.Role.ADMIN);
            employee.setPassword("123456");
            employee.setStatus(User.AccountStatus.ACTIVE);
            employeeRepo.save(employee);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceDemoApplication.class, args);
    }

}
