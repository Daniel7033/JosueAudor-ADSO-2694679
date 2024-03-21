package com.sena.ventaautos.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.ventaautos.Entity.Employee;

@Repository
public interface IEmployeeRepository extends IBaseRepository<Employee, Long>{
    
}
