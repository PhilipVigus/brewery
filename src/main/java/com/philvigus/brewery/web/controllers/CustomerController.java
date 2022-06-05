package com.philvigus.brewery.web.controllers;

import com.philvigus.brewery.services.CustomerService;
import com.philvigus.brewery.web.models.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> handlePost(@Valid @RequestBody CustomerDto customerDto) {
    CustomerDto savedDto = customerService.saveCustomer(customerDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer" + savedDto.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<Void> handleUpdate(
      @PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable UUID customerId) {
    customerService.deleteById(customerId);
  }
}
