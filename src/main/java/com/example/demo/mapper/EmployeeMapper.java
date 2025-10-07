package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.model.Employee;

@Component
public class EmployeeMapper {

	public EmployeeDTO toDto(Employee e) {
		if (e == null) {
			return null;
		}
		return new EmployeeDTO(e.getId(), e.getName(), e.getRole());
	}

	public Employee toEntity(EmployeeCreateDTO d) {
		if (d == null) {
			return null;
		}
		return new Employee(d.getName(), d.getRole());
	}

	public void updateEntity(EmployeeUpdateDTO d, Employee e) {
		if (d.getName() != null) {
			e.setName(d.getName());
		}
		if (d.getRole() != null) {
			e.setRole(d.getRole());
		}

	}
}
