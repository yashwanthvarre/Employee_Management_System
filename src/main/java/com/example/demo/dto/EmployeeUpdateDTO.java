package com.example.demo.dto;

import jakarta.validation.constraints.Size;

public class EmployeeUpdateDTO {
	@Size(min = 2, max = 50, message = "Name must be 2–50 characters")
	private String name;

	@Size(min = 2, max = 50, message = "Role must be 2–50 characters")
	private String role;

	public EmployeeUpdateDTO() {
	}

	public EmployeeUpdateDTO(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
