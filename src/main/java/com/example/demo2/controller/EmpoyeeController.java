package com.example.demo2.controller;

import com.example.demo2.model.Employee;
import com.example.demo2.repository.IRepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmpoyeeController {
    @Autowired
    public IRepositoryEmployee employee;

    @GetMapping
    public ResponseEntity findAll(){
        List<Employee> list = employee.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity save(@RequestBody Employee studentTest){
        employee.save(studentTest);
        return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Employee> list = employee.findById(id);
        if (!list.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.deleteById(id);

        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Employee employeE){
        Optional<Employee> list = employee.findById(id);
        if (!list.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeE.setId(id);
        employee.save(employeE);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity findByName (@RequestParam String name) {
        return new ResponseEntity<>(employee.findAllByNameContaining(name), HttpStatus.OK);
    }
    @GetMapping("/findByAge")
    public ResponseEntity findByName (@RequestParam int age) {
        return new ResponseEntity<>(employee.findAllByAge(age), HttpStatus.OK);
    }
    @GetMapping("/findByAddress")
    public ResponseEntity findByAddress (@RequestParam String address) {
        return new ResponseEntity<>(employee.findAllByAddressContaining(address), HttpStatus.OK);
    }


}
