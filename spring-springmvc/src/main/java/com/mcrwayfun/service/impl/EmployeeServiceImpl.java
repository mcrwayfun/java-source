package com.mcrwayfun.service.impl;

import com.mcrwayfun.entity.Employee;
import com.mcrwayfun.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
