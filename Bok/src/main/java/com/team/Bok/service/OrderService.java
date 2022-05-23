package com.team.Bok.service;

import com.team.Bok.dto.OrderDto;
import com.team.Bok.exception.BadRequest;
import com.team.Bok.model.Order;
import com.team.Bok.repasitory.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderDto get(Integer id) {
        OrderDto dto = new OrderDto();
        Order entity = check(id);
        convertEntityToDto(entity,dto);
        return dto;
    }

    private void convertEntityToDto(Order entity, OrderDto dto) {
        dto.setBook_id(entity.getBook_id());
        dto.setQuantity(entity.getQuantity());
        dto.setTotal_price(entity.getTotal_price());
        dto.setUser_id(entity.getUser_id());
        dto.setId(entity.getId());
    }

    private Order check(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Order not found");

        }
        return optional.get();

    }

    public OrderDto create(OrderDto dto) {
        Order entity = new Order();
        convertDtoToEntity(dto,entity);
        orderRepository.save(entity);
        return dto;
    }

    private void convertDtoToEntity(OrderDto dto, Order entity) {
        entity.setBook_id(dto.getBook_id());
        entity.setQuantity(dto.getQuantity());
        entity.setTotal_price(dto.getTotal_price());
        entity.setUser_id(dto.getUser_id());
    }

    public boolean update(OrderDto dto, Integer id) {
        Order entity = check(id);
        convertDtoToEntity(dto,entity);
        orderRepository.save(entity);
        return true;
    }

    public boolean delete(Integer id) {
        Order entity = check(id);
        orderRepository.delete(entity);
        return true;

    }
}
