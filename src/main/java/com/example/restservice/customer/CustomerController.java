package com.example.restservice.customer;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    Customer addCustomer(@RequestBody @Valid CustomerRequestDTO customerRequest) {
        Customer newCustomer = Customer.builder()
                .name(customerRequest.getName())
                .address(customerRequest.getAddress())
                .build();
        return customerRepository.save(newCustomer);
    }

    @PutMapping("/{id}")
    Customer updateCustomer(@RequestBody @Valid CustomerRequestDTO customerRequest, @PathVariable Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer == null) {
            throw new CustomerNotFoundException(id);
        } else {
            existingCustomer.setName(customerRequest.getName());
            existingCustomer.setAddress(customerRequest.getAddress());
            return customerRepository.save(existingCustomer);
        }
    }

    @GetMapping
    List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    Customer findCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer == null) {
            throw new CustomerNotFoundException(id);
        } else {
            customerRepository.deleteById(id);
        }
    }
}
