package com.team.Bok.controller;

import com.team.Bok.dto.CustomerDto;
import com.team.Bok.model.Customer;
import com.team.Bok.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        CustomerDto result = customerService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerDto customerDto) {
        CustomerDto result = customerService.create(customerDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CustomerDto customerDto) {
        boolean result = customerService.update(id, customerDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = customerService.delete(id);
        return ResponseEntity.ok(result);
    }

}
