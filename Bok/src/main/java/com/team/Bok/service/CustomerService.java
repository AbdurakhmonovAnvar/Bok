package com.team.Bok.service;

import com.team.Bok.dto.CustomerDto;
import com.team.Bok.exception.BadRequest;
import com.team.Bok.model.Customer;
import com.team.Bok.repasitory.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
        private CustomerRepository customerRepository;
        public CustomerDto get(Integer id) {
                CustomerDto dto = new CustomerDto();
               Customer entity =  check(id);
               convertEntityToDto(entity,dto);

                return dto;

        }

        private void convertEntityToDto(Customer entity, CustomerDto dto) {
                dto.setCity(entity.getCity());
                dto.setContact(entity.getContact());
                dto.setEmail(entity.getEmail());
                dto.setName(entity.getName());
                dto.setPassword(entity.getPassword());
                dto.setSurname(entity.getSurname());
                dto.setId(entity.getId());
        }

        private Customer check(Integer id) {
                Optional<Customer> optional = customerRepository.findById(id);
                if (optional.isEmpty()){
                        throw new  BadRequest("Customer not found");
                }
                return optional.get();
        }

        public CustomerDto create(CustomerDto customerDto) {
                Customer entity = new Customer();
                convertDtoToEntity(customerDto,entity);
                customerRepository.save(entity);
                return customerDto;

        }

        private void convertDtoToEntity(CustomerDto customerDto, Customer entity) {
                entity.setCity(customerDto.getCity());
                entity.setContact(customerDto.getContact());
                entity.setEmail(customerDto.getEmail());
                entity.setName(customerDto.getName());
                entity.setPassword(customerDto.getPassword());
                entity.setSurname(customerDto.getSurname());

        }

        public boolean update(Integer id, CustomerDto customerDto) {
                Customer entity = check(id);
                convertDtoToEntity(customerDto, entity);
                customerRepository.save(entity);
                return true;

        }

        public boolean delete(Integer id) {
                Customer entity = check(id);
                customerRepository.delete(entity);
                return true;


        }
}
