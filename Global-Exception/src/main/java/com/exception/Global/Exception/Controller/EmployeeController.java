package com.exception.Global.Exception.Controller;

import com.exception.Global.Exception.Entity.Employee;
import com.exception.Global.Exception.Service.EmployeeService;
import com.exception.Global.Exception.Service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /* @PostMapping("/create")
     public String create(@RequestBody Employee employee){
         employeeService.create(employee);
         return "Data SuccessFully Created";
     }*/
                  // OR
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        Employee empsave = employeeService.create(employee);
     //   return new ResponseEntity<Employee>(empsave, HttpStatus.CREATED);
                    //OR
         // return ResponseEntity.ok("Data is created Succesfully");
                  //OR
        return ResponseEntity.ok(empsave);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> empList = employeeService.getAll();
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }

    /*  @GetMapping("/getById/{id}")
      public Employee getById(@PathVariable int id) {
          return employeeService.getById(id);
      }*/
    //  OR
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee empId = employeeService.getById(id);
        return new ResponseEntity<Employee>(empId, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        employeeService.delete(id);
       // return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee empUpdate = employeeService.create(employee);
        return new ResponseEntity<Employee>(empUpdate, HttpStatus.CREATED);
    }
}
