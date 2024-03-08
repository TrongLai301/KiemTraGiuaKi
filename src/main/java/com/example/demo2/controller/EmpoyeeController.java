package com.example.demo2.controller;

import com.example.demo2.model.Employee;
import com.example.demo2.repository.IRepositoryEmployee;
import com.example.demo2.service.EmployeeService;
import com.example.demo2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmpoyeeController {
    @Autowired
    public IRepositoryEmployee employee;
    @Autowired
    public PostService postService;

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        Page<Employee> list = employee.findAll(pageable);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody Employee employeE, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity("Lỗi rồi", HttpStatus.BAD_REQUEST);
        }
        employee.save(employeE);
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
    public ResponseEntity edit(@Valid @PathVariable Long id, @RequestBody Employee employeE, BindingResult bindingResult){
        Optional<Employee> list = employee.findById(id);
        if (bindingResult.hasErrors()){
            return new ResponseEntity("Lỗi rồi", HttpStatus.BAD_REQUEST);
        }
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
