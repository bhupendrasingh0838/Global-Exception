package com.exception.Global.Exception.Service;

import com.exception.Global.Exception.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee create(Employee employee);

    public List<Employee> getAll();

    public Employee getById(int id);

    public void delete(int id);


}
