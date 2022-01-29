package com.project.employee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.project.employee.VO.ResponseTemplateVO;
import com.project.employee.entity.Employee;
import com.project.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

	 @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getEmployeerWithDepartment(@PathVariable("id") Long employeeId) {
        log.info("Inside getEmployeerWithDepartment of UserController");
        return employeeService.getEmployeeWithDepartment(employeeId);
    }


}
