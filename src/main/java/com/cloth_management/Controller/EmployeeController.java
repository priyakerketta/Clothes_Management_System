package com.cloth_management.Controller;

import com.cloth_management.Models.Employee;
import com.cloth_management.Repository.EmployeeRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/Employee")
    public String getEmployee(Model model){
        List<Employee> emp = employeeRepository.ListEmployees();
        model.addAttribute("Employees", emp);
        return "Employee";
    }
}
