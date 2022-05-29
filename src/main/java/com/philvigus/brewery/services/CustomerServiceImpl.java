package com.philvigus.brewery.services;

import com.philvigus.brewery.web.models.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder().id(UUID.randomUUID()).name("Bob Smith").build();
  }

  @Override
  public CustomerDto saveCustomer(CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    // TODO: add a real implementation to update customer
  }

  @Override
  public void deleteById(UUID customerId) {
    // TODO: add a real implementation to delete customer
  }
}
