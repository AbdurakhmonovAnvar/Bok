package com.team.Bok.controller;

import com.team.Bok.dto.OrderDto;
import com.team.Bok.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        OrderDto result = orderService.get(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDto dto){
        OrderDto result = orderService.create(dto);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody OrderDto dto){
        boolean result = orderService.update(dto,id);
        return ResponseEntity.ok(result);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = orderService.delete(id);
        return ResponseEntity.ok(result);
    }
}
