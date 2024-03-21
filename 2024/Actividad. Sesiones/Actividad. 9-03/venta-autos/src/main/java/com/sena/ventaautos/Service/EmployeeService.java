package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Employee;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.IEmployeeRepository;
import com.sena.ventaautos.IService.IEmployeeService;

@Service
public class EmployeeService extends ABaseService<Employee> implements IEmployeeService{

    @Override
    protected IBaseRepository<Employee, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private IEmployeeRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
