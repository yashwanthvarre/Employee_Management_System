package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;
	private final EmployeeMapper mapper;

	public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public Employee getByIdOrThrow(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found: " + id));
	}

	public Employee create(EmployeeCreateDTO dto) {
		Employee e = mapper.toEntity(dto);
		return repository.save(e);
	}

	public Employee update(Long id, EmployeeUpdateDTO dto) {
		Employee existing = getByIdOrThrow(id);
		mapper.updateEntity(dto, existing);
		return repository.save(existing);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
