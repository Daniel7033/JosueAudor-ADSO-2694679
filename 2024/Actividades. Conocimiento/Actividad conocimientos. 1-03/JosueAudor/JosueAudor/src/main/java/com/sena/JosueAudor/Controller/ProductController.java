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
import com.sena.JosueAudor.Entity.Product;
import com.sena.JosueAudor.IService.IProductService;

@CrossOrigin(origins = " ")
@RestController
@RequestMapping("v1/api/product")
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @GetMapping()
    public List<Product>findaAll() {
        return productService.findAll();
    }
    
    @GetMapping("{id}")
    public Optional<Product> show(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
    
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Product product, @PathVariable Long id) {
        productService.update(product, id);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
