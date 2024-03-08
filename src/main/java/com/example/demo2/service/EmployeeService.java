package com.example.demo2.service;

import com.example.demo2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(Long id);

    void deleteById(Long id);

    void save(Employee employeE);

    Object findAllByNameContaining(String name);
}
