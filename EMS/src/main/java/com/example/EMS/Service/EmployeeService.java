package com.example.EMS.Service;

import com.example.EMS.Entity.Employee;
import com.example.EMS.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
     private EmployeeRepository repository;
     public EmployeeService(EmployeeRepository repository){
         this.repository=repository;
     }
    public List<Employee > getAllEmployees(){
             return  repository.findAll();
    }
    public Employee getById(Long id){

        return repository.findById(id).orElse(null);

    }
    public Employee SaveEmployee(Employee employee){
         return repository.save(employee);
    }
    public void deleteEmployee(long id){
        repository.deleteById(id);

    }
}
