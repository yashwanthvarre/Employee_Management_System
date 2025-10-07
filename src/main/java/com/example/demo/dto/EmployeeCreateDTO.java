package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeCreateDTO {

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 2, max = 50, message = "Name must be 2-50 characters")
	private String name;

	@NotBlank(message = "Role cannot be empty")
	@Size(min = 2, max = 50, message = "Role must be 2-50 characters")
	private String role;

	public EmployeeCreateDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EmployeeCreateDTO(String name, String role) {
		this.name = name;
		this.role = role;
	}

}
