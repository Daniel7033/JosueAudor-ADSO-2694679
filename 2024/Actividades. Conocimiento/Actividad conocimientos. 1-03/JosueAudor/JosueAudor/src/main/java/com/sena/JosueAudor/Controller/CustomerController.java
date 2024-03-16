package com.sena.JosueAudor.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sena.JosueAudor.Entity.Customer;
import com.sena.JosueAudor.IService.ICustomerService;

@CrossOrigin(origins = " ")
@RestController
@RequestMapping("v1/api/customer")
public class CustomerController {
    
    @Autowired
    private ICustomerService customerService;
    
    @GetMapping()
    public List<Customer>all() {
        return customerService.all();
    }
    
    @GetMapping("{id}")
    public Optional<Customer> show(@PathVariable Long id) {
        return customerService.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
    
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.update(customer, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
