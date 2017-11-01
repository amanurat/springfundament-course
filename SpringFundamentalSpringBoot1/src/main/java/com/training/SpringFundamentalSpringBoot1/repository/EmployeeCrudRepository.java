package com.training.SpringFundamentalSpringBoot1.repository;

import com.training.SpringFundamentalSpringBoot1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {

}
