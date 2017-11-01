package com.training.SpringFundamentalSpringBoot1.repository;


import com.training.SpringFundamentalSpringBoot1.domain.Employee;
import com.training.SpringFundamentalSpringBoot1.dto.EmployeeDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public Employee findByLastName(String  lastName) {
        Query query = entityManager.createQuery("from Employee e where e.lastName = :LAST_NAME");
        query.setParameter("LAST_NAME", lastName);
        List resultList = query.getResultList();

        return resultList.isEmpty()? null : (Employee) resultList.get(0);
    }

    public List<EmployeeDto> findAllByNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("select id, componay_name from employee", EmployeeDto.class);
        return nativeQuery.getResultList();
    }

    public Employee getEmployeeById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }


}
