package com.project.employee.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.employee.VO.Department;
import com.project.employee.VO.ResponseTemplateVO;
import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveUser of EmployeeService");
        return employeeRepository.save(employee);
    }


    public ResponseTemplateVO getEmployeeWithDepartment(Long employeeId) {
        log.info("Inside getemployeeWithDepartment of employeeService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId()
                        ,Department.class);

        vo.setEmployee(employee);
        vo.setDepartment(department);

        return  vo;
    }
}
