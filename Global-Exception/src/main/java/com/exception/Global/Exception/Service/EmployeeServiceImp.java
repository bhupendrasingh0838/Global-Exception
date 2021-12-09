package com.exception.Global.Exception.Service;

import com.exception.Global.Exception.Entity.Employee;
import com.exception.Global.Exception.GlobalException.EmptyInputException;
import com.exception.Global.Exception.GlobalException.ListNotPresentException;
import com.exception.Global.Exception.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        // if(employee.getName().isEmpty() || employee.getName().length() == 0)
        if ((employee.getName().isEmpty() || employee.getAddress().isEmpty() || employee.getMobNumber().isEmpty() || employee.getCity().isEmpty())) {
            // throw new EmptyInputException("601","Input Fields are empty");
            //OR
            throw new EmptyInputException();
        }
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> empList = employeeRepository.findAll();
        if (empList.isEmpty())
            throw new ListNotPresentException("601", "List is completely empty, we have nothing to return");
        return empList;
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee.getId() == id)
            employeeRepository.deleteById(id);

    }
}
