package com.example.demo2.repository;

import com.example.demo2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryEmployee extends JpaRepository<Employee,Long> {
    List<Employee> findAllByNameContaining(String string);
    List<Employee> findAllByAge(int age);
    List<Employee> findAllByAddressContaining(String address);

    Page<Employee> findAll(Pageable pageable);

}
