package com.atqgh.springboot.controller;

import com.atqgh.springboot.bean.Department;
import com.atqgh.springboot.bean.Employee;
import com.atqgh.springboot.service.DepartmentService;
import com.atqgh.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: qiguohui
 * @Description:
 * @Date: Created in 23:47 2019/4/24
 * @Modified By:
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Department getDepartMent(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
