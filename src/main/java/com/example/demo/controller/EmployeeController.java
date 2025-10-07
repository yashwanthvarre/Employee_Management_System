package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService service;
	private final EmployeeMapper mapper;

	public EmployeeController(EmployeeService service, EmployeeMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public List<EmployeeDTO> all() {
		return service.getAll().stream().map(mapper::toDto).toList();
	}

	@GetMapping("/{id}")
	public EmployeeDTO one(@PathVariable Long id) {
		return mapper.toDto(service.getByIdOrThrow(id));
	}

	@PostMapping
	public EmployeeDTO create(@Valid @RequestBody EmployeeCreateDTO dto) {
		Employee saved = service.create(dto);
		return mapper.toDto(saved);
	}

	@PutMapping("/{id}")
	public EmployeeDTO update(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateDTO dto) {
		Employee saved = service.update(id, dto);
		return mapper.toDto(saved);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
