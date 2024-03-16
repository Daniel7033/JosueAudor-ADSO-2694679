package com.sena.JosueAudor.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.JosueAudor.Entity.Customer;
import com.sena.JosueAudor.IRespository.ICustomerRespository;
import com.sena.JosueAudor.IService.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRespository customerRepository;
    
    @Override
    public List<Customer>all() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer, Long id) {
        //Validar si
        Optional<Customer> op = customerRepository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else{
            //Crear nuevo objeto que va a contener los datos que se van actualizar
            Customer customerUpdate = op.get();
            customerUpdate.setName(customer.getName());
            customerUpdate.setEmail(customer.getEmail());
            customerUpdate.setPhone(customer.getPhone());
            customerUpdate.setAddress(customer.getAddress());
            
            //Actualizar el objeto
            customerRepository.save(customerUpdate);
        }      
    }

    @Override
    public void delete(Long id) {
        //Eliminado lógico de los datos de "customer"
        customerRepository.deleteById(id);
    }

}
