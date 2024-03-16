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
import com.sena.JosueAudor.Entity.CustomerProduct;
import com.sena.JosueAudor.IService.ICustomerProductService;

@CrossOrigin(origins = " ")
@RestController
@RequestMapping("v1/api/customer-product")
public class CustomerProductController {
    
    @Autowired
    private ICustomerProductService customerProductService;
    
    @GetMapping()
    public List<CustomerProduct>findaAll() {
        return customerProductService.findAll();
    }
    
    @GetMapping("{id}")
    public Optional<CustomerProduct> show(@PathVariable Long id) {
        return customerProductService.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CustomerProduct save(@RequestBody CustomerProduct customerProduct) {
        return customerProductService.save(customerProduct);
    }
    
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@RequestBody CustomerProduct customerProduct, @PathVariable Long id) {
        customerProductService.update(customerProduct, id);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerProductService.delete(id);
    }
}
