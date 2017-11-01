package com.training.SpringFundamentalSpringBoot1.dto;

import javax.persistence.Column;
import javax.persistence.Id;

//@Entity
public class EmployeeDto {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

}
