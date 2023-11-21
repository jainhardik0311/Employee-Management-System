package com.employee.service;

import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.repository.EmpRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;
    public void addEmp(Employee e) {
        repo.save(e);
    }

    public List<Employee> getAllEmp(){
        return repo.findAll();
    }

    public Employee getEmpByID(int id){
        Optional<Employee> e = repo.findById(id);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }

    public void deleteEmp(int id){
        repo.deleteById(id);
    }
}
