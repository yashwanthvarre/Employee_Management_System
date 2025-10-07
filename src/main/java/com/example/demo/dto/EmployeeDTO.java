package com.example.demo.dto;

public class EmployeeDTO {
	private Long id;
	private String name;
	private String role;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
