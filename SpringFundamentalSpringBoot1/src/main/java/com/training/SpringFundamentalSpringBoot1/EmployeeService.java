package com.training.SpringFundamentalSpringBoot1;

import com.training.SpringFundamentalSpringBoot1.domain.Employee;
import com.training.SpringFundamentalSpringBoot1.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true )
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;


    public List<Employee> findAllEmpoloyee() {
        return employeeJpaRepository.findAllEmployees();
    }

    @Transactional
    public void someBussinessForSave() {


    }

}
