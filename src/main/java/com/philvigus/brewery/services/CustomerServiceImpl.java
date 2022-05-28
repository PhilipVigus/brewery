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
}
