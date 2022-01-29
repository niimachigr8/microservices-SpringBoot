package com.project.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employee.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
	 Employee findByEmployeeId(Long empId);
}
