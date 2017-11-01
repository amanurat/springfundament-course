package com.training.SpringFundamentalSpringBoot1.controller;

import com.training.SpringFundamentalSpringBoot1.domain.Employee;
import com.training.SpringFundamentalSpringBoot1.repository.EmployeeCrudRepository;
import com.training.SpringFundamentalSpringBoot1.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {


    List<Employee> employeeList = new ArrayList<>();


    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;


    {
        Employee assanai = new Employee();
        assanai.setId(1);
        assanai.setFirstName("Assanai");
        assanai.setLastName("Manurat");

        Employee john = new Employee();
        john.setId(2);
        john.setFirstName("John");
        john.setLastName("Deo");
        employeeList.add(assanai);
        employeeList.add(john);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
//        employeeList.add(employee);

//        employeeJpaRepository.save(employee);

        employeeCrudRepository.save(employee);

        return employee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> listAllEmployee() {
        return employeeJpaRepository.findAllEmployees();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeJpaRepository.getEmployeeById(id);
    }

    //TODO PUT
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable Integer id , @RequestBody Employee employeeParam) {
        Employee employee = getEmployee(id);
        employee.setFirstName(employeeParam.getFirstName());
        employee.setLastName(employeeParam.getLastName());

        return employeeParam;
    }
    //TODO DELETE

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Integer id) {

        Employee employee = getEmployee(id);
//        employeeList.remove(employee);

        employeeJpaRepository.deleteEmployee(employee);

    }

}
